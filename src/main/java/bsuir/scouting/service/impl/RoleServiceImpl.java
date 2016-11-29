package bsuir.scouting.service.impl;

import bsuir.scouting.model.domain.Role;
import bsuir.scouting.repository.RoleRepository;
import bsuir.scouting.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void delete(Long id) {
        Role role = roleRepository.findOne(id);
        roleRepository.delete(role);
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
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
