<%@page contentType="text/html" pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="root"/>
        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from product_details63 WHERE pid=?; 
            <sql:param value="${param.pid}"/>
        </sql:query>
            <h3>Update</h3>
            <form action="updatedb.jsp">
                <table>
                    <tr>
                        <th>Product Name</th>
                        <th>Quantity</th>
                    </tr>
                    <c:forEach var="row" items="${result.rows}">
                    <tr>
                        
                        <td><input type="hidden" value="${param.pid}" name="pid" > 
                        <input type="text" value="${param.pname}" name="pname">
                        </td>
                        <td><input type="text" value="${param.quantity}" name="quantity"></td>
                        <td><input type="submit" value="Update"></td>
                        
                    </tr>
                    </c:forEach>
                    

                </table>    
                <a href="index.html">Go Home</a>
            </form>  
    </body>
</html>
            
            
            
            
            
            
            