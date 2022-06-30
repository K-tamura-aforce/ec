<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>和菓子通販:甘味堂</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/img/ec-icon.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Shippori+Mincho+B1:wght@500&family=Yuji+Syuku&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ress.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Material+Icons+Outlined"
	rel="stylesheet">
</head>
<body>

	<div class="wrapper">

		<!-- header -->
		<header class="header ">
			<div class="container">
				<h1 class="header-logo">
					<a href="../jp.co.aforce.action/Product_listAction">和菓子通販:甘味堂</a>
				</h1>
				<nav class="gnav">
					<ul class="gnav-list">
						<li class="gnav-item"><a href="product_regist.jsp">商品情報登録</a></li>
						<li class="gnav-item"><a href="product_update_search.jsp">商品情報変更</a></li>
						<li class="gnav-item"><a href="product_delete_search.jsp">商品情報削除</a></li>
						<li class="gnav-item"><a href="logout2.jsp">ログアウト</a></li>
					</ul>
				</nav>
			</div>
		</header>
		<!-- /header -->

		<main class="content">

			<!-- mv -->
			<div class="mv">
				<div class="mv-container">
					<p class="mv-title">ログアウトしますか？</p>
					<p class="mv-subtitle">
						<a href="../LogoutAction">ログアウト</a>
					</p>
				</div>
			</div>
			<div class="home-link">
				<a href="../jp.co.aforce.action/Product_listAction">戻る</a>
			</div>

			<%@include file="footer.jsp"%>