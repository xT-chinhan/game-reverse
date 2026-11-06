package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.byazt.ca.ho;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.umeng.analytics.pro.cc;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i1 extends pbla {
    private SDKMonitor pr;

    final class pgla implements SDKMonitor.IGetExtendParams {
        final /* synthetic */ String hw;
        final /* synthetic */ JSONObject pr;

        pgla(JSONObject jSONObject, String str) {
            this.pr = jSONObject;
            this.hw = str;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbla
    public final void hw(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.pr;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pbla
    public final void pr(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.pr;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pbla
    public final void pr(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a77c4a", new byte[]{67, 57, 69, 5, cc.m, 119, 112, 51, 112, 54, 126, 33, 104, 24, 12, 91, 99, 24, 103, 52, 117, 39, 4, 4, cc.l, 100, 116, 31, 101, 54, 126, 52, 73, 18, 75, 59, 47, 91, 38});
        if (this.pr == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "be1165", new byte[]{96, 98, 80, 83, 0, 33, 100, 74, 97, 108, 118}), str);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7f8d60", new byte[]{37, 101, 95, 21, cc.l, 40, 38, 94}), jSONObject);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b302c3", new byte[]{126, 52, 87, 84, 85, 39}), jSONObject2);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "647d9a", new byte[]{43, 57, 67, 53, 30, 98, 39}), jSONObject3);
            ho.hw((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f18174", new byte[]{90, 22, 127, 100, 59, 6, 70}), jSONObject4.toString());
        } catch (JSONException e) {
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.pr.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbla
    public final boolean pr(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        Context contextHw = pblp.pr().hw();
        String string2 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "88772c", new byte[]{58, 63, 73});
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "279358", new byte[]{48, 49, 65, 120, 11, 38, 53}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "03471a", new byte[]{41, 62, 84, 87, 49, 119, 58, 22}));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1007bb", new byte[]{35, 61, 77, 69, 84, 114, 7, 35, 77, 116}));
                JSONArray jSONArray2 = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "74ae29", new byte[]{52, 51, 2, 30, 31, 58, 1, 39, 28, 38}));
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
            } catch (JSONException e2) {
                str2 = string2;
                string2 = string;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "664905", new byte[]{52, 49, 74, 114, 6});
                string = string2;
                string2 = str2;
            }
        } catch (JSONException e3) {
            str2 = null;
        }
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ab9e0a", new byte[]{115, 111, 68, 23, 6, 113, 87, 113, 68, 38}));
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "409bab", new byte[]{55, 55, 90, 25, 76, 97, 2, 35, 68, 33}));
        SDKMonitorUtils.initMonitor(contextHw, string, jSONObject, new pgla(jSONObject, string2));
        this.pr = SDKMonitorUtils.getInstance(string);
        return true;
    }
}
