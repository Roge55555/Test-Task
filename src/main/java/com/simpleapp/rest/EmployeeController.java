package com.simpleapp.rest;

import com.simpleapp.dto.Employee;
import com.simpleapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("employees", employeeService.findAll());
        return "employeesList";
    }

    @GetMapping("/employee/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getById(id) );
        return "showEmployee";
    }

    @GetMapping("/addEmployee")
    public String createEmployee(){
        return "createEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee")Employee employee){
        employeeService.add(employee);
        return "redirect:/employees";
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", employeeService.getById(id));
        return "updateEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee")Employee employee){
        employeeService.update(employee);
        return "redirect:/employee/" + employee.getEmployeeId();
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
}