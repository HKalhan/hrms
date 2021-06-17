package com.example.hrms.core.utilities.verifications;

import java.util.UUID;

public class CodeGenerator {
    public static String sendVerificationCode() {
        UUID uuid = UUID.randomUUID();
        String code= uuid.toString().split("-")[0];
        return code;
    }
}
