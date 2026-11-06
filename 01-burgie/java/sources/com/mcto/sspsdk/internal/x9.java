package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class x9 {
    public static volatile x9 i;
    public final Context a;
    public final AudioManager b;
    public t9 d;
    public u9 e;
    public final HashMap c = new HashMap();
    public boolean f = false;
    public boolean g = false;
    public float h = -1.0f;

    public x9(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = (AudioManager) applicationContext.getSystemService(MediaFormat.KEY_AUDIO);
    }

    public static x9 a(Context context) {
        if (i == null) {
            synchronized (x9.class) {
                if (i == null) {
                    i = new x9(context);
                }
            }
        }
        return i;
    }

    public final void b(String str, w9 w9Var) {
        List list = (List) this.c.get(str);
        if (list != null) {
            list.remove(w9Var);
            if (list.isEmpty()) {
                this.c.remove(str);
                if ("android.media.VOLUME_CHANGED_ACTION".equals(str)) {
                    if (this.d != null) {
                        try {
                            this.a.getContentResolver().unregisterContentObserver(this.d);
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                    this.f = false;
                    return;
                }
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
                    u9 u9Var = this.e;
                    if (u9Var != null) {
                        try {
                            this.a.unregisterReceiver(u9Var);
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                    }
                    this.g = false;
                }
            }
        }
    }

    public final void a(String str, w9 w9Var) {
        if (w9Var != null) {
            List arrayList = (List) this.c.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.c.put(str, arrayList);
            }
            if (!arrayList.contains(w9Var)) {
                arrayList.add(w9Var);
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(str) && !this.f) {
                if (this.d == null) {
                    this.d = new t9(this, new Handler());
                }
                try {
                    this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.d);
                    this.f = true;
                    return;
                } catch (Exception e) {
                    e.getMessage();
                    return;
                }
            }
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(str) || this.g) {
                return;
            }
            if (this.e == null) {
                this.e = new u9(this);
            }
            try {
                this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.g = true;
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }
}
