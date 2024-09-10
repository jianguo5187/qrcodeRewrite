package com.qrcode.rewrite.controller;
import com.qrcode.rewrite.service.SysMainDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

@Controller
public class RedirectController {

    @Autowired
    private SysMainDomainService mainDomainService;

    @GetMapping("/")
    public ModelAndView redirectBasedOnQueryParam(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "webType", required = false) String webType, @RequestParam(name = "parentUserId", required = false) Long parentUserId) throws InterruptedException {

        if (webType != null && !webType.isEmpty()) {

            String redirectUrl = mainDomainService.getMainUrlByWebType(webType); // 可能需要处理为完整的URL，例如添加协议或路径
            if(!StringUtils.isEmpty(redirectUrl)){
                String redirectHostUrl = request.getRequestURL().toString();
                if(redirectHostUrl.endsWith("/")){
                    redirectHostUrl = redirectHostUrl.substring(0,redirectHostUrl.length()-1);
                }
                redirectHostUrl = redirectHostUrl + "/dpc/qrRedirect?redirectUrl=" + urlEncode(redirectUrl);

                if(parentUserId != null && parentUserId > 0){
                    redirectHostUrl = redirectHostUrl + "&parentUserId=" + parentUserId + "&expectedParam=firstRewrite";
                    return new ModelAndView("redirect:" + redirectHostUrl);
                }else{
                    return new ModelAndView("redirect:http://www.baidu.com");
                }
//                System.out.println("redirectHostUrl : " + redirectHostUrl);

//                Thread.sleep(1000);//延迟1秒跳转
//                if(!redirectUrl.startsWith("http") && !redirectUrl.startsWith("https")){
//                    redirectUrl = "http://" + redirectUrl;
//                }
//                if(parentUserId != null && parentUserId > 0){
//                    redirectUrl = redirectUrl + "?parentUserId=" + parentUserId;
//                }else{
//                    return new ModelAndView("redirect:http://www.baidu.com");
//                }
//                return new ModelAndView("redirect:" + redirectUrl);

                //todo
//                if(parentUserId != null && parentUserId > 0){
//                    boolean httpsFlg = false;
//                    if(redirectUrl.startsWith("http")){
//                        redirectUrl = redirectUrl.replace("http://","");
//                    }
//                    if(redirectUrl.startsWith("https")){
//                        redirectUrl = redirectUrl.replace("https://","");
//                        httpsFlg = true;
//                    }
//
//                    if(httpsFlg){
//                        redirectUrl = "https://" + generateSoleName() + "." + redirectUrl + ":6678";
//                    }else{
//                        redirectUrl = "http://" + generateSoleName() + "." + redirectUrl + ":6678";
//                    }
//
//                    redirectUrl = redirectUrl + "?parentUserId=" + parentUserId;
//                    System.out.println("redirectUrl : " + redirectUrl);
//                    return new ModelAndView("redirect:" + redirectUrl);
//                }else{
//                    return new ModelAndView("redirect:http://www.baidu.com");
//                }
            }else{

                // 如果没有提供rewrite参数，或者参数为空，可以重定向到默认页面
                return new ModelAndView("redirect:http://www.baidu.com");
            }
        } else {
            // 如果没有提供rewrite参数，或者参数为空，可以重定向到默认页面
            return new ModelAndView("redirect:http://www.baidu.com");
        }
    }


    @GetMapping("/dpc/qrRedirect")
    public ModelAndView qrRedirect(HttpServletRequest request, @RequestParam(name = "redirectUrl", required = false) String redirectUrl, @RequestParam(name = "parentUserId", required = false) Long parentUserId) {

        String redirectHostUrl = request.getRequestURL().toString().replace(request.getRequestURI(),"");
        redirectHostUrl = redirectHostUrl + "/dpc/qrRedirectSecond?redirectUrl=" + urlEncode(redirectUrl);
        if(parentUserId != null && parentUserId > 0){
            redirectHostUrl = redirectHostUrl + "&parentUserId=" + parentUserId+ "&expectedParam=secondRewrite";
            return new ModelAndView("redirect:" + redirectHostUrl);
        }else{
            return new ModelAndView("redirect:http://www.baidu.com");
        }
    }

    @GetMapping("/dpc/qrRedirectSecond")
    public ModelAndView qrRedirectSecond(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "redirectUrl", required = false) String redirectUrl, @RequestParam(name = "parentUserId", required = false) Long parentUserId) {

        String redirectHostUrl = request.getRequestURL().toString().replace(request.getRequestURI(),"");
        redirectHostUrl = redirectHostUrl + "/dpc/threeRedirect?redirectUrl=" + urlEncode(redirectUrl);
        if(parentUserId != null && parentUserId > 0){
            redirectHostUrl = redirectHostUrl + "&parentUserId=" + parentUserId+ "&expectedParam=threeRewrite";
            return new ModelAndView("redirect:" + redirectHostUrl);
        }else{
            return new ModelAndView("redirect:http://www.baidu.com");
        }
    }

    @GetMapping("/dpc/threeRedirect")
    public ModelAndView threeRedirect(@RequestParam(name = "redirectUrl", required = false) String redirectUrl, @RequestParam(name = "parentUserId", required = false) Long parentUserId) throws InterruptedException {
        Thread.sleep(1000);//延迟1秒跳转

        //TODO 0907
//        boolean httpsFlg = false;
//        if(redirectUrl.startsWith("http")){
//            redirectUrl = redirectUrl.replace("http://","");
//        }
//        if(redirectUrl.startsWith("https")){
//            redirectUrl = redirectUrl.replace("https://","");
//            httpsFlg = true;
//        }
//
//        if(httpsFlg){
//            redirectUrl = "https://" + generateSoleName() + "." + redirectUrl + ":8443";
//        }else{
//            redirectUrl = "http://" + generateSoleName() + "." + redirectUrl + ":8443";
//        }
//
        if(parentUserId != null && parentUserId > 0){
            redirectUrl = redirectUrl + "?parentUserId=" + parentUserId;
        }
        System.out.println("redirectUrl : " + redirectUrl);
        return new ModelAndView("redirect:" + redirectUrl);
    }

    public static String generateSoleName() {
        String tmpResult;
        StringBuilder soleResult = new StringBuilder();
        //生成7位随机
        for (int i = 1; i <= 6; i++) {
            //判断产生的随机数是0还是1，是0进入if语句用于输出数字，是1进入else用于输出字符
            int mark = 1;
            if(i > 1){
                mark = Math.random() >= 0.5 ? 1 : 0;
            }
            if (0 == mark) {
                Random random = new Random();
                //产生0-9数字
                tmpResult = random.nextInt(10) + "";
            } else {
                char[] englishNumArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                Random random = new Random();
                int sub = random.nextInt(englishNumArray.length);
                //产生A——z字符
                tmpResult = englishNumArray[sub] + "";
            }
            soleResult.append(tmpResult);
        }
        return soleResult.toString() + System.currentTimeMillis();
    }

    /**
     * 内容编码
     *
     * @param str 内容
     * @return 编码后的内容
     */
    public static String urlEncode(String str)
    {
        try
        {
            return URLEncoder.encode(str, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            return "";
        }
    }
}
