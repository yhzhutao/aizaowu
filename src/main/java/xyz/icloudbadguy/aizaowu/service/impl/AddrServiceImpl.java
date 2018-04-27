package xyz.icloudbadguy.aizaowu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.icloudbadguy.aizaowu.dao.AddrDao;
import xyz.icloudbadguy.aizaowu.entity.Addr;
import xyz.icloudbadguy.aizaowu.exception.AddrException;
import xyz.icloudbadguy.aizaowu.service.AddrService;

import java.util.List;
import java.util.UUID;

@Service
public class AddrServiceImpl implements AddrService {

    @Autowired
    private AddrDao addrDao;

    @Override
    public Addr getAddrInformation(String addrId) throws AddrException {
        Addr addr = addrDao.getAddrInformationById(Long.parseLong(addrId));
        if(addr==null){
            throw new AddrException("该地址不存在");
        }
        return addr;
    }

    @Override
    public void addAddrInformation(Addr addr1) {
        addrDao.addAddrInformation(addr1);
    }

    @Override
    public void modifyAddrInformation(Addr addr1) {
        Addr addr = addrDao.getAddrInformationById(addr1.getId());
        if(addr==null){
            throw new IllegalArgumentException("需要修改的地址信息不存在");
        }else if(addr1.getIsDefault()==1){
            List<Addr> list = addrDao.getAddrList(addr.getUserId());
            for(Addr addr2 : list){
                addr2.setIsDefault(0);
                addrDao.modifyAddrInformation(addr2);
            }
            addr1.setUserId(addr.getUserId());
            addrDao.modifyAddrInformation(addr1);
        }else{
            addrDao.modifyAddrInformation(addr1);
        }

    }

    @Override
    public void delAddrInformation(String addrId) throws IllegalArgumentException {
        Addr addr = addrDao.getAddrInformationById(Long.parseLong(addrId));
        if(addr==null){
            throw new IllegalArgumentException("不存在这样的地址信息");
        }
        addrDao.delAddrByaddrId(Long.parseLong(addrId));
    }

    @Override
    public List<Addr> getAddrList(String userId) throws IllegalArgumentException {
        List<Addr> list = addrDao.getAddrList(Long.parseLong(userId));
        if(list == null){
            throw  new IllegalArgumentException("不存在这样的地址信息");
        }else{
            return list;
        }
    }
}
