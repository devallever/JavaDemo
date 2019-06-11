package com.allever.pushTest.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created by allever on 18-8-2.
 */
public class MyTextLineEncoder implements ProtocolEncoder {
    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        String content = null;
        if(message instanceof String){
            content = (String) message;
        }

        if (content != null){

            CharsetEncoder charsetEncoder = (CharsetEncoder) session.getAttribute("encoder");
            if (charsetEncoder == null){
                charsetEncoder = Charset.defaultCharset().newEncoder();
                session.setAttribute("encoder", charsetEncoder);
            }

            //为buffer开辟内存
            IoBuffer ioBuffer = IoBuffer.allocate(content.length());
            //自动扩展内存
            ioBuffer.setAutoExpand(true);

            ioBuffer.putString(content, charsetEncoder);
            ioBuffer.flip();
            out.write(ioBuffer);
        }


    }

    @Override
    public void dispose(IoSession ioSession) throws Exception {

    }
}
