package develoPK.developk.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import develoPK.developk.domain.Item;
import develoPK.developk.domain.QItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestRepository {

    @PersistenceContext
    EntityManager em;

    public Item itemQuerydsl() {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QItem i = new QItem("i");

        Item findItem = queryFactory
                .selectFrom(i)
                .where(i.id.eq(3L))
                .fetchOne();

        return findItem;
    }

}
