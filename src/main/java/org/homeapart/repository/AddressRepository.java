package org.homeapart.repository;

import org.homeapart.domain.Address;

public interface AddressRepository extends CrudRepository<Long,Address>{

    Address findByCity(String city);

    Address findByCountry(String country);

}
