package io.qimia.qimiagraphqlengine.utils;

import io.qimia.qimiagraphqlengine.models.DBTypeEnum;
import org.springframework.util.Assert;

public class ClientDatabaseContextHolder {

    private static ThreadLocal<DBTypeEnum> CONTEXT
            = new ThreadLocal<>();

    public static void set(DBTypeEnum clientDatabase) {
        Assert.notNull(clientDatabase, "clientDatabase cannot be null");
        CONTEXT.set(clientDatabase);
    }

    public static DBTypeEnum getClientDatabase() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
