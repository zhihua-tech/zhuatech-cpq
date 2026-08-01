/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cpq.controller;

import cn.zhuatech.cpq.common.ApiResponse;
import cn.zhuatech.cpq.service.MarginGuardService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class MarginGuardController {
    private final MarginGuardService service;
    public MarginGuardController(MarginGuardService service) { this.service = service; }
    @PostMapping("/margin-guard")
    public ApiResponse<MarginGuardService.Result> evaluate(@Valid @RequestBody MarginGuardService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
