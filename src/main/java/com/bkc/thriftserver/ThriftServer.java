package com.bkc.thriftserver;

import com.bkc.service.TestQryImpl;
import com.bkc.thrift.generate.TestQry;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class ThriftServer {

    private static final int DEFAULT_PORT = 8181;

    private static TServer server = null;

    public static void server(){
        try {
            TNonblockingServerSocket socket = new TNonblockingServerSocket(DEFAULT_PORT);

            TestQry.Processor processor = new TestQry.Processor(new TestQryImpl());

            TNonblockingServer.Args arg = new TNonblockingServer.Args(socket);

            arg.protocolFactory(new TBinaryProtocol.Factory());

            arg.processorFactory(new TProcessorFactory(processor));

            server = new TNonblockingServer(arg);

            server.serve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
