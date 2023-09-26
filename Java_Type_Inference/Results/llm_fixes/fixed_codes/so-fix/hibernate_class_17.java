import org.hibernate.shards.ShardId;
import org.hibernate.shards.ShardStrategy;
import org.hibernate.shards.ShardStrategyFactory;
import org.hibernate.shards.strategy.ShardedConfiguration;
import org.hibernate.shards.strategy.access.SequentialShardAccessStrategy;
import org.hibernate.shards.strategy.resolution.AllShardsShardResolutionStrategy;
import org.hibernate.shards.strategy.selection.RoundRobinShardSelectionStrategy;

import org.hibernate.cfg.Configuration;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

public class hibernate_class_17 {
    public class SessionFactoryImpl {

        private static final String SHARD_CFG_0 = "/com/hibshards/config/shard0.hibernate.cfg.xml";
        private static final String SHARD_CFG_1 = "/com/hibshards/config/shard1.hibernate.cfg.xml";
        private static final String SHARDED_TABLE = "com/hibshards/orm/weather.hbm.xml";

        public SessionFactory createSessionFactory() throws NamingException {
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
                public ShardStrategy newShardStrategy(List<ShardId> shardIds) {
                    org.hibernate.shards.strategy.selection.RoundRobinShardLoadBalancer loadBalancer = new org.hibernate.shards.strategy.selection.RoundRobinShardLoadBalancer( shardIds );
                    RoundRobinShardSelectionStrategy pss = new RoundRobinShardSelectionStrategy( loadBalancer );
                    AllShardsShardResolutionStrategy prs = new AllShardsShardResolutionStrategy( shardIds );
                    SequentialShardAccessStrategy pas = new SequentialShardAccessStrategy();
                    return new org.hibernate.shards.ShardStrategyImpl( pss, prs, pas );
                }
            };
            return shardStrategyFactory;
        }

        private org.hibernate.shards.ShardConfiguration buildShardConfig( String configFile ) {
            Configuration config = new Configuration().configure( configFile );
            return new org.hibernate.shards.ConfigurationToShardConfigurationAdapter( config );
        }
    }
}