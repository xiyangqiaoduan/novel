<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp"/>

<div>
<form action=
      <c:choose>

        <c:when test="${user==null}">
              "${pageContext.request.contextPath}/admin/user/add"
        </c:when>
        <c:otherwise>
                "${pageContext.request.contextPath}/admin/user/edit"
        </c:otherwise>
      </c:choose>
    method="post" validate="true">
<input type="hidden" name="userno" value="${user.userno}"/>
<br>
<table class="yidu-table" align="center">
    <colgroup>
        <col width="120px">
        <col width="442px">
    </colgroup>
    <tbody>
    <tr>
        <th colspan="2">用户添加编辑</th>
    </tr>
    <c:if test="${user!=null}">
        <tr>
            <td>用户编号</td>
            <td>
                    ${user.userno}
            </td>
        </tr>
    </c:if>
    <tr>
        <td>登录ID</td>
        <td>
            <input type="text" name="loginid" id="loginid" value="${user.loginid}" class="tb-rounded"/>
        </td>
    </tr>
    <tr>
        <td>密码</td>
        <td>
            <input type="password" name="password" value="${user.password}" id="password" class="tb-rounded"/>
        </td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td>
            <input type="text" name="email" id="email" value="${user.email}" class="tb-rounded"/>
        </td>
    </tr>
    <tr>
        <td>性别</td>
        <td>
            <input type="radio" name="sex" value="1" <c:if test="${user.sex!=2}">checked</c:if>/> 男
            <input type="radio" name="sex" value="2" <c:if test="${user.sex==2}">checked</c:if>/> 女
        </td>
    </tr>
    <tr>
        <td>种别</td>
        <td>
            <select id="type" name="type">
                <option value="10">普通用户</option>
                <option value="20">作家</option>
                <option value="25">VIP</option>
                <option value="30">管理员</option>
                <option value="40">大分类编辑</option>
                <option value="41">小分类编辑</option>
            </select>

        </td>
    </tr>
    <tr>
        <td>QQ</td>
        <td>
            <input type="text" name="qq" id="qq" value="${user.qq}" class="tb-rounded"/>
        </td>
    </tr>
    <tr>
        <td>LineNo</td>
        <td>
            <input type="text" name="lineno" id="lineno" value="${user.lineno}" class="tb-rounded"/>
        </td>
    </tr>
    <tr>
        <td>真实姓名</td>
        <td>
            <input type="text" name="realname" id="realname" value="${user.realname}" maxlength="10"
                   class="tb-rounded"/>
        </td>
    </tr>
    <tr>
        <td>笔名</td>
        <td>
            <input type="text" name="username" id="username" value="${user.username}" class="tb-rounded"/>
        </td>
    </tr>
    <tr>
        <td>身份证号</td>
        <td>
            <input type="text" name="id" id="id" value="${user.id}" class="tb-rounded" maxlength="18"/>
        </td>
    </tr>
    <tr>
        <td>手机号</td>
        <td>
            <input type="text" name="mobileno" id="mobileno" value="${user.mobileno}" class="tb-rounded"
                   maxlength="11"/>
        </td>
    </tr>
    <tr>
        <td>开户银行</td>
        <td>
            <input type="text" name="branch" id="rounded" value="${user.branch}" class="tb-rounded" maxlength="50"/>
        </td>
    </tr>
    <tr>
        <td>银行帐号</td>
        <td>
            <input type="text" name="bankno" id="bankno" value="${user.bankno}" class="tb-rounded" maxlength="50"/>
        </td>
    </tr>
    <tr>
        <td>支付宝帐号</td>
        <td>
            <input type="text" name="alipayacount" id="alipayacount" value="${user.bankno}" class="tb-rounded"
                   maxlength="50"/>
        </td>
    </tr>
    <c:if test="${user!=null}">
        <tr>
            <td>注册时间</td>
            <td>
                <fmt:formatDate value="${user.regdate}" pattern="yyyy-MM-dd HH:mm"/>
            </td>
        </tr>
        <tr>
            <td>最后登录时间</td>
            <td>
                <fmt:formatDate value="${user.lastlogin}" pattern="yyyy-MM-dd HH:mm"/>
            </td>
        </tr>
    </c:if>
    <tr>
        <td colspan="2" style="text-align: center; padding: 2px">
            <input type="button" name="submit" value="返回" method="back" class="submitButton" theme="simple"
                   onclick="history.back();"/>

            <c:choose>
                <c:when test="${user==null}">
                    <input type="submit" name="submit" value="保存" method="save" class="submitButton" theme="simple"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" name="submit" value="更新" method="save" class="submitButton" theme="simple"/>
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
