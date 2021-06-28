package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image,Integer> {
    Image getById(int id);
    Image getByUser_id(int id);
}
