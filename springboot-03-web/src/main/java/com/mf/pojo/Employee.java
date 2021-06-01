package com.mf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer eId;
    private String eName;
    private String email;
    private Integer gender;

    private Department department;
    private Date birth;
}
