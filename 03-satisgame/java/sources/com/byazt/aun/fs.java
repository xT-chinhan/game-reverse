package com.byazt.aun;

import android.text.TextUtils;
import com.byazt.nf.rv;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 898, 101})
public class fs {
    public static fs n;
    public final Map<String, com.byazt.gdj.fs> qg = new ConcurrentHashMap();

    private fs() {
    }

    public static fs n() {
        if (n == null) {
            synchronized (fs.class) {
                if (n == null) {
                    n = new fs();
                }
            }
        }
        return n;
    }

    private static String qg(String str, int i) {
        return str + "_" + i;
    }

    public void n(String str, List<com.byazt.gdj.fs> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        for (com.byazt.gdj.fs fsVar : list) {
            if (fsVar != null && !TextUtils.isEmpty(fsVar.n())) {
                this.qg.put(qg(fsVar.n(), fsVar.qg()), fsVar);
            }
        }
    }

    public com.byazt.gdj.fs n(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, com.byazt.gdj.fs> map = this.qg;
        if (map == null || map.size() == 0) {
            rv.qg().ma();
        }
        return this.qg.get(qg(str, i));
    }
}
