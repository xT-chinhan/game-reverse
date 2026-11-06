package com.bytedance.embedapplog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sk implements ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile sk f523ms;
    private final CopyOnWriteArraySet<ah> xr = new CopyOnWriteArraySet<>();

    public static sk ms() {
        if (f523ms == null) {
            synchronized (sk.class) {
                if (f523ms == null) {
                    f523ms = new sk();
                }
            }
        }
        return f523ms;
    }

    private sk() {
    }

    @Override // com.bytedance.embedapplog.ah
    public void ms(String str, String str2, String str3) {
        Iterator<ah> it = this.xr.iterator();
        while (it.hasNext()) {
            it.next().ms(str, str2, str3);
        }
    }

    @Override // com.bytedance.embedapplog.ah
    public void ms(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<ah> it = this.xr.iterator();
        while (it.hasNext()) {
            it.next().ms(z, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.bytedance.embedapplog.ah
    public void ms(boolean z, JSONObject jSONObject) {
        Iterator<ah> it = this.xr.iterator();
        while (it.hasNext()) {
            it.next().ms(z, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.ah
    public void xr(boolean z, JSONObject jSONObject) {
        Iterator<ah> it = this.xr.iterator();
        while (it.hasNext()) {
            it.next().xr(z, jSONObject);
        }
    }
}
