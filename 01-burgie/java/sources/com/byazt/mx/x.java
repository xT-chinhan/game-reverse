package com.byazt.mx;

import com.byazt.ca.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, 121})
public class x {
    private static String pr(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", "300012449765");
            jSONObject.put("version", "1.0");
            String strPr = pr(System.currentTimeMillis());
            jSONObject.put("timestamp", strPr);
            jSONObject.put("appkey", "90E4DEDAD9B1CB57EA1538871ED468A7");
            jSONObject.put("businessType", GlobalSetting.SPLASH_AD);
            String string = UUID.randomUUID().toString();
            jSONObject.put("traceId", string);
            jSONObject.put("msgId", string);
            jSONObject.put("sign", c.hw("300012449765" + GlobalSetting.SPLASH_AD + string + strPr + string + "1.090E4DEDAD9B1CB57EA1538871ED468A7"));
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public static String pr(String str, String str2) {
        StringBuilder sbAppend = new StringBuilder(str).append("?");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", "9386206798");
            jSONObject.put("clientType", "Android-30100");
            jSONObject.put("format", "json");
            jSONObject.put("version", "v1.5");
            String strPr = pr.pr(str2.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB");
            jSONObject.put("paramKey", strPr);
            String strPr2 = pr.pr(true, ("timeStamp=" + System.currentTimeMillis()).getBytes(), str2);
            jSONObject.put("paramStr", strPr2);
            String[] strArr = {"9386206798", "Android-30100", "json", strPr, strPr2, "v1.5"};
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(strArr[i]);
            }
            jSONObject.put("sign", pr.pr(sb.toString(), "tgIBkg304BUpjGHLSq1wYYb0Xs77pMIm"));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                sbAppend.append(next).append("=").append(jSONObject.getString(next)).append("&");
            }
            sbAppend.deleteCharAt(sbAppend.length() - 1);
            return sbAppend.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
