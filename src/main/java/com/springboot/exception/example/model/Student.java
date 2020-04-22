package com.springboot.exception.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.exception.example.constant.CommonConstant;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Student {
    @NotNull(message = "Please provide a student Id")
    Long Id;
    @NotEmpty(message = "Please provide Student First Name")
    String FirstName;
    @NotEmpty(message = "Please provide Student Last Name")
    String LastName;
    @NotNull(message = "Please provide Student Height")
    Double height;
    @NotNull(message = "Please provide Student Weight")
    Double weight;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CommonConstant.DATE_FORMAT, timezone = CommonConstant.TIME_ZONE)
    @NotNull(message = "Please provide Student date of birth ")
    Date dateOfBirth;
    @NotEmpty(message = "Please provide a student department")
    String department;

}
