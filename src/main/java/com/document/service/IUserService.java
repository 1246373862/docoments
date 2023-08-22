package com.document.service;

import com.document.auth.PermissionEnum;
import com.document.entity.User;
import com.document.entity.dto.BasePageDTO;
import com.document.entity.dto.RegistryUserDTO;
import com.document.entity.dto.UserRoleDTO;
import com.document.util.BaseApiResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author hangfeng.ying
 */
public interface IUserService {

    void initFirstUser();

    BaseApiResult login(RegistryUserDTO userDTO);

    BaseApiResult registry(RegistryUserDTO userDTO);

    /**
     * @Author yinghangfeng
     * @Description 查询用户列表
     * @Date 21:36 2023/1/10
     * @Param [pageDTO]
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult getUserList(BasePageDTO pageDTO);

    BaseApiResult changeUserRole(UserRoleDTO userRoleDTO);

    /**
     * @Author yinghangfeng
     * @Description 屏蔽掉某个用户
     * @Date 21:37 2023/1/10
     * @Param [userId]
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult blockUser(String userId);

    User queryById(String userId);

    boolean checkPermissionForUser(User user, PermissionEnum[] permissionEnums);

    /**
     * @Author yinghangfeng
     * @Description 上传用户的头像信息
     * @Date 22:26 2023/1/12
     * @Param []
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult uploadUserAvatar(String userId, MultipartFile file);

    /**
     * Deleting a user profile picture
     * @param userId user index
     * @return BaseApiResult
     */
    BaseApiResult removeUserAvatar(String userId);

    /**
     * remove user entity
     * @param userId user index
     * @return BaseApiResult
     */
    BaseApiResult removeUser(String userId);

    /**
     * Remove user entities in batches
     * @param userIdList user index
     * @param adminUserId administrator index
     * @return BaseApiResult
     */
    BaseApiResult deleteUserByIdBatch(List<String> userIdList, String adminUserId);

    Map<String, String> queryUserAvatarBatch(List<String> userIdList);

    /**
     * @Author yinghangfeng
     * @Description 重置密码
     * @Date 20:08 2023/5/3
     * @Param [userId, adminId] 被充值的用户id， 管理者的id
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult resetUserPwd(String userId, String adminId);

}
