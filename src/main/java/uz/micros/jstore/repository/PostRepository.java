package uz.micros.jstore.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.jstore.entity.blog.Post;
import uz.micros.jstore.util.DbManager;
import uz.micros.jstore.util.Mapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private class PostMapper extends Mapper<Post>{}

    public void addPost(Post post){
    }

    public Post getPost(int id){
        return null;
    }

    public void savePost(Post post){
    }

    public void deletePost(int id){
    }

    @Transactional
    public List<Post> getPosts() {
        List<Post> res = new ArrayList<>();

        Session session = sessionFactory.getCurrentSession();
        res = session.createQuery("from Post").list();

        return res;
    }

}
