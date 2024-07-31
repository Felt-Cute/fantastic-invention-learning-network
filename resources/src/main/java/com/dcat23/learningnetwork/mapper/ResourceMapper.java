package com.dcat23.learningnetwork.mapper;

import com.dcat23.learningnetwork.dto.ResourceResponse;
import com.dcat23.learningnetwork.dto.ResourceUpdateDTO;
import com.dcat23.learningnetwork.dto.ResourceUploadDTO;
import com.dcat23.learningnetwork.model.Resource;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    @Mapping(target = "fileUrl", ignore = true)
    @Mapping(target = "uploadedByUserId", source = "userId")
    Resource toEntity(ResourceUploadDTO resourceUploadDTO);

    @Mapping(target = "userId", source = "uploadedByUserId")
    ResourceResponse toResponse(Resource resource);

    @Mapping(target = "userId", source = "uploadedByUserId")
    List<ResourceResponse> toResponse(List<Resource> resources);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(ResourceUpdateDTO resourceUpdateDTO, @MappingTarget Resource resource);
}
