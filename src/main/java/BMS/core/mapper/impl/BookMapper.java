package BMS.core.mapper.impl;

import BMS.core.entities.BookEntity;
import BMS.core.mapper.Mapper;
import BMS.dto.BookDTO;

public class BookMapper implements Mapper<BookDTO,BookEntity> {

    @Override
    public BookEntity DTOtoEntity(BookDTO dto) {
        return new BookEntity(dto.getTitle(),dto.getIsbn(),dto.getAuthors(),dto.getCategory(),dto.getSellingPrice(),dto.getPublishDate());
    }

    @Override
    public BookDTO entityToDTO(BookEntity entity) {
        return new BookDTO(entity.getTitle(),entity.getIsbn(),entity.getAuthors(),entity.getCategory(),entity.getSellingPrice(),entity.getPublishDate());
    }
}
