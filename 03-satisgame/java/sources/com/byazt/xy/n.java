package com.byazt.xy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.ug.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 577, 19})
public class n {
    public static String l = "";
    public static String q = "";
    public static String w = "";
    public static volatile n x;
    public Context cp;
    public s n;
    public boolean fs = true;
    public boolean rv = false;
    public volatile boolean tj = false;
    public final List<Pair<qg, q>> d = new ArrayList();
    public final List<Object> qg = new ArrayList();
    public final ServiceConnection oa = new ServiceConnection() { // from class: com.byazt.xy.n.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (n.this.s) {
                n.this.n(false);
                n.this.n = s.n.n(iBinder);
                n.this.s();
                Iterator<Object> it = n.this.qg.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (n.this.s) {
                n.this.n(false);
                n.this.n = null;
                Iterator<Object> it = n.this.qg.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    public String sz = "";
    public final Object s = new Object();

    private n() {
    }

    public static n n() {
        if (x == null) {
            synchronized (n.class) {
                if (x == null) {
                    x = new n();
                }
            }
        }
        return x;
    }

    public boolean n(Context context, boolean z) {
        if (TextUtils.isEmpty(q)) {
            JSONObject jSONObjectRv = d.rv();
            String strOptString = jSONObjectRv.optString(com.anythink.core.common.s.a);
            q = com.byazt.bk.s.n(jSONObjectRv.optString("q"), strOptString);
            l = com.byazt.bk.s.n(jSONObjectRv.optString("u"), strOptString);
            w = com.byazt.bk.s.n(jSONObjectRv.optString("w"), strOptString);
        }
        this.rv = z;
        if (context == null) {
            return true;
        }
        this.cp = context.getApplicationContext();
        if (TextUtils.isEmpty(w)) {
            w = this.cp.getPackageName();
        }
        if (this.n != null || q()) {
            return true;
        }
        return this.cp.bindService(n(context), this.oa, 33);
    }

    public void qg() {
        if (this.n != null) {
            this.cp.unbindService(this.oa);
            this.n = null;
        }
        this.qg.clear();
        this.d.clear();
    }

    public Intent n(Context context) {
        Intent intent = new Intent();
        intent.setAction(q);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (l.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void n(qg qgVar, q qVar) {
        synchronized (this.s) {
            qgVar.l = w;
            if (TextUtils.isEmpty(qgVar.w)) {
                qgVar.w = this.sz;
            }
            s sVar = this.n;
            if (sVar != null) {
                try {
                    sVar.n(qgVar, qVar);
                } catch (RemoteException unused) {
                }
            } else if (q() || n(this.cp, this.rv)) {
                this.d.add(Pair.create(qgVar, qVar));
            }
        }
    }

    public void s() {
        for (Pair<qg, q> pair : this.d) {
            try {
                this.n.n((qg) pair.first, (q) pair.second);
            } catch (RemoteException unused) {
            }
        }
        this.d.clear();
    }

    public boolean q() {
        return this.tj;
    }

    public void n(boolean z) {
        this.tj = z;
    }
}
