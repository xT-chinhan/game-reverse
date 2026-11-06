package com.uyumao;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UYMInnerManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;

    public b(Context context) {
        this.a = context;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x004e  */
    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        try {
            String strB = e.b(new File(this.a.getCacheDir() + File.separator + "net_change"));
            if (TextUtils.isEmpty(strB)) {
                jSONArray = null;
            } else {
                String[] strArrSplit = strB.split("\n");
                if (strArrSplit.length > 0) {
                    jSONArray = new JSONArray();
                    for (String str : strArrSplit) {
                        jSONArray.put(new JSONObject(str));
                    }
                } else {
                    jSONArray = null;
                }
            }
            Context context = this.a;
            if (j.a == null && context != null) {
                j.a = context.getApplicationContext();
            }
            c.a(this.a, c.a(this.a, j.a.a.a(), jSONArray), jSONArray != null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
