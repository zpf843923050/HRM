package com.dao;

import com.dao.provider.DocumentSqlProvider;
import com.pojo.Document;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static com.hrm.util.common.HrmConstants.DOCUMENTTABLE;

public interface DocumentDao {
    //分页动态查询
    @SelectProvider(type = DocumentSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "CREATE_DATE", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "USER_ID", property = "user",
                    one = @One(select = "com.dao.UserDao.selectById", fetchType = FetchType.EAGER))})
    List<Document> selectByPage(Map<String, Object> params);

    //统计
    @SelectProvider(type = DocumentSqlProvider.class, method = "count")
    void count(Map<String, Object> params);

    //根据id查询
    @Select("select *from " + DOCUMENTTABLE + "where id=#{id}")
    Document selectById(int id);

    //动态插入文档
    @SelectProvider(type = DocumentSqlProvider.class, method = "insertDocument")
    void save(Document document);

    //根据id删除
    @Delete("delete from " + DOCUMENTTABLE + "where id=#{id}")
    void deleteById(Integer id);

    //动态修改文档
    @SelectProvider(type = DocumentSqlProvider.class, method = "updateDocument")
    void update(Document document);
}
