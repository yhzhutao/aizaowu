package xyz.icloudbadguy.aizaowu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.icloudbadguy.aizaowu.dao.StoreDao;
import xyz.icloudbadguy.aizaowu.entity.Store;
import xyz.icloudbadguy.aizaowu.service.StoreService;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;
    @Override
    public List<String> getMyStore(String userId) {
        List<String> list = storeDao.getStoreByUserId(Integer.parseInt(userId));
        return list;
    }

    @Override
    public void delMyStore(String storeId) {
        Store store = storeDao.findStoreByStoreId(Integer.parseInt(storeId));
        if(store==null){
            throw new IllegalArgumentException("没有这样的收藏");
        }else{
            storeDao.delStoreByStoreId(Integer.parseInt(storeId));
        }

    }
}
