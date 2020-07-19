package com.hibernatevalidator.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xiaolong
 * @create 2020-07-19 19:21
 * @description 员工类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Positive(message = "id必须为正数",groups = {Employee.add.class})
    private int id;

    @Positive(message = "parent_id必须为正数",groups = {Employee.add.class})
    private int parent_id;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotNull(message = "createtime不能为空")
    @PastOrPresent
    private LocalDateTime createtime;

    @Valid
    private List<Department> departments;

    public interface add{};

    public interface update{};

}
