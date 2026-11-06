package com.byazt.so;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 427, 19})
public class n {
    public ConcurrentHashMap<String, Object> n = new ConcurrentHashMap<>();

    public void n(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.n.put(str, str2);
    }

    public String n(String str) {
        return qg(str, "");
    }

    private String qg(String str, String str2) {
        return (str == null || !this.n.containsKey(str)) ? str2 : (String) this.n.get(str);
    }

    public void n(String str, int i) {
        if (str != null) {
            this.n.put(str, Integer.valueOf(i));
        }
    }

    public int qg(String str) {
        return qg(str, 0);
    }

    private int qg(String str, int i) {
        return (str == null || !this.n.containsKey(str)) ? i : ((Integer) this.n.get(str)).intValue();
    }
}
