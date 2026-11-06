package com.ss.android.downloadlib.ms.ms;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.downloadlib.addownload.hi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    private static volatile ms ab = null;
    private static String c = "";
    private static String d = "";
    private static String ka = "";
    private Context hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public ah f4513ms;
    private boolean x = true;
    private boolean ny = false;
    private volatile boolean ch = false;
    private final List<Pair<xr, d>> sl = new ArrayList();
    public final List<Object> xr = new ArrayList();
    private final ServiceConnection zb = new ServiceConnection() { // from class: com.ss.android.downloadlib.ms.ms.ms.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (ms.this.ah) {
                ms.this.ms(false);
                ms.this.f4513ms = ah.ms.ms(iBinder);
                ms.this.ah();
                Iterator<Object> it = ms.this.xr.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (ms.this.ah) {
                ms.this.ms(false);
                ms.this.f4513ms = null;
                Iterator<Object> it = ms.this.xr.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    private String u = "";
    public final Object ah = new Object();

    private ms() {
    }

    public static ms ms() {
        if (ab == null) {
            synchronized (ms.class) {
                if (ab == null) {
                    ab = new ms();
                }
            }
        }
        return ab;
    }

    public boolean ms(Context context, boolean z) {
        if (TextUtils.isEmpty(d)) {
            JSONObject jSONObjectNy = hi.ny();
            String strOptString = jSONObjectNy.optString("s");
            d = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("q"), strOptString);
            ka = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("u"), strOptString);
            c = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString(IAdInterListener.AdReqParam.WIDTH), strOptString);
        }
        this.ny = z;
        if (context == null) {
            return true;
        }
        this.hi = context.getApplicationContext();
        if (TextUtils.isEmpty(c)) {
            c = this.hi.getPackageName();
        }
        if (this.f4513ms != null || d()) {
            return true;
        }
        return this.hi.bindService(ms(context), this.zb, 33);
    }

    public void xr() {
        if (this.f4513ms != null) {
            this.hi.unbindService(this.zb);
            this.f4513ms = null;
        }
        this.xr.clear();
        this.sl.clear();
    }

    public Intent ms(Context context) {
        Intent intent = new Intent();
        intent.setAction(d);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (ka.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void ms(xr xrVar, d dVar) {
        synchronized (this.ah) {
            xrVar.ka = c;
            if (TextUtils.isEmpty(xrVar.c)) {
                xrVar.c = this.u;
            }
            ah ahVar = this.f4513ms;
            if (ahVar != null) {
                try {
                    ahVar.ms(xrVar, dVar);
                } catch (RemoteException e) {
                    ab.ms(e);
                }
            } else if (d() || ms(this.hi, this.ny)) {
                this.sl.add(Pair.create(xrVar, dVar));
            }
        }
    }

    public void ah() {
        for (Pair<xr, d> pair : this.sl) {
            try {
                this.f4513ms.ms((xr) pair.first, (d) pair.second);
            } catch (RemoteException e) {
                ab.ms(e);
            }
        }
        this.sl.clear();
    }

    public boolean d() {
        return this.ch;
    }

    public void ms(boolean z) {
        this.ch = z;
    }
}
