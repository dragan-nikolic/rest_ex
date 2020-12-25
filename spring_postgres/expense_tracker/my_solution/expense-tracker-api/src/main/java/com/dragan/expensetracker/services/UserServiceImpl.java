package com.dragan.expensetracker.services;

import com.dragan.expensetracker.domain.User;
import com.dragan.expensetracker.exceptions.EtAuthException;
import com.dragan.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        validateEmail(email);

        Integer count = userRepository.getCountByEmail(email);
        if (count > 0) throw new EtAuthException("Email already in use!");

        Integer userId = userRepository.create(firstName, lastName, email, password);

        return userRepository.findById(userId);
    }

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        validateEmail(email);

        return userRepository.findByEmailAndPassword(email, password);
    }

    private void validateEmail(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches()) throw new EtAuthException("Invalid email format!");
    }
}
