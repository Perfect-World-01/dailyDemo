package org.hhq.rmi.first;

import org.hhq.rmi.RemoteService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**第一种调用方式
 * 这种方式启动需要
 * 编译：1、javac 远程实现
 * 生成本地代理以及服务代理：2、rmic 远程实现类
 * 注册远程服务：3、rmiregistry
 *
 * 注意：将相关的内容放到默认包中，然后执行以上操作
 */
public class FirstRemoteServiceImp implements RemoteService {
    /**
     * @param name          protocol://ip:port/serviceName
     * @param remote        serviceObject
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public void rebind(int port, String name,Remote remote) throws IOException {
        Naming.rebind(name,remote);
        System.out.println("first->rebind:success");
    }

    /**
     * 寻找服务(到远程注册表中寻找)
     * @param host 主机名称
     * @param port 端口
     * @param name 名称地址
     * @return 远程服务的本地代理
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws NotBoundException
     */
    public Remote lookup(String host, int port, String name) throws MalformedURLException, RemoteException, NotBoundException {
        Remote remote = Naming.lookup(name);
        System.out.println("first->lookup:success");
        return remote;
    }
}
