package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.FavJobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavJobAdvertDao extends JpaRepository< FavJobAdvert , Integer> {

    FavJobAdvert getByJobAdvert_Id(int id);
    void deleteByJobAdvert_Id(int id);
    FavJobAdvert getByCandidate_userIdAndJobAdvert_id(int userId,int id);

}
