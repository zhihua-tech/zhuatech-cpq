/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.dto;
import jakarta.validation.constraints.*; import java.time.*; import java.util.List;
public final class CpqDto { private CpqDto(){}
    public record Metric(String label,String value,String hint,String tone){}
    public record QuoteView(Long id,String orderNo,String productCode,String productName,String catalog,String workshop,int plannedQty,int completedQty,int defectQty,LocalDate dueDate,String status,String batchNo,int progress){}
    public record PriceRuleView(String code,String name,String catalog,String status,int oee,LocalDateTime lastHeartbeat){}
    public record ApprovalRequestView(String approvalRequestNo,String orderNo,String productName,String approvalRequestType,int approvalRequestQty,int defectQty,String result,String inspector){}
    public record Dashboard(List<Metric> metrics,List<QuoteView> quotes,List<PriceRuleView> priceRule,List<ApprovalRequestView> approvalRequests){}
    public record ReportRequest(@NotBlank String operationName,@Positive int goodQty,@PositiveOrZero int defectQty,@Size(max=200) String remark){}
    public record ReportResult(String orderNo,int completedQty,int defectQty,int progress,String status){}
}
