package com.mft.completeloginservice.model.service;

import com.mft.completeloginservice.controller.exception.NoContentException;
import com.mft.completeloginservice.controller.validation.BeanValidation;
import com.mft.completeloginservice.model.entity.Person;

import com.mft.completeloginservice.model.service.impl.ServiceImpl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class PersonService implements ServiceImpl<Person, Long>, Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
    //    -------------------------------------------------------------------------


    @Override
    @Transactional
    public Person save(Person person) throws Exception {
        // TODO: does it even work?

        BeanValidation<Person> validator = new BeanValidation<>();
        if (validator.validate(person) == null) {
            entityManager.persist(person);
        } else validator.validate(person);

        return person;
    }
    //    -------------------------------------------------------------------------


    @Override
    @Transactional
    public Person edit(Person person) throws Exception {
        entityManager.merge(person);
        return person;
    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public Person remove(Long id) throws Exception {
        Person person = entityManager.find(Person.class, id);
        if (person == null) {
            throw new NoContentException("No Person Was Found !");
        }
        person.setDeleted(true);
        entityManager.merge(person);
        return person;
    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public List<Person> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from personEntity oo where oo.deleted = false");
        List<Person> personList = query.getResultList();

        if (personList.size() == 0) {
            throw new NoContentException("Nothing Was Found !");
        }
        return personList;

    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public Person findById(Long id) throws Exception {
        Person person = entityManager.find(Person.class, id);
        if (person == null) {
            throw new NoContentException("No Person Was Found !");
        }
        return person;
    }
    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public Long getRecordCount() throws Exception {
        return 0L;
    }

    //    -------------------------------------------------------------------------
    @Transactional
    public List<Person> findByNameAndFamily(String name, String family) throws Exception {
        Query query = entityManager.createNamedQuery("Person.FindByNameAndFamily");
        query.setParameter("name", name);
        query.setParameter("family", family);
        List<Person> personList = query.getResultList();
        if (personList.size() == 0) {
            throw new NoContentException("No Person Was Found !");

        }
        return personList;
    }
    //    -------------------------------------------------------------------------

}
