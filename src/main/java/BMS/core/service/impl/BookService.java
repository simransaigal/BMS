package BMS.core.service.impl;

import BMS.core.entities.BookEntity;
import BMS.core.mapper.Mapper;
import BMS.core.mapper.impl.BookMapper;
import BMS.core.repository.BookDAO;
import BMS.core.repository.RepositoryInterface;
import BMS.core.repository.impl.BookRepository;
import BMS.core.service.ServiceInterface;
import BMS.dto.BookDTO;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.stream.Collectors;

public class BookService implements ServiceInterface<BookDTO> {

    private final Mapper<BookDTO,BookEntity> mapper;
    private final RepositoryInterface<BookEntity> repository;
    public BookService(BookDAO dao) {
        this.mapper = new BookMapper();
        this.repository = new BookRepository(dao);
    }
    public List<BookDTO> get() {
        List<BookEntity> books = repository.get();
        return books
                .stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO add(BookDTO dto){
        BookEntity addedBook = repository.add(mapper.DTOtoEntity(dto));
        return mapper.entityToDTO(addedBook);
    }

    public BookDTO update(BookDTO dto){
        BookEntity updatedBook = repository.update(mapper.DTOtoEntity(dto));
        return mapper.entityToDTO(updatedBook);
    }

    public BookDTO delete(BookDTO dto){
        BookEntity deletedBook = repository.delete(mapper.DTOtoEntity(dto));
        return mapper.entityToDTO(deletedBook);
    }
}
