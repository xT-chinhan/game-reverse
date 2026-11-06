package com.bykv.vk.component.ttvideo.mediakit.net;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLDNSManager {
    private static AVMDLDNSManager mInstance = null;
    public static Map<Integer, CreateConstructor> dnsMap = null;

    private AVMDLDNSManager() throws Exception {
        dnsMap = new HashMap();
        initDnsMap();
    }

    public synchronized void registerDnsConstructor(int i, CreateConstructor createConstructor) {
        try {
            dnsMap.put(Integer.valueOf(i), createConstructor);
        } catch (Exception e) {
        }
    }

    public synchronized CreateConstructor getCreateConstructor(int i) throws Exception {
        if (dnsMap.containsKey(Integer.valueOf(i))) {
            return dnsMap.get(Integer.valueOf(i));
        }
        return null;
    }

    private void initDnsMap() throws Exception {
        DefaultConstructor defaultConstructor = new DefaultConstructor();
        dnsMap.put(1, defaultConstructor);
        dnsMap.put(2, defaultConstructor);
        dnsMap.put(3, defaultConstructor);
    }

    public static AVMDLDNSManager getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDNSManager.class) {
                if (mInstance == null) {
                    try {
                        mInstance = new AVMDLDNSManager();
                    } catch (Exception e) {
                        mInstance = null;
                    }
                }
            }
        }
        return mInstance;
    }
}
