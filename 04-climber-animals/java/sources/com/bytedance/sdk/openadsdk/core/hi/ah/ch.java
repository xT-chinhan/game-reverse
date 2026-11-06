package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ul;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadController;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends x {
    private final DownloadStatusChangeListener le;
    private DownloadModel op;
    private AdDownloadController w;
    private DownloadEventConfig yu;

    public ch(Context context, lm lmVar, String str, boolean z) {
        super(context, lmVar, str, z);
        this.le = new DownloadStatusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.1
            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onIdle() {
                ch.this.ab.set(1);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ch.this.ms("onIdle", 0L, 0L, (String) null, (String) null);
                } else if (ch.this.sl != null) {
                    ch.this.sl.ms();
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
                ch.this.ab.set(2);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ch.this.ms("onIdle", 0L, 0L, (String) null, (String) null);
                } else if (ch.this.sl != null) {
                    ch.this.sl.ms();
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
                ch.this.ab.set(3);
                ch.this.x.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ch.this.ms("onDownloadActive", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ch.this.d.ah());
                    return;
                }
                if (ch.this.sl != null) {
                    ch.this.sl.ms(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ch.this.d.ah());
                }
                if (ch.this.sl == null || ch.this.sl.ah() || ch.this.ka == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.b.ms.xr(ch.this.ka.xg());
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
                ch.this.ab.set(4);
                ch.this.x.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ch.this.ms("onDownloadPaused", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ch.this.d.ah());
                } else if (ch.this.sl != null) {
                    ch.this.sl.xr(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ch.this.d.ah());
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
                ch.this.ab.set(5);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ch.this.ms("onDownloadFailed", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ch.this.d.ah());
                } else if (ch.this.sl != null) {
                    ch.this.sl.ah(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ch.this.d.ah());
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onInstalled(DownloadShortInfo downloadShortInfo) {
                ch.this.ab.set(7);
                ch.this.x.set(true);
                String str2 = !TextUtils.isEmpty(downloadShortInfo.fileName) ? downloadShortInfo.fileName : "";
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ch.this.ms("onInstalled", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, str2, ch.this.d.ah());
                } else if (ch.this.sl != null) {
                    ch.this.sl.ms(str2, ch.this.d.ah());
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
                ch.this.ab.set(6);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    ch.this.ms("onDownloadFinished", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ch.this.d.ah());
                } else if (ch.this.sl != null) {
                    ch.this.sl.ms(downloadShortInfo.totalBytes, downloadShortInfo.fileName, ch.this.d.ah());
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public void ms(boolean z) {
        this.op = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(this.c, this.ka, null).build();
        this.w = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(this.ka, z).build();
        this.yu = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(this.c).build();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public synchronized void c() {
        if (this.d == null) {
            return;
        }
        if (this.w != null && g.xr >= 6400 && !g.c()) {
            this.w.setDownloadMarketInterceptor(null);
        }
        if (this.ch != null && this.ch.get()) {
            this.ch.set(false);
            if (this.b != null) {
                this.b.call(4, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_DOWNLOAD_URL, this.op.getDownloadUrl())).xr(), Void.class);
            }
        }
        zb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public synchronized void xr() {
        if (this.d == null) {
            return;
        }
        this.ch.set(true);
        if (this.b != null) {
            this.b.call(5, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER, this.le).ms(TTDownloadField.TT_DOWNLOAD_MODEL, this.op)).xr(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(JSONObject jSONObject, boolean z) {
        c(jSONObject, z);
    }

    private void c(JSONObject jSONObject, final boolean z) {
        qv();
        if (getContext() == null || this.d == null || !ub()) {
            return;
        }
        final of<String, Object> ofVarMs = new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.d.xr()).ms("id", Long.valueOf(this.op.getId())).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_ACTION_TYPE_BUTTON, 2).ms(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG, com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(this.yu, jSONObject)).ms(TTDownloadField.TT_DOWNLOAD_CONTROLLER, this.w);
        if (ms()) {
            IDownloadButtonClickListener iDownloadButtonClickListener = new IDownloadButtonClickListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.2
                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleComplianceDialog(boolean z2) {
                }

                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleMarketFailedComplianceDialog() {
                    if (ofVarMs == null || ch.this.w == null) {
                        return;
                    }
                    ch.this.w.setDownloadMode(0);
                    ch.this.hi().ms(ch.this.ao());
                    ofVarMs.remove(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER);
                    if (ch.this.ms((com.bytedance.sdk.openadsdk.core.nw.d) null, (IDownloadButtonClickListener) null, (Map<String, Object>) ofVarMs, z)) {
                        return;
                    }
                    ch.this.xr((Map<String, Object>) ofVarMs);
                }
            };
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(ofVarMs, iDownloadButtonClickListener);
            if (ms((com.bytedance.sdk.openadsdk.core.nw.d) null, iDownloadButtonClickListener, ofVarMs, z)) {
                return;
            }
            xr(true);
            ms(ofVarMs, iDownloadButtonClickListener);
            return;
        }
        ms(ofVarMs, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final Map<String, Object> map, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.bytedance.sdk.openadsdk.core.hi.ch.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.3
            @Override // java.lang.Runnable
            public void run() {
                ch.this.ms(iDownloadButtonClickListener, (Map<String, Object>) map);
            }
        }, this.ka);
        this.re = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(IDownloadButtonClickListener iDownloadButtonClickListener, Map<String, Object> map) {
        try {
            if (iDownloadButtonClickListener == null) {
                ms(map);
                this.re = false;
            } else {
                xr(iDownloadButtonClickListener, map);
                this.re = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void xr(IDownloadButtonClickListener iDownloadButtonClickListener, final Map<String, Object> map) {
        if (this.b == null) {
            return;
        }
        final of<String, Object> ofVarMs = new of().ms(TTDownloadField.TT_ITEM_CLICK_LISTENER, null).ms(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER, iDownloadButtonClickListener).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(map);
        if (g.xr < 4500) {
            this.b.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVarMs).xr(), Void.class);
        } else {
            ofVarMs.put(TTDownloadField.TT_ITEM_CLICK_LISTENER, new OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.4
                @Override // com.ss.android.download.api.config.OnItemClickListener
                public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
                    if (!ch.this.h && !ch.this.ka.sh()) {
                        ul.ms(ch.this.getContext(), ch.this.ka.ir(), ch.this.ka, ch.this.c);
                        return;
                    }
                    Object obj = map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG);
                    if (obj instanceof DownloadEventConfig) {
                        ((DownloadEventConfig) obj).setDownloadScene(1);
                        ofVarMs.remove(TTDownloadField.TT_ITEM_CLICK_LISTENER);
                        ch.this.b.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVarMs).xr(), Void.class);
                    }
                }
            });
            this.b.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVarMs).xr(), Void.class);
        }
    }

    private void ms(final Map<String, Object> map, final boolean z) {
        int i = this.nw;
        if (i == 1) {
            ub.ms(re.getContext());
        } else if (i == 2) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.nw.d dVarMs = re.ms().ms(ch.this.ka, ch.this.d.xr());
                    if (dVarMs != null && dVarMs.ka()) {
                        ch.this.ms(dVarMs, (Map<String, Object>) map, z);
                    } else {
                        ub.ms(re.getContext());
                    }
                }
            });
        } else {
            ms((com.bytedance.sdk.openadsdk.core.nw.d) null, map, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final Map<String, Object> map) {
        if (this.nw == 1) {
            return;
        }
        if (this.nw == 2) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("tt_market_download_check") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.nw.d dVarMs = re.ms().ms(ch.this.ka, ch.this.d.xr());
                    if (dVarMs == null || !dVarMs.ka()) {
                        return;
                    }
                    nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ch.this.ms((IDownloadButtonClickListener) null, (Map<String, Object>) map);
                        }
                    });
                }
            });
        } else {
            ms((IDownloadButtonClickListener) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final com.bytedance.sdk.openadsdk.core.nw.d dVar, final Map<String, Object> map, final boolean z) {
        ms(new IDownloadButtonClickListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.7
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z2) {
                if (z2 && ch.this.ms(dVar, (IDownloadButtonClickListener) null, (Map<String, Object>) map, z)) {
                    return;
                }
                ch.this.ms((IDownloadButtonClickListener) null, (Map<String, Object>) map);
            }
        }, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms() {
        AdDownloadController adDownloadController = this.w;
        return adDownloadController != null && adDownloadController.getDownloadMode() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ab() {
        if (this.d == null) {
            return;
        }
        this.ch.set(false);
        if (this.b != null) {
            this.b.call(8, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.op.getDownloadUrl()).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_FORCE, Boolean.TRUE)).xr(), Void.class);
        }
        xr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(com.bytedance.sdk.openadsdk.core.nw.d dVar, final IDownloadButtonClickListener iDownloadButtonClickListener, final Map<String, Object> map, boolean z) {
        com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVarHi = hi();
        if (!ahVarHi.d(z)) {
            return false;
        }
        if (ms(getContext(), this.ka, this.c)) {
            return true;
        }
        ahVarHi.ms(dVar, this.c, this.d.xr(), new com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.8
            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr
            public void ms() {
                if (!ch.this.ms()) {
                    ch.this.ms(iDownloadButtonClickListener, (Map<String, Object>) map);
                } else {
                    ch.this.xr(true);
                    ch.this.ms((Map<String, Object>) map, iDownloadButtonClickListener);
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(boolean z) {
        if (g.xr >= 5400 && z) {
            this.re = z;
            if (ms() && this.w != null) {
                try {
                    h();
                    this.w.setEnableOppoAutoDownload(true);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ah("xgc1", "throwable", th);
                }
            }
        }
    }

    private void h() {
        if (this.ka == null) {
            return;
        }
        String strDa = this.ka.da();
        if (TextUtils.isEmpty(strDa) || g.xr < 6400 || g.c()) {
            return;
        }
        final String strEu = this.ka.eu();
        final String strCz = this.ka.cz();
        final com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) i.ms(strDa, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
        com.bytedance.sdk.component.utils.sl.ms("do", "listener == null " + (msVar == null));
        if (msVar != null && !TextUtils.isEmpty(this.ka.zm()) && this.ka.mh().d() == 1) {
            this.w.setDownloadMarketInterceptor(new DownloadMarketInterceptor() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ch.9
                @Override // com.ss.android.download.api.config.DownloadMarketInterceptor
                public Map<String, Object> interceptObmMarket(Map<String, Object> map) {
                    if (map != null) {
                        if (!ch.this.i) {
                            map.put("is_button", Boolean.FALSE);
                        }
                        Object obj = map.get("is_button");
                        msVar.ms(100, map);
                        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(map, obj, strEu, strCz);
                    } else {
                        com.bytedance.sdk.openadsdk.core.t.u uVarMs = com.bytedance.sdk.openadsdk.core.t.u.ms();
                        Boolean bool = Boolean.FALSE;
                        uVarMs.ms(bool, bool, "site param is null", strEu, strCz);
                    }
                    return map;
                }
            });
        } else {
            this.w.setDownloadMarketInterceptor(null);
        }
    }

    private void qv() {
        if (g.xr < 5400 || !ms() || this.re || this.op == null || this.w == null) {
            return;
        }
        try {
            if (g.xr >= 6400 && !g.c()) {
                this.w.setDownloadMarketInterceptor(null);
            }
            this.w.setEnableOppoAutoDownload(false);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ah("xgc_dof", "throwable", th);
        }
    }
}
