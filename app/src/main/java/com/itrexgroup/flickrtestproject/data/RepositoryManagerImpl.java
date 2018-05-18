package com.itrexgroup.flickrtestproject.data;

import javax.inject.Inject;

public class RepositoryManagerImpl implements RepositoryManager {

    private ServiceNetwork serviceNetwork;

    @Inject
    public RepositoryManagerImpl(ServiceNetwork serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    @Override
    public ServiceNetwork getServiceNetwork() {
        return serviceNetwork;
    }
}
