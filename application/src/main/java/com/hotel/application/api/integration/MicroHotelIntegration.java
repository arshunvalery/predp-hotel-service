package com.hotel.application.api.integration;

import com.hotel.domain.Guest;
import com.hotel.domain.Order;

import java.util.UUID;

public interface MicroHotelIntegration {

    Guest microGuestCreate(Guest guest);

    UUID microGuestDelete(UUID id);

    Guest microGuestUpdate(Guest guest);

    Boolean isPurchasePossible(Order order);
}
