<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="text" style="display: none;" name="sortColumn" id="sortColumn"
       value="${pagination.sortColumn}"/>
<input type="text" style="display: none;" name="sortOrder" id="sortOrder"
       value="${pagination.sortOrder}"/>
<table width="100%" align="center">
    <tr>
        <td class="pagination-label" width="100%" nowrap="nowrap">
            ${pagination.pageRecords} 件
        </td>
        <td>
            <c:choose>
                <c:when test="${pagination.previousFlag}">
                    <a href="#" onclick="fnPagination(4,${pagination.totalPages});">
                        <img src="${pageContext.request.contextPath}${pageContext.request.contextPath}/images/admin/left_end.gif" alt="Go to first page" width="15" height="19"/>
                    </a>
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/images/admin/left_end_gray.gif" alt="Go to first page" width="15" height="19"/>
                </c:otherwise>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${pagination.previousFlag}">
                    <a href="#" onclick="fnPagination(3,${pagination.totalPages});">
                        <img src="${pageContext.request.contextPath}/images/admin/left.gif" alt="Go to first page" width="15" height="19"/>
                    </a>
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/images/admin/left_gray.gif" alt="Go to first page" width="15" height="19"/>
                </c:otherwise>
            </c:choose>
        </td>
        <td class="pagination-label" nowrap="nowrap">页数:</td>
        <td>
            <input name="pageNumber" id="pageNumber" class="pagination-textbox"
                   <c:if test="${ pagination.previousFlag && pagination.nextFlag }">readonly="readonly"</c:if>
                   style="width: 30px;" maxlen="1" value="${pagination.pageNumber}" type="text"
                   onclick="fnPagination(7,${pagination.totalPages});"/></td>
        <td class="pagination-label" nowrap="nowrap">of ${pagination.totalPages}</td>

        <td>
            <c:choose>
                <c:when test="${pagination.nextFlag}">
                    <a href="#" onclick="fnPagination(1,${pagination.totalPages});">
                        <img src="${pageContext.request.contextPath}/images/admin/right.gif" alt="Go to next page" width="15" height="19"/>
                    </a>
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/images/admin/right_gray.gif" alt="Go to next page" width="15" height="19"/>
                </c:otherwise>
            </c:choose>

        </td>
        <td>
            <c:choose>
                <c:when test="${pagination.nextFlag}">
                    <a href="#" onclick="fnPagination(2,${pagination.totalPages});">
                        <img src="${pageContext.request.contextPath}/images/admin/right_end.gif" alt="Go to next page" width="15" height="19"/>
                    </a>
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/images/admin/right_end_gray.gif" alt="Go to next page" width="15" height="19"/>
                </c:otherwise>
            </c:choose>
        </td>
        <td>&nbsp;</td>
        <td class="pagination-label" nowrap="nowrap">每页件数</td>
        <td class="pagination-linkoff" style="" nowrap="nowrap">
            <select name="pageSize" id="pageSize" theme="simple" onchange="fnPagination(5,0);">
                <option value="5" <c:if test="${pagination.pageSize==5}">selected</c:if> >5</option>
                <option value="10" <c:if test="${pagination.pageSize==10}">selected</c:if> >10</option>
                <option value="50" <c:if test="${pagination.pageSize==50}">selected</c:if>  >50</option>
                <option value="100" <c:if test="${pagination.pageSize==100}">selected</c:if> >100</option>
                <option value="0" <c:if test="${pagination.pageSize==0}">selected</c:if>>All</option>
            </select>

        </td>
    </tr>
</table>
