package com.mcto.sspsdk.internal;

import android.content.pm.PackageInfo;
import android.os.Message;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {
    public final /* synthetic */ c1 a;

    public x0(c1 c1Var) {
        this.a = c1Var;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, java.util.List] */
    public final void a(String str, String str2) {
        if (!"android.intent.action.PACKAGE_ADDED".equals(str2)) {
            if ("android.intent.action.PACKAGE_REMOVED".equals(str2)) {
                t1 t1VarA = t1.a();
                if (t1VarA.f.get()) {
                    Message message = new Message();
                    message.what = 3;
                    message.obj = str;
                    t1VarA.g.sendMessage(message);
                    return;
                }
                return;
            }
            return;
        }
        this.a.a.getClass();
        u0 u0VarB = v0.b(str);
        s0 s0Var = new s0(7, 0.0f);
        s0Var.c = str;
        if (u0VarB != null) {
            String strA = u0VarB.a();
            int i = u0VarB.m;
            if (i == 0 || i == 5) {
                if (TextUtils.isEmpty(q.a)) {
                    q.a = nh.a(jd.a).a("lcsw");
                }
                if (!"1".equals(q.a)) {
                    return;
                }
            }
            this.a.a.getClass();
            v0.a(strA);
            HashMap map = new HashMap();
            map.put(v5.KEY_DOWNLOAD_TYPE, Integer.valueOf(u0VarB.l));
            map.put(v5.KEY_INSTALL_EVENT_TYPE, Integer.valueOf(u0VarB.m));
            PackageInfo packageInfoA = e1.a(str);
            if (packageInfoA != null) {
                map.put(v5.KEY_AD_INSTALL_TIME, Long.valueOf(packageInfoA.firstInstallTime));
                h1.a().a(str, packageInfoA.firstInstallTime);
            }
            l lVarA = l.a();
            String str3 = u0VarB.f;
            lVarA.getClass();
            l.a(strA, str3, 35, map);
            c1.a(this.a, strA);
            this.a.a(strA, u0VarB.g, s0Var);
            zf zfVar = new zf(u0VarB.g, str);
            zfVar.d = u0VarB.j;
            xf.a().a((ag) zfVar);
        } else {
            this.a.a(str, "", s0Var);
            h1 h1VarA = h1.a();
            h1VarA.getClass();
            try {
                if (h1VarA.b.contains(str)) {
                    h1VarA.a(str);
                }
            } catch (Exception e) {
            }
        }
        t1 t1VarA2 = t1.a();
        if (t1VarA2.f.get()) {
            Message message2 = new Message();
            message2.what = 2;
            message2.obj = str;
            t1VarA2.g.sendMessage(message2);
        }
    }
}
