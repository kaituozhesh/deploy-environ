package com.ktz.deploy.oauth2.server.configure;

import com.ktz.deploy.oauth2.server.domain.TbPermission;
import com.ktz.deploy.oauth2.server.domain.TbUser;
import com.ktz.deploy.oauth2.server.service.TbPermissionService;
import com.ktz.deploy.oauth2.server.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.assertj.core.util.Lists;
import java.util.List;

/**
 * @Author kaituozhesh
 * @Description 自定义认证授权
 * @Date 10:26 2020/3/18
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getByUsername(s);
        // 需要依赖test
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (tbUser != null) {
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
            tbPermissions.forEach(tbPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                grantedAuthorities.add(grantedAuthority);
            });
            return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
        }
        return null;

    }
}
