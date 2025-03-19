# Animals API
## Description
Simple CRUD API for Animal Objects
### Version
0.0.1

## Installation
- Get the project
    - clone  
        ```
      git clone https://github.com/DeadeyeFo/CRUD-API.git
        ``` 
    - OR download zip.
- Open the project in your IDE (I used VSCode).
- This project is built to run with jdk 21.
- [`/src/main/resources/application.properties`](https://github.com/DeadeyeFo/CRUD-API/blob/main/src/main/resources/application.properties) file  is the configuration for the MySQL database on your localhost.
  - the database name is on the `datasource.url` property between the last `/` and the `?`. In this case the database name is `animal-database`.
  - You MUST have the database up and running before running the project! 
    - Start your AMPPS Server.
    - Click on the Home icon to open the localhost server on your browser.
    - Go to Database Tools and open phpMyAdmin to start up the MySQL Dashboard.
    - Ensure the database that you need is available. Either
      - Create a database called `animal-database`
      - OR edit `datasource.url` to point to a database that you do have.
  - Verify your username and password is spelled correctly in the properties file.
- Build and run the main class. You should see a new table created in the aforementioned database.
## Notes
### AnimalX Java classes have different purposes: Separation of concerns!
- [Entity](https://github.com/DeadeyeFo/CRUD-API/blob/main/src/main/java/com/Individual_Assignment/__CRUD_API/Animals/Animal.java)
  - The Animal class is annotated as an `@Entity `. This is used by Hibernate (an implementation of the Jakarta Persistence API) to map class attributes to database tables and SQL types.
  - We also annotated with `@Table` to give Hibernate directions to use this specific table name. This is optional but it helps with naming conventions.
  - Any Entity must have at least one attribute that is annotated as an `@Id`. In our case it's conveniently the `animalId` attribute.
    - We are also using an autogeneration strategy for the ID. This way we are not manually assigning IDs to our animals. This is optional.
  - An Entity must have a no-argument constructor.
- [Repository]([https://github.com/uncg-csc340/sp25-crud-api-jpa/blob/35cd43dd1a489a7f69dcee6f1d62b9e77a37b032/src/main/java/com/csc340/sp25_crud_api_demo/animal/animalRepository.java#L12](https://github.com/DeadeyeFo/CRUD-API/blob/main/src/main/java/com/Individual_Assignment/__CRUD_API/Animals/AnimalRepository.java))
  - We are using an extension of the JPA Repository that comes with prebuilt database operations such as select all, select by id, select by any other reference, insert, delete, etc.
  - Annotate it as a `@Repository`.
  - We parametrize this using our object and its ID type.
    - `public interface animalRepository extends JpaRepository<animal, Integer>` => We want to apply the JPA repository operations on the `animal` type. The `animal` has an ID of type `int`.
- [Service]([https://github.com/uncg-csc340/sp25-crud-api-jpa/blob/7e8bf9e535b98dd33508db2277ea864c9a4f66b4/src/main/java/com/csc340/sp25_crud_api_demo/animal/animalService.java#L13](https://github.com/DeadeyeFo/CRUD-API/blob/main/src/main/java/com/Individual_Assignment/__CRUD_API/Animals/AnimalService.java))
  - Annotated as a `@Service`.
  - It is the go-between from controller to database. In here we define what functions we need from the repository. A lot of the functions are default functions that our repository inherits from JPA (save, delete, findAll, findByX), some of them are custom made (getHonorsanimals, getanimalsByName).
  - It asks the repository to perform SQL queries. 
- [Rest Controller](https://github.com/DeadeyeFo/CRUD-API/blob/main/src/main/java/com/Individual_Assignment/__CRUD_API/Animals/AnimalController.java)
  - Annotated as a `@RestController`.
  - All the API endpoints mapped inside this controller will start with `/animals`.
  - Return a Response Object.
  - It asks the Service class to perform data access functions.
## API Endpoints
Base URL: [`http://localhost:8080/animals`](http://localhost:8080/animals)


### [`/all`](http://localhost:8080/animals/all) (GET)
Gets a list of all Animals in the database.

#### Response - A JSON array of animal objects.

 ```
[
  {
    "animalId": 888,
    "name": "Axolotl",
    "description": "The axolotl is a unique amphibian native to Mexico, known for its ability to regenerate limbs. Unlike most salamanders, it remains aquatic throughout its life. With feathery external gills and a perpetual smile, this critter thrives in freshwater lakes and is critically endangered."
  },
  {
    "animalId": 889,
    "name": "Quokka",
    "description": "The quokka is a small, herbivorous marsupial native to Australia, often called \"the world's happiest animal\" due to its friendly, smiling expression. It thrives on Rottnest Island, is nocturnal, and can survive long periods without water by storing fat in its tail.."
  }
]
```

### [`/{animalId}`](http://localhost:8080/animals/888) (GET)
Gets an individual animal in the system. Each animal is identified by a numeric `animalId`

#### Parameters
- Path Variable: `animalId` &lt;integer&gt; - REQUIRED

#### Response - A single animal

```
[
  {
    "animalId": 888,
    "name": "Axolotl",
    "description": "The axolotl is a unique amphibian native to Mexico, known for its ability to regenerate limbs. Unlike most salamanders, it remains aquatic throughout its life. With feathery external gills and a perpetual smile, this critter thrives in freshwater lakes and is critically endangered."
  }
]
```

### [`/name`](http://localhost:8080/animals/name?search=ob) (GET)
Gets a specific animal by its name that contains the given string.

#### Parameters
- query parameter: `search` lt;String&gt; - REQUIRED

#### Response - A JSON array of animal object.

```
[
  {
    "animalId": 889,
    "name": "Quokka",
    "description": "The quokka is a small, herbivorous marsupial native to Australia, often called \"the world's happiest animal\" due to its friendly, smiling expression. It thrives on Rottnest Island, is nocturnal, and can survive long periods without water by storing fat in its tail.."
  }
]
```


### [`/new`](http://localhost:8080/animals/new) (POST)
Create  a new animal entry
 
#### Request Body
A animal object. Note that the animalId is auto assigned in the database so is not needed in the request.
```
  {
    "name": "Jaguar",
    "description": "The jaguar is a powerful big cat native to the Americas, known for its rosette-patterned coat and immense bite force, capable of crushing bones and turtle shells. A stealthy apex predator, it thrives in rainforests and wetlands, often hunting by ambush and swimming expertly."
  }
```
#### Response - The updated list of animals.

```
[
  {
    "animalId": 888,
    "name": "Axolotl",
    "description": "The axolotl is a unique amphibian native to Mexico, known for its ability to regenerate limbs. Unlike most salamanders, it remains aquatic throughout its life. With feathery external gills and a perpetual smile, this critter thrives in freshwater lakes and is critically endangered."
  },
  {
    "animalId": 889,
    "name": "Quokka",
    "description": "The quokka is a small, herbivorous marsupial native to Australia, often called \"the world's happiest animal\" due to its friendly, smiling expression. It thrives on Rottnest Island, is nocturnal, and can survive long periods without water by storing fat in its tail.."
  },
  {
    "animalId": 890,
    "name": "Jaguar",
    "description": "The jaguar is a powerful big cat native to the Americas, known for its rosette-patterned coat and immense bite force, capable of crushing bones and turtle shells. A stealthy apex predator, it thrives in rainforests and wetlands, often hunting by ambush and swimming expertly."
  }
]
```

### [`/update/{animalId}`](http://localhost:8080/animals/update/890) (PUT)
Update an existing animal.

#### Parameters
- Path Variable: `animalId` &lt;integer&gt; - REQUIRED

#### Request Body
A animal object with the updates.
```
  {
    "animalId": 890,
    "name": "Jaguar",
    "description": "jaguar is a powerful big cat native to the Americas, known for its rosette-patterned coat and immense bite force, capable of crushing bones and turtle shells. A stealthy apex predator, it thrives in rainforests and wetlands, often hunting by ambush and swimming expertly."
  }
```
#### Response - the updated animal object.
```
  {
    "animalId": 890,
    "name": "Jaguar",
    "description": "jaguar is a powerful big cat native to the Americas, known for its rosette-patterned coat and immense bite force, capable of crushing bones and turtle shells. A stealthy apex predator, it thrives in rainforests and wetlands, often hunting by ambush and swimming expertly."
  }
```

### [`/delete/{animalId}`](http://localhost:8080/animals/delete/1) (DELETE)
Delete an existing animal.

#### Parameters
- Path Variable: `animalId` &lt;integer&gt; - REQUIRED

#### Response - the updated list of animals.
```
[
  {
    "animalId": 888,
    "name": "Axolotl",
    "description": "The axolotl is a unique amphibian native to Mexico, known for its ability to regenerate limbs. Unlike most salamanders, it remains aquatic throughout its life. With feathery external gills and a perpetual smile, this critter thrives in freshwater lakes and is critically endangered."
  },
  {
    "animalId": 889,
    "name": "Quokka",
    "description": "The quokka is a small, herbivorous marsupial native to Australia, often called \"the world's happiest animal\" due to its friendly, smiling expression. It thrives on Rottnest Island, is nocturnal, and can survive long periods without water by storing fat in its tail.."
  }
]
```
