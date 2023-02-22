package com.dxjunkyard.location.domain.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Neighbor {
    Integer id;
    Geometry geo;
}
