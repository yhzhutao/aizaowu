package xyz.icloudbadguy.aizaowu.dao;

import xyz.icloudbadguy.aizaowu.entity.Addr;

public interface AddrDao {

    Addr getAddrInformationById(int addrId);

    void addAddrInformation(Addr addr1);

    void modifyAddrInformation(Addr addr1);

    void delAddrByaddrId(int addrId);
}
