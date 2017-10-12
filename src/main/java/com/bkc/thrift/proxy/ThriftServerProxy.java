package com.bkc.thrift.proxy;

import com.bkc.service.TestQryImpl;
import com.bkc.thrift.generate.TestQry;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftServerProxy {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private int port;// 端口
    private String serviceInterface;// 实现类接口
    private Object serviceImplObject;// 实现类

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void start() {

        new Thread() {
            @Override
            public void run() {
                try {
                    TNonblockingServerSocket socket = new TNonblockingServerSocket(8081);

                    TestQry.Processor processor = new TestQry.Processor(new TestQryImpl());

                    TNonblockingServer.Args arg = new TNonblockingServer.Args(socket);

                    arg.protocolFactory(new TBinaryProtocol.Factory());

                    arg.processorFactory(new TProcessorFactory(processor));

                    TServer server = new TNonblockingServer(arg);

                    server.serve();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServiceInterface() {
        return serviceInterface;
    }

    public void setServiceInterface(String serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public Object getServiceImplObject() {
        return serviceImplObject;
    }

    public void setServiceImplObject(Object serviceImplObject) {
        this.serviceImplObject = serviceImplObject;
    }
}
