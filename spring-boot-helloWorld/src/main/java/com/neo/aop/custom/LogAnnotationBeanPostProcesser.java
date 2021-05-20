package com.neo.aop.custom;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author: Chen Gong
 * @date：2021/5/20 11:31 上午
 */
@Service
public class LogAnnotationBeanPostProcesser extends AbstractBeanFactoryAwareAdvisingPostProcessor {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        super.setBeanFactory(beanFactory);
        LogAnnotationAdvisor advisor = new LogAnnotationAdvisor();
        advisor.setBeanFactory(beanFactory);
        this.advisor = advisor;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        for (Method method : methods) {
            if (method.isAnnotationPresent(Log.class)) {
                ProxyFactory proxyFactory = prepareProxyFactory(bean, beanName);
                if (!proxyFactory.isProxyTargetClass()) {
                    evaluateProxyInterfaces(bean.getClass(), proxyFactory);
                }
                proxyFactory.addAdvisor(this.advisor);
                customizeProxyFactory(proxyFactory);
                return proxyFactory.getProxy(getProxyClassLoader());
            }
        }
        return bean;

    }

}

