package uz.micros.jstore.repository;

import org.springframework.stereotype.Service;
import uz.micros.jstore.entity.blog.Post;
import uz.micros.jstore.util.DbManager;
import uz.micros.jstore.util.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostRepository {
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

    public List<Post> getPosts() {
        List<Post> res = new ArrayList<>();
        List<Map<String, Object>> list = DbManager.runQuery("select * from \"Posts\"");

        for(Map<String, Object> item : list){
            Post p = new PostMapper().map(item);

            res.add(p);
        }

        return res;
    }

}
