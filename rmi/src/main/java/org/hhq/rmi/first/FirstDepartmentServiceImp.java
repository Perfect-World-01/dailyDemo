package org.hhq.rmi.first;

import org.hhq.rmi.DepartmentServiceRemote;
import org.hhq.rmi.bean.Department;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * 这种方式启动需要
 * 编译：1、javac 远程实现
 * 生成本地代理以及服务代理：2、rmic 远程实现类
 * 注册远程服务：3、rmiregistry
 */
public class FirstDepartmentServiceImp extends UnicastRemoteObject implements DepartmentServiceRemote {

    public FirstDepartmentServiceImp() throws RemoteException {
    }

    /**
     *查询部门信息
     * @return 返回部门信息，要求Department序列化
     * @throws RemoteException
     */
    public List<Department> queryDepartments() throws RemoteException {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1,"QQQ"));
        departments.add(new Department(2,"AAA"));
        departments.add(new Department(3,"ZZZ"));
        return departments;
    }
}
