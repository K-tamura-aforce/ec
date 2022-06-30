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
							<img src="../img/P220622101054.png" alt="">
						</div>

						<div class="item-info">
							<h1 class="item-title">京羊羹「天の川」</h1>
							<p>
							七夕の世界を夏菓子に映し<br>
							夜空を映した濃い青の琥珀羹に銀箔の星を散りばめ、<br>
							揺らめく星屑をイメージした七夕の世界を描きました。<br>
							琥珀羹の下は味甚羹、小倉羹の二層になっており、<br>
							あっさりとした夏らしい味わいでございます。<br>
							冷たくしてお召し上がり下さい。<br>
							※期間・数量限定商品でございます。<br>
								<br>
								■内容：1本（200g）<br>
								■日持ち：25日<br>
								■特定原材料：-
							</p>

							<p>1296円(税込み)</p>

							<a class="cart-btn"
								href="../jp.co.aforce.action/Cart_addAction?product_id=P220622101054">カートに追加</a>
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