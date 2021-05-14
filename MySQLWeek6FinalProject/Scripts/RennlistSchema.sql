CREATE SCHEMA IF NOT EXISTS rennlist;

USE rennlist;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS forum;
DROP TABLE IF EXISTS forum_post;

CREATE TABLE user(
  userId INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(45) NULL,
  lastName VARCHAR(45) NULL,
  PRIMARY KEY (userId)
 );
  
  CREATE TABLE forum(
  forumId INT NOT NULL AUTO_INCREMENT,
  forumName VARCHAR(45) NOT NULL,
  forumDescript VARCHAR(45) NOT NULL,
  PRIMARY KEY (forumId)
 );
  
  CREATE TABLE forum_post(
  forum_post_Id INT NOT NULL AUTO_INCREMENT,
  forum_post_name VARCHAR(45) NOT NULL,
  forum_post_body text NOT NULL,
  PRIMARY KEY (forum_post_Id)
 );

USE rennlist;
DROP procedure IF EXISTS getUser;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE getUser()
BEGIN
	SELECT * FROM user;
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS getForum;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE getForum()
BEGIN
	SELECT * FROM forum;
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS getForum_post;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE getForum_post()
BEGIN
	select * from forum_post;
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS getUserById;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE getUserById (Id int)
BEGIN
	select * from user
    where userId = Id;
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS getForumById;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE getForumbyId (Id int)
BEGIN
	select * from forum
    where forumId = Id;
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS getForum_PostById;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE getForum_PostById (Id int)
BEGIN
	select * from forum_post
    where forum_post_Id = Id;
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS createUser;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE createUser (fName varchar(45), lName varchar(45))
BEGIN
	insert into user (firstName, lastName)
    values (fName, lName);
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS createForum;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE createForum (fName varchar(45), fDescr varchar(45))
BEGIN
	insert into forum (forumName, forumDescript)
    values (fName, fDescr);
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS createForumPost;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE createForumPost (fpname varchar(45), fpbody text)
BEGIN
	insert into forum_post (forum_Post_Name, forum_post_body)
    values (fpname, fpbody);
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS deleteUser;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE deleteUser (Id int)
BEGIN
	delete from user
    where userId = Id;
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS deleteForum;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE deleteForum (Id int)
BEGIN
	delete from forum
    where ForumId = Id;
END$$

DELIMITER ;

USE rennlist;
DROP procedure IF EXISTS deleteForumPost;

DELIMITER $$
USE rennlist$$
CREATE PROCEDURE deleteForumPost (Id int)
BEGIN
	delete from forum_post
    where forum_post_Id = Id;
END$$

DELIMITER ;

 