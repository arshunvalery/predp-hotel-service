package com.hotel.adapter.controller.facility;

import com.hotel.adapter.controller.BaseMapper;
import com.hotel.domain.Facility;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacilityMapper extends BaseMapper<FacilityDto, Facility> {
}
