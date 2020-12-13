package org.homeapart.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homeapart.domain.Address;
import org.homeapart.repository.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Log4j2
public class AddressRepositoryImpl implements AddressRepository {

    private SessionFactory sessionFactory;

    public AddressRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Address findByCity(String city) {
    try (Session session = sessionFactory.openSession()) {
      return session.find(Address.class, city);
        }
    }

    @Override
    public Address findByCountry(String country) {
        try(Session session=sessionFactory.openSession()){
            return session.find(Address.class,country);
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
    public Address findById(Long key) {
        try(Session session=sessionFactory.openSession()){
        return session.find(Address.class,key);
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
