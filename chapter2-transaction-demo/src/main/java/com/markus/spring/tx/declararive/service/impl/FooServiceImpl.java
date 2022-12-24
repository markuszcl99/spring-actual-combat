package com.markus.spring.tx.declararive.service.impl;

import com.markus.spring.tx.declararive.exception.RollbackException;
import com.markus.spring.tx.declararive.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: markus
 * @date: 2022/12/24 5:11 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Service
public class FooServiceImpl implements FooService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RollbackException.class)
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
    }
}
