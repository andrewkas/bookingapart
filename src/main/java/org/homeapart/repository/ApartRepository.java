package org.homeapart.repository;

import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.domain.enums.ApartamentType;


import java.util.List;
import java.util.Optional;

public interface ApartRepository extends CrudRepository<Long, Apart> {

    //List<Apart> search(String query);

    List<Apart> findByAddress(String country,String city);

    List<Apart> findByStatus(ApartamentStatus status);

    List <Apart> findByType(ApartamentType type);

    List <Apart> findByLandlord(Landlord landlord);




}
