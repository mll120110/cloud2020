package com.atguigu.springcloud.user.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.atguigu.springcloud.user.entity.UserDeviceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.springcloud.user.entity.BdUser;
import com.atguigu.springcloud.user.mapper.BdUserMapper;
import com.atguigu.springcloud.user.service.IBdUserService;
import com.atguigu.springcloud.user.vo.UserDeviceVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
@Slf4j
@Service(value = "bdUserServiceImpl")
public class BdUserServiceImpl extends ServiceImpl<BdUserMapper, BdUser> implements IBdUserService {

    @Autowired
    BdUserMapper bdUserMapper;


    /**
     * 新增用户
     *
     * @param bdUser
     * @return
     */
    public int createUser(BdUser bdUser) {
        int result;
        if (bdUser.getUserId() == null) {
            result = bdUserMapper.insert(bdUser);
        } else {
            result = this.updateUser(bdUser);
        }
        return result;
    }



    /**
     * 更新用户信息
     *
     * @param bdUser
     * @return
     */
    @Override
    public int updateUser(BdUser bdUser) {
        return bdUserMapper.update(bdUser, null);
    }

    /**
     * 新增用户、用户与设备绑定关系数据
     * 
     * @param userDeviceBean
     * @return
     */
    @Override
    @Transactional
    public int createUserAndDevice(UserDeviceBean userDeviceBean) {
        return 0;
    }

    /**
     * 获取用户信息
     * 
     * @param userId
     * @return
     */
    @Override
    public BdUser getUser(String userId) {
        QueryWrapper<BdUser> entityWrapper = new QueryWrapper<>();
        entityWrapper.eq("user_id", userId);
        entityWrapper.eq("state", 1);
        return bdUserMapper.selectOne(entityWrapper);
    }

    /**
     * 获取用户列表信息
     * 
     * @param startPage
     * @param endPage
     * @return
     */
    @Override
    public IPage<BdUser> getUserList(int startPage, int endPage) {
        Page<BdUser> page = new Page<>(startPage, endPage);
        QueryWrapper<BdUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", 1);
        return bdUserMapper.selectPage(page, queryWrapper);
    }

    @Override
    public BdUser getUserInfo() {
        return bdUserMapper.getUserInfo();
    }

    @Override
    public List<BdUser> getUserInfoTwo() {
        return bdUserMapper.getUserInfoTwo();
    }

    @Override
    public List<UserDeviceVO> getUserBeanList(String userId) {
        // 1.根据用户信息关联关系表，关系表中关联设备信息，实际上是以关系表为主，去关联用户与设备
        return bdUserMapper.getUserBeanList(userId);
    }
}
