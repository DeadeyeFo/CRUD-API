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
        <a href="animal-list.ftlh">Home</a>
        <a href="animal-details.ftlh">Details</a>
        <a href="about.html">About</a>
    </div>
    <!-- End Nav Bar -->

    <div class="container" style="margin-top: 15px;">
        <h1>${title}</h1>
        <form id="new-animal" action="/animals/update/${animal.animalId?c}" method="post">
            <input type="text" id="name" name="name" placeholder="Name"/>
            <input type="text" id="description" name="description" placeholder="Description"/>
            <button type="submit" class="btn btn-primary">Save</button>
           <a href="/animals/${animal.animalId?c}" class="btn btn-outline-danger" >Cancel</a>
        </form>
    
    </div>

</body>
</html>