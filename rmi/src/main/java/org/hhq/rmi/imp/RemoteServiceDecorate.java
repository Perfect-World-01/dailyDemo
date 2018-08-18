package org.hhq.rmi.imp;

import org.hhq.rmi.RemoteService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程服务调用的装饰类
 */
public class RemoteServiceDecorate implements RemoteService {
    /**
     * 远程服务调用
     */
    private RemoteService remoteService;

    public RemoteServiceDecorate(RemoteService remoteService){
        this.remoteService = remoteService;
    }

    /**
     * 装饰rebind
     * @param port 端口
     * @param name 名称地址
     * @param remote 需要注册的远程对象
     * @throws IOException
     */
    public void rebind(int port, String name, Remote remote) throws IOException {
        System.out.println("start：RemoteServiceDecorate->"+remoteService.getClass()+"->rebind:port:"+port+";name:"+name+";remote:"+remote);
        remoteService.rebind(port,name,remote);
        System.out.println("end:RemoteServiceDecorate->"+remoteService.getClass());
    }

    /**
     * 装饰lookup
     * @param host 主机名称
     * @param port 端口
     * @param name 名称地址
     * @return
     * @throws RemoteException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
    public Remote lookup(String host, int port, String name) throws RemoteException, NotBoundException, MalformedURLException {
        System.out.println("start:RemoteServiceDecorate->"+remoteService.getClass()+"->lookup:host:"+host+";port:"+port+";name:"+name);
        Remote remote = remoteService.lookup(host,port,name);
        System.out.println("end:RemoteServiceDecorate->"+remoteService.getClass()+"->lookup:remote:"+remote.getClass()+"");
        return remote;
    }
}
