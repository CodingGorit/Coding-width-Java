package cn.gorit.dao;

import cn.gorit.entity.Product;

import java.util.ArrayList;

public interface ProductDao {
    // ��ѯ���е���Ʒ
    public ArrayList<Product>  queryProducts();
}
