package org.hhq.rmi;

import org.hhq.rmi.imp.DepartmentServiceRemoteFactoryImp;
import org.hhq.rmi.imp.RemoteServiceFactoryDecorate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Test {

    public static void main(String[] args) throws IOException, NotBoundException {
        RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactoryDecorate();

        DepartmentServiceRemoteFactory departmentServiceRemoteFactory = new DepartmentServiceRemoteFactoryImp();

        int port=12345;
        String name = "rmi://127.0.0.1:12345/departmentService";
        String host = "localhost";
//        //第一种注入
//        firstRemoteRebind(port,name,remoteServiceFactory,departmentServiceRemoteFactory);
//        //第一种搜寻
//        firstRemoteLookup(host,port,name,remoteServiceFactory);
        //第二种注入
        secondRemoteRebind(port,name,remoteServiceFactory,departmentServiceRemoteFactory);
        //第二种搜寻
        secondRemoteLookup(host,port,name,remoteServiceFactory);

//        //第三种注入
//        thirdRemoteRebind(port,name,remoteServiceFactory,departmentServiceRemoteFactory);
//        //第三种搜寻
//        thirdRemoteLookup(host,port,name,remoteServiceFactory);
    }

    public static void firstRemoteRebind(int port, String name, RemoteServiceFactory remoteServiceFactory,DepartmentServiceRemoteFactory departmentServiceRemoteFactory) throws IOException {
        rebind(port,name,remoteServiceFactory.createFirstRemoteService(),departmentServiceRemoteFactory.createFirstDepartmentService());
    }

    public static void firstRemoteLookup(String host, int port, String name, RemoteServiceFactory remoteServiceFactory) throws RemoteException, NotBoundException, MalformedURLException {
        lookup(host,port,name,remoteServiceFactory.createFirstRemoteService());
    }
    public static void secondRemoteRebind(int port, String name, RemoteServiceFactory remoteServiceFactory,DepartmentServiceRemoteFactory departmentServiceRemoteFactory) throws IOException {
        rebind(port,name,remoteServiceFactory.createSecondRemoteService(),departmentServiceRemoteFactory.createSecondDepartmentService());
    }

    public static void secondRemoteLookup(String host, int port, String name, RemoteServiceFactory remoteServiceFactory) throws RemoteException, NotBoundException, MalformedURLException {
        lookup(host,port,name,remoteServiceFactory.createSecondRemoteService());
    }
    public static void thirdRemoteRebind(int port, String name, RemoteServiceFactory remoteServiceFactory,DepartmentServiceRemoteFactory departmentServiceRemoteFactory) throws IOException {
        rebind(port,name,remoteServiceFactory.createthirdRemoteService(),departmentServiceRemoteFactory.createThirdDepartmentService());
    }

    public static void thirdRemoteLookup(String host, int port, String name, RemoteServiceFactory remoteServiceFactory) throws RemoteException, NotBoundException, MalformedURLException {
        lookup(host,port,name,remoteServiceFactory.createthirdRemoteService());
    }

    private static void rebind(int port, String name, RemoteService remoteService, Remote remote) throws IOException {
        //注册服务到指定位置
        remoteService.rebind(port,name,remote);
    }
    private static Remote lookup(String host, int port, String name, RemoteService remoteService) throws RemoteException, NotBoundException, MalformedURLException {
        //查找制定位置的服务
        return (Remote)remoteService.lookup(host,port,name);
    }
}
