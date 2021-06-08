package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LinkService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LinkDao;
import com.example.hrms.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkManager implements LinkService {

    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        super();
        this.linkDao = linkDao;
    }

    @Override
    public Result add(Link link) {
        this.linkDao.save(link);
        return new SuccessResult("link eklendi");
    }

    @Override
    public Result update(Link link) {
        this.linkDao.save(link);
        return new SuccessResult("link güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.linkDao.deleteById(id);
        return new SuccessResult("link kaldırıldı");
    }

    @Override
    public DataResult<Link> getById(int id) {
        return new SuccessDataResult<Link>(this.linkDao.getById(id));
    }

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
    }

    @Override
    public DataResult<List<Link>> getAllByCandidateId(int id) {
        return new SuccessDataResult<List<Link>>(this.linkDao.getAllByCandidate_id(id));
    }
}
