package cn.gorit.entity;

//�м�ʵ�壨û�ж�Ӧ�ı�  ���ã���������
public class ShopcartAndProductDetail {
    private int shopNO;
    private String productName;
    private double price;
    private int num;

    public ShopcartAndProductDetail() {
    }

    public ShopcartAndProductDetail(int shopNO, String productName, double price, int num) {
        this.shopNO = shopNO;
        this.productName = productName;
        this.price = price;
        this.num = num;
    }

    public int getShopNO() {
        return shopNO;
    }

    public void setShopNO(int shopNO) {
        this.shopNO = shopNO;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
