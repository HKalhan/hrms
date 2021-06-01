package com.example.hrms.core.utilities.results;

import com.example.hrms.core.utilities.results.Result;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
