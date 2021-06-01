package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.User;

public interface UserService {
    DataResult<User> checkEmail(String email);
}
