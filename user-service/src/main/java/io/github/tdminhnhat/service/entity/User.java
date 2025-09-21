package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity @Table(name = "users")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class User extends AbstractEntityProperty {

    private final String USER = "USER";
    private final String ADMIN = "ADMIN";

    @Column(name = "user_id", length = 50, nullable = false, unique = true)
    @NonNull
    private String userId;

    @Column(name = "first_name", length = 100, nullable = false)
    @NonNull
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    @NonNull
    private String lastName;

    @Column(name = "sex", nullable = false)
    @NonNull
    private Boolean sex;

    @Column(name = "birth_date", nullable = false)
    @NonNull
    private LocalDate birthDate;

    @Column(name = "phone_number", length = 30, nullable = false, unique = true)
    @NonNull
    private String phoneNumber;

    @Column(name = "address", length = 400)
    private String address;

    @Column(name = "avatar", length = 500)
    private String avatar;

    @Column(name = "username", length = 100, unique = true, nullable = false)
    @NonNull
    private String username;

    @Column(name = "email", length = 200, unique = true, nullable = false)
    @NonNull
    private String email;

    @Column(name = "password", length = 200, nullable = false)
    @NonNull
    private String password;

    @Column(name = "role", length = 100, nullable = false)
    @NonNull
    private String role;

    @Column(name = "blocking", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    @NonNull
    private Boolean blocking;

    public User(String description, @NonNull String userId, @NonNull String firstName, @NonNull String lastName, @NonNull Boolean sex, @NonNull LocalDate birthDate, @NonNull String phoneNumber, String address, String avatar, @NonNull String username, @NonNull String email, @NonNull String password, @NonNull String role, @NonNull Boolean blocking) {
        super(description);
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.avatar = avatar;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.blocking = blocking;
    }
}
