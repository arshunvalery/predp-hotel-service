package com.hotel.adapter.integration;

import com.hotel.application.api.integration.MicroHotelIntegration;
import com.hotel.domain.Guest;
import com.hotel.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MicroHotelIntegrationAdapter implements MicroHotelIntegration {

    private final MicroHotelFeignClient microHotelFeignClient;


    public Guest microGuestCreate(Guest guest) {
        return microHotelFeignClient.microGuestCreate(guest);
    }

    public UUID microGuestDelete(UUID id) {
        return microHotelFeignClient.microGuestDelete(id);
    }

    public Guest microGuestUpdate(Guest guest) {
        return microHotelFeignClient.microGuestUpdate(guest);
    }

    @Override
    public Boolean isPurchasePossible(Order order) {
        return microHotelFeignClient.isPurchasePossible(order);
    }
}
