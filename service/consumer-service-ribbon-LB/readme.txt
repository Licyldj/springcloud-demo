provider-service.ribbon.NFLoadBalancerRuleClassName=com.netflix.loadbalancer.RandomRule
负载均衡策略
1.RandomRule(随机策略)

2.RoundRobinRule(轮询策略)

3.RetryRule(重试策略)

4.BestAvailableRule(最低并发策略)

5.ResponseTimeWeightedRule(响应时间加权策略)

6.ZoneAvoidanceRule(区域权衡策略)

其中最常用的两种策略是RandomRule和RoundRobinRule两种策略。
