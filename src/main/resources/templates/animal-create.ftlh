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

    <div class="container" style="margin: 50px auto; max-width: 600px; border: 2px solid #4e1919be; border-radius: 10px; padding: 30px; background-color: #fff;">
        <h1>${title}</h1>
        <form id="new-animal" action="/animals/add" method="post">
            <input type="text" id="name" name="name" placeholder="Name" 
                   style="width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;"/>
            <input type="text" id="description" name="description" placeholder="Description" 
                   style="width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;"/>
            <button type="submit" class="animal-button" style="margin-right: 10px;">Save</button>
            <a href="/animals/all" class="animal-button" style="background-color: #d9534f;">Cancel</a>
        </form>
    </div>


</body>
</html>