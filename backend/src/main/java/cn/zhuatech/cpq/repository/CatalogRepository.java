/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.repository; import cn.zhuatech.cpq.model.Catalog; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface CatalogRepository extends JpaRepository<Catalog,Long>{/**
                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                        */
Optional<Catalog> findByCode(String code);}
