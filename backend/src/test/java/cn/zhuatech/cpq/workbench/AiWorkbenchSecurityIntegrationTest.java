/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.workbench;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import cn.zhuatech.cpq.security.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
@SpringBootTest
@AutoConfigureMockMvc
class AiWorkbenchSecurityIntegrationTest {
  @Autowired MockMvc mvc;
  @Autowired JwtService jwt;

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void securityFilterRejectsAnonymous() throws Exception {
    mvc.perform(
            post("/api/workbench/configuration-dependency-check")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"quantity\":2,\"requiredGroups\":[\"BASE\",\"SUPPORT\"],\"options\":[{\"id\":\"CORE\",\"group\":\"BASE\",\"unitCost\":100,\"requires\":[],\"excludes\":[]},{\"id\":\"EXT\",\"group\":\"FEATURE\",\"unitCost\":20,\"requires\":[\"CORE\"],\"excludes\":[]},{\"id\":\"SUP\",\"group\":\"SUPPORT\",\"unitCost\":10,\"requires\":[],\"excludes\":[]}],\"selected\":[\"EXT\"]}"))
        .andExpect(status().isUnauthorized());
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void securityFilterRejectsInvalidBearer() throws Exception {
    mvc.perform(
            post("/api/workbench/configuration-dependency-check")
                .header("Authorization", "Bearer invalid-token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"quantity\":2,\"requiredGroups\":[\"BASE\",\"SUPPORT\"],\"options\":[{\"id\":\"CORE\",\"group\":\"BASE\",\"unitCost\":100,\"requires\":[],\"excludes\":[]},{\"id\":\"EXT\",\"group\":\"FEATURE\",\"unitCost\":20,\"requires\":[\"CORE\"],\"excludes\":[]},{\"id\":\"SUP\",\"group\":\"SUPPORT\",\"unitCost\":10,\"requires\":[],\"excludes\":[]}],\"selected\":[\"EXT\"]}"))
        .andExpect(status().isUnauthorized());
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void authenticatedCallerCanCompute() throws Exception {
    mvc.perform(
            post("/api/workbench/configuration-dependency-check")
                .header("Authorization", "Bearer " + jwt.generate("operator"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"quantity\":2,\"requiredGroups\":[\"BASE\",\"SUPPORT\"],\"options\":[{\"id\":\"CORE\",\"group\":\"BASE\",\"unitCost\":100,\"requires\":[],\"excludes\":[]},{\"id\":\"EXT\",\"group\":\"FEATURE\",\"unitCost\":20,\"requires\":[\"CORE\"],\"excludes\":[]},{\"id\":\"SUP\",\"group\":\"SUPPORT\",\"unitCost\":10,\"requires\":[],\"excludes\":[]}],\"selected\":[\"EXT\"]}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true));
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void authenticatedCallerGetsValidationError() throws Exception {
    mvc.perform(
            post("/api/workbench/configuration-dependency-check")
                .header("Authorization", "Bearer " + jwt.generate("operator"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.success").value(false));
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void existingBusinessEndpointRegression() throws Exception {
    mvc.perform(
            post("/api/admin/margin-guard")
                .header("Authorization", "Bearer " + jwt.generate("planner"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"quoteNo\":\"Q\",\"listPrice\":100,\"discountPercent\":0,\"unitCost\":90.001,\"quantity\":1,\"dealRisk\":0}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.decision").value("BLOCK"));
  }
}
