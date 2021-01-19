package com.emirozturk.Security;

import com.emirozturk.Entity.Role;
import com.emirozturk.Entity.User;
import com.emirozturk.Entity.UserChannel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BildirimUserDetails implements UserDetails {
    User user;

    public BildirimUserDetails(User user) {
        this.user = user;
    }

    public List<UserChannel> getChannels(){
        return user.getUserChannels();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = user.getRoles();
        for(var role:roles){
            var roleString = role.getRole();
            var auth = new SimpleGrantedAuthority(roleString);
            auths.add(auth);
        }
        return auths;
        */
        return user.getRoles().stream().map(x->new SimpleGrantedAuthority(x.getRole())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getEnabled() == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getEnabled() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getEnabled() == 1;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled()==1;
    }
}
