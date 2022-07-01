package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.WorkerDto;
import com.cmv.borusan.model.dto.WorkerSearch;
import com.cmv.borusan.service.WorkerService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerController extends BaseController{

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService){
        this.workerService = workerService;
    }

    @GetMapping(PUBLIC_FIND_ALL_WORKER)
    public List<WorkerDto> getAll(){
        return workerService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_WORKER)
    public ResponseEntity<WorkerDto> saveWorker(@RequestBody WorkerDto worker){
        return ResponseEntity.ok(workerService.saveWorker(worker));
    }

    @DeleteMapping(PUBLIC_DELETE_WORKER+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(workerService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_WORKER)
    public ResponseEntity<WorkerDto> update(@RequestBody WorkerDto worker){
        return ResponseEntity.ok(workerService.update(worker));
    }

    @PostMapping(PUBLIC_WORKER_PAGEABLE)
    public ResponseEntity getWorkersWithSort(Pageable pageable,@RequestBody WorkerSearch workerSearch){
        return ResponseEntity.ok(workerService.findWorkerWithPagination(pageable,workerSearch));
    }
}
