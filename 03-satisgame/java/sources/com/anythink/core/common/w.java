package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.common.h.cc;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class w {
    private static final String b = "w";
    Map<String, cc> a;

    public w() {
        if (this.a == null) {
            this.a = new ConcurrentHashMap(5);
        }
    }

    private void a() {
        if (this.a == null) {
            this.a = new ConcurrentHashMap(5);
        }
    }

    public final void a(String str, String str2, cc.a aVar, cc.a aVar2) {
        Map<String, cc> map = this.a;
        if (map == null) {
            return;
        }
        cc ccVar = map.get(str);
        if (ccVar == null) {
            synchronized (this) {
                ccVar = this.a.get(str);
                if (ccVar == null) {
                    ccVar = new cc();
                    ccVar.a(str2);
                    this.a.put(str, ccVar);
                }
            }
        }
        if (TextUtils.equals(str2, ccVar.b())) {
            if (aVar != null) {
                ccVar.a(aVar);
                ccVar.a(System.currentTimeMillis());
            }
            if (aVar2 != null) {
                ccVar.b(aVar2);
            }
        }
    }

    private cc a(String str) {
        Map<String, cc> map = this.a;
        if (map != null) {
            return map.remove(str);
        }
        return null;
    }
}
