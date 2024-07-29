package com.dcat23.learningnetwork.mapper;

import com.dcat23.learningnetwork.dto.ResourceResponse;
import com.dcat23.learningnetwork.dto.ResourceUpdateDTO;
import com.dcat23.learningnetwork.dto.ResourceUploadDTO;
import com.dcat23.learningnetwork.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    @Mapping(target = "fileUrl", ignore = true)
    @Mapping(target = "uploadedByUserId", source = "userId")
    Resource map(ResourceUploadDTO resourceUploadDTO);

    ResourceResponse map(Resource resource);

    List<ResourceResponse> map(List<Resource> resources);

    void update(ResourceUpdateDTO resourceUpdateDTO, @MappingTarget Resource resource);
}
