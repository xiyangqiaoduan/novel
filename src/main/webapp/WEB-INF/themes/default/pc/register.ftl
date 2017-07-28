<#include "${themeName}/pc/common.ftl"/>

<#macro titleContent>  
<title>用户注册|淘TO淘小说</title>
<meta name="keywords" content="淘TO淘小说网,就爱读书网,免费小说网,无弹出广告小说网,手打小说网"/>
<meta name="description" content="淘TO淘小说网是国内最大的小说网站之一。提供玄幻小说,言情小说,网游小说,修真小说,都市小说,武侠小说,网络小说等在线阅读,我们是更新最快,免费最多,页面简洁且无弹出广告的小说网站!" />
</#macro>  

<#macro content>

<form action="register" validate="true" method="post" onsubmit="$('#register_submit').css('cursor','wait');">
<script type="text/javascript" src="${contextPath}/themes/${themeName}/pc/js/formcommon.js"></script>
    <center>
        <span id="ErrorList">${errMsg}</span>
    </center>
    <table class="grid" align="center" width="500">
      <caption>
     新用户注册
      </caption>
      <tbody>
         <tr>
          <td class="odd userN" width="25%">用&nbsp;&nbsp;户&nbsp;&nbsp;名:</td>
          <td class="even">
              <input name="loginid" id = "loginid" style="160px;"  class="text username"  size="25" maxlength="32"/>
          </td>
        </tr>
        <tr>
          <td class="odd psd" width="25%">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
          <td class="even">
              <input name="password" type="password" id = "password" style="160px;"  class="text password"  size="25" maxlength="32"/>
          </td>
        </tr>
        <tr>
          <td class="odd again" width="25%">再次输入：</td>
          <td class="even">
              <input name="repassword"  type="password" id = "repassword" style="160px;"  class="text password"  size="25" maxlength="32"/>
          </td>
        </tr>
        <tr>
          <td class="odd emails" width="25%">电子邮箱：</td>
          <td class="even">
              <input name="email" id = "email" style="160px;"  class="text"  size="25" maxlength="60"/>
          </td>
        </tr>
        <tr>
          <td class="odd" width="25%">QQ：</td>
          <td class="even">
              <input name="qq" id = "qq" style="160px;"  class="text"  size="25" maxlength="15"/>
          </td>
        </tr>
        <tr>
          <td class="odd" width="25%">&nbsp;
          <td class="even">
              <input  type="submit" method="register"  class="submit" name="submit" theme="simple" style="cursor:pointer;"  value=" 提 交 "/>
          </td>
        </tr>
      </tbody>
    </table>
    <s:hidden name="backUrl"/>
</form>
</#macro>