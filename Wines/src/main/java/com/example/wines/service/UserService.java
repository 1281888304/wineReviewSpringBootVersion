package com.example.wines.service;



import com.example.wines.mapper.UserMapper;
import com.example.wines.pojo.Role;
import com.example.wines.pojo.User;
import com.example.wines.pojo.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService implements UserDetailsService {
  @Autowired
  UserMapper userMapper;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    User user = userMapper.loadUserByUsername(username);
    if(user == null){
      throw new UsernameNotFoundException("account is not existed！");
    }
    user.setRoles(userMapper.getUserRolesByUid(user.getId()));
    return user;
  }
  public String addUserByUsername(UserRegister userRegister){
    User newuser = userMapper.loadUserByUsername(userRegister.getUsername());
    if (newuser != null){
      return "User has been register！";
    }else {
      //新用户密码采用BCryptPasswordEncoder(10)格式存入数据库
      userRegister.setPassword(new BCryptPasswordEncoder(10).encode(userRegister.getPassword()));
      //设置用户状态可用，没有锁定
      userRegister.setEnabled(true);
      userRegister.setLocked(false);
      //执行用户注册
      int adduser = userMapper.addUserByUsername(userRegister);
      //用户成功注册后，添加用户角色
      if(adduser > 0){
        User getuser =userMapper.loadUserByUsername(userRegister.getUsername());
        int addrole = userMapper.addRole(getuser.getId(),userRegister.getRole());
        if (addrole > 0){
          return "Register success";
        }else{
          return "Register Fail";
        }
      }else {
        return "账户注册失败！";
      }
    }
  }
  public List<Role> getAllRole(){
    return userMapper.getAllRole();
  }
}