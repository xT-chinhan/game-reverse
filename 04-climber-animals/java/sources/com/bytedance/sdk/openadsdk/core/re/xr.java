package com.bytedance.sdk.openadsdk.core.re;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.ab;
import com.bytedance.sdk.openadsdk.core.yu;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    public interface ms {
        void ms(int i, String str);

        void ms(JSONObject jSONObject);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.re.xr$xr, reason: collision with other inner class name */
    public interface InterfaceC0306xr {
        void ms();

        void ms(JSONObject jSONObject);
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar, InterfaceC0306xr interfaceC0306xr) {
        if (msVar != null) {
            ms(msVar.ah(), msVar.ms(), msVar.xr(), interfaceC0306xr);
        } else if (interfaceC0306xr != null) {
            interfaceC0306xr.ms();
        }
    }

    public static void ms(String str, final String str2, final String str3, final InterfaceC0306xr interfaceC0306xr) {
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0306xr != null) {
                interfaceC0306xr.ms();
            }
        } else {
            com.bytedance.sdk.component.ny.xr.ah ahVarAh = ka.ms().xr().ah();
            ahVarAh.ms(str);
            ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.re.xr.1
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    if (xrVar == null) {
                        return;
                    }
                    if (xrVar.x()) {
                        String strD = xrVar.d();
                        ab.ms().ms(str2, str3, strD);
                        if (interfaceC0306xr != null) {
                            try {
                                interfaceC0306xr.ms(new JSONObject(strD));
                                return;
                            } catch (JSONException e) {
                                sl.ms(e);
                                interfaceC0306xr.ms();
                                return;
                            }
                        }
                        return;
                    }
                    InterfaceC0306xr interfaceC0306xr2 = interfaceC0306xr;
                    if (interfaceC0306xr2 != null) {
                        interfaceC0306xr2.ms();
                    }
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                    InterfaceC0306xr interfaceC0306xr2 = interfaceC0306xr;
                    if (interfaceC0306xr2 != null) {
                        interfaceC0306xr2.ms();
                    }
                }
            });
        }
    }

    public static void ms(lm lmVar, JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.qv.ah ahVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (ahVar == null) {
            return;
        }
        if (lmVar != null) {
            try {
                if (!TextUtils.isEmpty(lmVar.lx())) {
                    int iX = f.x(lmVar);
                    com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = lmVar.rt();
                    if (xrVarRt != null) {
                        xrVar = xrVarRt;
                    }
                    e eVar = new e();
                    eVar.d = 2;
                    if (lmVar.si() != null) {
                        eVar.c = 2;
                    }
                    JSONObject jSONObjectVt = lmVar.vt();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        Iterator<String> itKeys = jSONObjectVt.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject2.put(next, jSONObjectVt.opt(next));
                        }
                    } catch (JSONException e) {
                        sl.ms(e);
                    }
                    if (jSONObject != null) {
                        Iterator<String> itKeys2 = jSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            jSONObject2.put(next2, jSONObject.opt(next2));
                        }
                    }
                    eVar.sl = jSONObject2;
                    re.ms().ms(xrVar, eVar, iX, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.re.xr.2
                        @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                        public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                            ahVar.ms(false, null, false);
                            xrVar2.ms(i);
                            com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                        public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                            if (msVar.xr() != null && !msVar.xr().isEmpty()) {
                                ahVar.ms(true, msVar.xr(), false);
                                return;
                            }
                            ahVar.ms(false, null, false);
                            xrVar2.ms(-3);
                            com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                        }
                    });
                    return;
                }
            } catch (Exception e2) {
                sl.ah("PageNetUtils", "get ads error", e2);
                return;
            }
        }
        ahVar.ms(false, null, false);
    }

    public static void ms(String str, final ms msVar) {
        com.bytedance.sdk.component.ny.xr.ah ahVarAh = ka.ms().xr().ah();
        ahVarAh.ms(str);
        ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.re.xr.3
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                if (xrVar != null && xrVar.x()) {
                    try {
                        JSONObject jSONObject = new JSONObject(xrVar.d());
                        ms msVar2 = msVar;
                        if (msVar2 != null) {
                            msVar2.ms(jSONObject);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        sl.ms(e);
                        return;
                    }
                }
                ms msVar3 = msVar;
                if (msVar3 == null || xrVar == null) {
                    return;
                }
                msVar3.ms(xrVar.ms(), xrVar.xr());
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                }
            }
        });
    }
}
