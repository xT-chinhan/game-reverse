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
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u extends sl {
    private final lm ab;
    private WeakReference<Context> ah;
    private DownloadModel c;
    private DownloadEventConfig ch;
    private String d;
    private Bridge hi;
    private AdDownloadModel.Builder ka;
    private AdDownloadController ny;
    private int sl = 0;
    private volatile boolean u;
    private boolean ub;
    private String x;
    private volatile com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah zb;

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

    public u(Context context, String str, lm lmVar, String str2, boolean z) {
        this.ah = new WeakReference<>(context);
        this.ab = lmVar;
        this.x = str2;
        this.d = str;
        AdDownloadModel.Builder builderMs = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(str, str2, lmVar, (JSONObject) null);
        this.ka = builderMs;
        this.c = builderMs.build();
        this.ny = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(lmVar, z).build();
        this.ch = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(this.x).build();
        this.hi = com.bytedance.sdk.openadsdk.core.ch.ub().ul();
        ka(false);
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
        if (this.zb == null) {
            synchronized (this) {
                if (this.zb == null) {
                    this.zb = new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah(getContext(), this.ab);
                }
            }
        }
        return this.zb;
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
        hi();
    }

    private synchronized void c() {
        if (this.hi == null) {
            return;
        }
        if (this.ny != null && g.xr >= 6400 && !g.c()) {
            this.ny.setDownloadMarketInterceptor(null);
        }
        if (sl()) {
            this.hi.call(18, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms("id", Long.valueOf(this.c.getId())).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Boolean.class);
        } else {
            this.hi.call(4, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.c.getDownloadUrl()).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
        }
    }

    private synchronized void hi() {
        if (this.hi == null) {
            return;
        }
        if (!sl()) {
            this.hi.call(5, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_DOWNLOAD_MODEL, this.c).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
            return;
        }
        if (((Boolean) this.hi.call(19, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms("id", Long.valueOf(this.c.getId()))).xr(), Boolean.class)).booleanValue()) {
            this.hi.call(14, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms("id", Long.valueOf(this.c.getId())).ms(TTDownloadField.TT_LOG_EXTRA, this.c.getLogExtra()).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Boolean.class);
        }
    }

    private boolean sl() {
        lm lmVar = this.ab;
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
        this.zb = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms() {
        AdDownloadController adDownloadController = this.ny;
        return adDownloadController != null && adDownloadController.getDownloadMode() == 2;
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
        int i = this.sl;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.u.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.nw.d dVarMs = re.ms().ms(u.this.ab, u.this.d);
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
                    com.bytedance.sdk.openadsdk.core.nw.c cVarPh = u.this.ab.ph();
                    if (cVarPh == null) {
                        u.this.ab.ms(cVarKa);
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
                    if (u.this.u()) {
                        return;
                    }
                    u.this.ka.setAppIcon(cVarKa.c());
                    u.this.ka.setAppName(cVarKa.u());
                    u.this.ka.setPackageName(cVarKa.zb());
                    u.this.ms(dVarMs);
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
        lm lmVar = this.ab;
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
        lm lmVar = this.ab;
        if (lmVar == null || lmVar.tc() == null) {
            return false;
        }
        String strXr = this.ab.tc().xr();
        if (TextUtils.isEmpty(strXr)) {
            return false;
        }
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
        if (ms(getContext(), this.ab, this.x)) {
            return true;
        }
        ahVarXr.ms(dVar, this.x, this.d, new com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.u.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr
            public void ms() {
                u.this.y();
                u.this.xr(true);
            }
        });
        return true;
    }

    private boolean h() {
        if (this.hi == null || nw.y(this.ab) == 1 || nw.ch(this.ab) || !qv()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.u.3
            @Override // java.lang.Runnable
            public void run() {
                op.ms(u.this.getContext(), "应用正在下载...", 0);
            }
        });
        return false;
    }

    private boolean qv() {
        if (this.hi == null) {
            return false;
        }
        return ((Boolean) this.hi.call(6, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.d).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Boolean.class)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        final Map<String, Object> mapT = t();
        if (!ms()) {
            ms(16, mapT);
        } else {
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(mapT, new IDownloadButtonClickListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.u.4
                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleComplianceDialog(boolean z) {
                }

                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleMarketFailedComplianceDialog() {
                    if (mapT == null || u.this.ny == null) {
                        return;
                    }
                    u.this.ny.setDownloadMode(0);
                    u.this.xr().ms(u.this.d());
                    mapT.remove(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER);
                    if (u.this.zb()) {
                        return;
                    }
                    u.this.ms((com.bytedance.sdk.openadsdk.core.nw.d) null);
                }
            });
            ms(mapT);
        }
    }

    private void ms(final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.hi.ch.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.u.5
            @Override // java.lang.Runnable
            public void run() {
                u.this.ms(17, (Map<String, Object>) map);
            }
        }, this.ab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final int i, final Map<String, Object> map) {
        try {
            if (this.hi == null) {
                return;
            }
            if (sl()) {
                this.hi.call(13, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
                this.u = false;
            } else if (g.xr < 4500) {
                this.hi.call(i, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
                this.u = false;
            } else {
                map.put(TTDownloadField.TT_ITEM_CLICK_LISTENER, new OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.u.6
                    @Override // com.ss.android.download.api.config.OnItemClickListener
                    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
                        u.this.ch.setDownloadScene(1);
                        map.remove(TTDownloadField.TT_ITEM_CLICK_LISTENER);
                        u.this.hi.call(i, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
                    }
                });
                this.hi.call(i, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
                this.u = false;
            }
        } catch (Throwable unused) {
        }
    }

    private Map<String, Object> t() {
        if (sl()) {
            return new of().ms(TTDownloadField.TT_USERAGENT, null).ms(TTDownloadField.TT_IS_DISABLE_DIALOG, Boolean.TRUE).ms(TTDownloadField.TT_DOWNLOAD_MODEL, this.c).ms(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG, this.ch).ms(TTDownloadField.TT_DOWNLOAD_CONTROLLER, this.ny).ms(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER, null).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()));
        }
        return new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.d).ms("id", Long.valueOf(this.c.getId())).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_ACTION_TYPE_BUTTON, 2).ms(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG, this.ch).ms(TTDownloadField.TT_DOWNLOAD_CONTROLLER, this.ny);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(boolean z) {
        AdDownloadController adDownloadController;
        if (g.xr >= 5400 && z) {
            this.u = z;
            if (ms() && (adDownloadController = this.ny) != null) {
                try {
                    adDownloadController.setEnableOppoAutoDownload(true);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void d(boolean z) {
        this.ub = z;
    }

    private void nw() {
        AdDownloadController adDownloadController;
        if (g.xr < 5400 || !ms() || this.c == null || this.u || (adDownloadController = this.ny) == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(false);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ab() {
        if (this.hi != null) {
            this.hi.call(8, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.c.getDownloadUrl()).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_FORCE, Boolean.TRUE)).xr(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(int i) {
        this.sl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public Map<String, Object> ka() {
        return new HashMap();
    }
}
