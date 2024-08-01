package com.qrcode.rewrite.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {

    @GetMapping("/")
    public ModelAndView redirectBasedOnQueryParam(@RequestParam(name = "rewrite", required = false) String rewriteUrl) {
        if (rewriteUrl != null && !rewriteUrl.isEmpty()) {
            // 这里假设rewriteUrl已经是完整的URL，包括协议（http://或https://）
            // 如果rewriteUrl只是域名或路径，你需要根据需要进行拼接
            String redirectUrl = rewriteUrl; // 可能需要处理为完整的URL，例如添加协议或路径
            return new ModelAndView("redirect:" + redirectUrl);
        } else {
            // 如果没有提供rewrite参数，或者参数为空，可以重定向到默认页面
            return new ModelAndView("redirect:/defaultPage");
        }
    }
}
