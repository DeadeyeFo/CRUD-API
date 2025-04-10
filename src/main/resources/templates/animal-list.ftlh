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
        <a href="index.html">Home</a>
        <a href="details.html">Details</a>
        <a href="about.html">About</a>
    </div>
    <!-- End Nav Bar -->

    <header class="animal-container">
        <h1>${title}</h1>
    </header>


    <form class="animal-container" action="/animals/name">
            <input type="text" name="search" placeholder="Search for an animal by name &#128270;">
    </form>

    <a href="/animals/createForm" class="animal-button" style="float: right;">Add Animal</a> <!-- Link to add animal page -->
    
    <div class="animal-container">
        <#list animalList as animal> <!-- FreeMarker loop that iterates over the list of animals -->
        <div class="animal-row">
            <img class="animal-img" src="" alt="${animal.name!}">
            <div class="${animal.description!}"> <!-- Use the animal's class to set the class of the description div -->
                <h2>${animal.name!}</h2> <!-- Display the animal's name from animal object -->
                <p>${animal.description!}</p> <!-- Display the animal's description from the animal object-->
            </div>
        </div>
      </#list>
    </div>

</body>
</html>
