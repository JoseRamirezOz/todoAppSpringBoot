package com.resolverti.todo.services.impl;

import com.resolverti.todo.enitities.Tarea;
import com.resolverti.todo.repositories.TareaRepository;
import com.resolverti.todo.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository repositoryTarea;

    @Override
    public List<Tarea> getAllTareas() {
        return repositoryTarea.findAll();
    }

    @Override
    public Optional<Tarea> getTareaById(Long id) {
        return repositoryTarea.findById(id);
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        return repositoryTarea.save(tarea);
    }

    @Override
    public Tarea updateTarea(Long id, Tarea tarea) {
        if(repositoryTarea.existsById(id)){
            repositoryTarea.save(tarea);
        }

        return null;
    }

    @Override
    public void deleteTarea(Long id) {
        repositoryTarea.deleteById(id);
    }
}
