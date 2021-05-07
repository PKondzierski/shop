package pl.kondzierski.shop.model.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "permission_name")
    private String permissionName;

    @ManyToMany(mappedBy = "permissions")
    Set<Role> roles = new HashSet<>();


    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", parmissionName='" + permissionName + '\'' +
                '}';
    }
}
