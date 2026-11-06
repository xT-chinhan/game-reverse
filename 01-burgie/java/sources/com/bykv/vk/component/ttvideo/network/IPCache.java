package com.bykv.vk.component.ttvideo.network;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class IPCache {
    private static IPCache mInstance;
    private ConcurrentHashMap<String, IpInfo> mIpRecord = new ConcurrentHashMap<>();
    private static int mNetType = -1;
    private static String mNetExtraInfo = null;

    static class IpInfo {
        public int count;
        public String ipaddr;
        public long iptime;
        public boolean needUpdate;

        IpInfo() {
        }
    }

    public static IPCache getInstance() {
        if (mInstance == null) {
            synchronized (IPCache.class) {
                if (mInstance == null) {
                    mInstance = new IPCache();
                }
            }
        }
        return mInstance;
    }

    private IPCache() {
    }

    public IpInfo get(String str) {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public void put(String str, IpInfo ipInfo) {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, ipInfo);
        }
    }

    public int getRecordSize() {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            return concurrentHashMap.size();
        }
        return -1;
    }

    public void disableIpAddress(String str) {
        if (str == null) {
            return;
        }
        IpInfo ipInfo = null;
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            ipInfo = concurrentHashMap.get(str);
        }
        if (ipInfo != null) {
            ipInfo.needUpdate = true;
        }
    }

    public void clear() {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public int getCurNetType() {
        return mNetType;
    }

    public void setCurNetType(int i) {
        mNetType = i;
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public void setCurNetExtraInfo(String str) {
        mNetExtraInfo = str;
    }
}
