<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Pagina de cadastro de itens! Cada item possui uma chave e um valor compartilhados.</h1>
	<table>
		<tr>
			<td>
				<form action="PDFGeneratorServlet" method="POST">
					<input type="text" name="chave" id="chave"/>
					<input type="text" name="valor" id="valor"/>
					<input type="submit" value="Adicionar Item"/>
				</form>
			</td>
			<td>		
				<form action="PDFGeneratorServlet" method="GET">
					<input type="submit" value="Gerar PDF"/>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>