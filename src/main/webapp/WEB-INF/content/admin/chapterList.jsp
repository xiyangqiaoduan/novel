<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp" />
   <input type="hidden" name="articleno" value="${article.articleno}"/>
    <br>
    <table class="yidu-table" align="center">
        <colgroup>
            <col width="240px">
            <col width="240px">
            <col width="240px">
            <col width="240px">
        </colgroup>
        <tr>
            <td class="ac_odd" colspan="4">《${article.articlename}》-${article.author}
            &nbsp;&nbsp;&nbsp;[新建分卷] [<a href="${pageContext.request.contextPath}/admin/chapter/addPage?articleno=${article.articleno}">增加章节</a>]
             [<a href="${pageContext.request.contextPath}/admin/chapter/delall/${article.articleno}">清空文章</a>]
		   <input type="hidden" name="articleid" id="articleid" value="45911">
        </td>
        </tr>

        <c:forEach var="chapter" items="${chapterList}" varStatus="status">
            <c:if test="${status.index % 4 ==0} ">
                <c:choose>
                <c:when test="${status.index/ 4 % 2 == 1}">
                    <tr class="ac_odd">
                </c:when>
                <c:otherwise>
                    <tr>
                </c:otherwise>
                </c:choose>
            </c:if>
            <td>
                <a href="${pageContext.request.contextPath}/admin/chapter/editPage/${chapter.chapterno}">${chapter.chaptername}</a>
                <a href="javascript:confirmDelete('${pageContext.request.contextPath}/admin/chapter/del/${chapter.chapterno}')" style="color:red">删除</a>
            </td>
            <c:if test="${status.index % 4 ==3}">
                </tr>
            </c:if>
        </c:forEach>
    </table>
    </div>
    <jsp:include page="/WEB-INF/content/admin/commom/footer.jsp" />
</body>
</html>