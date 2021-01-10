package org.homeapart.repository;

import org.homeapart.domain.Additionally;
import org.homeapart.domain.Apart;

import java.util.List;


public interface AdditionallyRepository extends CrudRepository <Long, Additionally> {

    List<Additionally> findByApart(Apart apart);
}
