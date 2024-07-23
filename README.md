# Fantastic Invention Learning Network

[![GitHub Stars](https://img.shields.io/github/stars/felt-cute/fantastic-invention-learning-network.svg)](https://github.com/felt-cute/fantastic-invention-learning-network/stargazers)
[![GitHub Issues](https://img.shields.io/github/issues/felt-cute/fantastic-invention-learning-network.svg)](https://github.com/felt-cute/fantastic-invention-learning-network/issues)
[![Current Version](https://img.shields.io/badge/version-0.0.1-green.svg)](https://github.com/felt-cute/fantastic-invention-learning-network)
[![Live Demo](https://img.shields.io/badge/demo-offline-red.svg)](https://fmhh.vercel.app)

The goal of this project is to create a social media application tailored specifically for students and educators. 

This platform will facilitate collaboration on academic projects, resource sharing, and discussions on various 
educational topics. 

By enhancing peer learning and networking, the application aims to create a supportive community that fosters 
academic growth and engagement.

---
## Technical Stack
### Frontend
- **Framework**: React or Angular for building a dynamic user interface.
- **State Management**: Redux or Context API for managing application state.
### Backend
- **Framework**: Spring Boot for the backend RESTful API.
- **Database**: PostgreSQL or MongoDB for storing user data, resources, and discussions.
- **Authentication**: Use Spring Security for user authentication and authorization.
### Hosting and Deployment
- **Cloud Provider**: AWS, Heroku, or DigitalOcean for hosting the application.
- **Containerization**: Docker for containerizing the application for easier deployment and scalability.

---
## Monetization Strategies
1. **Freemium Model**: Offer basic features for free while charging for premium features such as advanced analytics, additional storage for resources, or exclusive webinars.
2. **Sponsorships**: Partner with educational institutions or companies for sponsored content or advertisements.
3. **Subscription Plans**: Provide subscription options for educators to access advanced tools for managing their courses and student interactions.

---
## Modules


---
## Setup

Clone the project

```bash
  git clone https://github.com/felt-cute/fantastic-invention-learning-network.git
  cd fantastic-invention-learning-network
```

Copy environment variables
```bash
cp .env.example .env
```
Add the following environment variables to the [.env](.env) file
`DATABASE_HOST`
`DATABASE_PORT`
`DATABASE_NAME`
`DATABASE_PASSWORD`
`DATABASE_USER`

Start the services

```bash
docker compose up -d
```
---
## [API Reference](http://localhost:8080/swagger-ui.html)
### [User Management Service](http://localhost:8080/swagger-ui.html)
- ``POST /api/users/register``
  - Register a new user (student or educator).
- `POST /api/users/login`
  - Authenticate a user and return an authentication token.
- `GET /api/users/{id}`
  - Retrieve user profile details by user ID.
- `PUT /api/users/{id}`
  - Update user profile information.
- `DELETE /api/users/{id} (admin)`
   - Delete a user account (admin only).
### [Project Management Service](http://localhost:8080/swagger-ui.html)
- `POST /api/projects`
  - Create a new project.
- `GET /api/projects/{projectId}`
  - Retrieve details of a specific project.
- `GET /api/projects/user/{userId}`
  - Get a list of projects associated with a specific user.
- `PUT /api/projects/{projectId}`
  - Update project details.
- `DELETE /api/projects/{projectId} (admin)`
   - Delete a project (admin only).
### [Resource Management Service](http://localhost:8080/swagger-ui.html)
- `POST /api/resources`
  - Upload a new resource to a project.
- `GET /api/resources/{resourceId}`
  - Retrieve details of a specific resource.
- `GET /api/resources/project/{projectId}`
  - Get a list of resources associated with a specific project.
- `PUT /api/resources/{resourceId}`
  - Update resource details.
- `DELETE /api/resources/{resourceId} (admin)`
   - Delete a resource (admin only).
### [Discussion Management Service](http://localhost:8080/swagger-ui.html)
- `POST /api/discussions`
  - Start a new discussion thread.
- `GET /api/discussions/{discussionId}`
  - Retrieve details of a specific discussion thread.
- `GET /api/discussions/project/{projectId}`
  - Get a list of discussions associated with a specific project.
- `POST /api/discussions/{discussionId}/messages`
  - Post a message in a discussion thread.
- `GET /api/discussions/{discussionId}/messages`
   - Retrieve all messages in a specific discussion thread.
### [Notification Service](http://localhost:8080/swagger-ui.html)
- `GET /api/notifications`
  - Retrieve a list of notifications for the authenticated user.
- `GET /api/notifications/{notificationId}`
  - Retrieve details of a specific notification.
- `DELETE /api/notifications/{notificationId}`
   - Delete a specific notification.

---
## Database schema
### [User Management Service](Users/README.md#database-schema)
#### [Users]()
- `id` (Primary key)
- `username`
- `email`
- `password`
- `role` (ENUM: 'student', 'educator')
- `created_at`
### [Project Management Service](Projects/README.md#database-schema)
#### [Projects]()
- `id` (Primary key)
- `title`
- `description`
- `owner_id` (Foreign key referencing users.id)
- `created_at`
### [Resource Management Service](Resources/README.md#database-schema)
#### [Resources]()
- `id` (Primary key)
- `project_id` (Foreign key referencing projects.id)
- `title`
- `file_url`
- `uploaded_by` (Foreign key referencing users.id)
- `created_at`
### [Discussion Management Service](Discussions/README.md#database-schema)
#### [Discussions]()
- `id` (Primary key)
- `project_id` (Foreign key referencing projects.id)
- `title`
- `created_by` (Foreign key referencing users.id)
- `created_at`
#### [Messages]()
- `id` (Primary key)
- `discussion_id` (Foreign key referencing discussions.id)
- `message`
- `posted_by` (Foreign key referencing users.id)
- `created_at`
### [Notification Service](Notifications/README.md#database-schema)
#### [Notifications]()
- `id` (Primary key)
- `user_id` (Foreign key referencing users.id)
- `type`
- `message`
- `created_at`
---
## Implementation Steps
1. **Set Up the Development Environment**
   - [] Install Java Development Kit (JDK)
   - [] Set up a Spring Boot project using Spring Initializr
   - [] Configure the project structure and dependencies (e.g., Spring Web, Spring Data JPA, Spring Security)
2. **Design the Database Schema**
   - [] Create the database using PostgreSQL or another relational database
   - [] Implement the database schema based on the defined tables for users, projects, resources, discussions, messages, and notifications
   - [] Set up JPA entities corresponding to each table
3. **Implement User Management Service**
   - [] Create User entity and repository
   - [] Implement user registration and login functionality
   - [] Develop user profile management features
   - [] Set up password hashing and validation
4. **Implement User Authentication and Authorization**
   - [] Set up Spring Security for authentication
   - [] Implement role-based access control (e.g., student, educator, admin)
   - [] Configure JWT (JSON Web Tokens) for secure API access
5. **Develop Project Management Service**
   - [] Create Project entity and repository
   - [] Implement project creation, retrieval, updating, and deletion functionality
   - [] Develop endpoints to manage project membership
6. **Develop Resource Management Service**
   - [] Create Resource entity and repository
   - [] Implement resource upload, retrieval, updating, and deletion functionality
   - [] Develop endpoints to associate resources with projects
7. **Develop Discussion Management Service**
   - [] Create Discussion and Message entities and repositories
   - [] Implement discussion thread creation, message posting, and retrieval functionality
   - [] Develop endpoints for managing discussions and messages
8. **Implement Notification Service**
   - [] Create Notification entity and repository
   - [] Implement notification creation and retrieval functionality
   - [] Develop endpoints for user notifications
9. **Implement RESTful APIs**
   - [] Design and develop endpoints for each microservice
   - [] Use Spring MVC for creating controllers
   - [] Ensure proper request validation and error handling
10. **Develop Frontend Application**
    - [] Choose a frontend framework (e.g., React, Angular, Vue.js)
    - [] Set up the frontend project structure
    - [] Implement user interfaces for registration, login, project management, resource sharing, discussions, and notifications
    - [] Integrate RESTful APIs with the frontend application
11. **Testing and Quality Assurance**
    - [] Write unit tests for backend services and controllers
    - [] Implement integration tests for API endpoints
    - [] Conduct user acceptance testing (UAT) with target users
12. **Deployment and Monitoring**
    - [] Choose a cloud provider (e.g., AWS, Heroku) for deployment
    - [] Set up CI/CD pipelines for automated deployment
    - [] Implement monitoring and logging for application performance
13. **Documentation**
    - [] Create API documentation using Swagger or OpenAPI
    - [] Write user guides and technical documentation for future development
---
## Additional Considerations
- **Data Privacy**: Ensure compliance with data protection regulations (e.g., GDPR, FERPA).
- **Accessibility**: Implement features to support users with disabilities (e.g., screen reader compatibility).
- **Scalability**: Design the architecture to handle increased user load and data volume.
## Bonus Features
- **Gamification**: Introduce leaderboards and achievements to encourage user engagement.
- **Discussion Polls**: Allow users to create polls within discussions to gather opinions.
- **Resource Rating System**: Enable users to rate and review shared resources.
## To-Do
- **User Feedback Mechanism**: Implement a system for users to provide feedback on features and usability.
- **Mobile Responsiveness**: Ensure the frontend is fully responsive across devices.
- **Performance Optimization**: Identify and optimize slow-performing queries and endpoints.
## Future Features
- **Integration with External Tools**: Allow integration with tools like Google Drive, Dropbox, or educational platforms (e.g., Moodle).
- **AI-Powered Recommendations**: Implement machine learning algorithms to suggest resources and discussions based on user behavior.
- **Offline Access**: Enable users to access certain features and resources without an internet connection.
---

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://dcatuns.vercel.app/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/devin-catuns/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)

---
## Buy me a coffee

Whether you use this project, have learned something from it, or just like it, please consider supporting it by buying me a coffee, so I can dedicate more time on open-source projects like this :)

<a href="https://www.buymeacoffee.com/devincatunj" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>
---
## Feedback
If you have any feedback, please reach out to me by 

<a href="mailto:devincatuns1@gmail.com">email</a>