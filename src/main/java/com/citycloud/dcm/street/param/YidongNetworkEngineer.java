package com.citycloud.dcm.street.param;

import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

@Data
public class YidongNetworkEngineer  {

@Excel(name = "公司id",width = 15)
    private  String corpId;
    @Excel(name = "姓名",width = 15)
    private  String name;

}
