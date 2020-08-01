package dao.dust;

import entity.OrderDetail;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 19:27
 */
public interface OrderDetailService {

    /**
     * 插入记录
     * @param orderDetail
     * @return
     */
    int add(OrderDetail orderDetail);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 更新记录
     * @param orderDetail
     * @return
     */
    int edit(OrderDetail orderDetail);

    /**
     * 选择一个
     * @param id
     * @return
     */
    OrderDetail selectOne(int id);

    /**
     * 选择所有
     * @return
     */
    List<OrderDetail> selectAll();

}
