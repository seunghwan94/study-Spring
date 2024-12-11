package site.mplace.di.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import site.mplace.di.vo.Post;

@Log4j2
@Service("normal")
public class PostServiceImplNormal implements PostService{

  @Override
  public List<Post> list() {
    List<Post> list = new ArrayList<>();
    list.add(Post.builder().pno(3L).title("일반 게시판 제목").writer("작성자").build());
    list.add(Post.builder().pno(4L).title("일반 게시판 제목").writer("작성자").build());
    
    return list;
  }

  @Override
  public void write(Post post) {
    log.info(getClass().getSimpleName() + ".write() call");
    
  }
  
}
