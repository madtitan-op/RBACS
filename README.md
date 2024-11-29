## RBAC System with JWT Authentication

### **Project Description**
This project implements a **Role-Based Access Control (RBAC) system** using **Spring Boot** with **JWT (JSON Web Token)** for secure, stateless authentication.

Key Features:
- **Authentication**: Secure login with credentials and JWT-based session management.
- **Authorization**: Enforces access based on user roles (`ADMIN` and `USER`).
    - `ADMIN`: Access to all admin and user resources.
    - `USER`: Access to user-specific resources.
    - **Public Resources**: No authentication required.
- **Stateless Design**: Uses JWT for session management without server-side storage.
- **Scalable Architecture**: Easily extensible for more roles or features.

---

### **Setup Instructions**

#### **1. Prerequisites**
- Java 17 or later
- Maven
- A database (PostgreSQL is configured by default, but it can be changed to MySQL)
- Postman or cURL (for testing APIs)

#### **2. Clone the Repository**
```bash
git clone https://github.com/madtitan-op/RBACS.git
cd RBACS
```

#### **3. Configure the Application**
- Open `application.properties` and update the database settings if necessary:
  ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/rbacs
    spring.datasource.username=postgres
    spring.datasource.password=secret
  ```
- You can replace the `secretKey` in `JwtService` with a strong secret key.

#### **4. Build the Application**
```bash
.\mvnw clean install
```

#### **5. Run the Application**
```bash
.\mvnw spring-boot:run
```

The application will by default start on [http://localhost:8080](http://localhost:8080).

---

### **Usage Instructions**

#### **1. Testing Endpoints**
Use the following endpoints to test the application:

1. **Login**
    - Endpoint: `POST /auth/login`
    - Request:
      ```json
      {
        "username": "admin",
        "password": "admin123"
      }
      ```
    - Response:
      ```json
      {
        "token": "your_jwt_token_here"
      }
      ```

2. **Access Protected Resources**
    - Include the JWT token in the `Authorization` header:
      ```
      Authorization: Bearer <your_token>
      ```
    - **Admin Endpoint**: `GET /admin/`
    - **User Endpoint**: `GET /user/`
    - **Public Endpoint**: `GET /public/`
      - *note*: Public Endpoint doesn't require any authentication

#### **2. Seeding Data**
The application automatically seeds the following users into the database for testing:
- Admin User:
    - Username: `admin`
    - Password: `admin123`
    - Role: `ADMIN`
- Regular User:
    - Username: `user`
    - Password: `user123`
    - Role: `USER`

#### **3. Testing JWT Validation**
- Use invalid or expired tokens to ensure proper error handling.
- Access endpoints without a token to verify security.

---

### **Technology Stack**
- **Backend**: Spring Boot
- **Authentication**: JWT
- **Database**: PostgreSQL (can be changed based on requirement)
- **Security**: Spring Security

---

### **Project Contributions**
This project was developed to implement a robust RBAC system:
- Designed the architecture for authentication and role-based access.
- Implemented JWT generation, validation, and authentication filters.
- Configured secure access rules for `ADMIN` and `USER` roles.
- Developed and tested endpoints to ensure proper authorization.

---

### **Future Enhancements**
- Add refresh tokens for longer session management.
- Integrate additional roles or fine-grained permissions.
- Add a frontend for user interaction.
