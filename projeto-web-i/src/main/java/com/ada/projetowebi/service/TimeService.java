package com.ada.projetowebi.service;

import com.ada.projetowebi.model.Time;
import com.ada.projetowebi.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time save(Time time) throws RuntimeException{
        String campoVazio = fieldEmpty(time);
        if(campoVazio != null)
            throw new RuntimeException("Não deixe o campo " + campoVazio + " em branco");
        return timeRepository.save(time);
    }

    private String fieldEmpty(Time time){
        if(time.getNome() == null || time.getNome().equals(""))
            return "Nome";
        if(time.getPais() == null || time.getPais().equals(""))
            return "País";
        if(time.getFundacao() == null)
            return "Fundação";
        if(time.getQuantidadeTitulos() == null)
            return "Quantidade de Títulos";
        return null;
    }

    public List<Time> findAll() throws RuntimeException{
        List<Time> times = timeRepository.findAll();
        if(times.size() == 0)
            throw new RuntimeException("Não há times cadastrados.");
        return times;
    }

    public Time findById(Long id) throws RuntimeException{
        Optional<Time> time = timeRepository.findById(id);
        if(time.isPresent())
            return time.get();
        else
            throw new RuntimeException("Id não existe");
    }

    public List<Time> findByNomeContains(String nome) throws RuntimeException{
        List<Time> times = timeRepository.findByNomeContainsIgnoreCase(nome);
        if(times.size() == 0)
            throw new RuntimeException("Não há times cadastrados com esse nome.");
        return times;
    }

    public List<Time> findAllSortByOrderByFundacao() throws RuntimeException{
        List<Time> times = timeRepository.findAll(Sort.by(Sort.Order.by("fundacao")));
        if(times.size() == 0)
            throw new RuntimeException("Não há times cadastrados.");
        return times;
    }

    public List<Time> findAllSortByOrderByNome() throws RuntimeException{
        List<Time> times = timeRepository.findAll(Sort.by(Sort.Order.by("nome")));
        if(times.size() == 0)
            throw new RuntimeException("Não há times cadastrados.");
        return times;
    }

    public List<Time> findAllSortByOrderByTitulos() throws RuntimeException{
        List<Time> times = timeRepository.findAll(Sort.by(Sort.Order.by("quantidadeTitulos")));
        if(times.size() == 0)
            throw new RuntimeException("Não há times cadastrados.");
        return times;
    }

    public void deleteById(Long id) {
        timeRepository.deleteById(id);
    }

    public Time edit(Long id, Time time) throws RuntimeException{
        Time timeASerEditado = findById(id);
        if (timeASerEditado == null)
            throw new RuntimeException("Id não existe");
        time.setId(id);
        return save(time);
    }


}
