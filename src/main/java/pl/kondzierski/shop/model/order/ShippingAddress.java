package pl.kondzierski.shop.model.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Table(name = "shipping_address")
@Getter
@Setter
public class ShippingAddress {

    private String firstname;
    private String lastname;
    private String street;
    @Column(name="house_number")
    private String houseNumber;
    @Column(name="flat_number")
    private String flatNumber;
    private String city;
    @Column(name="postal_code")
    private String postalCode;
    private String email;
    private String phone;

}
