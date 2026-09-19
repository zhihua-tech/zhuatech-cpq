/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.controller;
import cn.zhuatech.cpq.common.ApiResponse;
import cn.zhuatech.cpq.service.DealDeskGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/quotes")
public class DealDeskGovernanceController {
    private final DealDeskGovernanceService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DealDeskGovernanceController(DealDeskGovernanceService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/deal-desk")
    public ApiResponse<DealDeskGovernanceService.Result> evaluate(
            @Valid @RequestBody DealDeskGovernanceService.Request request) { return ApiResponse.ok(service.evaluate(request)); }
}
