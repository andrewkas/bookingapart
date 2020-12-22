package org.homeapart.repository.impl;


import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.domain.Booking;
import org.homeapart.repository.BookingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository


public class BookingRepositoryImpl implements BookingRepository {

    private SessionFactory sessionFactory;


    public BookingRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Booking> findByUserId(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select b from Booking b where b.user.id=:userId", Booking.class)
                    .setParameter("userId", userId).list();

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
    public Booking findById(Long key) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Booking.class, key);
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
