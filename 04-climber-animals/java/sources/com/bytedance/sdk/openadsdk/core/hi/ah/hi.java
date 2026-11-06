package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadController;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends x {
    private final DownloadStatusChangeListener le;
    private Map<String, Object> op;
    private AdDownloadController w;
    private DownloadModel yu;

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ah() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public boolean d() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms(JSONObject jSONObject, boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms(boolean z, boolean z2) {
        return false;
    }

    public hi(Context context, lm lmVar, String str, boolean z) {
        super(context, lmVar, str, z);
        this.le = new DownloadStatusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.hi.1
            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onIdle() {
                hi.this.ab.set(1);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    hi.this.ms("onIdle", 0L, 0L, null, null);
                } else if (hi.this.sl != null) {
                    hi.this.sl.ms();
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
                hi.this.ab.set(2);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    hi.this.ms("onIdle", 0L, 0L, null, null);
                } else if (hi.this.sl != null) {
                    hi.this.sl.ms();
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
                hi.this.ab.set(3);
                hi.this.x.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    hi.this.ms("onDownloadActive", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, hi.this.d.ah());
                    return;
                }
                if (hi.this.sl != null) {
                    hi.this.sl.ms(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, hi.this.d.ah());
                }
                if (hi.this.sl == null || hi.this.sl.ah() || hi.this.ka == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.b.ms.xr(hi.this.ka.xg());
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
                hi.this.ab.set(4);
                hi.this.x.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    hi.this.ms("onDownloadPaused", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, hi.this.d.ah());
                } else if (hi.this.sl != null) {
                    hi.this.sl.xr(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, hi.this.d.ah());
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
                hi.this.ab.set(5);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    hi.this.ms("onDownloadFailed", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, hi.this.d.ah());
                } else if (hi.this.sl != null) {
                    hi.this.sl.ah(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, hi.this.d.ah());
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onInstalled(DownloadShortInfo downloadShortInfo) {
                hi.this.ab.set(7);
                hi.this.x.set(true);
                String str2 = !TextUtils.isEmpty(downloadShortInfo.fileName) ? downloadShortInfo.fileName : "";
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    hi.this.ms("onInstalled", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, str2, hi.this.d.ah());
                } else if (hi.this.sl != null) {
                    hi.this.sl.ms(str2, hi.this.d.ah());
                }
            }

            @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
            public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
                hi.this.ab.set(6);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    hi.this.ms("onDownloadFinished", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, hi.this.d.ah());
                } else if (hi.this.sl != null) {
                    hi.this.sl.ms(downloadShortInfo.totalBytes, downloadShortInfo.fileName, hi.this.d.ah());
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public void ms(boolean z) {
        this.yu = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(this.c, this.ka, null).build();
        this.w = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(this.ka, z).build();
        this.op = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms() {
        AdDownloadController adDownloadController = this.w;
        return adDownloadController != null && adDownloadController.getDownloadMode() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public synchronized void c() {
        if (this.w != null && g.xr >= 6400 && !g.c()) {
            this.w.setDownloadMarketInterceptor(null);
        }
        if (this.ch != null && this.ch.get()) {
            this.ch.set(false);
            if (this.b != null) {
                of<String, Object> ofVarMs = new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()));
                DownloadModel downloadModel = this.yu;
                this.b.call(4, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, ofVarMs.ms(TTDownloadField.TT_DOWNLOAD_URL, downloadModel != null ? downloadModel.getDownloadUrl() : "")).xr(), Void.class);
            }
        }
        zb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public synchronized void xr() {
        h();
        this.ch.set(true);
        if (this.b != null) {
            this.b.call(5, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER, this.le).ms(TTDownloadField.TT_DOWNLOAD_MODEL, this.yu)).xr(), Void.class);
        }
    }

    private void h() {
        this.op.put("download_model", this.yu);
        this.op.put("download_controller", this.w);
        com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = this.ka.zh();
        if (kaVarZh != null) {
            this.op.put("download_url", kaVarZh.xr());
        }
        this.op.put("download_status_listener", this.le);
        this.op.put("event_tag", this.c);
        this.op.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.hi.2
            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
            public boolean ms(Map<String, Object> map) {
                hi hiVar = hi.this;
                return hiVar.ms(hiVar.getContext(), hi.this.ka, hi.this.c);
            }
        });
        this.op.put("download_popup_manager", hi());
        this.op.put("download_manager_hash_code", Integer.valueOf(hashCode()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(JSONObject jSONObject, boolean z) {
        if (com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms()) {
            f.le();
            HashMap map = new HashMap();
            map.put("material_meta", this.ka);
            map.put(com.umeng.analytics.pro.g.X, getContext());
            map.put("is_market_covert", Boolean.valueOf(ms()));
            map.put("download_model", this.yu);
            map.put("download_controller", this.w);
            com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = this.ka.zh();
            if (kaVarZh != null) {
                map.put("download_url", kaVarZh.xr());
            }
            Map<String, Object> map2 = this.op;
            if (map2 != null) {
                map.putAll(map2);
            }
            map.put("download_status_listener", this.le);
            map.put("event_tag", this.c);
            map.put("source", Integer.valueOf(f.xr(this.c)));
            map.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.hi.3
                @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
                public boolean ms(Map<String, Object> map3) {
                    hi hiVar = hi.this;
                    return hiVar.ms(hiVar.getContext(), hi.this.ka, hi.this.c);
                }
            });
            map.put("download_popup_manager", hi());
            map.putAll(com.bytedance.sdk.component.hi.ka.ms.ms().ms(this.ka.hashCode() + this.ka.eu()));
            map.put("convert_from_downloader", Boolean.TRUE);
            map.put("download_manager_hash_code", Integer.valueOf(ch()));
            map.put("is_feed_register_direct_download", Boolean.valueOf(z));
            HashMap map3 = new HashMap();
            map.put("download_manager_hash_code", Integer.valueOf(ch()));
            com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms(this.ka, map3, "clickEvent", map, this.c, new HashMap());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ab() {
        if (this.ch != null) {
            this.ch.set(false);
        }
        if (this.b != null) {
            com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
            of ofVar = new of();
            DownloadModel downloadModel = this.yu;
            this.b.call(8, xrVarMs.ms(0, ofVar.ms(TTDownloadField.TT_DOWNLOAD_URL, downloadModel != null ? downloadModel.getDownloadUrl() : "").ms(TTDownloadField.TT_FORCE, Boolean.TRUE).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
        }
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(lm lmVar, boolean z) {
        if (getContext() == null) {
            return;
        }
        xr(f.y(lmVar), z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(int i) {
        this.op.put("need_check_compliance", Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public Map<String, Object> ka() {
        return this.op;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public void ah(boolean z) {
        this.op.put("convert_from_landing_page", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(boolean z) {
        this.op.put("is_open_oppo_market_auto_download", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void d(boolean z) {
        this.i = z;
        this.op.put("is_click_button", Boolean.valueOf(z));
    }
}
