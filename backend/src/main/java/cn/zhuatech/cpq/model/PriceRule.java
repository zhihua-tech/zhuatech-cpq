/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="cpq_price_rule") public class PriceRule extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Status { RUNNING, IDLE, MAINTENANCE, ALARM }
    @Column(nullable=false,unique=true,length=32) private String code; @Column(nullable=false,length=80) private String name; @ManyToOne(optional=false,fetch=FetchType.LAZY) private Catalog catalog;
    @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Status status; @Column(nullable=false) private int oee; @Column(nullable=false) private LocalDateTime lastHeartbeat;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected PriceRule(){} /**
                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                             */
public PriceRule(String code,String name,Catalog catalog,Status status,int oee){this.code=code;this.name=name;this.catalog=catalog;this.status=status;this.oee=oee;this.lastHeartbeat=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getCode(){return code;} /**
                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                           */
public String getName(){return name;} /**
                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                 */
public Catalog getCatalog(){return catalog;} /**
                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                              */
public Status getStatus(){return status;} /**
                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                        */
public int getOee(){return oee;} /**
                                                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                         */
public LocalDateTime getLastHeartbeat(){return lastHeartbeat;}
}
