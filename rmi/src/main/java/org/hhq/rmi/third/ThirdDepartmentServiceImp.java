package org.hhq.rmi.third;

import org.hhq.rmi.DepartmentServiceRemote;
import org.hhq.rmi.bean.Department;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要调用 {@link java.rmi.server.UnicastRemoteObject} 暴露远程接口
 */
public class ThirdDepartmentServiceImp implements DepartmentServiceRemote {

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
