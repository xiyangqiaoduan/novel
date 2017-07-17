<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/content/admin/commom/header.jsp"/>
<div>

    <c:if test="${not empty msg}">
       <span style="font-family:  Arial, Helvetica, sans-serif;color: #ff0000;margin-left: 30px;">${msg}</span>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/admin/configEdit/save">
        <table class="grid" align="center" cellspacing="1" width="800">
            <caption>参数设置</caption>
            <tbody>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">网站域名</td>
                <td class="even"><input name="uri" value="${uri}" size="40" maxlength="100" class="text"
                                        theme="simple"/></td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">手机网站域名</td>
                <td class="even">
                    <input name="mobileUri" value="${mobileUri}" size="40" maxlength="100" class="text" theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">章节文件保存路径</td>
                <td class="even">
                    <input name="filePath" value="${filePath}" size="40" maxlength="100" class="text"
                           theme="simple"/><span class="hottext">填写绝对路径</span>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">图片文件保存路径</td>
                <td class="even">
                    <input name="relativeIamgePath" value="${relativeIamgePath}" size="25" maxlength="100" class="text"
                           theme="simple"/><span class="hottext">请填写相对路径</span>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">模版</td>
                <td class="even">
                    <input name="themeName" value="${themeName}" size="25" maxlength="100" class="text" theme="simple"/>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">每页表示件数</td>
                <td class="even">
                    <input name="countPerPage" value="${countPerPage}" size="25" maxlength="20" class="text"/>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">最大收藏书</td>
                <td class="even">
                    <input name="maxBookcase" value="${maxBookcase}" size="25" maxlength="20" class="text"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">txt文件编码</td>
                <td class="even">
                    <input name="txtEncoding" value="${txtEncoding}" size="25" maxlength="20" class="text"/>
                </td>
            </tr>

            </tbody>
        </table>
        <br/>
        <table class="grid" align="center" cellspacing="1" width="800">
            <caption>功能控制</caption>
            <tbody>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否启用伪静态</td>
                <td class="even">
                    <input name="cleanUrl" type="radio" value="1"
                           <c:if test="${cleanUrl ==true}">checked</c:if> /> 启用
                    <input name="cleanUrl" type="radio" value="0"
                           <c:if test="${cleanUrl ==false}">checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否启用图片URL优化</td>
                <td class="even">
                    <input name="enableCleanImageUrl" type="radio" value="1"
                           <c:if test="${enableCleanImageUrl == true}">checked</c:if> /> 启用
                    <input name="enableCleanImageUrl" type="radio" value="0"
                           <c:if test="${enableCleanImageUrl == false}">checked</c:if> /> 禁用

                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否启用拼音URL</td>
                <td class="even">
                    <input name="enablePinyinUrl" type="radio" value="1"  <c:if
                            test="${enablePinyinUrl == true}"> checked</c:if> /> 启用
                    <input name="enablePinyinUrl" type="radio" value="0"
                           <c:if test="${enablePinyinUrl == false}">checked</c:if>  /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否启用广告</td>
                <td class="even">
                    <input name="adEffective" type="radio" value="1"  <c:if
                            test="${adEffective == true}"> checked</c:if> /> 启用
                    <input name="adEffective" type="radio" value="0"
                           <c:if test="${adEffective == false}">checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否启用页面压缩</td>
                <td class="even">
                    <input name="compressEffective" type="radio" value="1"  <c:if
                            test="${compressEffective == true}"> checked</c:if> /> 启用
                    <input name="compressEffective" type="radio" value="0" <c:if
                            test="${compressEffective == false}"> checked</c:if>  /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">未登录发表评论</td>
                <td class="even">
                    <input name="addReviewWithoutLogin" type="radio" value="1"  <c:if
                            test="${addReviewWithoutLogin == true}"> checked</c:if> /> 启用
                    <input name="addReviewWithoutLogin" type="radio" value="0" <c:if
                            test="${addReviewWithoutLogin == false}"> checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否开启手机页面</td>
                <td class="even">
                    <input name="enableMobileSite" type="radio" value="1"  <c:if
                            test="${enableMobileSite == true}"> checked</c:if> /> 启用
                    <input name="enableMobileSite" type="radio" value="0" <c:if
                            test="${enableMobileSite == false}"> checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">通过域名跳转</td>
                <td class="even">
                    <input name="judgmobilesitebydomian" type="radio" value="1" <c:if
                            test="${judgmobilesitebydomian == true}"> checked</c:if> /> 启用
                    <input name="judgmobilesitebydomian" type="radio" value="0" <c:if
                            test="${judgmobilesitebydomian == false}"> checked</c:if> /> 禁用
                    &nbsp;&nbsp;<span class="hottext">否的话通过手机来判断</span>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">手机站点域名</td>
                <td class="even">
                    <input name="mobilesitedomian" value="${mobilesitedomian}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否开启伪原创</td>
                <td class="even">
                    <input name="enablePseudo" type="radio" value="1"  <c:if
                            test="${enablePseudo == true}"> checked</c:if> /> 启用
                    <input name="enablePseudo" type="radio" value="0"  <c:if
                            test="${enablePseudo == false}"> checked</c:if>  /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否开启QQ登录</td>
                <td class="even">
                    <input name="enableQQLogin" type="radio" value="1" <c:if
                            test="${enableQQLogin == true}"> checked</c:if> /> 启用
                    <input name="enableQQLogin" type="radio" value="0"  <c:if
                            test="${enableQQLogin == false}"> checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">APP ID</td>
                <td class="even">
                    <input name="qqAppId" size="25" maxlength="100" value="${qqAppId}" class="text" theme="simple"/>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">APP KEY</td>
                <td class="even">
                    <input name="qqAppKey" value="${qqAppKey}" size="25" maxlength="100" class="text" theme="simple"/>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否开启独立小说章节页</td>
                <td class="even">
                    <input name="enableChapterIndexPage" type="radio" value="1"  <c:if
                            test="${enableChapterIndexPage == true}"> checked</c:if>  /> 启用
                    <input name="enableChapterIndexPage" type="radio" value="0"  <c:if
                            test="${enableChapterIndexPage == false}"> checked</c:if>  /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否开启触发式静态</td>
                <td class="even">
                    <input name="enableGenerateHtmlFile" type="radio" value="1"  <c:if
                            test="${enableGenerateHtmlFile == true}"> checked</c:if>  /> 启用
                    <input name="enableGenerateHtmlFile" type="radio" value="0"  <c:if
                            test="${enableGenerateHtmlFile == false}"> checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否开启注册邮箱验证</td>
                <td class="even">
                    <input name="enableMailAuth" type="radio" value="1"  <c:if
                            test="${enableMailAuth == true}"> checked</c:if>  /> 启用
                    <input name="enableMailAuth" type="radio" value="0"  <c:if
                            test="${enableMailAuth == false}"> checked</c:if>  /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">邮件服务器是否需要验证</td>
                <td class="even">
                    <input name="mailSmtpAuth" type="radio" value="1" <c:if
                            test="${mailSmtpAuth == true}"> checked</c:if>  /> 启用
                    <input name="mailSmtpAuth" type="radio" value="0" <c:if
                            test="${mailSmtpAuth == false}"> checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否启用TLS</td>
                <td class="even">
                    <input name="mailSmtpStarttlsEnable" type="radio" value="1"  <c:if
                            test="${mailSmtpStarttlsEnable == true}"> checked</c:if> /> 启用
                    <input name="mailSmtpStarttlsEnable" type="radio" value="0" <c:if
                            test="${mailSmtpStarttlsEnable == false}"> checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">邮箱服务器地址</td>
                <td class="even">
                    <input name="mailSmtpHost" value="${mailSmtpHost}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">端口</td>
                <td class="even">
                    <input name="mailSmtpPort" value="${mailSmtpPort}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">邮箱帐号</td>
                <td class="even">
                    <input name="mailSmtpUsername" value="${mailSmtpPort}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">邮箱密码</td>
                <td class="even">
                    <input name="mailSmtpPassword" value="${mailSmtpPassword}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">发送邮箱地址</td>
                <td class="even">
                    <input name="mailSmtpFrom" value="${mailSmtpFrom}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">最大收藏件数</td>
                <td class="even">
                    <input name="maxSubscribe" value="${maxSubscribe}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">检查期间(单位：分)</td>
                <td class="even">
                    <input name="sendSubscribeInteval" value="${sendSubscribeInteval}" size="25" maxlength="100"
                           class="text" theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否启用全站单本（泛解析）</td>
                <td class="even">
                    <input name="enableSingleBook" type="radio" value="1"  <c:if
                            test="${enableSingleBook == true}"> checked</c:if> /> 启用
                    <input name="enableSingleBook" type="radio" value="0"  <c:if
                            test="${enableSingleBook == false}"> checked</c:if> /> 禁用
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">网站根域名</td>
                <td class="even">
                    <input name="rootDomain" value="${rootDomain}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">不包含的子域名(逗号分割)</td>
                <td class="even">
                    <input name="excludeSubDomain" value="${excludeSubDomain}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">重新加载小说间隔(单位：分)</td>
                <td class="even">
                    <input name="reloadSingleBookInterval" value="${reloadSingleBookInterval}" size="25" maxlength="100"
                           class="text" theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否生成网站地图</td>
                <td class="even">
                    <input name="createSiteMap" type="radio" value="1" <c:if
                            test="${createSiteMap == true}"> checked</c:if>  /> 启用
                    <input name="createSiteMap" type="radio" value="0"  <c:if
                            test="${createSiteMap == false}"> checked</c:if> /> 禁用
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">网站地图类型</td>
                <td class="even">
                    <input name="siteMapType" value="${siteMapType}" size="25" maxlength="100" class="text"
                           theme="simple"/><span class="hottext">支持html和xml格式</span></td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">列表页地址(不含页号)</td>
                <td class="even">
                    <input name="xmlSiteMapListWithNoPageURL" value="${xmlSiteMapListWithNoPageURL}" size="25"
                           maxlength="100" class="text" theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">列表页地址</td>
                <td class="even">
                    <input name="xmlSiteMapListURL" value="${xmlSiteMapListURL}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">简介页地址</td>
                <td class="even">
                    <input name="xmlSiteMapInfoURL" value="${xmlSiteMapInfoURL}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">小说列表页地址</td>
                <td class="even">
                    <input name="xmlSiteMapChaterListURL" value="${xmlSiteMapChaterListURL}" size="25" maxlength="100"
                           class="text" theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">阅读页地址</td>
                <td class="even">
                    <input name="xmlSiteMapReaderURL" value="${xmlSiteMapReaderURL}" size="25" maxlength="100"
                           class="text" theme="simple"/>
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否生成结构化数据</td>
                <td class="even">
                    <input name="createStructuringData" type="radio" value="1" <c:if
                            test="${createStructuringData == true}"> checked</c:if>  /> 启用
                    <input name="createStructuringData" type="radio" value="0"  <c:if
                            test="${createStructuringData == false}"> checked</c:if> /> 禁用
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">过滤关键字</td>
                <td class="even">
                    <input name="filterKeyWord" value="${filterKeyWord}" size="25" maxlength="100" class="text"
                           theme="simple"/>
                </td>
            </tr>
            </tbody>
        </table>
        <br/>
        <table class="grid" align="center" cellspacing="1" width="800">
            <caption>性能相关设置</caption>
            <tbody>
            <tr align="left" valign="middle">
                <td class="odd" width="30%">性能相关设置</td>
                <td class="even">
                    <input name="cacheEffective" type="radio" value="1" <c:if
                            test="${cacheEffective == true}"> checked</c:if> /> 启用
                    <input name="cacheEffective" type="radio" value="0" <c:if
                            test="${cacheEffective == false}"> checked</c:if> /> 禁用

                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否启用GZIP压缩</td>
                <td class="even">
                    <input name="gzipEffective" type="radio" value="1" <c:if
                            test="${gzipEffective == true}"> checked</c:if> /> 启用
                    <input name="gzipEffective" type="radio" value="0"  <c:if
                            test="${gzipEffective == false}"> checked</c:if> /> 禁用
                    &nbsp;&nbsp;<span class="hottext">压缩输出有利于提高浏览速度</span>
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否生成静态首页</td>
                <td class="even">
                    <input name="createIndexPage" type="radio" value="1" <c:if
                            test="${createIndexPage == true}"> checked</c:if> /> 启用
                    <input name="createIndexPage" type="radio" value="0" <c:if
                            test="${createIndexPage == false}"> checked</c:if> /> 禁用
                </td>
            </tr>

            <tr align="left" valign="middle">
                <td class="odd" width="30%">是否缓存小说件数</td>
                <td class="even">
                    <input name="enableCacheArticleCount" type="radio" value="1"  <c:if
                            test="${enableCacheArticleCount == true}"> checked</c:if>/> 启用
                    <input name="enableCacheArticleCount" type="radio" value="0"  <c:if
                            test="${enableCacheArticleCount == false}"> checked</c:if> /> 禁用
                </td>
            </tr>
            <tr align="left" valign="middle">
                <td class="odd" colspan="2">
                    <input type="submit" value="保存" class="submitButton" theme="simple"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<jsp:include page="/WEB-INF/content/admin/commom/footer.jsp"/>
</body>
</html>
