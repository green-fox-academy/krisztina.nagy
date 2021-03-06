CREATE DATABASE TodoApp;
CREATE TABLE apprentice (
aID INTEGER PRIMARY KEY AUTO_INCREMENT,
firstname VARCHAR(255) NOT NULL, 
lastname VARCHAR(255) NOT NULL
);
CREATE TABLE task(
tID INTEGER PRIMARY KEY AUTO_INCREMENT, 
taskName VARCHAR(255) NOT NULL, 
deadline DATETIME, 
state ENUM('ToDo', 'Doing', 'Review', 'Done') DEFAULT 'ToDo'
);
CREATE TABLE taskOwner (
oID INTEGER PRIMARY KEY AUTO_INCREMENT,
aID INT NOT NULL,
tID INT NOT NULL,
FOREIGN KEY (aID) REFERENCES apprentice (aID), 
FOREIGN KEY (tID) REFERENCES task (tID)
);
