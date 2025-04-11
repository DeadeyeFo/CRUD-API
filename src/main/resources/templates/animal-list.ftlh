<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
</head>

<body>
    <header class="header">
        <h1>Animal Sanctuary</h1>
    </header>

    <!-- Begin Nav Bar -->
    <div class="topnav">
        <a href="/animals/all">Home</a>
    </div>
    <!-- End Nav Bar -->

    <header class="animal-container">
        <h1>${title}</h1>
    </header>

    <div style="display: flex; justify-content: flex-end; margin: 20px 40px 10px 0;">
        <a href="/animals/createForm" class="animal-button">Add Animal</a>
    </div>

    <form class="animal-container" action="/animals/name">
            <input type="text" name="search" placeholder="Search for an animal by name &#128270;">
    </form>
    
    <div class="animal-container">
        <#list animalList as animal> <!-- FreeMarker loop that iterates over the list of animals -->
        <div class="animal-row">
            <img class="animal-img" src="" alt="${animal.name!}">
            <div class="${animal.description!}"> <!-- Use the animal's class to set the class of the description div -->
                <h2>${animal.name!}</h2> <!-- Display the animal's name from animal object -->
                <p>${animal.description!}</p> <!-- Display the animal's description from the animal object-->
                <p2>Animal ID: <a href="/animals/${animal.animalId?c}" method="get">${animal.animalId!}</a></p2>
            </div>
        </div>
      </#list>
    </div>

</body>
</html>
