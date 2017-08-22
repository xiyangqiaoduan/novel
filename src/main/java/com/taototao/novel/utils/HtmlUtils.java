package com.taototao.novel.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-08-10 18:01
 **/
public class HtmlUtils {


    public static String removeScript(String content) {
        String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(content);
        return content = m_script.replaceAll(""); // 过滤script标签
    }


    public static void main(String[] args){

        String htmlStr="<div>aaaa</div>";
        String regex="<div[^>]*?>[\\\\s\\\\S]*?<\\\\/div>";
        Pattern p_script = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签
        System.out.println(htmlStr);

    }

}
