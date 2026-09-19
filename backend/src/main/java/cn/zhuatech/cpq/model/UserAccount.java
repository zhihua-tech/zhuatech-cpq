/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.model;
import jakarta.persistence.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="cpq_user")
public class UserAccount extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Role { ADMIN, PRICING_MANAGER, SALES_REP, QUALITY }
    @Column(nullable=false,unique=true,length=32) private String username; @Column(nullable=false) private String password;
    @Column(nullable=false,length=50) private String fullName; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Role role;
    @Column(name="catalog_code",length=32) private String catalogCode; @Column(nullable=false) private boolean enabled=true;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected UserAccount(){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public UserAccount(String username,String password,String fullName,Role role,String catalogCode){this.username=username;this.password=password;this.fullName=fullName;this.role=role;this.catalogCode=catalogCode;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getUsername(){return username;} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String getPassword(){return password;} /**
                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                 */
public String getFullName(){return fullName;} /**
                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                               */
public Role getRole(){return role;} /**
                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                   */
public String getCatalogCode(){return catalogCode;} /**
                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                       */
public boolean isEnabled(){return enabled;}
}
