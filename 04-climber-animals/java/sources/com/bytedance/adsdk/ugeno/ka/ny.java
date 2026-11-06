package com.bytedance.adsdk.ugeno.ka;

import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny implements hi {
    private com.bytedance.adsdk.ugeno.xr.ah ah;
    private boolean c;
    private com.bytedance.adsdk.ugeno.ah.c d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ms f375ms;
    private Map<String, com.bytedance.adsdk.ugeno.ka.ah.ms> xr;

    public ny(com.bytedance.adsdk.ugeno.xr.ah ahVar, ms msVar) {
        this.ah = ahVar;
        this.f375ms = msVar;
        if (msVar != null) {
            this.xr = msVar.f376ms;
        }
    }

    public void ms(com.bytedance.adsdk.ugeno.ah.c cVar) {
        this.d = cVar;
    }

    public void ms() {
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarMs = ms("shake");
        if (msVarMs != null) {
            msVarMs.ms(this);
            msVarMs.ms(new Object[0]);
        }
    }

    public void xr() {
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarMs = ms("twist");
        if (msVarMs != null) {
            msVarMs.ms(this);
            msVarMs.ms(new Object[0]);
        }
    }

    public void ah() {
        ms msVar = this.f375ms;
        if (msVar == null) {
            return;
        }
        for (Map.Entry<String, com.bytedance.adsdk.ugeno.ka.ah.ms> entry : msVar.f376ms.entrySet()) {
            if (entry != null) {
                com.bytedance.adsdk.ugeno.ka.ah.ms value = entry.getValue();
                if (value instanceof com.bytedance.adsdk.ugeno.ka.ah.xr) {
                    value.ms(this);
                    value.ms(new Object[0]);
                }
            }
        }
    }

    public void d() {
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarMs = ms("timer");
        if (msVarMs != null) {
            msVarMs.ms(this);
            msVarMs.ms(new Object[0]);
        }
    }

    public boolean ms(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarMs = ms("touchStart");
        if (msVarMs instanceof com.bytedance.adsdk.ugeno.ka.ah.ab) {
            msVarMs.ms(this);
            msVarMs.ms(motionEvent);
        }
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarMs2 = ms("touchEnd");
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarMs3 = ms("tap");
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarMs4 = ms("slide");
        if (msVarMs2 instanceof com.bytedance.adsdk.ugeno.ka.ah.c) {
            msVarMs2.ms(this);
            this.c = msVarMs2.ms(motionEvent);
        }
        if (msVarMs3 == null && msVarMs4 == null) {
            return this.c;
        }
        if (this.c && motionEvent.getAction() == 1) {
            return true;
        }
        if (msVarMs3 instanceof com.bytedance.adsdk.ugeno.ka.ah.d) {
            msVarMs3.ms(this);
            this.ka = msVarMs3.ms(motionEvent);
        }
        boolean z = this.ka;
        if (z) {
            return true;
        }
        if (!(msVarMs4 instanceof com.bytedance.adsdk.ugeno.ka.ah.ah)) {
            return z;
        }
        msVarMs4.ms(this);
        return msVarMs4.ms(motionEvent);
    }

    private void ms(String str, List<c.ms> list) {
        com.bytedance.adsdk.ugeno.ka.xr.ms msVarMs;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c.ms msVar : list) {
            if (msVar != null && (msVarMs = com.bytedance.adsdk.ugeno.ka.xr.ms.C0195ms.ms(this.ah, str, msVar)) != null) {
                msVarMs.ms();
            }
        }
    }

    public com.bytedance.adsdk.ugeno.ka.ah.ms ms(String str) {
        Map<String, com.bytedance.adsdk.ugeno.ka.ah.ms> map = this.xr;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.xr.get(str);
    }

    @Override // com.bytedance.adsdk.ugeno.ka.hi
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, List<c.ms> list) {
        ms(str, list);
    }

    public static ny ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str) {
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarMs;
        if (ahVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                ms msVar = new ms(new HashMap(), new HashMap());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (msVarMs = com.bytedance.adsdk.ugeno.ka.ah.ms.C0194ms.ms(ahVar.ny().getContext(), ahVar, jSONObjectOptJSONObject, ahVar.ch())) != null) {
                        msVar.f376ms.put(msVarMs.ab(), msVarMs);
                        msVar.xr.put(msVarMs.x(), msVarMs);
                    }
                }
                return new ny(ahVar, msVar);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
        return null;
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public Map<String, com.bytedance.adsdk.ugeno.ka.ah.ms> f376ms;
        public Map<String, com.bytedance.adsdk.ugeno.ka.ah.ms> xr;

        public ms(Map<String, com.bytedance.adsdk.ugeno.ka.ah.ms> map, Map<String, com.bytedance.adsdk.ugeno.ka.ah.ms> map2) {
            this.f376ms = map;
            this.xr = map2;
        }
    }
}
