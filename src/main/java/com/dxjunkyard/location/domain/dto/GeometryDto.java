package com.dxjunkyard.location.domain.dto;

public class GeometryDto {
    public static String getPoint(String x_geometry, String y_geometry) {
        String point = "POINT(" + y_geometry + " " + x_geometry + ")";
        return point;
    }
}
