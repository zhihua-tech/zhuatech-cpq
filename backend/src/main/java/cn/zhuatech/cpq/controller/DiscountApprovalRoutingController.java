/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.controller;

import cn.zhuatech.cpq.common.ApiResponse;
import cn.zhuatech.cpq.service.DiscountApprovalRoutingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cpq/insights")
public class DiscountApprovalRoutingController {
    private final DiscountApprovalRoutingService service;

    public DiscountApprovalRoutingController(DiscountApprovalRoutingService service) {
        this.service = service;
    }

    @PostMapping("/discount-approval-routing")
    public ApiResponse<DiscountApprovalRoutingService.Result> route(
        @Valid @RequestBody DiscountApprovalRoutingService.Request request) {
        return ApiResponse.ok(service.route(request));
    }
}
