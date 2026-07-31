# CPQ 架构

版权所有 © 2026 上海如静知华信息科技有限公司。

浏览器通过 Vue 管理端或销售顾问端访问 Spring Boot REST API。安全层完成 JWT 与角色鉴权，业务层负责报价任务、配置方案、价格规则、审批和结果记录，JPA/Flyway 管理 MySQL 数据。

管理端角色为 `PRICING_MANAGER`、`QUALITY`、`ADMIN`；执行端角色为 `SALES_REP`。正式部署建议将价格规则连接置于独立采集服务，并隔离报价中心网络和办公网络。
