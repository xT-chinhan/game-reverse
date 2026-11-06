package com.byazt.jjx;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.byazt.qit.x;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1659, 19})
public class n extends ContentObserver {
    public static final Uri n = Settings.System.getUriFor("screen_brightness");
    public Context qg;
    public InterfaceC0222n s;

    /* JADX INFO: renamed from: com.byazt.jjx.n$n, reason: collision with other inner class name */
    public interface InterfaceC0222n {
        void n(int i);
    }

    public n(Context context, Handler handler, InterfaceC0222n interfaceC0222n) {
        super(handler);
        this.qg = context;
        this.s = interfaceC0222n;
    }

    @Override // android.database.ContentObserver
    public void onChange(final boolean z, final Uri uri) {
        super.onChange(z, uri);
        com.byazt.ag.qg.n(new x("brightness onChange") { // from class: com.byazt.jjx.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.n.equals(uri)) {
                    try {
                        int i = Settings.System.getInt(n.this.qg.getContentResolver(), "screen_brightness", 0);
                        if (n.this.s != null) {
                            n.this.s.n(i);
                        }
                    } catch (Throwable th) {
                        k.qg("BrightnessObserver", "get screen brightness error: ".concat(String.valueOf(th)));
                    }
                }
            }
        });
    }

    public void n() {
        this.qg.getContentResolver().registerContentObserver(n, true, this);
    }

    public void qg() {
        this.qg.getContentResolver().unregisterContentObserver(this);
    }
}
