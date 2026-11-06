package com.byazt.ye;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.view.View;
import com.byazt.af.w;
import com.byazt.hg.of;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 475, 5})
public class uc implements com.byazt.ni.pr {
    public Map<String, Object> aj;
    public int c;
    public Map<String, Object> fw;
    public String hn;
    public Context hw;
    public com.byazt.ni.pr pr;
    public View uc;
    public String x;
    public w zo;

    public uc(w wVar, Context context, String str, String str2, Map<String, Object> map) {
        this.zo = wVar;
        this.hw = context;
        this.hn = str;
        this.x = str2;
        this.aj = map;
        hw();
    }

    @Override // com.byazt.ni.pr
    public boolean pr(Map<String, Object> map) {
        boolean zPr = pr();
        hw();
        if (zPr) {
            return true;
        }
        HashMap map2 = new HashMap(2);
        map2.put("event_tag", this.hn);
        if (!TextUtils.isEmpty(this.x)) {
            map2.put("dpa_tag", this.x);
        }
        map2.put("material_meta", hn());
        int iPr = com.byazt.eg.hw.pr().pr(this.hw, this.zo, map2) & 255;
        hn(iPr);
        if (iPr == 0) {
            return true;
        }
        com.byazt.ni.pr prVar = this.pr;
        return prVar != null && prVar.pr(map);
    }

    private boolean pr() {
        if (this.c < 2) {
            return false;
        }
        HashMap map = new HashMap(2);
        if (pr(this.c)) {
            map.put("live_saas_param_interaction_type", Integer.valueOf(this.c));
        }
        if (this.aj.containsKey("saas_status_while_click")) {
            map.put("saas_status_while_click", this.aj.get("saas_status_while_click"));
        }
        map.put("event_tag", this.hn);
        String str = this.x;
        if (str != null) {
            map.put("dpa_tag", str);
        }
        map.put("material_meta", hn());
        if (this.fw == null) {
            this.fw = new HashMap();
        }
        com.byazt.eg.hw.pr().pr(this.uc, this.zo.w(), map, this.fw);
        int iPr = com.byazt.eg.hw.pr().pr(this.hw, this.zo, map);
        int i = iPr & 255;
        int i2 = (iPr & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            this.fw.put("click_saas_action", Integer.valueOf(i2));
        }
        return i == 0;
    }

    public static boolean pr(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    public void hw(Map<String, Object> map) {
        this.fw = map;
    }

    private void hw() {
        w wVar = this.zo;
        if (wVar != null) {
            this.c = wVar.c();
        } else {
            this.c = -1;
        }
    }

    public void hw(int i) {
        this.c = i;
    }

    public void pr(View view) {
        this.uc = view;
    }

    private of hn() {
        return com.byazt.lx.hw.pr(this.zo, this.aj);
    }

    private void hn(int i) {
        com.byazt.wb.x xVar;
        switch (i) {
            case 0:
                xVar = com.byazt.wb.x.hn;
                break;
            case 1:
                xVar = com.byazt.wb.x.c;
                break;
            case 2:
            default:
                xVar = com.byazt.wb.x.x;
                break;
            case 3:
                xVar = com.byazt.wb.x.fw;
                break;
            case 4:
                xVar = com.byazt.wb.x.uc;
                break;
        }
        com.byazt.lx.hw.pr(this.aj, xVar);
    }
}
