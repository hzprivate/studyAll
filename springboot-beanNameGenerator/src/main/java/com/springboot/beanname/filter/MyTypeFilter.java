package com.springboot.beanname.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * ComponentScan 扫描 指定过滤规则
 * @author hz
 * @create 2020-04-13
 */
public class MyTypeFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        // 检测名字包含 com.springboot.beanname.bean.bean1 的bean
        if(className.contains("com.springboot.beanname.bean.bean1")){
            return true;
        }
        return false;
    }
}
