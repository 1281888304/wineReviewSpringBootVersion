package com.example.wines.mapper;



import com.example.wines.pojo.Role;
import com.example.wines.pojo.User;
import com.example.wines.pojo.UserRegister;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface UserMapper {

  User loadUserByUsername(String username);

  List<Role> getUserRolesByUid(Integer id);

  int addUserByUsername(UserRegister userRegister);

  List<Role> getAllRole();

  int addRole(Integer uid, Integer rid);

}
