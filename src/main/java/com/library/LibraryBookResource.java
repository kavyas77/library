package com.library;

import com.library.LibraryBook;
import com.library.LibraryBookService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class LibraryBookResource {
	@Inject
    LibraryBookService libraryBookService;

    @GET
    public List<LibraryBook> getAllBooks() {
        return libraryBookService.getAllBooks();
    }

    @GET
    @Path("/{id}")
    public LibraryBook getBookById(@PathParam("id") Long id) {
        return libraryBookService.getBookById(id);
    }

    @POST
    @Transactional
    public Response createBook(LibraryBook book) {
        libraryBookService.createBook(book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public LibraryBook updateBook(@PathParam("id") Long id, LibraryBook book) {
        return libraryBookService.updateBook(id, book);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteBook(@PathParam("id") Long id) {
        libraryBookService.deleteBook(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
	

}
