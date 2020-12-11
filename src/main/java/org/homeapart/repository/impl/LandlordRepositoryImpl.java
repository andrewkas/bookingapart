package org.homeapart.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.User;
import org.homeapart.repository.LandlordRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Log4j2
public class LandlordRepositoryImpl implements LandlordRepository {

    private SessionFactory sessionFactory;

    public LandlordRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Landlord> findByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.of(session.find(Landlord.class, login));
        }
    }

    @Override
    public Landlord save(Landlord object) {
        try (Session session = sessionFactory.openSession())
        {
          session.saveOrUpdate(object);}
        return object;
    }

    @Override
    public List<Landlord> findAll() {
        try (Session session = sessionFactory.openSession()){

            return session.createQuery("select l from Landlord l", Landlord.class).list();
        }
    }

    @Override
    public Landlord findById(Long key) {
        try (Session session=sessionFactory.openSession()){

        return session.find(Landlord.class,key);
    }
    }

    @Override
    public Landlord update(Landlord object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            return object;
        }
    }

        @Override
        public Long delete (Landlord object){
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.getTransaction();
                transaction.begin();
                session.delete(object);
                transaction.commit();
                return object.getId();
            }
        }
    }
