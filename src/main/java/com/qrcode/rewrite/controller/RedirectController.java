package com.qrcode.rewrite.controller;
import com.qrcode.rewrite.service.SysMainDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class RedirectController {

    @Autowired
    private SysMainDomainService mainDomainService;

    @GetMapping("/")
    public ModelAndView redirectBasedOnQueryParam(HttpServletRequest request, @RequestParam(name = "webType", required = false) String webType, @RequestParam(name = "parentUserId", required = false) Long parentUserId) throws InterruptedException {

        if (webType != null && !webType.isEmpty()) {

            String redirectUrl = mainDomainService.getMainUrlByWebType(webType); // 可能需要处理为完整的URL，例如添加协议或路径
            if(!StringUtils.isEmpty(redirectUrl)){
                String redirectHostUrl = request.getRequestURL().toString();
                redirectHostUrl = redirectHostUrl + "/dpc/qrRedirect?redirectUrl=" + urlEncode(redirectUrl);

                if(parentUserId != null && parentUserId > 0){
                    redirectHostUrl = redirectHostUrl + "&parentUserId=" + parentUserId;
                }
                return new ModelAndView("redirect:" + redirectHostUrl);

//                Thread.sleep(1000);//延迟1秒跳转
//                if(!redirectUrl.startsWith("http") && !redirectUrl.startsWith("https")){
//                    redirectUrl = "http://" + redirectUrl;
//                }
//                if(parentUserId != null && parentUserId > 0){
//                    redirectUrl = redirectUrl + "?parentUserId=" + parentUserId;
//                }
//                return new ModelAndView("redirect:" + redirectUrl);
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
            redirectHostUrl = redirectHostUrl + "&parentUserId=" + parentUserId;
        }
        return new ModelAndView("redirect:" + redirectHostUrl);
    }

    @GetMapping("/dpc/qrRedirectSecond")
    public ModelAndView qrRedirectSecond(HttpServletRequest request, @RequestParam(name = "redirectUrl", required = false) String redirectUrl, @RequestParam(name = "parentUserId", required = false) Long parentUserId) {

        String redirectHostUrl = request.getRequestURL().toString().replace(request.getRequestURI(),"");
        redirectHostUrl = redirectHostUrl + "/dpc/threeRedirect?redirectUrl=" + urlEncode(redirectUrl);
        if(parentUserId != null && parentUserId > 0){
            redirectHostUrl = redirectHostUrl + "&parentUserId=" + parentUserId;
        }
        return new ModelAndView("redirect:" + redirectHostUrl);
    }

    @GetMapping("/dpc/threeRedirect")
    public ModelAndView threeRedirect(@RequestParam(name = "redirectUrl", required = false) String redirectUrl, @RequestParam(name = "parentUserId", required = false) Long parentUserId) throws InterruptedException {
        Thread.sleep(1000);//延迟1秒跳转

        if(!redirectUrl.startsWith("http") && !redirectUrl.startsWith("https")){
            redirectUrl = "http://" + redirectUrl;
        }
        if(parentUserId != null && parentUserId > 0){
            redirectUrl = redirectUrl + "?parentUserId=" + parentUserId;
        }
        return new ModelAndView("redirect:" + redirectUrl);
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
