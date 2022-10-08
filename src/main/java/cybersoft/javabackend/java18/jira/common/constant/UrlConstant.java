package cybersoft.javabackend.java18.jira.common.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UrlConstant {
    public static final String BASE_URL = "/api";
    public static final String VERSION = "/v1";
    public static final String ROLE_URL = BASE_URL + VERSION + "/roles";
    public static final String OPERATION_URL = BASE_URL + VERSION + "/operations";
    public static final String USER_URL = BASE_URL + VERSION + "/users";
    public static final String USER_GROUP_URL = BASE_URL + VERSION + "/group-users";
    public static final String AUTH_URL = BASE_URL + VERSION + "/auth";
}
