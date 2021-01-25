package org.homeapart.repository;

import org.homeapart.domain.Role;
import org.homeapart.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

       Optional<User> findByLogin(String login);

       @Query(value="select u.userRole from User u where u.id=:id")
       List<Role> findRole(Long id);

       void removeUserById(Long Id);

    //  List<User> findByLogin(String login);
//
        //  Optional<User> findById(Long id);
//
        //  List<User> findByLoginAndNameAndBirthDate(String login, String name, Date birthDate);
//
        //  List<User> findByLoginAndNameOrBirthDateOrderByIdDescNameDesc(String login, String name, Date birthDate);
//
        //  //select * from m_users where (login = ? and name = ?) or birth_date = ?
//
        //  @Query(value = "select u from User u")
        //  List<User> findByHQLQuery();
//
        //  @Query(value = "select * from m_user", nativeQuery = true)
        //  List<User> findByHQLQueryNative();
//
        //  @Query(value = "select u from User u where u.login = :login and u.name = :userName")
        //  List<User> findByHQLQuery(String login, @Param("userName") String name);
//
        //  @Query("select u.id, u.name from User u")
        //  List<Object[]> getPartsOfUser();


    }

