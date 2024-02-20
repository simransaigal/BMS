package BMS.core.controller;

import BMS.core.repository.BookDAO;
import BMS.core.service.ServiceInterface;
import BMS.core.service.impl.BookService;
import BMS.dto.*;
import org.jdbi.v3.core.Jdbi;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final ServiceInterface<BookDTO> service;
    public BookResource(BookDAO dao) {
        this.service = new BookService(dao);
    }
//
//    @GET
//    public Response getBooks(){
//        return Response.ok(clientEndpoint).build();
//    }

    @GET
    @Path("/books")
    public List<BookDTO> getBooks(){
        return service.get();
    }

    @POST
    public BookDTO addBook(@Valid BookDTO book){
        return service.add(book);
    }

    @PUT
    public BookDTO updateBook(BookDTO book){
        return service.update(book);
    }

    @DELETE
    public BookDTO deleteBook(BookDTO book){
        return service.delete(book);
    }
}
