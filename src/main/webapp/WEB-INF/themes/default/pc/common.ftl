<#include "${themeName}/pc/base.ftl"/>
<#macro headerContent>
  <div class="shadow" <#if pageType?? && pageType==4> style="height:1px;" </#if>></div>
  <header id="global-head" <#if pageType?? && pageType==4> style="height:45px;" </#if>>
    <div>
      <nav class="site-navigation cf" style="width: 320px;">
      <a class="home" href="${contextPath}/">首页</a>
      <a href="${contextPath}/info/siteMap">网站地图</a>
      <a href="${contextPath}/info/articleList?fullflag=true">完本小说</a>
      </nav>
<#--      <div class="hd-follow" style="width:630px;text-align:right;" >
        <div class="myhide"><a href="#" class="hides">浏览记录</a>
          <div class="hideInfo">
            <ul id="readhistory">
            </ul>
            <p>*提示：浏览记录仅放置最近浏览的10本书籍</p>
            <span>浏览记录是空的</span>
          </div>
        </div>
          <span id="checklogin">
            <#if enableQQLogin><a href="/gotoQQLogin" rel="nofollow"><img src="${contextPath}/themes/default/pc/images/qq_login.gif" class="vm" alt="QQ登录"></a></#if>
            <a href="${contextPath}/user/loginPage" style="color:#F0F0F0" rel="nofollow">访客登录</a>&nbsp;&nbsp;
            <a href="${contextPath}/user/registerPage" style="color:#F0F0F0" rel="nofollow">免费注册</a>&nbsp;&nbsp;
          </span>
        </div>-->
    </div>
    <!--TODO haserror check-->
    <#if hasError || ( pageType?? && pageType!=4) >
    <p class="site-logo">
        <a href="${contextPath}/" title="淘TO淘小说|免费小说网">
        <img src="${contextPath}/themes/${themeName}/pc/images/logo.png" alt="淘TO淘小说|免费小说网 - logo"></a>
    </p>
    <div class="site-search">
    <form action="${contextPath}/info/search" method="post" >
       <input name="key" type="text" id="key" onFocus="this.classname='over';if (value =='这是一个神奇的搜索，请输入小说名或作者名'){value =''}" onBlur="this.classname='input'"  value="<#if key??>${key?html}<#else>这是一个神奇的搜索，请输入小说名或作者名</#if>" />
       <input type="submit" id="searchbuttom" value="" style="background:url('${contextPath}/themes/${themeName}/pc/images/search.jpg');border:0px solid;cursor:pointer;" />
    </form>
    </div>
    </#if>
  </header>
</#macro>

<#macro naviContent>
  <div id="channel-header" class="clearfix">
    <div class="channel-header-wrapper">
      <nav class="channel-nav">
        <ul class="channel-nav-list">
            <li <#if pageType ?? && pageType==1>class="current"</#if> ><a href="${contextPath}/" title="淘TO淘小说">淘TO淘小说</a></li>

            <li <#if category??><#if 1==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=1">玄幻魔法</a></li>
            <li <#if category??><#if 2==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=2">武侠修真</a></li>
            <li <#if category??><#if 3==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=3">都市言情</a></li>
            <li <#if category??><#if 4==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=4">历史军事</a></li>
            <li <#if category??><#if 5==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=5">侦探推理</a></li>
            <li <#if category??><#if 6==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=6">网游动漫</a></li>
            <li <#if category??><#if 7==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=7">科幻小说</a></li>
            <li <#if category??><#if 8==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=8">恐怖灵异</a></li>
            <li <#if category??><#if 9==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=9">散文诗词</a></li>
            <li <#if category??><#if 10==category?c>class="current"</#if></#if>><a href="${contextPath}/info/articleList?category=10">其他类型</a></li>
            <li <#if pageType ?? && pageType==7>class="current"</#if>><a href="${contextPath}/info/top?sortColumn=lastupdate">排行榜</a></li>
        </ul>
      </nav>
    </div>
  </div>
</#macro>

<#macro footer>

<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b1613c516edd6ba04d9559a355794b2a";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"2","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<div class="clear"></div>
<footer id="global-foot">
    <p>
    本小说站所有小说、评论均为网友更新！仅代表发布者个人行为，与本小说站(www.taototao.com)立场无关！<br/>
    本站所有小说的版权为原作者所有！如无意中侵犯到您的权益，或是含有非法内容，请及时与我们联系，我们将在第一时间做出回应！谢谢！<br/>
        Copyright©2017-2018 taototao.com All Rights Reserved.鲁ICP备14010434号
        <#if pageType?? && pageType==1>
            <br>
            Powered by <a href="http://www.taototao.com">淘TO淘小说小说系统  V1.0.0 Beta</a>
        </#if>
    </p>
</footer>
<#if customizefooter?exists>
    <@customizefooter/>
</#if>
</#macro>