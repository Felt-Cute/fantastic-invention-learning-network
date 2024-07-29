package com.dcat23.learningnetwork.mapper;

import com.dcat23.learningnetwork.dto.ResourceDTO;
import com.dcat23.learningnetwork.dto.ResourceResponse;
import com.dcat23.learningnetwork.dto.ResourceUpdateDTO;
import com.dcat23.learningnetwork.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    Resource map(ResourceUpdateDTO resourceDTO);

    ResourceResponse map(Resource resource);

    List<ResourceResponse> map(List<Resource> resources);

    void update(ResourceDTO resourceDTO, @MappingTarget Resource resource);
}
