package com.bytedance.sdk.openadsdk.core.xr.ms.ms;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.anythink.core.common.e.a;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.umeng.analytics.pro.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends xr {
    private int ab;
    private boolean ny;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.ab x;

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr, com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        boolean z;
        xr(this.f3767ms.jr());
        d();
        final xr.ms msVarMs = this.ka.ms();
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.ms.ny.1
            @Override // java.lang.Runnable
            public void run() {
                xr.ms msVar = msVarMs;
                if (msVar != null) {
                    msVar.ms(ny.this.d, ny.this.ka.d());
                }
            }
        });
        Map<String, Object> mapCh = this.ka.ch();
        String strB = this.ah.b();
        if (TextUtils.isEmpty(strB)) {
            strB = "clickEvent";
        }
        String str = strB;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        mapCh.put("click_from_uchain", 1);
        mapCh.put(a.C0080a.b, str);
        f.le();
        HashMap map2 = new HashMap();
        map2.put("material_meta", this.f3767ms);
        map2.put("click_chain", ahVar);
        map2.put("dpa_tag", this.ah.t());
        map2.put(g.X, this.xr);
        map2.put("event_tag", this.ka.hi());
        map2.put("source", Integer.valueOf(this.ka.ny()));
        map2.put("view", this.d);
        if (this.d instanceof TextView) {
            CharSequence text = ((TextView) this.d).getText();
            z = text != null && (text.toString().contains("下载") || text.toString().contains("安装"));
            if (this.d instanceof Button) {
                z = true;
            }
        } else {
            z = false;
        }
        map2.put("is_click_button", Boolean.valueOf(z || this.ah.ms()));
        map2.put("handle_chain_data", map);
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarX = this.ka.x();
        if (ahVarX != null) {
            map2.put("download_adapter", ahVarX);
            map2.put("is_market_covert", Boolean.valueOf(ahVarX.ms()));
            map2.putAll(ahVarX.ka());
        }
        Map<String, Object> mapMs = com.bytedance.sdk.component.hi.ka.ms.ms().ms(this.f3767ms.hashCode() + this.f3767ms.eu());
        this.x = (com.bytedance.sdk.openadsdk.core.video.nativevideo.ab) i.ms(this.f3767ms.xg(), com.bytedance.sdk.openadsdk.core.video.nativevideo.ab.class);
        Object objRemove = mapMs.remove("is_express_ad");
        if (objRemove instanceof Boolean) {
            this.ny = ((Boolean) objRemove).booleanValue();
        }
        map2.put("is_video_lp", Boolean.valueOf(ny()));
        map2.putAll(mapMs);
        map2.put("convert_from_downloader", Boolean.FALSE);
        map2.put("convert_from_landing_page", Boolean.valueOf(this.ka.ah()));
        map2.put("pip_controller", this.ka.qv());
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms(this.f3767ms, this.xr, this.ka.hi(), this.ka.ny());
        msVar.ms(!ny() && this.ka.ka());
        msVar.xr(this.ka.sl());
        map2.put("is_open_web_page", Boolean.FALSE);
        msVar.xr(map2);
        map2.put("activity_type", Integer.valueOf(f.ms(msVar.ms())));
        map2.put("is_feed_register_direct_download", Boolean.valueOf(this.ah.ms()));
        com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms(this.f3767ms, mapCh, str, map2, this.ka.hi(), new HashMap());
        ka();
        return 0;
    }

    private boolean ny() {
        return ch() && xr(this.d) && !this.ka.ah();
    }

    private boolean xr(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387670 || view.getId() == 2114387957 || view.getId() == 2114387770 || view.getId() == 2114387692 || view.getId() == 2114387632) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (xr(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean ch() {
        if (this.f3767ms == null || hi() || !lm.xr(this.f3767ms)) {
            return false;
        }
        if (this.ab == 0) {
            this.ab = f.x(this.f3767ms);
        }
        c();
        x();
        ab();
        if (this.ab == 5 && sl() && x() && !c() && !ab()) {
            return false;
        }
        int i = this.ab;
        return i == 1 || i == 2 || i == 5;
    }

    private boolean hi() {
        return this.ny;
    }

    public boolean c() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.ab abVar = this.x;
        if (abVar == null) {
            return false;
        }
        return abVar.ms();
    }

    public boolean ab() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.ab abVar = this.x;
        if (abVar == null) {
            return false;
        }
        return abVar.xr();
    }

    protected boolean x() {
        if (this.f3767ms == null) {
            return true;
        }
        int iAb = re.xr().ab(f.ny(this.f3767ms));
        if (iAb == 1) {
            return u.d(this.xr);
        }
        if (iAb == 2) {
            return u.ka(this.xr) || u.d(this.xr) || u.c(this.xr);
        }
        if (iAb != 3) {
            return iAb != 5 || u.d(this.xr) || u.c(this.xr);
        }
        return false;
    }

    private boolean sl() {
        return this.f3767ms != null && this.f3767ms.ti() == 1 && lm.xr(this.f3767ms);
    }
}
