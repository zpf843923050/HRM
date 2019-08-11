package com.service;

import com.hrm.util.tag.PageModel;
import com.pojo.*;
import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.util.List;

public interface HrmService {
    /**
     * 用户登录
     *
     * @param loginname
     * @param password
     * @return User对象
     */
    User login(String loginname, String password);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return 返回User对象
     */
    User findUserById(Integer id);

    /**
     * 获取所有用户
     *
     * @param user
     * @param pageModel
     * @return 返回User的List集合
     */
    List<User> findUser(User user, PageModel pageModel);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    void removeUserById(Integer id);

    /**
     * 修改用户
     *
     * @param user 用户对象
     */
    void modifyUser(User user);

    /**
     * 添加用户
     *
     * @param user 用户对象
     */
    void addUser(User user);

    /**
     * 获取所有员工
     *
     * @param employee  查询条件
     * @param pageModel 分页对象
     * @return 返回员工的List集合
     */
    List<Employee> findEmployee(Employee employee, PageModel pageModel);

    /**
     * 根据id删除员工
     *
     * @param id
     */
    void removeEmployeeById(Integer id);

    /**
     * 根据id查询员工
     *
     * @param id
     * @return 返回员工对象
     */
    Employee findEmployee(Integer id);

    /**
     * 添加员工
     *
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     * 修改员工
     *
     * @param employee
     */
    void modifyEmployee(Employee employee);

    /**
     * 获取所有部门,分页查询
     *
     * @param dept
     * @param pageModel
     * @return 返回部门List集合
     */
    List<Dept> findDept(Dept dept, PageModel pageModel);

    /**
     * 获取所有部门
     *
     * @return 返回部门List集合
     */
    List<Dept> findDept();

    /**
     * 根据id删除部门
     *
     * @param id
     */
    public void removeDeptById(Integer id);

    /**
     * 添加部门
     *
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 根据id查询部门
     *
     * @param id
     * @return 返回部门对象
     */
    Dept findDeptById(Integer id);

    /**
     * 修改部门
     *
     * @param dept
     */
    void modifyDept(Dept dept);

    /**
     * 获取所有职位,分页查询
     *
     * @param job
     * @param pageModel
     * @return
     */
    List<Job> findJob(Job job, PageModel pageModel);

    /**
     * 根据id删除职务
     *
     * @param id
     */
    public void removeJobById(Integer id);

    /**
     * 添加职务
     *
     * @param job 职务对象
     */
    void addJob(Job job);

    /**
     * 根据id查找职务
     *
     * @param id
     * @return 返回职务
     */
    Job findJobById(Integer id);

    /**
     * 修改职务
     *
     * @param job
     */
    void modifyJob(Job job);

    /**
     * 获取所有公告,分页查询
     *
     * @param notice    公告对象
     * @param pageModel 分页模型
     * @return 公告的list集合
     */
    List<Notice> findNotice(Notice notice, PageModel pageModel);

    /**
     * 根据id查询公告
     *
     * @param id
     * @return 返回公告对象
     */
    Notice findNoticeById(Integer id);

    /**
     * 根据id删除公告
     *
     * @param id
     */
    void removeNoticeById(Integer id);

    /**
     * 添加公告
     *
     * @param notice 公告对象
     */
    void addNotice(Notice notice);

    /**
     * 修改公告
     *
     * @param notice 公告对象
     */
    void modifyNotice(Notice notice);

    /**
     * 获取所有文档
     *
     * @param document
     * @param pageModel
     * @return 文档list集合
     */
    List<Document> findDocument(Document document, PageModel pageModel);

    /**
     * 添加文档
     *
     * @param document
     */
    void addDocument(Document document);

    /**
     * 根据id查询文档
     *
     * @param id
     * @return
     */
    Document findDocumentById(Integer id);

    /**
     * 根据id删除文档
     *
     * @param id
     */
    void removeDocumentById(Integer id);

    /**
     * 修改文档
     *
     * @param document
     */
    void modifyDocument(Document document);
}
