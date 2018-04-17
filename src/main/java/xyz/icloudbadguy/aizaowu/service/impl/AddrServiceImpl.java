package xyz.icloudbadguy.aizaowu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.icloudbadguy.aizaowu.dao.AddrDao;
import xyz.icloudbadguy.aizaowu.entity.Addr;
import xyz.icloudbadguy.aizaowu.exception.AddrException;
import xyz.icloudbadguy.aizaowu.service.AddrService;

@Service
public class AddrServiceImpl implements AddrService {

    @Autowired
    private AddrDao addrDao;

    @Override
    public Addr getAddrInformation(String addrId) throws AddrException {
        Addr addr = addrDao.getAddrInformationById(Integer.parseInt(addrId));
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
        addrDao.modifyAddrInformation(addr1);
    }

    @Override
    public void delAddrInformation(String addrId) throws IllegalArgumentException {
        Addr addr = addrDao.getAddrInformationById(Integer.parseInt(addrId));
        if(addr==null){
            throw new IllegalArgumentException("不存在这样的地址信息");
        }
        addrDao.delAddrByaddrId(Integer.parseInt(addrId));
    }
}
