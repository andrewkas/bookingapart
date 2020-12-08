package org.homeapart.repository.impl;

import org.apache.log4j.Logger;
import org.homeapart.domain.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Log4j2
public class UserRepositoryImpl implements UserRepository {


    private SessionFactory sessionFactory;


    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<User> findAll() {
        try(Session session = sessionFactory.openSession()) {
           return session.createQuery("select u from User u order by u.id asc", User.class).list();

        }
    }

    @Override
    public List<User> search(String query) {
        return null;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try (
        Session session=sessionFactory.openSession()){

        return Optional.of(session.find(User.class,login));
    }
    }

    @Override
    public User save(User object) {
        try(Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(object);
            return object;
        }
    }

    @Override
    public User findById(Long key) {
        try(Session session = sessionFactory.openSession()) {
            return session.find(User.class, key);
        }
    }

    @Override
    public Optional<User> findOne(Long key) {
        Session session=sessionFactory.openSession();
        return Optional.of(session.find(User.class,key));
    }

    @Override
    public User update(User object) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(object);
            transaction.commit();
            return object;
        }
    }

    @Override
    public Long delete(User object) {
        try(Session session = sessionFactory.openSession()) {
            session.delete(object);
            return object.getId();
        }
    }
}


