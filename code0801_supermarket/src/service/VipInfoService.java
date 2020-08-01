package service;

import entity.VipInfo;

import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/30 11:29
 */
public interface VipInfoService {
    /**
     * 插入记录
     * @param vipInfo
     * @return
     */
    int add(VipInfo vipInfo);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 更新记录
     * @param vipInfo
     * @return
     */
    int edit(VipInfo vipInfo);

    /**
     * 选择一个
     * @param id
     * @return
     */
    Map<String, Object> selectOne(int id);

    /**
     * 选择所有
     * @return
     */
    List<VipInfo> selectAll();
}
