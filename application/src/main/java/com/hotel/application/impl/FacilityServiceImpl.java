package com.hotel.application.impl;

import com.hotel.application.api.repository.FacilityRepository;
import com.hotel.application.api.service.FacilityService;
import com.hotel.application.exceptions.ResourceNotFoundException;
import com.hotel.domain.Facility;
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
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    @Transactional
    @Override
    public Facility create(Facility entity) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ УСЛУГИ!!!");
        return facilityRepository.save(entity);
    }

    @Transactional
    @Override
    public Collection<Facility> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ УСЛУГИ!!!");
        return facilityRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Facility findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ УСЛУГИ!!!");
        return facilityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Falitity", "ID", id));
    }

    @Transactional
    @Override
    public UUID delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ УСЛУГИ!!!");
        return facilityRepository.delete(id);
    }

    @Transactional
    @Override
    public Facility update(Facility entity) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ УСЛУГИ!!!");
        return facilityRepository.update(entity);
    }
}
