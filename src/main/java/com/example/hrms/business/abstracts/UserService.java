package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.entities.User;
import com.example.hrms.core.utilities.results.Result;

public interface UserService {
    DataResult<User> checkEmail(String email);
    Result add(User user);
    DataResult<User> getById(int userId);
}
