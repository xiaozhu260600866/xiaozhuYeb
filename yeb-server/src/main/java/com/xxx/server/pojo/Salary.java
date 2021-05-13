package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_salary")
@ApiModel(value="Salary对象", description="")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("basic_salary")
    private Integer basicSalary;

    private Integer bonus;

    @TableField("lunch_salary")
    private Integer lunchSalary;

    @TableField("traffic_salary")
    private Integer trafficSalary;

    @TableField("all_salary")
    private Integer allSalary;

    @TableField("pension_base")
    private Integer pensionBase;

    @TableField("pension_per")
    private Float pensionPer;

    @TableField("create_date")
    private LocalDate createDate;

    @TableField("medical_base")
    private Integer medicalBase;

    @TableField("medical_per")
    private Float medicalPer;

    @TableField("accumulation_fund_base")
    private Integer accumulationFundBase;

    @TableField("accumulation_fund_per")
    private Float accumulationFundPer;

    private String name;


}
