package BMS.dto;

//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class BookDTO {
    String title;
    @Positive long isbn;
    String authors; //TODO: change to author class object
    String category; //TODO: enum
    @PositiveOrZero int sellingPrice;
    Date publishDate;

//    public void setPublishDate(Date publishDate){
//        if(publishDate.compareTo(new Date())>0){
//            this.publishDate = publishDate;
//        }
//        return;
//    }

}
