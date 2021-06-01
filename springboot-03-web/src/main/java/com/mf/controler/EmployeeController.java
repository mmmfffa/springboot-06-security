package com.mf.controler;

import com.mf.dao.DepartmentDao;
import com.mf.dao.EmployeeDao;
import com.mf.pojo.Department;
import com.mf.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    //controller层调service层

    //查询所有员工
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/employee")
    public String list(Model model){
        Collection<Employee> allEmployee = employeeDao.getAllEmployee();
        model.addAttribute("allEmployee",allEmployee);
        return "employee/list";
    }

    //restful风格
    @GetMapping("/add")
    public String toAddPage(Model model){
        //查出所有部门信息
        Collection<Department> allDepartment = departmentDao.getAllDepartment();
        model.addAttribute("allDepartment",allDepartment);
        return "employee/add";
    }
    @PostMapping ("/add")
    public String addEmployee(Employee employee){
        System.out.println("添加=》"+employee);
        //添加操作
        employeeDao.add(employee);
        return "redirect:/employee";
    }

    @GetMapping("/update/{eid}")
    public String toUpdatePage(@PathVariable("eid")Integer eid,Model model){
        //查出原来的数据
        Employee employee = employeeDao.getEmployeeById(eid);
        model.addAttribute("employee",employee);
        Collection<Department> allDepartment = departmentDao.getAllDepartment();
        model.addAttribute("allDepartment",allDepartment);
        return "employee/update";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee){
        System.out.println("修改=》"+employee);
        employeeDao.add(employee);//存储员工的是哈希表，id不重复，添加即修改
        return "redirect:/employee";
    }

    @GetMapping("/delete/{eid}")
    public String deleteEmployee(@PathVariable("eid")Integer eid){
        employeeDao.deleteEmployeeById(eid);
        return "redirect:/employee";
    }
}
