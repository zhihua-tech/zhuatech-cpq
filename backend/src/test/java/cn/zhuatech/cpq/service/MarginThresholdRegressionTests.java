/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.*;
import java.util.*;
import org.junit.jupiter.api.Test;

/** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
class MarginThresholdRegressionTests {
  private final MarginGuardService service = new MarginGuardService();

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  private MarginGuardService.Result run(String cost) {
    return service.evaluate(
        new MarginGuardService.Request("Q", new BigDecimal("100"), 0, new BigDecimal(cost), 1, 0));
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void belowTenIsBlockedBeforeDisplayRounding() {
    var r = run("90.001");
    assertEquals(new BigDecimal("10.00"), r.marginPercent());
    assertEquals("BLOCK", r.decision());
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void belowTwentyFiveStillRequiresApproval() {
    var r = run("75.001");
    assertEquals(new BigDecimal("25.00"), r.marginPercent());
    assertEquals("APPROVAL", r.decision());
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void exactTenRequiresApproval() {
    assertEquals("APPROVAL", run("90").decision());
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void exactTwentyFiveCanAutoApprove() {
    assertEquals("AUTO_APPROVE", run("75").decision());
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void fullDiscountCannotPass() {
    assertEquals(
        "BLOCK",
        service
            .evaluate(
                new MarginGuardService.Request("Q", BigDecimal.TEN, 100, BigDecimal.ONE, 1, 0))
            .decision());
  }
}
