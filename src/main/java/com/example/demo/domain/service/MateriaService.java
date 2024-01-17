package com.example.demo.domain.service;

import com.example.demo.domain.mapper.MateriaMapper;
import com.example.demo.domain.model.Materia;
import com.example.demo.domain.repository.MateriaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class MateriaService {
    private final MateriaRepository repository;
    private final MateriaMapper mapper;

    @Transactional
    public Materia saveMateria(Materia model){
        Materia materia = null;
        if(Objects.nonNull(model)){
            materia =   mapper.entityToModel(repository.save(mapper.modelToEntity(model)));
        }
        return materia;
    }

    public List<Materia> getAll(){
        return repository.findAll()
                .stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());
    }

    public Materia findById(final Integer id){
        return mapper.entityToModel(repository.findById(id).orElse(null));
    }

    public void deleteMateria(final Integer id){
        //TODO: validar si existe
      Materia materia =  findById(id);
      if(Objects.nonNull(materia)){
          repository.delete(mapper.modelToEntity(materia));
      }
    }


}
