package org.kxw.bms.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Create by kangxiongwei on 2018/1/8 20:32.
 */
public class ThriftClient {

    public static void main(String[] args) throws TException {
        TTransport transport = new TSocket("localhost", 9090);
        TProtocol protocol = new TBinaryProtocol(transport);
        HelloThrift.Client client = new HelloThrift.Client(protocol);
        transport.open();
        String res = client.helloString("world");
        System.out.println(res);
    }


}
