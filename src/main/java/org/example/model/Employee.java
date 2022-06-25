package org.example.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "employee")
@Setter
@Getter
@EqualsAndHashCode(of = {"employeeId"})
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @ElementCollection(targetClass = Position.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "emp_position", joinColumns = @JoinColumn(name = "emp_id"))
    @Enumerated(EnumType.STRING)
    private Set<Position> position;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    @OneToOne(mappedBy = "employee")
    private Warehouse warehouse;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getPosition();
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", position=" + position +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", warehouse=" + warehouse +
                '}';
    }
}
