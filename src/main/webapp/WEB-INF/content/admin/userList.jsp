<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp"/>
<br>
<table class="yidu-table" align="center">
    <colgroup>
        <col width="120px">
        <col width="170px">
        <col width="170px">
        <col width="100px">
        <col width="150px">
        <col width="120px">
        <col width="80px">
    </colgroup>
    <tr>
        <th class="sortable <c:if test="${pagination.sortColumn eq 'userno' }">sorted ${pagination.sortClass}</c:if>">
            <a href="#" onclick="fnPagination(6,'userno');">用户编号</a></th>

        <th class="sortable <c:if test="${pagination.sortColumn eq 'loginid' }">sorted ${pagination.sortClass}</c:if> ">
            <a href="#" onclick="fnPagination(6,'loginid');">用户名</a></th>

        <th class="sortable <c:if test="${pagination.sortColumn eq 'type'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'type');">种别</a></th>

        <th class="sortable <c:if test="${pagination.sortColumn eq 'sex'}">sorted  ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'sex');">性别</a></th>

        <th class="sortable">注册时间</th>
        <th class="sortable">最后登录时间</th>
        <th class="sortable">操作</th>

    </tr>
    <c:forEach items="${userList}" var="user" varStatus="status">

        <c:choose>
            <c:when test="${status.index%2>0}">
                <tr class="ac_odd">
            </c:when>
            <c:otherwise> <tr></c:otherwise>
        </c:choose>

        <td>${user.userno}</td>
        <td>${user.loginid}</td>
        <td>

            <c:choose>
                <c:when test="${user.type==10}">普通用户</c:when>
                <c:when test="${user.type==20}">作家</c:when>
                <c:when test="${user.type==25}">VIP</c:when>
                <c:when test="${user.type==30}">管理员</c:when>
                <c:when test="${user.type==40}">大分类编辑</c:when>
                <c:when test="${user.type==41}">小分类编辑</c:when>
            </c:choose>

        </td>
        <td>
            <c:choose>
                <c:when test="${user.sex==1}">男</c:when>
                <c:when test="${user.sex==2}">女</c:when>
                <c:otherwise>未知</c:otherwise>
            </c:choose>
        </td>
        <td>
            <fmt:formatDate value="${user.regdate}" pattern="yyyy-MM-dd HH:mm"/>
        </td>
        <td>
            <fmt:formatDate value="${user.lastlogin}" pattern="yyyy-MM-dd HH:mm"/>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/admin/user/edit/${user.userno}">编辑</a>
            <a href="javascript:confirmDelete('${pageContext.request.contextPath}/admin/user/del/${user.userno}')">删除</a>
        </td>
        </tr>
    </c:forEach>
</table>
<table width="910px" align="center">
    <tr>
        <td class="pagination-label" width="100%" nowrap="nowrap">
            <form  action="${pageContext.request.contextPath}/admin/user/list" method="post" name="paginationForm">
                <jsp:include page="/WEB-INF/content/admin/commom/pagination.jsp"/>
            </form>
        </td>
    </tr>
    <tr>
        <td class="pagination-label" width="100%" nowrap="nowrap">
            <a href="${pageContext.request.contextPath}/admin/user/addPage">追加</a>
        </td>
    </tr>
</table>
</div>
<jsp:include page="/WEB-INF/content/admin/commom/footer.jsp"/>
</body>
</html>