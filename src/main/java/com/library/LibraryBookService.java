package com.library;
import com.library.LibraryBook;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;

@ApplicationScoped

public class LibraryBookService {
	@Inject
    EntityManager entityManager;

    public List<LibraryBook> getAllBooks() {
        Query query = entityManager.createQuery("SELECT b FROM LibraryBook b");
        return query.getResultList();
    }

    public LibraryBook getBookById(Long id) {
        return entityManager.find(LibraryBook.class, id);
    }

    @Transactional
    public void createBook(LibraryBook book) {
        entityManager.persist(book);
    }

    @Transactional
    public LibraryBook updateBook(Long id, LibraryBook book) {
        LibraryBook existingBook = entityManager.find(LibraryBook.class, id);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setYearPublished(book.getYearPublished());
            return existingBook;
        } else {
            throw new WebApplicationException("Book not found", 404);
        }
    }

    @Transactional
    public void deleteBook(Long id) {
        LibraryBook book = entityManager.find(LibraryBook.class, id);
        if (book != null) {
            entityManager.remove(book);
        } else {
            throw new WebApplicationException("Book not found", 404);
        }
    }

}
