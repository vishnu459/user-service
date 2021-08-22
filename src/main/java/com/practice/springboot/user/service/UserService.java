package com.practice.springboot.user.service;

import com.practice.springboot.user.entity.User;
import com.practice.springboot.user.repository.UserRepository;
import com.practice.springboot.user.vo.Department;
import com.practice.springboot.user.vo.UserDepartmentData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method UserService...! ");
        return userRepository.save(user);
    }

    public UserDepartmentData findUserWithDepartment(final Long userId) {
        log.info("Inside findUserWithDepartment method UserService...! ");
        UserDepartmentData userDepartmentData = new UserDepartmentData();
        User user = userRepository.findByUserId(userId);
        log.info("Inside findUserWithDepartment method user details...! " + user);
/*        Map<String, Long> params = new HashMap<>();
        params.put("departmentId", user.getDepartmentId());
        Department responseEntity = restTemplate.exchange("http://localhost:9001/departments/find-department-by-id-param?",
                HttpMethod.GET, null, Department.class, params).getBody();
        log.info("RequestParam response ...!" + responseEntity);*/

        Department department = restTemplate
                .getForEntity("http://DEPARTMENT-SERVICE/departments/find-department-by-id/" + user.getDepartmentId(), Department.class).getBody();
        userDepartmentData.setUser(user);
        userDepartmentData.setDepartment(department);
        return userDepartmentData;
    }
}
