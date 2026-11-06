package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import com.taptap.sdk.db.constant.Common;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public a a;
    public String b;
    public String g;
    public String c = "";
    public String d = "";
    public String e = "";
    public int h = Integer.MIN_VALUE;
    public String f = com.bykv.vk.component.ttvideo.utils.b.a(null);

    c(a aVar, Context context) {
        this.a = aVar;
    }

    public void a() {
        b();
    }

    public void a(String str) {
        this.b = str;
        this.f = com.bykv.vk.component.ttvideo.utils.b.b(str);
    }

    public void b() {
        Map mapVersionInfo;
        a aVar = this.a;
        if (aVar == null || (mapVersionInfo = aVar.versionInfo()) == null) {
            return;
        }
        this.c = (String) mapVersionInfo.get("pc");
        this.d = (String) mapVersionInfo.get(Common.Predefined.SUB_SV);
        this.e = (String) mapVersionInfo.get("sdk_version");
    }

    public void b(String str) {
    }
}
