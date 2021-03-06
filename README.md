# Food4Thought

## Project description 
Our application, a Recipe Generator, takes input
from the user in the form of any number of ingredients they have, what
cooking level they are at, and whether they require assistance from one
of the chefs in our database. The program then returns a time-dependent
meal which meets the users criteria along with a chef that is available
to assist them if they specified they require assistance.

## How to navigate the Food4Thought Back-End Project      

Here's a link to download the CSV files (meals, chefs and matches) and ERD diagram:
https://drive.google.com/drive/folders/11tlOq6IdTOSeiPLoZzu7z1W6SusLjkLj?usp=sharing

<br />

## Database commands with Postico

### Creating the recipe database: 
```  
CREATE DATABASE recipe\_generator;
```

### Creating the meals schema:

```
CREATE TABLE meals (

    id SERIAL PRIMARY KEY,

    name character varying(255) NOT NULL,

    allergy\_info character varying(255),

    difficulty character varying(255) NOT NULL,

    ingredients character varying(255) NOT NULL,

    steps text NOT NULL,

    meal\_time character varying(255) NOT NULL

);
```

### Creating the chefs schema:

```
CREATE TABLE chefs (

    id SERIAL PRIMARY KEY,

    name VARCHAR(255) NOT NULL, 

    email TEXT NOT NULL,

    location VARCHAR(255) NOT NULL,

    price DECIMAL(10,2) NOT NULL,

);
```

### Creating the matches schema (JOIN table):

```
CREATE TABLE matches (

    id SERIAL PRIMARY KEY,

    chefs\_id INT REFERENCES chefs(id),

    meals\_id INT REFERENCES meals(id)

);
```
<br />

## Postman Instructions

For basic requests users do not need to be logged in e.g. GET requestlocalhost:8080/user
```
{

    "mainIngredient": "chicken, milk",

    "difficulty": "BEGINNER",

    "wantHelp": true

}
```
<br />
<br />

We added a security feature so that only certain people can add, delete and update entries in our database. Click on the  'Authorisation' tab in the request section, then select 'Basic Auth' from the 'Type' dropdown.

The login details to be used are:
<br />

**Username**: foo  
**Password**: foo


## Request Examples with Authorisation

### Interacting with the meals schema
<br />

| URL                | Request Type  | Description                                                           |
| -------------      | ------------- | ---------------------                                                 |
| .../meals          | GET           | Gets all the meals from the meals schema                              |
| .../meals/{id}     | GET           | Gets a specific meal by ID                                            |
| .../meals          | POST          | Let's user with authentication post a meal to the meals schema        |
| .../meals/{id}     | DELETE        | Deletes a specific meal by ID                                         |
| .../meals/{id}     | UPDATE        | Updates a specific meal by ID with whateve is pass into request body  |

<br />

Note - Replace the '...' above with localhost:8080 

<br />

Example meal to POST:
```
{

    "name": "Eel Pie",

    "difficulty": "BEGINNER",

    "allergyInfo": \[

        "DAIRY"

    \],

    "ingredients": \[

        "Eel"

    \],

    "steps":
"https://www.inspiredtaste.net/23159/homemade-eel-pie-recipe/",

    "mealTime": "SNACK",

    "chefs": null

}
```
<br />


Example meal to Update (PUT):
```
{

    "name": "Eel Pie",

    "difficulty": "BEGINNER",

    "allergyInfo": \[

        "DAIRY"

    \],

    "ingredients": \[

        "Eel"

    \],

    "steps":
"https://www.inspiredtaste.net/23159/homemade-eel-pie-recipe/",

    "mealTime": "SNACK",

    "chefs": null

}
```
<br />
<br />

### Interacting with the chefs schema
<br />


| URL                | Request Type  | Description                                                             |
| -------------      | ------------- | ---------------------                                                   |
| .../chefs          | GET           | Gets all the chefs from the chefs schema                                |
| .../chefs/{id}     | GET           | Gets a specific chef by ID                                              |
| .../chefs          | POST          | Let's user with authentication post a chef to the chefs schema          |
| .../chefs/{id}     | DELETE        | Deletes a specific chef by ID                                           |
| .../chefs/{id}     | UPDATE        | Updates a specific chef by ID with whatever is passed into request body |

<br />

Note - Replace the '...' above with localhost:8080 

<br />

Example chef to POST:
```
{

    "name": "Eminem",

    "email": "momsspaghetti\@gmail.com",

    "location": "Hollywood",

    "price": 400.00

}
```
<br />


Example chef to Update (PUT):
```
{

    "name": "Sarah",

    "email": "Sarahjoegmail.com",

    "location": "London",

    "price": 430.00

}
```
<br />
<br />

## Contributors
[Will Burdett](https://github.com/WillBurdett)  
[Nayan Gurung](https://github.com/Nayan-grg)  
[Darshil Dholakia](https://github.com/DarshilDholakia)  
[Abdiqani Afrah](https://github.com/Abdiqaniafrah)  
[Shirhan Mohamed](https://github.com/shirhan25) 
