package com.byazt.en;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.byazt.ca.ho;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1242, 37})
public class pr extends ContentObserver {
    public InterfaceC0054pr hw;
    public Context pr;

    /* JADX INFO: renamed from: com.byazt.en.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0054pr {
        void pr(int i);
    }

    public pr(Context context, Handler handler, InterfaceC0054pr interfaceC0054pr) {
        super(handler);
        this.pr = context;
        this.hw = interfaceC0054pr;
    }

    @Override // android.database.ContentObserver
    public void onChange(final boolean z, final Uri uri) {
        super.onChange(z, uri);
        zo.pr(new fw("brightness onChange") { // from class: com.byazt.en.pr.1
            @Override // java.lang.Runnable
            public void run() {
                if (uri.equals(Settings.System.getUriFor("screen_brightness"))) {
                    try {
                        int i = Settings.System.getInt(pr.this.pr.getContentResolver(), "screen_brightness", 0);
                        if (pr.this.hw != null) {
                            pr.this.hw.pr(i);
                        }
                    } catch (Throwable th) {
                        ho.hw("BrightnessObserver", "get screen brightness error: ".concat(String.valueOf(th)));
                    }
                }
            }
        });
    }

    public void pr() {
        this.pr.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this);
    }

    public void hw() {
        this.pr.getContentResolver().unregisterContentObserver(this);
    }
}
