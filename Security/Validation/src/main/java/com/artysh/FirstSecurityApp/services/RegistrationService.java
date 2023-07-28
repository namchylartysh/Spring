package com.artysh.FirstSecurityApp.services;

import com.artysh.FirstSecurityApp.models.Person;
import com.artysh.FirstSecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional // указывает на то, что происходит изменения в базе данных
    public void register(Person person) {
        peopleRepository.save(person);
    }
}
