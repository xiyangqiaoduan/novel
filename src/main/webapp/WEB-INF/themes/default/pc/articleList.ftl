<#include "${themeName}/pc/common.ftl"/>

<#macro titleContent>  
<#if category?? && category!=0 >
<title>${categoryStr}小说|淘TO淘小说网</title>
<meta name="keywords" content="${categoryStr},${categoryStr}小说,淘TO淘小说网,就爱读书网,免费小说网,无弹出广告小说网,手打小说网" />
<#elseif author?? >
<title>${author?html}的小说|淘TO淘小说网</title>
<meta name="keywords" content="${author?html}的小说,淘TO淘小说网,就爱读书网,免费小说网,无弹出广告小说网,手打小说网" />
<meta name="description" content="淘TO淘小说网是国内最大的小说网站之一。提供玄幻小说,言情小说,网游小说,修真小说,都市小说,武侠小说,网络小说等在线阅读,我们是更新最快,免费最多,页面简洁且无弹出广告的小说网站!" />
<#elseif tag?? >
<title>标签：${tag?html}的小说|淘TO淘小说网</title>
<meta name="keywords" content="标签：${tag?html}的小说,淘TO淘小说网,就爱读书网,免费小说网,无弹出广告小说网,手打小说网" />
<meta name="description" content="淘TO淘小说网是国内最大的小说网站之一。提供玄幻小说,言情小说,网游小说,修真小说,都市小说,武侠小说,网络小说等在线阅读,我们是更新最快,免费最多,页面简洁且无弹出广告的小说网站!" />
<#else>
<title>完本小说|淘TO淘小说网</title>
<meta name="keywords" content="完本小说,淘TO淘小说网,就爱读书网,免费小说网,无弹出广告小说网,手打小说网" />
<meta name="description" content="淘TO淘小说网是国内最大的小说网站之一。提供玄幻小说,言情小说,网游小说,修真小说,都市小说,武侠小说,网络小说等在线阅读,我们是更新最快,免费最多,页面简洁且无弹出广告的小说网站!" />
</#if>
</#macro>


<#macro content>
<div id="list_ad_01"></div>
<div class="mainnav" id="navList">
<div class="main-index">位置：  &nbsp; > &nbsp; <a href="#"><#if fullflag ?? && fullflag>全本小说<#elseif category ?? && category!=0>${categoryStr}<#elseif tag ??>标签：${tag?html}的小说<#elseif author??>${author?html}的小说<#else>小说列表页</#if></a></div>
    <section class="section board-list board-list-collapse">
    <ul class="seeWell cf">
        <#list articleList as article>
        <li>
           <a href="${contextPath}/${article.url}"  title="${article.articlename}" class="l mr10">
                <img src="${contextPath}/${article.imgUrl}" style="width: 120px; height: 150px"/></a>
           <#if article.fullflag ><img src="${contextPath}/themes/${themeName}/pc/images/only.png"  alt="完本图标" class="topss png_bg"><#else><img src="${contextPath}/themes/${themeName}/pc/images/only2.png"  alt="连载中图标" class="topss png_bg"></#if>
           <span class="l">
              <a href="${contextPath}/${article.url}"  title="${article.articlename}" class="clearfix stitle">${article.articlename}</a>
              作者：<a href="${contextPath}/info/articleList?author=${article.author}")}">${article.author}</a>
              <em class="c999 clearfix">${article.introForHtml}</em>
              更新：<a href="${contextPath}/${article.lastChapterUrl}"  title="${article.lastchapter}">${article.lastchapterOmit}</a>
              <a href="<#if !enableChapterIndexPage >${contextPath}/${article.url}<#else>${contextPath}/${article.chapterListUrl}</#if>" class="readTo"  title="${article.articlename}">马上阅读</a>
           </span>
        </li>
        </#list>
    </ul>

    <div id="list_ad_02"></div>
          <div class="pages">
              <div class="pagelink" id="pagelink">
                <#if fullflag?? && fullflag>
                    <#assign listurl = "${contextPath}/info/articleList?fullflag=true&page=" >
                    <#assign listurlforjs = "${contextPath}/wanben/" >
                <#elseif category?? && category !=0 >
                    <#assign listurl = "${contextPath}/info/articleList?category=${category}&page=">
                    <#assign listurlforjs = "${contextPath}/list/${category}/" >
                <#elseif author??>
                    <#assign listurl = "${contextPath}/info/articleList?author=${author?html}&page=">
                    <#assign listurlforjs = "${contextPath}/list/${author?html}/" >
                <#elseif tag??>
                    <#assign listurl = "${contextPath}/info/articleList?tag=${tag?html}&page=">
                    <#assign listurlforjs = "${contextPath}/list/${tag?html}/" >
                <#else>
                    <#assign listurl = "${contextPath}/info/articleList?page=">
                    <#assign listurlforjs = "${contextPath}/list/" >
                </#if>
                <em id="pagestats">${pagination.pageNumber?c}/${pagination.totalPages?c}</em>
                <a href="${listurl}1" class="first">首页</a>
                <#list pagination.pageNumberList as pagenum >
                    <#if pagenum_index == 0 && (pagenum > 1 )>
                        <a href="${listurl}${((pagenum-1)?c)}" class="prev">&lt;</a>
                    </#if>
                    <#if pagenum == pagination.pageNumber>
                        <strong>${pagenum?c}</strong>
                    <#else>
                        <a href="${listurl}${((pagenum)?c)}"> ${pagenum?c} </a>
                    </#if>
                    <#assign mxpagenum = pagenum >
                </#list>
                <#if mxpagenum?? && (mxpagenum < pagination.totalPages)>
                     <a href="${listurl}${((mxpagenum+1)?c)}" class="next">&gt;</a>
                </#if>
                <a href="${listurl}${(pagination.totalPages?c)}">尾页</a>
               <#-- <kbd>
                    <input name="page" type="text" size="4" maxlength="6" onkeydown="if(event.keyCode==13){window.location='${listurlforjs}'+this.value+'.html'; return false;}" /></kbd>-->
             </div>
        </div>
    </section>
  </div>
  <div id="list_ad_03"></div>
  </div>
</#macro>
