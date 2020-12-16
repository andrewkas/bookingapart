package org.homeapart.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.repository.ApartRepository;
import org.homeapart.service.AddressService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
public class ApartRepositoryImpl implements ApartRepository {

  private SessionFactory sessionFactory;


  public ApartRepositoryImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Apart> findByAddress(String country, String city) {
    try (Session session = sessionFactory.openSession()) {
      return session
              .createQuery("select a from Apart a where a.address.country=:country and a.address.city=:city", Apart.class)
              .list();

    }
  }

  @Override
  public List<Apart> findByStatus(ApartamentStatus status) {
    try (Session session = sessionFactory.openSession()) {
      return session
          .createQuery("select a from Apart a where a.status=: status",Apart.class)
          .list();
    }
  }

  @Override
  public List<Apart> findByType(String type) {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("select a from Apart a where a.type=:type", Apart.class).list();
    }
  }

  @Override
  public List<Apart> findByLandlord(Landlord landlord) {
    try (Session session = sessionFactory.openSession()) {

      return session.createQuery("select a from Apart a where a.landlord=:landlord",Apart.class).list();
    }
      }

    @Override
  public Apart save(Apart object) {
    try (Session session = sessionFactory.openSession()) {
      session.saveOrUpdate(object);
      return object;
    }
  }

  @Override
  public List<Apart> findAll() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("select a from Apart a", Apart.class).list();
    }
  }

  @Override
  public Apart findById(Long key) {
    try (Session session = sessionFactory.openSession()) {
      return session.find(Apart.class, key);
    }
  }

  @Override
  public Apart update(Apart object) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      session.saveOrUpdate(object);
      transaction.commit();
      return object;
    }
  }

  @Override
  public Long delete(Apart object) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      session.delete(object);
      transaction.commit();
      return object.getId();
    }
  }
}
