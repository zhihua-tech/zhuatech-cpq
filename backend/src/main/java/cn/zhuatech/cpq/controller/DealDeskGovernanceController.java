/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.controller;
import cn.zhuatech.cpq.common.ApiResponse;
import cn.zhuatech.cpq.service.DealDeskGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/enterprise/quotes")
public class DealDeskGovernanceController {
    private final DealDeskGovernanceService service;
    public DealDeskGovernanceController(DealDeskGovernanceService service) { this.service = service; }
    @PostMapping("/deal-desk")
    public ApiResponse<DealDeskGovernanceService.Result> evaluate(
            @Valid @RequestBody DealDeskGovernanceService.Request request) { return ApiResponse.ok(service.evaluate(request)); }
}
