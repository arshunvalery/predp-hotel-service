package com.hotel.adapter.controller.user;


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
@RequestMapping("/users")
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(userFacade.create(userDto));
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(userFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(userFacade.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(userFacade.delete(id));
    }

    @PatchMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(userFacade.update(userDto));
    }
}
