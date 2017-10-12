package com.bkc.service;

import com.bkc.thrift.generate.QryResult;
import com.bkc.thrift.generate.TestQry;
import org.apache.thrift.TException;

public class TestQryImpl implements TestQry.Iface{
    @Override public QryResult qryTest(int qryCode) throws TException {
        QryResult result = new QryResult();
        if (qryCode == 1) {
            result.setCode(1);
            result.setMsg("success");
        } else {
            result.setCode(0);
            result.setMsg("failed");
        }
        return result;
    }

    @Override public String helloWorld() throws TException {
        return "helloWorld";
    }
}
