package com.mf.dao;

import com.mf.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> department=null;
    static {
        department=new HashMap<>();//创建一个部门表
        department.put(101,new Department(101,"工部"));
        department.put(102,new Department(102,"礼部"));
        department.put(103,new Department(103,"吏部"));
        department.put(104,new Department(104,"户部"));

    }

    //获取所有部门信息
    public Collection<Department> getAllDepartment(){
        return department.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return department.get(id);
    }

}
