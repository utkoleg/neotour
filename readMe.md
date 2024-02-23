# NeoTour Project

NeoTour is a project aimed at providing a platform for users to explore and discover various tours and categories. It allows users to view different categories of tours, add new categories, add tours to existing categories, add comments to tours, and make reservations for tours.

# Project Structure

### The project consists of several components:

* Controllers: Contains REST controllers for handling HTTP requests and responses.
* DTOs (Data Transfer Objects): Contains classes representing data transferred between the client and the server.
* Services: Contains service classes responsible for business logic.
* Configurations: Contains configuration classes for setting up various components such as Cloudinary and OpenAPI.
* Swagger Documentation: Provides OpenAPI documentation for the project.

## Controllers

* CategoryController: Handles operations related to categories such as adding a new category, retrieving all categories, adding a tour to a category, and retrieving tours in a category.
TourController: Manages operations related to tours such as retrieving all tours, adding a new tour, retrieving a tour by ID, deleting a tour by ID, adding a comment to a tour, and adding a reservation to a tour.
Configurations

  
* CloudinaryConfig: Configures Cloudinary for handling image uploads.
OpenAPIConfig: Configures OpenAPI documentation for the project.
Swagger Documentation

The project provides OpenAPI documentation for easy understanding and integration with other services. It includes information about contacts, licenses, versions, and servers.

# How to Run

### To run the NeoTour project locally, follow these steps:

1) Clone the repository to your local machine.
2) Make sure you have Java and Maven installed.
3) Build the project using Maven: mvn clean install.
4) Run the project using Maven: mvn spring-boot:run.
5) Access the application through your web browser at http://localhost:9999.