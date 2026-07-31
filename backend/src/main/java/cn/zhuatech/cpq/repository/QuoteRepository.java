/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cpq.repository; import cn.zhuatech.cpq.model.Quote; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface QuoteRepository extends JpaRepository<Quote,Long>{List<Quote> findAllByOrderByDueDateAsc();List<Quote> findByCatalogCodeOrderByDueDateAsc(String code);long countByStatus(Quote.Status status);}
