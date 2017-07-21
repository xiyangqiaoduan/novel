<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp" />
  <form  action="${pageContext.request.contextPath}/admin/message/list" method="post" name="paginationForm">

    <table class="yidu-table" align="center">
        <colgroup>
            <col width="100px">
            <col width="170px">
            <col width="400px">
            <col width="130px">
            <col width="50px">
            <col width="100px">
        </colgroup>
        <tr>
            <th class="sortable <c:if test="${pagination.sortColumn eq 'loginid'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'loginid');">发件人</a></th>
            
            <th class="sortable <c:if test="${ pagination.sortColumn eq 'title'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'title');">标题</a></th>
            
            <th style="word-break:break-all; word-wrap:break-word;">内容</th>
            
            <th class="sortable <c:if test="${pagination.sortColumn eq 'postdate'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'postdate');">日期</a></th>
            
            <th class="sortable <c:if test="${pagination.sortColumn eq 'isread'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'isread');">状态</a></th>
            
            <th class="sortable">操作</th>
        </tr>

        <c:forEach items="${messageList}" var="message" varStatus="status">

        <c:choose>

            <c:when test="${status.index%2>0}"> <tr class="ac_odd"></c:when>
            <c:otherwise>  <tr></c:otherwise>
        </c:choose>

            <td>${message.loginid}</td>
            <td>${message.title}</td>
            <td>${message.content}</td>
            <td>
                <fmt:formatDate value="${message.postdate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
            </td>
            <td>
                    <c:choose>
                        <c:when test="${message.isread==true}">已读</c:when>
                        <c:otherwise>未读</c:otherwise>
                    </c:choose>

            </td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/message/reply?messageno=${message.messageno}">回复</a>
                <a href="javascript:confirmDelete('${pageContext.request.contextPath}/admin/message/del/${message.messageno}')">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <table width="950px" align="center">
        <tr>
            <td class="pagination-label" width="100%" nowrap="nowrap">
                    <jsp:include page="/WEB-INF/content/admin/commom/pagination.jsp" />
            </td>
        </tr>
    </table>
    </div>
     </form>
    <jsp:include page="/WEB-INF/content/admin/commom/footer.jsp" />
</body>
</html>