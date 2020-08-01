package dao.dust;

import entity.OrderDetail;

import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/27 20:34
 */
public interface OrderDetailDao {

    /**
     * 插入记录
     * @param orderDetail
     * @return
     * @throws Exception
     */
    int insert(OrderDetail orderDetail) throws Exception;

    /**
     * 删除记录
     * @param id
     * @return
     * @throws Exception
     */
    int delete(int id) throws Exception;

    /**
     * 更新记录
     * @param orderDetail
     * @return
     * @throws Exception
     */
    int update(OrderDetail orderDetail) throws Exception;

    /**
     * 查询一个记录
     * @param id
     * @return
     * @throws Exception
     */
    Map<String, Object> selectOne(int id) throws Exception;

    /**
     * 查询所有记录
     * @return
     * @throws Exception
     */
    List<OrderDetail> selectAll() throws Exception;

}
