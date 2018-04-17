package xyz.icloudbadguy.aizaowu.web;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.icloudbadguy.aizaowu.entity.Addr;
import xyz.icloudbadguy.aizaowu.entity.Result;
import xyz.icloudbadguy.aizaowu.exception.AddrException;
import xyz.icloudbadguy.aizaowu.service.AddrService;
import xyz.icloudbadguy.aizaowu.util.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@CrossOrigin
@RestController
public class AddrController {

    @Autowired
    private AddrService addrService;

    @GetMapping(value = "/getAddrInformation")
    private Result getAddrInformation(String addrId){
        try {
            Addr addr = addrService.getAddrInformation(addrId);
            return JsonResult.success(addr);
        } catch (AddrException e) {
            return JsonResult.error(e);
        }
    }
    @GetMapping(value = "/addAddrInformation")
    private Result addAddrInformation(HttpServletRequest request, HttpServletResponse response){
        try{
            String userId = request.getParameter("userId");
            String name = request.getParameter("name");
            String area = request.getParameter("area");
            String addr = request.getParameter("addr");
            String mobile = request.getParameter("mobile");
            String isDefault = request.getParameter("isDefault");
            if(userId==null||userId.trim().isEmpty()){
                throw new IllegalArgumentException("userId不能为空");
            }
            if(name==null||name.trim().isEmpty()){
                throw new IllegalArgumentException("名字不能为空");
            }
            if(area==null||area.trim().isEmpty()){
                throw new IllegalArgumentException("地区不能为空");
            }
            if(addr==null||addr.trim().isEmpty()){
                throw new IllegalArgumentException("详细地址不能为空");
            }
            if(mobile==null||addr.trim().isEmpty()){
                throw new IllegalArgumentException("手机号码不能为空");
            }
            Addr addr1 = new Addr();
            addr1.setId(Integer.parseInt(UUID.randomUUID().toString()));
            addr1.setUserId(Integer.parseInt(userId));
            addr1.setName(name);
            addr1.setAddr(area+addr);
            addr1.setMobile(mobile);
            addr1.setIsDefault(Integer.parseInt(isDefault));
            addrService.addAddrInformation(addr1);
            return JsonResult.success();
        }catch (IllegalArgumentException e){
            return JsonResult.error(e);
        }
    }
    @GetMapping(value = "/modifyAddrInformation")
    private Result modifyAddrInformation(HttpServletRequest request,HttpServletResponse response){
        try{
            String id = request.getParameter("id");
            String userId = request.getParameter("userId");
            String name = request.getParameter("name");
            String area = request.getParameter("area");
            String addr = request.getParameter("addr");
            String mobile = request.getParameter("mobile");
            String isDefault = request.getParameter("isDefault");
            if(id==null||id.trim().isEmpty()){
                throw new IllegalArgumentException("id不能为空");
            }
            if(userId==null||userId.trim().isEmpty()){
                throw new IllegalArgumentException("userId不能为空");
            }
            if(name==null||name.trim().isEmpty()){
                throw new IllegalArgumentException("名字不能为空");
            }
            if(area==null||area.trim().isEmpty()){
                throw new IllegalArgumentException("地区不能为空");
            }
            if(addr==null||addr.trim().isEmpty()){
                throw new IllegalArgumentException("详细地址不能为空");
            }
            if(mobile==null||addr.trim().isEmpty()){
                throw new IllegalArgumentException("手机号码不能为空");
            }
            Addr addr1 = new Addr();
            addr1.setId(Integer.parseInt(id));
            addr1.setUserId(Integer.parseInt(userId));
            addr1.setName(name);
            addr1.setAddr(area+addr);
            addr1.setMobile(mobile);
            addr1.setIsDefault(Integer.parseInt(isDefault));
            addrService.modifyAddrInformation(addr1);
            return JsonResult.success();
        }catch(IllegalArgumentException e){
            return JsonResult.error(e);
        }
    }

    @GetMapping(value = "/delAddrInformation")
    private Result delAddrInformation(String addrId){
        try{
            addrService.delAddrInformation(addrId);
            return JsonResult.success();
        }catch(IllegalArgumentException e){
            return JsonResult.error(e);
        }
    }
}
