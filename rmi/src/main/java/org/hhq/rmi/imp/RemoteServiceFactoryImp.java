package org.hhq.rmi.imp;

import org.hhq.rmi.RemoteService;
import org.hhq.rmi.RemoteServiceFactory;
import org.hhq.rmi.first.FirstRemoteServiceImp;
import org.hhq.rmi.second.SecondRemoteServiceImp;
import org.hhq.rmi.third.ThirdRemoteServiceImp;

public class RemoteServiceFactoryImp implements RemoteServiceFactory {
    @Override
    public RemoteService createFirstRemoteService() {
        return new FirstRemoteServiceImp();
    }

    @Override
    public RemoteService createSecondRemoteService() {
        return new SecondRemoteServiceImp();
    }

    @Override
    public RemoteService createthirdRemoteService() {
        return new ThirdRemoteServiceImp();
    }
}
