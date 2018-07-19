CREATE TABLE tutor (
  tutor_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  tutor_name VARCHAR(100) NOT NULL,
  tutor_ape_paterno VARCHAR(100) NOT NULL,  
  dni	VARCHAR(100) NOT NULL,
  phone VARCHAR(100) NOT NULL, 
  state_value VARCHAR(100) NOT NULL,  
  userid BIGINT UNSIGNED ,
  PRIMARY KEY (tutor_id),
  CONSTRAINT FK_user FOREIGN KEY (userid) REFERENCES user(user_id) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;




