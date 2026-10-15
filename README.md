# JDBC MySQL DELETE Demo (PreparedStatement)

## Aim
Demonstrate how to **delete data** from a MySQL database using JDBC's **PreparedStatement** with a WHERE condition.

## Problem Statement
A Java program that:
1. Connects to a MySQL database named `mydatabase`
2. Deletes a user record from the `users` table based on `id` (user ID = 2)
3. Displays a success message if rows were deleted, or a message indicating no rows were deleted
4. Handles any `SQLException`
5. Uses **try-with-resources** for automatic resource management

## Project Structure
```
jdbc-delete-demo/
├── output/                  # Sample output / screenshots
│   └── sample_output.txt
├── src/
│   └── JDBCDeleteDemo.java
├── README.md
└── .gitignore
```

## Prerequisites
1. **MySQL Server** running on `localhost:3306`
2. Database `mydatabase` created
3. Table `users` must exist with an `id` column (and preferably some data)
4. **MySQL Connector/J** (JDBC driver) in the classpath

### Sample data (optional – for testing)
```sql
USE mydatabase;
INSERT INTO users (name, email) VALUES
('John Doe', 'johndoe@example.com'),
('Jane Doe', 'janedoe@example.com'),
('Alice', 'alice@example.com');
```

## How to Compile & Run

```bash
cd src
javac JDBCDeleteDemo.java

# Run (adjust the path to the connector jar)
java -cp ".:/path/to/mysql-connector-j-8.x.x.jar" JDBCDeleteDemo
```

**Important:** Update the constants inside `JDBCDeleteDemo.java`:
```java
private static final String JDBC_URL  = "jdbc:mysql://localhost:3306/mydatabase";
private static final String USERNAME  = "root";
private static final String PASSWORD  = "your_password";
```

## Expected Output

**When a matching row exists (id = 2):**
```
Connected to MySQL database successfully!
Row deleted successfully.
Number of rows deleted: 1
```

**When no matching row exists:**
```
Connected to MySQL database successfully!
No rows were deleted.
```

## Key Concepts Used
- `DriverManager.getConnection()`
- `PreparedStatement` with parameterized WHERE clause
- `setInt(1, 2)` for the id parameter
- `executeUpdate()` returns the number of rows affected
- Conditional message based on rows affected
- `try-with-resources` for automatic resource management
- Proper `SQLException` handling

## Constraints Followed
- MySQL database must be running and accessible
- JDBC driver must be in the classpath
- `users` table must exist with an `id` column
- Uses PreparedStatement (not Statement) for the DELETE operation
