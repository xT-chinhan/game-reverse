package com.anythink.core.common.h;

import android.text.TextUtils;
import com.anythink.core.api.ATSDKUtils;
import com.anythink.core.api.BaseAd;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class at {
    private final String a = "at";
    private String b;
    private List<c> c;
    private boolean d;
    private boolean e;

    public final synchronized void a(String str, List<c> list) {
        boolean z;
        if (TextUtils.equals(this.b, str) && this.e) {
            return;
        }
        this.b = str;
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    z = false;
                    break;
                }
                by unitGroupInfo = list.get(i).e().getUnitGroupInfo();
                if (unitGroupInfo.n() == 8 && unitGroupInfo.bd() && unitGroupInfo.bg() == 1) {
                    z = true;
                    break;
                }
                i++;
            }
        } else {
            z = false;
            break;
        }
        this.d = z;
        if (z) {
            this.c = list;
            this.e = false;
        } else {
            this.c = null;
            this.e = true;
        }
    }

    public final synchronized void a(String str, String str2, String str3) {
        List<c> list;
        Map<String, Object> networkInfoMap;
        Object obj;
        if (TextUtils.equals(this.b, str2) && this.d && !this.e && (list = this.c) != null && list.size() > 0) {
            this.e = true;
            try {
                ArrayList arrayList = new ArrayList();
                Collections.sort(this.c);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                int i = 0;
                double dA = 0.0d;
                String strAS = "";
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    c cVar = this.c.get(i2);
                    if (cVar.e() != null && cVar.e().getUnitGroupInfo() != null) {
                        by unitGroupInfo = cVar.e().getUnitGroupInfo();
                        if (TextUtils.equals(str3, unitGroupInfo.G())) {
                            strAS = cVar.i().aS();
                            jSONObject.put("nw_firm_id", unitGroupInfo.n());
                            jSONObject.put(com.anythink.core.d.b.e.a.h, a(unitGroupInfo.K()));
                            BaseAd baseAdF = cVar.f();
                            if (baseAdF != null) {
                                jSONObject.put("advertiser_name", baseAdF.getAdvertiserName());
                                jSONObject.put("title", baseAdF.getTitle());
                                jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.IMAGE_URL, baseAdF.getMainImageUrl());
                                jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.DESC, baseAdF.getDescriptionText());
                                jSONObject.put("video_url", baseAdF.getVideoUrl());
                            }
                            i = i2;
                        }
                    }
                    if (i2 >= i && cVar.e() != null && cVar.e().getUnitGroupInfo() != null) {
                        by unitGroupInfo2 = cVar.e().getUnitGroupInfo();
                        if (cVar.f() != null) {
                            networkInfoMap = cVar.f().getNetworkInfoMap();
                        } else {
                            networkInfoMap = cVar.e().getNetworkInfoMap();
                        }
                        String networkPlacementId = cVar.e().getNetworkPlacementId();
                        if (unitGroupInfo2.n() == 8) {
                            if (dA == 0.0d) {
                                dA = a(unitGroupInfo2.K());
                            }
                            if (!TextUtils.isEmpty(networkPlacementId)) {
                                String string = "";
                                if (networkInfoMap != null && (obj = networkInfoMap.get("request_id")) != null) {
                                    string = obj.toString();
                                }
                                jSONObject2.put(networkPlacementId, string + "," + String.valueOf(cVar.d() - cVar.i().ac()) + "," + a(unitGroupInfo2.K()));
                            }
                        } else if (!arrayList.contains(Integer.valueOf(unitGroupInfo2.n()))) {
                            arrayList.add(Integer.valueOf(unitGroupInfo2.n()));
                            jSONObject3.put(new StringBuilder().append(unitGroupInfo2.n()).toString(), a(unitGroupInfo2.K()));
                        }
                    }
                }
                com.anythink.core.common.t.f.a(str, str2, strAS, dA, jSONObject2.toString(), jSONObject.toString(), jSONObject3.toString());
                this.c = null;
            } catch (Throwable unused) {
            }
        }
    }

    private static double a(double d) {
        return ATSDKUtils.getUsdChangeToRmbRate() > 0.0d ? d * ATSDKUtils.getUsdChangeToRmbRate() : d;
    }
}
