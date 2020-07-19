package com.hibernatevalidator.controller;

import com.hibernatevalidator.bean.Department;
import com.hibernatevalidator.bean.Employee;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.groups.Default;

/**
 * @author xiaolong
 * @create 2020-07-19 19:31
 * @description 测试controller
 */
@RestController
@Validated
public class Testcontroller {

    @PostMapping("/add")
    public Object add(@RequestBody /*@Valid*/ @Validated({Employee.add.class}) Employee employee){
        return "add ok";
    }

    @PostMapping("/update")
    public Object update(@RequestBody /*@Valid*/ @Validated({Default.class}) Employee employee){
        return "update ok";
    }

}
