package develoPK.developk.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String accountId;

    private String password;

    private String Nickname;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();

    public User(String accountId) {
        this.accountId = accountId;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> userList = new ArrayList<>();

}
