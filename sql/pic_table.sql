CREATE TABLE pic_table (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           url VARCHAR(255) NOT NULL,
                           poi_id INT NOT NULL
);
INSERT INTO pic_table (url, poi_id) VALUES ('http://example.com/image1.jpg', 1);
INSERT INTO pic_table (url, poi_id) VALUES ('http://example.com/image3.jpg', 1);