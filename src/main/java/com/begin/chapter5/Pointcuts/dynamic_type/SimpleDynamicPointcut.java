package com.begin.chapter5.Pointcuts.dynamic_type;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass == SimpleBean.class;
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("Dynamic check for: " + method.getName());
        int x = ((Integer)objects[0]).intValue();
        return x != 100;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static checking for: " + method.getName());
        return ("foo".equals(method.getName()));
    }
}
