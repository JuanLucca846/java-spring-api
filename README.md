# Java Spring

This Java Spring Boot API provides essential functionalities to manage users data and their departments. Inspired by the YouTube tutorial [DevSuperior/Seu primeiro projeto Java web no Spring Boot](https://www.youtube.com/watch?v=D4frmIHAxEY), but this project has been enhanced with additional endpoints.

#### Features

- Get all users.
- Get a specific users by ID.
- Create a new user.
- Edit an existing user.
- Delete an existing user.


#### Technologies

- ![IntelliJ](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
- ![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

#### API Endpoints

| Method | Endpoint        | Responsibility       |
| ------ | --------------- | -------------------- |
| POST   | /users          | Create user        |
| GET    | /users          | Get all users      |
| GET    | /users/:id      | Find user by id    |
| PATCH  | /users/:id      | Update user by id  |
| DELETE | /users/:id      | Delete user by id  |

#### Examples

| **POST /users**  |
| ----------------- |
| **Request Body:** |

```json
{
    "name": "John Doe",
    "email": "johndoe@gmail.com",
    "derpartment": {
        "id": 1
    }
}
```

| **PATCH /users/:id** |
| --------------------- |
| **Request Body:**     |

```json
{
    "name": "Updated Doe",
    "email": "updateddoe@gmail.com",
    "derpartment": {
        "id": 2
    }
}
```

#### Script SQL

```sql
INSERT INTO tb_department(name) VALUES ('Gestão');
INSERT INTO tb_department(name) VALUES ('Informática');

INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Maria', 'maria@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Bob', 'bob@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Alex', 'alex@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Ana', 'ana@gmail.com');
```

#### Prerequisites

- Java JDK
- Spring Boot
- Maven or Gradle


#### Maven resources puglin config

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-resources-plugin</artifactId>
	<version>3.1.0</version>
</plugin>
```

#### DB config

```
# H2 DB config
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 web client config
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Show SQL on console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

#### Running the app

```bash
#build
$ mvn clean install

#run
$ mvn spring-boot:run
```
