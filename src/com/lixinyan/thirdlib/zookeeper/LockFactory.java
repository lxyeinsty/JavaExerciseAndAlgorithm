package com.lixinyan.thirdlib.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.net.UnknownHostException;
import java.util.Collections;

/**
 * Created by administrator on 2016/6/5.
 *
 */
public class LockFactory {

    public static ZooKeeper DEFAULT_ZOOKEEPER = null;

    /**
     * 初始化分布式锁
     * @param path，锁节点路径
     * @param connectStr，zookeeper连接地址
     * @param ip，ip地址，标识本机锁
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     * @throws UnknownHostException
     */
    public static synchronized Lock initLock(String path, String connectStr, String ip)
            throws KeeperException, InterruptedException, UnknownHostException {
        DEFAULT_ZOOKEEPER = getDefaultZookeeper(connectStr);

        if (DEFAULT_ZOOKEEPER != null) {
            Stat stat = DEFAULT_ZOOKEEPER.exists(path, true);
            if (stat == null) {
                createZnode(path, ip);
            }
            Lock lock = new Lock(path, ip);
            lock.setZooKeeper(DEFAULT_ZOOKEEPER);
            return lock;
        }

        return null;
    }

    private static ZooKeeper getDefaultZookeeper(String connectStr) {
        try{
            ZooKeeper zooKeeper = new ZooKeeper(connectStr, 10 * 1000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {}
            });
            return zooKeeper;
        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;
    }

    private static void createZnode(String path, String ip) throws UnknownHostException,
            KeeperException, InterruptedException {
        if (DEFAULT_ZOOKEEPER != null) {
            String data = "unlock";
            DEFAULT_ZOOKEEPER.create(path, data.getBytes(),
                    Collections.singletonList(new ACL(ZooDefs.Perms.ALL, ZooDefs.Ids.ANYONE_ID_UNSAFE)),
                    CreateMode.EPHEMERAL);
        }
    }
}
