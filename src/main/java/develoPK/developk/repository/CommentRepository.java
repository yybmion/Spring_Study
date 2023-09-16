package develoPK.developk.repository;


import develoPK.developk.domain.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Comment comment){
        em.persist(comment);
    }

    public List<Comment> findAll(){
        return em.createQuery("select c from Comment c",Comment.class)
                .getResultList();
    }
}
