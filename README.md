# Workshop22

## Objective
The objective of this workshop is to write a simple CRUD application. You will map the HTTP methods to SQL verbs.

# Before starting application[^1]

## 1. Add.env with the following contents
- ### For localhost development
    ```
    MYSQLUSER=<user>
    MYSQLPASSWORD=<password>
    MYSQLDATABASE=
    MYSQLHOST=
    MYSQLPORT=
    MYSQL_URL=jdbc:mysql://localhost/<schema name>
    ```
- ### For deploying to Railway MySQL and using root user
    `MYSQLUSER=root` if using root user.

    Spring runs `MySqlConfig.java` and pulls railway's environment variables to connect to railway's MySQL.

- ### For deploying to Railway MySQL and using new user
    #### share these variables to railway
    ```
    MYSQLUSER=<user>
    MYSQLPASSWORD=<password>
    ```

## 2. Create database and tables with:
[Database](src/main/java/sg/edu/nus/iss/workshop22/database)

[^1]: Or before deploying to Railway and Railway's MySQL