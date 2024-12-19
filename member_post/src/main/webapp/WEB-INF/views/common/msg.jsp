<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>      

<script>
  alert('${msg}');
  let url = "${url}";
  
  // if(url.includes('url=')){
  //   const arr = url.split("?");
  //   url = arr[0] +"?"+ arr[1] +"?"+ encodeURIComponent(arr[2]);
  // }

  <c:choose>
    <c:when test="${not empty url}">
      location.href = url;
    </c:when>
    <c:otherwise>
      history.back();
    </c:otherwise>
  </c:choose>

</script>