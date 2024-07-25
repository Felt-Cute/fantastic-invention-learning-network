# Project Management Service

Manages creation, retrieval, updating, and deletion of projects.

## Core Features

- Project collaboration
- membership management
- project details retrieval

## [API Reference](http://localhost:8182/swagger-ui.html)

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

## [Projects]()
- `id` (Primary key)
- `title`
- `description`
- `owner_id` (Foreign key referencing users.id)
- `created_at`