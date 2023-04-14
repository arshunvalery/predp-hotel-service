package com.hotel.adapter.controller.order;

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
@RequestMapping("/orders")
public class OrderController {

    private final OrderFacade orderFacade;

    @PostMapping
    public ResponseEntity<OrderDto> create(@Valid @RequestBody OrderDto orderDto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(orderFacade.create(orderDto));
    }

    @GetMapping
    public ResponseEntity<Collection<OrderDto>> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(orderFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(orderFacade.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(orderFacade.delete(id));
    }

    @PatchMapping
    public ResponseEntity<OrderDto> update(@RequestBody OrderDto orderDto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ГОСТЯ!!!");
        return ResponseEntity.ok(orderFacade.update(orderDto));
    }
}