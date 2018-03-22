package com.bs.project.consumer.service.impl;

import com.bs.project.consumer.dao.ResourceDao;
import com.bs.project.consumer.model.Resource;
import com.bs.project.consumer.model.SysRole;
import com.bs.project.consumer.service.ResourceService;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

/**
 * Created by Nominal on 2018/3/22 0022.
 * 微博：@Mr丶Li_Anonym
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceDao resourceDao;

    @Autowired
    UserService userService;

    /**
     * 根据
     *
     * @param userName
     * @return
     */
    @Override
    public List<Resource> findByUserId(String userName) {
        Long resid=null;
        //根据传入的用户名 查询出角色id
        Long rid=userService.findAll(userName).getSysRoles().get(0).getId();
        System.out.println("rid:"+rid);
        Resource resource=new Resource();
        List<Resource> res=resourceDao.findAll();
        for (Resource re : res) {
            List<SysRole> role=re.getSysRoles();
            resid=re.getId();
            for (SysRole sysRole : role) {
                Long did=sysRole.getId();
                System.out.println("did:"+did);
                if (rid==did){
                    break;
                }
            }
        }

        System.out.println();
        return resourceDao.findAllByIdEquals(resid);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Resource> findAll() {
        return resourceDao.findAll();
    }
}
