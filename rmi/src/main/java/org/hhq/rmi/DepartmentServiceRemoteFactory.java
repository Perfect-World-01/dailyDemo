package org.hhq.rmi;

import java.rmi.RemoteException;

/**
 * 抽象工厂
 * 创建部门服务实现
 */
public interface DepartmentServiceRemoteFactory {
    /**
     * 部门服务的第一种实现
     * @return 服务对象
     * @throws RemoteException
     */
    DepartmentServiceRemote createFirstDepartmentService() throws RemoteException;

    /**
     * 部门服务的第二种实现
     * @return 服务对象
     * @throws RemoteException
     */
    DepartmentServiceRemote createSecondDepartmentService() throws RemoteException;
    /**
     * 部门服务的第三种实现
     * @return 服务对象
     * @throws RemoteException
     */
    DepartmentServiceRemote createThirdDepartmentService() throws RemoteException;
}
