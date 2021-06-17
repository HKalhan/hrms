package com.example.hrms.core.business;

import com.example.hrms.core.utilities.results.Result;

public class BusinessRules {
    public static Result run(Result... results) {
        for (Result result: results ) {
            if (!result.isSuccess()) {
                return result;
            }
        }
        return null;
    }
}
