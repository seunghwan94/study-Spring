package com.example.clone.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "tbl_member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long mno;

  private String email;

  private String password;

  private String name;

  private Boolean fromSocial;

  @Builder.Default
  @ElementCollection(fetch = FetchType.LAZY)
  private Set<MemberRole> roleSet = new HashSet<>();

  public void addMemberRole(MemberRole memberRole){
    roleSet.add(memberRole);
  }
}
