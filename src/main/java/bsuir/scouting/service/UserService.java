package bsuir.scouting.service;


import bsuir.scouting.model.domain.User;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<User> findAll(Long teamId);
}
