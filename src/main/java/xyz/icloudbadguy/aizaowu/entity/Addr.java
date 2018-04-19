package xyz.icloudbadguy.aizaowu.entity;

public class Addr {
    private long id;
    private int userId;
    private String name;
    private String mobile;
    private String area;
    private String addr;
    private int isDefault;
    private String postNum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Addr{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", area='" + area + '\'' +
                ", addr='" + addr + '\'' +
                ", isDefault=" + isDefault +
                ", postNum='" + postNum + '\'' +
                '}';
    }
}
