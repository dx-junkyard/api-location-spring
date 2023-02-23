package com.dxjunkyard.location.service;

import com.dxjunkyard.location.domain.dto.GeometryDto;
import com.dxjunkyard.location.domain.resource.Geometry;
import com.dxjunkyard.location.domain.resource.Neighbor;
import com.dxjunkyard.location.domain.resource.Neighborhood;
import com.dxjunkyard.location.domain.resource.request.AddLocationRequest;
import com.dxjunkyard.location.domain.resource.response.GetNeighborhoodResponse;
import com.dxjunkyard.location.repository.dao.mapper.GeometryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GeometryService {
    @Autowired
    GeometryMapper geometryMapper;

    public void addLocation(AddLocationRequest request) {
        geometryMapper.addLocation(request.getId(), GeometryDto.getPoint(request.getLongitude(), request.getLatitude()));
    }

    public GetNeighborhoodResponse getNeighborhood(String latitude, String longitude, Integer rangem) {
        List<Neighbor> neighborList = new ArrayList<>();
        List<Neighborhood> allNazoList = geometryMapper.getNeighborhood(GeometryDto.getPoint(longitude, latitude));
        for (Neighborhood neighbor : allNazoList) {
            if (neighbor.getDistance() < rangem) {
                neighborList.add(
                        Neighbor.builder()
                                .id(neighbor.getId())
                                .geo(Geometry.builder()
                                        .latitude(neighbor.getLatitude())
                                        .longitude(neighbor.getLongitude())
                                        .build())
                                .build());
            }
        }
        return GetNeighborhoodResponse.builder().neighborList(neighborList).build();
    }
}
