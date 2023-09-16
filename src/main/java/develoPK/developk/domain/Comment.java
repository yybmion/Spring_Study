package develoPK.developk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * 연관관계 편의 메서드
     */
    public void setItem(Item item){
        this.item=item;
        item.getOrderList().add(this);
    }

    public void setUser(User user){
        this.user=user;
        user.getUserList().add(this);
    }
    /**
     * 생성 메소드
     */
    public static Comment createComment(Item item){
        Comment comment = new Comment();
        comment.setItem(item);
        return comment;
    }

}
