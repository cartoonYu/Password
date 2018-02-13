package com.example.cartoon.passwordmanager.data.TablePersonalInformation;

import java.util.List;

/**
 * Created by cartoon on 2018/2/10.
 */

interface IGetInformation {
    boolean addInformation(PersonalInformation information);
    List<PersonalInformation> getInformation();
    boolean updateInformation(PersonalInformation information);
}
