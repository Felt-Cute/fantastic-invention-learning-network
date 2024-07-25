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

## Database Schema

[Projects](src%2Fmain%2Fjava%2Fcom%2Fdcat23%2Flearningnetwork%2Fmodel%2FProject.java)
- `id` (Primary key)
- `title` 
- `description`
- `owner_id` (Foreign key referencing users.id)
- `created_at`
