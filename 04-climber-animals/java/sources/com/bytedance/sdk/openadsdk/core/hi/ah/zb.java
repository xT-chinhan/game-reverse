package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends sl {
    private WeakReference<Context> ah;
    private String c;
    private volatile boolean ch;
    private String d;
    private final lm ka;
    private volatile com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ny;
    private int x = 0;
    private boolean hi = false;
    private Bridge ab = com.bytedance.sdk.openadsdk.core.ch.ub().ul();

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ah() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(int i, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(lm lmVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms(JSONObject jSONObject, boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms(boolean z, boolean z2) {
        return false;
    }

    public zb(Context context, String str, lm lmVar, String str2, boolean z) {
        this.ah = new WeakReference<>(context);
        this.ka = lmVar;
        this.c = str2;
        this.d = str;
        ka(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.ah;
            if (weakReference == null) {
                return re.getContext();
            }
            Context context = weakReference.get();
            return context == null ? re.getContext() : context;
        } catch (Throwable unused) {
            return re.getContext();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.sl
    public com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah xr() {
        if (this.ny == null) {
            synchronized (this) {
                if (this.ny == null) {
                    this.ny = new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah(getContext(), this.ka);
                }
            }
        }
        return this.ny;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.hi.ah.ah.ms d() {
        if (ms()) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ka();
        }
        return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ka(boolean z) {
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.d, this.c, this.ka, (JSONObject) null, ch());
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.ka, ch(), z);
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.c, ch());
        hi();
    }

    private synchronized void c() {
        if (this.ab == null) {
            return;
        }
        if (g.xr >= 6400 && !g.c()) {
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms((com.bytedance.sdk.openadsdk.core.le.ms.ms.ah) null, ch());
        }
        if (sl()) {
            this.ab.call(18, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Boolean.class);
        } else {
            this.ab.call(4, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
        }
    }

    private synchronized void hi() {
        if (this.ab == null) {
            return;
        }
        if (!sl()) {
            this.ab.call(5, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
            return;
        }
        of ofVar = new of();
        ofVar.ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()));
        if (((Boolean) this.ab.call(19, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVar).xr(), Boolean.class)).booleanValue()) {
            this.ab.call(14, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Boolean.class);
        }
    }

    private boolean sl() {
        lm lmVar = this.ka;
        if (lmVar != null) {
            return nw.ms(lmVar);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void x() {
        hi();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ny() {
        c();
        WeakReference<Context> weakReference = this.ah;
        if (weakReference != null) {
            weakReference.clear();
            this.ah = null;
        }
        this.ny = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms() {
        Bridge bridge = this.ab;
        return bridge != null && com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(bridge, ch()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(JSONObject jSONObject, boolean z) {
        xr().ms(d());
        if (h()) {
            if (ms() || !zb()) {
                ms((com.bytedance.sdk.openadsdk.core.nw.d) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zb() {
        int i = this.x;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.zb.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.nw.d dVarMs = re.ms().ms(zb.this.ka, zb.this.d);
                    if (dVarMs == null || !dVarMs.ka()) {
                        ub.ms(re.getContext());
                        return;
                    }
                    String strC = dVarMs.c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject = new JSONObject(strC);
                    } catch (JSONException unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.nw.c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(jSONObject);
                    com.bytedance.sdk.openadsdk.core.nw.c cVarPh = zb.this.ka.ph();
                    if (cVarPh == null) {
                        zb.this.ka.ms(cVarKa);
                    } else {
                        cVarPh.ch(cVarKa.u());
                        cVarPh.xr(cVarKa.ka());
                        cVarPh.d(cVarKa.ab());
                        cVarPh.xr(cVarKa.sl());
                        cVarPh.ka(cVarKa.x());
                        cVarPh.ny(cVarKa.zb());
                        cVarPh.ah(cVarKa.c());
                        cVarPh.c(cVarKa.ny());
                        cVarPh.ab(cVarKa.ch());
                        cVarPh.x(cVarKa.hi());
                        cVarKa = cVarPh;
                    }
                    if (zb.this.u()) {
                        return;
                    }
                    zb.this.ms(cVarKa.c(), cVarKa.u(), cVarKa.zb());
                    zb.this.ms(dVarMs);
                }
            });
            return true;
        }
        if (u()) {
            return true;
        }
        ub.ms(re.getContext());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, String str2, String str3) {
        if (this.ab == null) {
            return;
        }
        this.ab.call(24, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_APP_ICON, str).ms("appName", str2).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms("packageName", str3)).xr(), Boolean.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.nw.d dVar) {
        nw();
        if (xr(dVar)) {
            return;
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        return ao() || ub();
    }

    private boolean ub() {
        lm lmVar = this.ka;
        com.bytedance.sdk.openadsdk.core.nw.c cVarPh = lmVar != null ? lmVar.ph() : null;
        String strZb = cVarPh != null ? cVarPh.zb() : "";
        Intent intentXr = TextUtils.isEmpty(strZb) ? null : f.xr(getContext(), strZb);
        if (intentXr != null && f.ah(getContext(), strZb)) {
            try {
                getContext().startActivity(intentXr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private boolean ao() {
        lm lmVar = this.ka;
        if (lmVar == null || lmVar.tc() == null) {
            return false;
        }
        String strXr = this.ka.tc().xr();
        if (TextUtils.isEmpty(strXr)) {
            return false;
        }
        h.ms((String) null);
        Uri uri = Uri.parse(strXr);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (!f.ms(getContext(), intent)) {
            return false;
        }
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        try {
            getContext().startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean xr(com.bytedance.sdk.openadsdk.core.nw.d dVar) {
        com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVarXr = xr();
        if (!ahVarXr.d(false) || qv()) {
            return false;
        }
        if (ms(getContext(), this.ka, this.c)) {
            return true;
        }
        ahVarXr.ms(dVar, this.c, this.d, new com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.zb.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr
            public void ms() {
                zb.this.y();
                zb.this.xr(true);
            }
        });
        return true;
    }

    private boolean h() {
        if (this.ab == null || nw.y(this.ka) == 1 || nw.ch(this.ka) || !qv()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.zb.3
            @Override // java.lang.Runnable
            public void run() {
                op.ms(zb.this.getContext(), "应用正在下载...", 0);
            }
        });
        return false;
    }

    private boolean qv() {
        if (this.ab == null) {
            return false;
        }
        return ((Boolean) this.ab.call(6, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.d).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Boolean.class)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        final Map<String, Object> mapT = t();
        if (!ms()) {
            ms(16, mapT);
        } else {
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(mapT, new com.bytedance.sdk.openadsdk.core.le.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.zb.4
                @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
                public void handleComplianceDialog(boolean z) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
                public void handleMarketFailedComplianceDialog() {
                    if (mapT == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(0, zb.this.ch());
                    zb.this.xr().ms(zb.this.d());
                    mapT.remove(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER);
                    if (zb.this.zb()) {
                        return;
                    }
                    zb.this.ms((com.bytedance.sdk.openadsdk.core.nw.d) null);
                }
            });
            ms(mapT);
        }
    }

    private void ms(final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.hi.ch.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.zb.5
            @Override // java.lang.Runnable
            public void run() {
                zb.this.ms(17, (Map<String, Object>) map);
            }
        }, this.ka);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final int i, final Map<String, Object> map) {
        try {
            if (this.ab == null) {
                return;
            }
            if (sl()) {
                this.ab.call(13, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
                this.ch = false;
            } else if (g.xr < 4500) {
                this.ab.call(i, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
                this.ch = false;
            } else {
                map.put(TTDownloadField.TT_ITEM_CLICK_LISTENER, new com.bytedance.sdk.openadsdk.core.le.ms.ms.d() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.zb.6
                    @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.d
                    public void ms(Bridge bridge, Bridge bridge2, Bridge bridge3) {
                        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.xr(1, zb.this.ch());
                        map.remove(TTDownloadField.TT_ITEM_CLICK_LISTENER);
                        zb.this.ab.call(i, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
                    }
                });
                this.ab.call(i, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
                this.ch = false;
            }
        } catch (Throwable unused) {
        }
    }

    private Map<String, Object> t() {
        long jLongValue = Double.valueOf(this.ka.df()).longValue();
        if (sl()) {
            return new of().ms(TTDownloadField.TT_USERAGENT, null).ms(TTDownloadField.TT_IS_DISABLE_DIALOG, Boolean.TRUE).ms(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER, null).ms(TTDownloadField.TT_ACTION_TYPE_BUTTON, 2).ms("id", Long.valueOf(jLongValue)).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()));
        }
        return new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.d).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms("id", Long.valueOf(jLongValue)).ms(TTDownloadField.TT_ACTION_TYPE_BUTTON, 2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(boolean z) {
        if (g.xr >= 5400 && z) {
            this.ch = z;
            if (ms()) {
                com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(true, com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.ka, this.hi), ch());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void d(boolean z) {
        this.hi = z;
    }

    private void nw() {
        if (g.xr >= 5400 && ms() && !this.ch) {
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(false, (com.bytedance.sdk.openadsdk.core.le.ms.ms.ah) null, ch());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ab() {
        if (this.ab != null) {
            this.ab.call(8, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_FORCE, Boolean.TRUE).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(int i) {
        this.x = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public Map<String, Object> ka() {
        return new HashMap();
    }
}
