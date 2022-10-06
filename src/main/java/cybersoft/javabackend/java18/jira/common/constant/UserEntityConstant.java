package cybersoft.javabackend.java18.jira.common.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntityConstant {
    @UtilityClass
    public static class User{
        public static final String TABLE_NAME = "J_USER";
        public static final String USERNAME = "J_USERNAME";
        public static final String  PASSWORD= "J_PASSWORD";
        public static final String FULLNAME = "J_FULLNAME";
        public static final String DISPLAY_NAME = "J_DISPLAY_NAME";
        public static final String AVATAR = "J_AVATAR";
        public static final String EMAIL = "J_EMAIL";
        public static final String STATUS = "J_STATUS";
        public static final String FACEBOOK_URL = "J_FACEBOOK_URL";
        public static final String MAJORITY = "J_MAJORITY";
        public static final String DEPARTMENT = "J_DEPARTMENT";
        public static final String HOBBIES = "J_HOBBIES";
    }

    @UtilityClass
    public static class UserGroupMappedUser {
        public static final String GROUP_MAPPED_USER = "users";
        public static final String JOIN_TABLE = "J_GROUP_USER";
        public static final String JOIN_TABLE_GROUP_ID = "J_GROUP_ID";
        public static final String JOIN_TABLE_USER_ID = "J_USER_ID";
    }
}
