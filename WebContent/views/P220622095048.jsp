<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>和菓子通販:甘味堂</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/ec-icon.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Shippori+Mincho+B1:wght@500&family=Yuji+Syuku&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/item-style.css">
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
					<a href="../jp.co.aforce.action/Product_searchAction">和菓子通販:甘味堂</a>
				</h1>
				<form class="search_container"
					action="../jp.co.aforce.action/Product_searchAction" method="post">
					<input id="sbox" type="text" name="keyword"
						value="${sessionScope.keyword}" size="25" placeholder="キーワードを入力">
					<input id="sbtn" type="submit" value="&#xf002">
				</form>
				<nav class="gnav">
					<ul class="gnav-list">
						<li class="gnav-item"><a href="member_update.jsp">会員情報変更</a></li>
						<li class="gnav-item"><a href="member_password_update.jsp">パスワード変更</a></li>
						<li class="gnav-item"><a href="logout.jsp">ログアウト</a></li>
						<li class="gnav-item"><a href="member_cart.jsp">カート</a></li>
						<li class="gnav-item"><a href="member_delete.jsp">退会</a></li>
					</ul>
				</nav>
			</div>
		</header>
		<!-- /header -->

		<main class="content">

				<div class="container">
					<div id="item" class="wrapper">
						<div class="item-image">
							<img src="../img/P220622095048.png" alt="">
						</div>

						<div class="item-info">
							<h1 class="item-title">あずきとうふ「京豆水」</h1>
							<p>
								甘味堂の看板商品です。<br>
								大豆ににがりを入れるとかたまりますが、小豆に<br>
								にがりを入れてもかたまりません。<br>
								ありえないもののたとえを「小豆のとうふ」などと申します。<br>
								しかし、その「ありえないもの」を職人の知恵と工夫で<br>
								形に致しましたのがこの「京豆水」でございます。<br>
								京菓子は水がいのち。<br>
								東山連峰から湧き出る天然の水と葛を使い、<br>
								ありえないはずの「小豆のとうふ」を作り上げました。<br>
								モチモチっとした食感で、あっさりと仕上げております。<br>
								ちょっと変わったお菓子の冷奴、どうぞ冷やしてお召し上がり下さい。<br>

								<br>
								■内容：400g<br>
								■日持ち：3日<br>
								■特定原材料：-
							</p>

							<p>972円(税込み)</p>

							<a class="cart-btn"
								href="../jp.co.aforce.action/Cart_addAction?product_id=P220622095048">カートに追加</a>
						</div>
					</div>
					<div class="home-link">
					<a href="product_search.jsp">商品一覧へ</a>
				</div>
				</div>


			<%
			session.removeAttribute("message");

			session.removeAttribute("keyword");
			%>

<%@include file="footer.jsp"%>