package com.lixinyan.thirdlib.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * Created by administrator on 2016/6/5.
 *
 */
public class Lock {
    private String path;
    private ZooKeeper zooKeeper;
    private String ip;

    /**
     * 初始化构造，
     * @param path 建立节点的path
     */
    public Lock(String path, String ip) {
        this.path = path;
        this.ip = ip;
    }

    public synchronized void lock() throws Exception {
        Stat stat = zooKeeper.exists(path, true);
        if (stat != null) {
            byte[] data = zooKeeper.getData(path, null, stat);
            String dataStr = new String(data);
            while (!data.equals("unlock")) {
                data = zooKeeper.getData(path, null, stat);
                dataStr = new String(data);
            }
            if (dataStr.equals("unlock")) {
                dataStr = this.ip + ":lock";
                zooKeeper.setData(path, dataStr.getBytes(), -1);
            }
        }
    }

    public synchronized void unlock() throws Exception {
        Stat stat = zooKeeper.exists(path, true);
        String data = "unlock";
        zooKeeper.setData(path, data.getBytes(), -1);
    }

    public synchronized boolean isLock() {
        try {
            Stat stat = zooKeeper.exists(path, true);
            String data = ip + ":lock";
            String nodeData = new String(zooKeeper.getData(path, true, stat));
            if (data.equals(nodeData)) {
                return true;
            }
        } catch (KeeperException e) {
            e.getStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

}
