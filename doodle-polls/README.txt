For this project I chose Java because it is center of my interest, and Mongo data base as
the most appropriate data base for this kind of application.

Regarding to my solution and implementation there is a main endpoint  http://localhost:8080/api/polls
Text search is supported, but not for all fields, just for ones that are useful when filtering polls.
In my opinion that fields are: title, description and text (as part of Option), so text search can be done
for any word in these fields.
For filtering on creation date format "yyyy-MM-dd" should be used as a request parameter, so the appropriate URL looks like :
http://localhost:8080/api/polls?since=2017-01-01

As in task requirement is written this "Design an API endpoint to list all polls created by a USER",
It looks like we want to filter polls that are created by exact user not all polls from database, 
even if we have just polls from one user in data base. (populated by link https://boiling-tor-31289.herokuapp.com/users/me/polls )
Each doodle user should have a different email for signing in, so we can rely on that information if we want to filter polls by user.
Because of this, just to be sure that i implemented all requirements, i made one more URL that filters polls by user email.
All features are impleted as for main endpoint. So if you wanted to test that also, you can use endpoint : http://localhost:8080/api/user/email/{email}/polls

Thanks for your time