package com.songhaozhi.mayday.annotation;

import java.lang.annotation.*;

/**
 * @Auther: xuyang
 * @Date: 2019/11/24 21:49
 * @Description:
 */
@Documented
@Target(
        {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorityIP {
    String name();
}