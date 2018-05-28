<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta charset="UTF-8">
		<title>Page d'upload</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
		
	</head>
	<body>
		<form action="<c:url value="/upload" />" enctype="multipart/form-data" method="post">
			<fieldset>
				<legend>Envoi de fichier</legend>

				<label for="description">Description du fichier</label>
				<input type="text" id="description" name="description" value="<c:out value="${fichier.description}" />">
				<span class="erreur"><c:out value="${ form.erreurs['description'] }" /></span>
				<br>
				
				<label for="fichier">Emplacement du fichier <span class="requis">*</span></label>
				<input type="file" id="fichier" name="fichier" value="<c:out value="${ fichier.nom }" />">
				<span class="erreur"><c:out value="${ form.erreurs['fichier'] }" /></span>
				<br>
				
				<input type="submit" value="Envoyer" class="sansLabel" >
				<br>
							
				<p class="${empty erreurs ? 'success' : 'erreur' }">${form.resultat}</p>
			</fieldset>
		</form>
	</body>
</html>