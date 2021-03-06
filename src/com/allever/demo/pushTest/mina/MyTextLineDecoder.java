package com.allever.demo.pushTest.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * Created by allever on 18-8-2.
 */
public class MyTextLineDecoder implements ProtocolDecoder {
    @Override
    public void decode(IoSession session, IoBuffer ioBuffer, ProtocolDecoderOutput out) throws Exception {
        //get()读取一个字节
        //一个一个的读字节，然后进行解码
        //ioBuffer.get();
        int startPosition = ioBuffer.position();
        //判断是否还有字节可以读取
        while (ioBuffer.hasRemaining()){
            //每次循环读取一个字节
            byte b = ioBuffer.get();
            //当遇到\n表示读取一行结束
            if (b == '\n'){
                //当前位置
                int currentPosition = ioBuffer.position();
                //长度
                int limit = ioBuffer.limit();
                //截取开始位置到\n位置的字节
                //重定向到开始位置，相当于移动游标
                ioBuffer.position(startPosition);
                //指定终点位置
                ioBuffer.limit(currentPosition);
                //slice():截取内容
                IoBuffer sliceContentBuffer = ioBuffer.slice();
                byte[] dest = new byte[sliceContentBuffer.limit()];
                //把sliceContentBuffer的内容赋值到dest
                sliceContentBuffer.get(dest);

                String content = new String(dest);
                out.write(content);//写出到

                //还原位置:原因：ioBuffer重定向.避免死循环
                ioBuffer.position(currentPosition);
                ioBuffer.limit(limit);
            }
        }
    }

    @Override
    public void finishDecode(IoSession ioSession, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {

    }

    @Override
    public void dispose(IoSession ioSession) throws Exception {

    }
}
