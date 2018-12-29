package com.begin.chapter4.JSR330

import com.begin.chapter4.GroovyConfiguration.Contact
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

def ctx = new GenericApplicationContext()
def reader = new GroovyBeanDefinitionReader(ctx)

reader.beans {
    contact(Contact, firstName: 'lapa', lastName: 'pushistovna', age: 7)
}

ctx.refresh()
println ctx.getBean("contact")