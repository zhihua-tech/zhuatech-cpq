/* Copyright 2026 上海如静知华信息科技有限公司 */
export const domain={
 code:'CPQ',systemName:'配置、定价与报价管理系统',englishName:'CONFIGURE PRICE QUOTE',
 theme:{primary:'#1f746d',dark:'#19302d',accent:'#b47735'},
 workspace:'销售运营中心 / 报价中心运营',fieldWorkspace:'大客户报价中心',period:'2026-08-01 · 周六',liveText:'价格规则数据链路正常',
 fieldContextLabel:'当前报价中心',fieldContext:'日班 · 08:30—17:30',fieldUser:'陆承',fieldRole:'销售顾问',adminUser:'周妍',adminRole:'报价中心主管',
 adminTitle:'报价中心运营驾驶舱',adminBreadcrumb:'报价中心运营 / 今日态势',adminSubtitle:'集中查看收样、报价、审批、价格规则与时限风险。',exportAction:'导出报价日报',createAction:'新建报价任务',
 chartTitle:'报价完成趋势',chartSubtitle:'当日累计完成率 / 计划目标',chartLabels:['08:30','09:30','10:30','11:30','13:30','14:30','15:30','16:30','17:30'],loadTitle:'报价中心负荷',loadSubtitle:'在检任务占可用能力',recordsTitle:'在检任务',recordsSubtitle:'按承诺时限与异常优先显示',issueTitle:'销售运营与时限风险',issueSubtitle:'需要报价中心主管处理的事项',
 recordName:'报价任务',itemName:'配置方案 / 项目',unitName:'报价中心',batchName:'配置方案批次',planName:'计划项目',doneName:'已完成',exceptionName:'异常',unitLabel:'项',
 listBreadcrumb:'报价管理 / 任务台账',listSubtitle:'统一管理收样、任务分派、报价、审批与报价单签发。',listSummary:[['今日收样','54'],['在检任务','31'],['待审批','8'],['超时风险','2',true]],tabs:['全部','待确认','报价中','待审批','已完成'],
 fieldBreadcrumb:'报价执行 / 我的工作台',fieldTitle:'理化报价工作台',fieldSubtitle:'当前 7 项在检任务 · 2 台价格规则已预约 · 工程师陆承',fieldSecondary:'交接记录',reportAction:'录入结果',fieldNoticeTitle:'环境状态合规',fieldNotice:'温湿度、价格规则校准和标准品状态均满足报价要求',
 steps:['收样确认','配置方案前处理','价格规则报价','结果审批','报价单签发'],documentAction:'查看报价产品配置',printAction:'打印配置方案标签',resourceCardTitle:'价格规则状态',resourceValueLabel:'当前柱压',resourceHealthLabel:'价格规则健康度',quickSubtitle:'报价中心高频业务入口',quickActions:[['结果录入','/shopfloor/report','原始数据与结果'],['配置方案流转','/shopfloor/material','交接与留样位置'],['价格规则预约','/shopfloor/resources','日历与使用记录'],['偏差上报','/shopfloor/andon','OOS / OOT / 环境异常']],
 reportDefaults:[3,0],reportTitle:'报价结果录入',reportSubtitle:'记录原始结果、异常数量和报价过程备注。',reportSuccess:'报价结果已保存并进入审批队列',reportPlaceholder:'填写计算依据、异常现象或重复报价说明',reportFootnote:'提交后写入原始记录并生成审计轨迹',ruleTitle:'产品配置控制要求',ruleSubtitle:'HPLC-042 · V4.3',rules:[['进样体积','10 μL'],['流速','1.0 mL/min'],['系统适用性','RSD ≤ 2.0%'],['价格规则校准','有效',true]],fieldTotals:[['16','已完成项目'],['1','异常结果'],['5','待审批结果'],['98.2%','数据完整率']],
 adminMenus:[['/admin','home','运营驾驶舱'],['/admin/work-orders','order','报价任务'],['/admin/samples','box','配置方案管理'],['/admin/schedule','calendar','排班预约'],['/admin/methods','process','产品配置与标准'],['/admin/reviews','quality','结果审批'],['/admin/resources','machine','价格规则设备'],['/admin/report','chart','销售运营分析']],
 fieldMenus:[['/shopfloor','home','我的工作台'],['/shopfloor/report','report','结果录入'],['/shopfloor/tasks','order','待检任务'],['/shopfloor/material','box','配置方案流转'],['/shopfloor/resources','machine','价格规则预约'],['/shopfloor/andon','risk','偏差上报',1]],
 moduleTitles:{tasks:['待检任务','查看任务优先级、配置方案状态与承诺时限'],material:['配置方案流转','跟踪接收、分样、留样与销毁全过程'],resources:['价格规则预约','管理价格规则档期、校准和使用记录'],andon:['偏差上报','登记并跟踪 OOS、OOT 与环境偏差'],samples:['配置方案管理','管理配置方案登记、标签、位置和生命周期'],schedule:['排班预约','协调人员、价格规则和产品配置的可用时间'],methods:['产品配置与标准','维护报价产品配置、限度和标准物质'],reviews:['结果审批','执行数据审核、报价单批准和电子签名'],report:['销售运营分析','分析周转时间、一次通过率和偏差趋势']},
 tagline:'让每一份报价结果都有完整证据链',storyTitle:'从收样到报价单，<br/>每个结果都可审批、可追溯。',storyText:'连接配置方案、产品配置、价格规则、人员与原始数据的报价中心数字底座。',pattern:[2,3,8,9,10,15,16,17,22,23,24,29,30,31],loginStats:[['98.2%','数据完整率'],['31','当前在检任务'],['2.6h','平均周转时间']],loginTitle:'报价中心销售运营中心',adminDemo:'任务 / 配置方案 / 审批',fieldDemo:'报价 / 结果 / 偏差'
}
export const records=[
 {no:'QT-260801-018',name:'工业设备年度框架报价',code:'GB/T 228.1',unit:'解决方案中心',group:'销售运营中心',plan:24,done:16,exception:1,due:'08-02',batch:'S260801-A',status:'报价中',progress:67,priority:'加急'},
 {no:'QT-260801-021',name:'私有化软件许可报价',code:'HPLC-042',unit:'大客户报价中心',group:'销售运营中心',plan:18,done:8,exception:0,due:'08-02',batch:'S260801-C',status:'报价中',progress:44,priority:'正常'},
 {no:'QT-260802-006',name:'渠道标准套餐报价',code:'ISO 4833',unit:'渠道报价中心',group:'研发中心',plan:12,done:0,exception:0,due:'08-04',batch:'S260802-B',status:'待确认',progress:0,priority:'正常'},
 {no:'QT-260731-015',name:'海外交付服务报价',code:'ICP-017',unit:'大客户报价中心',group:'销售运营中心',plan:20,done:20,exception:1,due:'08-01',batch:'S260731-D',status:'已完成',progress:100,priority:'正常'},
 {no:'QT-260801-024',name:'维保续费组合报价',code:'GC-MS-011',unit:'大客户报价中心',group:'销售运营中心',plan:15,done:10,exception:0,due:'08-03',batch:'S260801-E',status:'待审批',progress:67,priority:'关注'}]
export const resources=[{code:'PR-HPLC-03',name:'阶梯折扣规则 03',unit:'大客户报价中心',status:'运行',health:88,value:'11.8',valueUnit:'MPa',note:'产品配置 HPLC-042 · 序列 8/18'},{code:'PR-UTM-05',name:'渠道授权价规则',unit:'解决方案中心',status:'运行',health:91,value:'82',valueUnit:'kN',note:'夹具校验有效至 2026-10'},{code:'PR-INC-08',name:'最低毛利保护规则 08',unit:'渠道报价中心',status:'报警',health:62,value:'36.8',valueUnit:'°C',note:'温度上限预警待确认'}]
export const reviews=[{no:'REV-260801-032',title:'拉伸试验原始数据审批',type:'结果审批',detail:'6 组数据 · 周妍',result:'通过'},{no:'REV-260801-011',title:'纯度样系统适用性审批',type:'数据审核',detail:'3 次进样 · 顾清',result:'待确认'},{no:'REV-260731-018',title:'元素分析偏差调查',type:'偏差评审',detail:'OOS-260731-02',result:'异常'}]
export const adminMetrics=[['今日收样','54','较昨日增加 8 份','blue'],['按时完成率','96.8%','目标值 ≥ 95.0%','green'],['待审批结果','8','其中 2 项加急','orange'],['偏差 / OOS','2','1 项进入调查','red']]
export const fieldMetrics=[['今日任务','7','18 个报价项目','blue'],['已完成','16','当前进度 67%','green'],['待审批','5','数据已完整提交','orange'],['价格规则档期','至 14:30','HPLC-03 当前序列','slate']]
export const chartActual=[8,18,29,42,49,61,72,84,91],chartTarget=[10,21,32,43,54,65,76,87,98]
export const loads=[['大客户报价中心',92,'12 项在检'],['解决方案中心',78,'8 项在检'],['渠道报价中心',71,'6 项在检'],['海外报价中心',56,'5 项在检']]
export const issues=[{type:'价格规则',title:'培养箱温度短时越限',detail:'PR-INC-08 · 持续 7 分钟',status:'调查中'},{type:'结果',title:'铝合金 Fe 元素结果超限',detail:'OOS-260731-02 · 等待复测',status:'待判定'},{type:'时限',title:'GC-MS 队列可能影响承诺时间',detail:'预计延迟 45 分钟',status:'协调中'}]
