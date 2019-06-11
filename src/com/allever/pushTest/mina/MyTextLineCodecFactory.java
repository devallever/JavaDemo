package com.allever.pushTest.mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * Created by allever on 18-8-2.
 */
public class MyTextLineCodecFactory implements ProtocolCodecFactory {

    private MyTextLineEncoder mEncoder;
    private MyTextLineDecoder mDecoder;
    private MyTextLineQumulativeDecoder myTextLineQumulativeDecoder;

    public MyTextLineCodecFactory(){
        mDecoder = new MyTextLineDecoder();
        mEncoder = new MyTextLineEncoder();
        myTextLineQumulativeDecoder = new MyTextLineQumulativeDecoder();
    }
    @Override
    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return mEncoder;
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return myTextLineQumulativeDecoder;
    }
}
