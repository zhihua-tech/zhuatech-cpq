/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.repository; import cn.zhuatech.cpq.model.PriceRule; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface PriceRuleRepository extends JpaRepository<PriceRule,Long>{List<PriceRule> findAllByOrderByCodeAsc();long countByStatus(PriceRule.Status status);}
