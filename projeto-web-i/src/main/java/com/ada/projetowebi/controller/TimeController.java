package com.ada.projetowebi.controller;

import com.ada.projetowebi.model.Time;
import com.ada.projetowebi.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping({"","/","/home"})
    public String home(){
        return "home";
    }

    @PostMapping("/save")
    public String save(Time time, Model model){
        try{
            timeService.save(time);
        } catch (RuntimeException e){
            model.addAttribute("time", time);
            model.addAttribute("campoVazio", true);
            model.addAttribute("cadastrar", true);
            model.addAttribute("mensagem", e.getMessage());
            return "criar_time";
        }
        return "redirect:all";
    }

    @GetMapping("/all")
    public String findAll(Model model){
        try{
            List<Time> times = timeService.findAll();
            model.addAttribute("times", times);
            model.addAttribute("isEmpty", false);
        }catch (RuntimeException e){
            model.addAttribute("mensagem", e.getMessage());
            model.addAttribute("isEmpty", true);
        }
        return "listar_times";
    }

    @GetMapping("/{id}")
    public Time findById(@PathVariable Long id){
        return timeService.findById(id);
    }

    @GetMapping("/nome")
    public String findByNomeContains(@RequestParam String nome, Model model){
        try{
            List<Time> times = timeService.findByNomeContains(nome);
            model.addAttribute("times", times);
            model.addAttribute("isEmpty", false);
        }catch (RuntimeException e){
            model.addAttribute("mensagem", e.getMessage());
            model.addAttribute("isEmpty", true);
        }
        return "listar_times";
    }

    @GetMapping("/orderByFundacao")
    public String findAllSortByOrderByFundacao(Model model){
        try{
            List<Time> times = timeService.findAllSortByOrderByFundacao();
            model.addAttribute("times", times);
            model.addAttribute("isEmpty", false);
        }catch (RuntimeException e){
            model.addAttribute("mensagem", e.getMessage());
            model.addAttribute("isEmpty", true);
        }
        return "listar_times";
    }

    @GetMapping("/orderByNome")
    public String findAllSortByOrderByNome(Model model){
        try{
            List<Time> times = timeService.findAllSortByOrderByNome();
            model.addAttribute("times", times);
            model.addAttribute("isEmpty", false);
        }catch (RuntimeException e){
            model.addAttribute("mensagem", e.getMessage());
            model.addAttribute("isEmpty", true);
        }
        return "listar_times";
    }

    @GetMapping("/orderByTitulos")
    public String findAllSortByOrderByTitulos(Model model){
        try{
            List<Time> times = timeService.findAllSortByOrderByTitulos();
            model.addAttribute("times", times);
            model.addAttribute("isEmpty", false);
        }catch (RuntimeException e){
            model.addAttribute("mensagem", e.getMessage());
            model.addAttribute("isEmpty", true);
        }
        return "listar_times";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model){
        timeService.deleteById(id);
        return "redirect:/times/all";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam Long id, Time time, Model model){
        try{
            timeService.edit(id,time);
        }catch (RuntimeException e){
        model.addAttribute("time", time);
        model.addAttribute("campoVazio", true);
        model.addAttribute("cadastrar", false);
            model.addAttribute("mensagem", e.getMessage());
        return "criar_time";
    }
        return "redirect:all";
    }

    @GetMapping("/cadastrar-editar/{id}")
    public String controlar(@PathVariable Long id, Model model){
        if(id == 0){
            model.addAttribute("time", new Time());
            model.addAttribute("cadastrar", true);
            return "criar_time";
        }
        model.addAttribute("time", timeService.findById(id));
        model.addAttribute("cadastrar", false);
        return "criar_time";
    }

}
