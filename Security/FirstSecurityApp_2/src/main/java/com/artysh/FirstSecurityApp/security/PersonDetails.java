package com.artysh.FirstSecurityApp.security;

import com.artysh.FirstSecurityApp.models.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // это означает, что этот акаунт не просрочен, действителен
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // этот аккаунт не заблокирован
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // пароль не просрочен
    }

    @Override
    public boolean isEnabled() {
        return true; // этот аккаунт включен
    }

    // чтобы получать данные аутентифицированного пользователя
    public Person getPerson() {
        return  this.person;
    }
}
