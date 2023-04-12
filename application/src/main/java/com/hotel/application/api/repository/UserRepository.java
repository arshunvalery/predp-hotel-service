package com.hotel.application.api.repository;

import com.hotel.domain.User;

public interface UserRepository extends BaseRepository<User>{

    User loadUserByUsername(String str);
}
