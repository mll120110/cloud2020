package com.atguigu.springcloud.user.service;

import java.util.List;

import com.atguigu.springcloud.user.entity.BdUser;
import com.atguigu.springcloud.user.entity.UserDeviceBean;
import com.atguigu.springcloud.user.vo.UserDeviceVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
public interface IBdUserService extends IService<BdUser> {
    /**
     * 新增用户
     * 
     * @param bdUser
     * @return
     */
    int createUser(BdUser bdUser);

    /**
     * 更新用户信息
     *
     * @param bdUser
     * @return
     */
    int updateUser(BdUser bdUser);

    /**
     * 新增用户、用户与设备绑定关系数据
     *
     * @param userDeviceBean
     * @return
     */
    int createUserAndDevice(UserDeviceBean userDeviceBean);

    /**
     * 获取用户信息
     * 
     * @param userId
     * @return
     */
    BdUser getUser(String userId);

    /**
     * 获取用户列表信息
     * 
     * @param startPage
     * @param endPage
     * @return
     */
    IPage<BdUser> getUserList(int startPage, int endPage);

    /**
     * getUserInfo
     * 
     * @return
     */
    BdUser getUserInfo();

    List<BdUser> getUserInfoTwo();

    /**
     * 根据关联关系获取用户与设备的信息
     * 
     * @return
     */
    List<UserDeviceVO> getUserBeanList(String userId);
}
