package uz.micros.jstore.repository;

import org.springframework.stereotype.Service;
import uz.micros.jstore.entity.blog.Post;
import uz.micros.jstore.util.DbManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PostRepository {
    public void addPost(Post post){

    }

    public Post getPost(int id){
        return null;
    }

    public void savePost(Post post){

    }

    public void deletePost(int id){

    }

    public List<Post> getPosts() {
        List<Post> res = new ArrayList<>();
        List<Map<String, Object>> list = DbManager.runQuery("select * from \"Posts\"");

        for(Map<String, Object> item : list){
            Post p = new Post();

            p.setId((Integer)item.get("Id"));
            p.setSubject((String) item.get("Subject"));
            p.setDate((Date) item.get("Date"));
            p.setText((String) item.get("Text"));

            res.add(p);
        }

        return res;
    }
}
