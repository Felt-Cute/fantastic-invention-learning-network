# User Management Service

Handles user registration, login, and profile management.

## Core Features
- User authentication and authorization
- role-based access control
- password management

## API Reference

- `POST /api/users/register`
    - Register a new user (student or educator).
- `POST /api/users/login`
    - Authenticate a user and return an authentication token.
- `GET /api/users/{id}`
    - Retrieve user profile details by user ID.
- `PUT /api/users/{id}`
    - Update user profile information.
- `DELETE /api/users/{id} (admin)`
    - Delete a user account (admin only).


## Database Schema

### [Users]()

- `id` (Primary key)
- `username`
- `email`
- `password`
- `role` (ENUM: 'student', 'educator')
- `created_at`