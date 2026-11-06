package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.anythink.china.b.c;
import com.byazt.mk.l;
import com.byazt.mk.q;
import com.byazt.qt.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends Activity {
    private Intent n;

    @com.byazt.cp.n(n = {0, 55, 2383, 2384, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 1552})
    public static class n implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n();
        this.n = getIntent();
        if (qg.getContext() == null) {
            qg.n(this);
        }
    }

    private void n() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (qg.getContext() == null) {
            qg.n(this);
        }
        try {
            setIntent(intent);
            this.n = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            qg();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void qg() {
        try {
            int intExtra = this.n.getIntExtra("type", 0);
            if (intExtra == 1) {
                n(intExtra, this.n.getIntArrayExtra("permissions"));
                return;
            }
            if (intExtra == 2) {
                n(this.n.getStringExtra("permission_id_key"), this.n.getStringArrayExtra("permission_content_key"));
            } else if (intExtra == 3) {
                n(intExtra, (int[]) null);
            } else {
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void n(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        try {
            q.n().n(this, strArr, new l() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                @Override // com.byazt.mk.l
                public void n() {
                    com.byazt.mk.n.n(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.mk.l
                public void n(String str2) {
                    com.byazt.mk.n.n(str, str2);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void n(int i, int[] iArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (i != 1) {
                if (i == 3) {
                    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    arrayList.add(c.a);
                    arrayList.add(c.b);
                }
            } else if (iArr != null && iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 == 1) {
                        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    } else if (i2 == 2) {
                        arrayList.add(c.a);
                    } else if (i2 == 3) {
                        arrayList.add(c.b);
                    }
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            q.n().n(this, strArr, new l() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                @Override // com.byazt.mk.l
                public void n() {
                    com.byazt.rb.qg.n("TMe", "-------=----- onGranted");
                    com.byazt.rb.l.q(new n());
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.mk.l
                public void n(String str) {
                    com.byazt.rb.qg.n("TMe", "-------=----- onDenied: ".concat(String.valueOf(str)));
                    c.a.equals(str);
                    com.byazt.rb.l.q(new n());
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        q.n().n(this, strArr, iArr);
        com.byazt.rb.l.q(new n());
        finish();
    }
}
