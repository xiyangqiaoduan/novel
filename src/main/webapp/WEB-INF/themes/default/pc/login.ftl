<#include "${themeName}/pc/common.ftl"/>

<#macro titleContent>  
<title>用户登录|淘TO淘小说</title>
<meta name="keywords" content="淘TO淘小说网,就爱读书网,免费小说网,无弹出广告小说网,手打小说网"/>
<meta name="description" content="淘TO淘小说网是国内最大的小说网站之一。提供玄幻小说,言情小说,网游小说,修真小说,都市小说,武侠小说,网络小说等在线阅读,我们是更新最快,免费最多,页面简洁且无弹出广告的小说网站!" />
</#macro>  

<#macro content>
    <form action="${contextPath}/user/login" method="post" validate="true">
    <center>
        <span id="ErrorList">${errorMsg}</span>
    </center>
    <table class="grid" align="center" width="400">
      <caption>
        登陆淘TO淘小说
      </caption>
      <tbody>
        <tr>
          <td sytle="text-align: right; padding-left: 20px;" class="odd userN" width="25%">用&nbsp;&nbsp;户&nbsp;&nbsp;名:</td>
          <td class="even">
                <input name="loginid" id = "loginid" style="width:150px; height:20px;" maxlength="32"/>
          </td>
        </tr>
        <tr>
          <td class="odd psd" width="25%">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
          <td class="even">
            <input  name="password" id="password" style="width:150px; height:20px;" maxlength="32" type="password"/>
          </td>
        </tr>
        <tr>
          <td width="25%"></td>
          <td class="even">
            <input type="checkbox" name="useCookie" fieldValue="true" theme="simple"  value="true" />下次自动登录
          </td>
        </tr>
        <tr>
          <td class="odd" width="25%">&nbsp;
          </td>
          <td class="even">
              <input type="submit" method="login" class="submit" name="submit" theme="simple" style="cursor:pointer;" value=" 提 交 "/>
              <span class="pl10">没有账号？<a href="${contextPath}/user/registerPage">注册一个吧!</a></span>
          </td>
        </tr>
      </tbody>
    </table>
</form>
</#macro>