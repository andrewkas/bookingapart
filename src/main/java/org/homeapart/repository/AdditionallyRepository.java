package org.homeapart.repository;

import org.homeapart.domain.Additionally;

import java.util.List;


public interface AdditionallyRepository extends CrudRepository <Long, Additionally> {

    List<Additionally> findByApartId(long id);
}
