package c1m.m2a.m1g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.meta.android.mpg.cm.api.IAdCallback;

/* JADX INFO: loaded from: classes.dex */
final class r extends BroadcastReceiver {
    private IAdCallback.IVideoIAdCallback a;

    private static class b {
        private static final r a = new r();
    }

    private r() {
    }

    private IntentFilter a(String str) {
        return new IntentFilter(String.format("%s.mpg.cm.callback", str));
    }

    public static r a() {
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

    void a(IAdCallback.IVideoIAdCallback iVideoIAdCallback) {
        this.a = iVideoIAdCallback;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        switch (intent.getIntExtra("callback_event", 0)) {
            case 1:
                c1m.m2a.m1g.b.a().a("MetaAdVideoCBR", "onShow");
                IAdCallback.IVideoIAdCallback iVideoIAdCallback = this.a;
                if (iVideoIAdCallback != null) {
                    iVideoIAdCallback.onAdShow();
                    return;
                }
                return;
            case 2:
                c1m.m2a.m1g.b.a().a("MetaAdVideoCBR", "onAdClickSkip");
                IAdCallback.IVideoIAdCallback iVideoIAdCallback2 = this.a;
                if (iVideoIAdCallback2 != null) {
                    iVideoIAdCallback2.onAdClickSkip();
                    return;
                }
                return;
            case 3:
                String stringExtra = intent.getStringExtra("callback_extra");
                c1m.m2a.m1g.b.a().a("MetaAdVideoCBR", String.format("onShowFail %1s", stringExtra));
                IAdCallback.IVideoIAdCallback iVideoIAdCallback3 = this.a;
                if (iVideoIAdCallback3 != null) {
                    iVideoIAdCallback3.onAdShowFailed(30008, stringExtra);
                }
                break;
            case 4:
                c1m.m2a.m1g.b.a().a("MetaAdVideoCBR", "onAdReward");
                IAdCallback.IVideoIAdCallback iVideoIAdCallback4 = this.a;
                if (iVideoIAdCallback4 != null) {
                    iVideoIAdCallback4.onAdReward();
                    return;
                }
                return;
            case 5:
                c1m.m2a.m1g.b.a().a("MetaAdVideoCBR", "onAdClose");
                if (this.a != null) {
                    intent.getStringExtra("callback_extra");
                    this.a.onAdClose();
                }
                break;
            case 6:
                c1m.m2a.m1g.b.a().a("MetaAdVideoCBR", IAdInterListener.AdCommandType.AD_CLICK);
                IAdCallback.IVideoIAdCallback iVideoIAdCallback5 = this.a;
                if (iVideoIAdCallback5 != null) {
                    iVideoIAdCallback5.onAdClick();
                    return;
                }
                return;
            default:
                return;
        }
        b();
    }
}
