<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Gestion Cinéma</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script type="text/javascript" src="js/script.js"></script>
</head>
</head>

<body onload="loadSceance('${pageContext.request.contextPath}')">
<div class="header">
 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 	<div class="navbar-header">
      <a class="navbar-brand" href="#">Gestion Cinéma</a>
	</div>
	<div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item"><a class="nav-link " href="index.html">Accueil</a></li>
      <li class="nav-item"><a class="nav-link active" href="SceanceServlet">Liste des sceance</a></li>
      <li class="nav-item"><a class="nav-link" href="ASceance.html">Ajout Scéance</a></li>
    </ul>
  </div>
</nav>
	<div class="container-fluid mt-3">
		<input id="sceance" class="form-control" placeholder="sceance" />
		<button class="btn btn-success" onclick="cherche()">
			<i class="fas fa-search"></i>
		</button>
	</div> 
</div>
	
	<div id="divDisplaySceance"></div>

	<template id="templateDisplaySceance">
		<br />
		<div class="row">
			<div class="col-2">
				<h3 id="diffusionDate"></h3>
			</div>
			<div class="col-6">
				<h3 id="movieName"></h3>
			</div>
			<div class="col-4">
				<button class="btn btn-success" onclick="">
					<em class="fa fa-plus"></em>
				</button>
			</div>
		</div>
		<div class="row">
			<div class="col-8">
				<div class="row">
					<div class="col-8">
						<h5 id="movieDescription"></h5>
					</div>
					<div class="col-4">
						<img id="moviePoster" alt="Image containing movie poster"
							width="120" />
					</div>
				</div>
			</div>
		</div>
	</template>
</body>

</html>