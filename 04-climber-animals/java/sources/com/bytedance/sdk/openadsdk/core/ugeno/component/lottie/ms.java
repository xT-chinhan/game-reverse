package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.nw;
import com.bytedance.adsdk.lottie.ny;
import com.bytedance.adsdk.lottie.t;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    private View nl;
    private boolean r;

    public ms(Context context) {
        super(context);
        this.r = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr, com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab */
    public UgenLottieView ms() {
        UgenLottieView ugenLottieViewMs = super.ms();
        ugenLottieViewMs.setTextDelegate(new t(ugenLottieViewMs) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms.1
            @Override // com.bytedance.adsdk.lottie.t
            public String ms(String str) {
                return com.bytedance.adsdk.ugeno.d.xr.ms(str, ms.this.d);
            }
        });
        ugenLottieViewMs.setViewDelegate(new nw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms.2
            @Override // com.bytedance.adsdk.lottie.nw
            public View ms(String str, Map<String, Object> map) {
                if (!"view:".equals(str) || map == null || map.isEmpty()) {
                    return null;
                }
                if (!ms.this.r) {
                    ms.this.r = true;
                    ms.this.ms(map);
                }
                return ms.this.nl;
            }
        });
        ugenLottieViewMs.setLottieClicklistener(new LottieAnimationView.xr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms.3
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.xr
            public void ms(String str, JSONArray jSONArray) {
                zb zbVar = new zb();
                zbVar.ms(1);
                zbVar.ms(ms.this);
                if (jSONArray != null && jSONArray.length() > 0) {
                    ms.this.ms(zbVar, jSONArray);
                }
                if (ms.this.z != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lottieEvent", true);
                        jSONObject.put("uttieUrl", ms.this.f3472ms);
                        if (TextUtils.equals("CSJCLOSE", str)) {
                            jSONObject.put("type", ILivePush.ClickType.CLOSE);
                        } else if (TextUtils.equals("clickEvent", str)) {
                            jSONObject.put("type", "clickEvent");
                        }
                        zbVar.ms(jSONObject);
                        ub ubVar = ms.this.z;
                        ms msVar = ms.this;
                        ubVar.ms(zbVar, msVar, msVar);
                    } catch (JSONException e) {
                        sl.ms(e);
                    }
                }
            }
        });
        ugenLottieViewMs.setLottieAnimListener(new LottieAnimationView.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms.4
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.ms
            public void ms(Map<String, Object> map) {
                ms.this.ms(map, 19);
            }

            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.ms
            public void xr(Map<String, Object> map) {
                ms.this.ms(map, 20);
            }
        });
        return ugenLottieViewMs;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms$5, reason: invalid class name */
    class AnonymousClass5 implements d {
        AnonymousClass5() {
        }

        @Override // com.bytedance.adsdk.lottie.d
        public Bitmap ms(final ny nyVar) {
            final String strMs;
            if (nyVar == null) {
                return null;
            }
            String strZb = nyVar.zb();
            String strSl = nyVar.sl();
            String strD = nyVar.d();
            if (!TextUtils.isEmpty(strD) && strD.startsWith("${") && "image:".equals(strZb)) {
                strMs = com.bytedance.adsdk.ugeno.d.xr.ms(strD, ms.this.d);
            } else if (!TextUtils.isEmpty(strZb) && TextUtils.isEmpty(strSl)) {
                strMs = com.bytedance.adsdk.ugeno.d.xr.ms(strZb, ms.this.d);
            } else if (!TextUtils.isEmpty(strSl) && TextUtils.isEmpty(strZb)) {
                strMs = com.bytedance.adsdk.ugeno.d.xr.ms(strSl, ms.this.d);
            } else {
                strMs = (TextUtils.isEmpty(strSl) || TextUtils.isEmpty(strZb)) ? null : com.bytedance.adsdk.ugeno.d.xr.ms(strZb, ms.this.d) + com.bytedance.adsdk.ugeno.d.xr.ms(strSl, ms.this.d);
            }
            if (TextUtils.isEmpty(strMs)) {
                return null;
            }
            Bitmap bitmap = ms.this.vf.get(strMs);
            if (bitmap != null) {
                return bitmap;
            }
            com.bytedance.adsdk.ugeno.d.ms().xr().ms(ms.this.ny, strMs, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms.5.1
                @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
                public void ms(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, nyVar.ms(), nyVar.xr(), false);
                        ms.this.vf.put(strMs, bitmapCreateScaledBitmap);
                        x.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((UgenLottieView) ms.this.ka).ms(nyVar.hi(), bitmapCreateScaledBitmap);
                            }
                        });
                    }
                }
            });
            return ms.this.vf.get(strMs);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr
    protected void x() {
        if (this.ka == 0 || ((UgenLottieView) this.ka).getVisibility() != 0) {
            return;
        }
        ((UgenLottieView) this.ka).setImageAssetDelegate(new AnonymousClass5());
        ((UgenLottieView) this.ka).ms();
        am();
    }

    private void am() {
        zb zbVar = new zb();
        zbVar.ms(21);
        zbVar.ms(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            jSONObject.put("uttieUrl", this.f3472ms);
            zbVar.ms(jSONObject);
            this.z.ms(zbVar, this, this);
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Map<String, Object> map, int i) {
        zb zbVar = new zb();
        zbVar.ms(i);
        zbVar.ms(this);
        if (map != null) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ms(zbVar, (JSONArray) obj);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            if (map != null) {
                Object obj2 = map.get("duration");
                if (obj2 instanceof Long) {
                    jSONObject.put("duration", obj2);
                    jSONObject.put("uttieUrl", this.f3472ms);
                }
            }
            zbVar.ms(jSONObject);
            this.z.ms(zbVar, this, this);
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(zb zbVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("vid");
                    if (!TextUtils.isEmpty(strOptString)) {
                        int iOptInt = jSONObjectOptJSONObject.optInt(LiveConfigKey.HIGH, 0);
                        ah ahVarMs = ms(zbVar.ms(), strOptString);
                        if (ahVarMs != null) {
                            ahVarMs.xr(iOptInt == 0 ? 0 : 8);
                            View viewNy = ahVarMs.ny();
                            if (viewNy instanceof UgenLottieView) {
                                UgenLottieView ugenLottieView = (UgenLottieView) viewNy;
                                if (iOptInt == 0) {
                                    ugenLottieView.ms();
                                    am();
                                } else {
                                    ugenLottieView.c();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ah ms(ah ahVar, String str) {
        if (ahVar == null) {
            return null;
        }
        while (ahVar.g() != null) {
            ahVar = ahVar.g();
        }
        return ahVar.ah(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Map<String, Object> map) {
        Object obj = map.get("ugen_url");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("ugen_md5");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("ugen_v");
        final String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("ugen_w");
        final int iIntValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
        Object obj5 = map.get("ugen_h");
        final int iIntValue2 = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        JSONObject jSONObjectXr = ch.xr(str2, str);
        if (jSONObjectXr != null && jSONObjectXr.length() > 0) {
            ms(jSONObjectXr, iIntValue, iIntValue2, str3);
        } else {
            ch.ms(str2, str, new com.bytedance.sdk.openadsdk.core.ugeno.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms.6
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.ah
                public void ms(String str4) {
                    try {
                        ms.this.ms(new JSONObject(str4), iIntValue, iIntValue2, str3);
                    } catch (Throwable th) {
                        sl.ms(th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(JSONObject jSONObject, int i, int i2, String str) {
        ah<View> ahVarMs;
        com.bytedance.adsdk.ugeno.ah.sl slVar = new com.bytedance.adsdk.ugeno.ah.sl(this.xr);
        if (str.startsWith("2")) {
            ahVarMs = slVar.ms(jSONObject);
            slVar.xr(this.d);
        } else {
            ahVarMs = str.startsWith("3") ? slVar.ms(jSONObject, this.d, (JSONObject) null) : null;
        }
        if (ahVarMs != null) {
            this.nl = ahVarMs.ny();
        }
    }
}
