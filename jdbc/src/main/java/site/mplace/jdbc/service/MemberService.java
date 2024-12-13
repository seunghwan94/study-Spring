package site.mplace.jdbc.service;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.sql.DataSourceDefinition;
import lombok.AllArgsConstructor;
import site.mplace.jdbc.dao.MemberDao;
import site.mplace.jdbc.dao.PostDao;
import site.mplace.jdbc.dao.ReplyDao;

@AllArgsConstructor
@Service
public class MemberService {
  private MemberDao memberDao;
  private PostDao postDao;
  private ReplyDao replyDao;
  
  // // 옛날 방식  
  // private DataSourceTransactionManager manager;
  // private TransactionDefinition definition;
  
  // public void quitMember(String id){
  //   TransactionStatus status = manager.getTransaction(definition);
    
  //   try{
  //     replyDao.updateToWriterNull(id);
  //     postDao.updateToWriterNull(id);
  //     memberDao.delete(id);
  //     manager.commit(status);
  //   }catch(DataAccessException e){
  //     manager.rollback(status);
  //   }
    
  // }

  // 요즘 방식 -> class에도 사용가능하다. 트랜젝션 주고싶은곳에 다들어감
  @Transactional
  // 다른 설정 주고싶으면 이런식으로 바꿔라
  // @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
  public void quitMember(String id){
      replyDao.updateToWriterNull(id);
      postDao.updateToWriterNull(id);
      memberDao.delete(id);
  }

}
