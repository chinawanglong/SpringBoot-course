[toc]

## SpringBoot 事物配置管理

> Spring Boot 默认的事物规则是遇到运行时异常（RuntimeException）和程序错误（error）才会回滚。针对非运行时异常，如果要进行事物回滚的话，可以在@Transactional注解中使用rollback属性来指定异常，比如@Transactional(rollback=Exception.class)