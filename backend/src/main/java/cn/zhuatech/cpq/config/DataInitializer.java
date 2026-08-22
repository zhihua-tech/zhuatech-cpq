/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.config;

import cn.zhuatech.cpq.model.*;
import cn.zhuatech.cpq.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(CatalogRepository catalogs, QuoteRepository orders,
                           PriceRuleRepository priceRules, ApprovalRequestRepository approvalRequests,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (catalogs.count() > 0) return;
            Catalog chemistry = catalogs.save(new Catalog("CAT-CHEM", "大客户报价中心", "销售运营中心", 180));
            Catalog micro = catalogs.save(new Catalog("CAT-MICRO", "渠道报价中心", "研发中心", 120));
            Catalog material = catalogs.save(new Catalog("CAT-MAT", "解决方案中心", "工程中心", 96));

            Quote t1 = orders.save(new Quote("QT-260801-018", "GB-T-228", "工业设备年度框架报价", material, 24, 16, 1, LocalDate.now().plusDays(1), Quote.Status.RUNNING, "S260801-A"));
            Quote t2 = orders.save(new Quote("QT-260801-021", "HPLC-042", "私有化软件许可报价", chemistry, 18, 8, 0, LocalDate.now().plusDays(1), Quote.Status.RUNNING, "S260801-C"));
            Quote t3 = orders.save(new Quote("QT-260802-006", "ISO-4833", "渠道标准套餐报价", micro, 12, 0, 0, LocalDate.now().plusDays(3), Quote.Status.RELEASED, "S260802-B"));
            Quote t4 = orders.save(new Quote("QT-260731-015", "ICP-017", "海外交付服务报价", chemistry, 20, 20, 1, LocalDate.now(), Quote.Status.COMPLETED, "S260731-D"));

            priceRules.saveAll(List.of(
                new PriceRule("PR-HPLC-03", "阶梯折扣规则 03", chemistry, PriceRule.Status.RUNNING, 88),
                new PriceRule("PR-ICP-02", "年度返利计算规则", chemistry, PriceRule.Status.IDLE, 76),
                new PriceRule("PR-UTM-05", "渠道授权价规则", material, PriceRule.Status.RUNNING, 91),
                new PriceRule("PR-INC-08", "最低毛利保护规则 08", micro, PriceRule.Status.ALARM, 62)
            ));
            approvalRequests.saveAll(List.of(
                new ApprovalRequest("APR-260801-032", t1, "留样审批", 6, 0, ApprovalRequest.Result.PASSED, "周妍"),
                new ApprovalRequest("APR-260801-011", t2, "前处理审批", 3, 0, ApprovalRequest.Result.PASSED, "陆承"),
                new ApprovalRequest("APR-260801-018", t4, "结果审批", 5, 1, ApprovalRequest.Result.FAILED, "周妍"),
                new ApprovalRequest("APR-260802-003", t3, "收样确认", 4, 0, ApprovalRequest.Result.PENDING, "陆承")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆承", UserAccount.Role.SALES_REP, "CAT-CHEM"),
                new UserAccount("planner", demo, "周妍", UserAccount.Role.PRICING_MANAGER, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
