Welcome to the Theme microservice tutorial!
==============================


Hey! We are the team **Ideiglenes_nev** . This is the guide to one of our microservices, called **Theme**.

----------


Documentation
-------------

The main purpose of this microservice was, that connected to the  **CodeCool Shop**, or any other in particular, it provides background and formatting to create a cozy look, related to the actual season of the year.

How it works
-------------

It consists of 2 files, the ThemeController and ThemeService, the first one containing the business logic.
The microservice checks the actual month by the timer of the computer, then deciding what season it is, so it can select the fitting (depending on the season) background and formatting ( as a bootstrap link ) for the pages. In the end it returns 2 links in a Json form.

> **How to install:**

> - Clone the repository of our microservice and open the file structure with an IDE like IntelliJ.
> - Run the server named ThemeService
> - It runs on the localhost:60001 
> - The Bootstrap CDN link needs to be used in the html header

Example request/responses
--------------------------------------
Request is localhost:60001/theme (open it in a browser). 
Response will be a json containing 2 links, depending on the season
- a picture to use as background
- a bootstrap link 


Bootstrap guide: 
http://www.w3schools.com/bootstrap/bootstrap_get_started.asp
