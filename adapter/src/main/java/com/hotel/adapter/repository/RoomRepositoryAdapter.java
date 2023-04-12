package com.hotel.adapter.repository;

import com.hotel.application.api.repository.RoomRepository;
import com.hotel.domain.Room;
import com.hotel.domain.enums.RoomStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RoomRepositoryAdapter implements RoomRepository {

    private final RoomJpaRepository roomJpaRepository;

    @Override
    public Room save(Room entity) {
        return roomJpaRepository.save(entity);
    }

    @Override
    public Collection<Room> findAll() {
        return roomJpaRepository.findAll();
    }

    @Override
    public Optional<Room> findById(UUID id) {
        return roomJpaRepository.findById(id);
    }

    @Override
    public UUID delete(UUID id) {
        roomJpaRepository.deleteById(id);
        return id;
    }

    @Override
    public Room update(Room entity) {
        return roomJpaRepository.save(entity);
    }

    @Override
    public RoomStatus changeStatus(Room room) {

        switch (room.getStatus()) {
            case FREE: {
                room.setStatus(RoomStatus.REPAIRED);
                return RoomStatus.REPAIRED;
            }

            case REPAIRED: {
                room.setStatus(RoomStatus.FREE);
                return RoomStatus.FREE;
            }
            default:
                return null;
        }
    }

    @Override
    public Room autoChangeStatus(Room room, RoomStatus roomStatus) {
        room.setStatus(roomStatus);
        return room;
    }

    @Override
    public Boolean existsByRoomNumber(String number) {
        return roomJpaRepository.findAll().stream().anyMatch(n -> n.getNumber().equals(number));
    }
}
