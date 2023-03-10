package com.ada.projetowebi.repository;

import com.ada.projetowebi.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

    List<Time> findByNomeContainsIgnoreCase(String nome);
}
