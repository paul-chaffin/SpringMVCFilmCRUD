# Spring MVC Film CRUD Project

## Week 8 Weekend Project for Skill Distillery

### Description

This program allows a user to `search` for film records by an Id or keyword from an existing SQL database. Additionally, a user may `add`, `update`, and `delete` films from a database by using `C.R.U.D` operations. 

### Learning Objectives 

- Gain exposure and valuable practice working collaboratively as a team
- Build a full C.R.U.D application 

## How To Use This Program

#### Step 0

- Download project code and sdvid database files. 
	
#### Run program on server

- User will land on home.jsp landing page.
    - Search for a film by its Id by entering a numeric number. A message will display on a results page if no record is found. 
    - Search for a film by a keyword - which searches on a film's title or description. A message will display on a results page if no record is found. 
        - Either of the above searches will yield results on a result.jsp page if corresponding records are found.
           - Results will display a film *or* multiple films based on type of search chosen by user.
           - Search results will display `film details` along with `film category` and each film's `cast of actors`. 
<br> <br> CRUD: 
- User may add / create a new film from a form on the home.jsp page. <br>
User may enter all or only some text boxes as desired. When user hits submit button on the add new film form, user will be redirected to result page. 
    - On result page, a user has the option of `updating a film they have created`, or a user may `delete a film by Id` they have previously created.
        - If user chooses to `update a film they previously created`, the results will immediately display on the result page. 
       - If user chooses to `delete a film they previously created`, a simple confirmation message will display on a results page. 

## Technologies Used

- Spring MVC
- Spring ToolSuite 
- MAMP Server
- Gradle
- Java
- HTML
- JSP tag library
- SQL
- Zoom
- git 
- GitHub

## Project Members

- Paul Chaffin
- JD Hufstetler
- Brian Teets 

## Lessons Learned

- Collaborating using git and GitHub 
    - Exposure and practice with utilizing git pull and push with other contributing team members
    - Exposure with resolving merge conflicts 
- Team work with diagnosing sql query syntax - particularly with JOIN statements
- Integrating the complexities of combining sql, JSP result views and Java methods into a workable solution 
