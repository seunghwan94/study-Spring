package com.example.guestbook2.domain.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "dtoList")
public class PageResultDto<Dto, En> {
  private List<Dto> dtoList;
  
  private int totalPage;
  private int page, size;
  private int start, end;
  private boolean prev, next;

  private List<Integer> pageList;

  // map을 사용하기위해 function 사용 Entity -> Dto로 바꾸는 코드
  // ( ※ Page<Entity> => List<Dto>로 만들기위해 )
  public PageResultDto(Page<En> result, Function<En, Dto> fn){
    dtoList = result.stream().map(fn).toList();
    totalPage = result.getTotalPages();

    Pageable pageable = result.getPageable();
    page = pageable.getPageNumber() + 1;
    size = pageable.getPageSize();

    int tempEnd = (int)(Math.ceil(page / 10.0)) * 10;
    start = tempEnd - 9;
    prev = start > 1;

    end = totalPage > tempEnd ? tempEnd : totalPage;
    next = totalPage > tempEnd;

    pageList = IntStream.rangeClosed(start, end).boxed().toList();
  }


}
