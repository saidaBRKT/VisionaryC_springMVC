package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.AppelOffre;

import java.util.List;

public interface AppelOffreService {

    int deleteByRef(String ref);
    AppelOffre findByRef(String ref);

    List<AppelOffre> findAll();


    AppelOffre getOne(Long aLong);

    AppelOffre save(AppelOffre appelOffre);

    AppelOffre update(AppelOffre appelOffre);

    List<AppelOffre> getAll();
}
