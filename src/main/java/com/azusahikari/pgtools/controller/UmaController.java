package com.azusahikari.pgtools.controller;

import com.azusahikari.pgtools.service.UmaService;
import com.azusahikari.pgtools.util.CarrotJuicerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/uma")
public class UmaController {
    final
    UmaService umaService;

    public UmaController(UmaService umaService) {
        this.umaService = umaService;
    }

    @RequestMapping("/index")
    public String index(HttpSession session) {
        return "uma/index";
    }

    @GetMapping("/supportCardList")
    public String supportCardList(Model model) {
        model.addAttribute("supportCardList", umaService.getSupportCard());
        return "uma/supportCardList";
    }
    @GetMapping("/msgpackList")
    public String msgpackList(Model model) {
        model.addAttribute("msgpackList", CarrotJuicerUtil.findMsgpack(new File("src/main/resources/static/CarrotJuicer")));
        return "uma/msgpack";
    }
    @ResponseBody
    @PostMapping("/getMsgpack")
    public String getMsgpack(@RequestBody Map<String,Object> map) {
        return CarrotJuicerUtil.getMsgPack(new File((String) map.get("path")));
    }
    @GetMapping("/upload")
    public String upload() {
        return "uma/upload";
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    @GetMapping("/getChara")
    public Map<String, Object> charaList() {
        Map<String, Object> result = new HashMap<>();
        result.put("chara", umaService.queryChara());
        return result;
    }

    @ResponseBody
    @GetMapping("/getSupportCard")
    public List<Map<String, Object>> getSupportCard() {
        return umaService.getSupportCard();
    }

    @ResponseBody
    @PostMapping("/uploadMaster")
    public Map<String, Object> uploadMaster(MultipartFile uploadFile) {
        Map<String, Object> result = new HashMap<>();
        if (uploadFile.isEmpty()) {
            //返回选择文件提示
            result.put("msg", "请选择上传文件");
            return result;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = "src/main/resources/static/uploadFile/";
        log.info("上传文件保存的路径【{}】", realPath);
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath);
        log.info("存放上传文件的文件夹【{}】", file);
        log.info("输出文件夹绝对路径【{}】", file.getAbsolutePath());
        //递归生成文件夹
        if (file.isDirectory() || file.mkdirs()) {
            //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
            String oldName = uploadFile.getOriginalFilename();
            log.info("文件原始的名字【{}】", oldName);
            String newName = "master_" + format + ".mdb";
            log.info("文件要保存后的新名字【{}】", newName);
            try {
                //构建真实的文件路径
                File newFile = new File(file.getAbsolutePath() + File.separator + newName);
                //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
                uploadFile.transferTo(newFile);
                String filePath = newFile.getPath();
                log.info("【{}】", filePath);
                result = umaService.uploadMaster(filePath);
                for (Map.Entry<String, Object> entry : result.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    log.info("{}: {}", key, value);
                }
                result.put("msg", "更新成功");
                result.put("path", filePath);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result.put("msg", "上传失败!");
        return result;
    }
}
