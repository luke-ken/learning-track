package com.sideproject.learningtrack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class IndexedAnnotationConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "learnprogress_db";
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
