package com.practice.springboot.user.controller;

import com.practice.springboot.user.entity.User;
import com.practice.springboot.user.service.UserService;
import com.practice.springboot.user.vo.UserDepartmentData;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save-user")
    @ApiResponses(@ApiResponse(code = 500, message = "Internal server error"))
    @ResponseBody
    @ResponseStatus
    public User saveUser(@RequestBody final User user){
        log.info("Inside saveUser method of UserController..");
    return userService.saveUser(user);
    }

    @GetMapping("/find-user")
    public UserDepartmentData findUserWithDepartment(@RequestParam(name = "userId") final Long userId){
        log.info("Inside saveUser method of UserController..");
        return userService.findUserWithDepartment(userId);
    }
}
