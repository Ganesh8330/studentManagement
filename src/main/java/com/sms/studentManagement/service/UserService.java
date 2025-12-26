package com.sms.studentManagement.service;

import com.sms.studentManagement.dto.LoginRequest;
import com.sms.studentManagement.models.Users;

public interface UserService {

    Users createUsers(Users user);

    String verify(LoginRequest request);
}
