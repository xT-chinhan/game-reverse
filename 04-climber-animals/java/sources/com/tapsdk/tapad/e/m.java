package com.tapsdk.tapad.e;

import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.UserAction;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.network.ResponseBean;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import com.tapsdk.tapad.model.entities.UserActionResult;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.bv;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    class a implements Function<ResponseBean<UserActionResult>, UserActionResult> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserActionResult apply(ResponseBean<UserActionResult> responseBean) throws Exception {
            return responseBean.data;
        }
    }

    class b extends com.tapsdk.tapad.internal.network.c.c<ResponseBean<UserActionResult>> {
        b() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:60:0x0141  */
    /* JADX WARN: Code duplicated, block: B:65:0x0157 A[Catch: JSONException -> 0x0187, TryCatch #0 {JSONException -> 0x0187, blocks: (B:3:0x0013, B:5:0x0021, B:7:0x0028, B:9:0x0036, B:11:0x0041, B:13:0x004e, B:16:0x0058, B:17:0x005d, B:19:0x0074, B:21:0x007d, B:23:0x0086, B:25:0x0096, B:27:0x009d, B:30:0x00ac, B:31:0x00b2, B:38:0x00c7, B:40:0x00d7, B:42:0x00e7, B:44:0x00f0, B:47:0x00f9, B:49:0x00fe, B:51:0x0107, B:53:0x0110, B:55:0x012b, B:57:0x0131, B:58:0x0136, B:61:0x0143, B:62:0x014a, B:63:0x0154, B:65:0x0157, B:67:0x015b, B:69:0x0162, B:71:0x0169, B:73:0x0170, B:75:0x0177, B:76:0x017f, B:77:0x0182, B:32:0x00b6, B:34:0x00be), top: B:81:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x015b A[Catch: JSONException -> 0x0187, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0187, blocks: (B:3:0x0013, B:5:0x0021, B:7:0x0028, B:9:0x0036, B:11:0x0041, B:13:0x004e, B:16:0x0058, B:17:0x005d, B:19:0x0074, B:21:0x007d, B:23:0x0086, B:25:0x0096, B:27:0x009d, B:30:0x00ac, B:31:0x00b2, B:38:0x00c7, B:40:0x00d7, B:42:0x00e7, B:44:0x00f0, B:47:0x00f9, B:49:0x00fe, B:51:0x0107, B:53:0x0110, B:55:0x012b, B:57:0x0131, B:58:0x0136, B:61:0x0143, B:62:0x014a, B:63:0x0154, B:65:0x0157, B:67:0x015b, B:69:0x0162, B:71:0x0169, B:73:0x0170, B:75:0x0177, B:76:0x017f, B:77:0x0182, B:32:0x00b6, B:34:0x00be), top: B:81:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x017f A[SYNTHETIC] */
    public Observable<UserActionResult> a(UserAction[] userActionArr, TapAdConfig tapAdConfig) {
        String devImei;
        String strB;
        String[] strArrC;
        JSONArray jSONArray;
        com.tapsdk.tapad.internal.network.a aVarA = com.tapsdk.tapad.a.a().a(Constants.b.a);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api_version", "1");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.tapsdk.tapad.internal.tracker.experiment.h.b.n, tapAdConfig.mMediaId);
            jSONObject.put("request_id", UUID.randomUUID());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("package_name", com.tapsdk.tapad.internal.utils.d.e(com.tapsdk.tapad.c.a));
            jSONObject3.put("app_version", com.tapsdk.tapad.internal.utils.d.f(com.tapsdk.tapad.c.a));
            if (tapAdConfig.gameChannel != null && tapAdConfig.gameChannel.length() > 0) {
                jSONObject3.put("channel", tapAdConfig.gameChannel);
            }
            jSONObject2.put(com.anythink.core.common.e.a.C0080a.c, jSONObject3);
            jSONObject.put("media", jSONObject2);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(Common.Predefined.SUB_OS_TYPE, 1);
            jSONObject4.put(bv.y, com.tapsdk.tapad.internal.utils.d.i());
            jSONObject4.put("model", com.tapsdk.tapad.internal.utils.d.f());
            jSONObject4.put("brand", com.tapsdk.tapad.internal.utils.d.e());
            int[] iArrB = com.tapsdk.tapad.internal.utils.d.b(com.tapsdk.tapad.c.a);
            jSONObject4.put("screen_width", iArrB[0]);
            jSONObject4.put("screen_height", iArrB[1]);
            if (!tapAdConfig.mCustomController.isCanUsePhoneState()) {
                devImei = tapAdConfig.mCustomController.getDevImei();
                if (devImei != null && devImei.length() > 0) {
                }
                jSONObject4.put("android_id", com.tapsdk.tapad.internal.utils.d.a(com.tapsdk.tapad.c.a, tapAdConfig));
                jSONObject4.put("oaid", "");
                jSONObject4.put("device_id", GUIDHelper.INSTANCE.getUID());
                jSONObject4.put("taptap_id", "");
                jSONObject4.put("language", com.tapsdk.tapad.internal.utils.d.j());
                jSONObject4.put(bv.ac, com.tapsdk.tapad.internal.utils.d.h(com.tapsdk.tapad.c.a) ? 2 : 1);
                jSONObject4.put(bv.O, com.tapsdk.tapad.internal.utils.d.d());
                jSONObject4.put(bv.J, com.tapsdk.tapad.internal.utils.d.g());
                jSONObject4.put("physical_memory_byte", com.tapsdk.tapad.internal.utils.d.k());
                jSONObject4.put("system_update_time", 0);
                jSONObject4.put("system_boot_time", 0);
                strB = l.a().b();
                if (strB != null && strB.length() > 0) {
                    jSONObject4.put(com.tapsdk.tapad.internal.tracker.experiment.h.f.D, strB);
                }
                strArrC = g.d().c();
                if (strArrC.length > 0) {
                    jSONObject4.put("installed_package", Arrays.toString(strArrC));
                }
                jSONObject.put("device", jSONObject4);
                jSONArray = new JSONArray();
                for (UserAction userAction : userActionArr) {
                    if (userAction != null) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("action_type", userAction.actionType);
                        jSONObject5.put("action_time", userAction.actionTime);
                        jSONObject5.put(com.tapsdk.tapad.internal.tracker.experiment.d.q, userAction.amount);
                        jSONObject5.put("is_win", userAction.winStatus);
                        jSONArray.put(jSONObject5);
                    }
                }
                jSONObject.put("user_action", jSONArray);
                return aVarA.b(new b(), "/user_activities/report", new HashMap<>(), new HashMap<>(), jSONObject).map(new a());
            }
            devImei = com.tapsdk.tapad.internal.utils.d.c(com.tapsdk.tapad.c.a);
            jSONObject4.put("imei", devImei);
            jSONObject4.put("android_id", com.tapsdk.tapad.internal.utils.d.a(com.tapsdk.tapad.c.a, tapAdConfig));
            jSONObject4.put("oaid", "");
            jSONObject4.put("device_id", GUIDHelper.INSTANCE.getUID());
            jSONObject4.put("taptap_id", "");
            jSONObject4.put("language", com.tapsdk.tapad.internal.utils.d.j());
            jSONObject4.put(bv.ac, com.tapsdk.tapad.internal.utils.d.h(com.tapsdk.tapad.c.a) ? 2 : 1);
            jSONObject4.put(bv.O, com.tapsdk.tapad.internal.utils.d.d());
            jSONObject4.put(bv.J, com.tapsdk.tapad.internal.utils.d.g());
            jSONObject4.put("physical_memory_byte", com.tapsdk.tapad.internal.utils.d.k());
            jSONObject4.put("system_update_time", 0);
            jSONObject4.put("system_boot_time", 0);
            strB = l.a().b();
            if (strB != null) {
                jSONObject4.put(com.tapsdk.tapad.internal.tracker.experiment.h.f.D, strB);
            }
            strArrC = g.d().c();
            if (strArrC.length > 0) {
                jSONObject4.put("installed_package", Arrays.toString(strArrC));
            }
            jSONObject.put("device", jSONObject4);
            jSONArray = new JSONArray();
            while (i < userActionArr.length) {
                if (userAction != null) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("action_type", userAction.actionType);
                    jSONObject6.put("action_time", userAction.actionTime);
                    jSONObject6.put(com.tapsdk.tapad.internal.tracker.experiment.d.q, userAction.amount);
                    jSONObject6.put("is_win", userAction.winStatus);
                    jSONArray.put(jSONObject6);
                }
            }
            jSONObject.put("user_action", jSONArray);
        } catch (JSONException unused) {
        }
        return aVarA.b(new b(), "/user_activities/report", new HashMap<>(), new HashMap<>(), jSONObject).map(new a());
    }
}
