
CREATE TABLE IF NOT EXISTS companies (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    email VARCHAR(40) UNIQUE NOT NULL,
    name VARCHAR(80) NOT NULL,
    description VARCHAR(2500) NOT NULL
);

CREATE TABLE IF NOT EXISTS offers (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    company_id VARCHAR(36) NOT NULL,
    title VARCHAR(50) NOT NULL,
    company_name VARCHAR(80) NOT NULL,
    category VARCHAR(40) NOT NULL,
    type VARCHAR(40) NOT NULL,
    place VARCHAR(40) NOT NULL,
    salary INT NOT NULL,
    experience INT NOT NULL,
    study_level VARCHAR(40) NOT NULL,
    description VARCHAR(2500) NOT NULL,
    FOREIGN KEY(company_id) REFERENCES companies(id)
);

