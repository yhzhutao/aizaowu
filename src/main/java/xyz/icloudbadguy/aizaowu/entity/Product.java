package xyz.icloudbadguy.aizaowu.entity;

public class Product {
    private int id;
    private String name;
    private int categoryId;
    private double price;
    private String detail;
    private String picUrl;
    private int num;
    private String proProperties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProProperties() {
        return proProperties;
    }

    public void setProProperties(String proProperties) {
        this.proProperties = proProperties;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", num=" + num +
                ", proProperties='" + proProperties + '\'' +
                '}';
    }
}
