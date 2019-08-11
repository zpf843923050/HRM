package com.dao;

import com.dao.provider.JobDynaSqlProvider;
import com.pojo.Job;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.omg.PortableInterceptor.INACTIVE;
import sun.rmi.log.LogInputStream;

import java.util.List;
import java.util.Map;

import static com.hrm.util.common.HrmConstants.JOBTABLE;

public interface JobDao {
    //根据id查询
    @Select("SELECT *FROM " + JOBTABLE + "WHERE ID=#{id}")
    Job selectById(int id);

    //查询所有job
    @Select("SELECT *FROM" + JOBTABLE)
    List<Job> selectAllJob();

    //动态查询
    @SelectProvider(type = JobDynaSqlProvider.class, method = "selectWithParam")
    List<Job> selectByParam(Map<String, Object> params);

    //统计数量
    @SelectProvider(type = JobDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //根据id删除职务
    @Delete("delete from " + JOBTABLE + "where id=#{id}")
    void deleteById(Integer id);

    //动态插入职务
    @SelectProvider(type = JobDynaSqlProvider.class, method = "insertJob")
    void save(Job job);

    //动态修改职务
    @SelectProvider(type = JobDynaSqlProvider.class, method = "updateJob")
    void update(Job job);


}
