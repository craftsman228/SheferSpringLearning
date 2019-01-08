package com.begin.chapter5.Introductions;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified{

    private Boolean isModified = false;
    private Map<Method, Method> methodCache = new HashMap<>();


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (!isModified){
           if ((mi.getMethod().getName().startsWith("set")) && (mi.getArguments().length == 1)) {
                Method getter = getGetter(mi.getMethod());
                if (getter != null){
                    Object newVal = mi.getArguments()[0];
                    Object oldVal = getter.invoke(mi.getThis(), null);
                    if ((newVal == null) && (oldVal == null)){
                         isModified = false;
                    }else if ((newVal == null) && (oldVal != null)){
                        isModified = true;
                    }else if((newVal != null) && (oldVal == null)){
                        isModified = true;
                    }else {
                        isModified = (!newVal.equals(oldVal));
                    }
                }
            }
        }
        return super.invoke(mi);
    }

    private Method getGetter(Method setter) {
        Method getter = null;
        getter = methodCache.get(setter);
        if (getter != null){
            return getter;
        }
        String getterName = setter.getName().replaceFirst("set", "get");
        try{
            getter.getDeclaringClass().getMethod(getterName, null);
            synchronized (methodCache){
                methodCache.put(setter, getter);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return getter;
    }

    @Override
    public boolean isModified() {
        return isModified;
    }
}
