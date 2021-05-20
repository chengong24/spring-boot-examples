package com.neo.aop.custom;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author: Chen Gong
 * @date：2021/5/20 11:32 上午
 */
public class LogAnnotationAdvisor implements BeanFactoryAware, Advisor {

    private Advice advice;

    public LogAnnotationAdvisor() {

        this.advice = new LogAnnotationInterceptor();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {


    }

    @Override
    public Advice getAdvice() {


        return this.advice;
    }

    @Override
    public boolean isPerInstance() {
        // TODO Auto-generated method stub
        return false;
    }

}
