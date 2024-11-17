USE library_db;

CREATE TABLE IF NOT EXISTS library_book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(50) NOT NULL,
    year_published INT NOT NULL
);

-- Insert initial data
INSERT INTO library_book (title, author, isbn, year_published)
VALUES
    ('The Catcher in the Rye', 'J.D. Salinger', '9780316769488', 1951),
    ('To Kill a Mockingbird', 'Harper Lee', '9780061120084', 1960),
    ('1984', 'George Orwell', '9780451524935', 1949),
    ('Moby-Dick', 'Herman Melville', '9781503280786', 1851);