DROP TABLE Widget;
 
CREATE TABLE Widget 
(
  ID int primary not null,
  VERSION_ID int not null default 0,
  X_COORD int NOT NULL,
  Y_COORD int NOT NULL,
  Z_COORD int NOT NULL,
  WIDTH int NOT NULL,
  HEIGHT int NOT NULL,
  LAST_UPDATE_TIMESTAMP datetime default getdate() 
);

CREATE INDEX widget_idx ON Widget(ID, Z_COORD);