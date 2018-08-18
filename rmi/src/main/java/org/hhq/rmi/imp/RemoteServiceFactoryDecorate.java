package org.hhq.rmi.imp;

import org.hhq.rmi.RemoteService;
import org.hhq.rmi.RemoteServiceFactory;
import org.hhq.rmi.first.FirstRemoteServiceImp;
import org.hhq.rmi.second.SecondRemoteServiceImp;
import org.hhq.rmi.third.ThirdRemoteServiceImp;

/**
 * 服务调用装饰
 */
public class RemoteServiceFactoryDecorate implements RemoteServiceFactory {


    @Override
    public RemoteService createFirstRemoteService() {
        return new RemoteServiceDecorate(new FirstRemoteServiceImp());
    }

    @Override
    public RemoteService createSecondRemoteService() {
        return new RemoteServiceDecorate(new SecondRemoteServiceImp());
    }

    @Override
    public RemoteService createthirdRemoteService() {
        return new RemoteServiceDecorate(new ThirdRemoteServiceImp());
    }
}
