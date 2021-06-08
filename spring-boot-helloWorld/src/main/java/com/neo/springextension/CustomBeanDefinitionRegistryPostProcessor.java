//package com.neo.springextension;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.core.type.filter.AnnotationTypeFilter;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
///**
// * @author: Chen Gong
// * @date：2021/5/28 3:38 下午
// */
//@Component
//public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {
//
//    private ApplicationContext applicationContext;
//
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//
//    }
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    public static class ComponentScanner extends ClassPathBeanDefinitionScanner {
//        public ComponentScanner(BeanDefinitionRegistry registry) {
//            super(registry, false);
//            addIncludeFilter(new AnnotationTypeFilter(TrantorComponent.class));
//        }
//
//        public void scan(ResourceLoader resourceLoader) {
//            setResourceLoader(resourceLoader);
//            BeanDefinitionRegistry registry = getRegistry();
//            if (registry == null) {
//                return;
//            }
//            Set<String> packages = BasePackageUtils.findBasePackages(registry);
//            scan(packages.toArray(new String[]{}));
//        }
//    }
//}
