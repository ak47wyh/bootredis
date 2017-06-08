package com.example.demo.web;

import com.example.demo.dao.PersonDao;
import com.example.demo.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/8.
 */
@RestController
public class PersonControll {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/set")
    public String set(){
        Person person = new Person("1","wang",1);
        personDao.save(person);
        return "ok";
    }

    @RequestMapping("/setStr")
    public String  setStr(String key,String val){
        personDao.setStr(key,val);
        return "ok";
    }

    @RequestMapping("/get")
    public String get(String key){
        return personDao.getStr(key);
    }

    @RequestMapping("/getPerson")
    public Person getPerson(String key){
        return personDao.getPerson(key);
    }
}
