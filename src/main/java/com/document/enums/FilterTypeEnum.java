package com.document.enums;

import com.document.util.converter.BaseEnum;

/**
 * @author hangfeng.ying
 */
public enum FilterTypeEnum implements BaseEnum {

    /**
     * all
     */
    ALL(1),

    /**
     * filter
     */
    FILTER(2),

    /**
     * category
     */
    CATEGORY(3),

    /**
     * tag
     */
    TAG(4);

    private Integer code;

    FilterTypeEnum(int code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
}
