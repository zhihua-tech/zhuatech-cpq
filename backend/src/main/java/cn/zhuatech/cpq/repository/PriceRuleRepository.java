/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.repository; import cn.zhuatech.cpq.model.PriceRule; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface PriceRuleRepository extends JpaRepository<PriceRule,Long>{/**
                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                            */
List<PriceRule> findAllByOrderByCodeAsc();/**
                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                      */
long countByStatus(PriceRule.Status status);}
