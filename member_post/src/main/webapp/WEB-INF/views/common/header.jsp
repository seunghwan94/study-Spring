<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="container-fluid bg-secondary pb-3">
  <div class="container clearfix p-2">
    <!-- <a href="index.html" class="float-start"><img src="https://placehold.co/240x80?text=Mago" alt="Logo"></a> -->
    <a href="${cp}index" class="float-start"><img class="logo-img" src="https://i.namu.wiki/i/gq8rUiVxHzCh5G-6Ca7Y8jf_TrVX4N7Wd0-Zv9q0FHitA3u3prbxWGXFjFCw5lkHzKGaHDP0GCuTIp25p9TsvQ.webp" alt="Logo"></a>
    <h1 class="float-end fw-bold p-3 text-center">Mago UI Practice</h1>
  </div>
</header>
 <nav class="navbar navbar-expand-sm bg-dark border-secondary border-bottom">
   <ul class="navbar-nav container justify-content-start">
     <li class="nav-item"><a class="nav-link text-white mx-3" href="${cp}index">Home</a></li>
     <li class="nav-item"><a class="nav-link text-white mx-3" href="${cp}mypage">MyPage</a></li>
     <li class="nav-item"><a class="nav-link text-white mx-3" href="${cp}post/list?category=1">공지사항</a></li>
     <li class="nav-item dropdown">
       <a class="nav-link dropdown-toggle text-white mx-3" data-bs-toggle="dropdown" role="button">게시판</a>
       <div class="dropdown-menu">
         <a class="dropdown-item" href="${cp}post/list?category=2">자유게시판</a>
         <a class="dropdown-item" href="${cp}post/list?category=3">자료실</a>
         <a class="dropdown-item" href="gallery.html">갤러리</a>
       </div>
     </li>
   </ul>
 </nav>