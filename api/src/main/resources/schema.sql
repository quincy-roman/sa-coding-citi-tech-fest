CREATE TABLE IF NOT EXISTS Batch (
	id SERIAL PRIMARY KEY,
	name VARCHAR(25) NOT NULL,
	faciliator_Id VARCHAR(25) NOT NULL
); 

INSERT INTO Batch (name, faciliator_Id) VALUES ('Delaney Lekien', 987654);
INSERT INTO Batch (name, faciliator_Id) VALUES ('Quincy Roman', 987655);

CREATE TABLE IF NOT EXISTS sa_User (
	id SERIAL PRIMARY KEY,
	email VARCHAR(75) NOT NULL,
	password VARCHAR(100) NOT NULL,
	first_Name VARCHAR(25) NOT NULL,
	last_Name VARCHAR(25) NOT NULL,
	role VARCHAR(25) NOT NULL,
	batch_Id VARCHAR(25)
);

INSERT INTO sa_User (email, password, first_Name, last_Name, role, batch_Id) VALUES ('delaneylekien@gmail.com', '$2a$10$NKGJNqEGC93k0EFaBY87..qSHLyZ9L0F5t7j3uo9rDJC7jlzWgLn2', 'Delaney', 'Lekien', 'Admin', '123456');
INSERT INTO sa_User (email, password, first_Name, last_Name, role, batch_Id) VALUES ('quincyromane@gmail.com', '$2a$10$NKGJNqEGC93k0EFaBY87..qSHLyZ9L0F5t7j3uo9rDJC7jlzWgLn2', 'Quincy', 'Roman', 'Admin', '123456');
INSERT INTO sa_User (email, password, first_Name, last_Name, role, batch_Id) VALUES ('hvc@gmail.com', 'password', 'Harrison', 'Cooley', 'Admin', '123456');


CREATE TABLE IF NOT EXISTS Assignment (
	id SERIAL PRIMARY KEY,
	batch_Id VARCHAR(25) NOT NULL,
	name VARCHAR(25) NOT NULL,
	max_Score INT NOT NULL,
	assignment_Type VARCHAR(25) NOT NULL,
	due_Date DATE NOT NULL,
	s3_File_Path VARCHAR(250)
);

INSERT INTO Assignment (batch_Id,name,max_Score,assignment_Type,due_Date,s3_File_Path) VALUES ('123456','Quiz #1',10,'Quiz','2023-09-22','https://s3.console.aws.amazon.com/s3/buckets/bucket-hackathon-test-12983765123?region=us-east-1&tab=objects');
INSERT INTO Assignment (batch_Id,name,max_Score,assignment_Type,due_Date,s3_File_Path) VALUES ('123456','Assignment #1',5,'Assignment','2023-09-29','https://s3.console.aws.amazon.com/s3/buckets/bucket-hackathon-test-12983765123?region=us-east-1&tab=objects');

CREATE TABLE IF NOT EXISTS Event (
	event_Id SERIAL PRIMARY KEY,
	batch_Id VARCHAR(25) NOT NULL,
	name VARCHAR(25) NOT NULL,
	description VARCHAR(250),
	date DATE NOT NULL
);

INSERT INTO Event (batch_Id,name,description,date) VALUES ('123456','Delaney Lekien','This event is being hosted by the Hackathon team at Citi','2023-09-22');

CREATE TABLE IF NOT EXISTS Attendance (
	id SERIAL PRIMARY KEY,
	batch_Id VARCHAR(25) NOT NULL,
	user_Id VARCHAR(25) NOT NULL,
	date DATE NOT NULL,
	attendance_Status VARCHAR(25) NOT NULL
);

INSERT INTO Attendance (batch_Id,user_Id,date,attendance_Status) VALUES ('123456','1','2023-09-22','Present');

CREATE TABLE IF NOT EXISTS Submission (
	id SERIAL PRIMARY KEY,
	user_Id VARCHAR(25) NOT NULL,
	assignment_Id VARCHAR(25) NOT NULL,
	s3_File_Path VARCHAR(250),
	grade INT NOT NULL,
	submitted_Date DATE NOT NULL
);	

INSERT INTO Submission (user_Id,assignment_Id,s3_File_Path,grade,submitted_Date) VALUES ('1','Quiz #1','https://s3.console.aws.amazon.com/s3/buckets/bucket-hackathon-test-12983765123?region=us-east-1&tab=objects','95','2023-09-22');

CREATE TABLE IF NOT EXISTS Registration_Token (
	email VARCHAR(75) NOT NULL,
	token VARCHAR(50) NOT NULL,
	expiry_Date DATE NOT NULL	
);

INSERT INTO Registration_Token (email,token,expiry_Date) VALUES ('delaneylekien@gmail.com','','2023-09-29');
