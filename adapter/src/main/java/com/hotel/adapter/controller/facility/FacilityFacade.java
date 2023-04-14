package com.hotel.adapter.controller.facility;

import com.hotel.application.api.service.FacilityService;
import com.hotel.domain.Facility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FacilityFacade {

    private final FacilityService facilityService;

    private final FacilityMapper facilityMapper;


    public FacilityDto create(FacilityDto facilityDto) {
        Facility facility = facilityMapper.toEntity(facilityDto);
        return facilityMapper.toDto(facilityService.create(facility));
    }

    public Collection<FacilityDto> findAll() {
        return facilityService.findAll()
                .stream()
                .map(facilityMapper::toDto)
                .collect(Collectors.toList());
    }

    public FacilityDto findById(UUID id) {
        return facilityMapper.toDto(facilityService.findById(id));
    }

    public UUID delete(UUID id) {
        return facilityService.delete(id);
    }

    public FacilityDto update(FacilityDto facilityDto) {
        Facility facility = facilityMapper.toEntity(facilityDto);
        return facilityMapper.toDto(facilityService.update(facility));
    }
}