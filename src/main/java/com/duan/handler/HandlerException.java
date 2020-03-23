package com.duan.handler;

import com.duan.exception.AgeException;
import com.duan.exception.NameException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerException implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {
       ModelAndView mv = new ModelAndView();
       mv.addObject("ex",e);
        if (e instanceof NameException){
            mv.addObject("tips","需要提示的信息");
            mv.setViewName("nameError");
        }else  if (e instanceof AgeException){
            mv.addObject("tips","需要提示的信息");
            mv.setViewName("ageError");
        }else {
            mv.addObject("tips","需要提示的信息");
            mv.setViewName("otherError");
        }
        return mv;
    }
}
