package com.hotel.adapter.controller.guest;

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
@RequestMapping("/guests")
public class GuestController {

    private final GuestFacade guestFacade;

    @PostMapping
    public ResponseEntity<GuestDto> create(@Valid @RequestBody GuestDto guestDto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(guestFacade.create(guestDto));
    }

    @GetMapping
    public ResponseEntity<Collection<GuestDto>> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(guestFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDto> findById(@PathVariable UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(guestFacade.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(guestFacade.delete(id));
    }

    @PatchMapping
    public ResponseEntity<GuestDto> update(@RequestBody GuestDto guestDto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(guestFacade.update(guestDto));
    }
}
