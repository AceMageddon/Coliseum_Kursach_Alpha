package com.example.demo.service;

import com.example.demo.model.InfoEntity;
import com.example.demo.repo.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    @Autowired
    private InfoRepository infoRepository;

    public InfoEntity findInfoById(long id){return infoRepository.findById(id).get();}

    public void safeInfo(InfoEntity infoEntity){
        infoRepository.save(infoEntity);
    }

    public String getInfoData(long id){return infoRepository.findById(id).get().getData();}
}
