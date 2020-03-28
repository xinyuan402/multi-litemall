package com.lcwork.multimall.db.service;

import com.lcwork.multimall.db.dao.generate.MultimallSystemMapper;
import com.lcwork.multimall.db.domain.generate.MultimallSystem;
import com.lcwork.multimall.db.domain.generate.MultimallSystemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MultimallSystemConfigService {
    @Resource
    private MultimallSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        MultimallSystemExample example = new MultimallSystemExample();
        example.or().andDeletedEqualTo(false);

        List<MultimallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (MultimallSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    /**
     * mall 信息属于单商城信息,不再适用于多商城
     * 后期要删除
     *
     * @return
     */
    @Deprecated
    public Map<String, String> listMail() {
        MultimallSystemExample example = new MultimallSystemExample();
        example.or().andKeyNameLike("litemall_mall_%").andDeletedEqualTo(false);
        List<MultimallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for (MultimallSystem system : systemList) {
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        MultimallSystemExample example = new MultimallSystemExample();
        example.or().andKeyNameLike("litemall_wx_%").andDeletedEqualTo(false);
        List<MultimallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for (MultimallSystem system : systemList) {
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        MultimallSystemExample example = new MultimallSystemExample();
        example.or().andKeyNameLike("litemall_order_%").andDeletedEqualTo(false);
        List<MultimallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for (MultimallSystem system : systemList) {
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    /**
     * mall 信息属于单商城信息,不再适用于多商城
     * 后期要删除
     *
     * @return
     */
    @Deprecated
    public Map<String, String> listExpress() {
        MultimallSystemExample example = new MultimallSystemExample();
        example.or().andKeyNameLike("litemall_express_%").andDeletedEqualTo(false);
        List<MultimallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for (MultimallSystem system : systemList) {
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            MultimallSystemExample example = new MultimallSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            MultimallSystem system = new MultimallSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        MultimallSystem system = new MultimallSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
}
