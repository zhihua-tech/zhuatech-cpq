/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cpq.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class MarginGuardService {
    public Result evaluate(Request request) {
        BigDecimal netUnitPrice = request.listPrice().multiply(BigDecimal.ONE.subtract(
            BigDecimal.valueOf(request.discountPercent()).divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)));
        BigDecimal revenue = netUnitPrice.multiply(BigDecimal.valueOf(request.quantity())).setScale(2, RoundingMode.HALF_UP);
        BigDecimal marginPercent = netUnitPrice.signum() == 0 ? BigDecimal.valueOf(-100)
            : netUnitPrice.subtract(request.unitCost()).divide(netUnitPrice, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        String decision = marginPercent.compareTo(BigDecimal.TEN) < 0 ? "BLOCK"
            : marginPercent.compareTo(BigDecimal.valueOf(25)) < 0 || request.discountPercent() > 20 || request.dealRisk() >= 60
            ? "APPROVAL" : "AUTO_APPROVE";
        List<String> reasons = new ArrayList<>();
        if (marginPercent.compareTo(BigDecimal.valueOf(25)) < 0) reasons.add("报价毛利低于标准阈值");
        if (request.discountPercent() > 20) reasons.add("折扣超过销售自主权限");
        if (request.dealRisk() >= 60) reasons.add("交易风险需要商务复核");
        return new Result(request.quoteNo(), netUnitPrice.setScale(2, RoundingMode.HALF_UP), revenue,
            marginPercent.setScale(2, RoundingMode.HALF_UP), decision, !"AUTO_APPROVE".equals(decision), reasons);
    }

    public record Request(@NotBlank String quoteNo, @DecimalMin("0") BigDecimal listPrice,
                          @DecimalMin("0") @DecimalMax("100") double discountPercent,
                          @DecimalMin("0") BigDecimal unitCost, @Positive int quantity,
                          @Min(0) @Max(100) int dealRisk) {}
    public record Result(String quoteNo, BigDecimal netUnitPrice, BigDecimal revenue,
                         BigDecimal marginPercent, String decision,
                         boolean approvalRequired, List<String> reasons) {}
}
