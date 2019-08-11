package com.dao.provider;

import com.pojo.Document;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.hrm.util.common.HrmConstants.DOCUMENTTABLE;

public class DocumentSqlProvider {
    //分页动态查询
    public String selectWithParam(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE("title LIKE CONCAT('%',#{document.title},'%')");
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
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE("title LIKE CONCAT('%,#{document.title},'%')");
                    }
                }
            }
        }.toString();
    }

    //动态插入
    public String insertDocument(Document document) {
        return new SQL() {
            {
                INSERT_INTO(DOCUMENTTABLE);
                if (document.getTitle() != null && !document.getTitle().equals("")) {
                    VALUES("title", "#{title}");
                }
                if (document.getFileName() != null && !document.getFileName().equals("")) {
                    VALUES("filename", "#{filename}");
                }
                if (document.getRemark() != null && !document.getRemark().equals("")) {
                    VALUES("remark", "#{remark}");
                }
                if (document.getUser() != null && document.getUser().getId() != null) {
                    VALUES("user_id", "#{user.id}");
                }
            }
        }.toString();
    }

    //动态更新
    public String updateDocument(Document document) {
        return new SQL() {
            {
                UPDATE(DOCUMENTTABLE);
                if (document.getTitle() != null) {
                    SET("title=#{title}");
                }
                if (document.getFileName() != null) {
                    SET("filename=#{filename}");
                }
                if (document.getRemark() != null) {
                    SET("remark=#{remark}");
                }
                if (document.getUser() != null) {
                    SET("user_id=#{user.id}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
