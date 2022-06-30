<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>和菓子通販:甘味堂</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/ec-icon.png" />
<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/ec-icon.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Shippori+Mincho+B1:wght@500&family=Yuji+Syuku&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/purchase-style.css">
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
						<li class="gnav-item"><a href="../views/member_update.jsp">会員情報変更</a></li>
						<li class="gnav-item"><a
							href="../views/member_password_update.jsp">パスワード変更</a></li>
						<li class="gnav-item"><a href="../views/logout.jsp">ログアウト</a></li>
						<li class="gnav-item"><a href="../views/member_cart.jsp">カート</a></li>
						<li class="gnav-item"><a href="../views/member_delete.jsp">退会</a></li>
					</ul>
				</nav>
			</div>
		</header>
		<!-- /header -->

		<main class="content">

			<!-- mv -->
			<div class="mv">
				<div class="mv-container">
					<p class="mv-title">カート内容</p>
					<c:choose>
						<c:when test="${cart.size()>0}">
							<p class="mv-subtitle">${cart.size()}種類の商品があります。</p>
							<hr>
						</c:when>
						<c:otherwise>
							<p class="mv-subtitle">カートに商品がありません。</p>
						</c:otherwise>
					</c:choose>

					<c:set var="total" value="${0}" />

					<table class="cart">
						<tr>
							<th>商品写真</th>
							<th>商品名</th>
							<th>価格</th>
							<th>個数</th>
							<th>小計</th>
						</tr>
						<c:forEach var="item" items="${cart}">
							<c:set var="total" value="${total + item.product_subtotal}" />
							<input type="hidden" name="product_id"
								value="${item.product_info.product_id}">
							<tr>
								<td class="cart-img"><img
									src="../img/${item.product_info.product_id}.png" height="96"></td>
								<td>${item.product_info.product_name}</td>
								<td>${item.product_info.product_price}円</td>
								<td>${item.product_count}個</td>
								<td>${item.product_subtotal}円</td>
						</c:forEach>
						<tr>
							<td colspan="4" align="center" class="total"><strong>合計(税込み)</strong></td>
							<td>${total}円</td>
						</tr>
					</table>
					<hr>

					<p class="mv-title">宛先</p>

					<h2 id="message"
						style="color: red; text-align: center; padding: 10px 0; margin: 0;">${sessionScope.message}</h2>

					<p class="mv-subtitle">宛先を変更される場合は、入力内容を変更してください。</p>

					<form action="../Purchase_confirmAction" method="post">
						<table class="member-table">
							<tr>
								<th class="member-item">宛名</th>
								<td class="member-body"><input type="text"
									name="purchase_name" class="form-text" maxlength="32"
									value="${sessionScope.member_info.last_name}${sessionScope.member_info.first_name}"
									required></td>
							</tr>
							<tr>
								<th class="member-item">郵便番号<br>※ハイフン(-)なしで入力
								</th>
								<td class="member-body"><input type="text" name="purchase_post_code"
									class="form-text" maxlength="7" pattern="^[0-9]+$"
									value="${sessionScope.member_info.post_code}"
									placeholder="例)1020072" required></td>
							</tr>
							<tr>
								<th class="member-item">住所</th>
								<td class="member-body"><input type="text" name="purchase_address"
									class="form-text" maxlength="32"
									value="${sessionScope.member_info.address}"
									placeholder="例)東京都千代田区飯田橋4-8-13" required></td>
							</tr>
							<tr>
								<th class="member-item">支払方法</th>
								<td class="member-body"><label class="member-sex">
										<input type="radio" name="payment_method" value="100" required><span
										class="member-sex-txt">クレジットカード払い </span>
								</label> <label class="member-sex"> <input type="radio"
										name="payment_method" value="200" required><span
										class="member-sex-txt">コンビニ払い</span></label> <label class="member-sex">
										<input type="radio" name="payment_method" value="300" required><span
										class="member-sex-txt">代引き払い</span>
								</label></td>
							</tr>

						</table>
						<div class="member-submit">
							<input type="submit" value="購入内容を確認する">
						</div>
					</form>
				</div>
				<div class="home-link">
					<a href="../views/member_cart.jsp">戻る</a>
				</div>
			</div>



			<%
			session.removeAttribute("message");
			%>

<%@include file="footer.jsp"%>