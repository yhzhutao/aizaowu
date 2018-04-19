package xyz.icloudbadguy.aizaowu.dao;

import xyz.icloudbadguy.aizaowu.entity.Addr;

import java.util.List;

public interface AddrDao {

    Addr getAddrInformationById(long addrId);

    void addAddrInformation(Addr addr1);

    void modifyAddrInformation(Addr addr1);

    void delAddrByaddrId(long addrId);

    List<Addr> getAddrList(long userId);
}
