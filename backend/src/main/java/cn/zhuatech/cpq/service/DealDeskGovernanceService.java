/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.service;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class DealDeskGovernanceService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result evaluate(Request request) {
        int discountBps = request.listPriceCents() == 0 ? 0
                : (int) ((request.listPriceCents() - request.netPriceCents()) * 10_000L / request.listPriceCents());
        int marginBps = request.netPriceCents() == 0 ? -10_000
                : (int) ((request.netPriceCents() - request.costCents()) * 10_000L / request.netPriceCents());
        List<String> blockers = new ArrayList<>();
        List<String> approvals = new ArrayList<>();
        if (request.netPriceCents() > request.listPriceCents()) blockers.add("净价不得高于目录价");
        if (request.netPriceCents() < request.costCents()) blockers.add("报价低于成本");
        if (discountBps > request.maxDiscountBps()) approvals.add("折扣超出销售授权，需要 Deal Desk 审批");
        if (marginBps < 2_000) approvals.add("毛利率低于 20%，需要财务审批");
        if (request.legalTermsChanged() && !request.legalApproved()) blockers.add("非标法务条款尚未批准");
        String decision = !blockers.isEmpty() ? "BLOCKED" : !approvals.isEmpty() ? "APPROVAL_REQUIRED" : "APPROVED";
        return new Result(request.quoteNo(), decision, discountBps, marginBps,
                List.copyOf(blockers), List.copyOf(approvals), "APPROVED".equals(decision));
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String quoteNo, @Min(1) long listPriceCents,
                          @Min(0) long netPriceCents, @Min(0) long costCents,
                          @Min(0) @Max(10_000) int maxDiscountBps,
                          boolean legalTermsChanged, boolean legalApproved) {
        /**
         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
         */
        public Request {
            if (quoteNo == null || quoteNo.isBlank()) throw new IllegalArgumentException("quoteNo is required");
            if (listPriceCents < 1 || netPriceCents < 0 || costCents < 0) throw new IllegalArgumentException("invalid price values");
            if (maxDiscountBps < 0 || maxDiscountBps > 10_000) throw new IllegalArgumentException("maxDiscountBps must be 0..10000");
        }
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(String quoteNo, String decision, int discountBps, int marginBps,
                         List<String> blockers, List<String> requiredApprovals, boolean orderConversionAllowed) {}
}
