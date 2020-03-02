package de.dimk.service;

import de.dimk.model.Account;

public interface AccountService {
    Account findByUsername(String username);
}
