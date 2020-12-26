package org.homeapart.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.domain.Address;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;
import org.homeapart.repository.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class AddressRepositoryImpl implements AddressRepository {

    private SessionFactory sessionFactory;

    public AddressRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Address> findByCity(City city) {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("select a from Address a where a.city=:city",Address.class).setParameter("city",city).list();
        }
    }

    @Override
    public List<Address> findByCountry(Country country) {
        try(Session session=sessionFactory.openSession()){
            return session.createQuery("select a from Address a where a.country=:country",Address.class).setParameter("country",country).list();
        }
    }

    @Override
    public List<Address> findByCountryAndCity(Country country,City city) {
        try(Session session=sessionFactory.openSession()){
            return session.createQuery("select a from Address a where a.country=:country and a.city=:city",Address.class).setParameter("country",country).setParameter("city",city).list();
        }
    }

    @Override
    public Address save(Address object) {
        try(Session session=sessionFactory.openSession()){
          session.saveOrUpdate(object);
            return object;
        }

    }

    @Override
    public Optional<Address> findById(Long key) {
        try(Session session=sessionFactory.openSession()){
        return Optional.ofNullable(session.find(Address.class,key));
        }
    }

  @Override
  public Address update(Address object) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      session.saveOrUpdate(object);
      transaction.commit();
      return object;
    }
}
    @Override
    public Long delete(Address object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            return object.getId();
    }
        }

    @Override
  public List<Address> findAll() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("select a from Address a", Address.class).list();
    }
        }

}
