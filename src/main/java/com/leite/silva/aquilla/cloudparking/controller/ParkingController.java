package com.leite.silva.aquilla.cloudparking.controller;

import com.leite.silva.aquilla.cloudparking.mapper.ParkingMapper;
import com.leite.silva.aquilla.cloudparking.dto.response.ParkingResponseDto;
import com.leite.silva.aquilla.cloudparking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/parkings")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingResponseDto> index() {
        return parkingMapper.toParkingDTOList(parkingService.findAll());
    }
}
