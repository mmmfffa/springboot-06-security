package com.mf.dao;


import com.mf.pojo.Department;
import com.mf.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer,Employee> employees=null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees=new HashMap<>();//创建一个部门表
        employees.put(1001,new Employee(1001,"蒙恬","111.qqCom",0,new Department(101,"工部"),new Date()));
        employees.put(1002,new Employee(1002,"易小川","112.qqCom",1,new Department(101,"工部"),new Date()));
        employees.put(1003,new Employee(1003,"千禧","113.qqCom",1,new Department(103,"吏部"),new Date()));
        employees.put(1004,new Employee(1004,"小凯","114.qqCom",0,new Department(104,"户部"),new Date()));

    }

    //增加一个员工，主键自增
    public static Integer initId=1005;
    public void add(Employee employee){
        if (employee.getEId()==null) employee.setEId(initId++);
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getDId()));
        employees.put(employee.getEId(),employee);
    }
    //获取全部员工
    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }

}
