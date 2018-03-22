package com.bs.project.consumer.dao;

import com.bs.project.consumer.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Nominal on 2018/3/22 0022.
 * 微博：@Mr丶Li_Anonym
 */
public interface ResourceDao extends JpaRepository<Resource,Long> {
    List<Resource> findAllByIdEquals(Long id);


}
