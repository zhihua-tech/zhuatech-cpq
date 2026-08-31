/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DealDeskGovernanceServiceTest {
    private final DealDeskGovernanceService service = new DealDeskGovernanceService();
    @Test void approvesQuoteWithinDiscountAndMarginGuardrails() {
        var result = service.evaluate(new DealDeskGovernanceService.Request(
                "Q-001", 1_000_000, 900_000, 600_000, 1_500, false, false));
        assertEquals("APPROVED", result.decision());
        assertEquals(1_000, result.discountBps());
        assertTrue(result.orderConversionAllowed());
    }
    @Test void blocksBelowCostQuoteWithUnapprovedTerms() {
        var result = service.evaluate(new DealDeskGovernanceService.Request(
                "Q-002", 1_000_000, 500_000, 600_000, 2_000, true, false));
        assertEquals("BLOCKED", result.decision());
        assertEquals(2, result.blockers().size());
        assertFalse(result.orderConversionAllowed());
    }
}
