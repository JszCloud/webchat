package com.bs.project.consumer.service;

import com.bs.project.consumer.model.Resource;

import java.util.List;

/**
 * Created by Nominal on 2018/3/22 0022.
 * 微博：@Mr丶Li_Anonym
 */
public interface ResourceService {
    /**
     * 查询所有
     * @return
     */
    List<Resource> findAll();

    /**
     * 根据
     * @param userName
     * @return
     */
    List<Resource> findByUserId(String userName);


}
