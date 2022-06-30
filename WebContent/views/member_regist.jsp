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
						<p class="mv-title">新規会員登録</p>

						<h2 id="message"
							style="color: red; text-align: center; padding: 10px 0; margin: 0;">${sessionScope.message}</h2>

						<form action="../Member_registAction" method="post">
							<table class="member-table">
								<th class="member-item">名前</th>
								<td class="member-body">姓<input type="text"
									name="last_name" class="form-text" maxlength="32"
									value="${sessionScope.member_info.last_name}" required>
									<br>名<input type="text" name="first_name"
									class="form-text" maxlength="32"
									value="${sessionScope.member_info.first_name}" required>
								</td>
								</tr>
								<tr>
									<th class="member-item">性別</th>
									<td class="member-body"><label class="member-sex">
											<input type="radio" name="sex" value="1"
											<c:if test="${sessionScope.member_info.sex == '1'}">checked</c:if>
											required><span class="member-sex-txt">男性 </span>
									</label> <label class="member-sex"> <input type="radio"
											name="sex" value="2"
											<c:if test="${sessionScope.member_info.sex == '2'}">checked</c:if>
											required> <span class="member-sex-txt">女性</span></label></td>
								</tr>
								<tr>
									<th class="member-item">生年月日</th>
									<td class="member-body"><select name="birth_year"
										class="form-select" required>
											<option value="" selected disabled></option>
											<c:forEach var="i" begin="1920" end="2020">
												<option value="${i}"
													<c:if test="${sessionScope.member_info.birth_year == i }">selected</c:if>>${i}</option>
											</c:forEach>
									</select>年 <select name="birth_month" class="form-select" required>
											<option value="" selected disabled></option>
											<c:forEach var="i" begin="1" end="12">
												<option value="${i}"
													<c:if test="${sessionScope.member_info.birth_month == i }">selected</c:if>>${i}</option>
											</c:forEach>
									</select> 月<select name="birth_day" class="form-select" required>
											<option value="" selected disabled></option>
											<c:forEach var="i" begin="1" end="31">
												<option value="${i}"
													<c:if test="${sessionScope.member_info.birth_day == i }">selected</c:if>>${i}</option>
											</c:forEach>
									</select>日</td>
								</tr>
								<tr>
									<th class="member-item">電話番号<br>※ハイフン(-)なしで入力
									</th>
									<td class="member-body"><input type="tel"
										name="phone_number" class="form-text" maxlength="32"
										value="${sessionScope.member_info.phone_number}"
										placeholder="例)0352162868" required></td>
								</tr>
								<tr>
									<th class="member-item">メールアドレス</th>
									<td class="member-body"><input type="email"
										name="mail_address" class="form-text" maxlength="100"
										value="${sessionScope.member_info.mail_address}" required></td>
								</tr>
								<tr>
									<th class="member-item">郵便番号<br>※ハイフン(-)なしで入力
									</th>
									<td class="member-body"><input type="text"
										name="post_code" class="form-text" maxlength="7"
										pattern="^[0-9]+$"
										value="${sessionScope.member_info.post_code}"
										placeholder="例)1020072" required></td>
								</tr>
								<tr>
									<th class="member-item">住所</th>
									<td class="member-body"><input type="text" name="address"
										class="form-text" maxlength="32"
										value="${sessionScope.member_info.address}"
										placeholder="例)東京都千代田区飯田橋4-8-13" required></td>
								</tr>
								<tr>
									<th class="member-item">パスワード<br>※半角英数字のみで入力
									</th>
									<td class="member-body"><input type="password"
										name="password" class="form-text" maxlength="100"
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
								<input type="submit" value="登録">
							</div>
						</form>
					</div>
					<div class="home-link">
						<a href="login.jsp">戻る</a>
					</div>
				</div>
			</div>

			<%
			session.removeAttribute("member_info");
			session.removeAttribute("message");
			%>
			<%@include file="footer.jsp"%>