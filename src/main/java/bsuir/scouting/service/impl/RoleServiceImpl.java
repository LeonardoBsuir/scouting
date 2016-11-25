package bsuir.scouting.service.impl;

import bsuir.scouting.domain.Role;
import bsuir.scouting.repository.RoleRepository;
import bsuir.scouting.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void delete(Role entity) {
        roleRepository.delete(entity);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findOne(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }
}
