package com.lkh.consumer;

import java.util.Date;

import com.lkh.api.HelloService;
import com.lkh.netty.NettyClient;

public class ClientBootstrap {

	public static final String providerName = "HelloService#hello#";

	public static void main(String[] args) throws InterruptedException {

		NettyClient consumer = new NettyClient();
		// 创建一个代理对象
		HelloService service = (HelloService) consumer.getBean(HelloService.class, providerName);

		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			System.out.println(service.hello("are you ok ?"+new  Date()));
		}
	}

}
