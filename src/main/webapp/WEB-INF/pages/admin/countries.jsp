<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">Countries</h2>
    <div class="head-button">
        <form action="${pageContext.request.contextPath}/countries" , method="post">
            <button class="insert" name="action" value="insertForm">Add</button>
        </form>
    </div>
    <div class="clear"></div>
    <table>
        <c:forEach items="${countries}" var="item">
            <tr>
                <form action="${pageContext.request.contextPath}/countries" method="post">
                    <input type="hidden" name="countryId" value="${item.getId()}">
                    <input type="hidden" name="countryName" value="${item.getName()}">
                    <td>${item.getName()} </td>
                    <td>
                        <button name="action" value="editForm" type="submit">Edit</button>
                    </td>
                    <td>
                        <button name="action" value="delete" type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                    </td>
                    <td>
                        <button name="action" value="statistic" type="submit">Visa Statistic</button>
                    </td>

                </form>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <div id="statistic">Number of Visas: ${numberOfVisas} </div>
    <br>
    <div class="bottom-button">
        <a href="/adminsCabinet"><button>Back</button></a>
    </div>
    <div class="clear"></div>
</div>
<%--<script type="text/javascript">--%>
    <%--(function showStatistic() {--%>
        <%--if(document.getElementById("stat").value !== 0){--%>
            <%--document.getElementById("statistic").style.display = "block";--%>
        <%--}--%>
    <%--})();--%>
<%--</script>--%>
</body>
</html>
