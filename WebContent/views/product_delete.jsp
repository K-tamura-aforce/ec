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

			<div class="member">
				<!-- mv -->
				<div class="mv">
					<div class="mv-container">
						<p class="mv-title">商品情報削除</p>

						<h2 id="message"
							style="color: red; text-align: center; padding: 10px 0; margin: 0;">${sessionScope.message}</h2>

						<form action="../Product_deleteAction" method="post">

							<table class="member-table">
								<tr>
									<th class="member-item">商品ID</th>
									<td class="member-body">${sessionScope.product_info.product_id}
										<input type="hidden" name="product_id"
										value="${sessionScope.product_info.product_id}">
									</td>
								</tr>
								<tr>
									<th class="member-item">商品名</th>
									<td class="member-body">${sessionScope.product_info.product_name}
									</td>
								</tr>
								<tr>
									<th class="member-item">ジャンル</th>
									<td class="member-body"><c:if
											test="${sessionScope.product_info.product_genre == 10 }">生菓子・半生菓子</c:if>
										<c:if test="${sessionScope.product_info.product_genre == 20 }">暦の上生菓子</c:if>
										<c:if test="${sessionScope.product_info.product_genre == 30 }">羊羹</c:if>
										<c:if test="${sessionScope.product_info.product_genre == 40 }">煎餅</c:if>
										<c:if test="${sessionScope.product_info.product_genre == 50 }">干菓子／琥珀糖</c:if>
										<c:if test="${sessionScope.product_info.product_genre == 60 }">焼菓子（お饅頭）</c:if>
									</td>
								</tr>
								<tr>
									<th class="member-item">価格</th>
									<td class="member-body">${sessionScope.product_info.product_price}円
									</td>
								</tr>
							</table>
							<div class="member-submit">
								<input type="submit" value="削除">
							</div>
						</form>
					</div>
					<div class="home-link">
						<a href="product_delete_search.jsp">戻る</a>
					</div>
				</div>
			</div>

			<%
			session.removeAttribute("product_info");
			session.removeAttribute("message");
			%>

			<%@include file="footer.jsp"%>