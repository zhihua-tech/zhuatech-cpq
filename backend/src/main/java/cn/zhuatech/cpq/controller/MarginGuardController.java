/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.controller;

import cn.zhuatech.cpq.common.ApiResponse;
import cn.zhuatech.cpq.service.MarginGuardService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/admin")
public class MarginGuardController {
    private final MarginGuardService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public MarginGuardController(MarginGuardService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/margin-guard")
    public ApiResponse<MarginGuardService.Result> evaluate(@Valid @RequestBody MarginGuardService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
