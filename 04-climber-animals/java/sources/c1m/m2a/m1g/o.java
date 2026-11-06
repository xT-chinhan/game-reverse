package c1m.m2a.m1g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.meta.android.mpg.cm.api.IAdCallback;

/* JADX INFO: loaded from: classes.dex */
final class o extends BroadcastReceiver {
    private IAdCallback a;

    private static class b {
        private static final o a = new o();
    }

    private o() {
    }

    private IntentFilter a(String str) {
        return new IntentFilter(String.format("%s.mpg.banner.callback", str));
    }

    public static o a() {
        return b.a;
    }

    private void b() {
        this.a = null;
    }

    public void a(Context context) {
        if (context != null) {
            t.a(context, this, a(context.getPackageName()), true);
        }
    }

    void a(IAdCallback iAdCallback) {
        this.a = iAdCallback;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("callback_event", 0);
        if (intExtra == 1) {
            c1m.m2a.m1g.b.a().a("MetaAdBannerCBR", "onShow");
            IAdCallback iAdCallback = this.a;
            if (iAdCallback != null) {
                iAdCallback.onAdShow();
                return;
            }
            return;
        }
        if (intExtra == 3) {
            String stringExtra = intent.getStringExtra("callback_extra");
            c1m.m2a.m1g.b.a().a("MetaAdBannerCBR", String.format("onShowFail %1s", stringExtra));
            IAdCallback iAdCallback2 = this.a;
            if (iAdCallback2 != null) {
                iAdCallback2.onAdShowFailed(30008, stringExtra);
            }
        } else {
            if (intExtra != 5) {
                if (intExtra != 6) {
                    return;
                }
                c1m.m2a.m1g.b.a().a("MetaAdBannerCBR", IAdInterListener.AdCommandType.AD_CLICK);
                IAdCallback iAdCallback3 = this.a;
                if (iAdCallback3 != null) {
                    iAdCallback3.onAdClick();
                    return;
                }
                return;
            }
            c1m.m2a.m1g.b.a().a("MetaAdBannerCBR", "onAdClose");
            IAdCallback iAdCallback4 = this.a;
            if (iAdCallback4 != null) {
                iAdCallback4.onAdClose();
            }
        }
        b();
    }
}
