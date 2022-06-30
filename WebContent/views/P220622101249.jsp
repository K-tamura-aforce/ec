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
							<img src="../img/P220622101249.png" alt="">
						</div>

						<div class="item-info">
							<h1 class="item-title">季節工芸菓「貴船の流れ」</h1>
							<p>
							涼しげな貴船の水面を映しました<br>
							清流ともみじの名所、京の奥座敷「貴船」。<br>
							そのせせらぎの水面を見た目楽しく、おいしくお菓子に仕上げました。<br>
							琥珀羹に青紅葉を浮かべ、流れゆく清流を表現いたしました。<br>
							大納言あずきの香りと風味をお楽しみ下さい。<br>
							冷やしていただくと、より一層おいしくお召し上がりいただけます。<br>
								<br>
								■内容：210g<br>
								■日持ち：30日<br>
								■特定原材料：-
							</p>

							<p>1296円(税込み)</p>

							<a class="cart-btn"
								href="../jp.co.aforce.action/Cart_addAction?product_id=P220622101249">カートに追加</a>
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