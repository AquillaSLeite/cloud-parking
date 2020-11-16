package com.leite.silva.aquilla.cloudparking.mapper;

import com.leite.silva.aquilla.cloudparking.dto.response.ParkingResponseDto;
import com.leite.silva.aquilla.cloudparking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingResponseDto parkingResponseDto(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingResponseDto.class);
    }

    public List<ParkingResponseDto> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::parkingResponseDto).collect(Collectors.toList());
    }
}
