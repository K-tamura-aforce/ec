/**
 * カート用JavaScriptファイル
 */
'use strict';

window.onload = onLoad;

const selects = document.querySelectorAll('.select');

selects.forEach(function onLoad() {

	// 選択した商品の名前
	const productName = this.dataset.product;
	// 選択した個数
	const count = this.selectedIndex;
	// 選択した商品の単価
	const productPrice = document.getElementById(productName + 'Price').textContent;
	// 選択した商品の小計を計算
	const subtotal = Math.floor(productPrice * count);

	// 小計に表示
	document.getElementById(productName + 'Subtotal').textContent = subtotal;

	// 合計を表示
	const subtotals = document.getElementsByClassName('subtotal');
	let total = 0;
	for (let item of subtotals) {
		total += parseInt(item.textContent);
	}
	document.getElementById('total').textContent = total;

});
