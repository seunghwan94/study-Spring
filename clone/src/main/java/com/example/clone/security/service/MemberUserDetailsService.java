package com.example.clone.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.clone.entity.Member;
import com.example.clone.repository.MemberRepositroy;
import com.example.clone.security.dto.AuthMemberDto;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MemberUserDetailsService implements UserDetailsService{
  @Autowired
  private MemberRepositroy repositroy;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info(username);
    Member member = repositroy.findByEmailAndFromSocial(username, false);
    if(member == null){
      throw new UsernameNotFoundException(username);
    }

    AuthMemberDto authMemberDto = new AuthMemberDto(member.getEmail(), member.getPassword(), member.getMno(), member.getFromSocial()
      , member.getName(), member.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).toList());
    
    return authMemberDto;
  }
    
}
