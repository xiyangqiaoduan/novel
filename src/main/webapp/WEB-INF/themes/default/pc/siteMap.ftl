<#include "${themeName}/pc/common.ftl"/>
<#macro titleContent>  
<title>网站地图|淘TO淘小说网</title>
<meta name="keywords" content="完本小说,淘TO淘小说网,就爱读书网,免费小说网,无弹出广告小说网,手打小说网"/>
<meta name="description" content="淘TO淘小说网是国内最大的小说网站之一。提供玄幻小说,言情小说,网游小说,修真小说,都市小说,武侠小说,网络小说等在线阅读,我们是更新最快,免费最多,页面简洁且无弹出广告的小说网站!" />
</#macro>  
<#macro content> 
   <p class="b-all-switch normal">网站地图:</p>
    <div class="mainLink">
        <#list articleList as article><a class="poptext" href="${contextPath}/${article.url}" title="${article.articlename}最新章节" class="f14">${article.articlename}</a></#list>
    </div>
</#macro>

