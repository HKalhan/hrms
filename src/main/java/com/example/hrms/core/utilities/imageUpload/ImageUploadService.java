package com.example.hrms.core.utilities.imageUpload;

import com.example.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUploadService {
    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
