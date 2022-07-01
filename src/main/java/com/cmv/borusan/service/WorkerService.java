package com.cmv.borusan.service;

import com.cmv.borusan.exception.EntityNotFoundException;
import com.cmv.borusan.model.dto.WorkerDto;
import com.cmv.borusan.model.dto.WorkerSearch;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.entity.Worker;
import com.cmv.borusan.model.mapper.WorkerMapper;
import com.cmv.borusan.repository.ProductRepository;
import com.cmv.borusan.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;

    private final ProductRepository productRepository;

    public List<WorkerDto> getAll() {
        return WorkerMapper.mapToList(workerRepository.findAll());
    }

    public WorkerDto saveWorker(WorkerDto workerDto) {
        Worker worker = WorkerMapper.mapTo(workerDto);
        workerRepository.save(worker);
        return workerDto;
    }

    public Boolean delete(Long id) {
        List<Product> product = productRepository.findByWorkerId(id);
        for (Product product1:product){
            product1.setWorker(null);
        }
        productRepository.saveAll(product);
        workerRepository.deleteById(id);
        return true;
    }

    public WorkerDto update(WorkerDto workerDto) {
       Worker worker= workerRepository.findById(workerDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(workerDto.getId().toString(), Worker.class));
        WorkerMapper.updateWorker(worker, workerDto);
        workerRepository.save(worker);
        return workerDto;
    }

    public Page<Worker> findWorkerWithPagination(Pageable pageable, WorkerSearch workerSearch){
        if (workerSearch.getName() == null){
            workerSearch.setName("");
        }
        if (workerSearch.getSurname() == null){
            workerSearch.setSurname("");
        }
        Page<Worker> workers = workerRepository.findAll(workerSearch.getName(),workerSearch.getSurname(),pageable);
        return  workers;
    }

}
