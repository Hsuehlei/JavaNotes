package sharedbike_v2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/6 14:40
 */
public interface Share {

    /**
     * 投放单车
     *
     * @param shareBike
     */
    void putBike(ShareBike shareBike);

    /**
     * 查看单车
     *
     * @return
     */
    ShareBike[] selectBike();

    /**
     * 删除单车
     *
     * @param id
     */
    void deleteBike(int id);

    /**
     * 借出单车
     *
     * @param id
     */
    void lendBike(int id);

    /**
     * 归还单车
     *
     * @param id
     */
    void returnBike(int id);
}
