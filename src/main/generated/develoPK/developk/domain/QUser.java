package develoPK.developk.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1166957269L;

    public static final QUser user = new QUser("user");

    public final StringPath accountId = createString("accountId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Item, QItem> itemList = this.<Item, QItem>createList("itemList", Item.class, QItem.class, PathInits.DIRECT2);

    public final StringPath Nickname = createString("Nickname");

    public final StringPath password = createString("password");

    public final ListPath<Comment, QComment> userList = this.<Comment, QComment>createList("userList", Comment.class, QComment.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

