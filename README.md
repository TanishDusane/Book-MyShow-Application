# Book MyShow Application

This project is a comprehensive implementation of a booking management system, designed to streamline the process of booking tickets for movies and shows. Leveraging the Spring Boot framework, MySQL database integration, and RESTful API development, this application offers a seamless user experience for browsing, booking, and managing tickets.

## Features
- **CRUD Operations:** The project incorporates CRUD (Create, Read, Update, Delete) functionalities for essential entities, including movies, shows, theaters, tickets, and users. These operations enable efficient management of data across the application.

- **Entity Overview:**
  - **Movie:** CRUD operations allow the addition, retrieval, modification, and deletion of movie records.
  - **Show:** Facilitates the scheduling of shows with functionalities for adding, viewing, updating, and removing show details.
  - **Theater:** Manages venue information through CRUD operations, ensuring accurate representation and easy modification.
  - **Ticket:** Enables users to book, view, update, and cancel tickets seamlessly, enhancing the overall booking experience.
  - **User:** Allows the creation, retrieval, updating, and deletion of user accounts, ensuring robust user management within the application.

- **API Documentation:** Utilizing Swagger, the project provides comprehensive API documentation, facilitating easy understanding and interaction with the exposed endpoints.

## Development Details
In the development of the BookMyShow application, meticulous attention was dedicated to crafting CRUD functionalities for each vital entity. This included implementing four essential operations—creation, retrieval, updating, and deletion—for entities such as Movie, Show, Theater, Ticket, and User. The Movie entity, for instance, was endowed with capabilities to seamlessly create, retrieve, update, and delete movie records, ensuring dynamic management of movie listings. Similarly, the Show entity was meticulously designed to facilitate the seamless handling of show information, encompassing functionalities such as adding, viewing, updating, and removing show details to maintain an up-to-date schedule. Complementing this, the Theater entity was equipped with a suite of CRUD operations, enabling the efficient addition, retrieval, modification, and removal of theater data, ensuring accurate representation of venue information. Moreover, the Ticket entity was intricately engineered to provide users with the ability to effortlessly book, view, update, and cancel tickets, enhancing the overall user experience. Finally, the User entity was endowed with functionalities for the creation, retrieval, updating, and deletion of user accounts, ensuring robust user management within the application. Through meticulous attention to CRUD operations across all entities, the BookMyShow application delivers a seamless and intuitive user experience while maintaining the integrity and accuracy of its data.

## Getting Started
To run the application locally, follow these steps:
1. Clone this repository to your local machine:
   
   ```bash
   git clone https://github.com/TanishDusane/Book-MyShow-Application.git
   ```
3. Navigate to the project directory:
   
   ```bash
   cd Book-MyShow-Application
   ```
5. Set up the required dependencies. Ensure you have Java 17 and Maven installed on your system.
6. Configure the MySQL database according to the application properties.
7. Run the application using Maven:
   
   ```bash
   mvn spring-boot:run
   ```
   Alternatively, you can import the project into your preferred IDE and run it from there.

## Usage
Once the application is up and running, you can interact with it through the provided API endpoints. Refer to the Swagger documentation for details on available endpoints and their usage.

## Contributor
- [Tanish Dusane](https://github.com/TanishDusane/TanishDusane)

------

Happy Coding!
