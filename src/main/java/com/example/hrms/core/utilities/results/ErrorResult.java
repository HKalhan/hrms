package com.example.hrms.core.utilities.results;

import com.example.hrms.core.utilities.results.Result;

public class ErrorResult extends Result {
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }


}
