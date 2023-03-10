package com.ada.projetowebi.controller;

import com.ada.projetowebi.model.Time;
import com.ada.projetowebi.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/times")
public class TimeRestController {

    @Autowired
    private TimeService timeService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Time time){
        try{
            timeService.save(time);
            return ResponseEntity.ok(time);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        try{
            List<Time> times = timeService.findAll();
            return ResponseEntity.ok(times);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            Time time = timeService.findById(id);
            return ResponseEntity.ok(time);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> findByNomeContains(@PathVariable String nome){
        try{
            List<Time> times = timeService.findByNomeContains(nome);
            return ResponseEntity.ok(times);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/orderByFundacao")
    public ResponseEntity<?> findAllSortByOrderByFundacao(){
        try{
            List<Time> times = timeService.findAllSortByOrderByFundacao();
            return ResponseEntity.ok(times);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/orderByNome")
    public ResponseEntity<?> findAllSortByOrderByNome(){
        try{
            List<Time> times = timeService.findAllSortByOrderByNome();
            return ResponseEntity.ok(times);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/orderByTitulos")
    public ResponseEntity<?> findAllSortByOrderByTitulos(){
        try{
            List<Time> times = timeService.findAllSortByOrderByTitulos();
            return ResponseEntity.ok(times);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try{
            Time time = timeService.findById(id);
            timeService.deleteById(id);
            return ResponseEntity.ok("Time com o Id " + id + " excluído com sucesso");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestParam Long id, @RequestBody Time time){
        try{
            return ResponseEntity.ok(timeService.edit(id, time));
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
