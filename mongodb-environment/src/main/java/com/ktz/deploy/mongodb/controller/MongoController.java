package com.ktz.deploy.mongodb.controller;

import com.ktz.deploy.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;


/**
 * ClassName: MongoController
 * Description:
 * date: 2020/3/15 19:56
 *
 * @author kaituozhe_sh
 */
@RestController
public class MongoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/get_all")
    public Object getAll() {
        return mongoTemplate.findAll(User.class);
    }

    @PostMapping("/add")
    public Object add(@RequestBody User user) {
        if (user.getId() == null) {
            return mongoTemplate.insert(user, "user");
        } else {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(user.getId()));

            Update update = new Update();
            update.set("name", user.getName());
            update.set("age", user.getAge());

            return mongoTemplate.updateFirst(query, update, "user");
        }
    }

    @PostMapping("/delete/{id}")
    public Object delete(@PathVariable String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        return mongoTemplate.remove(query, User.class, "user");
    }
}
