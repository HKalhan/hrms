package com.example.hrms.core.utilities.imageUpload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;

@Service
public class ImageHelper implements ImageUploadService{

    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {

        Cloudinary cloudinary=new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dm9pafbdd",
                "api_key", "276234516643716",
                "api_secret", "rbr7WJqoIiKZmlS_Mk3RjdvcjWE"));

        try {
            Map uploadResult= cloudinary.uploader().upload(imageFile.getBytes(),ObjectUtils.emptyMap());

            return new SuccessDataResult<Map>(uploadResult);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();

    }
}