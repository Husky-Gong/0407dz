<%--
  Created by IntelliJ IDEA.
  User: jersey
  Date: 4/9/20
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <script type="text/javascript" src="js/jquery-1.12.3.min.js"/>

    <script type="text/javascript">
        $(function(){
            $("form").submit(function(){
                var name = $("#name").val();
                var price = $("#price").val();
                var production = $("#production").val();

                if(name!="" && price!="" && production!=""){
                    return true;
                }
                else{
                    alert("Error!");
                    return false;
                }
            })
        })
    </script>
</head>
<body>

<h3>Flower Add</h3>
    <form method="post" action="zx/flowerSaveServlet">
        <p>
            NAME:<input type="text" name="name" id="name"/>${requestScope.msg}
        </p>
        <p>
            PRICE:<input type="text" name="price" id="price"/>
        </p>
        <p>
            PRODUCTION:<input type="text" name="production" id="production"/>
        </p>
        <p>
            <input type="submit" value="SUBMIT"/>
        </p>
    </form>
</body>
</html>
