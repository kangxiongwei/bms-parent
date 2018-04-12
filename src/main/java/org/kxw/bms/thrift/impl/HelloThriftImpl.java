package org.kxw.bms.thrift.impl;

import org.apache.thrift.TException;
import org.kxw.bms.thrift.HelloThrift;

/**
 * Create by kangxiongwei on 2018/1/8 20:18.
 */
public class HelloThriftImpl implements HelloThrift.Iface {

    @Override
    public String helloString(String param) throws TException {
        return "hello " + param;
    }

    @Override
    public int helloInt(int param) throws TException {
        return 0;
    }

    @Override
    public boolean helloBool(boolean param) throws TException {
        return false;
    }

    @Override
    public void helloVoid() throws TException {

    }

    @Override
    public String helloNull() throws TException {
        return null;
    }

}
