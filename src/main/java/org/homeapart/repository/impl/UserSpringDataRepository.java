package org.homeapart.repository.impl;

import org.homeapart.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface UserSpringDataRepository extends JpaRepository<User,Long> {


    List<User> findByLogin(String login);

    Optional<User> findById(Long id);

    List<User> findByLoginAndNameAndBirthDate(String login, String name, Date birthDate);

    List<User> findByLoginAndNameOrBirthDateOrderByIdDescNameDesc(String login, String name, Date birthDate);

    //select * from m_users where (login = ? and name = ?) or birth_date = ?

    @Query(value = "select u from User u")
    List<User> findByHQLQuery();

    @Query(value = "select * from m_user", nativeQuery = true)
    List<User> findByHQLQueryNative();

    @Query(value = "select u from User u where u.login = :login and u.name = :userName")
    List<User> findByHQLQuery(String login, @Param("userName") String name);

    @Query("select u.id, u.name from User u")
    List<Object[]> getPartsOfUser();


}
