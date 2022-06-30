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
	href="<%=request.getContextPath()%>/css/product-style.css">
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
					<p class="mv-title">商品一覧</p>
					<table class="list">
						<tr>
							<th>商品ID</th>
							<th>商品写真</th>
							<th>商品名</th>
							<th>ジャンル</th>
							<th>価格</th>
						</tr>
						<c:forEach var="product_info" items="${list}">
							<tr>
								<td>${product_info.product_id}</td>
								<td><img src="../img/${product_info.product_id}.png"></td>
								<td>${product_info.product_name}</td>
								<td><c:if test="${product_info.product_genre == 10 }">生菓子・半生菓子</c:if>
									<c:if test="${product_info.product_genre == 20 }">暦の上生菓子</c:if>
									<c:if test="${product_info.product_genre == 30 }">羊羹</c:if> <c:if
										test="${product_info.product_genre == 40 }">煎餅</c:if> <c:if
										test="${product_info.product_genre == 50 }">干菓子/琥珀糖</c:if> <c:if
										test="${product_info.product_genre == 60 }">焼菓子(お饅頭)</c:if></td>
								<td>${product_info.product_price}円</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<%
			session.removeAttribute("list");
			session.removeAttribute("message");
			%>

			<!-- contact -->
			<section class="contact section" id="contact">
				<div class="container">
					<h2 class="title">CONTACT</h2>
					<p class="lead">
						お問い合わせは、<br class="sp-only">メールにてお願いいたします。
					</p>
					<div class="contact-list">
						<span class="contact-item">kannmidou@gmail.com</span>
					</div>
				</div>
			</section>
			<!-- /contact -->
			<div class="page-top" id="js-page-top">
				<span class="material-icons-outlined">expand_less</span>
			</div>
		</main>

		<!-- footer -->
		<footer class="footer">
			<div class="copyright">&copy;和菓子通販:甘味堂</div>
		</footer>
		<!-- /footer -->

	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/script.js"></script>

</body>
</html>
