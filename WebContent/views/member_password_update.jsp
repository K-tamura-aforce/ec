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
	href="<%=request.getContextPath()%>/css/member_info-style.css">
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

			<div class="member">

				<!-- mv -->
				<div class="mv">
					<div class="mv-container">
						<p class="mv-title">パスワード変更</p>

						<h2 id="message"
							style="color: red; text-align: center; padding: 10px 0; margin: 0;">${sessionScope.message}</h2>

						<form action="../Member_password_updateAction" method="post">
							<table class="member-table">
								<tr>
									<th class="member-item">会員番号</th>
									<td class="member-body">${sessionScope.member_info.member_id}
										<input type="hidden" name="member_id"
										value="${sessionScope.member_info.member_id}"> <input
										type="hidden" name="last_name"
										value="${sessionScope.member_info.last_name}"> <input
										type="hidden" name="first_name"
										value="${sessionScope.member_info.first_name}"> <input
										type="hidden" name="sex"
										value="${sessionScope.member_info.sex}"> <input
										type="hidden" name="birth_year"
										value="${sessionScope.member_info.birth_year}"> <input
										type="hidden" name="birth_month"
										value="${sessionScope.member_info.birth_month}"> <input
										type="hidden" name="birth_day"
										value="${sessionScope.member_info.birth_day}"> <input
										type="hidden" name="phone_number"
										value="${sessionScope.member_info.phone_number}"> <input
										type="hidden" name="mail_address"
										value="${sessionScope.member_info.mail_address}"> <input
										type="hidden" name="post_code"
										value="${sessionScope.member_info.post_code}"> <input
										type="hidden" name="address"
										value="${sessionScope.member_info.address}">
									</td>
								<tr>
									<th class="member-item">現在のパスワード<br>※半角英数字のみで入力
									</th>
									<td class="member-body"><input type="password"
										name="password" class="form-text" maxlength="100"
										pattern="^[a-zA-Z0-9]+$" required></td>
								</tr>
								<tr>
									<th class="member-item">新しいパスワード<br>※半角英数字のみで入力
									</th>
									<td class="member-body"><input type="password"
										name="new_password" class="form-text" maxlength="100"
										pattern="^[a-zA-Z0-9]+$" required></td>
								</tr>
								<tr>
									<th class="member-item">確認パスワード<br>※半角英数字のみで入力
									</th>
									<td class="member-body"><input type="password"
										name="confirm_password" class="form-text" maxlength="100"
										pattern="^[a-zA-Z0-9]+$" required></td>
								</tr>

							</table>
							<div class="member-submit">
								<input type="submit" value="変更">
							</div>
						</form>
					</div>
					<div class="home-link">
						<a href="../views/product_search.jsp">戻る</a>
					</div>
				</div>
			</div>

			<%
			session.removeAttribute("message");
			%>

<%@include file="footer.jsp"%>