# appone

This is a spring boot app. This app expose two RESTful services


http://localhost:80/greetings

returns a message {"message":"Hello World"}

http://localhost:8080/internal-greetings

{"message":"Hello Management"}

/internal-greetings is only accessible to a authenticated user . The username \ password to use is Admin\password.


This application is also enabled with Actuator which allows us to invoke the actuate endpoints on port 9001