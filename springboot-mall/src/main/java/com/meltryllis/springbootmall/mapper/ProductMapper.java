package com.meltryllis.springbootmall.mapper;

import com.meltryllis.springbootmall.entities.Commodity;
import com.meltryllis.springbootmall.entities.Product;
import org.apache.ibatis.annotations.*;
import org.json.JSONArray;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Ereshkigal
 * @date 2019/10/15 - 8:54
 */
//@Mapper
public interface ProductMapper {

    @Select("select * from product")
    public List<Product> productList();

    @Insert("insert into product(pName,category,info,price,image,details) values(#{pName},#{category},#{info},#{price},#{image},#{details})")
    public void insertDept(Product product);

    @Select("select sup_category from category group by sup_category")
    public List<String> selectCategory();

    @Select("select category from category where sup_category = #{category}")
    public List<String> selectSubCategory(String category);

    @Select("select * from product where id=#{id}")
    public Product productDetails(Integer id);

    @Delete("delete from product where id=#{id}")
    public void deleted(Integer id);

    @Update("update product set pName=#{pName}, category=#{category}, info=#{info}, price=#{price}, image=#{image}, details=#{details} where id = #{id}")
    public void updateProduct(Product product);

    @Update("update product set pName=#{pName}, category=#{category}, info=#{info}, price=#{price}, details=#{details} where id = #{id}")
    public void updateProductNoImage(Product product);
}
