package com.bkc.servlet;

import com.bkc.thrift.generate.TestQry;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServlet;

public class QueryServlet extends TServlet{
    public QueryServlet(TestQry.Iface testQryImpl) {
        super(new TestQry.Processor<TestQry.Iface>(testQryImpl),
            new TCompactProtocol.Factory());
    }
}
