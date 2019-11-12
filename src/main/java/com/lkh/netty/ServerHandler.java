package com.lkh.netty;

import com.lkh.consumer.ClientBootstrap;
import com.lkh.provider.HelloServiceImpl;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 用于处理请求数据
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {

    // 如果符合约定，则调用本地方法，返回数据
    if (msg.toString().startsWith(ClientBootstrap.providerName)) {
      String result = new HelloServiceImpl()
          .hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
      ctx.writeAndFlush(result);
    }

  }
}
