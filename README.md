# RECIPE     MANAGEMENT     SYSTEM

## Readme Index 
1. Domain Description
2. Developer Access Credentials
3. Database Information
4. Admin Access
5. Existing Users Access
6. Database Import
7. Importing a SQL File using mysqldump


## Domain Description <br>


![Slide1](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/04bcefbb-190d-4074-9a0b-ee6cae3fba5b)

![Slide2](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/aadf42ce-1899-4d6b-9361-7ddfbd7a82cf)

![Slide3](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/2660f1e5-76d4-4056-a424-7e2eca0dfc52)

![Slide4](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/1f9a193e-2956-4425-a57e-8068725b0ce7)

![Slide5](https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/4d6dd422-376d-44dd-9128-243bf983492c)

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
- Username: check users table
- Password: 1234 (Note: This is a common password for all existing users in the database)

## Database Import ⏬
You can import the MySQL file provided with the extension .SQL into your system. This will allow you to use the database schema used during the creation of this project and make updates as needed.

## Import a SQL file using mysqldump
To import a .sql file with mysqldump, use the mysqlimport command and use the following flags and syntax 
$ mysqlimport -u root -p root ~/backup/database/magazines.sql

◉ -u and -p are needed for authentication, and is then followed by the name of the database you want to import into.
◉ You'll need to specify the path to your SQL dump file that will contain your import data: ~/backup/database/magazines.sql
◉ You won't need to use > or < for importing, but you will need them for exporting in the next guide.
◉ This will prompt a password request.
◉ Your file will be automatically imported.

# Notes:

◉ After entering this command, you may be asked to enter the password for the MySQL user that you used.
◉ Please be careful when using an existing database that has records as this command will overwrite your existing database and end up losing your records.

For any further feedback, suggestions, or assistance, please feel free to contact us. We are here to help and support you.

Let's Connect 🫰



<p><a href="https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System"><img src="https://github.com/ShaswatSRaghuvansi/Ratatouille-Recipe-Management-System/assets/115460278/22df6b0f-ed38-4d9b-8672-5bee59bd000d"></a>
</p>
