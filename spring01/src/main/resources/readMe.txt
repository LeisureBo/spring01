AOP实现方式1：针对某个类对象的全部方法进行AOP切面处理(spring-aop-1.xml)
实现途径：spring提供的类org.springframework.aop.framework.ProxyFactoryBean
AOP实现方式2：针对某个类的指定方法进行AOP切面处理(spring-aop-2.xml)
实现途径：spring提供的接口org.springframework.aop.support.NameMatchMethodPointcut

使用 ProxyFactoryBean 来创建 AOP 代理的最重要的优点之一是 IoC 可以管理通知和切入点。 这是一个非常的强大的功能，能够实现其他 AOP框架很难实现的特定的方法。
例如，一个通知本身可以引用应用对象（除了目标对象，它在任何AOP 框架中都可以引用应用对象），这完全得益于依赖注入所提供的可插入性。

注意：
1.ProxyFactoryBean的proxyInterfaces属性只支持使用字符串的方式进行注入，不支持使用Bean的依赖方式进行注入。
2.如果ProxyFactoryBean的proxyInterfaces 属性没有被设置，但是目标类实现了一个（或者更多）接口，
那么ProxyFactoryBean 将自动检测到这个目标类已经实现了至少一个接口， 一个基于JDK的代理将被创建 。被实际代理的接口将是目标类所实现的全部接口；
实际上，这和在proxyInterfaces属性中列出目标类实现的每个接口的情况是一样的。然而，这将显著地减少工作量以及输入错误的可能性。

