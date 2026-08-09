/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cpq.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountApprovalRoutingService {
    public Result route(Request request) {
        BigDecimal discountAmount = request.listAmount().multiply(request.discountRate())
            .setScale(2, RoundingMode.HALF_UP);
        BigDecimal netAmount = request.listAmount().subtract(discountAmount)
            .setScale(2, RoundingMode.HALF_UP);
        String approvalLevel = request.discountRate().compareTo(new BigDecimal("0.30")) >= 0
            || request.dealRiskScore() >= 85 ? "EXECUTIVE"
            : request.grossMarginRate().compareTo(new BigDecimal("0.12")) < 0
                || request.paymentTermDays() > 90 ? "FINANCE"
            : request.discountRate().compareTo(new BigDecimal("0.20")) >= 0
                || request.dealRiskScore() >= 60 ? "SALES_DIRECTOR"
            : request.discountRate().compareTo(new BigDecimal("0.10")) >= 0
                || request.strategicCustomer() ? "SALES_MANAGER" : "AUTO_APPROVE";

        List<String> approvalPath = new ArrayList<>();
        approvalPath.add("销售负责人");
        if (List.of("SALES_DIRECTOR", "FINANCE", "EXECUTIVE").contains(approvalLevel)) approvalPath.add("销售总监");
        if (List.of("FINANCE", "EXECUTIVE").contains(approvalLevel)) approvalPath.add("财务负责人");
        if ("EXECUTIVE".equals(approvalLevel)) approvalPath.add("经营管理层");
        if ("AUTO_APPROVE".equals(approvalLevel)) approvalPath = List.of("规则自动审批");
        return new Result(request.quoteNo(), netAmount, discountAmount,
            approvalLevel, approvalPath, "AUTO_APPROVE".equals(approvalLevel));
    }

    public record Request(@NotBlank String quoteNo, @DecimalMin("0.01") BigDecimal listAmount,
                          @DecimalMin("0") @DecimalMax("1") BigDecimal discountRate,
                          @DecimalMin("0") @DecimalMax("1") BigDecimal grossMarginRate,
                          @Min(0) @Max(100) int dealRiskScore, boolean strategicCustomer,
                          @Min(0) int paymentTermDays) {}

    public record Result(String quoteNo, BigDecimal netAmount, BigDecimal discountAmount,
                         String approvalLevel, List<String> approvalPath,
                         boolean automatic) {}
}
