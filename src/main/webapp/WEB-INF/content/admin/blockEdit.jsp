<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp"/>
<body>
<c:choose>
    <c:when test="${block==null}">
        <form action="${pageContext.request.contextPath}/admin/systemblock/save" method="post">
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/admin/systemblock/update" method="post">
    </c:otherwise>
</c:choose>

    <input type="hidden" name="blockno" value="${block.blockno == null ?0:block.blockno}"/>
    <br>
    <table class="yidu-table" align="center">
        <colgroup>
            <col width="120px">
            <col width="442px">
        </colgroup>
        <tbody>
        <tr>
            <th colspan="2">区块设置</th>
        </tr>
        <tr>
            <td>区块ID</td>
            <td>
                <input type="text" name="blockid" id="blockid" maxlength="32" class="tb-rounded"
                       value="${block.blockid}"/>
            </td>
        </tr>
        <tr>
            <td>区块名</td>
            <td>
                <input name="blockname" value="${block.blockname}" id="blockname" maxlength="32" class="tb-rounded"/>
            </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <select id="type" name="type">
                    <option value="10"
                            <c:if test="${block.type == 10}">selected</c:if> >标准小说列表(各种排行榜单)
                    </option>
                    <option value="40" <c:if test="${block.type == 40}">selected</c:if>>随机小说列表(为了性能，暂不支持类型)</option>
                    <option value="50" <c:if test="${block.type == 50}">selected</c:if>>
                        动态推荐小说列表(同分类当前小说的后几本，只用于简介，章节列表，阅读页)
                    </option>
                    <option value="20" <c:if test="${block.type == 20}">selected</c:if>>自定义小说列表</option>
                    <option value="30" <c:if test="${block.type == 30}">selected</c:if>>HTML内容</option>
                    <option value="60" <c:if test="${block.type == 60}">selected</c:if>>和显示名字相似的小说(只用于简介，章节列表，阅读页)
                    </option>
                    <option value="70" <c:if test="${block.type == 70}">selected</c:if>>同作者小说列表</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>分类</td>
            <td>
                <select id="category" name="category">
                    <option value="0" selected>请选择分类</option>
                    <option value="1" <c:if test="${block.category == 1}">selected</c:if>>玄幻魔法</option>
                    <option value="2" <c:if test="${block.category == 2}">selected</c:if>>武侠修真</option>
                    <option value="3" <c:if test="${block.category == 3}">selected</c:if>>都市言情</option>
                    <option value="4" <c:if test="${block.category == 4}">selected</c:if>>历史军事</option>
                    <option value="5" <c:if test="${block.category == 5}">selected</c:if>>侦探推理</option>
                    <option value="6" <c:if test="${block.category == 6}">selected</c:if>>网游动漫</option>
                    <option value="7" <c:if test="${block.category == 7}">selected</c:if>>科幻小说</option>
                    <option value="8" <c:if test="${block.category == 8}">selected</c:if>>恐怖灵异</option>
                    <option value="9" <c:if test="${block.category == 9}">selected</c:if>>散文诗词</option>
                    <option value="10" <c:if test="${block.category == 10}">selected</c:if>>其他类型</option>
                </select>

            </td>
        </tr>
        <tr>
            <td>排序</td>
            <td>
                <select id="sortcol" name="sortcol">
                    <option value="" selected>请选择排序</option>
                    <option value="lastupdate" <c:if test="${block.sortcol eq 'lastupdate'}">selected</c:if>>最后更新时间
                    </option>
                    <option value="postdate" <c:if test="${block.sortcol eq 'postdate'}">selected</c:if>>入库时间</option>
                    <option value="allvisit" <c:if test="${block.sortcol eq 'allvisit'}">selected</c:if>>总排行</option>
                    <option value="monthvisit" <c:if test="${block.sortcol eq 'monthvisit'}">selected</c:if>>月排行
                    </option>
                    <option value="weekvisit" <c:if test="${block.sortcol eq 'weekvisit'}">selected</c:if>>周排行</option>
                    <option value="dayvisit" <c:if test="${block.sortcol eq 'dayvisit'}">selected</c:if>>日排行</option>
                    <option value="allvote" <c:if test="${block.sortcol eq 'allvote'}">selected</c:if>>总推荐</option>
                    <option value="monthvote" <c:if test="${block.sortcol eq 'monthvote'}">selected</c:if>>月推荐</option>
                    <option value="weekvote" <c:if test="${block.sortcol eq 'weekvote'}">selected</c:if>>周推荐</option>
                    <option value="dayvote" <c:if test="${block.sortcol eq 'dayvote'}">selected</c:if>>日推荐</option>
                    <option value="size" <c:if test="${block.sortcol eq 'size'}">selected</c:if>>小说字数</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>升序</td>
            <td>
                <input type="radio" name="isasc" value="1"
                       <c:if test="${block.isasc ==true}">checked</c:if> />是
                <input type="radio" name="isasc" value="0" <c:if test="${block.isasc ==false}">checked</c:if>/>否
            </td>
        </tr>
        <tr>
            <td>全本</td>
            <td>
                <input type="radio" name="isfinish" value="1" <c:if test="${block.isfinish ==true}">checked</c:if>/>是
                <input type="radio" name="isfinish" value="0" <c:if test="${block.isfinish ==false}">checked</c:if>/>否
            </td>
        </tr>
        <tr>
            <td>显示件数</td>
            <td>
                <input type="text" id="limitnum" name="limitnum" value="${block.limitnum}" class="tb-rounded"/>
            </td>
        </tr>
        <tr>
            <td>内容</td>
            <td>
                <textarea id="content" name="content" class="tb-rounded" cols="30" rows="5">${block.content}</textarea>
            </td>
        </tr>
        <tr>
            <td>表示对象画面</td>
            <td>
                <select id="target" name="target">
                    <option value="6" <c:if test="${block.target==6}">selected</c:if>>首页</option>
                    <option value="1" <c:if test="${block.target==1}">selected</c:if>>小说分类画面</option>
                    <option value="2" <c:if test="${block.target==2}">selected</c:if>>小说介绍画面</option>
                    <option value="3" <c:if test="${block.target==3}">selected</c:if>>章节列表画面</option>
                    <option value="4" <c:if test="${block.target==4}">selected</c:if>>小说阅读画面</option>
                    <option value="7" <c:if test="${block.target==7}">selected</c:if>>小说排行榜画面</option>
                    <option value="99" <c:if test="${block.target==99}">selected</c:if>>全站</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center; padding: 2px">
                <input type="submit" value="返回" class="submitButton" theme="simple" onclick="history.back()"/>

                <c:choose>
                    <c:when test="${ block ==null}">
                        <input type="submit" value="保存" class="submitButton" theme="simple"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="更新" class="submitButton" theme="simple"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<jsp:include page="/WEB-INF/content/admin/commom/footer.jsp"/>
</body>
</html>
