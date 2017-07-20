package com.taototao.novel.controller.base;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-14 12:58
 **/
public abstract class AbstractAdminBaseController extends  AbstractBaseController{

    /**
     * 命名空间。
     */
    public static final String NAMESPACE = "/admin";

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                try {
                    if (value != null) {
                       // setValue(new Date(Long.valueOf(value)));
                        setValue(sdf.parse(value));
                    }
                } catch (Exception e) {
                    setValue(null);
                }
            }
        });

        binder.registerCustomEditor(int.class,new PropertyEditorSupport(){
            @Override
            public void setAsText(String value) throws IllegalArgumentException {
                try {
                    if (value != null) {
                        setValue(Integer.parseInt(value));
                    }
                } catch (Exception e) {
                    setValue(0);
                }
            }
        });

    }



}
