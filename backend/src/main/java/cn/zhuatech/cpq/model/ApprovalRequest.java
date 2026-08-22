/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="cpq_approval_request") public class ApprovalRequest extends BaseEntity {
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String approvalRequestNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private Quote quote;
    @Column(nullable=false,length=30) private String approvalRequestType; @Column(nullable=false) private int approvalRequestQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    protected ApprovalRequest(){} public ApprovalRequest(String approvalRequestNo,Quote quote,String approvalRequestType,int approvalRequestQty,int defectQty,Result result,String inspector){this.approvalRequestNo=approvalRequestNo;this.quote=quote;this.approvalRequestType=approvalRequestType;this.approvalRequestQty=approvalRequestQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    public String getApprovalRequestNo(){return approvalRequestNo;} public Quote getQuote(){return quote;} public String getApprovalRequestType(){return approvalRequestType;} public int getApprovalRequestQty(){return approvalRequestQty;} public int getDefectQty(){return defectQty;} public Result getResult(){return result;} public String getInspector(){return inspector;}
}
