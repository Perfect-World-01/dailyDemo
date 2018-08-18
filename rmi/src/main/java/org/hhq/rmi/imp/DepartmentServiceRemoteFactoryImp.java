package org.hhq.rmi.imp;

import org.hhq.rmi.DepartmentServiceRemote;
import org.hhq.rmi.DepartmentServiceRemoteFactory;
import org.hhq.rmi.first.FirstDepartmentServiceImp;
import org.hhq.rmi.second.SecondDepartmentServiceImp;
import org.hhq.rmi.third.ThirdDepartmentServiceImp;

import java.rmi.RemoteException;

public class DepartmentServiceRemoteFactoryImp implements DepartmentServiceRemoteFactory {
    @Override
    public DepartmentServiceRemote createFirstDepartmentService() throws RemoteException {
        return new FirstDepartmentServiceImp();
    }

    @Override
    public DepartmentServiceRemote createSecondDepartmentService() throws RemoteException {
        return new SecondDepartmentServiceImp();
    }

    @Override
    public DepartmentServiceRemote createThirdDepartmentService() throws RemoteException  {
        return new ThirdDepartmentServiceImp();
    }
}
