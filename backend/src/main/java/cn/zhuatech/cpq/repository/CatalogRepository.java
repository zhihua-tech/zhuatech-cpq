/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cpq.repository; import cn.zhuatech.cpq.model.Catalog; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface CatalogRepository extends JpaRepository<Catalog,Long>{Optional<Catalog> findByCode(String code);}
