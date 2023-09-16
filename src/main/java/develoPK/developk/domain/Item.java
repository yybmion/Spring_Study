package develoPK.developk.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String itemName;

    private int price;

    private String contents; // 상품 설명

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Comment> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<FileUploader> fileUploaders = new ArrayList<>();
}
