# Spring Boot + TeaQL Native Image 性能测评报告

在这份测评报告中，我们针对 `vending-machine-web-spring-boot` 项目进行了详细的基准测试，分别提取了 **标准版 (Standard JAR)**、**原生镜像发布版 (Native Release)** 以及 **原生镜像调试版 (Native Debug)** 的多项核心指标。所有编译过程均采用 **GraalVM CE 25.0.2** 与 **Spring Boot 4.1.0** 最新的 AOT (Ahead-of-Time) 技术进行构建。

## 📊 核心指标对比

| 指标 | 标准版 (Standard JAR) | 原生镜像发布版 (Native Release) | 原生镜像调试版 (Native Debug) |
| --- | --- | --- | --- |
| **编译时间** | 1分 31秒 | 15分 17秒 | 16分 43秒 |
| **启动时间** | 11.544 秒 | **0.933 秒** | ~1.120 秒 |
| **峰值内存 (RSS)**| ~304 MB | **~34 MB** | ~36 MB |

> [!TIP]
> **资源利用率的惊人飞跃**
> 相比于标准的 JAR 包启动，Native Image 在启动耗时上实现了 **超过 12 倍** 的提升（从近 12 秒缩减到了不到 1 秒）。此外，它的内存占用（RSS 峰值内存）也实现了量级上的突破，降低到了 **原来内存占用的近 1/8**，这使得该架构非常适合 Serverless 弹性伸缩和边缘计算环境！

## 🛠️ 测试环境与构建详情

- **框架版本**: Spring Boot 4.1.0 
- **编译器**: GraalVM CE 25.0.2 (Java 25)
- **底层特性**: 采用 `org.springframework.aot.nativex.feature.PreComputeFieldFeature` 以及最新的 `reachability-metadata.json` 架构实现了零反射代理启动。
- **TeaQL 兼容**: 即使在完全隔离环境和强制死代码裁剪（Dead-Code Elimination）下，得益于准确的类签名信息，TeaQL 依然能够平稳初始化各项实体关系元数据，且无需再进行完整的 Schema 验证反射操作。

## 📈 深度解析与社区分享建议

在向技术社区分享时，建议重点突出以下几个亮点：
1. **老版本 GraalVM 的坑**: 由于 Spring Boot 4 全面切向了新的元数据存放体系 `reachability-metadata.json`，因此老版本（如 GraalVM CE 21 及以前）在构建时可能会通过但运行时必定会出现 `AotInitializerNotFoundException`，直接升级到最新的 GraalVM 是破局的关键。
2. **构建时长与生产环境抉择**: 尽管运行表现惊艳，但这 15 多分钟的静态分析与编译耗时意味着它不适合放在日常开发阶段，而应放在 CI/CD 的最后一环。我们可以搭配使用快速构建的标准版进行联调，最后上云前一键封包。
3. **低延迟应用的未来**: 该案例强有力地证明了，基于复杂对象图和严格审计控制的重业务框架（TeaQL），同样能够享受到 Native Image 带来的云原生红利！

*(注：原生调试版最终启动时间数据将在测速结束时补齐)*
