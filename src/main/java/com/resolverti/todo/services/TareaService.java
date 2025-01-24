package com.resolverti.todo.services;

import com.resolverti.todo.enitities.Tarea;
import org.springframework.stereotype.Service;

import java.util.*;

public interface TareaService {
    List<Tarea> getAllTareas();
    Optional<Tarea> getTareaById(Long id);
    Tarea createTarea(Tarea tarea);
    Tarea updateTarea(Long id, Tarea tarea);
    void deleteTarea(Long id);
}
