package com.bs.project.config.websocket;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * WebSocket 配置
 */
@Configuration
@EnableWebSocketMessageBroker//开启使用STOMP协议传输
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		//注册STOMP协议的节点，并映射指定的URL，指定使用SockJS协议
		stompEndpointRegistry.addEndpoint("/any-socket").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {//配置消息代理 Message Broker

		messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
		//广播式应配置一个  /topic 消息代理
		messageBrokerRegistry.enableSimpleBroker("/topic", "/queue");
	}

	@Override
	public void configureWebSocketTransport(final WebSocketTransportRegistration registration) {
		registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
			@Override
			public WebSocketHandler decorate(final WebSocketHandler handler) {
				return new WebSocketHandlerDecorator(handler) {
					@Override
					public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
						String username = session.getPrincipal().getName();

						super.afterConnectionEstablished(session);
					}

					@Override
					public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
							throws Exception {
						String username = session.getPrincipal().getName();

						super.afterConnectionClosed(session, closeStatus);
					}
				};
			}
		});
		super.configureWebSocketTransport(registration);
	}
}
