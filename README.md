




# Student Attendance System

This is a simple student attendance system where you can log in, view a welcome page, and log out.
It uses **Java (Spring Boot)** for the backend and **HTML, JavaScript** for the frontend.
The login functionality is protected with a **JWT (JSON Web Token)**, which ensures secure
authentication.

## Project Structure

- **server/**: Contains the backend code using Spring Boot for the REST API.
- **client/**: Contains the frontend code (HTML, JavaScript).
- **docs/**: For storing any necessary documentation or screenshots.

1. Clone the repository:
   ```bash
   git clone https://github.com/Thenuga12/attendance-system.git
   mkdir server
   mkdir client
   mkdir docs
   git add .
   git commit -m "#1,Create the root folders";
   git push

## Setup Instructions
### Backend Setup (Server)
Using IDE: Intellij Idea
Create the spring boot gradle project using java 17 with spring boot version 3.4.3 by spring initializer
Set up the SDK for the project
Add the dependencies for which we want
*spring-boot-starter-security: Provides support for authentication and authorization, necessary for securing the application.
*spring-boot-starter-web: Includes everything you need to build RESTful APIs
*Lombok: Reduces boilerplate code in Java classes (like getters, setters, constructors)
*spring-boot-starter-test: Basic testing support for Spring Boot
*spring-security-test: Provides testing tools for Spring Security, useful for writing security-related tests.
*junit-platform-launcher: Provides the necessary components to run JUnit tests.
*jjwt-api: Provides the API interface for working with JSON Web Tokens (JWT).
*jjwt-impl: The implementation of the JWT API.
*jjwt-jackson: Jackson support for JSON processing with JWT
Refresh the gradle file when add the dependencies
Run the Project

#### Front end Setup (Client)
Create the front using html and javascript
Create the home page and login page using html
Create the css file for style the pages
Using the javascript for connect the sever and client
Run the Project


### Login Credentials
user name: thenu
password : a1b2

user name:admin
password: 123
   

