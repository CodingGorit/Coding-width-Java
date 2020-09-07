package cn.gorit.dao;

import cn.gorit.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    // �����û����˺ź������ѯ, ���صĵ��û����˻���Ϣ
    public User selectUserByNameAndPwd(String username, String password);

    // �����û�
    public int addUser(User u);

    // �����û�����
    public int updateUser(User u);

    //ɾ���û�����
    public void deleteUserById(int id);

    public ArrayList<User> queryAllUser();
}
