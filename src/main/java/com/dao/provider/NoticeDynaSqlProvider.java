package com.dao.provider;

import com.pojo.Notice;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.hrm.util.common.HrmConstants.NOTICETABLE;

public class NoticeDynaSqlProvider {
    //分页动态查询
    public String selectWithParam(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE("title LIKE CONCAT('%',#{notice.title},'%')");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE("content LIKE CONCAT('%',#{notice.content},'%')");
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
                FROM(NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE("title LIKE CONCAT('%,#{dept.title},'%')");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE("content LIKE CONCAT('%,#{dept.content},'%')");
                    }
                }
            }
        }.toString();
    }

    //动态插入
    public String insertNotice(Notice Notice) {
        return new SQL() {
            {
                INSERT_INTO(NOTICETABLE);
                if (Notice.getTitle() != null && !Notice.getTitle().equals("")) {
                    VALUES("title", "#{title}");
                }
                if (Notice.getContent() != null && !Notice.getContent().equals("")) {
                    VALUES("content", "#{content}");
                }
                if (Notice.getUser() != null && Notice.getUser().getId() != null) {
                    VALUES("user_id", "#{user.id}");
                }
            }
        }.toString();
    }

    //动态更新
    public String updateNotice(Notice notice) {
        return new SQL() {
            {
                UPDATE(NOTICETABLE);
                if (notice.getTitle() != null) {
                    SET("title=#{title}");
                }
                if (notice.getContent() != null) {
                    SET("content=#{content}");
                }
                if (notice.getUser() != null) {
                    SET("user_id=#{user.id}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

}
