package com.example.clone.security.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clone.entity.Member;
import com.example.clone.entity.MemberRole;
import com.example.clone.repository.MemberRepositroy;
import com.example.clone.security.dto.AuthMemberDto;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class Oauth2UserDetailsService extends DefaultOAuth2UserService{

  @Autowired
  private MemberRepositroy repositroy;
  @Autowired
  private PasswordEncoder encoder;

  @Override
  @Transactional
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    log.error(userRequest);

    String clientName = userRequest.getClientRegistration().getClientName();
    Map<?,?> params = userRequest.getAdditionalParameters();
    OAuth2User oAuth2User = super.loadUser(userRequest);

    log.error(clientName);
    log.error(params);
    log.error(oAuth2User);

    oAuth2User.getAttributes().forEach((k,v) -> { log.info(k); log.info(v); });

    String email = null;
    if(clientName.equalsIgnoreCase("google")){
      email = oAuth2User.getAttribute("email");
    }

    Member member = saveSocialMember(email);

    AuthMemberDto authMemberDto = new AuthMemberDto(
      member.getEmail(), 
      member.getPassword(), 
      member.getMno(), 
      member.getFromSocial(), 
      member.getName(), 
      member.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).toList(), 
      oAuth2User.getAttributes()
    );
    return authMemberDto;
  }

  @Transactional
  private Member saveSocialMember(String email){
    Member member = repositroy.findByEmailAndFromSocial(email, true);

    if(member != null){ return member; }
    Member member2 = Member.builder()
      .email(email)
      .password(encoder.encode("1234"))
      .fromSocial(true)
    .build();
    member2.addMemberRole(MemberRole.USER);
    repositroy.save(member2);

    return member2;
  }
    
}
