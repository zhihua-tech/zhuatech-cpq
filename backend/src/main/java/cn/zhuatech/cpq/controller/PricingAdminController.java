/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.controller; import cn.zhuatech.cpq.common.ApiResponse; import cn.zhuatech.cpq.dto.CpqDto.*; import cn.zhuatech.cpq.service.CpqService; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasAnyRole('PRICING_MANAGER','QUALITY','ADMIN')") public class PricingAdminController {private final CpqService service;/**
                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                      */
public PricingAdminController(CpqService service){this.service=service;}/**
                                                                                                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                              */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.adminDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                   */
@GetMapping("/work-orders") public ApiResponse<List<QuoteView>> orders(){return ApiResponse.ok(service.quotes());}}
