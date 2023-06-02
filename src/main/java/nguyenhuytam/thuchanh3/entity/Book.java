package nguyenhuytam.thuchanh3.entity;
import nguyenhuytam.thuchanh3.Validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Generated;
import nguyenhuytam.thuchanh3.Validator.annotation.ValidCategoryId;
import nguyenhuytam.thuchanh3.Validator.annotation.ValidUsername;
import org.hibernate.MappingException;
import org.hibernate.service.spi.InjectService;

import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "title")
    @NotEmpty(message = "Title must be less than 50 characters")
    @Size(max = 50,min = 1,message = "Title must be less than 50 characters")
    private String title;

    @Column(name= "author")
    private String author;

    @Column(name= "price")
    @NotNull(message = "Price is required")
    private String price;

@ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;
@ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ValidUserId
    private User user;

}
