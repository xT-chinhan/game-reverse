package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.sdk.component.utils.sl;
import com.umeng.analytics.pro.ek;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class o1 extends pblw {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SDKMonitor f4841ms;

    final class pgla implements SDKMonitor.IGetExtendParams {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final /* synthetic */ JSONObject f4842ms;
        final /* synthetic */ String xr;

        pgla(JSONObject jSONObject, String str) {
            this.f4842ms = jSONObject;
            this.xr = str;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void ms(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.f4841ms;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void ms(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "752656", new byte[]{21, 59, com.anythink.core.common.s.a.c.b, 80, ek.l, 32, 38, 49, 117, 99, 40, 35, 109, 77, ek.k, 12, 53, 26, 98, 97, 35, 37, 1, 81, ek.m, 51, 34, 29, 96, 99, 40, 54, 76, 71, 74, 108, 121, 89, 35});
        if (this.f4841ms == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d070a9", new byte[]{102, 55, 86, 82, 87, 45, 98, 31, 103, 109, 112}), str);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1c272f", new byte[]{35, 96, 85, 70, 10, 126, 32, 91}), jSONObject);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a1b500", new byte[]{125, 54, 5, 83, 6, 36}), jSONObject2);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "381085", new byte[]{46, 53, 69, 97, 31, 54, 34}), jSONObject3);
            sl.d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "13cc52", new byte[]{ek.k, 20, 36, 54, 57, 0, 17}), jSONObject4.toString());
        } catch (JSONException e) {
            sl.ms(e);
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.f4841ms.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final boolean ms(String str) {
        JSONObject jSONObject;
        String str2;
        String str3;
        String string;
        String string2;
        Context contextXr = pblv.ms().xr();
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "73aec5", new byte[]{53, 52, 31});
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "75fa69", new byte[]{53, 51, 30, 42, 8, 39, 48}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "de6f74", new byte[]{125, 104, 86, 6, 55, 34, 110, com.anythink.core.common.s.a.c.b}));
                try {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "74b532", new byte[]{37, 57, 31, 71, 5, 34, 1, 39, 31, 118}));
                    JSONArray jSONArray2 = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "06e89b", new byte[]{51, 49, 6, 67, 20, 97, 6, 37, 24, 123}));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        arrayList2.add(jSONArray2.getString(i2));
                    }
                    if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
                        return false;
                    }
                    SDKMonitorUtils.setConfigUrl(string, arrayList);
                    SDKMonitorUtils.setDefaultReportUrl(string, arrayList2);
                } catch (JSONException unused2) {
                    str2 = string;
                    str3 = string2;
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "96013c", new byte[]{59, 49, 78, 122, 5});
                    string = str2;
                    string2 = str3;
                }
            } catch (JSONException unused3) {
                str2 = string;
                str3 = null;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "96013c", new byte[]{59, 49, 78, 122, 5});
                string = str2;
                string2 = str3;
                jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7a059", new byte[]{116, 58, 28, 66, 3, 41, 80, 36, 28, 115}));
                jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4ad8f4", new byte[]{55, 102, 7, 67, 75, 55, 2, 114, 25, 123}));
                SDKMonitorUtils.initMonitor(contextXr, string, jSONObject, new pgla(jSONObject, string2));
                this.f4841ms = SDKMonitorUtils.getInstance(string);
                return true;
            }
        } catch (JSONException unused4) {
            str2 = null;
        }
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7a059", new byte[]{116, 58, 28, 66, 3, 41, 80, 36, 28, 115}));
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4ad8f4", new byte[]{55, 102, 7, 67, 75, 55, 2, 114, 25, 123}));
        SDKMonitorUtils.initMonitor(contextXr, string, jSONObject, new pgla(jSONObject, string2));
        this.f4841ms = SDKMonitorUtils.getInstance(string);
        return true;
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void xr(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.f4841ms;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }
}
