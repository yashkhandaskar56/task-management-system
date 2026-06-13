🔹 USER TABLE

        CREATE TABLE users (
            id BIGINT IDENTITY(1,1) PRIMARY KEY,
            name VARCHAR(100) NOT NULL,
            email VARCHAR(150) NOT NULL UNIQUE,
            password VARCHAR(255) NOT NULL,
            role VARCHAR(50),
            created_at DATETIME DEFAULT GETDATE()
        );

🔹 TASK TABLE

         CREATE TABLE tasks (
            id BIGINT IDENTITY(1,1) PRIMARY KEY,
            title VARCHAR(200) NOT NULL,
            description VARCHAR(500),
            status VARCHAR(50),
            due_date DATE,
            user_id BIGINT,
            created_at DATETIME DEFAULT GETDATE(),
        
            CONSTRAINT fk_user
            FOREIGN KEY (user_id) REFERENCES users(id)
            ON DELETE CASCADE
        );
