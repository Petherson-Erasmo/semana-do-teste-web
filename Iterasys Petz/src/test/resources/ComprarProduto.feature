#language: pt
Funcionalidade: Comprar Produto
		# Dado que acesso o site da da Petz
		# Quando seleciono um produto e add no carrinho
		# Ent�o eu finalizo a compra
		
		Cenario: Compra a partir de uma busca
		Dado que acesso o site da Petz
		Quando busco por "coleira" e pressiono Enter
		Entao exibe uma lista de produtos relacionados com "coleira"
		Quando escolho "Coleira Petz Azul para Cães"
		Entao exibe para o "Tamanho P" o preco de "R$ 39,99"
		
		