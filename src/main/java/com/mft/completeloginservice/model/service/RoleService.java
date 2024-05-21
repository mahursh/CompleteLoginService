package com.mft.completeloginservice.model.service;

import com.mft.completeloginservice.controller.exception.NoContentException;
import com.mft.completeloginservice.model.entity.Role;
import com.mft.completeloginservice.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class RoleService implements ServiceImpl<Role, Long>,Serializable {
    @PersistenceContext(unitName = "mft" )
    EntityManager entityManager;

    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public Role save(Role role) throws Exception {
        entityManager.persist(role);
        return role;
    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public Role edit(Role role) throws Exception {
        entityManager.merge(role);
        return role;
    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public Role remove(Long id) throws Exception {
        Role role =entityManager.find(Role.class , id);
        if (role == null){
            throw new NoContentException("No Role Was Found !");
        }
        role.setDeleted(true);
        entityManager.merge(role);
        return role;
    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public List<Role> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from roleEntity oo");
        List<Role> roles = query.getResultList();
        if (roles.size()==0){
            throw new NoContentException("Nothing Was Found !");
        }
        return roles;

    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public Role findById(Long id) throws Exception {
        Role role = entityManager.find(Role.class , id);
        if (role == null){
            throw new NoContentException("No Role Was Found !");
        }
        return role;


    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public Long getRecordCount() throws Exception {
        return null;
    }
    //    -------------------------------------------------------------------------

}
