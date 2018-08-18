package org.hhq.rmi.third;

import org.hhq.rmi.RemoteService;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 第三种调用方式
 */
public class ThirdRemoteServiceImp implements RemoteService {
    /**
     * @param port 端口
     * @param name 名称地址
     * @param remote 需要注册的远程对象
     * @throws RemoteException
     */
    public void rebind(int port, String name, Remote remote) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(port);
        Remote remote2 = UnicastRemoteObject.exportObject(remote,0);
        registry.rebind(name,remote2);
        System.out.println("third->rebind:success");
    }

    /**
     * @param host 主机名称
     * @param port 端口
     * @param name 名称地址
     * @return 远程服务的本地代理
     * @throws RemoteException
     * @throws NotBoundException
     */
    public Remote lookup(String host, int port, String name) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host,port);
        Remote remote = registry.lookup(name);
        System.out.println("third->lookup:success");
        return remote;
    }
}
