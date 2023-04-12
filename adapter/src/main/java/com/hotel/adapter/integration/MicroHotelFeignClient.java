package com.hotel.adapter.integration;

import com.hotel.domain.Guest;
import com.hotel.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "microhotel", url="${service.microhotel.url}")
public interface MicroHotelFeignClient {

    @PostMapping("/guests/microcreate")
    Guest microGuestCreate(Guest guest);

    @DeleteMapping("/guests/microdelete/{id}")
    UUID microGuestDelete(@PathVariable("id") UUID id);

    @PostMapping("/guests/microupdate")
    Guest microGuestUpdate(Guest guest);

    @PostMapping("/orders/possible")
    Boolean isPurchasePossible(Order order);
}
