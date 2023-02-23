package com.dxjunkyard.location.repository.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.dxjunkyard.location.domain.resource.Neighborhood;

import java.util.List;

@Mapper
public interface GeometryMapper {
    void addLocation(Integer id, String location);
    List<Neighborhood> getNeighborhood(String location);
}
