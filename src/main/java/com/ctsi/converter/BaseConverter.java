package com.ctsi.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseConverter<T1, T2> {
	
	private final Logger logger = LoggerFactory.getLogger(BaseConverter.class);
	
	/**
	 * 对象转对象
	 * @param from
	 * @param clazz
	 * @return
	 */
    public T2 convert(T1 from, Class<T2> clazz) {
        if (from == null) {
            return null;
        }
        T2 to = null;
        try {
            to = clazz.newInstance();
        } catch (Exception e) {
            logger.error("初始化{}对象失败。", clazz, e);
        }
        convert(from, to);
        return to;
    }
    
    /**
     * 批量转换
     * @param fromList
     * @param clazz
     * @return
     */
    public List<T2> convert(List<T1> fromList, Class<T2> clazz) {
        if (CollectionUtils.isEmpty(fromList)) {
            return null;
        }
        List<T2> toList = new ArrayList<T2>();
        for (T1 from : fromList) {
            toList.add(convert(from, clazz));
        }
        return toList;
    }
    
    /**
     * 属性拷贝方法，有特殊需求时子类覆写此方法
     * @param from
     * @param to
     */
    protected void convert(T1 from, T2 to) {
        BeanUtils.copyProperties(from, to);
    }
}

