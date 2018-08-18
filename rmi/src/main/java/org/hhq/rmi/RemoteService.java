package org.hhq.rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 创建服务调用接口
 */
public interface RemoteService {
    /**
     * 重新绑定服务
     * @param port 端口
     * @param name 名称地址
     * @param remote 需要注册的远程对象
     * @throws IOException
     */
    void rebind(int port, String name, Remote remote) throws IOException;

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
    Remote lookup(String host, int port, String name) throws MalformedURLException, RemoteException, NotBoundException;
}
