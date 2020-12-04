package com.dragan.expensetracker.services;

import com.dragan.expensetracker.domain.User;
import com.dragan.expensetracker.exceptions.EtAuthException;

public interface UserService {

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
    User validateUser(String email, String password) throws EtAuthException;
}
