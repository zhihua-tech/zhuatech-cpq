/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="cpq_price_rule") public class PriceRule extends BaseEntity {
    public enum Status { RUNNING, IDLE, MAINTENANCE, ALARM }
    @Column(nullable=false,unique=true,length=32) private String code; @Column(nullable=false,length=80) private String name; @ManyToOne(optional=false,fetch=FetchType.LAZY) private Catalog catalog;
    @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Status status; @Column(nullable=false) private int oee; @Column(nullable=false) private LocalDateTime lastHeartbeat;
    protected PriceRule(){} public PriceRule(String code,String name,Catalog catalog,Status status,int oee){this.code=code;this.name=name;this.catalog=catalog;this.status=status;this.oee=oee;this.lastHeartbeat=LocalDateTime.now();}
    public String getCode(){return code;} public String getName(){return name;} public Catalog getCatalog(){return catalog;} public Status getStatus(){return status;} public int getOee(){return oee;} public LocalDateTime getLastHeartbeat(){return lastHeartbeat;}
}
