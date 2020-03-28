package com.lcwork.multimall.admin.dto;

import com.lcwork.multimall.db.domain.generate.MultimallGoods;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsAttribute;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsProduct;
import com.lcwork.multimall.db.domain.generate.MultimallGoodsSpecification;

public class GoodsAllinone {
    MultimallGoods goods;
    MultimallGoodsSpecification[] specifications;
    MultimallGoodsAttribute[] attributes;
    MultimallGoodsProduct[] products;

    public MultimallGoods getGoods() {
        return goods;
    }

    public void setGoods(MultimallGoods goods) {
        this.goods = goods;
    }

    public MultimallGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(MultimallGoodsProduct[] products) {
        this.products = products;
    }

    public MultimallGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(MultimallGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public MultimallGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(MultimallGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}
