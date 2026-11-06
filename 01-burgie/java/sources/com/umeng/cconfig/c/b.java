package com.umeng.cconfig.c;

import android.text.TextUtils;
import com.umeng.cconfig.UMRemoteConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    private String a;
    private String b;

    public b(String str, JSONArray jSONArray) {
        this.a = str;
        this.b = jSONArray.toString();
    }

    public b(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject.toString();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a A[Catch: all -> 0x003c, Exception -> 0x003e, TryCatch #2 {Exception -> 0x003e, blocks: (B:2:0x0000, B:10:0x0024, B:12:0x002a, B:14:0x0034, B:6:0x0017), top: B:20:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0034 A[Catch: all -> 0x003c, Exception -> 0x003e, TRY_LEAVE, TryCatch #2 {Exception -> 0x003e, blocks: (B:2:0x0000, B:10:0x0024, B:12:0x002a, B:14:0x0034, B:6:0x0017), top: B:20:0x0000 }] */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        try {
            String strA = a.a(this.a, this.b);
            int i = -1;
            if (!this.a.contains("https://ucc.umeng.com/v1/fetch")) {
                if (this.a.contains("https://pslog.umeng.com/ablog")) {
                    i = 2;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(strA)) {
                    UMRemoteConfig.getInstance().handlerMessage(i, str, this.b);
                } else {
                    UMRemoteConfig.getInstance().handlerMessage(i, str, null);
                }
            }
            i = 1;
            str = strA;
            if (TextUtils.isEmpty(strA)) {
                UMRemoteConfig.getInstance().handlerMessage(i, str, this.b);
            } else {
                UMRemoteConfig.getInstance().handlerMessage(i, str, null);
            }
        } catch (Exception e) {
        }
    }
}
