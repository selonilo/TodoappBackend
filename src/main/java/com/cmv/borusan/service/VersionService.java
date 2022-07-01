package com.cmv.borusan.service;

import com.cmv.borusan.model.dto.VersionDto;
import com.cmv.borusan.model.mapper.VersionMapper;
import com.cmv.borusan.repository.VersionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class VersionService {
    private final VersionRepository versionRepository;

    public List<VersionDto> getAll(){
        return VersionMapper.mapToList(versionRepository.findAll());
    }


}
