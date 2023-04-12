package com.hotel.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "guests")
public class Guest extends BaseEntity {
    private String name;
    private String surname;
    private String tel;
    private int age;
    private String gender;
    private int cash;

    @OneToMany(mappedBy = "guest")
    private List<Order> orders;
}
