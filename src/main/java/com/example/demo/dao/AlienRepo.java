package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien,Integer> {

   /* List<Alien>  findByLang(String tech);

    List<Alien>  findByAidGreaterThan(int i);

    @Query("from Alien where lang=?1 order by aname")
    List<Alien> findByLangSorted(String tech);*/
}
