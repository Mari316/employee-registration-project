package com.cydeo.employeeregistrationproject.controller;

import com.cydeo.employeeregistrationproject.bootstrap.DaraGenerator;
import com.cydeo.employeeregistrationproject.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

@GetMapping("/register")
    public String createEmployee(Model model){
    model.addAttribute("employee", new Employee());
    model.addAttribute("states", DaraGenerator.getAllStates());

        return "employee/employee-create";
    }

    //!!! BindingResult have to be after object only this order!!!! we use to check validation and pass data or not
    @PostMapping("/list")  //@Valid will check if @NotNull etc conditions are fulfilled
    public String employeeList(@Valid @ModelAttribute("employee")Employee employee, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){                                              // we didnt add "employee" its already inside
            model.addAttribute("states", DaraGenerator.getAllStates()); //added this here because we dont want to lose selected state?
            return "employee/employee-create";// in case of error user will not go to next page
        }
        DaraGenerator.saveEmployee(employee);// we saved employee
        model.addAttribute("employees", DaraGenerator.readAllEmployees());// we use "Model" when we want to bring smt to View




    return "employee/employee-list";
    }

}
