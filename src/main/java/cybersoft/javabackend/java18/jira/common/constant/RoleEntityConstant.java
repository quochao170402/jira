package cybersoft.javabackend.java18.jira.common.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleEntityConstant {
    @UtilityClass
    public static class Role{
        public static final String TABLE_NAME = "J_ROLE";
        public static final String NAME = "J_NAME";
        public static final String DESCRIPTION = "J_DESCRIPTION";
        public static final String CODE = "J_CODE";

    }

    @UtilityClass
    public static class UserGroup{
        public static final String TABLE_NAME = "J_GROUP";
        public static final String NAME = "J_NAME";
        public static final String DESCRIPTION = "J_DESCRIPTION";
        public static final String CODE = "J_CODE";

    }

    @UtilityClass
    public static class Operation {
        public static final String TABLE_NAME = "J_OPERATION";
        public static final String NAME = "J_NAME";
        public static final String DESCRIPTION = "J_DESCRIPTION";
        public static final String CODE = "J_CODE";
        public static final String TYPE = "J_TYPE";

    }

    @UtilityClass
    public static class Module{
        public static final String TABLE_NAME = "J_MODULE";
        public static final String NAME = "J_NAME";
        public static final String DESCRIPTION = "J_DESCRIPTION";
        public static final String CODE = "J_CODE";

    }

    @UtilityClass
    public static class RoleMappedOperation {
        public static final String OPERATION_MAPPED_ROLE = "operations";
        public static final String JOIN_TABLE = "J_ROLE_OPERATION";
        public static final String JOIN_TABLE_ROLE_ID = "J_ROLE_ID";
        public static final String JOIN_TABLE_OPERATION_ID = "J_OPERATION_ID";

    }
}
