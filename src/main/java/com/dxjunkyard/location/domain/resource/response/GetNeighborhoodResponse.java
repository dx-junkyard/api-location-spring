package com.dxjunkyard.location.domain.resource.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.dxjunkyard.location.domain.resource.Neighbor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetNeighborhoodResponse {
    private List<Neighbor> nazoList;
}
