package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.VersionDto;
import com.cmv.borusan.service.VersionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VersionController extends BaseController{

    private final VersionService versionService;

    public VersionController(VersionService versionService){
        this.versionService = versionService;
    }

    @GetMapping(VERSION)
    public List<VersionDto> getAll(){
        return versionService.getAll();
    }
}
