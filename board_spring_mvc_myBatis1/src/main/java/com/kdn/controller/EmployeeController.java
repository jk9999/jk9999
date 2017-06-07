package com.kdn.controller;


import java.awt.print.Pageable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kdn.model.biz.EmployeeService;
import com.kdn.model.domain.Board;
import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@ExceptionHandler
	public ModelAndView handler(Exception e){
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", e.getMessage());
		model.addObject("content", "ErrorHandler.jsp");
		return model;
	}
	
	
	@RequestMapping(value="insertEmployeeForm.do",method=RequestMethod.GET)
	public String insertEmployeForm(Model model){
		model.addAttribute("content", "employee/insertEmployee.jsp");
		return "index";
	}
	@RequestMapping(value="insertEmployee.do",method=RequestMethod.POST)
	public String insertEmploye(Employee employee, Model model){
		employeeService.add(employee);
		model.addAttribute("content", "employee/login.jsp");
		//회원 가입 후에 로그인으로 이동
		return "index";
	}
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(Model model,HttpSession session, String empno){
		employeeService.login(empno);
		session.setAttribute("id", empno);
		return "index";
	}
	@RequestMapping(value="loginform.do",method=RequestMethod.GET)
	public String loginform(Model model){
		model.addAttribute("content", "employee/login.jsp");
		return "index";
	}
	@RequestMapping(value="logout.do",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("id");
		
		return "index";
	}
	@RequestMapping(value="employeeUpdateForm.do",method=RequestMethod.GET)
	public String employeeUpdateForm(Model model, Employee employee, HttpSession session){
		String empno = (String) session.getAttribute("id");
		employee = employeeService.search(empno);
		if(empno == null)
            return "redirect:loginForm.do";
        model.addAttribute(employee);
		model.addAttribute("content", "employee/employeeUpdate.jsp");
		return "index";
	}
	@RequestMapping(value="employeeUpdate.do",method=RequestMethod.POST)
	public String employeeUpdate(Model model, Employee employee, HttpSession session){
		String empno = (String) session.getAttribute("id");
		employee.setEmpno(empno);
		employeeService.update(employee);
		return "index";
	}
	@RequestMapping(value="myPage.do",method=RequestMethod.GET)
	public String myPage(Model model, HttpSession session, Employee employee){
		String empno = (String) session.getAttribute("id");
		employee = employeeService.search(empno);
		model.addAttribute(employee);
		model.addAttribute("content", "employee/myPage.jsp");
		return "index";
	}
	@RequestMapping(value="listEmployee.do", method=RequestMethod.GET)
	public String listEmploye(PageBean bean, Model model ){
		List<Employee> list = employeeService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("content", "employee/listEmployee.jsp");
		return "index";
	}
	@RequestMapping(value="searchEmploye.do",method=RequestMethod.GET)
	public String searchEmploye(Model model, Employee employee, String empno){
		System.out.println(empno);
		employee.setEmpno(empno);
		employee = employeeService.search(empno);
		model.addAttribute(employee);
		model.addAttribute("content", "employee/employeeUpdate.jsp");
		return "index";
	}
	@RequestMapping(value="deleteEmployee.do",method=RequestMethod.POST)
	public String deleteEmploye(Model model, Employee employee, HttpSession session){
		String empno = (String) session.getAttribute("id");
		employee.setEmpno(empno);
		employeeService.remove(empno);
		session.removeAttribute("id");
		return "index";
	}
}
