package org.homeapart.repository.impl;


import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.domain.Booking;
import org.homeapart.domain.User;
import org.homeapart.repository.BookingRepository;
import org.homeapart.service.UserService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Log4j2
public class BookingRepositoryImpl implements BookingRepository {

    private SessionFactory sessionFactory;
    private UserService userService;


    public BookingRepositoryImpl(SessionFactory sessionFactory, UserService userService) {
        this.sessionFactory = sessionFactory;
        this.userService = userService;
    }

    @Override
    public List<Booking> findByUserId(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            User user=userService.findById(userId);
            return session.createQuery("select b from Booking b where b.user=:user", Booking.class)
                    .setParameter("user", user).list();

        }
    }

    @Override
    public Booking save(Booking object) {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(object);
            return object;
        }
    }

    @Override
    public List<Booking> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select b from Booking b", Booking.class).list();
        }
    }

    @Override
    public Optional<Booking> findById(Long key) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.find(Booking.class, key));
        }
    }

    @Override
    public Booking update(Booking object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(object);
            transaction.commit();
            return object;
        }
    }

    @Override
    public Long delete(Booking object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(object);
            transaction.commit();
            return object.getId();
        }
    }
}
