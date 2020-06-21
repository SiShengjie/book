package com.tongji.book.controller;

import com.tongji.book.entity.*;
import com.tongji.book.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private UserService userService;
    private EnterpriseService enterpriseService;
    private VipService vipService;
    private InsideService innerService;
    private MarketService marketService;
    private AbroadService abroadService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setEnterpriseService(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @Autowired
    public void setVipService(VipService vipService) {
        this.vipService = vipService;
    }

    @RequestMapping("/index")
    public String dashboard(Map<String, Object> map) {
        int sumAllUser = userService.countAll();
        int sumAllTable = countAllDirs();
        map.put("userSum", sumAllUser);
        map.put("formSum", sumAllTable);
        map.put("loginCount", LoginController.loginCount);
        return "dashboard";
    }

    private int countAllDirs() {
        File[] files1 = new File("/usr/java/uploadExcels/qiZhongJiXie").listFiles();
        int len1 = files1 == null ? 0 : files1.length;
        File[] files2 = new File("/usr/java/uploadExcels/wuLiuCangChu").listFiles();
        int len2 = files2 == null ? 0 : files2.length;
        File[] files3 = new File("/usr/java/uploadExcels/shuSongJiXie").listFiles();
        int len3 = files3 == null ? 0 : files3.length;
        return len1 + len2 + len3;
    }

    @Autowired
    public void setInnerService(InsideService innerService) {
        this.innerService = innerService;
    }

    @Autowired
    public void setMarketService(MarketService marketService) {
        this.marketService = marketService;
    }

    @Autowired
    public void setAbroadService(AbroadService abroadService) {
        this.abroadService = abroadService;
    }

    @RequestMapping("/tables")
    public String tables(Map<String, Object> map) {
        List<Enterprise> allEnterprise = enterpriseService.getAll();
        List<Vip> allVip = vipService.findAll();
        List<Inside> allInside = innerService.getAll();
        List<Market> allMarket = marketService.getAll();
        List<Abroad> allAbroad = abroadService.getAll();
        map.put("allEnterprise", allEnterprise);
        map.put("allVip", allVip);
        map.put("allInside", allInside);
        map.put("allMarket", allMarket);
        map.put("allAbroad", allAbroad);
        map.put("tableLevel", 0);
        return "tables";
    }

    @RequestMapping("/tables{tableId}")
    public String tables(@PathVariable("tableId") int tableId, Map<String, Object> map) {
        switch (tableId) {
            case 1:
                List<Enterprise> allEnterprise = enterpriseService.getAll();
                map.put("allEnterprise", allEnterprise);
                break;
            case 2:
                List<Vip> allVip = vipService.findAll();
                map.put("allVip", allVip);
                break;
            case 3:
                List<Inside> allInside = innerService.getAll();
                map.put("allInside", allInside);
                break;
            case 4:
                List<Market> allMarket = marketService.getAll();
                map.put("allMarket", allMarket);
                break;
            case 5:
                List<Abroad> allAbroad = abroadService.getAll();
                map.put("allAbroad", allAbroad);
                break;
        }
        map.put("tableLevel", tableId);
        return "tables";
    }

    @RequestMapping("/collect")
    public String acquire(Map<String, Object> map) {
        map.put("collectId", 0);
        return "collect";
    }

    @GetMapping("/collect{id}")
    public String collect(@PathVariable("id") int id, Map<String, Object> map) {
        map.put("collectId", id);
        return "collect";
    }

    @GetMapping("/download{id}")
    public void download(@PathVariable("id") int id, HttpServletResponse response) throws Exception {
        String fileName = "";
        switch (id) {
            case 1:
                fileName = "起重机械数据采集表.xlsx";
                break;
            case 2:
                fileName = "物流仓储数据采集表.xlsx";
                break;
            case 3:
                fileName = "输送机械数据采集表.xlsx";
                break;
            case 4:
                fileName = "1.致辞：打造行业信息平台，共享合作发展成果.docx";
                break;
            case 5:
                fileName = "2.蓝皮书企业数据征集函.docx";
                break;
            case 6:
                fileName = "3.信息报送真实性声明.docx";
                break;
            case 7:
                fileName = "4.《起重运输机械》征稿函（前文学术二合一）.docx";
                break;
        }
        String path = "/static/" + fileName;

        // 将文件名称进行编码
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        if (id<=3){
            response.setContentType("application/vnd.ms-excel");
        }else {
            response.setContentType("application/msword");
        }
        // 读取服务器端模板文件
        InputStream inputStream = MainController.class.getResourceAsStream(path);

        // 将流中内容写出去
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inputStream.close();
        outputStream.close();
    }

    @PostMapping("upload{id}")
    @ResponseBody
    public String upload(@PathVariable("id") int id, MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String filePath = "/usr/java/uploadExcels/";
        switch (id) {
            case 1:
                filePath += "qiZhongJiXie/";
                break;
            case 2:
                filePath += "wuLiuCangChu/";
                break;
            case 3:
                filePath += "shuSongJiXie/";
                break;
        }
        File newFile = new File(filePath + System.currentTimeMillis() + fileName);
        //已建目录，不必验证
//        if (!newFile.getParentFile().exists()) {
//            newFile.getParentFile().mkdirs();
//        }
        try {
            file.transferTo(newFile);
            return "上传成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }
}
