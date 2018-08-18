package org.hhq.rmi.second;

import org.hhq.rmi.RemoteService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 第二中调用方式
 */
public class SecondRemoteServiceImp implements RemoteService {
    /**
     *
     * @param port 端口
     * @param name 名称地址
     * @param remote 需要注册的远程对象
     * @throws RemoteException
     * @throws MalformedURLException
     */
    public void rebind(int port, String name, Remote remote) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(port);
        Naming.rebind(name,remote);
        System.out.println("second->rebind:success");
    }

    /**
     *
     * @param host 主机名称
     * @param port 端口
     * @param name 名称地址
     * @return 远程服务的本地代理
     * @throws RemoteException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
    public Remote lookup(String host, int port, String name) throws RemoteException, NotBoundException, MalformedURLException {
        Remote remote = Naming.lookup(name);
        System.out.println("second->lookup:success");
        return remote;
    }
}
