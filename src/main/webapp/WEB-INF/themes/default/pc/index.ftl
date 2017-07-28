<#include "${themeName}/pc/common.ftl"/>

<#macro titleContent>  
<title>淘TO淘小说|免费小说网</title>
<meta name="keywords" content="淘TO淘小说,免费小说网,无弹出广告小说网"/>
<meta name="description" content="淘TO淘小说网是国内最大的小说网站之一。提供玄幻小说\,言情小说\,网游小说\,修真小说\,都市小说\,武侠小说\,网络小说等在线阅读\,我们是更新最快\,免费最多\,页面简洁且无弹出广告的小说网站!" />
</#macro>  

<#macro recommendblock articleList id style> 
<ul class="seeWell cf" id="${id}" style="${style}">
    <#list articleList as article>
    <li>
       <a href="${article.url}"  title="${article.articlename}" class="l mr10">
           <img src="${contextPath}${article.imgUrl}" style="width: 120px; height: 150px" alt="${article.articlename}"/></a>
       <#if article.fullflag ><img src="${contextPath}/themes/${themeName}/pc/images/only.png" alt="完本图标" class="topss png_bg"><#else><img src="${contextPath}/themes/${themeName}/pc/images/only2.png" class="topss png_bg" alt="连载中图标"></#if>
       <span class="l">
          <a href="${article.url}"  title="${article.articlename}" class="clearfix stitle">${article.articlename}</a>
          作者：<a href="${contextPath}/info/articleList?author=${article.author}">${article.author}</a>
          <em class="c999 clearfix">${article.introForHtml}</em>
          更新：<a href="${article.lastChapterUrl}"  title="${article.lastchapter}">${article.lastchapterOmit}</a>
          <a href="<#if !enableChapterIndexPage >${article.url}<#else>${article.chapterListUrl}</#if>" class="readTo"  title="${article.articlename}">马上阅读</a>
       </span>
    </li>
    </#list>
</ul>
</#macro>

<#macro lastupdateblock articleList> 
<section class="box" id="news">
    <h2>刚刚更新的：</h2>
    <ol>
        <#list articleList as article>
            <li>
                <em class="r">${article.lastupdate?string("yyyy-MM-dd HH:mm")}</em>
                <a href="/articleList?category=${article.category}&page=1" title = "${article.categoryStr} ">[&nbsp;${article.categoryStr}&nbsp;]</a>
                <a class="poptext" href="${article.url}"
                    title="${article.articlename}最新章节" class="f14">${article.articlename}</a>
                <a class="poptext" href="${article.lastChapterUrl}" ><#if article.lastchapter?? >${article.lastchapter}</#if></a>
                作者：<a class="poptext" href="${contextPath}/info/articleList?author=${article.author}" title="${article.author}的小说" class="f14">${article.author}</a>
            </li>
        </#list>
    </ol>
</section>
</#macro>

<#macro lastinsertblock articleList> 
<section class="box" id="sorts">
    <h2>最新入库小说：</h2>
    <ol>
        <#list articleList as article>
        <li class="top3">
            <span class="order">${article_index+1}</span>
            <span class="chapter"><a href="/articleList?category=${article.category}" title="${article.categoryStr}>" target="_blank">[${article.categoryStr}]</a></span>
            <a target="_blank" href="${article.url}" title="${article.articlename}最新章节">${article.articlename}</a> 
            <span class="chapter"><a href="${article.lastChapterUrl}" title="${article.lastchapter}">${article.lastchapter}</a></span>
        </li>
        </#list>
    </ol>
</section>
</#macro>


<#macro content>
   <div id="index_ad_01"></div>
   <p class="b-all-switch normal">好看的:
      <a href="javascript:;" class="select" id="ask1" onMouseOver="repales_rell(1,5)">都市言情</a>
      <a href="javascript:;" id="ask2" onMouseOver="repales_rell(2,5)">玄幻魔法</a>
      <a href="javascript:;" id="ask3" onMouseOver="repales_rell(3,5)">历史军事</a>
      <a href="javascript:;" id="ask4" onMouseOver="repales_rell(4,5)">恐怖灵异</a>
      <a href="javascript:;" id="ask5" onMouseOver="repales_rell(5,5)">武侠修真</a>
   </p>

    <#if recommendblock?exists>
          <@recommendblock articleList=blocks.index_yanqing_tuijian id="cttd1" style=""/>
    </#if>
    <#if recommendblock?exists>
          <@recommendblock articleList=blocks.index_xuanhuan_tuijian id="cttd2" style="display:none;"/>
    </#if>
    <#if recommendblock?exists>
          <@recommendblock articleList=blocks.index_junshi_tuijian id="cttd3" style="display:none;"/>
    </#if>
    <#if recommendblock?exists>
          <@recommendblock articleList=blocks.index_kongbu_tuijian id="cttd4" style="display:none;"/>
    </#if>
    <#if recommendblock?exists>
          <@recommendblock articleList=blocks.index_wuxia_tuijian id="cttd5" style="display:none;"/>
    </#if>
    <div id="index_ad_02"></div>
    <div class="clear"></div>
    <div id="J_random_board" class="random-board cf board">
        <#if lastupdateblock?exists>
          <@lastupdateblock articleList=blocks.last_update_list/>
        </#if>
        <#if lastinsertblock?exists>
          <@lastinsertblock articleList=blocks.last_insert_list/>
        </#if>
    </div> 
    <div id="index_ad_03"></div>
    <div class="clear"></div>
    <p class="b-all-switch normal">友情链接:</p>
    <div class="mainLink">
    <a href="http://www.baidu.com">百度</a>
    </div>
</#macro>
