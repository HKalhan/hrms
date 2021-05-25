package com.example.hrms.business.abstracts;
import com.example.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    List<JobTitle> getAll();
}
