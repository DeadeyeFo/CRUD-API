<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title} - Animal Details</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<header class="header">
    <h1>Animal Sanctuary</h1>
</header>

<nav class="topnav">
    <a href="/animals/all">Home</a>
    <a href="/animals/createForm">Create an Animal</a>
</nav>

<div class="card-body" style="margin: 25px; 
                             border: 3px solid #4e1919be; 
                             border-radius: 25px; 
                             padding: 30px;">
    <h1>${title}</h1>
    <div class="card" style="border: 2px solid #4e1919be; border-radius: 8px;">
        <h3 class="card-header" style="padding: 30px;">${animal.name}</h5>

        <div class="card-body" style="padding: 30px">
            <span style="float:right">
                <a href="/animals/update/${animal.animalId}" class="animal-button" style="padding: 10px">Edit Animal</a>
            </span>
            <h5 class="card-title">ID: ${animal.animalId}</h5>
            <p class="card-text">Name: ${animal.name}</p>
            <p class="card-text">Description: ${animal.description}</p>

            <a href="/animals/delete/${animal.animalId}" class="animal-button" style="padding: 10px">Delete Animal</a>
            <a href="/animals/all" class="animal-button" style="padding: 10px">Go Back</a>
        </div>
    </div>
</div>

</body>
</html>
