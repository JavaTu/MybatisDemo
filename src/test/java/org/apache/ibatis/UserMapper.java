package org.apache.ibatis;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> queryList(Map<String, Object> param);

}
