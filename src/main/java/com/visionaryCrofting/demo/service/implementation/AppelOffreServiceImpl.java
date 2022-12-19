package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.Repositories.AoRepository;
import com.visionaryCrofting.demo.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppelOffreServiceImpl implements AppelOffreService {
    @Override
    public int deleteByRef(String ref) {
        return aoRepository.deleteByRef(ref);
    }

    @Override
    public AppelOffre findByRef(String ref) {
        return aoRepository.findByRef(ref);
    }

    @Override
    public List<AppelOffre> findAll() {
        return aoRepository.findAll();
    }

    @Override
    public AppelOffre getOne(Long aLong) {
        return aoRepository.findById(aLong).orElse(null);
    }

    @Override
    public AppelOffre save(AppelOffre appelOffre){
        if (this.findByRef(appelOffre.getRef()) != null) return null;
        return aoRepository.save(appelOffre);
    }

    @Override
    public AppelOffre update(AppelOffre appelOffre) {
        AppelOffre appelOffre1 = this.findByRef(appelOffre.getRef());
        if (appelOffre1 == null){
            throw new IllegalStateException("appeld'offre Not Found");
        }else {
            appelOffre1 = appelOffre;
            return aoRepository.save(appelOffre1);
        }
    }

    @Override
    public List<AppelOffre> getAll() {
        return aoRepository.findAll();
    }

    @Autowired
    AoRepository aoRepository;
}
