package pl.kondzierski.shop.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "\"role\"")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();


    @ManyToMany
            @JoinTable(
                    name = "role_permission",
                    joinColumns = @JoinColumn(name="role_id"),
                    inverseJoinColumns = @JoinColumn(name = "permission_id")
            )
    @JsonIgnoreProperties("roles")
    Set<Permission> permissions = new HashSet<>();

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
