package com.hotel.application.impl;

import com.hotel.application.api.integration.MicroHotelIntegration;
import com.hotel.application.api.integration.MicroHotelService;
import com.hotel.domain.Guest;
import com.hotel.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MicroHotelServiceImpl implements MicroHotelService {

    private final MicroHotelIntegration microHotelIntegration;

    @Override
    public Guest microGuestCreate(Guest guest) {
        return microHotelIntegration.microGuestCreate(guest);
    }

    @Override
    public UUID microGuestDelete(UUID id) {
        return microHotelIntegration.microGuestDelete(id);
    }

    @Override
    public Guest microGuestUpdate(Guest guest) {
        return microHotelIntegration.microGuestUpdate(guest);
    }

    @Override
    public Boolean isPurchasePossible(Order order){
        return microHotelIntegration.isPurchasePossible(order);
    }
}
