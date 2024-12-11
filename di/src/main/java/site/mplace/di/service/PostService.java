package site.mplace.di.service;

import java.util.List;

import site.mplace.di.vo.Post;

public interface PostService {
  default void write(Post post){
    
  }
  List<Post> list();
}
