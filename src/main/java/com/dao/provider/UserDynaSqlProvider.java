package com.dao.provider;

import com.pojo.User;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;
import com.sun.org.apache.regexp.internal.RE;
import javafx.beans.binding.ObjectExpression;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.test.context.jdbc.Sql;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

import static com.hrm.util.common.HrmConstants.NOTICETABLE;
import static com.hrm.util.common.HrmConstants.USERTABLE;

public class UserDynaSqlProvider {
    //分页动态查询
    public String selectWithParam(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getUsername() != null && !user.getUsername().equals("")) {
                        WHERE("username Like CONCAT ('%',#{user.username},'%')");
                    }
                    if (user.getStatus() != null && !user.getStatus().equals("")) {
                        WHERE("status LIKE CONCAT('%',#{user.status},'%')");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += "limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
        }
        return sql;
    }

    //动态查询总数量
    public String count(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM(USERTABLE);
                User user = (User) params.get("user");
                if (params.get("user") != null && !params.get("user").equals("")) {
                    WHERE("username LIKE CONCAT('%',#{user.username},'%')");
                }
                if (user.getStatus() != null && !user.getStatus().equals("")) {
                    WHERE("status LIKE CONCAT('%',#{user.status},'%')");
                }
            }
        }.toString();
    }

    //动态插入
    public String insertUser(User user) {
        return new SQL() {
            {
                INSERT_INTO(USERTABLE);
                if (user.getUsername() != null && !user.getUsername().equals("")) {
                    VALUES("username", "#{username}");
                }
                if (user.getStatus() != null && !user.getStatus().equals("")) {
                    VALUES("status", "#{status}");
                }
                if (user.getPassword() != null && !user.getPassword().equals("")) {
                    VALUES("password", "#{password}");
                }
            }
        }.toString();
    }

    //动态更新
    public String updateUser(User user) {
        return new SQL() {
            {
                UPDATE(USERTABLE);
                if (user.getUsername() != null) {
                    SET("username=#{username}");
                }
                if (user.getLoginname() != null) {
                    SET("loginname=#{loginname}");
                }
                if (user.getPassword() != null) {
                    SET("password=#{password}");
                }
                if (user.getStatus() != null) {
                    SET("status=#{status}");
                }
                if (user.getCreateDate() != null) {
                    SET("create_date=#{createDate}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
