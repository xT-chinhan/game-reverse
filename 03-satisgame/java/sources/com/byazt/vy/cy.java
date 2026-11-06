package com.byazt.vy;

import android.content.Context;
import android.os.SystemClock;
import com.byazt.ehw.DeviceUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy {
    public static JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.vf.oa oaVar = (com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new");
            com.byazt.vf.s sVar = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog");
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, oaVar.fs());
            String strN = DeviceUtils.n((Boolean) null);
            jSONObject.put("imei", strN);
            jSONObject.put("imei_md5", k.n(strN));
            jSONObject.put("oaid", sVar.n(false));
            jSONObject.put("applog_did", com.byazt.yu.n.n().qg());
            jSONObject.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, oaVar.qg());
            jSONObject.put("vendor", oaVar.cp());
            jSONObject.put("ua", oaVar.cy());
            jSONObject.put("ip", com.byazt.ehw.w.n());
            jSONObject.put("package_name", hu.n());
            jSONObject.put("publisher_did", com.byazt.qt.n.d().cd());
            jSONObject.put("android_id", DeviceUtils.qg());
            jSONObject.put("os_version", oaVar.rv());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject n(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.vf.oa oaVar = (com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new");
            jSONObject.put("imei", DeviceUtils.n((Boolean) null));
            jSONObject.put("android_id", DeviceUtils.qg());
            jSONObject.put("uuid", com.byazt.ehw.n.s());
            jSONObject.put("ssid", oaVar.q((Boolean) null));
            jSONObject.put("wifi_mac", oaVar.n((Boolean) null));
            jSONObject.put("imsi", oaVar.l((Boolean) null));
            jSONObject.put("power_on_time", new StringBuilder().append(SystemClock.elapsedRealtime()).toString());
            jSONObject.put("rom_version", um.n());
            jSONObject.put("sys_compiling_time", oaVar.sz());
            jSONObject.put("type", oaVar.n(false));
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, oaVar.fs());
            jSONObject.put("os_version", oaVar.rv());
            jSONObject.put("vendor", oaVar.cp());
            jSONObject.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, oaVar.qg());
            jSONObject.put("language", oaVar.q());
            jSONObject.put("conn_type", ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(60000L));
            jSONObject.put("mac", oaVar.s((Boolean) null));
            jSONObject.put("screen_width", com.byazt.rb.w.qg(context));
            jSONObject.put("screen_height", com.byazt.rb.w.s(context));
            jSONObject.put("oaid", ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).n(false));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
