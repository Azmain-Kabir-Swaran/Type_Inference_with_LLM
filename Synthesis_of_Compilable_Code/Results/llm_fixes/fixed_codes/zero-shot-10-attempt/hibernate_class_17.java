import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.shards.ShardId;
import org.hibernate.shards.loadbalance.RoundRobinShardLoadBalancer;
import org.hibernate.shards.strategy.ShardStrategy;
import org.hibernate.shards.strategy.ShardStrategyFactory;
import org.hibernate.shards.strategy.access.SequentialShardAccessStrategy;
import org.hibernate.shards.strategy.resolution.AllShardsShardResolutionStrategy;
import org.hibernate.shards.strategy.selection.RoundRobinShardSelectionStrategy;

import org.hibernate.shards.util.ShardConfiguration;
import org.hibernate.shards.util.ShardedConfiguration;

import java.util.ArrayList;
import java.util.List;

public class hibernate_class_17 {
    public class SessionFactoryImpl {

        private static final String SHARD_CFG_0 = "/com/hibshards/config/shard0.hibernate.cfg.xml";
        private static final String SHARD_CFG_1 = "/com/hibshards/config/shard1.hibernate.cfg.xml";
        private static final String SHARDED_TABLE = "com/hibshards/orm/weather.hbm.xml";

        public SessionFactory createSessionFactory() {
            Configuration prototypeConfig = new Configuration().configure(SHARD_CFG_0);
            prototypeConfig.addResource(SHARDED_TABLE);

            List<org.hibernate.shards.util.ShardConfiguration> shardConfigs = new ArrayList<>();
            shardConfigs.add(buildShardConfig(SHARD_CFG_0));
            shardConfigs.add(buildShardConfig(SHARD_CFG_1));

            ShardStrategyFactory shardStrategyFactory = buildShardStrategyFactory();
            org.hibernate.shards.util.ShardedConfiguration shardedConfig = new org.hibernate.shards.util.ShardedConfiguration(
                    prototypeConfig,
                    shardConfigs,
                    shardStrategyFactory);
            return shardedConfig.buildShardedSessionFactory();
        }

        private ShardStrategyFactory buildShardStrategyFactory() {

            ShardStrategyFactory shardStrategyFactory = new ShardStrategyFactory() {
                public ShardStrategy newShardStrategy(List<ShardId> shardIds) {
                    RoundRobinShardLoadBalancer loadBalancer = new RoundRobinShardLoadBalancer(shardIds);
                    RoundRobinShardSelectionStrategy pss = new RoundRobinShardSelectionStrategy(loadBalancer);
                    AllShardsShardResolutionStrategy prs = new AllShardsShardResolutionStrategy(shardIds);
                    SequentialShardAccessStrategy pas = new SequentialShardAccessStrategy();
                    return new ShardStrategy(pss, prs, pas);
                }
            };
            return shardStrategyFactory;
        }

        private org.hibernate.shards.util.ShardConfiguration buildShardConfig(String configFile) {
            Configuration config = new Configuration().configure(configFile);
            return new org.hibernate.shards.util.ShardConfiguration(config);
        }
    }
}