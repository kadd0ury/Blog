<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
        </head>
        <body>
            <form:form modelAttribute="login" action="login" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="username">Username:</form:label>
                        </td>
                        <td>
                            <form:input path="username" />
                         </td>
                         <td>
                <form:errors path="username" cssClass="alert-danger" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password:</form:label>
                            
                
                        </td>
                        <td>
                            <form:password path="password" /> <br>
                            <td>
                            <form:errors path="password" cssClass="alert-danger" style="color:red" /> </td>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="login" name="login">Login</form:button>
                        </td>
                        
             
            </table>
                    </tr>
                    <tr></tr>
               
                </table>
            </form:form>
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
        </body>
        </html>