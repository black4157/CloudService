<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
		<!-- Blueprint header -->
		<header class="bp-header cf">
			<div class="dummy-logo">
				<div class="dummy-icon foodicon foodicon--coconut"></div>
				<h2 class="dummy-heading">Fooganic</h2>
			</div>
			<div class="bp-header__main">

				<h1 class="bp-header__title">cloud</h1>
				<nav class="bp-nav">
					<a class="bp-nav__item bp-icon bp-icon--prev" href="/"
						data-info="previous Blueprint"><span>Previous Blueprint</span></a>
					<!--a class="bp-nav__item bp-icon bp-icon--next" href="" data-info="next Blueprint"><span>Next Blueprint</span></a-->
				</nav>
			</div>
		</header>
		<button class="action action--open" aria-label="Open Menu">
			<span class="icon icon--menu"></span>
		</button>
		<nav id="ml-menu" class="menu">
			<button class="action action--close" aria-label="Close Menu">
				<span class="icon icon--cross"></span>
			</button>
			<div class="menu__wrap">
			<a href="/logout">로그아웃 하기</a><p>
	<a href="/board/boardList">공지사항 보기</a><p>
	<a href="/send">전송하기</a><p>
	<a href="/upload">파일 올리기</a><p>
			</div>
		</nav>
		<div class="content">