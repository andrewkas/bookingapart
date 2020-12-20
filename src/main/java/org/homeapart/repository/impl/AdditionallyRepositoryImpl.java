package org.homeapart.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.domain.Additionally;
import org.homeapart.domain.Apart;
import org.homeapart.repository.AdditionallyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AdditionallyRepositoryImpl implements AdditionallyRepository {

    private SessionFactory sessionFactory;

    @Override
    public List<Additionally> findByApart(Apart apart) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select a from Additionally a where a.apart=:apart", Additionally.class).list();
        }
    }


    @Override
    public Additionally save(Additionally object) {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(object);
            return object;
        }
    }

    @Override
    public List<Additionally> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select a from Additionally a", Additionally.class).list();
        }
    }

    @Override
    public Additionally findById(Long key) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Additionally.class, key);
        }
    }

    @Override
    public Additionally update(Additionally object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(object);
            transaction.commit();
            return object;
        }
    }

    @Override
    public Long delete(Additionally object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(object);
            transaction.commit();
            return object.getId();
        }
    }
}