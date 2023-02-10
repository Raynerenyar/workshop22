package sg.edu.nus.iss.workshop22.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MySqlConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {

        String url;
        url = env.getProperty("MYSQL_URL");
        if (!(env.getProperty("MYSQLDATABASE").isEmpty())) {
            url = "jdbc:" + env.getProperty("MYSQL_URL");
        }

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.password(env.getProperty("MYSQLPASSWORD"));
        dataSourceBuilder.username(env.getProperty("MYSQLUSER"));

        return dataSourceBuilder.build();

    }

}
