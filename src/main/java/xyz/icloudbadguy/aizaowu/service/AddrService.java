package xyz.icloudbadguy.aizaowu.service;

import xyz.icloudbadguy.aizaowu.entity.Addr;
import xyz.icloudbadguy.aizaowu.exception.AddrException;

import java.util.List;

public interface AddrService {

    Addr getAddrInformation(int addrId) throws AddrException;

    void addAddrInformation(Addr addr1);

    void modifyAddrInformation(Addr addr1);

    void delAddrInformation(int addrId) throws IllegalArgumentException;

    List<Addr> getAddrList(int userId) throws IllegalArgumentException;
}
