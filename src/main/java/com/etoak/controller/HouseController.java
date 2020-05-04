package com.etoak.controller;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;
import com.etoak.exception.ParamException;
import com.etoak.service.HouseService;
import com.etoak.utils.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/house")
@Slf4j
public class HouseController {

    // 读取的默认配置文件获取文件上传目录
    @Value("${upload.dir}")
    private String uploadDirectory;

    // 读取的默认配置文件获取图片访问路径前缀
    @Value("${upload.savePathPrefix}")
    private String savePathPrefix;

    @Autowired
    HouseService houseService;

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdda() {
        return "house/add";
    }

    /**
     * 添加房源
     * @param file
     * @param house
     * @return
     */
    @PostMapping("/add")
    public String add(@RequestParam("file")MultipartFile file, House house)
            throws IOException, IllegalStateException {

        // 检验参数
        ValidationUtil.validate(house);

        // 上传文件
        String originalFilename = file.getOriginalFilename();
        String prefix = UUID.randomUUID().toString().replaceAll("-", "");
        // 新文件名称：原始文件名_uuid.文件后缀
        String newFilename =  prefix + "_" + originalFilename;

        File destFile = new File(this.uploadDirectory, newFilename);
        file.transferTo(destFile);

        // 给House设置访问地址
        house.setPic(this.savePathPrefix + newFilename);
        houseService.addHouse(house);
        return "redirect:/house/toAdd";
    }

    /**
     * 添加房源
     * @param file
     * @param house
     * @return
     */
    @PostMapping("/add2")
    public String add2(@RequestParam("file")MultipartFile file, @Valid House house, BindingResult bingResult)
            throws IOException, IllegalStateException {

        // 对参数进行校验
        List<ObjectError> allErrors = bingResult.getAllErrors();
        if(CollectionUtils.isNotEmpty(allErrors)) {
            StringBuffer msgBuffer = new StringBuffer();
            for(ObjectError objectError : allErrors) {
                String message = objectError.getDefaultMessage();
                msgBuffer.append(message).append(";");
            }
            throw new ParamException("参数校验失败：" + msgBuffer.toString());
        }

        // 上传文件
        String originalFilename = file.getOriginalFilename();
        String prefix = UUID.randomUUID().toString().replaceAll("-", "");
        // 新文件名称：原始文件名_uuid.文件后缀
        String newFilename =  prefix + "_" + originalFilename;

        File destFile = new File(this.uploadDirectory, newFilename);
        file.transferTo(destFile);

        // 给House设置访问地址
        house.setPic(this.savePathPrefix + newFilename);
        houseService.addHouse(house);
        return "redirect:/house/toAdd";
    }

    /**
     * 房源列表查询
     * @param pageNum: 页码
     * @param pageSize: 每页记录数
     * @param houseVo: 查询条件
     * @return
     */
    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Page<HouseVo> queryList(
            @RequestParam(required = false, defaultValue = "1") int pageNum,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            HouseVo houseVo,
            @RequestParam(value = "rentalList[]", required = false) String[] rentalList) {
        log.info("pageNum - {}, pageSize - {}, houseVo - {}, rentalList- {}", pageNum, pageSize, houseVo, rentalList);
        return houseService.queryList(pageNum, pageSize, houseVo, rentalList);
    }

    /**
     * 跳转到列表页面
     * @return
     */
    @GetMapping("/toList")
    public String toList() {
        return "house/list";
    }

    /**
     * 更新房源
     * @param house
     * @return
     */
    @PutMapping("/update")
    public String update(House house) {
        log.info("house - {}", house);
        houseService.updateHouse(house);
        return "redirect:/house/toList";
    }

    /**
     * 根据id删除房源
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteHouse(@PathVariable("id") int id) {
        log.info("delete id - {}", id);
        houseService.deleteById(id);
        return "redirect:/house/toList";
    }
}