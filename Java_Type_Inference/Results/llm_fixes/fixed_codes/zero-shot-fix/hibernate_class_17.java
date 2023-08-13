import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.naming.NamingException;

public class hibernate_class_17 {

    public static void main(String[] args) throws NamingException {
        SessionFactoryImpl sessionFactoryImpl = new SessionFactoryImpl();
        sessionFactoryImpl.createSessionFactory();
    }

    public static class SessionFactoryImpl {

        private static final String SHARD_CFG_0 = "/com/hibshards/config/shard0.hibernate.cfg.xml";
        private static final String SHARD_CFG_1 = "/com/hibshards/config/shard1.hibernate.cfg.xml";
        private static final String SHARDED_TABLE = "com/hibshards/orm/weather.hbm.xml";

        public SessionFactory createSessionFactory() throws NamingException {
            Configuration prototypeConfig = new Configuration().configure(SHARD_CFG_0);
            prototypeConfig.addResource(SHARDED_TABLE);

            List<ShardConfiguration> shardConfigs = new ArrayList<ShardConfiguration>();
            shardConfigs.add(buildShardConfig(SHARD_CFG_0));
            shardConfigs.add(buildShardConfig(SHARD_CFG_1));

            ShardStrategyFactory shardStrategyFactory = buildShardStrategyFactory();
            ShardedConfiguration shardedConfig = new ShardedConfiguration(prototypeConfig, shardConfigs, shardStrategyFactory);
            return shardedConfig.buildShardedSessionFactory();
        }

        private ShardConfiguration buildShardConfig(String configFile) {
            Configuration config = new Configuration().configure(configFile);
            return new ConfigurationToShardConfigurationAdapter(config);
        }

        private interface ShardConfiguration {
        }

        private interface ShardId {
        }

        private interface ShardStrategy {
        }

        private interface ShardSelectionStrategy {
        }

        private interface ShardResolutionStrategy {
        }

        private interface ShardAccessStrategy {
        }

        private class RoundRobinShardSelectionStrategy implements ShardSelectionStrategy {
            public RoundRobinShardSelectionStrategy(RoundRobinShardLoadBalancer loadBalancer) {
            }
        }

        private class RoundRobinShardLoadBalancer {
            public RoundRobinShardLoadBalancer(List<ShardId> shardIds) {
            }
        }
    }
}