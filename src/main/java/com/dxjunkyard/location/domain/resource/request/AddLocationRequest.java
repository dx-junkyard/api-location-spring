package com.dxjunkyard.location.domain.resource.request;

import lombok.Data;

@Data
public class AddLocationRequest {
    private Integer id; //
    private String latitude;  // y : 緯度、北緯
    private String longitude; // x : 経度、東経
}
