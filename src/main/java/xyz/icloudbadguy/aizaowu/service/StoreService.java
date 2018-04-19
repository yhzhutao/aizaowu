package xyz.icloudbadguy.aizaowu.service;

import java.util.List;

public interface StoreService {

    List<String> getMyStore(String userId);

    void delMyStore(String storeId);
}
