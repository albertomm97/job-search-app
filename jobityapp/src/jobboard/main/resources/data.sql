INSERT INTO offer_category (category) VALUES ('Backend'), ('Fullstack'), ('Frontend'), ('Sysadmin'), ('Analyst');
INSERT INTO offer_type (type) VALUES ('Remote'), ('Hybrid'), ('Office');
INSERT INTO offer_place (place) VALUES ('Alicante'), ('Valencia'), ('Madrid'), ('Barcelona');
INSERT INTO offer_study_level (study) VALUES ('Nothing'), ('Elementary'), ('High School'), ('Degree'), ('Master'), ('Phd');
INSERT INTO offer_work_time (work_time) VALUES ('full-time'), ('part-time');

INSERT INTO companies (id, email, name, description) VALUES ('decf33ca-81a7-419f-a07a-74f214e928e5', 'intel@gmail.com', 'Intel', 'Software company');

INSERT INTO offers (id,
                    company_id,
                    title,
                    category,
                    type,
                    place,
                    study_level,
                    work_time,
                    salary,
                    experience,
                    description,
                    created_at)
              VALUES
                    ('decf33ca-81a7-419f-a07a-74f214e928e5',
                     'decf33ca-81a7-419f-a07a-74f214e928e5',
                     'Software Backend Engineer',
                     1,
                     1,
                     1,
                     4,
                     1,
                     30000,
                     1,
                     'Backend software engineer using Spring Boot, Hexagonal Architecture and DDD',
                     CURRENT_TIMESTAMP());
