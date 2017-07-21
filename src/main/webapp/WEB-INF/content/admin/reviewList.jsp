<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp" />
<form  action="${pageContext.request.contextPath}/admin/review/list" method="post" name="paginationForm">
    <table align="center">
        <tr>
            <td>
            评论搜索：
                <select name="option" theme="simple">
                    <option value="articlename" <c:if test="${option eq 'articlename'}">selected</c:if>>小说名</option>
                    <option value="loginid" <c:if test="${option eq 'loginid'}">selected</c:if>>用户名</option>
                    <option value="chaptername" <c:if test="${option eq 'chaptername'}">selected</c:if> >章节名</option>
                </select>

            </td>
            <td>&nbsp;&nbsp;</td>
            <td>
                <input value="${key}" name="key" maxlength="30"  size="30"/>
            </td>
            <td>&nbsp;&nbsp;</td>
            <td>
                <input type="submit" id="searchbuttom" value="搜索">
            </td>
        </tr>
    </table>
    <table class="yidu-table" align="center">
        <colgroup>
            <col width="80px">
            <col width="150px">
            <col width="170px">
            <col width="170px">
            <col width="140px">
            <col width="120px">
            <col width="80px">
        </colgroup>
        <tr>
            <th class="sortable <c:if test="${pagination.sortColumn eq 'reviewno'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'reviewno');">评论编号</a></th>
            
            <th class="sortable <c:if test="${pagination.sortColumn eq 'loginid'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'loginid');">用户名</a></th>
            
            <th class="sortable <c:if test="${pagination.sortColumn eq 'articlename'}">sorted ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'articlename');">小说名</a></th>
            
            <th class="sortable <c:if test="${pagination.sortColumn eq 'chaptername'}">sorted  ${pagination.sortClass} </c:if>">
            <a href="#" onclick="fnPagination(6,'chaptername');">章节名称</a></th>
            
            <th class="sortable">评论</th>
            <th class="sortable">发布时间</th>
            <th class="sortable">操作</th>

        </tr>
        <c:forEach items="${reviewList}"  var="review" varStatus="status">

            <c:choose>
                <c:when test="${status.index%2>0}">
                    <tr class="ac_odd">
                </c:when>
                <c:otherwise>
                    <tr>
                </c:otherwise>
            </c:choose>

            <td>${review.reviewno}</td>
            <td>${review.loginid}</td>
            <td>${review.articlename}</td>
            <td>${review.chaptername}</td>
            <td>${review.review}</td>
            <td><fmt:formatDate value="${review.postdate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
            <td>
                <a href="javascript:confirmDelete('${pageContext.request.contextPath}/admin/review/del/${review.reviewno}')">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <table width="910px" align="center">
        <tr>
            <td class="pagination-label" width="100%" nowrap="nowrap">
                <form namespace="/admin" action="reviewList" method="post" name="paginationForm">
                    <jsp:include page="/WEB-INF/content/admin/commom/pagination.jsp" />
                </form>
            </td>
        </tr>
    </table>
    </div>
    </form>
    <jsp:include page="/WEB-INF/content/admin/commom/footer.jsp" />
</body>
</html>