package com.hotel.application.impl;

import com.hotel.application.api.repository.RoomRepository;
import com.hotel.application.api.service.RoomService;
import com.hotel.application.exceptions.ResourceIsUsedException;
import com.hotel.application.exceptions.ResourceNotFoundException;
import com.hotel.domain.Room;
import com.hotel.domain.enums.RoomStatus;
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
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Transactional
    @Override
    public Room create(Room entity) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ КОМНАТЫ!!!");

        if(roomRepository.existsByRoomNumber(entity.getNumber()))
        {
            throw new ResourceIsUsedException("Комната", "номером", entity.getNumber());
        }

        entity.setStatus(RoomStatus.FREE);
        return roomRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Room> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ КОМНАТЫ!!!");
        return roomRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Room findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ КОМНАТЫ!!!");
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room", "ID", id));
    }

    @Transactional
    @Override
    public UUID delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ КОМНАТЫ!!!");
        return roomRepository.delete(id);
    }

    @Transactional
    @Override
    public Room update(Room entity) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ КОМНАТЫ!!!");

        if(!roomRepository.existsByRoomNumber(entity.getNumber()))
        {
            throw new ResourceIsUsedException("Комната", "номером", entity.getNumber());
        }

        return roomRepository.save(entity);
    }

    @Transactional
    @Override
    public RoomStatus changeStatus(UUID id) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ СТАТУСА ОДНОГО В СЕРВИСЕ КОМНАТЫ!!!");


        Room entity = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room", "ID", id));

        if(entity.getStatus().toString().equals("BUSY")){
            throw new ResourceIsUsedException("Комната", "номером", entity.getNumber());
        }

        return roomRepository.changeStatus(entity);
    }
}
