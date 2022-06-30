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
						<p class="mv-title">退会手続き</p>

						<h2 id="message"
							style="color: red; text-align: center; padding: 10px 0; margin: 0;">${sessionScope.message}</h2>

						<form action="../views/member_confirm_delete.jsp" method="post">
							<table class="member-table">
								<tr>
									<th class="member-item">会員番号</th>
									<td class="member-body">${sessionScope.member_info.member_id}
										<input type="hidden" name="member_id"
										value="${sessionScope.member_info.member_id}">
									</td>
								</tr>
								<tr>
									<th class="member-item">名前</th>
									<td class="member-body">姓
										${sessionScope.member_info.last_name} <br>名
										${sessionScope.member_info.first_name}
									</td>
								</tr>
								<tr>
									<th class="member-item">性別</th>
									<td class="member-body"><c:if
											test="${sessionScope.member_info.sex == '1'}">男性</c:if> <c:if
											test="${sessionScope.member_info.sex == '2'}">女性</c:if></td>
								</tr>
								<tr>
									<th class="member-item">生年月日</th>
									<td class="member-body">${sessionScope.member_info.birth_year}年
										${sessionScope.member_info.birth_month}月
										${sessionScope.member_info.birth_day}日</td>
								</tr>
								<tr>
									<th class="member-item">電話番号</th>
									<td class="member-body">${sessionScope.member_info.phone_number}</td>
								</tr>
								<tr>
									<th class="member-item">メールアドレス</th>
									<td class="member-body">${sessionScope.member_info.mail_address}</td>
								</tr>
								<tr>
									<th class="member-item">郵便番号</th>
									<td class="member-body">${sessionScope.member_info.post_code}</td>
								</tr>
								<tr>
									<th class="member-item">住所</th>
									<td class="member-body">${sessionScope.member_info.address}</td>
								</tr>

							</table>
							<div class="member-submit">
								<input type="submit" value="退会確認">
							</div>
						</form>
					</div>
					<div class="home-link">
						<a href="../views/product_search.jsp">戻る</a>
					</div>
				</div>
				<% session.removeAttribute("message");%>

				<%@include file="footer.jsp"%>