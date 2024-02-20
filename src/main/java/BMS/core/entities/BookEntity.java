package BMS.core.entities;

import lombok.*;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name="book")
public class BookEntity {
    @Column(name = "title")
    String title;
    @Id
    long isbn;
    @Column(name = "authors")
    String authors;
    @Column(name = "category")
    String category;
    @Column(name = "sellingPrice")
    int sellingPrice;
    @Column(name = "publishDate")
    Date publishDate;
}
