package org.kxw.bms.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.kxw.bms.thrift.impl.HelloThriftImpl;

/**
 * Create by kangxiongwei on 2018/1/8 20:28.
 */
public class ThriftServer {


    public static void main(String[] args) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TProcessor processor = new HelloThrift.Processor<>(new HelloThriftImpl());
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
            // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
