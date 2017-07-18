<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp"/>
<br>
<table class="yidu-table" align="center">
    <colgroup>
        <col width="130px">
        <col width="100px">
        <col width="250px">
        <col width="250px">
        <col width="100px">
    </colgroup>
    <tr>
        <th class="sortable <c:if test="${ 'blockno' eq pagination.sortColumn}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'blockno');">区块编号</a></th>

        <th class="sortable <c:if test="${ pagination.sortColumn eq 'blockid'}"> sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'blockid');">区块ID</a></th>

        <th class="sortable <c:if test="${ pagination.sortColumn eq 'blockname'}"> sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'blockname');">名称</a></th>

        <th class="sortable <c:if test="${pagination.sortColumn eq 'type'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'type');">类型</a></th>
        <th class="sortable">操作</th>
    </tr>

    <c:forEach items="${blockList}" var="block" varStatus="status">
        <c:choose>
            <c:when test="${status.index%2 > 0}">
                <tr class="ac_odd">
            </c:when>
            <c:otherwise>
                <tr>
            </c:otherwise>
        </c:choose>
        <td>${block.blockno}</td>
        <td>${block.blockid}</td>
        <td>${block.blockname}</td>
        <td>
            <c:choose>
                <c:when test="${block.type eq 10}">
                    标准小说列表(各种排行榜单)
                </c:when>
                <c:when test="${block.type eq 40}">
                    随机小说列表(为了性能，暂不支持类型)
                </c:when>
                <c:when test="${block.type eq 50}">
                    动态推荐小说列表(同分类当前小说的后几本，只用于简介，章节列表，阅读页)
                </c:when>
                <c:when test="${block.type eq 20}">
                    自定义小说列表
                </c:when>
                <c:when test="${block.type eq 30}">
                    HTML内容
                </c:when>
                <c:when test="${block.type eq 60}">
                    和显示名字相似的小说(只用于简介，章节列表，阅读页)
                </c:when>
                <c:when test="${block.type eq 70}">
                    同作者小说列表
                </c:when>
            </c:choose>

        </td>
        <td>
            <a href="${pageContext.request.contextPath}/admin/systemblock/edit/${block.blockno}">编辑</a>
            <a href="javascript:confirmDelete('${pageContext.request.contextPath}/admin/block/delete/${block.blockno}')">删除</a>
        </td>
        </tr>
    </c:forEach>
</table>
<table width="898px" align="center">
    <tr>
        <td class="pagination-label" width="100%" nowrap="nowrap">
            <form  action="${pageContext.request.contextPath}/admin/systemblock/blockList" method="post" name="paginationForm">
                <jsp:include page="/WEB-INF/content/admin/commom/pagination.jsp"/>
            </form>
        </td>
    </tr>
    <tr>
        <td class="pagination-label" width="100%" nowrap="nowrap">
            <a href="${pageContext.request.contextPath}/admin/blockEdit">追加</a>
        </td>
    </tr>
</table>
</div>
<jsp:include page="/WEB-INF/content/admin/commom/footer.jsp"/>
</body>
</html>