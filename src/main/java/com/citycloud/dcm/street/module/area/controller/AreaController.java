package com.citycloud.dcm.street.module.area.controller;

import com.citycloud.dcm.street.config.SingerService;
import com.citycloud.dcm.street.mapper.UserMapper;
import com.citycloud.dcm.street.module.area.service.ExcelService;
import com.citycloud.dcm.street.param.YidongNetworkEngineer;
import com.citycloud.dcm.street.util.SrtategyContent;
import com.citycloud.dcm.street.vo.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@Api(tags = "阿双方各")
public class AreaController {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    ExcelService  excelService;


    @Autowired
    SingerService singerService;

    @Autowired
    private RedisTemplate<String, Object> redisStrTemplate;

    @Email
   @Value("${aaa}")
  private String aaa;

    @ApiOperation("阿斯蒂芬")
    @ResponseBody
    @GetMapping("/findAll")
    public JsonData listQueryDistrictStreets() throws Exception{
        List<Map<String, Object>> all = userMapper.findAll();
//        for(int i=0;i<100;i++){
//
//
//        }
        //redisStrTemplate.opsForValue().set("nihao", JSON.toJSONString(all), 15, TimeUnit.MINUTES);

        String suggestion0 = SrtategyContent.getProperty("suggestion0");
        return new JsonData(suggestion0);
    }



    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, HttpServletResponse response) {
        //Step.2 AutoPoi 导出Excel
        ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
        YidongNetworkEngineer yidongNetworkEngineer = new YidongNetworkEngineer();
        yidongNetworkEngineer.setName("张三");
        yidongNetworkEngineer.setCorpId("1");
        YidongNetworkEngineer two = new YidongNetworkEngineer();
        two.setName("李四");
        two.setCorpId("2");
        ArrayList<Object> list = new ArrayList<>();
        list.add(yidongNetworkEngineer);
        list.add(two);
        //导出文件名称
        mv.addObject(NormalExcelConstants.FILE_NAME, "移动网报障处理人员表列表");
        mv.addObject(NormalExcelConstants.CLASS, YidongNetworkEngineer.class);
        //mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("移动网报障处理人员表列表数据", "导出人:Jeecg", "导出信息"));
        mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("移动网报障处理人员表列表数据","导出信息"));
        mv.addObject(NormalExcelConstants.DATA_LIST, list);



        return mv;
    }


    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/excel")
    public void excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        excelService.getExcel(request,response);

    }



}
