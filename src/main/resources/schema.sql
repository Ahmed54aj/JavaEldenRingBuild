-- Create playerCharacter table
CREATE TABLE IF NOT EXISTS playerCharacter (
    name VARCHAR(255) NOT NULL,
    buildType VARCHAR(255),
    level INT,
    strength INT,
    dexterity INT,
    intelligence INT,
    faith INT,
    arcane INT,
    vigor INT,
    endurance INT,
    mind INT,
    weapon VARCHAR(255),
    armor VARCHAR(255),
    shield VARCHAR(255),
    talisman VARCHAR(255),
    PRIMARY KEY (name)
);