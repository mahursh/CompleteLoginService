package com.mft.completeloginservice.model.service;

import com.mft.completeloginservice.controller.exception.NoContentException;
import com.mft.completeloginservice.model.entity.User;
import com.mft.completeloginservice.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


import java.io.Serializable;
import java.util.List;

import static com.mft.completeloginservice.controller.encryption.Base64.Encoder.baseEncoder;

@ApplicationScoped
public class UserService implements ServiceImpl<User, Long>, Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
    //    -------------------------------------------------------------------------


    @Override
    @Transactional
    public User save(User user) throws Exception {

        String password = baseEncoder(user.getPassword());
        user.setPassword(password);

        entityManager.persist(user);
        System.out.println(user);
        return user;

    }

    //    -------------------------------------------------------------------------

    @Override
    @Transactional
    public User edit(User user) throws Exception {
        // TODO: checking deleted = false

        entityManager.merge(user);
        return user;
    }

    //    -------------------------------------------------------------------------
    @Override
    @Transactional
    public User remove(Long id) throws Exception {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new NoContentException("No User Was Found !");
        }
        user.setDeleted(true);
        entityManager.merge(user);
        return user;
    }

    //    -------------------------------------------------------------------------
    @Override
    @Transactional
    public List<User> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from userEntity oo where oo.deleted = false ");
        List<User> userList = query.getResultList();
        if (userList.size() == 0) {
            throw new NoContentException("Nothing Was Found !");
        }

        return userList;
    }

    //    -------------------------------------------------------------------------
    @Override
    @Transactional
    public User findById(Long id) throws Exception {
        User user = entityManager.find(User.class, id);

        if (user == null) {
            throw new NoContentException("No User Was Found !");
        }
        return user;

    }

    //    -------------------------------------------------------------------------
    @Override
    @Transactional
    public Long getRecordCount() throws Exception {
        return null;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    public User findByUserName(String userName) throws Exception {
        Query query = entityManager.createNamedQuery("User.FindByUserName");
        query.setParameter("userName", userName);
        User user = (User) query.getSingleResult();
        if (user == null) {
            throw new NoContentException("No User Was Found !");
        }

        return user;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    public User findByUserNameAndPassword(String userName, String password) throws Exception {
        Query query = entityManager.createNamedQuery("User.FindByUserNameAndPassword");
        query.setParameter("userName", userName);
        query.setParameter("password", password);

        User user = (User) query.getSingleResult();
        if (user == null) {
            throw new NoContentException("No User Was Found ! ");
        }
        return user;
    }
    //    -------------------------------------------------------------------------

    @Transactional
    public User findEmailByUserName(String userName) throws Exception {
        Query query = entityManager.createNamedQuery("User.FindEmailByUserName");
        query.setParameter("userName", userName);

        User user = (User) query.getSingleResult();
        if (user == null) {
            throw new NoContentException("No User Was Found ! ");
        }
        return user;
    }

}
