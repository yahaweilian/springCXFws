package com.ynding.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ynding.utils.DateUtil;


/**
 * aliseph
 */
public class TaxHouse implements Serializable {
    private static final long serialVersionUID = 4120317386145472700L;
    private String houseId;// 房产编码
    private String xinfang;// 是否新房
    private String picId;// 对应图片编码
    private String bianma;// 房产证号
    private String zhuguan;// 主管税务机关
    private String caozuo;// 操作员
    private Date luruTime;// 录入时间
    private String shenheRen;// 审核操作员
    private Date shenheTime;// 审核时间
    private String churang;// 出让方
    private String weiyiChu;// 出让方是否唯一住房
    private String shourang;// 受让方
    private String weiyiShou;// 受让方是否唯一住房
    private String fenqu;// 所属分区
    private String jiedao;//所属街道/乡镇
    private String quhua;// 所属区划
    private String chengshi;// 所属地市
    private String dizhi;// 地址
    private String leixingZong;// 房产类型
    private String leixingFen;// 房产细类
    private String jiaoyi;// 交易类型
    private String quanshu;// 权属转移类别
//    @NotBlank(message = "来源类型不能为空")
    private String laiyuan;// 来源类型
    private BigDecimal shenbao;// 申报价格
    private Date quanzhengTime;// 权证填制时间
    private BigDecimal qianci;// 前次交易价格
    private Date qianciTime;// 前次交易时间
    private String qianciWay;//前次获取房屋方式
    private String fangfa;// 评估方法
    private String zijian;// 是否自建房
    private String putong;// 是否普通住房
    private String quyuBj;// 所属区域标记
    private Integer nianxian;// 已购买年份

    private BigDecimal fushu1;// 附属面积1 跃层
    private BigDecimal fushu2;// 附属面积2 车库
    private BigDecimal fushu3;// 附属面积3 阁楼
    private BigDecimal fushu4;// 附属面积4 地下室
    private BigDecimal fushu5;// 附属面积5 柴间/杂间（黄山）
    private BigDecimal fushu6;// 附属面积6
    private BigDecimal mianji;// 房屋面积
    private String niandai;// 建筑年代
    private String linjie;// 分区位置
    private String danyuan;// 建筑单元位置
    private String zhuangxiu;// 装修情况
    private Date jiaoyiTime;// 交易时间
    private String caoxiang;// 建筑朝向
    private String jiegou;// 建筑结构
    private Integer louceng;// 所在楼层
    private Integer loucengZong;// 总楼层
    private BigDecimal miankuan;// 面宽
    private String shouyi;// 收益年限
    private String luxian;// 商业路线
    private BigDecimal tudiMianji;// 土地面积
    private String yongtu;// 厂房用途
    private Integer kuadu;// 建筑跨度
    private Integer kuashu;// 建筑跨数
    private String cenggao;// 建筑层高
    private String tudijibie;// 土地级别
    private String daima;// 房屋代码
    private String dikouDizhi;// 可抵扣房产地址
    private BigDecimal dikouMianji;// 可抵扣房产面积
    private BigDecimal dikouJiage;// 可抵扣房产价格
    private BigDecimal fcjGujia;// 房产局评估价格
    private String shenhe;// 审核标记
    private String pinggu;// 评估标记
    private String zhengshou;// 征收标记
    private String shanchu;// 删除标记
    private Date shanchuTime;// 删除时间
    private String shanchuRen;// 删除人
    private Date zhengshouTime;// 征收时间
    private String zhengshouRen;// 征收人
    private String wanshui;// 完税标记
    private Date wanshuiTime;// 完税时间
    private String wanshuiRen;// 完税操作员

    private String zsLiushui;// 征收流水号
    private String fenquMing;// 所属分区名称
    private String leixingMing;// 房产细类名称
    private String churangMing;// 出让方
    private String shourangMing;// 受让方
    private BigDecimal zongjia;// 计税总价格
    private BigDecimal pingguzongjia;// 评估总价格
    private BigDecimal fushujiage;// 附属面积价格
	private String resultId;// 评估结果编码
    private Date dayinTime;// 打印时间
    private String beizhu;// 备注
    private Double bili;// 转让比例
    private String taxpayerLeixing;// 出让方类型 个人/公司 房产局模式使用
    private String jicheng;// 是否办理过继承
    private String zengyu;// 是否办理过赠与
    private String tuishui;// 是否办理退税
    
    private BigDecimal zengzhishuijishui; //增值税计税价格
    private String  hanshui; //是否含税 1-含税 0-不含
    //合同编码
    private String htbh;
    //房屋类型
    private String fangwulx;
    private String fanghao;//房号
    
    //与状态表对应   
    private String  qszydx;//权属转移对象
	private String  qszyyt;//权属转移用途
	private float   htjg; //合同价格
	private  Date  htqdrq; //合同签订日期
    
	private float   tnmj; //套内面积
	private String  fssslx; //附属设施类型
	private float   fsmj; //附属物面积
	
	private Date barq;//备案日期 BARQ
	private String xqmc;//小区名称 XQMC
	private String fwdh;//房屋栋号FWDH

	private BigDecimal fsje; //附属金额
	private BigDecimal dj; //单价DJ  
	
    private String qcjylxmc;//前次交易类型名称
    
    
	public String getQcjylxmc() {
		return qcjylxmc;
	}

	public void setQcjylxmc(String qcjylxmc) {
		this.qcjylxmc = qcjylxmc;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getFsje() {
		return fsje;
	}

	public void setFsje(BigDecimal fsje) {
		this.fsje = fsje;
	}

	public String getFwdh() {
		return fwdh;
	}

	public void setFwdh(String fwdh) {
		this.fwdh = fwdh;
	}

	public String getXqmc() {
		return xqmc;
	}

	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}

	public BigDecimal getFushujiage() {
        return fushujiage;
    }

    public void setFushujiage(BigDecimal fushujiage) {
        this.fushujiage = fushujiage;
    }

    public BigDecimal getZengzhishuijishui() {
		return zengzhishuijishui;
	}

	public void setZengzhishuijishui(BigDecimal zengzhishuijishui) {
		this.zengzhishuijishui = zengzhishuijishui;
	}

	public String getQianciWay() {
		return qianciWay;
	}

	public void setQianciWay(String qianciWay) {
		this.qianciWay = qianciWay;
	}

	public String getFanghao() {
		return fanghao;
	}

	public void setFanghao(String fanghao) {
		this.fanghao = fanghao;
	}

	public String getFangwulx() {
		return fangwulx;
	}

	public void setFangwulx(String fangwulx) {
		this.fangwulx = fangwulx;
	}

	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}

	public String getJiedao() {
		return jiedao;
	}

	public void setJiedao(String jiedao) {
		this.jiedao = jiedao;
	}


    public Map<String, String> toMap(boolean isModify) {
        Map<String, String> map = new HashMap<String, String>();
        if (fushu1 != null)
            map.put("fushu1", fushu1.toString());
        if (fushu2 != null)
            map.put("fushu2", fushu2.toString());
        if (fushu3 != null)
            map.put("fushu3", fushu3.toString());
        if (fushu4 != null)
            map.put("fushu4", fushu4.toString());
        if (fushu5 != null)
            map.put("fushu5", fushu5.toString());
        if (fushu6 != null)
            map.put("fushu6", fushu6.toString());
        if (mianji != null)
            map.put("mianji", mianji.toString());
        if (niandai != null)
            map.put("niandai", niandai);
        if (linjie != null)
            map.put("linjie", linjie);
        if (danyuan != null)
            map.put("danyuan", danyuan);
        if (zhuangxiu != null)
            map.put("zhuangxiu", zhuangxiu);
        if (jiaoyiTime != null) {
            if (isModify) {
                map.put("jiaoyiTime",
                        DateUtil.format(jiaoyiTime, DateUtil.DATE_FORMAT));
            } else {
                map.put("jiaoyiTime",
                        DateUtil.format(jiaoyiTime, DateUtil.YEAR_FORMAT));
                map.put("jiaoyiTimeDate",
                        DateUtil.format(jiaoyiTime, DateUtil.MONTH_FORMAT));
            }
        }
        if (caoxiang != null)
            map.put("caoxiang", caoxiang);
        if (jiegou != null)
            map.put("jiegou", jiegou);
        if (louceng != null)
            map.put("louceng", louceng.toString());
        if (loucengZong != null)
            map.put("loucengZong", loucengZong.toString());
        if (miankuan != null)
            map.put("miankuan", miankuan.toString());
        if (luxian != null)
            map.put("luxian", luxian);
        if (shouyi != null)
            map.put("shouyi", shouyi);
        if (tudiMianji != null)
            map.put("tudiMianji", tudiMianji.toString());
        if (yongtu != null)
            map.put("yongtu", yongtu);
        if (kuadu != null)
            map.put("kuadu", kuadu.toString());
        if (kuashu != null)
            map.put("kuashu", kuashu.toString());
        if (cenggao != null)
            map.put("cenggao", cenggao.toString());
        if (tudijibie != null)
            map.put("tudijibie", tudijibie);

        if (quhua != null)
            map.put("quhua", quhua);
        if (hanshui != null)
            map.put("hanshui", hanshui);
        if (fangfa != null)
        	map.put("fangfa", fangfa);
        if (chengshi != null)
            map.put("chengshi", chengshi);
        if (danyuan != null)
            map.put("danyuan", danyuan);
        if (leixingFen != null)
            map.put("leixingFen", leixingFen);
        if (caozuo != null)
        	map.put("caozuo", caozuo);
        if (zhuguan != null)
        	map.put("zhuguan", zhuguan);
        if (houseId != null)
        	map.put("houseId", houseId);
        return map;
    }

    public String getDikouDizhi() {
        return dikouDizhi;
    }

    public void setDikouDizhi(String dikouDizhi) {
        this.dikouDizhi = dikouDizhi;
    }

    public BigDecimal getDikouMianji() {
        return dikouMianji;
    }

    public void setDikouMianji(BigDecimal dikouMianji) {
        this.dikouMianji = dikouMianji;
    }

    public BigDecimal getDikouJiage() {
        return dikouJiage;
    }

    public void setDikouJiage(BigDecimal dikouJiage) {
        this.dikouJiage = dikouJiage;
    }

    public String getTuishui() {
        return tuishui;
    }

    public void setTuishui(String tuishui) {
        this.tuishui = tuishui;
    }

    public String getJicheng() {
        return jicheng;
    }

    public void setJicheng(String jicheng) {
        this.jicheng = jicheng;
    }

    public String getZengyu() {
        return zengyu;
    }

    public void setZengyu(String zengyu) {
        this.zengyu = zengyu;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getWanshui() {
        return wanshui;
    }

    public void setWanshui(String wanshui) {
        this.wanshui = wanshui;
    }

    public Date getWanshuiTime() {
        return wanshuiTime;
    }

    public void setWanshuiTime(Date wanshuiTime) {
        this.wanshuiTime = wanshuiTime;
    }

    public String getWanshuiRen() {
        return wanshuiRen;
    }

    public void setWanshuiRen(String wanshuiRen) {
        this.wanshuiRen = wanshuiRen;
    }

    public String getZsLiushui() {
        return zsLiushui;
    }

    public void setZsLiushui(String zsLiushui) {
        this.zsLiushui = zsLiushui;
    }

    public String getTaxpayerLeixing() {
        return taxpayerLeixing;
    }

    public void setTaxpayerLeixing(String taxpayerLeixing) {
        this.taxpayerLeixing = taxpayerLeixing;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public BigDecimal getZongjia() {
        return zongjia;
    }

    public void setZongjia(BigDecimal zongjia) {
        this.zongjia = zongjia;
    }
    
    public BigDecimal getPingguzongjia() {
		return pingguzongjia;
	}

	public void setPingguzongjia(BigDecimal pingguzongjia) {
		this.pingguzongjia = pingguzongjia;
	}

    public String getQuyuBj() {
        return quyuBj;
    }

    public void setQuyuBj(String quyuBj) {
        this.quyuBj = quyuBj;
    }

    public Integer getNianxian() {
        return nianxian;
    }

    public void setNianxian(Integer nianxian) {
        this.nianxian = nianxian;
    }

    public String getChurangMing() {
        return churangMing;
    }

    public void setChurangMing(String churangMing) {
        this.churangMing = churangMing;
    }

    public String getShourangMing() {
        return shourangMing;
    }

    public void setShourangMing(String shourangMing) {
        this.shourangMing = shourangMing;
    }

    public String getFenquMing() {
        return fenquMing;
    }

    public void setFenquMing(String fenquMing) {
        this.fenquMing = fenquMing;
    }

    public String getLeixingMing() {
        return leixingMing;
    }

    public void setLeixingMing(String leixingMing) {
        this.leixingMing = leixingMing;
    }

    public Date getShanchuTime() {
        return shanchuTime;
    }

    public void setShanchuTime(Date shanchuTime) {
        this.shanchuTime = shanchuTime;
    }

    public String getShanchuRen() {
        return shanchuRen;
    }

    public void setShanchuRen(String shanchuRen) {
        this.shanchuRen = shanchuRen;
    }

    public Date getZhengshouTime() {
        return zhengshouTime;
    }

    public void setZhengshouTime(Date zhengshouTime) {
        this.zhengshouTime = zhengshouTime;
    }

    public String getZhengshouRen() {
        return zhengshouRen;
    }

    public void setZhengshouRen(String zhengshouRen) {
        this.zhengshouRen = zhengshouRen;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getBianma() {
        return bianma;
    }

    public void setBianma(String bianma) {
        this.bianma = bianma;
    }

    public String getZhuguan() {
        return zhuguan;
    }

    public void setZhuguan(String zhuguan) {
        this.zhuguan = zhuguan;
    }

    public String getCaozuo() {
        return caozuo;
    }

    public void setCaozuo(String caozuo) {
        this.caozuo = caozuo;
    }

    public Date getLuruTime() {
        return luruTime;
    }

    public void setLuruTime(Date luruTime) {
        this.luruTime = luruTime;
    }

    public String getShenheRen() {
        return shenheRen;
    }

    public void setShenheRen(String shenheRen) {
        this.shenheRen = shenheRen;
    }

    public Date getShenheTime() {
        return shenheTime;
    }

    public void setShenheTime(Date shenheTime) {
        this.shenheTime = shenheTime;
    }

    public String getChurang() {
        return churang;
    }

    public void setChurang(String churang) {
        this.churang = churang;
    }

    public String getWeiyiChu() {
        return weiyiChu;
    }

    public void setWeiyiChu(String weiyiChu) {
        this.weiyiChu = weiyiChu;
    }

    public String getShourang() {
        return shourang;
    }

    public void setShourang(String shourang) {
        this.shourang = shourang;
    }

    public String getWeiyiShou() {
        return weiyiShou;
    }

    public void setWeiyiShou(String weiyiShou) {
        this.weiyiShou = weiyiShou;
    }

    public String getFenqu() {
        return fenqu;
    }

    public void setFenqu(String fenqu) {
        this.fenqu = fenqu;
    }

    public String getQuhua() {
        return quhua;
    }

    public void setQuhua(String quhua) {
        this.quhua = quhua;
    }

    public String getChengshi() {
        return chengshi;
    }

    public void setChengshi(String chengshi) {
        this.chengshi = chengshi;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getLeixingZong() {
        return leixingZong;
    }

    public void setLeixingZong(String leixingZong) {
        this.leixingZong = leixingZong;
    }

    public String getLeixingFen() {
        return leixingFen;
    }

    public void setLeixingFen(String leixingFen) {
        this.leixingFen = leixingFen;
    }

    public String getJiaoyi() {
        return jiaoyi;
    }

    public Date getBarq() {
		return barq;
	}

	public void setBarq(Date barq) {
		this.barq = barq;
	}

	public void setJiaoyi(String jiaoyi) {
        this.jiaoyi = jiaoyi;
    }

    public BigDecimal getShenbao() {
        return shenbao;
    }

    public void setShenbao(BigDecimal shenbao) {
        this.shenbao = shenbao;
    }

    public Date getQuanzhengTime() {
        return quanzhengTime;
    }

    public void setQuanzhengTime(Date quanzhengTime) {
        this.quanzhengTime = quanzhengTime;
    }

    public BigDecimal getQianci() {
        return qianci;
    }

    public void setQianci(BigDecimal qianci) {
        this.qianci = qianci;
    }

    public Date getQianciTime() {
        return qianciTime;
    }

    public void setQianciTime(Date qianciTime) {
        this.qianciTime = qianciTime;
    }

    public String getFangfa() {
        return fangfa;
    }

    public void setFangfa(String fangfa) {
        this.fangfa = fangfa;
    }

    public String getZijian() {
        return zijian;
    }

    public void setZijian(String zijian) {
        this.zijian = zijian;
    }

    public String getPutong() {
        return putong;
    }

    public void setPutong(String putong) {
        this.putong = putong;
    }

    public BigDecimal getFushu1() {
        return fushu1;
    }

    public void setFushu1(BigDecimal fushu1) {
        this.fushu1 = fushu1;
    }

    public BigDecimal getFushu2() {
        return fushu2;
    }

    public void setFushu2(BigDecimal fushu2) {
        this.fushu2 = fushu2;
    }

    public BigDecimal getFushu3() {
        return fushu3;
    }

    public void setFushu3(BigDecimal fushu3) {
        this.fushu3 = fushu3;
    }

    public BigDecimal getFushu4() {
        return fushu4;
    }

    public void setFushu4(BigDecimal fushu4) {
        this.fushu4 = fushu4;
    }

    public BigDecimal getFushu5() {
        return fushu5;
    }

    public void setFushu5(BigDecimal fushu5) {
        this.fushu5 = fushu5;
    }

    public BigDecimal getFushu6() {
        return fushu6;
    }

    public void setFushu6(BigDecimal fushu6) {
        this.fushu6 = fushu6;
    }

    public BigDecimal getMianji() {
        return mianji;
    }

    public void setMianji(BigDecimal mianji) {
        this.mianji = mianji;
    }

    public String getNiandai() {
        return niandai;
    }

    public Date getNiandaiDate() {
        return DateUtil.parse(this.niandai, DateUtil.YEAR_FORMAT);
    }

    public void setNiandai(String niandai) {
        this.niandai = niandai;
    }

    public String getLinjie() {
        return linjie;
    }

    public void setLinjie(String linjie) {
        this.linjie = linjie;
    }

    public String getDanyuan() {
        return danyuan;
    }

    public void setDanyuan(String danyuan) {
        this.danyuan = danyuan;
    }

    public String getZhuangxiu() {
        return zhuangxiu;
    }

    public void setZhuangxiu(String zhuangxiu) {
        this.zhuangxiu = zhuangxiu;
    }

    public Date getJiaoyiTime() {
        return jiaoyiTime;
    }

    public void setJiaoyiTime(Date jiaoyiTime) {
        this.jiaoyiTime = jiaoyiTime;
    }

    public String getCaoxiang() {
        return caoxiang;
    }

    public void setCaoxiang(String caoxiang) {
        this.caoxiang = caoxiang;
    }

    public String getJiegou() {
        return jiegou;
    }

    public void setJiegou(String jiegou) {
        this.jiegou = jiegou;
    }

    public Integer getLouceng() {
        return louceng;
    }

    public void setLouceng(Integer louceng) {
        this.louceng = louceng;
    }

    public Integer getLoucengZong() {
        return loucengZong;
    }

    public void setLoucengZong(Integer loucengZong) {
        this.loucengZong = loucengZong;
    }

    public String getLuxian() {
        return luxian;
    }

    public void setLuxian(String luxian) {
        this.luxian = luxian;
    }

    public BigDecimal getMiankuan() {
        return miankuan;
    }

    public void setMiankuan(BigDecimal miankuan) {
        this.miankuan = miankuan;
    }

    public String getShouyi() {
        return shouyi;
    }

    public void setShouyi(String shouyi) {
        this.shouyi = shouyi;
    }

    public BigDecimal getTudiMianji() {
        return tudiMianji;
    }

    public void setTudiMianji(BigDecimal tudiMianji) {
        this.tudiMianji = tudiMianji;
    }

    public String getYongtu() {
        return yongtu;
    }

    public void setYongtu(String yongtu) {
        this.yongtu = yongtu;
    }

    public Integer getKuadu() {
        return kuadu;
    }

    public void setKuadu(Integer kuadu) {
        this.kuadu = kuadu;
    }

    public Integer getKuashu() {
        return kuashu;
    }

    public void setKuashu(Integer kuashu) {
        this.kuashu = kuashu;
    }

    public String getCenggao() {
        return cenggao;
    }

    public void setCenggao(String cenggao) {
        this.cenggao = cenggao;
    }

    public String getTudijibie() {
        return tudijibie;
    }

    public void setTudijibie(String tudijibie) {
        this.tudijibie = tudijibie;
    }

    public String getDaima() {
        return daima;
    }

    public void setDaima(String daima) {
        this.daima = daima;
    }

    public BigDecimal getFcjGujia() {
        return fcjGujia;
    }

    public void setFcjGujia(BigDecimal fcjGujia) {
        this.fcjGujia = fcjGujia;
    }

    public String getShenhe() {
        return shenhe;
    }

    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }

    public String getPinggu() {
        return pinggu;
    }

    public void setPinggu(String pinggu) {
        this.pinggu = pinggu;
    }

    public String getZhengshou() {
        return zhengshou;
    }

    public void setZhengshou(String zhengshou) {
        this.zhengshou = zhengshou;
    }

    public String getShanchu() {
        return shanchu;
    }

    public void setShanchu(String shanchu) {
        this.shanchu = shanchu;
    }

    public Date getDayinTime() {
        return dayinTime;
    }

    public void setDayinTime(Date dayinTime) {
        this.dayinTime = dayinTime;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Double getBili() {
        return bili;
    }

    public void setBili(Double bili) {
        this.bili = bili;
    }

    public String getXinfang() {
        return xinfang;
    }

    public void setXinfang(String xinfang) {
        this.xinfang = xinfang;
    }

	public String getQuanshu() {
		return quanshu;
	}

	public void setQuanshu(String quanshu) {
		this.quanshu = quanshu;
	}

	public String getLaiyuan() {
		return laiyuan;
	}

	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}

	public String getHanshui() {
		if(hanshui==null){
			hanshui="0";
		}
		return hanshui;
	}

	public void setHanshui(String hanshui) {
		this.hanshui = hanshui;
	}

	public String getQszydx() {
		return qszydx;
	}

	public void setQszydx(String qszydx) {
		this.qszydx = qszydx;
	}

	public String getQszyyt() {
		return qszyyt;
	}

	public void setQszyyt(String qszyyt) {
		this.qszyyt = qszyyt;
	}

	public float getHtjg() {
		return htjg;
	}

	public void setHtjg(float htjg) {
		this.htjg = htjg;
	}

	public Date getHtqdrq() {
		return htqdrq;
	}

	public void setHtqdrq(Date htqdrq) {
		this.htqdrq = htqdrq;
	}

	public float getTnmj() {
		return tnmj;
	}

	public void setTnmj(float tnmj) {
		this.tnmj = tnmj;
	}

	public String getFssslx() {
		return fssslx;
	}

	public void setFssslx(String fssslx) {
		this.fssslx = fssslx;
	}

	public float getFsmj() {
		return fsmj;
	}

	public void setFsmj(float fsmj) {
		this.fsmj = fsmj;
	}
   
	
	
  
}