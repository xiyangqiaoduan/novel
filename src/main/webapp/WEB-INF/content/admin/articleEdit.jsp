<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp"/>


<form  method="post" enctype="multipart/form-data"  action=
    <c:choose>
        <c:when test="${article==null}"> "${pageContext.request.contextPath}/admin/article/save" </c:when>
        <c:otherwise>"${pageContext.request.contextPath}/admin/article/update" </c:otherwise>
    </c:choose>
    >


    <input name="articleno" value="${article.articleno}" type="hidden">
    <br>
    <table class="yidu-table" align="center">
        <colgroup>
            <col width="120px">
            <col width="580px">
        </colgroup>
        <tbody>
        <tr>
            <th colspan="2">小说添加编辑</th>
        </tr>
        <c:if test="${article.articleno!=0}">
            <tr>
                <td>小说编号</td>
                <td>
                        ${article.articleno}
                </td>
            </tr>
        </c:if>
        <tr>
            <td>小说名</td>
            <td>
                <input name="articlename" value="${article.articlename}" maxlength="32" class="tb-rounded"/>
            </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>

                <select name="category" id="category">
                    <option value="1" <c:if test="${article.category == 1}">selected</c:if>>玄幻魔法</option>
                    <option value="2" <c:if test="${article.category == 2}">selected</c:if>>武侠修真</option>
                    <option value="3" <c:if test="${article.category == 3}">selected</c:if>>都市言情</option>
                    <option value="4" <c:if test="${article.category == 4}">selected</c:if>>历史军事</option>
                    <option value="5" <c:if test="${article.category == 5}">selected</c:if>>侦探推理</option>
                    <option value="6" <c:if test="${article.category == 6}">selected</c:if>>网游动漫</option>
                    <option value="7" <c:if test="${article.category == 7}">selected</c:if>>科幻小说</option>
                    <option value="8" <c:if test="${article.category == 8}">selected</c:if>>恐怖灵异</option>
                    <option value="9" <c:if test="${article.category == 9}">selected</c:if>>散文诗词</option>
                    <option value="10" <c:if test="${article.category == 10}">selected</c:if>>其他类型</option>
                </select>


            </td>
        </tr>
        <tr>
            <td>作者</td>
            <td>
                <input type="text" id="author" name="author" value="${article.author}" class="tb-rounded"/>
            </td>
        </tr>
        <tr>
            <td>管理员</td>
            <td>
                <input type="text" id="agent" name="agent" value="${article.agent}" class="tb-rounded"/>
            </td>
        </tr>

        <tr>
            <td>小说简介</td>
            <td>
                <textarea rows="5" cols="30" name="intro" class="tb-rounded" id="intro">${article.intro}</textarea>
            </td>
        </tr>
        <tr>
            <td>关键字</td>
            <td>
                <input type="text" id="keywords" name="keywords" value="${article.keywords}" class="tb-rounded"/>
            </td>
        </tr>
        <tr>
            <td>封面图</td>
            <td>
                <input type="file" name="fileData">
            </td>
        </tr>
        <tr>
            <td>文章状态</td>
            <td>

                <input type="radio" name="fullflag"
                       <c:if test="${article.fullflag ==true}">checked</c:if> value="1"/>已完成
                <input type="radio" name="fullflag"
                       <c:if test="${article.fullflag !=true}">checked</c:if> value="0"/>连载中
            </td>
        </tr>
        <tr>
            <td>管理授权${article.authorflag}</td>
            <td>
                <input type="radio" name="authorflag"
                       <c:if test="${article.authorflag ==true }">checked</c:if> value="1"/>授权给该作者
                <input type="radio" name="authorflag"
                       <c:if test="${article.authorflag !=true }">checked</c:if> value="0"/>暂时不予授权
            </td>
        </tr>
        <tr>
            <td>授权级别</td>
            <td>
                <input type="radio" name="permission"
                       <c:if test="${article.permission ==1}">checked</c:if> value="1"/>专属作品
                <input type="radio" name="permission"
                       <c:if test="${article.permission ==2}">checked</c:if> value="2"/>驻站作品
                <input type="radio" name="permission"
                       <c:if test="${article.permission ==3}">checked</c:if> value="3"/>授权作品
                <input type="radio" name="permission"
                       <c:if test="${article.permission ==4}">checked</c:if> value="3"/>暂未授权

            </td>
        </tr>
        <tr>
            <td>首发状态</td>
            <td>
                <input type="radio" name="firstflag"
                       <c:if test="${article.firstflag ==true}">checked</c:if> value="1"/>本站首发
                <input type="radio" name="firstflag"
                       <c:if test="${article.firstflag !=true}">checked</c:if> value="0"/>他站首发
            </td>
        </tr>
        <tr>
            <td>
                发布日期
            </td>
            <td> 格式:yyyy-MM-dd hh:mm 例:2017-01-01 21:28
                <input type="text" name="postdate" class="tb-rounded" id="postdateStr"
                       value="<fmt:formatDate value="${article.postdate}" pattern="yyyy-MM-dd HH:mm" />">
            </td>
        </tr>
        <tr>
            <td colspan="2">SEO设置</td>
        </tr>
        <tr>
            <td>启用独立简介页设置</td>
            <td>
                <input type="radio" name="usecustomizeinfotitle"
                       <c:if test="${article.usecustomizeinfotitle ==true}">checked</c:if> value="1"/>是
                <input type="radio" name="usecustomizeinfotitle"
                       <c:if test="${article.usecustomizeinfotitle !=true}">checked</c:if> value="0"/>否
            </td>
        </tr>
        <tr>
            <td>标题</td>
            <td>
                <input type="text" name="infotitle" value="${article.infotitle}" class="tb-rounded" id="infotitle">
            </td>
        </tr>
        <tr>
            <td>关键字</td>
            <td>
                <input type="text" name="infokeywords" value="${article.infokeywords}" class="tb-rounded"
                       id="infokeywords">
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td>
                <input type="text" name="infodescription" value="${article.infodescription}" class="tb-rounded"
                       id="infodescription">
            </td>
        </tr>
        <tr>
            <td>启用独立列表页设置</td>
            <td>

                <input type="radio" name="usecustomizelisttitle"
                       <c:if test="${article.usecustomizelisttitle ==true}">checked</c:if> value="1"/>是
                <input type="radio" name="usecustomizelisttitle"
                       <c:if test="${article.usecustomizelisttitle !=true}">checked</c:if> value="0"/>否

            </td>
        </tr>
        <tr>
            <td>标题</td>
            <td>
                <input type="text" name="listtitle" value="${article.listtitle}" class="tb-rounded" id="listtitle">
            </td>
        </tr>
        <tr>
            <td>关键字</td>
            <td>
                <input type="text" name="listkeywords" value="${article.listkeywords}" class="tb-rounded"
                       id="listkeywords">
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td>
                <input type="text" name="listdescription" value="${article.listdescription}" class="tb-rounded"
                       id="listdescription">
            </td>
        </tr>

        <tr>
            <td colspan="2">统计信息</td>
        </tr>
        <tr>
            <td>日点击</td>
            <td>
                <input type="text" name="dayvisit" value="${article.dayvisit}" class="tb-rounded" id="dayvisit">
            </td>
        </tr>
        <tr>
            <td>周点击</td>
            <td>
                <input type="text" name="weekvisit" value="${article.weekvisit}" class="tb-rounded" id="weekvisit">
            </td>
        </tr>
        <tr>
            <td>月点击</td>
            <td>
                <input type="text" name="monthvisit" value="${article.monthvisit}" class="tb-rounded"
                       id="monthvisit">
            </td>
        </tr>
        <tr>
            <td>总点击</td>
            <td>
                <input type="text" name="allvisit" value="${article.allvisit}" class="tb-rounded" id="allvisit">
            </td>
        </tr>
        <tr>
            <td>日推荐</td>
            <td>
                <input type="text" name="dayvote" value="${article.dayvote}" class="tb-rounded" id="dayvote">
            </td>
        </tr>
        <tr>
            <td>周推荐</td>
            <td>
                <input type="text" name="weekvote" value="${article.weekvote}" class="tb-rounded" id="weekvote">
            </td>
        </tr>
        <tr>
            <td>月推荐</td>
            <td>
                <input type="text" name="monthvote" value="${article.monthvote}" class="tb-rounded" id="monthvote">
            </td>
        </tr>
        <tr>
            <td>总推荐</td>
            <td>
                <input type="text" name="allvote" value="${article.allvote}" class="tb-rounded" id="allvote">
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center; padding: 2px">
                <input type="button" value="返回" class="submitButton" theme="simple" onclick="history.back()"/>
                <c:choose>
                    <c:when test="${article==null}">
                        <input type="submit" name="submit" value="保存" class="submitButton" theme="simple"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" name="submit" value="修改" class="submitButton" theme="simple"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</div>
<jsp:include page="/WEB-INF/content/admin/commom/footer.jsp"/>
</body>
</html>
