package com.sy.shya.user.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sy.shya.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    /*
     * name은 key가 아니기 때문에 User를 리턴하면 에러가 난다.
     * key가 아니면 다수가 조회 될 수 있기때문에 List로 반환해야 한다.
    */
    @Query( "select id, name, password from User where name = :name" )
    public List<User> findUsersForName( @Param( "name" ) String name );

    // from User where name like %:name%
    public List<User> findByNameContaining( String name );
}
