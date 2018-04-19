package xyz.icloudbadguy.aizaowu.dao;

import xyz.icloudbadguy.aizaowu.entity.Store;

import java.util.List;

public interface StoreDao {
    List<String> getStoreByUserId(int userId);

    void delStoreByStoreId(int storeId);

    Store findStoreByStoreId(int storeId);
}
