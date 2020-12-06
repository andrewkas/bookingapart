package org.homeapart.repository;

import org.homeapart.domain.Apart;

import java.util.List;
import java.util.Optional;

public interface ApartRepository extends CrudRepository{

    List<Apart> search(String query);

    Optional<Apart> findByStatus(String status);
}
