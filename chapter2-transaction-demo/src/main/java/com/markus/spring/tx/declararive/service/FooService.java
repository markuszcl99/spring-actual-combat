package com.markus.spring.tx.declararive.service;

import com.markus.spring.tx.declararive.exception.RollbackException;

/**
 * @author: markus
 * @date: 2022/12/24 5:08 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface FooService {
    void insertRecord();

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;
}
