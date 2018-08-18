package org.hhq.rmi;

/**
 * 抽象工厂
 * 创建服务调用类型
 */
public interface RemoteServiceFactory {
    /**
     * 第一种服务调用方式
     * @return 服务调用
     */
    RemoteService createFirstRemoteService();
    /**
     * 第二种服务调用方式
     * @return 服务调用
     */
    RemoteService createSecondRemoteService();
    /**
     * 第三种服务调用方式
     * @return 服务调用
     */
    RemoteService createthirdRemoteService();
}
