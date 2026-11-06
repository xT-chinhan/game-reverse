package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mcto.sspsdk.QyAdSlot;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 implements Runnable {
    public final /* synthetic */ c1 a;

    public a1(c1 c1Var) {
        this.a = c1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        if (this.a.g.compareAndSet(true, false)) {
            Context context = jd.a;
            z = true;
        } else {
            z = false;
        }
        this.a.a.getClass();
        ArrayList<u0> arrayList = new ArrayList();
        t4 t4VarB = t4.b();
        if (t4VarB != null) {
            SQLiteDatabase sQLiteDatabaseC = t4VarB.c();
            try {
                if (sQLiteDatabaseC != null) {
                    try {
                        Cursor cursorRawQuery = sQLiteDatabaseC.rawQuery("select * from A", null);
                        while (cursorRawQuery.moveToNext()) {
                            t0 t0Var = new t0();
                            t0Var.e = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(an.aF));
                            t0Var.g = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("b"));
                            t0Var.h = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("d"));
                            t0Var.d = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(an.av));
                            t0Var.c = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("g"));
                            t0Var.a = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("f"));
                            t0 t0VarA = t0Var.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("e")));
                            t0VarA.b = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("j"));
                            t0VarA.i = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(an.aG));
                            t0VarA.k = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("k"));
                            t0VarA.o = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(an.aC));
                            t0VarA.p = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("l"));
                            u0 u0Var = new u0(t0VarA);
                            arrayList.add(u0Var);
                            u0Var.c();
                        }
                        cursorRawQuery.close();
                    } catch (Exception e) {
                        r9.a("ssp_sdk", "ssp_downloader", e);
                    }
                    t4VarB.a();
                }
            } catch (Throwable th) {
                t4VarB.a();
                throw th;
            }
        }
        HashMap map = new HashMap();
        for (u0 u0Var2 : arrayList) {
            String str = u0Var2.i;
            int i = u0Var2.l;
            s0 s0Var = new s0(7, 100.0f);
            PackageInfo packageInfoA = e1.a(str);
            if (packageInfoA != null) {
                String strA = u0Var2.a();
                int i2 = u0Var2.m;
                if (i2 == 0 || i2 == 5) {
                    if (TextUtils.isEmpty(q.a)) {
                        q.a = nh.a(jd.a).a("lcsw");
                    }
                    if (!"1".equals(q.a)) {
                    }
                }
                this.a.a.getClass();
                v0.a(strA);
                HashMap map2 = new HashMap();
                map2.put(v5.KEY_DOWNLOAD_TYPE, Integer.valueOf(i));
                map2.put(v5.KEY_INSTALL_EVENT_TYPE, Integer.valueOf(i2));
                map2.put(v5.KEY_AD_INSTALL_TIME, Long.valueOf(packageInfoA.firstInstallTime));
                l lVarA = l.a();
                String str2 = u0Var2.f;
                lVarA.getClass();
                l.a(strA, str2, 35, map2);
                map.put(str, new xa(str, "" + packageInfoA.firstInstallTime));
                c1.a(this.a, strA);
                this.a.a(strA, u0Var2.g, s0Var);
                zf zfVar = new zf(u0Var2.g, str);
                zfVar.d = u0Var2.j;
                xf.a().a((ag) zfVar);
            } else if (z && u0Var2.l <= 2 && u0Var2.a == 1) {
                u0Var2.q = 1;
                this.a.b(u0Var2);
            }
        }
        if (!z) {
            h1.a().a(map);
            return;
        }
        h1.a().d = map;
        QyAdSlot qyAdSlotBuild = QyAdSlot.newQyAdSlot().videoId("11111").isMute(false).codeId("504").supportNegativeFeedback(false).build();
        HashMap map3 = c0.k;
        b0 b0Var = new b0();
        b0Var.d = 9;
        b0Var.h = false;
        b0Var.a = qyAdSlotBuild;
        b0Var.c = gj.a(qyAdSlotBuild.h());
        b0Var.b = new f1();
        new c0(b0Var).b();
    }
}
