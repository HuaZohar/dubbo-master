# dubbo的框架

![](D:\learn\dubbo\dubbo原理整理\dubbo-framework.jpg)

- **config 配置层**：对外配置接口，以 `ServiceConfig`, `ReferenceConfig` 为中心，可以直接初始化配置类，也可以通过 spring 解析配置生成配置类
- **proxy 服务代理层**：服务接口透明代理，生成服务的客户端 Stub 和服务器端 Skeleton, 以 `ServiceProxy`为中心，扩展接口为 `ProxyFactory`
- **registry 注册中心层**：封装服务地址的注册与发现，以服务 URL 为中心，扩展接口为 `RegistryFactory`, `Registry`, `RegistryService`
- **cluster 路由层**：封装多个提供者的路由及负载均衡，并桥接注册中心，以 `Invoker` 为中心，扩展接口为 `Cluster`, `Directory`, `Router`, `LoadBalance`
- **monitor 监控层**：RPC 调用次数和调用时间监控，以 `Statistics` 为中心，扩展接口为 `MonitorFactory`, `Monitor`, `MonitorService`
- **protocol 远程调用层**：封装 RPC 调用，以 `Invocation`, `Result` 为中心，扩展接口为 `Protocol`, `Invoker`, `Exporter`
- **exchange 信息交换层**：封装请求响应模式，同步转异步，以 `Request`, `Response` 为中心，扩展接口为 `Exchanger`, `ExchangeChannel`, `ExchangeClient`, `ExchangeServer`
- **transport 网络传输层**：抽象 mina 和 netty 为统一接口，以 `Message` 为中心，扩展接口为 `Channel`, `Transporter`, `Client`, `Server`, `Codec`
- **serialize 数据序列化层**：可复用的一些工具，扩展接口为 `Serialization`, `ObjectInput`, `ObjectOutput`, `ThreadPool`

# dubbo的配置加载源码

```
1. 执行com.alibaba.dubbo.config.spring.schema.DubboNamespaceHandler 中的init()方法
	向private final Map<String, BeanDefinitionParser> parsers = new HashMap<>();添加各个配置项和BeanDefinitionParser
2.依次执行DubboBeanDefinitionParser类的解析方法parse()，进行解析，并把配置信息注册
```

# dubbo的服务暴露源码

![img](D:\learn\dubbo\dubbo原理整理\dubbo-服务暴露.jpg)

```java
对配置文件中标签<dubbo:service interface="com.learn.service.UserService" ref="userService"/>进行解析暴露
1.ServiceBean
	1.1 实现了InitializingBean接口的afterPropertiesSet方法
		1.1.1 分别注册保存各种组件，包含provider、application、module、registries、Monitor、Protocol、Path
	1.2 监听了spring容器刷新完成时间，即实现了ApplicationListener<ContextRefreshedEvent>接口
		监听方法为onApplicationEvent()
		1.2.1 export();
		1.2.2 ServiceConfig.doExport() -> doExportUrls() -> doExportUrlsFor1Protocol()
		1.2.3 doExportUrlsFor1Protocol()方法中
			1.2.3.1获取指定接口、指定实现类、指定注册中心、指定协议的执行器 invoker，并进行包装
			1.2.3.2调用protocol.export(wrapperInvoker);
			有两个Proticol，DubboProtocol和RegistryProtocol。
			1.2.3.2.1先执行RegistryProtocol.export() -> doLocalExport(originInvoker) 
                1)DubboProtocol.export()
			DubboProtocol.export() -> openServer(url) 
             -> Exchangers.bind(url, requestHandler)
             -> Transporters.bind(url, new DecodeHandler(new HeaderExchangeHandler(handler)))
             -> NettyServer/MinaTransporter
             	2)ProviderConsumerRegTable.registerProvider(originInvoker, registryUrl, registedProviderUrl);注册服务到注册中心
//    public static ConcurrentHashMap<String, Set<ProviderInvokerWrapper>> providerInvokers = new ConcurrentHashMap<String, Set<ProviderInvokerWrapper>>();
//    public static ConcurrentHashMap<String, Set<ConsumerInvokerWrapper>> consumerInvokers = new ConcurrentHashMap<String, Set<ConsumerInvokerWrapper>>();		
```

# dubbo的服务引用源码

![](D:\learn\dubbo\dubbo原理整理\dubbo-服务引用.jpg)

```
对配置文件<dubbo:reference id="userService" interface="com.learn.service.UserService"/>解析引用服务

1.ReferenceBean
	1.1 实现了InitializingBean接口的afterPropertiesSet方法
		1.1.1 分别注册保存各种组件，包含consumer、application、module、registries、Monitor
	1.2 FactoryBean  自定义Bean的生成，调用getObject()接口
		get()->init()->createProxy(map)->Protocol.refer()
		1.2.1 有两个Protocol，DubboProtocol和RegistryProtocol
		1.2.1.1 先执行RegistryProtocol.refer()方法
			1）directory.subscribe()内部调用
			DubboProtocol.refer()
				->getClients(url);
					->getSharedClient(url);
						->initClient(url);
							->Exchangers.connect(url, requestHandler);
								->Transporters.connect(url, new DecodeHandler(new HeaderExchangeHandler(handler)));
		1.2.1.2 注册到注册表，ProviderConsumerRegTable.registerConsumer(invoker, url, subscribeUrl, directory); 返回执行器
	1.3 返回代理对象 proxyFactory.getProxy(invoker);
2. 把代理对象保存到容器中
```

# dubbo的服务执行源码

```
//代理服务接口执行

1.InvokerInvocationHandler.invoke()方法
```

