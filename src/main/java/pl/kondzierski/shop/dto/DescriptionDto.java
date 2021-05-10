package pl.kondzierski.shop.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.product.Description;


@Getter
@Setter
public class DescriptionDto {
    private String title;
    private String description;
    private String imagePath;
    private short sequenceNumber;

    public DescriptionDto(Description description){}

    public DescriptionDto() {
    }

    public DescriptionDto(String title, String description, String imagePath, short sequenceNumber) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.sequenceNumber = sequenceNumber;
    }
}
