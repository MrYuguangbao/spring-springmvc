package com.annotation.importanno;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.importanno
 * @author:admin
 * @createTime 9月 18 2021 23:32:10
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.annotation.importanno.Blue", "com.annotation.importanno.Orange"};
    }
}
