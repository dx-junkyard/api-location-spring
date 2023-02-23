package com.dxjunkyard.location.controller;

import lombok.extern.slf4j.Slf4j;
import com.dxjunkyard.location.domain.resource.request.*;
import com.dxjunkyard.location.domain.resource.response.*;
import com.dxjunkyard.location.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api")
@Slf4j
public class Controller {
    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private GeometryService geometryService;

    /**
     * ★location
     */
    @PostMapping("/location")
    @ResponseBody
    public NormalResponse addLocation(
            @RequestBody AddLocationRequest request){
        logger.info("geometry API");
        try {
            geometryService.addLocation(request);
            return NormalResponse.builder().result("OK").build();
        } catch (Exception e) {
            logger.info("geometry" + e.getMessage());
            return NormalResponse.builder().result("NG").build();
        }
    }

    /**
     * ★location
     */
    @GetMapping("/location")
    @ResponseBody
    public GetNeighborhoodResponse getNeighborhoodNazo(
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude,
            @RequestParam("rangem") Integer rangem) {
        logger.info("geometry API");
        try {
            GetNeighborhoodResponse response = geometryService.getNeighborhood(latitude, longitude, rangem);
            return response;
        } catch (Exception e) {
            return GetNeighborhoodResponse.builder().build();
        }
    }


    @GetMapping("/hello")
    @ResponseBody
    public NormalResponse checkin(){
        logger.info("疎通確認 URL");
        return NormalResponse.builder().result("OK").build();
    }

}
