/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq;

import cn.zhuatech.cpq.service.DiscountApprovalRoutingService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DiscountApprovalRoutingServiceTests {
    private final DiscountApprovalRoutingService service = new DiscountApprovalRoutingService();

    @Test
    void routesLargeDiscountToSalesDirector() {
        var result = service.route(new DiscountApprovalRoutingService.Request(
            "Q-2026-1001", new BigDecimal("100000"), new BigDecimal("0.25"),
            new BigDecimal("0.22"), 40, false, 60));

        assertEquals(new BigDecimal("75000.00"), result.netAmount());
        assertEquals("SALES_DIRECTOR", result.approvalLevel());
        assertFalse(result.automatic());
    }

    @Test
    void escalatesExtremeDiscountToExecutive() {
        var result = service.route(new DiscountApprovalRoutingService.Request(
            "Q-2026-1002", new BigDecimal("200000"), new BigDecimal("0.35"),
            new BigDecimal("0.10"), 70, true, 120));

        assertEquals("EXECUTIVE", result.approvalLevel());
        assertEquals(4, result.approvalPath().size());
    }
}
