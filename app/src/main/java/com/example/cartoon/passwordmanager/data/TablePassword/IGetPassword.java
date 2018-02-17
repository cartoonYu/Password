package com.example.cartoon.passwordmanager.data.TablePassword;

import java.util.List;

/**
 * Created by cartoon on 2018/2/17.
 */

interface IGetPassword {
    List<Password> getList();
    boolean addPassword(Password password);
    boolean updatePassword(Password newPassword,Password oldPassword);
    boolean deletePassword(Password password);
}
