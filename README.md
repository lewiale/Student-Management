# Student Management Application

## Project Overview
This project is a comprehensive student management application developed using **Java**, **Spring Boot**, and **MySQL**. It provides a robust system for managing students, teachers, courses, batches, and enrollments, supporting CRUD operations (Create, Read, Update, Delete) through RESTful API endpoints.

## Features
- **Student Management**: Add, update, delete, and view student records, including their ID, name, address, and phone number.
- **Teacher Management**: Manage teacher records with functionalities similar to students.
- **Course Management**: Handle course details, including course name, syllabus, and duration.
- **Batch Management**: Manage batches with information such as batch name, start date, and the associated course.
- **Enrollment Management**: Manage enrollments, linking students to batches, with details on join date and fees.
- **Integration**: Easily extendable to include more features such as batch enrollment tracking.

## Technologies Used
- **Java**
- **Spring Boot**
- **MySQL**
- **Postman** (for API testing)
- **Jakarta Persistence API (JPA)**
- **Lombok** (for reducing boilerplate code in DTOs)

## Project Structure
- **Entity**:
  - `Student`: Represents student records.
  - `Teacher`: Represents teacher records.
  - `Course`: Represents course details.
  - `Batch`: Represents batch details and their association with courses.
  - `Enrollment`: Represents student enrollments in batches.
- **DTOs**:
  - `StudentDTO`, `TeacherDTO`, `CourseDTO`, `BatchDTO`, `EnrollmentDTO`: For data transfer across layers.
  - `StudentSaveDTO`, `TeacherSaveDTO`, `CourseSaveDTO`, `BatchSaveDTO`, `EnrollmentSaveDTO`: For creating new records.
  - `StudentUpdateDTO`, `TeacherUpdateDTO`, `CourseUpdateDTO`, `BatchUpdateDTO`, `EnrollmentUpdateDTO`: For updating existing records.
- **Controller**:
  - `StudentController`, `TeacherController`, `CourseController`, `BatchController`, `EnrollmentController`: Handle HTTP requests and map them to the corresponding service methods.
- **Service**:
  - `StudentService`, `TeacherService`, `CourseService`, `BatchService`, `EnrollmentService`: Interface definitions for business logic.
  - `StudentServiceIMPL`, `TeacherServiceIMPL`, `CourseServiceIMPL`, `BatchServiceIMPL`, `EnrollmentServiceIMPL`: Implementations of the service interfaces.
- **Repository**:
  - `StudentRepo`, `TeacherRepo`, `CourseRepo`, `BatchRepo`, `EnrollmentRepo`: Data access layer interfaces extending `JpaRepository`.

## Setup Instructions
1. Clone the repository.
2. Ensure you have Java, Spring Boot, and MySQL installed.
3. Update the `application.properties` file with your MySQL database credentials.
4. Run the application using your preferred IDE or command line interface.
5. Use Postman or any other API testing tool to interact with the provided API endpoints.

## API Endpoints
Here are some of the key API endpoints available:

- **Student Endpoints**:
  - `POST /api/v1/student/save`: Save a new student.
  - `GET /api/v1/student/getAllStudents`: Retrieve all students.
  - `PUT /api/v1/student/update`: Update an existing student.
  - `DELETE /api/v1/student/delete/{id}`: Delete a student by ID.

- **Teacher Endpoints**:
  - `POST /api/v1/teacher/save`: Save a new teacher.
  - `GET /api/v1/teacher/getAllTeachers`: Retrieve all teachers.
  - `PUT /api/v1/teacher/update`: Update an existing teacher.
  - `DELETE /api/v1/teacher/delete/{id}`: Delete a teacher by ID.

- **Course Endpoints**:
  - `POST /api/v1/course/save`: Save a new course.
  - `GET /api/v1/course/getAllCourses`: Retrieve all courses.
  - `PUT /api/v1/course/update`: Update an existing course.
  - `DELETE /api/v1/course/delete/{id}`: Delete a course by ID.

- **Batch Endpoints**:
  - `POST /api/v1/batch/save`: Save a new batch.
  - `GET /api/v1/batch/getAllBatches`: Retrieve all batches.
  - `PUT /api/v1/batch/update`: Update an existing batch.
  - `DELETE /api/v1/batch/delete/{id}`: Delete a batch by ID.

- **Enrollment Endpoints**:
  - `POST /api/v1/enrollment/save`: Save a new enrollment.
  - `GET /api/v1/enrollment/getAllEnrollments`: Retrieve all enrollments.
  - `PUT /api/v1/enrollment/update`: Update an existing enrollment.
  - `DELETE /api/v1/enrollment/delete/{id}`: Delete an enrollment by ID.

## Author
**Lewi Alemayehu**  
Bachelor of Science in Computer Science and Software Engineering, **University of Washington**

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
