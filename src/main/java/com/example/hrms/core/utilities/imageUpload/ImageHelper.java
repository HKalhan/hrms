package com.example.hrms.core.utilities.imageUpload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.core.utilities.results.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.Map;

@Service
public class ImageHelper implements ImageUploadService{

    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        return null;
    }
}
