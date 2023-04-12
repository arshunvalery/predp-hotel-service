package com.hotel.domain;

import com.hotel.domain.enums.RoomStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room extends BaseEntity{
    private String number;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    private int price;

    @OneToMany(mappedBy = "room")
    private List<Order> orders;
}