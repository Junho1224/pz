package com.von.api.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.von.api.common.command.CommandService;
import com.von.api.common.component.MessengerVO;
import com.von.api.common.query.QueryService;

public interface UserService extends CommandService, QueryService{
   
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
    String updatePassword(User user);


   


}
