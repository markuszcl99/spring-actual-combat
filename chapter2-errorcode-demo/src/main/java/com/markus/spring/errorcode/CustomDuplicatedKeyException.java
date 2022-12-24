package com.markus.spring.errorcode;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author: markus
 * @date: 2022/12/24 5:55 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {
    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
