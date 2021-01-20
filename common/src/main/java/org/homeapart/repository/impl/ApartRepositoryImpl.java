package org.homeapart.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.domain.enums.ApartamentType;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import org.homeapart.repository.ApartRepository;
import org.homeapart.service.AddressService;
import org.homeapart.service.LandlordService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

//@Repository
//@Log4j2

public class ApartRepositoryImpl{// implements ApartRepository {

//  private SessionFactory sessionFactory;
//
//
//
//
//  public ApartRepositoryImpl(SessionFactory sessionFactory) {
//    this.sessionFactory = sessionFactory;
//
//  }
//  @Cacheable("apart")
//  @Override
//  public List<Apart> findByAddress(String country, String city) {
//    try (Session session = sessionFactory.openSession()) {
//      return session
//              .createQuery("select a from Apart a where a.address.country=:country and a.address.city=:city", Apart.class)
//              .list();
//
//    }
//  }
//
//  @Override
//  public List<Apart> findByStatus(ApartamentStatus status) {
//    try (Session session = sessionFactory.openSession()) {
//      return session
//          .createQuery("select a from Apart a where a.status=: status",Apart.class).setParameter("status",status).list();
//    }
//  }
//  @Cacheable("apart")
//  @Override
//  public List<Apart> findByType (ApartamentType type) {
//    try (Session session = sessionFactory.openSession()) {
//      return session.createQuery("select a from Apart a where a.type=:type", Apart.class).setParameter("type",type).list();
//    }
//  }
//
//  @Override
//  public List<Apart> findByLandlordId(Long landlordId) {
//    try (Session session = sessionFactory.openSession()) {
//
//
//      return session.createQuery("select a from Apart a where a.landlord.id=:landlordId",Apart.class)
//              .setParameter("landlordId",landlordId).list();
//    }
//      }
//  @Cacheable("apart")
//      @Override
//      public List<Apart> findByParam(Country country,
//                                      City city,
//                                     Integer questNumber,
//                                     ApartamentType type,
//                                    Double costPerDay){
//    try(Session session=sessionFactory.openSession()){
//      return session.createQuery("select a from Apart a where a.address.country=:country and a.address.city=:city " +
//              "and a.guestNumber>:questNumber and a.type=:type and a.costPerDay<:costPerDay",Apart.class)
//              .setParameter("country",country)
//              .setParameter("city",city)
//              .setParameter("questNumber",questNumber)
//              .setParameter("type",type)
//              .setParameter("costPerDay",costPerDay)
//              .list();
//    }
//      }
//
//    @Override
//  public Apart save(Apart object) {
//    try (Session session = sessionFactory.openSession()) {
//      session.saveOrUpdate(object);
//      return object;
//    }
//  }
//  @Cacheable("apart")
//  @Override
//  public List<Apart> findAll() {
//    try (Session session = sessionFactory.openSession()) {
//      return session.createQuery("select a from Apart a", Apart.class).list();
//    }
//  }
//  @Cacheable("apart")
//  @Override
//  public Optional<Apart> findById(Long key) {
//    try (Session session = sessionFactory.openSession()) {
//      return Optional.ofNullable(session.find(Apart.class, key));
//    }
//  }
//
//  @Override
//  public Apart update(Apart object) {
//    try (Session session = sessionFactory.openSession()) {
//      Transaction transaction = session.beginTransaction();
//      session.saveOrUpdate(object);
//      transaction.commit();
//      return object;
//    }
//  }
//
//  @Override
//  public Long delete(Apart object) {
//    try (Session session = sessionFactory.openSession()) {
//      Transaction transaction = session.beginTransaction();
//      session.delete(object);
//      transaction.commit();
//      return object.getId();
//    }
//  }
}
