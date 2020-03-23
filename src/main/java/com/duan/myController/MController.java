package com.duan.myController;

import com.duan.domain.Student;
import com.duan.exception.AgeException;
import com.duan.exception.MyUserException;
import com.duan.exception.NameException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Controller等同于 extends Controller
 */
@Controller
public class MController {
    /**
     * method 代表的只能使用get方法请求
     * 形参和属性值的名字一模一样为注意接收属性值参数
     * @RequestParam（“”） 可用再参数前 eg:@RequestParam(value = "name") String name
     * */
    @RequestMapping(value = "/some.do" , method = RequestMethod.GET)
    public ModelAndView dosome(Student student){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","娃哈哈");
        mv.addObject("name",student.getName());
        mv.addObject("age",student.getAge());
        mv.addObject("student",student);
        mv.setViewName("result");
        return mv;
    }
    @RequestMapping(value = "/some1.do" , method = RequestMethod.GET)
    public ModelAndView dosome1(String name ,Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","娃哈哈");
        if (!name.equals("zs")){
            throw new NameException("姓名不正确");
        }
        if(age==null || age>80){
            throw new AgeException("年龄不正确");
        }
        mv.setViewName("result");
        return mv;
    }
    @RequestMapping(value = "/yy.do")
    public void ajax(String name, int age, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        String json = mapper.writeValueAsString(student);
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
    /**
     *
     *     @ExceptionHandler(value = NameException.class)
     *     public ModelAndView doNameException(String name ,Integer age){
     *         ModelAndView mv = new ModelAndView();
     *         mv.addObject("tips","需要提示的信息");
     *         mv.setViewName("nameError");
     *         mv.setViewName("result");
     *         return mv;
     *         }
     */
}
