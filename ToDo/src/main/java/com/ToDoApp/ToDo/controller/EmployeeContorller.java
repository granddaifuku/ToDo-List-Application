package com.ToDoApp.ToDo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ToDoApp.ToDo.model.Employee;
import com.ToDoApp.ToDo.service.EmployeeService;

@Controller
public class EmployeeContorller {
	
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("/")
	public String employees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("title", "Employees");
		model.addAttribute("isAdd", true);
		return "view/employees";
	}
	@PostMapping(value="/save")
	public String save(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes, Model model) {
		Employee dbEmployee = employeeService.save(employee);
		if (dbEmployee!=null) {
			redirectAttributes.addFlashAttribute("successmessage", "Employee is saved succesfully");
			return "redirect:/";
		} else {
			model.addAttribute("errormessage", "Employee is not save, Please try again");
			model.addAttribute("employee", employee);
			return "view/employees";
		}
	}
	
	@GetMapping(value="/getEmployee/{id}")
	public String getEmpoyee(@PathVariable Long id, Model model) {
		Employee employee = employeeService,findById(id);
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employeee", employee);
		model.addAttribute("title", "Edit Employees");
		model.addAttribute("isAdd", false);
		return "view/employees";
	}
	
	@PostMapping(value="/update")
	public String update(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes, Model model) {
		Employee dbEmployee = employeeService.update(employee);
		if (dbEmployee!=null) {
			redirectAttributes.addFlashAttribute("successmessage", "Employee is updated succesfully");
			return "redirect:/";
		} else {
			model.addAttribute("errormessage", "Employee is not updated, Please try again");
			model.addAttribute("employee", employee);
			return "view/employees";
		}
	}
	
	@GetMapping(values="/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		employeeService.delete(id);
		redirectAttributes.addFlashAttribute("successmessage", "Employee is deleted succesfully");
		return "redirect:/";
	}

}
