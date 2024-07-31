<a id="readme-top"></a>
[![GitHub Stars][stars-shield]][stars-url]
[![GitHub Issues][issues-shield]][issues-url]
[![Current Version][version-shield]][repo-url]
[![Live Demo][live-demo-shield]][live-demo-url]


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/felt-cute/fantastic-invention-learning-network">
    <img src="logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Fantastic Invention Learning Network</h3>

  <p align="center">
    Collaborative Learning Network for Students and Educators
    <br />
    <a href="https://github.com/felt-cute/fantastic-invention-learning-network"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/felt-cute/fantastic-invention-learning-network">View Demo</a>
    ·
    <a href="https://github.com/felt-cute/fantastic-invention-learning-network/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/felt-cute/fantastic-invention-learning-network/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">Overview</a>
      <ul>
        <li><a href="#technical-stack">Tech Stack</a></li>
        <li><a href="#core-features">Core Features</a></li>
        <li><a href="#monetization-strategies">Monetization Strategies</a></li>
      </ul>
    </li>
    <li><a href="#setup">Setup</a></li>
    <li><a href="#modules">Modules</a></li>
    <li><a href="#api-reference">API Reference</a></li>
    <li><a href="#database-schema">Database Schema</a></li>
    <li><a href="#implementation-steps">Implementation Steps</a></li>
    <li>
        <a href="#additional-considerations">Additional Considerations</a>
        <ul>
            <li><a href="#bonus-features">Bonus Features</a></li>
            <li><a href="#to-do">To-Dos</a></li>
            <li><a href="#future-features">Future Features</a></li>
        </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
    
  </ol>
</details>

---

## Overview

The goal of this project is to create a social media application tailored specifically for students and educators.

This platform will facilitate collaboration on academic projects, resource sharing, and discussions on various
educational topics.

By enhancing peer learning and networking, the application aims to create a supportive community that fosters
academic growth and engagement.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## Technical Stack

### Frontend
- **Framework**: React or Angular for building a dynamic user interface.
- **State Management**: Redux or Context API for managing application state.

### Backend
- **Framework**: Spring Boot for the backend RESTful API.
- **Database**: PostgreSQL for storing user data, resources, and discussions.
- **Authentication**: Use Spring Security for user authentication and authorization.

### Hosting and Deployment
- **Cloud Provider**: AWS, Heroku, or DigitalOcean for hosting the application.
- **Containerization**: Docker for containerizing the application for easier deployment and scalability.`

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## Core Features
- **User Management**: Registration, login, and profile management with role-based access control.
- **Project Collaboration**: Create, join, and manage projects to facilitate teamwork.
- **Resource Library**: Centralized library for uploading, accessing, and sharing educational resources.
- **Discussion Forums**: Start discussions and engage in collaborative dialogues on academic topics.
- **Notifications**: Real-time notifications about project updates and discussion replies.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## Monetization Strategies
1. **Freemium Model**: Offer basic features for free while charging for premium features such as advanced analytics, additional storage for resources, or exclusive webinars.
2. **Sponsorships**: Partner with educational institutions or companies for sponsored content or advertisements.
3. **Subscription Plans**: Provide subscription options for educators to access advanced tools for managing their courses and student interactions.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## Setup

Copy environment variables to the [.env](.env) file
```bash
cp .env.example .env
```
`DATABASE_HOST`
`DATABASE_PORT`
`DATABASE_NAME`
`DATABASE_PASSWORD`
`DATABASE_USER`
`JWT_SECRET`
`AWS_ACCESS_KEY_ID`
`AWS_SECRET_ACCESS_KEY`

Start the services

```bash
docker compose up -d
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## Modules

### [User Management Service](users/README.md)
- **Functionality**: Handles user registration, login, and profile management.
- **Core Features**: User authentication and authorization, role-based access control, password management.

### [Project Management Service](projects/README.md)
- **Functionality**: Manages creation, retrieval, updating, and deletion of projects.
- **Core Features**: Project collaboration, membership management, and project details retrieval.

### [Resource Management Service](resources/README.md)
- **Functionality**: Facilitates uploading, accessing, and managing educational resources.
- **Core Features**: Resource sharing, categorization, and retrieval based on project association.

### Discussion Management Service
- **Functionality**: Manages discussion threads and messages between users.
- **Core Features**: Creating discussion threads, posting messages, and retrieving discussions.

### Notification Service
- **Functionality**: Handles notifications for user activities and updates.
- **Core Features**: Real-time notifications, retrieval of notifications, and management of notification states.

### User Profile Service
- **Functionality**: Manages user profile details and customization.
- **Core Features**: Profile retrieval, updating, and deletion.

### Analytics Service
- **Functionality**: Collects and analyzes user activity data.
- **Core Features**: Logging user activities, retrieving analytics data for users and projects.

### API Gateway
- **Functionality**: Acts as a single entry point for client requests to various microservices.
- **Core Features**: Routing, load balancing, security enforcement, and request aggregation.

### Inter-Service Communication
- **Functionality**: Facilitates communication between microservices.
- **Core Features**: RESTful APIs and gRPC for synchronous and asynchronous communication.

### Data Management
- **Functionality**: Manages data storage and retrieval across microservices.
- **Core Features**: Integration with PostgreSQL or MongoDB for data persistence.

### Event-Driven Architecture
- **Functionality**: Supports asynchronous communication and event handling.
- **Core Features**: Integration with Kafka for event streaming and decoupled service interactions.

### Security and Monitoring
- **Functionality**: Ensures application security and performance monitoring.
- **Core Features**: Implementing Spring Security for authentication, centralized logging, and monitoring solutions like ELK Stack or Prometheus.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---


## [API Reference](http://localhost:8080/actuator/gateway/routes)

### [User Management Service](http://localhost:8181/swagger-ui.html)
- `POST /api/users/register`
    - Register a new user (student or educator).
- `POST /api/users/login`
    - Authenticate a user and return an authentication token.
- `GET /api/users/{id}`
    - Retrieve user profile details by user ID.
- `GET /api/users/user`
    - Retrieve authenticated user details.
- `PUT /api/users/{id}` (admin)
    - Update user profile information (admin only).

### [Project Management Service](http://localhost:8182/swagger-ui.html)

- `POST /api/projects`
    - Create a new project.
- `GET /api/projects/{projectId}`
    - Retrieve details of a specific project.
- `GET /api/projects/member/{memberId}`
    - Get a list of projects associated with a specific member.
- `PUT /api/projects/{projectId}`
    - Update project details.
- `DELETE /api/projects/{projectId}` (owner)
    - Delete a project (owner only).
- `POST /api/members/add`
    - Add member to a project.
- `DELETE /api/members/remove`
    - Remove a member from a project.
- `GET /api/members/{memberId}`
    - Get a list of Projects associated with a member id.

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

### [User Profile Service](http://localhost:8080/swagger-ui.html)
- `GET /api/profiles/{userId}`
   - Retrieve detailed user profile information.
- `PUT /api/profiles/{userId}`
   - Update user profile details.
- `DELETE /api/profiles/{userId}` (admin)
   - Delete a user profile (admin only).

### [Analytics Service](http://localhost:8080/swagger-ui.html)
- `POST /api/analytics/log`
   - Log user activity (e.g., resource access, project participation).
- `GET /api/analytics/user/{userId}`
   - Retrieve analytics data for a specific user.
- `GET /api/analytics/project/{projectId}`
   - Retrieve analytics data for a specific project.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

---
## Database schema

### [User Management Service](./users/README.md#database-schema)

#### [Users](users%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Flearningnetwork%2Fusers%2Fmodel%2FUserEntity.java)
- `id` (Primary key)
- `username`
- `email` (unique)
- `password`
- `roles` (ENUM: 'student', 'educator', `admin`)
- `created_at`

### [Project Management Service](Projects/README.md#database-schema)

#### [Projects](projects%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Flearningnetwork%2Fmodel%2FProject.java)
- `id` (Primary key)
- `title`
- `description`
- `owner_id` (Foreign key referencing users.id)
- `created_at`

### [Resource Management Service](Resources/README.md#database-schema)

#### [Resources](resources%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Flearningnetwork%2Fmodel%2FResource.java)
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
- `is_read` (Boolean)
- `created_at`

### [Analytics Service](analytics/README.md#database-schema)

#### [User Activity]()
- `id` (Primary key)
- `user_id` (Foreign key referencing users.id)
- `action_type` (ENUM: 'resource_access', 'project_participation', etc.)
- `target_id` (ID of the resource or project)
- `timestamp`

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---
## Implementation Steps

1. **Set Up the Development Environment**
    - [x] Install Java Development Kit (JDK)
    - [x] Set up a Spring Boot project using Spring Initializr
    - [x] Configure the project structure and dependencies (e.g., Spring Web, Spring Data JPA, Spring Security)

2. **Design the Database Schema**
    - [x] Create the database using PostgreSQL
    - [] Implement the database schema based on the defined tables for 
      - [x] users
      - [x] projects
      - [x] resources
      - [] discussions
      - [] messages
      - [] notifications
    - [] Set up JPA entities corresponding to each table

3. **Implement User Management Service**
    - [x] Create User entity and repository
    - [x] Implement user registration and login functionality
    - [x] Develop user profile management features
    - [x] Set up password hashing and validation

4. **Implement User Authentication and Authorization**
    - [x] Set up Spring Security for authentication
    - [x] Implement role-based access control (e.g., student, educator, admin)
    - [x] Configure JWT (JSON Web Tokens) for secure API access

5. **Develop Project Management Service**
    - [x] Create Project entity and repository
    - [x] Implement project creation, retrieval, updating, and deletion functionality
    - [x] Develop endpoints to manage project membership

6. **Develop Resource Management Service**
    - [x] Create Resource entity and repository
    - [x] Implement resource upload, retrieval, updating, and deletion functionality
    - [x] Develop endpoints to associate resources with projects

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

10. **Implement Inter-Service Communication**
    - [x] Implement REST service communication using OpenFeign
    - [x] Set up service discovery using Eureka or Consul for dynamic service registration and discovery
    - [x] Configure load balancing for API calls through the API Gateway

11. **Develop Event-Driven Architecture**
    - [] Integrate Kafka for event streaming and asynchronous communication between services
    - [] Implement event sourcing where applicable to capture state changes as events

12. **Implement Caching and Data Management**
    - [] Use Redis for caching frequently accessed data and managing user sessions
    - [] Implement rate limiting using Redis to control API usage

13. **Develop Frontend Application**
    - [] Choose a frontend framework (e.g., React, Angular, Vue.js)
    - [] Set up the frontend project structure
    - [] Implement user interfaces for registration, login, project management, resource sharing, discussions, and notifications
    - [] Integrate RESTful APIs with the frontend application

14. **Testing and Quality Assurance**
    - [] Write unit tests for backend services and controllers
    - [] Implement integration tests for API endpoints
    - [] Conduct user acceptance testing (UAT) with target users

15. **Deployment and Monitoring**
    - [] Choose a cloud provider (e.g., AWS, Heroku) for deployment
    - [] Set up CI/CD pipelines for automated deployment
    - [] Implement monitoring and logging for application performance, using tools like ELK Stack or Prometheus

16. **Documentation**
    - [] Create API documentation using Swagger or OpenAPI
    - [] Write user guides and technical documentation for future development

<p align="right">(<a href="#readme-top">back to top</a>)</p>

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

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- CONTACT -->
## Contact

Devin Catuns - <a href="mailto:devincatuns1@gmail.com">devincatuns1@gmail.com</a>

[![LinkedIn][linkedin-shield]][linkedin-url]
[![portfolio][porfolio-shield]][portfolio-url]

[Fantastic Invention Learning Network][repo-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>

---
## Buy me a coffee

Whether you use this project, have learned something from it, or just like it, please consider supporting it by buying me a coffee, so I can dedicate more time on open-source projects like this :)

<a href="https://www.buymeacoffee.com/devincatunj" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[version-shield]: https://img.shields.io/badge/version-0.0.1-green.svg?style=for-the-badge
[contributors-shield]: https://img.shields.io/github/contributors/felt-cute/fantastic-invention-learning-network.svg?style=for-the-badge&logo=github
[contributors-url]: https://github.com/felt-cute/fantastic-invention-learning-network/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/felt-cute/fantastic-invention-learning-network.svg?style=for-the-badge
[forks-url]: https://github.com/felt-cute/fantastic-invention-learning-network/network/members
[stars-shield]: https://img.shields.io/github/stars/felt-cute/fantastic-invention-learning-network.svg?style=for-the-badge&&logo=github
[stars-url]: https://github.com/felt-cute/fantastic-invention-learning-network/stargazers
[issues-shield]: https://img.shields.io/github/issues/felt-cute/fantastic-invention-learning-network.svg?style=for-the-badge
[issues-url]: https://github.com/felt-cute/fantastic-invention-learning-network/issues
[license-shield]: https://img.shields.io/github/license/felt-cute/fantastic-invention-learning-network.svg?style=for-the-badge
[license-url]: https://github.com/felt-cute/fantastic-invention-learning-network/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=0A66C2
[linkedin-url]: https://www.linkedin.com/in/devin-catuns/
[live-demo-shield]: https://img.shields.io/badge/demo-offline-red.svg?style=for-the-badge
[live-demo-url]: https://filn.vercel.app
[repo-url]: https://github.com/felt-cute/fantastic-invention-learning-network
[porfolio-shield]: https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white
[portfolio-url]: https://dcat23.vercel.app/
