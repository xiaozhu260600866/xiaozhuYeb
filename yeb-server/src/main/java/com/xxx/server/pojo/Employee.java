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
@TableName("t_employee")
@ApiModel(value="Employee对象", description="")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String gender;

    private LocalDate birthday;

    @TableField("id_card")
    private String idCard;

    private String wedlock;

    @TableField("nation_id")
    private Integer nationId;

    @TableField("native_place")
    private String nativePlace;

    @TableField("politic_id")
    private Integer politicId;

    private String email;

    private String phone;

    private String address;

    @TableField("department_id")
    private Integer departmentId;

    @TableField("job_level_id")
    private Integer jobLevelId;

    @TableField("pos_id")
    private Integer posId;

    @TableField("engage_form")
    private String engageForm;

    @TableField("tiptop_degree")
    private String tiptopDegree;

    private String specialty;

    private String school;

    @TableField("begin_date")
    private LocalDate beginDate;

    @TableField("work_state")
    private String workState;

    @TableField("work_id")
    private String workId;

    @TableField("contract_term")
    private Double contractTerm;

    @TableField("conversion_time")
    private LocalDate conversionTime;

    @TableField("not_work_date")
    private LocalDate notWorkDate;

    @TableField("begin_contract")
    private LocalDate beginContract;

    @TableField("end_contract")
    private LocalDate endContract;

    @TableField("work_age")
    private Integer workAge;

    @TableField("salary_id")
    private Integer salaryId;


}
