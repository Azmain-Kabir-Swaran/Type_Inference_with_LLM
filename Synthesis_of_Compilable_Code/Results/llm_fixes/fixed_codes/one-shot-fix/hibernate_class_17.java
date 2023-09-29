import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.shards.ShardId;
import org.hibernate.shards.ShardedConfiguration;
import org.hibernate.shards.strategy.ShardStrategy;
import org.hibernate.shards.strategy.ShardStrategyFactory;
import org.hibernate.shards.strategy.loadbalance.RoundRobinShardLoadBalancer;
import org.hibernate.shards.strategy.resolution.AllShardsShardResolutionStrategy;
import org.hibernate.shards.strategy.access.SequentialShardAccessStrategy;
import org.hibernate.shards.strategy.selection.RoundRobinShardSelectionStrategy;

public class hibernate_class_17 {
    public class SessionFactoryImpl {

        private static final String SHARD_CFG_0 = "/com/hibshards/config/shard0.hibernate.cfg.xml";
        private static final String SHARD_CFG_1 = "/com/hibshards/config/shard1.hibernate.cfg.xml";
        private static final String SHARDED_TABLE = "com/hibshards/orm/weather.hbm.xml";

        public org.hibernate.SessionFactory createSessionFactory() throws javax.naming.NamingException {
            Configuration prototypeConfig = new Configuration().configure( SHARD_CFG_0 );
            prototypeConfig.addResource( SHARDED_TABLE );

            List<org.hibernate.shards.ShardConfiguration> shardConfigs = new ArrayList<org.hibernate.shards.ShardConfiguration>();
            shardConfigs.add( buildShardConfig( SHARD_CFG_0 ) );
            shardConfigs.add( buildShardConfig( SHARD_CFG_1 ) );

            ShardStrategyFactory shardStrategyFactory = buildShardStrategyFactory();
            ShardedConfiguration shardedConfig = new ShardedConfiguration(
                    prototypeConfig,
                    shardConfigs,
                    shardStrategyFactory);
            return shardedConfig.buildShardedSessionFactory();
        }

        private ShardStrategyFactory buildShardStrategyFactory() {

            ShardStrategyFactory shardStrategyFactory = new ShardStrategyFactory() {
                public ShardStrategy newShardStrategy1(List<ShardId> shardIds) {
                    RoundRobinShardLoadBalancer loadBalancer = new RoundRobinShardLoadBalancer( shardIds );
                    org.hibernate.shards.strategy.ShardSelectionStrategy pss = new RoundRobinShardSelectionStrategy( loadBalancer );
                    org.hibernate.shards.strategy.ShardResolutionStrategy prs = new AllShardsShardResolutionStrategy( shardIds );
                    org.hibernate.shards.strategy.ShardAccessStrategy pas = new SequentialShardAccessStrategy();
                    return new ShardStrategyImpl( pss, prs, pas );
                }

                @Override
                public ShardStrategy newShardStrategy(List<ShardId> arg0) {
                    // TODO Auto-generated method stub
                    return null;
                }
            };
            return shardStrategyFactory;
        }

        private org.hibernate.shards.ShardConfiguration buildShardConfig( String configFile ) {
            Configuration config = new Configuration().configure( configFile );
            return new ConfigurationToShardConfigurationAdapter( config );
        }
    }
}