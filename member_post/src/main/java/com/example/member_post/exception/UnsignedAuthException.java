package com.example.member_post.exception;

public class UnsignedAuthException extends RuntimeException{
  public UnsignedAuthException(String msg){
    super(msg);
  }
}
