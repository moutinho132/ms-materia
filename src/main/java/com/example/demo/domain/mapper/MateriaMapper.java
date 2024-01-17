package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.MateriaEntity;
import com.example.demo.domain.model.Materia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MateriaMapper {

    Materia entityToModel(MateriaEntity entity);

    MateriaEntity modelToEntity(Materia model);
}
