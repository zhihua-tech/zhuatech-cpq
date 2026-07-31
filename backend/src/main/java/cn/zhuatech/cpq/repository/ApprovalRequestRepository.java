/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cpq.repository; import cn.zhuatech.cpq.model.ApprovalRequest; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest,Long>{List<ApprovalRequest> findTop10ByOrderByIdDesc();long countByResult(ApprovalRequest.Result result);}
