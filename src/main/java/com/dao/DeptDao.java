package com.dao;

import com.dao.provider.DeptDynaSqlProvider;
import com.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import static com.hrm.util.common.HrmConstants.DEPTTABLE;

public interface DeptDao {
    //动态查询
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "selectWithParam")
    List<Dept> selectByPage(Map<String, Object> params);

    //查询总量
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //根据ID查询部门
    @Select("select *from "+DEPTTABLE +"WHERE ID=#{id}")
    Dept selectById(int id);

    //根据id删除部门
    @Delete("delete from "+DEPTTABLE+"WHERE id=#{id}")
    void deleteById(Integer id);

    //动态插入部门
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "insertDept")
    void insertDept(Dept dept);

    //动态修改部门
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "updateDept")
    void updateDept(Dept dept);

}
