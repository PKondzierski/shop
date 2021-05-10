package pl.kondzierski.shop.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
public class Description {

    private String title;
    private String description;
    private String imagePath;
    @Column(name = "sequence_number")
    private short sequenceNumber;

}
