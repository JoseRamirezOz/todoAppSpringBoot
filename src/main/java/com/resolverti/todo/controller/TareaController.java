package com.resolverti.todo.controller;

import com.resolverti.todo.enitities.Tarea;
import com.resolverti.todo.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin("*")
public class TareaController {
    @Autowired
    TareaService tareasService;


    @GetMapping
    public List<Tarea> listarTareas(){
        return tareasService.getAllTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTarea(@PathVariable  Long id){
        Optional<Tarea> tarea = tareasService.getTareaById(id);
        return tarea.map(value -> ResponseEntity.ok().body(value)).orElse(
                 null);
    }


    @PostMapping
    public ResponseEntity<Tarea> guardarTarea(@RequestBody Tarea tarea){
        Tarea tareaGuardada = tareasService.createTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaGuardada);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Long id, @RequestBody Tarea tarea){
        Tarea tareaUpdate = tareasService.updateTarea(id,tarea);
        if(tareaUpdate != null){
            return ResponseEntity.ok().body(tareaUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id){
        tareasService.deleteTarea(id);
        return ResponseEntity.noContent().build();
    }
}
