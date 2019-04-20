package com.amdsystems.web.controller;

import com.amdsystems.service.SubscriberService;
import com.amdsystems.web.model.Greeting;
import com.amdsystems.web.model.TrafficModel;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Controller
public class GreetingController {




    @RequestMapping(value = "/image", method = RequestMethod.GET)
    @ResponseBody
    public Greeting getImageAsByteArray(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("out/production/resources/webapp/static/image.png");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
       // response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      //  IOUtils.copy(resource.getInputStream(), response.getOutputStream());
      WebApplicationContext context=  WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        return new Greeting(1, "xmlbody");
    }

    @GetMapping("/async")
    public DeferredResult<ResponseEntity<?>> handleReqDefResult(Model model) {
        System.out.println("Received async-deferredresult request");
        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();

        ForkJoinPool.commonPool().submit(() -> {
            System.out.println("Processing in separate thread");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
            }
            output.setResult(ResponseEntity.ok("ok"));
        });

        System.out.println("servlet thread freed");
        return output;
    }


    @GetMapping("/greeting")
    public String greetingForm(Model model, HttpServletRequest request) throws Exception {
       if (1==1)
           throw new Exception("-------------Illegal");
        model.addAttribute("greeting", new Greeting());
        request.getCookies();
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(Greeting greeting, HttpSession session, WebRequest request, ServletResponse response,
                               Model model, ServletRequest servletRequest, RedirectAttributes attributes) throws IOException {
      //  attributes.setAttribute("greeting", greeting);
        String test = servletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(test);
    //    response.getWriter().write(greeting.getContent());
        attributes.addFlashAttribute("greeting", greeting);
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String result(Model model) {
        return "result";
    }

    @GetMapping(value = "/1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void result1(Model model, HttpServletRequest request, ServletResponse response) throws IOException {

        response.getWriter().write("foo({\"bar\": \"bazzzzz\"});");
    }
}



