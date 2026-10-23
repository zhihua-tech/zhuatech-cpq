/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cpq.workbench;

import static cn.zhuatech.cpq.workbench.WorkbenchInput.*;

import java.math.*;
import java.util.*;
import org.springframework.stereotype.Service;

/** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
@Service
public class AiWorkbenchService {
  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  public Map<String, Object> execute(Map<String, Object> r) {
    validate(r);

    keys(r, "quantity", "requiredGroups", "options", "selected");
    int quantity = integer(r, "quantity", 1, 1000000);
    var required = strings(r, "requiredGroups", 0, 100);
    if (new HashSet<>(required).size() != required.size())
      throw new IllegalArgumentException("必选分组重复");
    Map<String, Map<String, Object>> options = new TreeMap<>();
    for (var o : rows(r, "options", 1, 200)) {
      keys(o, "id", "group", "unitCost", "requires", "excludes");
      String id = id(o, "id");
      if (options.putIfAbsent(id, o) != null) throw new IllegalArgumentException("选项重复");
      id(o, "group");
      money(o, "unitCost");
      for (String key : List.of("requires", "excludes")) {
        var refs = strings(o, key, 0, 100);
        if (new HashSet<>(refs).size() != refs.size() || refs.contains(id))
          throw new IllegalArgumentException("依赖或互斥重复/自引用");
      }
    }
    for (var o : options.values())
      for (String key : List.of("requires", "excludes"))
        if (!options.keySet().containsAll(strings(o, key, 0, 100)))
          throw new IllegalArgumentException("选项规则引用未知项");
    var selected = strings(r, "selected", 0, 200);
    if (new HashSet<>(selected).size() != selected.size()
        || !options.keySet().containsAll(selected)) throw new IllegalArgumentException("已选项重复或未知");
    Set<String> chosen = new TreeSet<>(selected), groups = new HashSet<>();
    List<Map<String, Object>> issues = new ArrayList<>();
    Set<List<String>> conflicts = new HashSet<>();
    BigDecimal cost = BigDecimal.ZERO;
    for (String id : chosen) {
      var o = options.get(id);
      groups.add(o.get("group").toString());
      cost = cost.add(money(o, "unitCost"));
      for (String ref : strings(o, "requires", 0, 100))
        if (!chosen.contains(ref))
          issues.add(Map.of("type", "MISSING_DEPENDENCY", "option", id, "required", ref));
      for (String ref : strings(o, "excludes", 0, 100))
        if (chosen.contains(ref)) {
          var pair = List.of(id.compareTo(ref) < 0 ? id : ref, id.compareTo(ref) < 0 ? ref : id);
          if (conflicts.add(pair))
            issues.add(Map.of("type", "CONFLICT", "first", pair.get(0), "second", pair.get(1)));
        }
    }
    for (String group : required)
      if (!groups.contains(group)) issues.add(Map.of("type", "MISSING_GROUP", "group", group));
    return Map.of(
        "valid",
        issues.isEmpty(),
        "issues",
        issues,
        "selectedUnitCost",
        cost,
        "totalCost",
        cost.multiply(BigDecimal.valueOf(quantity)),
        "automaticQuoteApproval",
        false);
  }
}
