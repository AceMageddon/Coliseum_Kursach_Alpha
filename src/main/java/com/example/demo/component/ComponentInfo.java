package com.example.demo.component;

import com.example.demo.data.Data;
import com.example.demo.repo.InfoRepository;
import com.example.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentInfo {

    @Autowired
    InfoService infoService;

    @Autowired
    InfoRepository infoRepository;

    public void getinfo(){
        Data.idata = infoService.getInfoData(Data.iid);
    }
}
