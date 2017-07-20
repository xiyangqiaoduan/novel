<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp"/>
<form  action="${pageContext.request.contextPath}/admin/article/list" method="post" name="paginationForm">

    <input type="hidden" name="category"/>
    <div id="channel-header" class="clear fix">
        <div class="channel-header-wrapper">
            <nav class="channel-nav">
                <ul class="channel-nav-list">
                    <li
                            <c:if test="${category==0}">class="current"</c:if> ><a href="${pageContext.request.contextPath}/admin/article/list">全部小说</a>
                    </li>
                    <li
                            <c:if test="${category==1}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=1">玄幻魔法</a></li>
                    <li
                            <c:if test="${category==2}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=2">武侠修真</a></li>
                    <li
                            <c:if test="${category==3}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=3">都市言情</a></li>
                    <li
                            <c:if test="${category==4}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=4">历史军事</a></li>
                    <li
                            <c:if test="${category==5}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=5">侦探推理</a></li>
                    <li
                            <c:if test="${category==6}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=6">网游动漫</a></li>
                    <li
                            <c:if test="${category==7}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=7">科幻小说</a></li>
                    <li
                            <c:if test="${category==8}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=8">恐怖灵异</a></li>
                    <li
                            <c:if test="${category==9}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=9">散文诗词</a></li>
                    <li
                            <c:if test="${category==10}">class="current"</c:if> ><a
                            href="${pageContext.request.contextPath}/admin/article/list?category=10">其他类型</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <table align="center">
        <tr>
            <td>
                小说搜索（支持小说名，作者名模糊检索）
            </td>
            <td>&nbsp;&nbsp;</td>
            <td>
                <input type="text" name="key" id="key" maxlength="30" size="30"/>
            </td>
            <td>&nbsp;&nbsp;</td>
            <td>
                <input type="submit" id="searchbuttom" value="搜索">
            </td>
            <td>&nbsp;&nbsp;</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/article/list?allvisit=0&category=${category}">冷门文章</a> |
                <a href="${pageContext.request.contextPath}/admin/article/list?hasChapter=0&category=${category}">空文章</a>
            </td>
        </tr>
    </table>
    <table align="center">
        <tr>
            <td> [<a href="javascript:selectAll()">全选</a>] [<a href="javascript:unSelectAll()">全取消</a>]</td>
            <td>[<a href="javascript:operApply()">批量删除</a>]</td>
            <td> [<a href="${pageContext.request.contextPath}/admin/article/addPage">添加小说</a>]</td>
        </tr>
    </table>
    <table class="yidu-table" align="center">
        <colgroup>
            <col width="30px">
            <col width="150px">
            <col width="100px">
            <col width="120px">
            <col width="280px">
            <col width="120px">
            <col width="150px">
        </colgroup>
        <tr>
            <th></th>
            <th class="sortable <c:if test="${pagination.sortColumn eq 'articlename'}">sorted ${pagination.sortClass} </c:if>">
                <a href="#" onclick="fnPagination(6,'articlename');">小说名</a></th>

            <th class="sortable <c:if test="${pagination.sortColumn eq 'category'}">sorted  ${pagination.sortClass} /> </c:if>">
                <a href="#" onclick="fnPagination(6,'category');">类型</a></th>

            <th class="sortable <c:if test="${pagination.sortColumn eq 'author'}">sorted ${pagination.sortClass} </c:if>">
                <a href="#" onclick="fnPagination(6,'author');">作者</a></th>

            <th class="sortable">最新章节</th>

            <th class="sortable <c:if test="${pagination.sortColumn eq 'lastupdate'} ">sorted ${pagination.sortClass} </c:if>">
                <a href="#" onclick="fnPagination(6,'lastupdate');">更新时间</a></th>

            <th class="sortable">操作</th>
        </tr>

        <c:forEach var="article" items="${articleList}" varStatus="status">

            <c:choose>
                <c:when test="${status.index%2>0}">
                    <tr class="ac_odd">
                </c:when>
                <c:otherwise>
                    <tr>
                </c:otherwise>
            </c:choose>
            <td><input type="checkbox" name="article_articleno" value="${article.articleno}"/></td>
            <td>${article.articlename}</td>
            <td>
                <c:choose>
                    <c:when test="${article.category==1}">玄幻魔法</c:when>
                    <c:when test="${article.category==2}">武侠修真</c:when>
                    <c:when test="${article.category==3}">都市言情</c:when>
                    <c:when test="${article.category==4}">历史军事</c:when>
                    <c:when test="${article.category==5}">侦探推理</c:when>
                    <c:when test="${article.category==6}">网游动漫</c:when>
                    <c:when test="${article.category==7}">科幻小说</c:when>
                    <c:when test="${article.category==8}">恐怖灵异</c:when>
                    <c:when test="${article.category==9}">散文诗词</c:when>
                    <c:when test="${article.category==10}">其他类型</c:when>
                </c:choose>

            </td>
            <td>${article.author}</td>
            <td>${article.lastchapter}</td>
            <td>
                <fmt:formatDate value="${article.lastupdate}"  pattern="yyyy-MM-dd HH:mm" />
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/article/editPage/${article.articleno}">编辑</a>
                <a href="javascript:confirmDelete('${pageContext.request.contextPath}/admin/article/del?articleno=${article.articleno}')">删除</a>
                <a href="${pageContext.request.contextPath}/admin/chapter/list?articleno=${article.articleno}">章节列表</a>
            </td>
            </tr>
        </c:forEach>
    </table>
    <table width="950px" align="center">
        <tr>
            <td class="pagination-label" width="100%" nowrap="nowrap">
                <jsp:include page="/WEB-INF/content/admin/commom/pagination.jsp"/>
            </td>
        </tr>
    </table>
    </div>
</form>
<jsp:include page="/WEB-INF/content/admin/commom/footer.jsp"/>
</body>
</html>