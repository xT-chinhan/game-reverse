package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.QyCustomMade;
import com.mcto.sspsdk.component.webview.QyWebViewDataBean;
import com.mcto.sspsdk.ssp.activity.QyDetailPageActivityNew;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y3 {
    public static int a(Context context, p pVar, b4 b4Var) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        z3 z3Var = b4Var.a;
        if (z3Var == null) {
            z3Var = z3.GRAPHIC;
        }
        boolean zA = false;
        if (z3.NEGATIVE == z3Var || z3.CLOSE == z3Var) {
            return 0;
        }
        String strOptString = pVar.i().optString("detailPage");
        if (z3.DOWN_CONFIRM_DETAIL_BTN == z3Var) {
            a(context, strOptString, pVar);
            return 1;
        }
        String str = z3Var.a;
        int i3 = pVar.S0;
        if (j.b(2, i3)) {
            if (j.b(2, pVar.S0) && pVar.j0 == 3014) {
                boolean zA2 = rd.a();
                ArrayList arrayList = va.a;
                String str2 = pVar.m0;
                if (TextUtils.isEmpty(str2)) {
                    if (!zA2) {
                        Iterator it = va.a.iterator();
                        while (it.hasNext()) {
                            if (((ra) it.next()).a(context, pVar.l0, pVar.k0)) {
                                zA = true;
                                break;
                            }
                        }
                    } else {
                        for (ra raVar : va.a) {
                            if (!raVar.a.a.isEmpty() && raVar.a.a.contains(rd.f)) {
                                zA = raVar.a(context, pVar.l0, pVar.k0);
                                break;
                            }
                        }
                    }
                } else {
                    zA = e1.a(false, context, str2, null);
                }
                if (zA) {
                    return 4;
                }
            }
            if (z3.HALF_WEBVIEW.equals(z3Var)) {
                return 1;
            }
            a(context, pVar.E, pVar);
            return 1;
        }
        if (j.b(3, i3)) {
            if (z3.HALF_WEBVIEW.equals(z3Var)) {
                return 1;
            }
            String strOptString2 = b4Var.k;
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = pVar.i().optString("apkName");
            }
            String strOptString3 = pVar.i().optString("deeplink");
            if (e1.c(strOptString2)) {
                if (!e1.a(TextUtils.equals("1", pVar.i().optString("deeplinkNewFlag", "1")), context, strOptString3, strOptString2)) {
                    e1.a(context, strOptString2);
                }
                return 8;
            }
            if (((z3Var.c & 4) != 0) && b4Var.i != 1 && (i2 = pVar.L) != 3 && i2 != 8) {
                a(context, strOptString, pVar);
                return 1;
            }
            if (b4Var.i == 1 || z3.DOWN_CONFIRM_ACTION_BTN == z3Var || z3.DIRECT_ACTION_BTN == z3Var || (i = pVar.L) == 3 || i == 8 || (str.endsWith("button") && b4Var.i == 2)) {
                String str3 = pVar.E;
                t0 t0Var = new t0();
                t0Var.i = strOptString2;
                t0Var.h = pVar.Q;
                t0Var.g = pVar.P;
                t0Var.p = strOptString3;
                t0Var.d = str3;
                c1.a().a(new u0(t0Var.a(pVar.d())));
                return 2;
            }
            View view = b4Var.l;
            if (view != null) {
                if ((pVar.r == 1) && pVar.H0 != null) {
                    p5 p5Var = new p5(view, pVar);
                    View view2 = b4Var.l;
                    try {
                        PopupWindow popupWindow = new PopupWindow((View) p5Var.b, -1, -1, true);
                        popupWindow.setContentView(p5Var.b);
                        p5Var.b.setOnClickListener(new n5(popupWindow));
                        if (view2.getWindowToken() != null) {
                            popupWindow.showAtLocation(view2, 17, 0, 0);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } catch (Throwable th) {
                        int i4 = p5Var.d.a;
                    }
                    if (z2) {
                        return 32;
                    }
                }
            }
            a(context, strOptString, pVar);
            return 1;
        }
        if (j.b(4, i3)) {
            String strOptString4 = pVar.i().optString("apkName");
            String strOptString5 = pVar.i().optString("deeplink");
            if ((!lj.b(strOptString5) && e1.c(strOptString4)) && e1.a(TextUtils.equals("1", pVar.i().optString("deeplinkNewFlag", "1")), context, strOptString5, strOptString4)) {
                return 4;
            }
            a(context, pVar.E, pVar);
            return 1;
        }
        if (!j.b(5, i3)) {
            return -1;
        }
        if (rd.a()) {
            String str4 = pVar.E;
            QyCustomMade qyCustomMade = rd.d;
            if (qyCustomMade != null ? qyCustomMade.registration(str4) : false) {
                return 16;
            }
        }
        try {
            String str5 = pVar.E;
            String str6 = pVar.c().l;
            String strOptString6 = new JSONObject(str5).optJSONObject("biz_params").optString("biz_params");
            AtomicInteger atomicInteger = gj.a;
            HashMap map = new HashMap();
            for (String str7 : strOptString6.split("&")) {
                String[] strArrSplit = str7.split("=", 2);
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], gj.e(strArrSplit[1]));
                }
            }
            String str8 = (String) map.get("miniAppName");
            String str9 = (String) map.get("miniAppPath");
            String str10 = (String) map.get("miniProgramType");
            String str11 = (String) map.get("extData");
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = str8;
            if (!TextUtils.isEmpty(str9)) {
                req.path = str9;
            }
            req.miniprogramType = gj.a((Object) str10, 0);
            if (!TextUtils.isEmpty(str11)) {
                req.extData = str11;
            }
            WXAPIFactory.createWXAPI(context, str6).sendReq(req);
            z = true;
        } catch (Throwable th2) {
            r9.a("ssp_clickAction", "open wx error", th2);
            z = false;
        }
        return z ? 16 : -1;
    }

    public static void a(Context context, String str, p pVar) {
        if (lj.b(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context.getApplicationContext(), QyDetailPageActivityNew.class);
        intent.setAction("android.intent.action.VIEW");
        intent.putExtra("dataBean", QyWebViewDataBean.a(str, pVar));
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            r9.a("ssp_clickAction", "open Web view: ", e);
        }
    }
}
