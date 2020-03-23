<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/1/9
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试项目</title>
    <script type="text/javascript" src="/js/jQuery.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                $.ajax({
                    url:"/yy.do",
                    data:{
                        "name":"zhangsan",
                        "age":20
                    },
                    type:"post",
                    dataType:"json",
                    success:function (resp) {
                        alert(resp.name+"||"+resp.age)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>提交参数</p>
    <form action="some.do" >
        姓名:<input type="text" name="name"/><br/>
        年龄:<input type="text" name="age"/><br/>
        <input type="submit"/>
    </form>
    <form action="some1.do" >
        姓名:<input type="text" name="name"/><br/>
        年龄:<input type="text" name="age"/><br/>
        <input type="submit"/>
    </form>
    <button>发起请求</button>
</body>
</html>
