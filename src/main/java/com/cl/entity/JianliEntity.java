package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 简历
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
@TableName("jianli")
public class JianliEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JianliEntity() {
		
	}
	
	public JianliEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 照片
	 */
					
	private String zhaopian;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 学校
	 */
					
	private String xuexiao;
	
	/**
	 * 专业
	 */
					
	private String zhuanye;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 手机号码
	 */
					
	private String shoujihaoma;
	
	/**
	 * 学历
	 */
					
	private String xueli;
	
	/**
	 * 成绩
	 */
					
	private String chengji;
	
	/**
	 * 荣誉证书
	 */
					
	private String rongyuzhengshu;
	
	/**
	 * 目标薪资
	 */
					
	private String mubiaoxinzi;
	
	/**
	 * 期望城市
	 */
					
	private String qiwangchengshi;
	
	/**
	 * 实习经历
	 */
					
	private String shixijingli;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：照片
	 */
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	/**
	 * 获取：照片
	 */
	public String getZhaopian() {
		return zhaopian;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：学校
	 */
	public void setXuexiao(String xuexiao) {
		this.xuexiao = xuexiao;
	}
	/**
	 * 获取：学校
	 */
	public String getXuexiao() {
		return xuexiao;
	}
	/**
	 * 设置：专业
	 */
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	/**
	 * 获取：专业
	 */
	public String getZhuanye() {
		return zhuanye;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：手机号码
	 */
	public void setShoujihaoma(String shoujihaoma) {
		this.shoujihaoma = shoujihaoma;
	}
	/**
	 * 获取：手机号码
	 */
	public String getShoujihaoma() {
		return shoujihaoma;
	}
	/**
	 * 设置：学历
	 */
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	/**
	 * 获取：学历
	 */
	public String getXueli() {
		return xueli;
	}
	/**
	 * 设置：成绩
	 */
	public void setChengji(String chengji) {
		this.chengji = chengji;
	}
	/**
	 * 获取：成绩
	 */
	public String getChengji() {
		return chengji;
	}
	/**
	 * 设置：荣誉证书
	 */
	public void setRongyuzhengshu(String rongyuzhengshu) {
		this.rongyuzhengshu = rongyuzhengshu;
	}
	/**
	 * 获取：荣誉证书
	 */
	public String getRongyuzhengshu() {
		return rongyuzhengshu;
	}
	/**
	 * 设置：目标薪资
	 */
	public void setMubiaoxinzi(String mubiaoxinzi) {
		this.mubiaoxinzi = mubiaoxinzi;
	}
	/**
	 * 获取：目标薪资
	 */
	public String getMubiaoxinzi() {
		return mubiaoxinzi;
	}
	/**
	 * 设置：期望城市
	 */
	public void setQiwangchengshi(String qiwangchengshi) {
		this.qiwangchengshi = qiwangchengshi;
	}
	/**
	 * 获取：期望城市
	 */
	public String getQiwangchengshi() {
		return qiwangchengshi;
	}
	/**
	 * 设置：实习经历
	 */
	public void setShixijingli(String shixijingli) {
		this.shixijingli = shixijingli;
	}
	/**
	 * 获取：实习经历
	 */
	public String getShixijingli() {
		return shixijingli;
	}

}
