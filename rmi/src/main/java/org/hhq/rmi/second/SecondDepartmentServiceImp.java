package org.hhq.rmi.second;

import org.hhq.rmi.DepartmentServiceRemote;
import org.hhq.rmi.bean.Department;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * 这种方式与方式一有部分相同，提供LocateRegistry.createRegistry(port)，完成了注册前的注册服务初始化
 */
public class SecondDepartmentServiceImp extends UnicastRemoteObject implements DepartmentServiceRemote {

    public SecondDepartmentServiceImp() throws RemoteException {
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
