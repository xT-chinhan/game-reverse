package com.anythink.basead.k;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.d.g;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.v;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.m;
import com.qumeng.advlib.api.AiClkAdManager;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.QMConfig;
import com.qumeng.advlib.core.QMCustomControl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.anythink.basead.f.d.a {
    private static volatile b b;
    private boolean d;
    private final String a = getClass().getSimpleName();
    private final String e = "3.473.10.439";
    private Context c = t.b().g();

    private b() throws Exception {
        if (!"3.473.10.439".equals(AiClkAdManager.getSdkVersion())) {
            throw new Exception("QM Plugin version is wrong");
        }
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    private void b() {
        int persionalizedAdStatus;
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            try {
                persionalizedAdStatus = ATSDK.getPersionalizedAdStatus();
            } catch (Throwable unused) {
                persionalizedAdStatus = 0;
            }
            AiClkAdManager.getInstance().setPersonalRecommend(persionalizedAdStatus != 2);
            QMConfig.Builder builder = new QMConfig.Builder();
            builder.customControl(new QMCustomControl() { // from class: com.anythink.basead.k.b.1
                private static boolean c() {
                    return false;
                }

                private static boolean a() {
                    return v.a(t.b().g()).b() && !t.b().c("android_id");
                }

                private static boolean b() {
                    return (!v.a(t.b().g()).b() || t.b().c("imei") || t.b().c("imsi") || t.b().c("mac")) ? false : true;
                }

                private static String d() {
                    return m.H();
                }
            });
            AiClkAdManager.getInstance().init(builder.build(this.c));
            this.d = true;
        }
    }

    @Override // com.anythink.basead.f.d.a
    public final JSONArray a(String str, int i) {
        JSONArray jSONArray = new JSONArray();
        try {
            String strA = a(str);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            b();
            int i2 = 3;
            if (i != 0) {
                if (i == 1) {
                    i2 = 4;
                } else if (i != 3) {
                    i2 = i != 4 ? -1 : 6;
                } else {
                    i2 = 2;
                }
            }
            if (i2 > 0) {
                String biddingToken = AiClkAdManager.getInstance().createAdRequest().getBiddingToken(new AdRequestParam.Builder().adslotID(strA).adType(i2).build());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slot_id", strA);
                jSONObject.put("token", biddingToken);
                jSONArray.put(jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONArray;
    }

    private static String a(String str) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (TextUtils.isEmpty(str) || (jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(com.anythink.basead.f.d.b.a)) == null) {
                return null;
            }
            return jSONObjectOptJSONObject.optString("slot_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.basead.f.d.a
    public final void a(final r rVar, x xVar, final com.anythink.basead.f.a.a.InterfaceC0040a interfaceC0040a) {
        String strAf = rVar.af();
        if (TextUtils.isEmpty(strAf)) {
            if (interfaceC0040a != null) {
                interfaceC0040a.a(rVar, g.a(g.s, g.Y));
                return;
            }
            return;
        }
        try {
            int i = xVar.j;
            int i2 = 3;
            if (i != 0) {
                if (i == 1) {
                    i2 = 4;
                } else if (i != 3) {
                    i2 = i != 4 ? -1 : 6;
                } else {
                    i2 = 2;
                }
            }
            if (i2 > 0) {
                AiClkAdManager.getInstance().createAdRequest().invokeADV(new AdRequestParam.Builder().setAdm(strAf).adType(i2).adslotID(a(xVar.r)).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.anythink.basead.k.b.2
                    private void a(IMultiAdObject iMultiAdObject) {
                        com.anythink.basead.f.a.a.InterfaceC0040a interfaceC0040a2 = interfaceC0040a;
                        if (interfaceC0040a2 != null) {
                            interfaceC0040a2.a(rVar, new a(iMultiAdObject));
                        }
                    }

                    private void a(String str) {
                        com.anythink.basead.f.a.a.InterfaceC0040a interfaceC0040a2 = interfaceC0040a;
                        if (interfaceC0040a2 != null) {
                            interfaceC0040a2.a(rVar, g.a(g.s, g.aa.concat(String.valueOf(str))));
                        }
                    }
                }).build());
            } else if (interfaceC0040a != null) {
                interfaceC0040a.a(rVar, g.a(g.s, "Adx DSP SDK Offer load fail:with unsupport format:" + xVar.j));
            }
        } catch (Throwable th) {
            if (interfaceC0040a != null) {
                interfaceC0040a.a(rVar, g.a(g.s, g.Z + th.getMessage()));
            }
        }
    }
}
