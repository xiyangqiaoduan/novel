<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp"/>


<form action=
      <c:choose>
            <c:when test="${chapter==null}">
              "${pageContext.request.contextPath}/admin/chapter/save"
            </c:when>
            <c:otherwise>"${pageContext.request.contextPath}/admin/chapter/edit"</c:otherwise>
      </c:choose>
        method="post" validate="true">
<br>
<table class="yidu-table" align="center">
    <colgroup>
        <col width="120px">
        <col width="580px">
    </colgroup>
    <tbody>
    <tr>
        <th colspan="2">章节添加编辑</th>
    </tr>
    <tr>
        <td>小说名</td>
        <td>
            <c:choose>
                <c:when test="${chapter==null}">
                    ${article.articlename}
                </c:when>
                <c:otherwise>
                    ${chapter.articlename}
                </c:otherwise>
            </c:choose>

        </td>
    </tr>
    <c:if test="chapter!=null">
        <tr>
            <td>章节编号</td>
            <td>
                    ${chapter.chapterno}
            </td>
        </tr>
    </c:if>
    <tr>
        <td>章节名</td>
        <td>
            <input name="chaptername" id="chaptername" value="${chapter.chaptername}" class="tb-rounded" maxlength="32">
        </td>
    </tr>
    <tr>
        <td>类型</td>
        <td>
            <input type="radio" name="vip" value="0" <c:if test="${chapter.isvip!=true}">checked</c:if>>普通
            <input type="radio" name="vip" value="1" <c:if test="${chapter.isvip ==true}">checked</c:if>>VIP
        </td>
    </tr>
    <tr>
        <td>内容</td>
        <td>
            <textarea rows="30" cols="20" id="content" name="content" class="tb-rounded">${content}</textarea>
        </td>
    </tr>
    <c:if test="chapter!=null">
        <tr>
            <td>发布时间</td>
            <td>
                <input name="postdate"
                       value=" <fmt:formatDate value="${chapter.postdate}" dateStyle="yyyy-MM-dd HH:mm" />"/>
            </td>
        </tr>
    </c:if>

    <tr>
        <td colspan="2" style="text-align: center; padding: 2px">
            <input name="submit" type="button" value="返回" method="back" class="submitButton" theme="simple"
                   onclick="history.back()"/>

            <c:choose>
                <c:when test="${chapter==null}">
                    <input name="submit" type="submit" value="保存" method="save" class="submitButton" theme="simple"/>
                </c:when>
                <c:otherwise>
                    <input name="submit" type="submit" value="更新" method="save" class="submitButton" theme="simple"/>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    </tbody>
</table>

<c:choose>
    <c:when test="${chapter==null}">
        <input type="hidden" name="articlename" value="${article.articlename}"/>
        <input type="hidden" name="articleno" value="${article.articleno}"/>
    </c:when>
    <c:otherwise>
        <input type="hidden" name="articlename" value="${chapter.articlename}"/>
        <input type="hidden" name="articleno" value="${chapter.articleno}"/>
    </c:otherwise>
</c:choose>


<input type="hidden" name="chapterno" value="${chapter.chapterno}"/>
</form>
</div>
<jsp:include page="/WEB-INF/content/admin/commom/footer.jsp"/>
</body>
</html>
