package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tapsdk.tapad.e.a;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class x implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {
    private lm ah;
    private String d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nw.ka f3148ms;
    private Context xr;

    public x(com.bytedance.sdk.openadsdk.core.nw.ka kaVar, Context context) {
        this.f3148ms = kaVar;
        this.xr = context;
    }

    public void ms(lm lmVar) {
        this.ah = lmVar;
    }

    public void ms(String str) {
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(Map<String, Object> map) {
        return ms();
    }

    private boolean ms() {
        com.bytedance.sdk.openadsdk.core.nw.ka kaVar = this.f3148ms;
        if (kaVar == null) {
            return false;
        }
        String strMs = kaVar.ms();
        if (nw.c(this.ah) != 3 || TextUtils.isEmpty(strMs)) {
            return false;
        }
        boolean zXr = xr(strMs);
        if (zXr) {
            xr();
        } else {
            ms(false);
        }
        return zXr;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.x$1] */
    private void xr() {
        new CountDownTimer(a.f, a.f) { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.x.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (ch.ub() == null || ch.ub().ms()) {
                    x.this.ms(true);
                } else {
                    x.this.ms(false);
                }
            }
        }.start();
    }

    public boolean xr(String str) {
        if (this.xr == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            com.bytedance.sdk.component.utils.xr.startActivity(this.xr, intent, TextUtils.equals("main", UMModuleRegister.INNER));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ah, this.d, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ah, this.d, "quickapp_fail");
        }
    }
}
