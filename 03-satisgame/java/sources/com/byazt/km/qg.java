package com.byazt.km;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 26})
public class qg implements com.byazt.wv.q {
    public static volatile qg n;
    public final CopyOnWriteArraySet<com.byazt.wv.q> qg = new CopyOnWriteArraySet<>();

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    private qg() {
    }

    @Override // com.byazt.wv.q
    public void n(String str, String str2, String str3) {
        Iterator<com.byazt.wv.q> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().n(str, str2, str3);
        }
    }

    @Override // com.byazt.wv.q
    public void n(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<com.byazt.wv.q> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().n(z, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.byazt.wv.q
    public void n(boolean z, JSONObject jSONObject) {
        Iterator<com.byazt.wv.q> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().n(z, jSONObject);
        }
    }

    @Override // com.byazt.wv.q
    public void qg(boolean z, JSONObject jSONObject) {
        Iterator<com.byazt.wv.q> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().qg(z, jSONObject);
        }
    }
}
