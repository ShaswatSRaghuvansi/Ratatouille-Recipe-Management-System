# RATATOUILLE     RECIPE     MANAGEMENT     SYSTEM

## Readme Index 
1. Domain Description
2. Developer Access Credentials
3. Database Information
4. Admin Access
5. Existing Users Access
6. Database Import
7. Importing a SQL File using mysqldump


## Domain Description <br>

![Slide1](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/ef0f5311-2c6d-419a-a724-db08e3865062)

![Slide2](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/d0d4d763-d277-42e7-9507-cbcfea536a78)

![Slide3](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/c4875df9-11c3-45b0-a567-6046e7e607b4)

![Slide4](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/202ef7ef-39df-4251-b716-f54bd900aa71)

![Slide5](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/f1be88c0-ce1b-48b1-9583-17a0a2aea9dd)

## Developer Access Credentials 🪪

## Database Information
- Database Name: ratatouille_rms
- Database Credentials:
  - Username: root
  - Password: root

## Admin Access 🧑‍💻
To access the system as an administrator, use the following credentials:
- Username: admin
- Password: admin

## Existing Users Access 👤
To log in as an existing user, please use the following credentials:
- Username: check the users table
- Password: 1234 (Note: This is a common password for all existing users in the database)

## Database Import ⏬
You can import the MySQL file provided with the extension .SQL into your system. This will allow you to use the database schema used during the creation of this project and make updates as needed.

## Import a SQL file using mysqldump
To import a .sql file with mysqldump, use the mysqlimport command and use the following flags and syntax <br>
$ mysqlimport -u root -p root ~/backup/database/magazines.sql<br>

◉ -u and -p are needed for authentication and is then followed by the name of the database you want to import into. <br>
◉ You'll need to specify the path to your SQL dump file that will contain your import data: ~/backup/database/magazines.sql<br>
◉ You won't need to use > or < for importing, but you will need them for exporting in the next guide.<br>
◉ This will prompt a password request.<br>
◉ Your file will be automatically imported.<br>

Learn to <a href="https://www.youtube.com/watch?v=sJ64ZiB6PUU&t=324s"> Import&Export </a>Database in MySql.

# Notes:

◉ After entering this command, you may be asked to enter the password for the MySQL user that you used.<br>
◉ Please be careful when using an existing database that has records as this command will overwrite your existing database and end up losing your records.<br>

For any further feedback, suggestions, or assistance, please feel free to contact us. We are here to help and support you.<br>

Let's Connect 🫰

![Slide7](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/458ce827-5103-4cf7-b2d5-23fad57bb28c)

