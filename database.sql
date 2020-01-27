CREATE TABLE player (
    id                      INTEGER          PRIMARY KEY AUTOINCREMENT,
    name                    VARCHAR (0, 20)  UNIQUE,
    score                   INTEGER (0, 100),
    [gamecount vs computer] INTEGER (0, 100),
    [gamecount vs player]   INTEGER (0, 100) 
);
///////////
CREATE TABLE game (
    id                  INTEGER          PRIMARY KEY AUTOINCREMENT,
    [vs player name ]   VARCHAR (0, 100),
    [start player name] VARCHAR (0, 100),
    [winner name]       VARCHAR (0, 100),
    datetime            DATE (0, 100),
    recorded            BOOLEAN (0, 10) 
);
///////////
CREATE TABLE [game moves] (
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    xpos      INTEGER,
    ypos      INTEGER,
    [game id] INTEGER REFERENCES game (id) 
);

