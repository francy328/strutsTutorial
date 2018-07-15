<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html>
<head>
<title>Inserisci il nome</title>
<html:base />
</head>

<body>
	Ciao, inserisci il tuo nome.
	<br />
	<br />

	<html:form action="/esempio">
		 Nome: <html:text property="nome" />
		<html:submit title="Invia" />
	</html:form>

</body>
</html:html>