package pl.kondzierski.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.order.Order;
import pl.kondzierski.shop.model.order.ShippingAddress;
import pl.kondzierski.shop.model.security.Role;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Timestamp created;
    private Timestamp updated;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Order> order = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name="shipping_address",
            joinColumns = @JoinColumn(name="user_id")
    )
    private Set<ShippingAddress> shippingAddress = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", role=" + role +
                '}';
    }
}
