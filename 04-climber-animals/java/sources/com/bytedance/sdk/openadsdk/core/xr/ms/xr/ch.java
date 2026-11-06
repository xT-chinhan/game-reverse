package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.anythink.basead.exoplayer.i.a;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.yu;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    private static volatile boolean x = false;
    private ce ab;
    private final Context ah;
    private boolean c;
    private int d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Toast f3779ms;
    private final lm xr;

    public interface ms {
        void ms();

        void xr();
    }

    public static boolean ms() {
        return x;
    }

    public static void ms(boolean z) {
        x = z;
    }

    public ch(lm lmVar, Context context) {
        this.xr = lmVar;
        this.ah = context;
    }

    public ch ms(String str) {
        this.ka = str;
        return this;
    }

    public ch ms(int i) {
        this.d = i;
        return this;
    }

    public ch xr(boolean z) {
        this.c = z;
        return this;
    }

    public boolean ms(ms msVar) {
        int iXr;
        if (this.ab == null) {
            lm lmVar = this.xr;
            this.ab = lmVar != null ? lmVar.js() : null;
        }
        ce ceVar = this.ab;
        if (ceVar == null) {
            return false;
        }
        int iXr2 = ceVar.xr();
        if (iXr2 != 1) {
            if (iXr2 != 2 || (iXr = xr(msVar)) == 0) {
                return false;
            }
            if (iXr == 2) {
                return true;
            }
            if (TextUtils.isEmpty(this.ab.ms())) {
                return false;
            }
            ms(msVar, this.ab, a.f);
            return true;
        }
        if (this.c && (TextUtils.isEmpty(this.ab.x()) || xr(msVar) == 2)) {
            return true;
        }
        return false;
    }

    private int xr(ms msVar) {
        ce ceVarJs;
        lm lmVar = this.xr;
        if (lmVar == null || (ceVarJs = lmVar.js()) == null) {
            return 0;
        }
        if (ceVarJs.c() != 1 || !x.ah().ms()) {
            return 1;
        }
        if (TextUtils.isEmpty(ceVarJs.ab())) {
            return 0;
        }
        ms(msVar, ceVarJs);
        return 2;
    }

    private void ms(final ms msVar, ce ceVar) {
        xr();
        re.ms().ms(ceVar, this.xr.ir(), this.xr.lx(), new xr(msVar, ceVar, this.f3779ms) { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.1
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.xr, com.bytedance.sdk.openadsdk.core.yu.ah
            public void ms(JSONObject jSONObject) {
                String strOptString = jSONObject.optString("userName");
                String strOptString2 = jSONObject.optString("path");
                if (!TextUtils.isEmpty(strOptString)) {
                    if (ch.this.f3779ms != null) {
                        ch.this.f3779ms.cancel();
                    }
                    x.ah().ms(ch.this.xr, strOptString, strOptString2, msVar, ch.this.ka, ch.this.c);
                    return;
                }
                ms(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " userName or path is null!");
            }
        }, 1, a.f);
    }

    private void ms(ms msVar, ce ceVar, long j) {
        xr();
        re.ms().ms(ceVar, this.xr.ir(), this.xr.lx(), new xr(msVar, ceVar, this.f3779ms), 2, j);
    }

    class xr implements yu.ah<JSONObject> {
        private final Toast d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final ms f3783ms;
        private final ce xr;

        xr(ms msVar, ce ceVar, Toast toast) {
            this.f3783ms = msVar;
            this.xr = ceVar;
            this.d = toast;
        }

        @Override // com.bytedance.sdk.openadsdk.core.yu.ah
        public void ms(int i, String str) {
            sl.xr("WechatClickHandler", "getWechatLink failed:" + i + ", " + str);
            this.xr.xr(0);
            Toast toast = this.d;
            if (toast != null) {
                toast.cancel();
            }
            ms msVar = this.f3783ms;
            if (msVar != null) {
                msVar.xr();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sdk.openadsdk.core.yu.ah
        public void ms(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(strOptString)) {
                ch.this.ms(strOptString, this.xr, this.f3783ms);
            } else {
                ms(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " scheme is null!");
            }
        }
    }

    private void xr() {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ch.this.f3779ms != null) {
                        ch.this.f3779ms.cancel();
                    }
                    ch chVar = ch.this;
                    chVar.f3779ms = op.ms(chVar.ah, "即将跳转微信...", 1, 17, 0, 0);
                    ch.this.f3779ms.show();
                } catch (Throwable th) {
                    sl.xr("toast error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, final ce ceVar, final ms msVar) {
        Toast toast = this.f3779ms;
        if (toast != null) {
            toast.cancel();
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        final String strMs = nw.xr(this.xr) ? this.ka : f.ms(this.d);
        com.bytedance.sdk.component.utils.xr.ms(this.ah, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.3
            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms() {
                ceVar.xr(1);
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(ch.this.xr, strMs, "deeplink_success_realtime", (Throwable) null);
                HashMap map = new HashMap();
                map.put("source", "WechatClickProcesser");
                com.bytedance.sdk.openadsdk.core.zb.ah.x(ch.this.xr, strMs, "open_url_app", map);
                com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(ch.this.xr, strMs, false);
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms();
                }
            }

            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms(Throwable th) {
                ceVar.xr(0);
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.xr();
                }
            }
        }, TextUtils.equals("main", UMModuleRegister.INNER));
    }
}
