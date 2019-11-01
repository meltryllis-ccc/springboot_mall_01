package com.meltryllis.springbootmall.mapper;

import com.meltryllis.springbootmall.entities.Cart;
import com.meltryllis.springbootmall.entities.CartView;
import com.meltryllis.springbootmall.entities.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Ereshkigal
 * @date 2019/10/23 - 19:39
 */
public interface OrderMapper {

    @Insert("INSERT INTO `order` (`user_id`, `pid`, `price`, `num`, `total_price`, `order_num`, `generation_time`) values(#{userId},#{pId},#{price},#{num},#{totalPrice},#{orderNum},now(3))")
    public void insertOrder(Order order);

//    @Select("select num from car where userid=#{userid} and pid=#{pid}")
//    public Integer pNum(Integer userid, Integer pid);
//
//    @Update("update car set num=#{num} where userid=#{userid} and pid=#{pid}")
//    public void updatePNum(Cart cart);
//
//    @Select("select product.id as pid,product.pName,product.info,product.price,product.image,car.id,car.num from product left join car on product.id=car.pid where car.userid=#{userId}")
//    public List<CartView> cartPage(Integer userId);
//
//    @Delete("delete from car where id=#{id}")
//    public void removeProduct(String id);
}
