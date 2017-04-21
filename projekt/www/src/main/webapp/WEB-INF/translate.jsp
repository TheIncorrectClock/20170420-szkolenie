<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tłumaczenie dla słowa ${word}</title>
</head>
<body>

<c:forEach items="${words}" var="w">
    <li> ${w}</li>
</c:forEach>

</body>
</html>