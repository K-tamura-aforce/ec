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
	href="<%=request.getContextPath()%>/css/product-style2.css">
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
					<a href="login.jsp">和菓子通販:甘味堂</a>
				</h1>
			</div>
		</header>
		<!-- /header -->

		<main class="content">

			<div class="member">
				<!-- mv -->
				<div class="mv">
					<div class="mv-container">
						<p class="mv-title">ログイン</p>
						<h2 id="message"
							style="color: red; text-align: center; padding: 10px 0; margin: 0;">${sessionScope.message}</h2>
						<h2 id="message"
							style="color: red; text-align: center; padding: 10px 0; margin: 0;">${sessionScope.message2}</h2>
						<form action="../LoginAction" method="post">
							<table class="member-table">
								<tr>
									<th class="member-item">ID</th>
									<td class="member-body"><input type="text"
										name="member_id" class="form-text"
										value="${sessionScope.member_id}" required></td>
								</tr>
								<tr>
									<th class="member-item">パスワード<br>※半角英数字のみで入力
									</th>
									<td class="member-body"><input type="password"
										name="password" class="form-text" maxlength="100"
										pattern="^[a-zA-Z0-9]+$" required></td>
								</tr>
							</table>
							<div class="member-submit">
								<input type="submit" value="ログイン">
							</div>
						</form>
					</div>
					<div class="home-link">
						<a href="member_regist.jsp">新規会員登録はこちら</a>
					</div>
				</div>
			</div>

			<%
			session.removeAttribute("member_id");
			session.removeAttribute("message");
			session.removeAttribute("message2");
			%>

			<%@include file="footer.jsp"%>