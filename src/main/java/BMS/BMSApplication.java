package BMS;

import BMS.core.controller.BookResource;
import BMS.core.entities.BookEntity;
import BMS.core.repository.BookDAO;
import BMS.core.service.impl.BookService;
import com.mysql.cj.xdevapi.SessionFactory;
import io.dropwizard.Application;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;

public class BMSApplication extends Application<BMSConfiguration> {

    private static final String SQL = "sql";

    public static void main(final String[] args) throws Exception {
        new BMSApplication().run(args);
    }

    @Override
    public String getName() {
        return "BMS";
    }

    private final HibernateBundle<BMSConfiguration> hibernate = new HibernateBundle<BMSConfiguration>(BookEntity.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(BMSConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(final Bootstrap<BMSConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider()); // for picking config from resource
        bootstrap.addBundle((ConfiguredBundle<? super BMSConfiguration>) hibernate);
    }

    @Override
    public void run(final BMSConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
//        final JdbiFactory factory = new JdbiFactory();
//        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final BookDAO dao = new BookDAO((SessionFactory) hibernate.getSessionFactory());
        environment.jersey().register(new BookResource(dao));
    }

}
