
CREATE TABLE User_Photo (
                PhotoId INT AUTO_INCREMENT NOT NULL,
                Photo LONGBLOB NOT NULL,
                PRIMARY KEY (PhotoId)
);


CREATE TABLE Reminder (
                ReminderId INT NOT NULL,
                userID INT NOT NULL,
                Notes VARCHAR(500),
                PRIMARY KEY (ReminderId)
);


CREATE TABLE Shopping_List (
                ListId INT AUTO_INCREMENT NOT NULL,
                List_Name VARCHAR(20) NOT NULL,
                Items VARCHAR(25) NOT NULL,
                PRIMARY KEY (ListId)
);


CREATE TABLE JobList (
                JobId INT AUTO_INCREMENT NOT NULL,
                Notes VARCHAR(500) NOT NULL,
                JobName VARCHAR(40) NOT NULL,
                Job_Description VARCHAR(100) NOT NULL,
                ReminderId INT NOT NULL,
                Deadline VARCHAR(35) NOT NULL,
                PRIMARY KEY (JobId)
);


CREATE TABLE Users (
                UserId INT AUTO_INCREMENT NOT NULL,
                UserName VARCHAR(20) NOT NULL,
                ReminderId INT NOT NULL,
                PhotoId INT NOT NULL,
                JobId INT NOT NULL,
                ListId INT NOT NULL,
                PRIMARY KEY (UserId)
);


CREATE TABLE Calender (
                CalenderId INT NOT NULL,
                Appointments VARCHAR(40) NOT NULL,
                Classes VARCHAR(50) NOT NULL,
                UserId INT NOT NULL,
                Reminder VARCHAR(100) NOT NULL,
                ReminderId INT NOT NULL,
                Special_Events VARCHAR(100),
                PRIMARY KEY (CalenderId)
);


CREATE TABLE Location (
                LocationId INT AUTO_INCREMENT NOT NULL,
                Location_Name VARCHAR(30) NOT NULL,
                CalenderId INT NOT NULL,
                ListId INT NOT NULL,
                PRIMARY KEY (LocationId)
);


ALTER TABLE Users ADD CONSTRAINT user_photo_users_fk
FOREIGN KEY (PhotoId)
REFERENCES User_Photo (PhotoId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Users ADD CONSTRAINT reminders_users_fk
FOREIGN KEY (ReminderId)
REFERENCES Reminder (ReminderId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Calender ADD CONSTRAINT reminders_calender_fk
FOREIGN KEY (ReminderId)
REFERENCES Reminder (ReminderId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE JobList ADD CONSTRAINT reminders_joblist_fk
FOREIGN KEY (ReminderId)
REFERENCES Reminder (ReminderId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Location ADD CONSTRAINT shopping_list_location_fk
FOREIGN KEY (ListId)
REFERENCES Shopping_List (ListId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Users ADD CONSTRAINT shopping_list_users_fk
FOREIGN KEY (ListId)
REFERENCES Shopping_List (ListId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Users ADD CONSTRAINT joblist_users_fk
FOREIGN KEY (JobId)
REFERENCES JobList (JobId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Calender ADD CONSTRAINT users_calender_fk
FOREIGN KEY (UserId)
REFERENCES Users (UserId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Location ADD CONSTRAINT calender_location_fk
FOREIGN KEY (CalenderId)
REFERENCES Calender (CalenderId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
