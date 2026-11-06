package com.bytedance.sdk.openadsdk.core.hi;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.sdk.openadsdk.core.hi.ah.x {
    private Map<String, Object> w;
    private final com.bytedance.sdk.openadsdk.core.le.ms.ms.xr yu;

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

    public xr(Context context, lm lmVar, String str, boolean z) {
        super(context, lmVar, str, z);
        this.yu = new com.bytedance.sdk.openadsdk.core.le.ms.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.hi.xr.1
            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ms() {
                xr.this.ab.set(1);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    xr.this.ms("onIdle", 0L, 0L, null, null);
                } else if (xr.this.sl != null) {
                    xr.this.sl.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ms(Bridge bridge, Bridge bridge2) {
                if (bridge == null || bridge.values() == null) {
                    return;
                }
                xr.this.ab.set(2);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    xr.this.ms("onIdle", 0L, 0L, null, null);
                } else if (xr.this.sl != null) {
                    xr.this.sl.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ms(Bridge bridge, int i) {
                ValueSet valueSetValues;
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                xr.this.ab.set(3);
                xr.this.x.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    xr.this.ms("onDownloadActive", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), xr.this.d.ah());
                    return;
                }
                if (xr.this.sl != null) {
                    xr.this.sl.ms(valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), xr.this.d.ah());
                }
                if (xr.this.sl == null || xr.this.sl.ah() || xr.this.ka == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.b.ms.xr(xr.this.ka.xg());
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void xr(Bridge bridge, int i) {
                ValueSet valueSetValues;
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                xr.this.ab.set(4);
                xr.this.x.set(false);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    xr.this.ms("onDownloadPaused", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), xr.this.d.ah());
                } else if (xr.this.sl != null) {
                    xr.this.sl.xr(valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), xr.this.d.ah());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ms(Bridge bridge) {
                ValueSet valueSetValues;
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                xr.this.ab.set(5);
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    xr.this.ms("onDownloadFailed", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), xr.this.d.ah());
                } else if (xr.this.sl != null) {
                    xr.this.sl.ah(valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), xr.this.d.ah());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void xr(Bridge bridge) {
                ValueSet valueSetValues;
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                xr.this.ab.set(7);
                xr.this.x.set(true);
                String strStringValue = !TextUtils.isEmpty(valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME)) ? valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME) : "";
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    xr.this.ms("onInstalled", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), strStringValue, xr.this.d.ah());
                } else if (xr.this.sl != null) {
                    xr.this.sl.ms(strStringValue, xr.this.d.ah());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.xr
            public void ah(Bridge bridge) {
                ValueSet valueSetValues;
                xr.this.ab.set(6);
                if (bridge == null || (valueSetValues = bridge.values()) == null) {
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    xr.this.ms("onDownloadFinished", valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), xr.this.d.ah());
                } else if (xr.this.sl != null) {
                    xr.this.sl.ms(valueSetValues.longValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES), valueSetValues.stringValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME), xr.this.d.ah());
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public void ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.c, this.ka, (JSONObject) null, ch());
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.ka, ch(), z);
        this.w = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms() {
        return this.b != null && com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.b, ch()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public synchronized void xr() {
        h();
        this.ch.set(true);
        if (this.b != null) {
            this.b.call(5, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER, this.yu)).xr(), Void.class);
        }
    }

    private void h() {
        com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = this.ka.zh();
        if (kaVarZh != null) {
            this.w.put("download_url", kaVarZh.xr());
        }
        this.w.put("download_status_listener", this.yu);
        this.w.put("event_tag", this.c);
        this.w.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.xr.2
            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
            public boolean ms(Map<String, Object> map) {
                xr xrVar = xr.this;
                return xrVar.ms(xrVar.getContext(), xr.this.ka, xr.this.c);
            }
        });
        this.w.put("download_popup_manager", hi());
        this.w.put("download_manager_hash_code", Integer.valueOf(hashCode()));
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
        this.w.put("need_check_compliance", Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public Map<String, Object> ka() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(boolean z) {
        this.w.put("is_open_oppo_market_auto_download", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public void ah(boolean z) {
        this.w.put("convert_from_landing_page", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    protected synchronized void c() {
        if (this.d == null) {
            return;
        }
        if (this.b != null && g.xr >= 6400 && !g.c()) {
            com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms((com.bytedance.sdk.openadsdk.core.le.ms.ms.ah) null, ch());
        }
        if (this.ch != null && this.ch.get()) {
            this.ch.set(false);
            if (this.b != null) {
                this.b.call(4, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
            }
        }
        zb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void xr(JSONObject jSONObject, boolean z) {
        if (com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms()) {
            f.le();
            HashMap map = new HashMap();
            map.put("material_meta", this.ka);
            map.put(com.umeng.analytics.pro.g.X, getContext());
            map.put("is_market_covert", Boolean.valueOf(ms()));
            com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = this.ka.zh();
            if (kaVarZh != null) {
                map.put("download_url", kaVarZh.xr());
            }
            map.putAll(this.w);
            map.put("download_status_listener", this.yu);
            map.put("event_tag", this.c);
            map.put("source", Integer.valueOf(f.xr(this.c)));
            map.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.xr.3
                @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
                public boolean ms(Map<String, Object> map2) {
                    xr xrVar = xr.this;
                    return xrVar.ms(xrVar.getContext(), xr.this.ka, xr.this.c);
                }
            });
            map.put("download_popup_manager", hi());
            map.putAll(com.bytedance.sdk.component.hi.ka.ms.ms().ms(this.ka.hashCode() + this.ka.eu()));
            map.put("convert_from_downloader", Boolean.TRUE);
            map.put("download_manager_hash_code", Integer.valueOf(ch()));
            map.put("is_feed_register_direct_download", Boolean.valueOf(z));
            HashMap map2 = new HashMap();
            map.put("download_manager_hash_code", Integer.valueOf(ch()));
            com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms(this.ka, map2, "clickEvent", map, this.c, new HashMap());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ab() {
        if (this.d == null) {
            return;
        }
        this.ch.set(false);
        if (this.b != null) {
            this.b.call(8, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_FORCE, Boolean.TRUE).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
        }
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void d(boolean z) {
        this.i = z;
        this.w.put("is_click_button", Boolean.valueOf(z));
    }
}
