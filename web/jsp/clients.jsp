<%@ page import="client.model.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
</head>
<body>
<h1>hi</h1>
<%--<%--%>
    <%--LinkedList<Client> clients=%>"${clients}"<%;%>--%>
    <%--for(Client client:clients){%>--%>
<%--<h2><%=client.getName()%></h2>--%>
    <%--<%}%>--%>
<%--<%List<Client> cls=${clients};%>--%>
<table border="2" width="80%">
    ${ clients.size() }
        ${ clients.get(1).toString() }
<c:forEach items="${ clients.size() }" var="cl">
    <tr>
        <td>
                ${clients.get(cl)}
                <%--${cl.accountNumber}--%>
            <c:out value="${cl}"/>
            ${ clients.get(0).birthday.toString() }

        </td>
    </tr>
</c:forEach>
    <%--<%List<Client> clientList=session.;%>--%>
</table>
</body>
</html>