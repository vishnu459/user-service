package com.practice.springboot.user.vo;

import com.practice.springboot.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartmentData {

    private User user;
    private Department department;
}
