package org.homeapart.repository.impl;



import org.homeapart.domain.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.repository.UserRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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
    public Optional<User> findByLogin(String login) {
        try (
                Session session=sessionFactory.openSession()){

            return session.createQuery("select u from User u where u.login=:login",User.class)
                    .setParameter("login",login).uniqueResultOptional();


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
    public Optional <User> findById(Long key) {
        try(Session session = sessionFactory.openSession()) {

            return Optional.ofNullable(session.find(User.class, key));
        }
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
    public Long delete(User user) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(user);
            transaction.commit();
            return user.getId();
        }
    }
}


