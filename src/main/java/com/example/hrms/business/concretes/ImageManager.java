package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.utilities.imageUpload.ImageHelper;
import com.example.hrms.core.utilities.imageUpload.ImageUploadService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ImageDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private ImageUploadService helper;

    @Autowired
    public ImageManager(ImageDao imageDao, ImageHelper helper) {
        super();
        this.imageDao = imageDao;
        this.helper=helper;
    }

    @Override
    public Result upload(int id, MultipartFile imageFile) {
        @SuppressWarnings("unchecked")
        Map<String,String> sample=(Map<String, String>) this.helper.uploadImageFile(imageFile).getData();

        Candidate candidate=new Candidate();
        Image image=new Image();
        candidate.setId(id);
        image.setCandidate(candidate);

        image.setUrl(sample.get("url"));
        image.setUpdateDate(LocalDate.now());

        this.imageDao.save(image);
        return new SuccessResult("Resim eklendi.");
    }

    @Override
    public Result delete(int id) {
        this.imageDao.deleteById(id);
        return new SuccessResult("Resim kaldırıldı.");
    }

    @Override
    public DataResult<Image> getByCandidate(int id) {
        return new SuccessDataResult<Image>(this.imageDao.getByCandidate_id(id));
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
    }

    @Override
    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<Image>(this.imageDao.getById(id));
    }
}
