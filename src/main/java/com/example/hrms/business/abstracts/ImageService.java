package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Result upload (int id, MultipartFile imageFile);
    Result delete(int id);
    DataResult<Image>getByCandidate(int id);
    DataResult<List<Image>> getAll();
    DataResult<Image> getById(int id);
}
