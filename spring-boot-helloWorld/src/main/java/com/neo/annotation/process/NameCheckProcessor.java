//package com.neo.annotation.process;
//
//import javax.annotation.processing.ProcessingEnvironment;
//import javax.annotation.processing.RoundEnvironment;
//import javax.annotation.processing.SupportedAnnotationTypes;
//import javax.annotation.processing.SupportedSourceVersion;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.TypeElement;
//
///**
// * @author: Chen Gong
// * @date：2021/5/25 9:09 上午
// */
//@SupportedAnnotationTypes("*")
//@SupportedSourceVersion(SourceVersion.RELEASE_8)
//public class NameCheckProcessor extends AbstractProcessor {
//
//    private NameChecker nameChecker;
//
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnv) {
//        super.init(processingEnv);
//        nameChecker = new NameChecker(processingEnv);
//    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        if (!roundEnv.processingOver()) {
//            for (Element element : roundEnv.getRootElements()) {
//                nameChecker.checkNames(element);
//            }
//        }
//        return false;
//    }
//}
