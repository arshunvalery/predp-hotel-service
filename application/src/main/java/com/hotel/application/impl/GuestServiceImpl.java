package com.hotel.application.impl;

import com.hotel.application.api.integration.MicroHotelService;
import com.hotel.application.api.repository.GuestRepository;
import com.hotel.application.api.service.GuestService;
import com.hotel.application.exceptions.ResourceIsnotReturnedException;
import com.hotel.application.exceptions.ResourceNotFoundException;
import com.hotel.domain.Guest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;
    private final MicroHotelService microHotelService;

    @Transactional
    @Override
    public Guest create(Guest entity) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ ГОСТЯ!!!");

        guestRepository.save(entity);

        if(microHotelService.microGuestCreate(entity) == null){
            throw new ResourceIsnotReturnedException("Guest");
        }

        return entity;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Guest> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ ГОСТЯ!!!");
        return guestRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Guest findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        return guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest", "ID", id));
    }

    @Transactional
    @Override
    public UUID delete(UUID id) {

        if(microHotelService.microGuestDelete(id) == null){
            throw new ResourceIsnotReturnedException("Guest");
        }

        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        return guestRepository.delete(id);
    }

    @Transactional
    @Override
    public Guest update(Guest entity) {

        if(microHotelService.microGuestUpdate(entity) == null){
            throw new ResourceIsnotReturnedException("Guest");
        }

        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        return guestRepository.update(entity);
    }
}
