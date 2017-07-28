<#include "${themeName}/pc/common.ftl"/>

<#macro assignContent> 
    <#assign topnamemap = topNameJsonData?eval>
</#macro>

<#macro titleContent>  
<title>排行榜|淘TO淘小说网</title>
<meta name="keywords" content="淘TO淘小说网,就爱读书网,免费小说网,无弹出广告小说网,手打小说网" />
<meta name="description" content="淘TO淘小说网是国内最大的小说网站之一。提供玄幻小说,言情小说,网游小说,修真小说,都市小说,武侠小说,网络小说等在线阅读,我们是更新最快,免费最多,页面简洁且无弹出广告的小说网站!" />
</#macro>

<#macro content>
    <div id="top_ad_01"></div>
    <div class="topLefft">
        <h1>排行榜</h1>
        <ul>
            <#list topnamemap?keys as topkey>
                <li <#if sortColumn??><#if topkey==sortColumn>class="select"</#if></#if>><a href="${contextPath}/info/top?sortColumn=${topkey}")}">${topnamemap[topkey]}</a></li>
            </#list>
        </ul>
    </div>
    <div class="topRight">
        <h1 class="allClick"><span>${topnamemap[sortColumn]}</span></h1>
        <ul class="seeWell cf">
        <#list articleList as article>
        <#if article_index lt 3>
            <li><a class="l mr10" title="${article.articlename}" href="${contextPath}/${article.url}" target="_blank">
            <img style="width: 120px; height: 150px" src="${contextPath}${article.imgUrl}" alt="${article.articlename}"></a>
            <#if article.fullflag ><img src="${contextPath}/themes/${themeName}/pc/images/only.png"  alt="完本图标" class="topss png_bg"><#else><img src="${contextPath}/themes/${themeName}/pc/images/only2.png"  alt="连载中图标" class="topss png_bg"></#if>
            <span class="l"><a class="clearfix stitle" href="${contextPath}/${article.url}">
            <em <#if article_index ==0 >class="first"</#if>>${article_index + 1}</em>${article.articlename}</a>
            类型：<a href="${contextPath}/info/articleList?category=${article.category}&page=1"><#if article.category!=0>${article.categoryStr}</#if></a><br/>
            作者：<a href="${contextPath}/info/articleList?author=${article.author}">${article.author}</a>
            <br>点击数：<label>${article.allvisit}</label>
            <a class="readTo" href="<#if !enableChapterIndexPage >${contextPath}/${article.url}<#else>${contextPath}/${article.chapterListUrl}</#if>">马上阅读</a></span></li>
        </#if>
        </#list>
        </ul>
        <div class="allList">
        <#list articleList as article>
        <#if article_index gt 2 >
          <dl><dt><em>${article_index + 1}</em>[
          <a href="${contextPath}/info/articleList?category=${article.category}&page=1"> <#if article.category!=0>${article.categoryStr}</#if></a>]</dt>
          <dd class="title"><a href="${contextPath}/${article.url}">${article.articlename}</a></dd>
          <dd class="state">最新章节：<a href="${contextPath}/${article.lastChapterUrl}"><#if article.lastchapter?? >${article.lastchapter}</#if></a>&nbsp;&nbsp;[${article.lastupdate?string("yyyy-MM-dd HH:mm")}]</dd>
          <dd class="authors">作者：<a href="${contextPath}/info/articleList?author=${article.author}">${article.author}</a></dd></dl>
        </#if>
        </#list>
        <div id="top_ad_02"></div>
        <div class="mainnav" id="navList">
        <div class="pages">
              <div class="pagelink" id="pagelink">
                <#assign listurl = "${contextPath}/info/top?sortColumn=${sortColumn}&page=">
                <#assign listurlforjs = "${contextPath}/info/top/${sortColumn}/" >
                <em id="pagestats">${pagination.pageNumber}/${pagination.totalPages?c}</em>
                <a href="${listurl}1" class="first">首页</a>
                <#list pagination.pageNumberList as pagenum >
                    <#if pagenum_index == 0 && (pagenum > 1 )>
                        <a href="${listurl}${((pagenum-1)?c)}" class="prev">&lt;</a>
                    </#if>
                    <#if pagenum == pagination.pageNumber>
                        <strong>${pagenum?c}</strong>
                    <#else>
                        <a href="${listurl}${(pagenum?c)}"> ${pagenum?c} </a>
                    </#if>
                    <#assign mxpagenum = pagenum >
                </#list>
                <#if mxpagenum?? && (mxpagenum < pagination.totalPages)>
                     <a href="${listurl}${((mxpagenum+1)?c)}" class="next">&gt;</a>
                </#if>
                <a href="${listurl}${(pagination.totalPages?c)}">尾页</a>
 <#--               <kbd>
                    <input name="page" type="text" size="4" maxlength="6" onkeydown="if(event.keyCode==13){window.location='${listurlforjs}'+this.value+'.html'; return false;}" /></kbd>-->
             </div>
        </div>
        </div>
        </div>
    </div>
    <div id="top_ad_03"></div>
</div>
</#macro>
