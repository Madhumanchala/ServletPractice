<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="FirstServlet" method="post">  
Name:<input type="text" name="userName"/><br/>  
<input type="submit" value="go"/>  

	 <fieldset style="width:20%; background-color:#e6ffe6;">
                <legend>Count visitor</legend>
                <%
                    Integer hitsCount =
                    (Integer)application.getAttribute("hitCounter");
                    if( hitsCount ==null || hitsCount == 0 )
                    {
                        /* First visit */
                        out.println("Welcome to my website!!");
                        hitsCount = 1;
                    }
                    else
                    {
                        /* return visit */
                        out.println("Welcome to my website!!");
                        hitsCount += 1;
                    }
                    application.setAttribute("hitCounter", hitsCount);
                %>
                <p>You are visitor number: <%= hitsCount%></p>
            </fieldset>
</body>
</html>