# User Management Service

Handles user registration, login, and profile management.

## Core Features
- User authentication and authorization
- role-based access control
- password management

## [API Reference](http://localhost:8181/swagger-ui.html)

- `POST /api/users/register`
    - Register a new user (student or educator).
- `POST /api/users/login`
    - Authenticate a user and return an authentication token.
- `GET /api/users/{id}`
    - Retrieve user profile details by user ID.
- `GET /api/users/user`
  - Retrieve authenticated user details.
- `PUT /api/users/{id}`
    - Update user profile information.


## Database Schema
### [Users](./src%2Fmain%2Fjava%2Fcom%2Fdcat23%2Flearningnetwork%2Fusers%2Fmodel%2FUserEntity.java)

- `id` (Primary key)
- `username`
- `email`
- `password`
- `roles` (ENUM: 'student', 'educator', `admin`)
- `created_at`