package org.hhq.rmi;

import org.hhq.rmi.bean.Department;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 1、要求接口必须继承remote接口
 * 2、所有远程方法均需要抛出远程调用异常
 * 创建远程调用接口
 */
public interface DepartmentServiceRemote  extends Remote {
    /**
     *查询部门信息
     * @return 返回部门信息，要求Department序列化
     * @throws RemoteException
     */
    List<Department> queryDepartments() throws RemoteException;
}
