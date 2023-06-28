package org.utarid.funmath.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utarid.funmath.dto.ResultDTO;
import org.utarid.funmath.entity.ResultEntity;

@Mapper
public interface ResultMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resultDate", expression = "java(java.time.LocalDateTime.now())")
    ResultEntity resultDTOToResultEntity(ResultDTO userDTO);

    ResultDTO resultEntityToResultDTO(ResultEntity userEntity);
}