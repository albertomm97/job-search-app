DELETE FROM categories;

INSERT INTO categories (category_value, category_type) VALUES
('Backend', 'category'), ('Fullstack', 'category'), ('Frontend', 'category'), ('Sysadmin', 'category'), ('Analyst', 'category'),
('Remote', 'type'), ('Hybrid', 'type'), ('Office', 'type'),
('Alicante', 'place'), ('Valencia', 'place'), ('Madrid', 'place'), ('Barcelona', 'place'),
('Nothing', 'study_level'), ('Elementary', 'study_level'), ('High School', 'study_level'), ('Degree', 'study_level'),
('Master', 'study_level'), ('Phd', 'study_level'), ('Full Time', 'work_time'), ('Part Time', 'work_time');

INSERT INTO companies (id, email, name, description) VALUES ('decf33ca-81a7-419f-a07a-74f214e928e5', 'intel@gmail.com', 'Intel', 'Software company');

/*

INSERT INTO offers (id,
                    company_id,
                    title,
                    salary,
                    experience,
                    description,
                    created_at)
              VALUES
                    ('decf33ca-81a7-419f-a07a-74f214eOOOOO',
                     'decf33ca-81a7-419f-a07a-74f214e928e5',
                     'Software Backend Engineer',
                     30000,
                     1,
                     'Backend software engineer using Spring Boot, Hexagonal Architecture and DDD',
                     CURRENT_TIMESTAMP());

INSERT INTO offers_categories
SELECT 'decf33ca-81a7-419f-a07a-74f214eOOOOO' as offer_id, c.id as category_id
FROM offers o, categories c
WHERE c.category_value IN ('Backend', 'Remote', 'Valencia', 'Degree', 'Full Time')
*/
