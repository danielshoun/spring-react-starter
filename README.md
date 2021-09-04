# Spring React Starter

This is a starter template for creating projects using Spring and React. JWT authorization has already been implemented.

## Getting Started

This template was created with the following software versions in mind:
- OpenJDK v16.0.2
- Node v15.11
- Gradle v7.2
- Yarn v1.22.5
- PostgreSQL v13.4
 
First, go ahead and clone this repository.

    git clone https://github.com/danielshoun/spring-react-starter.git

Next, install the dependencies for both the frontend.

    cd frontend && yarn install

You will need to edit the `src/main/resources/applications.properties` to provide valid database credentials before Spring Boot will start successfully.

From here you have two choices:

1. If you would like to take advantage of React's live reload feature during development, you should build and run each process separately.
   1. `gradle build && java -jar build/libs/spring-react-starter-0.0.1-SNAPSHOT.jar`
   2. `cd frontend && yarn start`
2. You can also build the frontend which will automatically place it in Spring Boot's static asset folder. When the Gradle project is built again, it will be included.
   1. `cd frontend && yarn build`
   2. `gradle build && java -jar build/libs/spring-react-starter-0.0.1-SNAPSHOT.jar`

The first option will make the React app available from `http://localhost:3000/` while the backend remains on `http://localhost:8080/`. The second will serve the React app from within Spring at `http://localhost:8080/`.

A full tutorial explaining how to create and extend this template from scratch will be made available soon.