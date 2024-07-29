# Resources Application

Facilitates uploading, accessing, and managing educational resources.

## Key Features

- Resource sharing
- categorization
- retrieval based on project association.

## [API Reference](http://localhost:8080/swagger-ui.html)
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

## [Database Schema](resources%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Flearningnetwork%2Fmodel%2FResource.java)
- `id` (Primary key)
- `project_id` (Foreign key referencing projects.id)
- `title`
- `file_url`
- `uploaded_by` (Foreign key referencing users.id)
- `created_at`