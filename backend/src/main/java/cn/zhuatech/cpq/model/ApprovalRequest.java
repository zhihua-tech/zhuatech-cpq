/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="cpq_approval_request") public class ApprovalRequest extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String approvalRequestNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private Quote quote;
    @Column(nullable=false,length=30) private String approvalRequestType; @Column(nullable=false) private int approvalRequestQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected ApprovalRequest(){} /**
                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                   */
public ApprovalRequest(String approvalRequestNo,Quote quote,String approvalRequestType,int approvalRequestQty,int defectQty,Result result,String inspector){this.approvalRequestNo=approvalRequestNo;this.quote=quote;this.approvalRequestType=approvalRequestType;this.approvalRequestQty=approvalRequestQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getApprovalRequestNo(){return approvalRequestNo;} /**
                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                     */
public Quote getQuote(){return quote;} /**
                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                            */
public String getApprovalRequestType(){return approvalRequestType;} /**
                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                */
public int getApprovalRequestQty(){return approvalRequestQty;} /**
                                                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                               */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                            */
public Result getResult(){return result;} /**
                                                                                                                                                                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                      */
public String getInspector(){return inspector;}
}
