package com.zhengdf.module.sys.repository;

import com.zhengdf.domain.sys.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/24 0:07
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<SysUser,Long> {

    SysUser findSysUserByUsernameAndStatus(String username, Integer status);
}
