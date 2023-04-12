package com.hotel.adapter.controller.room;

import com.hotel.adapter.dto.RoomDto;
import com.hotel.domain.enums.RoomStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomFacade roomFacade;

    @PostMapping
    public ResponseEntity<RoomDto> create(@Valid @RequestBody RoomDto roomDto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(roomFacade.create(roomDto));
    }

    @GetMapping
    public ResponseEntity<Collection<RoomDto>> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(roomFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findById(@PathVariable UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(roomFacade.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(roomFacade.delete(id));
    }

    @PatchMapping
    public ResponseEntity<RoomDto> update(@RequestBody RoomDto roomDto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(roomFacade.update(roomDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoomStatus> changeStatus(@PathVariable UUID id) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ СТАТУСА ОДНОГО В КОНТРОЛЛЕРЕ КОМНАТЫ!!!");
        return ResponseEntity.ok(roomFacade.changeStatus(id));
    }
}
