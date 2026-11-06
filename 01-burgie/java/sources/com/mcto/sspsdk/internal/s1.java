package com.mcto.sspsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mcto.sspsdk.QyCustomMade;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class s1 extends Handler {
    public final /* synthetic */ t1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(t1 t1Var, Looper looper) {
        super(looper);
        this.a = t1Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String[] strArr;
        int i;
        HashMap map;
        xa xaVar;
        xa xaVarA;
        t1 t1Var = this.a;
        u1 u1Var = t1Var.b;
        if (u1Var == null || u1Var.c == -1) {
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            t1 t1VarA = t1.a();
            t1VarA.getClass();
            QyCustomMade qyCustomMade = rd.d;
            int i3 = (qyCustomMade == null || !qyCustomMade.alist()) ? t1VarA.b.c : 1;
            if (i3 == 0) {
                t1VarA.g.sendEmptyMessageDelayed(1, t1VarA.b.b);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - t1VarA.a;
            u1 u1Var2 = t1VarA.b;
            if (j < u1Var2.d) {
                return;
            }
            if (i3 == 1) {
                t1VarA.a(kl.a(jd.a, u1Var2.a));
            } else if (i3 == 2 && !TextUtils.isEmpty(u1Var2.f)) {
                u1 u1Var3 = t1VarA.b;
                if (u1Var3.e == 0) {
                    t1VarA.a(kl.b(jd.a, u1Var3.f));
                } else {
                    t1VarA.c = u1Var3.f.split(",");
                    t1VarA.g.sendEmptyMessageDelayed(4, t1VarA.b.e);
                    jCurrentTimeMillis = 0;
                }
            }
            t1VarA.a = jCurrentTimeMillis;
            nh.a(jd.a).a("iad_dev", "dsts", jCurrentTimeMillis + "");
            return;
        }
        HashMap map2 = null;
        if (i2 == 2) {
            String str = (String) message.obj;
            if (!t1Var.f.get() || this.a.e.containsKey(str) || (xaVarA = kl.a(jd.a, str)) == null) {
                return;
            }
            this.a.e.put(str, xaVarA);
            kl.a(this.a.e, (HashMap) null);
            kl.a(this.a.e);
            return;
        }
        if (i2 == 3) {
            String str2 = (String) message.obj;
            if (t1Var.f.get() && (xaVar = (xa) this.a.e.remove(str2)) != null) {
                xaVar.g = "1";
                xaVar.e = "" + System.currentTimeMillis();
                HashMap map3 = new HashMap();
                map3.put(xaVar.a, xaVar);
                kl.a(this.a.e, map3);
                kl.a(this.a.e);
                return;
            }
            return;
        }
        if (i2 != 4 || (strArr = t1Var.c) == null || (i = t1Var.d) >= strArr.length) {
            return;
        }
        t1Var.d = i + 1;
        String str3 = strArr[i];
        xa xaVarA2 = kl.a(jd.a, str3);
        if (xaVarA2 != null) {
            t1Var.e.put(str3, xaVarA2);
            HashMap map4 = new HashMap();
            map4.put(str3, xaVarA2);
            map = null;
            map2 = map4;
        } else if (t1Var.e.containsKey(str3)) {
            map = new HashMap();
            map.put(str3, t1Var.e.remove(str3));
        } else {
            map = null;
        }
        kl.a(map2, map);
        kl.a(t1Var.e);
        t1Var.g.sendEmptyMessageDelayed(4, t1Var.b.e);
    }
}
