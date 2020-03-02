package de.dimk.repository;

import de.dimk.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("select acct from Account acct where acct.userName = :username")
    Account findByUserName(@Param("username") String userName);

}
