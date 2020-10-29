package com.mycompany.sport.resources;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import static com.mycompany.sport.resources.DatasourceProducer.JNDI_NAME;


/**
 *
 * @author mikael
 */
@Singleton
@DataSourceDefinition(
    name = JNDI_NAME,
    className = "org.postgresql.xa.PGXADataSource",
    url = "jdbc:postgresql://localhost:5432/postgres")
public class DatasourceProducer {
    public static final String JNDI_NAME =  "java:app/jdbc/postgres";

    @Resource(lookup=JNDI_NAME)
    DataSource ds;

    @Produces
    public DataSource getDatasource() {
        return ds;
    }
}
