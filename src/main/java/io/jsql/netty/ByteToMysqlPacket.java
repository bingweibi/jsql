package io.jsql.netty;

import io.jsql.mysql.mysql.AuthPacket;
import io.jsql.mysql.mysql.CommandPacket;
import io.jsql.mysql.mysql.MySQLPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by 长宏 on 2017/4/30 0030.
 * byte到mysql包的解析。
 */
@Component
@Scope("prototype")
public class ByteToMysqlPacket extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] data = (byte[]) msg;
        MySQLPacket mySQLPacket;
        if (data[4] >= MySQLPacket.MIN_COMP_NUMBER && data[4] <= MySQLPacket.MAX_COMP_NUMBER) {
            mySQLPacket = new CommandPacket();
            mySQLPacket.read(data);
        } else {
            mySQLPacket = new AuthPacket();
            mySQLPacket.read(data);
        }
        ctx.fireChannelRead(mySQLPacket);

    }
}
