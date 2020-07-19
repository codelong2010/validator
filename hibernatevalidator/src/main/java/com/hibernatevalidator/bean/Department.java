package com.hibernatevalidator.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

/**
 * @author xiaolong
 * @create 2020-07-19 19:24
 * @description 部门类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Positive(message = "department.id必须为正数")
    private int id;

    @NotBlank(message = "department.name不能为空")
    private String name;

}
