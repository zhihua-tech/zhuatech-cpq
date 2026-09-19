/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.repository; import cn.zhuatech.cpq.model.ApprovalRequest; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest,Long>{/**
                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                        */
List<ApprovalRequest> findTop10ByOrderByIdDesc();/**
                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                         */
long countByResult(ApprovalRequest.Result result);}
