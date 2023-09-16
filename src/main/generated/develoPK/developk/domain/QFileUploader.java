package develoPK.developk.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFileUploader is a Querydsl query type for FileUploader
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileUploader extends EntityPathBase<FileUploader> {

    private static final long serialVersionUID = -2033680108L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFileUploader fileUploader = new QFileUploader("fileUploader");

    public final StringPath fileFullName = createString("fileFullName");

    public final StringPath filename = createString("filename");

    public final StringPath fileOriName = createString("fileOriName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QItem item;

    public QFileUploader(String variable) {
        this(FileUploader.class, forVariable(variable), INITS);
    }

    public QFileUploader(Path<? extends FileUploader> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFileUploader(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFileUploader(PathMetadata metadata, PathInits inits) {
        this(FileUploader.class, metadata, inits);
    }

    public QFileUploader(Class<? extends FileUploader> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.item = inits.isInitialized("item") ? new QItem(forProperty("item"), inits.get("item")) : null;
    }

}

