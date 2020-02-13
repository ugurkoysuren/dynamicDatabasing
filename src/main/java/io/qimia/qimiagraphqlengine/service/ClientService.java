package io.qimia.qimiagraphqlengine.service;

import io.qimia.qimiagraphqlengine.models.ClientDao;
import io.qimia.qimiagraphqlengine.models.DBTypeEnum;
import io.qimia.qimiagraphqlengine.utils.ClientDatabaseContextHolder;

public class ClientService {

    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public String getClientName(DBTypeEnum clientDb) {
        ClientDatabaseContextHolder.set(clientDb);
        String clientName = this.clientDao.getClientName();
        ClientDatabaseContextHolder.clear();
        return clientName;
    }
}
