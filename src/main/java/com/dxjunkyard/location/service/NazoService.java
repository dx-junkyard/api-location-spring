package com.dxjunkyard.location.service;

import com.dxjunkyard.location.domain.dto.GeometryDto;
import com.dxjunkyard.location.domain.resource.Geometry;
import com.dxjunkyard.location.domain.resource.Neighbor;
import com.dxjunkyard.location.domain.resource.Neighborhood;
import com.dxjunkyard.location.domain.resource.request.AddLocationRequest;
import com.dxjunkyard.location.domain.resource.response.GetNeighborhoodResponse;
import com.dxjunkyard.location.repository.dao.mapper.NazoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NazoService {
    @Autowired
    NazoMapper nazoMapper;

    public void addLocation(AddLocationRequest request) {
        nazoMapper.addLocation(request.getId(), GeometryDto.getPoint(request.getLongitude(), request.getLatitude()));
    }

    public GetNeighborhoodResponse getNeighborhoodNazo(String latitude, String longitude, Integer rangem) {
        List<Neighbor> nazoList = new ArrayList<>();
        List<Neighborhood> allNazoList = nazoMapper.getNeighborhoodNazo(GeometryDto.getPoint(longitude, latitude));
        for (Neighborhood nazo : allNazoList) {
            if (nazo.getDistance() < rangem) {
                nazoList.add(
                        Neighbor.builder()
                                .id(nazo.getId())
                                .geo(Geometry.builder()
                                        .latitude(nazo.getLatitude())
                                        .longitude(nazo.getLongitude())
                                        .build())
                                .build());
            }
        }
        return GetNeighborhoodResponse.builder().nazoList(nazoList).build();
    }
}
