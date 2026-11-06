package com.byazt.xfv;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.eld.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 37})
public class pr {
    public static volatile pr fw;
    public hn pr;
    public Context w;
    public static String x = "";
    public static String c = "";
    public static String uc = "";
    public boolean zo = true;
    public boolean aj = false;
    public volatile boolean vk = false;
    public final List<Pair<hw, x>> k = new ArrayList();
    public final List<Object> hw = new ArrayList();
    public final ServiceConnection m = new ServiceConnection() { // from class: com.byazt.xfv.pr.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (pr.this.hn) {
                pr.this.pr(false);
                pr.this.pr = hn.pr.pr(iBinder);
                pr.this.hn();
                Iterator<Object> it = pr.this.hw.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (pr.this.hn) {
                pr.this.pr(false);
                pr.this.pr = null;
                Iterator<Object> it = pr.this.hw.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    public String g = "";
    public final Object hn = new Object();

    private pr() {
    }

    public static pr pr() {
        if (fw == null) {
            synchronized (pr.class) {
                if (fw == null) {
                    fw = new pr();
                }
            }
        }
        return fw;
    }

    public boolean pr(Context context, boolean z) {
        if (TextUtils.isEmpty(x)) {
            JSONObject jSONObjectAj = k.aj();
            String strOptString = jSONObjectAj.optString(an.aB);
            x = com.byazt.now.hn.pr(jSONObjectAj.optString("q"), strOptString);
            c = com.byazt.now.hn.pr(jSONObjectAj.optString(an.aH), strOptString);
            uc = com.byazt.now.hn.pr(jSONObjectAj.optString("w"), strOptString);
        }
        this.aj = z;
        if (context != null) {
            this.w = context.getApplicationContext();
            if (TextUtils.isEmpty(uc)) {
                uc = this.w.getPackageName();
            }
            if (this.pr == null && !x()) {
                return this.w.bindService(pr(context), this.m, 33);
            }
            return true;
        }
        return true;
    }

    public void hw() {
        if (this.pr != null) {
            this.w.unbindService(this.m);
            this.pr = null;
        }
        this.hw.clear();
        this.k.clear();
    }

    public Intent pr(Context context) {
        Intent intent = new Intent();
        intent.setAction(x);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (c.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void pr(hw hwVar, x xVar) {
        synchronized (this.hn) {
            hwVar.c = uc;
            if (TextUtils.isEmpty(hwVar.uc)) {
                hwVar.uc = this.g;
            }
            hn hnVar = this.pr;
            if (hnVar != null) {
                try {
                    hnVar.pr(hwVar, xVar);
                } catch (RemoteException e) {
                }
            } else if (x() || pr(this.w, this.aj)) {
                this.k.add(Pair.create(hwVar, xVar));
            }
        }
    }

    public void hn() {
        for (Pair<hw, x> pair : this.k) {
            try {
                this.pr.pr((hw) pair.first, (x) pair.second);
            } catch (RemoteException e) {
            }
        }
        this.k.clear();
    }

    public boolean x() {
        return this.vk;
    }

    public void pr(boolean z) {
        this.vk = z;
    }
}
