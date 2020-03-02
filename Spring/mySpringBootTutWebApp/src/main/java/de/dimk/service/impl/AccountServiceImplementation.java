package de.dimk.service.impl;

import de.dimk.model.Account;
import de.dimk.repository.AccountRepository;
import de.dimk.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    private AccountRepository acctDao;

    @Override
    public Account findByUsername(String username) {
        return acctDao.findByUserName(username);
    }
}
