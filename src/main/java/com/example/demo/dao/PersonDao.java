package com.example.demo.dao;

import com.example.demo.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/8.
 */
@Repository
public class PersonDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String ,String > valOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void setStr(String key,String val){
        valOpsStr.set(key,val);
    }

    public String getStr(String key){
        return valOpsStr.get(key);
    }

    public void save(Person person){
        valOps.set(person.getId(),person);
    }

    public Person getPerson(String id){
        return (Person) valOps.get(id);
    }

}
