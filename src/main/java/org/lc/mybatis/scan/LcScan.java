package org.lc.mybatis.scan;

import org.lc.mybatis.register.LcImportRegister;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(LcImportRegister.class)
public @interface LcScan {
    String value() default "";
}
