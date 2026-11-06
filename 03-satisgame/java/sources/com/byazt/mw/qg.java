package com.byazt.mw;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.anythink.core.common.f.a;
import com.anythink.core.common.f.e;
import com.anythink.core.common.f.h;
import com.anythink.core.common.l.f;
import com.byazt.ehw.DeviceUtils;
import com.byazt.gct.j;
import com.byazt.gct.ju;
import com.byazt.gct.pk;
import com.byazt.gct.wv;
import com.byazt.gct.y;
import com.byazt.gct.yw;
import com.byazt.q.AdBaseConstants;
import com.byazt.qit.x;
import com.byazt.qyu.PluginConstants;
import com.byazt.shr.cd;
import com.byazt.tk.k;
import com.byazt.uq.cp;
import com.byazt.uq.fs;
import com.byazt.uq.oa;
import com.byazt.uq.rv;
import com.byazt.uq.sz;
import com.byazt.vgx.w;
import com.byazt.vyf.l;
import com.byazt.wd.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.model.AdnName;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 26})
public class qg implements com.byazt.mw.n {
    public AtomicLong q = new AtomicLong(0);
    public final Context qg;
    public static final AtomicInteger s = new AtomicInteger(0);
    public static volatile int n = 0;

    private boolean qg(int i) {
        return i == 3 || i == 4;
    }

    public qg(Context context) {
        this.qg = context;
    }

    public JSONObject n(com.byazt.zq.qg qgVar, y yVar, int i, boolean z, int i2, boolean z2) {
        return n(qgVar, yVar, i, z, i2, z2, (String) null);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
    @JProtect
    private JSONObject n(y yVar) {
        com.byazt.uq.n.C0367n c0367nQg;
        boolean z;
        boolean z2;
        boolean z3;
        CharSequence title;
        JSONObject jSONObject = new JSONObject();
        boolean z4 = false;
        if (yVar != null) {
            try {
                if (TextUtils.isEmpty(yVar.um) || (c0367nQg = com.byazt.uq.n.qg(yVar.um)) == null) {
                    z3 = false;
                    z2 = false;
                } else {
                    if (TextUtils.isEmpty(c0367nQg.n)) {
                        z = false;
                    } else {
                        jSONObject.put("top_page_title", c0367nQg.n);
                        z = true;
                    }
                    if (TextUtils.isEmpty(c0367nQg.qg)) {
                        z2 = false;
                    } else {
                        jSONObject.put("top_page_name", c0367nQg.qg);
                        z2 = true;
                    }
                    if (!TextUtils.isEmpty(c0367nQg.s)) {
                        jSONObject.put("t_name", c0367nQg.s);
                        z4 = true;
                    }
                    jSONObject.put("l_source", c0367nQg.w);
                    z3 = z4;
                    z4 = z;
                }
            } catch (Throwable th) {
                k.n("NetApiImpl", "buildFeatureRequestBody error: ", th);
                return jSONObject;
            }
        } else {
            z3 = false;
            z2 = false;
        }
        if (z4 && z2 && z3) {
            return jSONObject;
        }
        Activity activity = null;
        if (com.byazt.vyf.s.cy().s() != null && com.byazt.vyf.s.cy().s().n() != null) {
            activity = com.byazt.vyf.s.cy().s().n().get();
        }
        if (activity != null) {
            if (!z4 || !z2) {
                sz.n(activity);
                if (!z4 && (title = activity.getTitle()) != null && title.length() > 0) {
                    jSONObject.put("top_page_title", title.toString());
                }
                if (!z2) {
                    jSONObject.put("top_page_name", activity.getClass().getName());
                }
            }
            if (!z3) {
                try {
                    String strW = com.byazt.uq.q.w();
                    if (!TextUtils.isEmpty(strW)) {
                        jSONObject.put("t_name", strW);
                        jSONObject.put("l_source", 1);
                    } else if (com.byazt.uq.s.x()) {
                        String strN = fs.n();
                        if (!TextUtils.isEmpty(strN)) {
                            jSONObject.put("t_name", strN);
                            jSONObject.put("l_source", 2);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    private void n(JSONObject jSONObject, com.byazt.zq.qg qgVar, y yVar) throws JSONException {
        long jN = oa.n();
        oa.n(jN);
        oa.n(jN, "step0/5 buildCoreRit,enter,adSlotType=" + (qgVar != null ? qgVar.a() : -1));
        try {
            JSONObject jSONObjectN = n(yVar);
            oa.n(jN, "step1/5 buildCoreRit,loadFeature=" + jSONObjectN);
            String strOptString = jSONObjectN.optString("top_page_name", " ");
            String strOptString2 = jSONObjectN.optString("t_name", " ");
            String strValueOf = String.valueOf(jSONObjectN.optInt("l_source", 0));
            String strN = rv.n(com.byazt.vyf.s.cy().ou(), qgVar != null ? qgVar.a() : 0, strOptString, strOptString2).n();
            cp.qg qgVarN = cp.n(strN);
            oa.n(jN, "step4/5 buildCoreRit,showListSnapshot=" + oa.n(qgVarN));
            StringBuilder sb = new StringBuilder(64);
            sb.append(qgVarN.qg).append('_');
            cp.n(sb, strN).append('_');
            cp.n(sb, strOptString).append('_');
            cp.n(sb, strOptString2).append('_');
            cp.n(sb, strValueOf);
            jSONObject.put("l_feat", sb.toString());
            jSONObject.put("s_feat_lt", qgVarN.n);
            oa.n(jN, "step5/5 buildCoreRit,featureV2=" + jSONObject);
        } finally {
            oa.qg();
        }
    }

    private void qg(JSONObject jSONObject, com.byazt.zq.qg qgVar, y yVar) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("feature_data_v2");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            n(jSONObjectOptJSONObject, qgVar, yVar);
            jSONObject.put("feature_data_v2", jSONObjectOptJSONObject);
        } catch (Throwable th) {
            oa.n("appendCoreRit,error=" + th, th);
            k.n("NetApiImpl", "appendCoreRit error: ", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0261 A[Catch: all -> 0x051f, TryCatch #7 {all -> 0x051f, blocks: (B:69:0x0102, B:71:0x010b, B:72:0x0110, B:74:0x0117, B:75:0x011d, B:79:0x0146, B:81:0x01c1, B:82:0x01da, B:86:0x01e9, B:88:0x0203, B:89:0x0208, B:95:0x023b, B:99:0x0252, B:101:0x0261, B:103:0x026b, B:105:0x0271), top: B:214:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0280 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0297  */
    /* JADX WARN: Code duplicated, block: B:116:0x02a2 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:119:0x02b7 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:121:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:128:0x0363  */
    /* JADX WARN: Code duplicated, block: B:136:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:137:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:144:0x0414 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:147:0x041c A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0443 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0035 A[Catch: all -> 0x0524, TRY_ENTER, TryCatch #2 {all -> 0x0524, blocks: (B:6:0x001b, B:14:0x0035, B:17:0x003e), top: B:206:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:151:0x044a  */
    /* JADX WARN: Code duplicated, block: B:153:0x0453 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:159:0x0474 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:161:0x047c  */
    /* JADX WARN: Code duplicated, block: B:163:0x047f A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:166:0x0496 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:16:0x003b  */
    /* JADX WARN: Code duplicated, block: B:170:0x04b1 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:172:0x04c0 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:177:0x04d6 A[Catch: all -> 0x051c, TryCatch #4 {all -> 0x051c, blocks: (B:108:0x027a, B:110:0x0280, B:111:0x0289, B:115:0x0299, B:119:0x02b7, B:120:0x02c0, B:122:0x02f5, B:125:0x0358, B:127:0x035c, B:129:0x0366, B:131:0x039e, B:133:0x03a2, B:134:0x03a9, B:138:0x03cb, B:141:0x03f2, B:142:0x0402, B:144:0x0414, B:147:0x041c, B:149:0x0443, B:152:0x044b, B:155:0x0462, B:157:0x0466, B:153:0x0453, B:159:0x0474, B:163:0x047f, B:164:0x0488, B:166:0x0496, B:167:0x04a8, B:175:0x04cb, B:177:0x04d6, B:179:0x04df, B:181:0x04e5, B:183:0x04ec, B:185:0x04f0, B:186:0x04fe, B:188:0x0504, B:190:0x050a, B:191:0x050f, B:170:0x04b1, B:172:0x04c0, B:174:0x04c6, B:116:0x02a2), top: B:210:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:17:0x003e A[Catch: all -> 0x0524, TRY_LEAVE, TryCatch #2 {all -> 0x0524, blocks: (B:6:0x001b, B:14:0x0035, B:17:0x003e), top: B:206:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:210:0x027a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0061  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c1 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:48:0x00b7, B:51:0x00c1, B:53:0x00cf, B:55:0x00d6, B:57:0x00dc, B:58:0x00e1, B:60:0x00e7, B:62:0x00ed, B:64:0x00f3), top: B:202:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00cf A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:48:0x00b7, B:51:0x00c1, B:53:0x00cf, B:55:0x00d6, B:57:0x00dc, B:58:0x00e1, B:60:0x00e7, B:62:0x00ed, B:64:0x00f3), top: B:202:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00dc A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:48:0x00b7, B:51:0x00c1, B:53:0x00cf, B:55:0x00d6, B:57:0x00dc, B:58:0x00e1, B:60:0x00e7, B:62:0x00ed, B:64:0x00f3), top: B:202:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f3 A[Catch: all -> 0x0100, TRY_LEAVE, TryCatch #0 {all -> 0x0100, blocks: (B:48:0x00b7, B:51:0x00c1, B:53:0x00cf, B:55:0x00d6, B:57:0x00dc, B:58:0x00e1, B:60:0x00e7, B:62:0x00ed, B:64:0x00f3), top: B:202:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x010b A[Catch: all -> 0x051f, TryCatch #7 {all -> 0x051f, blocks: (B:69:0x0102, B:71:0x010b, B:72:0x0110, B:74:0x0117, B:75:0x011d, B:79:0x0146, B:81:0x01c1, B:82:0x01da, B:86:0x01e9, B:88:0x0203, B:89:0x0208, B:95:0x023b, B:99:0x0252, B:101:0x0261, B:103:0x026b, B:105:0x0271), top: B:214:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0117 A[Catch: all -> 0x051f, TryCatch #7 {all -> 0x051f, blocks: (B:69:0x0102, B:71:0x010b, B:72:0x0110, B:74:0x0117, B:75:0x011d, B:79:0x0146, B:81:0x01c1, B:82:0x01da, B:86:0x01e9, B:88:0x0203, B:89:0x0208, B:95:0x023b, B:99:0x0252, B:101:0x0261, B:103:0x026b, B:105:0x0271), top: B:214:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0143  */
    /* JADX WARN: Code duplicated, block: B:78:0x0145  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c1 A[Catch: all -> 0x051f, TryCatch #7 {all -> 0x051f, blocks: (B:69:0x0102, B:71:0x010b, B:72:0x0110, B:74:0x0117, B:75:0x011d, B:79:0x0146, B:81:0x01c1, B:82:0x01da, B:86:0x01e9, B:88:0x0203, B:89:0x0208, B:95:0x023b, B:99:0x0252, B:101:0x0261, B:103:0x026b, B:105:0x0271), top: B:214:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:88:0x0203 A[Catch: all -> 0x051f, TryCatch #7 {all -> 0x051f, blocks: (B:69:0x0102, B:71:0x010b, B:72:0x0110, B:74:0x0117, B:75:0x011d, B:79:0x0146, B:81:0x01c1, B:82:0x01da, B:86:0x01e9, B:88:0x0203, B:89:0x0208, B:95:0x023b, B:99:0x0252, B:101:0x0261, B:103:0x026b, B:105:0x0271), top: B:214:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x023a  */
    /* JADX WARN: Code duplicated, block: B:97:0x024f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0251  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19, types: [int] */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.byazt.mw.qg] */
    /* JADX WARN: Type inference failed for: r4v31, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.json.JSONObject] */
    @JProtect
    public JSONObject n(com.byazt.zq.qg qgVar, y yVar, int i, boolean z, int i2, boolean z2, String str) {
        com.byazt.zq.qg qgVar2;
        String str2;
        String strQg;
        int iN;
        Object obj;
        int i3;
        int andSet;
        int i4;
        com.byazt.wq.qg qgVarN;
        int iS;
        int i5;
        String strX;
        long jCurrentTimeMillis;
        boolean z3;
        y yVar2;
        JSONObject jSONObjectN;
        String[] strArrN;
        String strConcat;
        boolean z4;
        String str3;
        String str4;
        ?? r12;
        long jCurrentTimeMillis2;
        long jCurrentTimeMillis3;
        long jCurrentTimeMillis4;
        JSONObject jSONObjectS;
        JSONArray jSONArrayN;
        JSONObject jSONObjectN2;
        long jCurrentTimeMillis5;
        String strL;
        String strW;
        JSONObject jSONObject;
        String strN;
        ?? jSONObject2 = new JSONObject();
        boolean z5 = i2 == 5;
        try {
            long jCurrentTimeMillis6 = System.currentTimeMillis();
            if (yVar != null) {
                try {
                    if (!TextUtils.isEmpty(yVar.qg())) {
                        strQg = yVar.qg();
                    } else if (TextUtils.isEmpty(str)) {
                        strQg = w.x();
                    } else {
                        strQg = str;
                    }
                } catch (Throwable th) {
                    th = th;
                    qgVar2 = qgVar;
                    str2 = null;
                    n(str2, qgVar2, th);
                    return jSONObject2;
                }
            } else if (TextUtils.isEmpty(str)) {
                strQg = str;
            } else {
                strQg = w.x();
            }
            if (qgVar != null) {
                try {
                    if (qgVar.wm() != null) {
                        iN = com.byazt.lpr.w.n(com.byazt.lpr.w.n(qgVar.wm()));
                        jSONObject2.put(h.b.c, iN);
                    } else {
                        iN = -1;
                    }
                    if (i == 7) {
                        if (yVar != null && yVar.n > 0) {
                            iN = yVar.n;
                            jSONObject2.put(h.b.c, iN);
                        }
                        if (yVar != null && !TextUtils.isEmpty(yVar.s)) {
                            jSONObject2.put("pre_sessions", yVar.s);
                            jSONObject2.put("play_again_count", yVar.q);
                        }
                    } else if (i == 8 && yVar != null && yVar.n > 0) {
                        iN = yVar.n;
                        jSONObject2.put(h.b.c, iN);
                    }
                    try {
                        strL = com.byazt.ed.q.n().l();
                        strW = com.byazt.ed.q.n().w();
                        i3 = iN;
                        try {
                            jSONObject = new JSONObject();
                            if (TextUtils.isEmpty(strL)) {
                                obj = "unknown";
                            } else {
                                obj = "unknown";
                                try {
                                    jSONObject.putOpt("version", strL);
                                } catch (Throwable unused) {
                                }
                            }
                            if (qgVar != null) {
                                strN = w.n(qgVar.hd());
                                if (!TextUtils.isEmpty(strN)) {
                                    jSONObject.put("external_ab_vid", strN);
                                }
                            } else {
                                strN = null;
                            }
                            if (!TextUtils.isEmpty(strW)) {
                                jSONObject.putOpt("param", strW);
                            }
                            if (TextUtils.isEmpty(strL) || !TextUtils.isEmpty(strN) || !TextUtils.isEmpty(strW)) {
                                jSONObject2.put("abtest", jSONObject);
                            }
                        } catch (Throwable unused2) {
                            obj = "unknown";
                        }
                    } catch (Throwable unused3) {
                        obj = "unknown";
                        i3 = iN;
                    }
                    if (z5) {
                        try {
                            andSet = tj.qg.getAndSet(0);
                            if (andSet > 0) {
                                jSONObject2.put("throttle_count", andSet);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            qgVar2 = qgVar;
                            str2 = strQg;
                            n(str2, qgVar2, th);
                            return jSONObject2;
                        }
                    }
                    jSONObject2.put("request_id", strQg);
                    if (z2) {
                        jSONObject2.put("exemption_req", 1);
                    }
                    jSONObject2.put("ad_sdk_version", com.byazt.nf.tj.w);
                    jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
                    jSONObject2.put("is_plugin", com.byazt.nf.tj.n());
                    jSONObject2.put("sdk_boost_type", com.byazt.gv.n.l());
                    if (com.byazt.nf.tj.l()) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    jSONObject2.put("is_use_tt_video", i4);
                    long jCurrentTimeMillis7 = (System.currentTimeMillis() - jCurrentTimeMillis6) + 0;
                    long jCurrentTimeMillis8 = System.currentTimeMillis();
                    long jCurrentTimeMillis9 = System.currentTimeMillis();
                    qgVarN = com.byazt.wq.qg.n();
                    n(yVar, "liveInstance", jCurrentTimeMillis9, z5);
                    long jCurrentTimeMillis10 = System.currentTimeMillis();
                    iS = qgVarN.s();
                    jSONObject2.put("live_sdk_status", iS);
                    n(yVar, "liveSdkStatus", jCurrentTimeMillis10, z5);
                    long jCurrentTimeMillis11 = System.currentTimeMillis();
                    jSONObject2.put("live_auth_status", qgVarN.l());
                    n(yVar, "liveAuthStatus", jCurrentTimeMillis11, z5);
                    jSONObject2.put("live_sdk_config", qgVarN.fs());
                    long jCurrentTimeMillis12 = System.currentTimeMillis();
                    jSONObject2.put("live_ad_click_count", qgVarN.w());
                    n(yVar, "liveAdClickCount", jCurrentTimeMillis12, z5);
                    n(yVar, "liveSupportCode", System.currentTimeMillis(), z5);
                    long jCurrentTimeMillis13 = System.currentTimeMillis();
                    com.byazt.vyf.s.cy().d();
                    n(yVar, "liveOaidNotify", jCurrentTimeMillis13, z5);
                    if (iS != 2) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        jSONObject2.put("app_start_time", jElapsedRealtime - Process.getStartElapsedRealtime());
                        jSONObject2.put("live_last_init_time", jElapsedRealtime - qgVarN.rv());
                    }
                    if (com.byazt.vyf.s.cy().oj()) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    jSONObject2.put("csj_type", i5);
                    jSONObject2.put("pma_data", com.byazt.zk.n.n().qg());
                    strX = qgVarN.x();
                    if (!TextUtils.isEmpty(strX)) {
                        jSONObject2.put("live_plugin_version", strX);
                    }
                    n(yVar, "liveInfo", jCurrentTimeMillis8, z5);
                    long jCurrentTimeMillis14 = System.currentTimeMillis();
                    jSONObject2.put("source_type", a.C0017a.c);
                    jSONObject2.put("logsdk_version", com.byazt.ed.s.n().l(i));
                    jCurrentTimeMillis = jCurrentTimeMillis7 + (System.currentTimeMillis() - jCurrentTimeMillis14);
                    long jCurrentTimeMillis15 = System.currentTimeMillis();
                    if (i2 != 4 || z5) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    jSONObject2.put(a.C0017a.c, DeviceUtils.n(i, z3));
                    n(yVar, "appInfo", jCurrentTimeMillis15, z5);
                    long jCurrentTimeMillis16 = System.currentTimeMillis();
                    Context context = this.qg;
                    if (z5) {
                        yVar2 = yVar;
                    } else {
                        yVar2 = null;
                    }
                    jSONObjectN = com.byazt.ehw.n.n(context, i, yVar2);
                    n(yVar, "deviceInfo", jCurrentTimeMillis16, z5);
                    long jCurrentTimeMillis17 = System.currentTimeMillis();
                    if (jSONObjectN != null) {
                        if (!com.byazt.nf.rv.qg().o() && !com.byazt.iz.rv.qg()) {
                            jSONObjectN.remove("free_space");
                        }
                        qgVar2 = qgVar;
                        if (qgVar2 != null) {
                            try {
                                if (qgVar.k() > 0) {
                                    jSONObjectN.put("orientation", qgVar.k());
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str2 = strQg;
                                n(str2, qgVar2, th);
                            }
                        }
                        if (com.byazt.ed.s.n().x(i)) {
                            Object obj2 = obj;
                            jSONObjectN.put("wifi_signal", obj2);
                            jSONObjectN.put("cellular_signal", obj2);
                        } else {
                            jSONObjectN.put("wifi_signal", DeviceUtils.n(0));
                            jSONObjectN.put("cellular_signal", DeviceUtils.n(1));
                        }
                        if (i2 != 4) {
                            jSONObjectN.put("sof_chara", com.byazt.cl.s.x());
                        }
                        com.byazt.ehw.q.n(jSONObjectN);
                        jSONObjectN.put("cpu_arch", com.byazt.cl.s.sz());
                        jSONObjectN.put("direction", com.byazt.hnb.qg.n().w());
                        jSONObjectN.put("font_size", com.byazt.wb.s.x().sz());
                        jSONObjectN.put("gpu_model", com.byazt.wb.fs.n());
                    } else {
                        qgVar2 = qgVar;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                    }
                    jSONObject2.put("device", jSONObjectN);
                    n(yVar, "deviceExtra", jCurrentTimeMillis17, z5);
                    long jCurrentTimeMillis18 = System.currentTimeMillis();
                    jSONObject2.put("sdk_extra_data", n(qgVar2, i2));
                    jSONObject2.put("pan_code_serial", "1000");
                    n(yVar, "sdkExtraData", jCurrentTimeMillis18, z5);
                    long jCurrentTimeMillis19 = System.currentTimeMillis();
                    jSONObject2.put("user", s(qgVar2, i));
                    n(yVar, "userInfo", jCurrentTimeMillis19, z5);
                    long jCurrentTimeMillis20 = System.currentTimeMillis();
                    jSONObject2.put("ua", ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).qg(false));
                    n(yVar, "uaInfo", jCurrentTimeMillis20, z5);
                    jSONObject2.put("channel", com.byazt.nf.tj.rv);
                    long jCurrentTimeMillis21 = System.currentTimeMillis();
                    strArrN = com.byazt.ehw.n.n(i);
                    strConcat = "";
                    if (strArrN != null || strArrN.length < 2) {
                        z4 = false;
                        str3 = "";
                        str4 = str3;
                    } else {
                        z4 = false;
                        str4 = strArrN[0];
                        str3 = strArrN[1];
                    }
                    jSONObject2.put("ip", str4);
                    jSONObject2.put("client_ipv6", str3);
                    jSONObject2.put("client_ipv4", com.byazt.ehw.n.n(str4, i));
                    n(yVar, "ipInfo", jCurrentTimeMillis21, z5);
                    long jCurrentTimeMillis22 = System.currentTimeMillis();
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(n(qgVar2, i, yVar));
                    jSONObject2.put("adslots", jSONArray);
                    n(yVar, "adslotInfo", jCurrentTimeMillis22, z5);
                    long jCurrentTimeMillis23 = System.currentTimeMillis();
                    if (yVar != null && yVar.sz > 0) {
                        jSONObject2.put("load_ad_api", yVar.sz);
                    }
                    com.byazt.ehw.n.n((JSONObject) jSONObject2, i);
                    ?? jSONObject3 = new JSONObject();
                    jSONObject3.put("start2req_time", SystemClock.elapsedRealtime() - l.l);
                    if (l.qg.get()) {
                        r12 = z4;
                    } else {
                        r12 = 1;
                    }
                    jSONObject3.put("start_type", r12);
                    jSONObject3.put("show_count", com.byazt.hm.n.n);
                    jSONObject2.put("ads_parameter", jSONObject3);
                    n(jSONObject2, yVar);
                    jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
                    jSONObject2.put("ts", jCurrentTimeMillis2);
                    if (qgVar.q() != null && strQg != null) {
                        strConcat = String.valueOf(jCurrentTimeMillis2).concat(qgVar.q()).concat(strQg);
                    }
                    jSONObject2.put("req_sign", com.byazt.tk.l.qg(strConcat));
                    jCurrentTimeMillis3 = jCurrentTimeMillis + (System.currentTimeMillis() - jCurrentTimeMillis23);
                    if (yVar != null) {
                        yVar.n("basicFields", jCurrentTimeMillis3, z5);
                    }
                    if (i2 == 4) {
                        jCurrentTimeMillis5 = System.currentTimeMillis();
                        jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(com.byazt.nf.rv.qg().n(qgVar.q())));
                        if (com.byazt.nf.rv.qg().qg(qgVar.q())) {
                            if (7 == qgVar.a()) {
                                z4 = true;
                            }
                            n(z4, jSONObject2, qgVar.q());
                        } else {
                            com.byazt.eji.s.n().n(qgVar.q(), (String) null, (String) null, true);
                        }
                        if (yVar != null && yVar.k != null) {
                            yVar.k.n("precache_time", System.currentTimeMillis() - jCurrentTimeMillis5);
                        }
                    }
                    if (z) {
                        jSONObject2.put("ad_sdk_version", com.byazt.nf.tj.w);
                        return jSONObject2;
                    }
                    if (i2 == 3) {
                        jSONObject2.put("material_keys", w.n(qgVar));
                    }
                    jCurrentTimeMillis4 = System.currentTimeMillis();
                    if (com.byazt.nf.rv.qg().cl()) {
                        jSONObject2.put("feature_data", com.byazt.wb.s.x().rv());
                        n(yVar, "featureV1", jCurrentTimeMillis4, z5);
                    }
                    long jCurrentTimeMillis24 = System.currentTimeMillis();
                    if (i2 != 4 || z5) {
                        com.byazt.rm.qg.n(qgVar2, i3);
                        jSONObjectS = com.byazt.aun.q.n().s();
                        if (jSONObjectS != null && jSONObjectS.length() > 0) {
                            jSONObject2.putOpt("feature_data_v2", jSONObjectS);
                        }
                    }
                    n(yVar, "featureV2", jCurrentTimeMillis24, z5);
                    if (com.byazt.uq.s.q()) {
                        qg(jSONObject2, qgVar2, yVar);
                        jSONObjectN2 = n(yVar);
                        if (jSONObjectN2 != null && jSONObjectN2.length() > 0) {
                            jSONObject2.put("load_feature", jSONObjectN2);
                        }
                    }
                    if (yVar != null && yVar.hd > 0) {
                        jSONObject2.put("second_page_type", yVar.hd);
                        jSONObject2.put("second_page_origin_req_id", yVar.cd);
                    }
                    jSONArrayN = com.byazt.gh.l.n();
                    if (jSONArrayN != null && jSONArrayN.length() > 0) {
                        jSONObject2.putOpt("csj_sdk_abilities", jSONArrayN);
                    }
                    long jCurrentTimeMillis25 = System.currentTimeMillis();
                    com.byazt.wfe.n.n((JSONObject) jSONObject2);
                    n(yVar, "dplStatusCounter", jCurrentTimeMillis25, z5);
                } catch (Throwable th4) {
                    th = th4;
                    qgVar2 = qgVar;
                    str2 = strQg;
                    n(str2, qgVar2, th);
                    return jSONObject2;
                }
            } else {
                iN = -1;
                if (i == 7) {
                    if (yVar != null) {
                        iN = yVar.n;
                        jSONObject2.put(h.b.c, iN);
                    }
                    if (yVar != null) {
                        jSONObject2.put("pre_sessions", yVar.s);
                        jSONObject2.put("play_again_count", yVar.q);
                    }
                } else if (i == 8) {
                    iN = yVar.n;
                    jSONObject2.put(h.b.c, iN);
                }
                strL = com.byazt.ed.q.n().l();
                strW = com.byazt.ed.q.n().w();
                i3 = iN;
                jSONObject = new JSONObject();
                if (TextUtils.isEmpty(strL)) {
                    obj = "unknown";
                    jSONObject.putOpt("version", strL);
                } else {
                    obj = "unknown";
                }
                if (qgVar != null) {
                    strN = w.n(qgVar.hd());
                    if (!TextUtils.isEmpty(strN)) {
                        jSONObject.put("external_ab_vid", strN);
                    }
                } else {
                    strN = null;
                }
                if (!TextUtils.isEmpty(strW)) {
                    jSONObject.putOpt("param", strW);
                }
                if (TextUtils.isEmpty(strL)) {
                    jSONObject2.put("abtest", jSONObject);
                } else {
                    jSONObject2.put("abtest", jSONObject);
                }
                if (z5) {
                    andSet = tj.qg.getAndSet(0);
                    if (andSet > 0) {
                        jSONObject2.put("throttle_count", andSet);
                    }
                }
                jSONObject2.put("request_id", strQg);
                if (z2) {
                    jSONObject2.put("exemption_req", 1);
                }
                jSONObject2.put("ad_sdk_version", com.byazt.nf.tj.w);
                jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
                jSONObject2.put("is_plugin", com.byazt.nf.tj.n());
                jSONObject2.put("sdk_boost_type", com.byazt.gv.n.l());
                if (com.byazt.nf.tj.l()) {
                    i4 = 1;
                } else {
                    i4 = 2;
                }
                jSONObject2.put("is_use_tt_video", i4);
                long jCurrentTimeMillis26 = (System.currentTimeMillis() - jCurrentTimeMillis6) + 0;
                long jCurrentTimeMillis27 = System.currentTimeMillis();
                long jCurrentTimeMillis28 = System.currentTimeMillis();
                qgVarN = com.byazt.wq.qg.n();
                n(yVar, "liveInstance", jCurrentTimeMillis28, z5);
                long jCurrentTimeMillis110 = System.currentTimeMillis();
                iS = qgVarN.s();
                jSONObject2.put("live_sdk_status", iS);
                n(yVar, "liveSdkStatus", jCurrentTimeMillis110, z5);
                long jCurrentTimeMillis111 = System.currentTimeMillis();
                jSONObject2.put("live_auth_status", qgVarN.l());
                n(yVar, "liveAuthStatus", jCurrentTimeMillis111, z5);
                jSONObject2.put("live_sdk_config", qgVarN.fs());
                long jCurrentTimeMillis112 = System.currentTimeMillis();
                jSONObject2.put("live_ad_click_count", qgVarN.w());
                n(yVar, "liveAdClickCount", jCurrentTimeMillis112, z5);
                n(yVar, "liveSupportCode", System.currentTimeMillis(), z5);
                long jCurrentTimeMillis113 = System.currentTimeMillis();
                com.byazt.vyf.s.cy().d();
                n(yVar, "liveOaidNotify", jCurrentTimeMillis113, z5);
                if (iS != 2) {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    jSONObject2.put("app_start_time", jElapsedRealtime2 - Process.getStartElapsedRealtime());
                    jSONObject2.put("live_last_init_time", jElapsedRealtime2 - qgVarN.rv());
                }
                if (com.byazt.vyf.s.cy().oj()) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                jSONObject2.put("csj_type", i5);
                jSONObject2.put("pma_data", com.byazt.zk.n.n().qg());
                strX = qgVarN.x();
                if (!TextUtils.isEmpty(strX)) {
                    jSONObject2.put("live_plugin_version", strX);
                }
                n(yVar, "liveInfo", jCurrentTimeMillis27, z5);
                long jCurrentTimeMillis114 = System.currentTimeMillis();
                jSONObject2.put("source_type", a.C0017a.c);
                jSONObject2.put("logsdk_version", com.byazt.ed.s.n().l(i));
                jCurrentTimeMillis = jCurrentTimeMillis26 + (System.currentTimeMillis() - jCurrentTimeMillis114);
                long jCurrentTimeMillis115 = System.currentTimeMillis();
                if (i2 != 4) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                jSONObject2.put(a.C0017a.c, DeviceUtils.n(i, z3));
                n(yVar, "appInfo", jCurrentTimeMillis115, z5);
                long jCurrentTimeMillis116 = System.currentTimeMillis();
                Context context2 = this.qg;
                if (z5) {
                    yVar2 = yVar;
                } else {
                    yVar2 = null;
                }
                jSONObjectN = com.byazt.ehw.n.n(context2, i, yVar2);
                n(yVar, "deviceInfo", jCurrentTimeMillis116, z5);
                long jCurrentTimeMillis117 = System.currentTimeMillis();
                if (jSONObjectN != null) {
                    if (!com.byazt.nf.rv.qg().o()) {
                        jSONObjectN.remove("free_space");
                    }
                    qgVar2 = qgVar;
                    if (qgVar2 != null) {
                        if (qgVar.k() > 0) {
                            jSONObjectN.put("orientation", qgVar.k());
                        }
                    }
                    if (com.byazt.ed.s.n().x(i)) {
                        Object obj3 = obj;
                        jSONObjectN.put("wifi_signal", obj3);
                        jSONObjectN.put("cellular_signal", obj3);
                    } else {
                        jSONObjectN.put("wifi_signal", DeviceUtils.n(0));
                        jSONObjectN.put("cellular_signal", DeviceUtils.n(1));
                    }
                    if (i2 != 4) {
                        jSONObjectN.put("sof_chara", com.byazt.cl.s.x());
                    }
                    com.byazt.ehw.q.n(jSONObjectN);
                    jSONObjectN.put("cpu_arch", com.byazt.cl.s.sz());
                    jSONObjectN.put("direction", com.byazt.hnb.qg.n().w());
                    jSONObjectN.put("font_size", com.byazt.wb.s.x().sz());
                    jSONObjectN.put("gpu_model", com.byazt.wb.fs.n());
                } else {
                    qgVar2 = qgVar;
                    jCurrentTimeMillis = jCurrentTimeMillis;
                }
                jSONObject2.put("device", jSONObjectN);
                n(yVar, "deviceExtra", jCurrentTimeMillis117, z5);
                long jCurrentTimeMillis118 = System.currentTimeMillis();
                jSONObject2.put("sdk_extra_data", n(qgVar2, i2));
                jSONObject2.put("pan_code_serial", "1000");
                n(yVar, "sdkExtraData", jCurrentTimeMillis118, z5);
                long jCurrentTimeMillis119 = System.currentTimeMillis();
                jSONObject2.put("user", s(qgVar2, i));
                n(yVar, "userInfo", jCurrentTimeMillis119, z5);
                long jCurrentTimeMillis29 = System.currentTimeMillis();
                jSONObject2.put("ua", ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).qg(false));
                n(yVar, "uaInfo", jCurrentTimeMillis29, z5);
                jSONObject2.put("channel", com.byazt.nf.tj.rv);
                long jCurrentTimeMillis210 = System.currentTimeMillis();
                strArrN = com.byazt.ehw.n.n(i);
                strConcat = "";
                if (strArrN != null) {
                    z4 = false;
                    str3 = "";
                    str4 = str3;
                } else {
                    z4 = false;
                    str3 = "";
                    str4 = str3;
                }
                jSONObject2.put("ip", str4);
                jSONObject2.put("client_ipv6", str3);
                jSONObject2.put("client_ipv4", com.byazt.ehw.n.n(str4, i));
                n(yVar, "ipInfo", jCurrentTimeMillis210, z5);
                long jCurrentTimeMillis211 = System.currentTimeMillis();
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(n(qgVar2, i, yVar));
                jSONObject2.put("adslots", jSONArray2);
                n(yVar, "adslotInfo", jCurrentTimeMillis211, z5);
                long jCurrentTimeMillis212 = System.currentTimeMillis();
                if (yVar != null) {
                    jSONObject2.put("load_ad_api", yVar.sz);
                }
                com.byazt.ehw.n.n((JSONObject) jSONObject2, i);
                ?? jSONObject4 = new JSONObject();
                jSONObject4.put("start2req_time", SystemClock.elapsedRealtime() - l.l);
                if (l.qg.get()) {
                    r12 = z4;
                } else {
                    r12 = 1;
                }
                jSONObject4.put("start_type", r12);
                jSONObject4.put("show_count", com.byazt.hm.n.n);
                jSONObject2.put("ads_parameter", jSONObject4);
                n(jSONObject2, yVar);
                jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
                jSONObject2.put("ts", jCurrentTimeMillis2);
                if (qgVar.q() != null) {
                    strConcat = String.valueOf(jCurrentTimeMillis2).concat(qgVar.q()).concat(strQg);
                }
                jSONObject2.put("req_sign", com.byazt.tk.l.qg(strConcat));
                jCurrentTimeMillis3 = jCurrentTimeMillis + (System.currentTimeMillis() - jCurrentTimeMillis212);
                if (yVar != null) {
                    yVar.n("basicFields", jCurrentTimeMillis3, z5);
                }
                if (i2 == 4) {
                    jCurrentTimeMillis5 = System.currentTimeMillis();
                    jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(com.byazt.nf.rv.qg().n(qgVar.q())));
                    if (com.byazt.nf.rv.qg().qg(qgVar.q())) {
                        if (7 == qgVar.a()) {
                            z4 = true;
                        }
                        n(z4, jSONObject2, qgVar.q());
                    } else {
                        com.byazt.eji.s.n().n(qgVar.q(), (String) null, (String) null, true);
                    }
                    if (yVar != null) {
                        yVar.k.n("precache_time", System.currentTimeMillis() - jCurrentTimeMillis5);
                    }
                }
                if (z) {
                    jSONObject2.put("ad_sdk_version", com.byazt.nf.tj.w);
                    return jSONObject2;
                }
                if (i2 == 3) {
                    jSONObject2.put("material_keys", w.n(qgVar));
                }
                jCurrentTimeMillis4 = System.currentTimeMillis();
                if (com.byazt.nf.rv.qg().cl()) {
                    jSONObject2.put("feature_data", com.byazt.wb.s.x().rv());
                    n(yVar, "featureV1", jCurrentTimeMillis4, z5);
                }
                long jCurrentTimeMillis213 = System.currentTimeMillis();
                if (i2 != 4) {
                    com.byazt.rm.qg.n(qgVar2, i3);
                    jSONObjectS = com.byazt.aun.q.n().s();
                    if (jSONObjectS != null) {
                        jSONObject2.putOpt("feature_data_v2", jSONObjectS);
                    }
                } else {
                    com.byazt.rm.qg.n(qgVar2, i3);
                    jSONObjectS = com.byazt.aun.q.n().s();
                    if (jSONObjectS != null) {
                        jSONObject2.putOpt("feature_data_v2", jSONObjectS);
                    }
                }
                n(yVar, "featureV2", jCurrentTimeMillis213, z5);
                if (com.byazt.uq.s.q()) {
                    qg(jSONObject2, qgVar2, yVar);
                    jSONObjectN2 = n(yVar);
                    if (jSONObjectN2 != null) {
                        jSONObject2.put("load_feature", jSONObjectN2);
                    }
                }
                if (yVar != null) {
                    jSONObject2.put("second_page_type", yVar.hd);
                    jSONObject2.put("second_page_origin_req_id", yVar.cd);
                }
                jSONArrayN = com.byazt.gh.l.n();
                if (jSONArrayN != null) {
                    jSONObject2.putOpt("csj_sdk_abilities", jSONArrayN);
                }
                long jCurrentTimeMillis214 = System.currentTimeMillis();
                com.byazt.wfe.n.n((JSONObject) jSONObject2);
                n(yVar, "dplStatusCounter", jCurrentTimeMillis214, z5);
            }
        } catch (Throwable th5) {
            th = th5;
            qgVar2 = qgVar;
            str2 = null;
        }
        return jSONObject2;
    }

    private String n(com.byazt.zq.qg qgVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_settings_update", com.byazt.ehw.qg.qg(System.currentTimeMillis()));
            if (qg(qgVar, i)) {
                jSONObject.put("can_merge_same_rit_request", 1);
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    private boolean qg(com.byazt.zq.qg qgVar, int i) {
        if (i == 5 && qgVar != null && !TextUtils.isEmpty(qgVar.q()) && com.byazt.ph.q.cy()) {
            try {
                com.byazt.udc.n.n();
                return com.byazt.phf.n.qg(qgVar.q());
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static void n(y yVar, String str, long j, boolean z) {
        if (yVar != null) {
            yVar.n(str, System.currentTimeMillis() - j, z);
        }
    }

    private void n(String str, com.byazt.zq.qg qgVar, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("req_id", str);
            if (qgVar != null) {
                jSONObject.putOpt("slot", qgVar.q());
            }
            com.byazt.eji.s.n().n("b_ad_req", jSONObject, th);
        } catch (Throwable unused) {
        }
    }

    private void n(JSONObject jSONObject, y yVar) {
        if (yVar == null || yVar.w == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", yVar.w);
        } catch (Exception unused) {
        }
    }

    private void n(com.byazt.gct.qg qgVar, long j, long j2, long j3, long j4) {
        if (qgVar == null) {
            return;
        }
        qgVar.n(j);
        qgVar.qg(j3);
        qgVar.s(j2);
        qgVar.q(j4);
    }

    private long[] n(com.byazt.qk.oa oaVar, com.byazt.shr.tj tjVar, int i) {
        long jFs;
        long jX;
        com.byazt.qk.tj tjVarW;
        long[] jArr = {0, 0};
        if (tjVar == null) {
            return jArr;
        }
        long jMax = Math.max(0, i);
        if (oaVar == null || (tjVarW = oaVar.w()) == null || tjVarW.fs() <= 0) {
            jFs = 0;
            jX = 0;
        } else {
            jFs = (tjVar.tj() <= 0 || tjVarW.fs() <= tjVar.tj()) ? 0L : tjVarW.fs() - tjVar.tj();
            jX = tjVarW.rv() > tjVarW.fs() ? tjVarW.rv() - tjVarW.fs() : 0L;
        }
        if (jX <= 0) {
            jX = tjVar.x() - tjVar.tj();
        }
        long j = jX - jMax;
        if (jFs <= 0) {
            jFs = 0;
        }
        jArr[0] = jFs;
        jArr[1] = j > 0 ? j : 0L;
        return jArr;
    }

    @Override // com.byazt.mw.n
    @JProtect
    public void n(final com.byazt.zq.qg qgVar, final y yVar, final int i, com.byazt.mw.n.qg qgVar2) {
        final com.byazt.yy.n nVar = new com.byazt.yy.n(qgVar2);
        nVar.n(i);
        if ((i != 3 || !com.byazt.hi.w.n(qgVar)) && Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.qit.l.q(new x("get_ad") { // from class: com.byazt.mw.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.q(qgVar, yVar, i, nVar);
                }
            });
        } else {
            q(qgVar, yVar, i, nVar);
        }
    }

    @Override // com.byazt.mw.n
    public void qg(final com.byazt.zq.qg qgVar, final y yVar, final int i, com.byazt.mw.n.qg qgVar2) {
        final com.byazt.yy.n nVar = new com.byazt.yy.n(qgVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.qit.l.qg(new x("bid_pre") { // from class: com.byazt.mw.qg.12
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.n(qgVar, yVar, i, nVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            n(qgVar, yVar, i, nVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    public cd n(com.byazt.zq.qg qgVar, com.byazt.gct.qg qgVar2, y yVar, int i, int i2, com.byazt.mw.n.qg qgVar3, boolean z) {
        cd cdVarQg;
        com.byazt.lq.s.n(qgVar);
        boolean z2 = i2 == 5;
        yVar.n("buildAdBodyReady", z2);
        JSONObject jSONObjectN = n(qgVar, yVar, i, false, i2, z);
        yVar.n("doBuildAdBody", z2);
        if (jSONObjectN == null) {
            qgVar2.n(-9);
            qgVar3.n(-9, com.byazt.bxg.n.n(-9), qgVar2);
            return null;
        }
        String string = jSONObjectN.toString();
        if (i2 == 5) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            cdVarQg = com.byazt.cl.q.n().n(string);
            yVar.n("encrypt", System.currentTimeMillis() - jCurrentTimeMillis, z2);
        } else {
            cdVarQg = com.byazt.cl.q.n().qg(string);
        }
        if (cdVarQg == null) {
            qgVar2.n(-9);
            qgVar3.n(-9, com.byazt.bxg.n.n(-9), qgVar2);
            return null;
        }
        cdVarQg.n(jSONObjectN);
        return cdVarQg;
    }

    private boolean n(com.byazt.phf.l lVar, String str) {
        if (lVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return lVar.n(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.zq.qg qgVar, y yVar, int i, com.byazt.mw.n.qg qgVar2, String str, int i2) {
        s(qgVar, yVar, i, qgVar2, str, i2);
    }

    public void q(com.byazt.zq.qg qgVar, y yVar, int i, com.byazt.mw.n.qg qgVar2) {
        if (qgVar != null && qgVar.j()) {
            if (com.byazt.ph.q.oa()) {
                qg(qgVar, yVar, i, qgVar2, "/api/ad/union/sdk/anti_req/", 5);
                return;
            }
            com.byazt.gct.qg qgVar3 = new com.byazt.gct.qg();
            qgVar3.n(qgVar);
            qgVar3.n(-17);
            qgVar2.n(-17, com.byazt.bxg.n.n(-17), qgVar3);
            return;
        }
        s(qgVar, yVar, i, qgVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    private void qg(final com.byazt.zq.qg qgVar, final y yVar, int i, final com.byazt.mw.n.qg qgVar2, String str, int i2) {
        final com.byazt.gct.qg qgVar3 = new com.byazt.gct.qg();
        qgVar3.n(qgVar);
        try {
            com.byazt.wd.cp cpVar = new com.byazt.wd.cp();
            cpVar.qg(false);
            cpVar.n(true);
            com.byazt.qk.rv rvVarN = n(qgVar, yVar, i, qgVar2, str, i2, qgVar3, cpVar);
            if (rvVarN == null) {
                qgVar3.n(-15);
                qgVar2.n(-15, com.byazt.bxg.n.n(-15), qgVar3);
            } else {
                rvVarN.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.20
                    @Override // com.byazt.qk.x
                    public void n(com.byazt.qk.oa oaVar) {
                        JSONObject jSONObject;
                        if (oaVar == null || (jSONObject = (JSONObject) com.byazt.cl.q.n(oaVar, "get_ads", true).second) == null) {
                            return;
                        }
                        n nVarN = n.n(jSONObject, qgVar, yVar);
                        if (nVarN.q != 20000) {
                            qgVar3.n(nVarN.q);
                            qgVar3.qg(nVarN.w);
                            StringBuilder sb = new StringBuilder("reason: ");
                            sb.append(nVarN.w).append("  message: ").append(nVarN.l);
                            qgVar2.n(nVarN.q, sb.toString(), qgVar3);
                        }
                    }

                    @Override // com.byazt.qk.x
                    public void n(int i3, String str2, Throwable th) {
                        qg.this.n(th, qgVar3, qgVar2);
                    }
                });
                com.byazt.vyf.qg.n().q();
                n();
            }
        } catch (Throwable th) {
            qg(th, qgVar3, qgVar2);
        }
    }

    private void s(final com.byazt.zq.qg qgVar, final y yVar, final int i, final com.byazt.mw.n.qg qgVar2, String str, final int i2) {
        final com.byazt.qk.rv rvVarN;
        final com.byazt.gct.qg qgVar3 = new com.byazt.gct.qg();
        qgVar3.n(qgVar);
        try {
            com.byazt.wd.cp cpVarN = n(qgVar, qgVar3, qgVar2, i2 == 5, yVar, i);
            if (cpVarN.qg() || (rvVarN = n(qgVar, yVar, i, qgVar2, str, i2, qgVar3, cpVarN)) == null) {
                return;
            }
            rvVarN.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.21
                @Override // com.byazt.qk.x
                public void n(com.byazt.qk.oa oaVar) {
                    qg.this.n(rvVarN, oaVar, qgVar3, qgVar2, qgVar, yVar, i, i2);
                }

                @Override // com.byazt.qk.x
                public void n(int i3, String str2, Throwable th) {
                    qg.this.n(th, qgVar3, qgVar2);
                }
            });
            com.byazt.vyf.qg.n().q();
            n();
        } catch (Throwable th) {
            qg(th, qgVar3, qgVar2);
        }
    }

    private com.byazt.wd.cp n(com.byazt.zq.qg qgVar, com.byazt.gct.qg qgVar2, com.byazt.mw.n.qg qgVar3, boolean z, y yVar, int i) {
        com.byazt.wd.cp cpVar = new com.byazt.wd.cp();
        cpVar.qg(true);
        if (qgVar3 == null) {
            return cpVar;
        }
        if (!com.byazt.ivn.l.n()) {
            qgVar2.n(1000);
            qgVar3.n(1000, "广告请求开关已关闭,请联系穿山甲管理员", qgVar2);
            return cpVar;
        }
        if (z) {
            yVar.n("execGetAdReady", z);
            if (!TextUtils.isEmpty(qgVar.py()) && yVar.l <= 0) {
                n(qgVar2, qgVar, qgVar3, yVar, i);
                return cpVar;
            }
            cpVar.qg(tj.n.n(qgVar2, qgVar, i, qgVar3, yVar, cpVar));
            return cpVar;
        }
        cpVar.qg(false);
        return cpVar;
    }

    private void n(com.byazt.gct.qg qgVar, com.byazt.zq.qg qgVar2, final com.byazt.mw.n.qg qgVar3, y yVar, int i) {
        qgVar.s(2);
        qgVar.n(qgVar2.py());
        try {
            boolean z = false;
            JSONObject jSONObjectN = com.byazt.cl.q.n(new JSONObject(qgVar2.py()), false, true);
            if (jSONObjectN == null) {
                n(qgVar3, qgVar);
                return;
            }
            n nVarN = n.n(jSONObjectN, qgVar2, yVar);
            qgVar.n(nVarN.cp);
            qg(nVarN.rv);
            if (nVarN.q != 20000) {
                qgVar.n(nVarN.q);
                StringBuilder sb = new StringBuilder("reason: ");
                sb.append(nVarN.w).append("  message: ").append(nVarN.l);
                qgVar3.n(nVarN.q, sb.toString(), qgVar);
                return;
            }
            if (nVarN.fs == null) {
                n(qgVar3, qgVar);
                return;
            }
            nVarN.fs.n(jSONObjectN);
            List<pk> listQg = nVarN.fs.qg();
            if (listQg != null) {
                List<pk> arrayList = new ArrayList<>(listQg);
                for (pk pkVar : listQg) {
                    pk pkVarN = com.byazt.ed.l.n(pkVar.ha(), i, pkVar.mk());
                    if (pkVarN != null) {
                        arrayList.remove(pkVar);
                        pkVarN.an(pkVar.fb());
                        arrayList.add(pkVarN);
                    } else if (pkVar.g()) {
                        final String str = nVarN.x;
                        if (!TextUtils.isEmpty(str) && yVar != null) {
                            yVar.n(str);
                        }
                        final String strQ = qgVar2.q();
                        final String strN = w.n(qgVar2);
                        com.byazt.nf.rv.n().s(qgVar2, yVar, i, new com.byazt.mw.n.qg() { // from class: com.byazt.mw.qg.22
                            @Override // com.byazt.mw.n.qg
                            public void n(int i2, String str2, com.byazt.gct.qg qgVar4) {
                                com.byazt.eji.s.n().n(i2, str2, str, strQ, strN);
                                qgVar3.n(i2, str2, qgVar4);
                            }

                            @Override // com.byazt.mw.n.qg
                            public void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar4) {
                                com.byazt.eji.s.n().n(0, "success", str, strQ, strN);
                                qgVar3.n(nVar, qgVar4);
                            }
                        });
                        z = true;
                    }
                }
                if (z) {
                    return;
                } else {
                    nVarN.fs.n(arrayList);
                }
            }
            qgVar3.n(nVarN.fs, qgVar);
        } catch (Throwable th) {
            k.n("NetApiImpl", "get ad error: ", th);
            n(qgVar3, qgVar);
        }
    }

    private com.byazt.qk.rv n(com.byazt.zq.qg qgVar, y yVar, int i, com.byazt.mw.n.qg qgVar2, String str, int i2, com.byazt.gct.qg qgVar3, com.byazt.wd.cp cpVar) throws JSONException {
        boolean z;
        String strN;
        byte[] bytes;
        Map<String, String> mapN;
        com.byazt.phf.l lVarQ = cpVar.q();
        if (n(lVarQ, "beforeReqBody")) {
            cpVar.qg(true);
            qgVar3.n(-8);
            qgVar2.n(-8, com.byazt.bxg.n.n(-8), qgVar3);
            return null;
        }
        cd cdVarN = n(qgVar, qgVar3, yVar, i, i2, qgVar2, cpVar.s());
        if (cdVarN == null) {
            return null;
        }
        com.byazt.qk.rv rvVarN = com.byazt.phf.s.n();
        if (cpVar.n()) {
            strN = w.cp(str);
            z = true;
        } else {
            z = true;
            strN = w.n(str, true);
        }
        String strN2 = com.byazt.dh.s.n(rvVarN, strN);
        rvVarN.n(strN2);
        if (cdVarN.n() != null) {
            com.byazt.dh.s.n(cdVarN.n(), 0);
        }
        if (i2 == 5) {
            if (cdVarN.q() != null) {
                JSONObject jSONObjectQ = cdVarN.q();
                rvVarN.n(jSONObjectQ);
                bytes = jSONObjectQ.toString().getBytes(StandardCharsets.UTF_8);
            } else if (cdVarN.s() != null) {
                bytes = cdVarN.s();
                rvVarN.n(bytes);
            } else {
                qgVar3.n(-15);
                qgVar2.n(-15, com.byazt.bxg.n.n(-15), qgVar3);
                return null;
            }
        } else {
            JSONObject jSONObjectQ2 = cdVarN.q();
            rvVarN.n(jSONObjectQ2);
            bytes = jSONObjectQ2.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z2 = i2 == 5 ? z : false;
        yVar.n("doHttpReqSignReady", z2);
        com.byazt.orb.n nVarN = com.byazt.orb.n.n(z);
        yVar.n("MSInst", z2);
        Map<String, String> mapN2 = nVarN.n(strN2, bytes);
        yVar.n("doHttpReqSign", z2);
        if (mapN2 == null) {
            mapN2 = new HashMap<>();
        }
        if (i2 == 5 && (mapN = com.byazt.lq.s.n(qgVar.q())) != null) {
            mapN2.putAll(mapN);
        }
        com.byazt.lq.l.n(mapN2);
        Map<String, String> mapL = cdVarN.l();
        rvVarN.n(RequestParamsUtils.USER_AGENT_KEY, ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).qg(false));
        if (mapL != null) {
            mapN2.putAll(mapL);
        }
        if (mapN2.size() > 0) {
            for (Map.Entry<String, String> entry : mapN2.entrySet()) {
                rvVarN.n(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> mapN3 = n(bytes, mapL, cdVarN);
        if (z2) {
            boolean zCy = com.byazt.ph.q.cy();
            n(mapN3, qgVar, zCy && n(cdVarN), zCy || com.byazt.phf.n.n(), zCy);
        }
        if (n(lVarQ, "reqBodyEnd")) {
            cpVar.qg(true);
            qgVar3.n(-8);
            qgVar2.n(-8, com.byazt.bxg.n.n(-8), qgVar3);
            return null;
        }
        if (mapN3 != null && lVarQ != null) {
            mapN3.put("extra_request_drop_decision_listener", lVarQ);
        }
        rvVarN.n(mapN3);
        yVar.n("appendHeader", z2);
        return rvVarN;
    }

    private void n(Map<String, Object> map, com.byazt.zq.qg qgVar, boolean z, boolean z2, boolean z3) {
        if (map == null) {
            return;
        }
        if (z2) {
            map.put("is_get_ads", Boolean.TRUE);
            map.put("get_ads_rit", qgVar == null ? "" : qgVar.q());
        }
        if (z3) {
            com.byazt.udc.n.n();
            map.put("get_ads_request_ts", Long.valueOf(System.currentTimeMillis()));
            map.put("can_merge_same_rit_request", Boolean.valueOf(z));
        }
    }

    private boolean n(cd cdVar) {
        if (cdVar != null && cdVar.n() != null) {
            try {
                String strOptString = cdVar.n().optString("sdk_extra_data");
                if (!TextUtils.isEmpty(strOptString) && new JSONObject(strOptString).optInt("can_merge_same_rit_request", 0) == 1) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private Map<String, Object> n(byte[] bArr, Map<String, String> map, cd cdVar) {
        HashMap map2 = new HashMap();
        try {
            com.byazt.shr.tj tjVar = new com.byazt.shr.tj();
            tjVar.fs(System.currentTimeMillis());
            tjVar.rv(bArr == null ? 0L : bArr.length);
            tjVar.s(cdVar.qg());
            if (map != null) {
                tjVar.n(map.get("x-pglcypher"));
            }
            tjVar.n(cdVar.n());
            com.byazt.vf.k kVarS = com.byazt.cl.s.s();
            tjVar.qg(kVarS != null ? kVarS.s() : 0);
            tjVar.n(com.byazt.nf.rv.qg().of());
            map2.put("load_time_model", tjVar);
        } catch (Exception unused) {
        }
        return map2;
    }

    private void n() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.q.get() >= 30000) {
            this.q.set(jCurrentTimeMillis);
            com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.mw.qg.23
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.ivn.q.n((com.byazt.ivn.qg) null).s();
                }
            }, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Throwable th, com.byazt.gct.qg qgVar, com.byazt.mw.n.qg qgVar2) {
        if (th != null) {
            if (TextUtils.equals("request_drop_intercept", th.getMessage())) {
                qgVar.n(-8);
                qgVar2.n(-8, com.byazt.bxg.n.n(-8), qgVar);
                Object[] objArr = new Object[2];
                Integer.valueOf(-8);
                return;
            }
            if ("ready queue max count exceeded".equals(th.getMessage())) {
                qgVar.n(-18);
                qgVar.qg(com.byazt.bxg.n.n(-18));
                n(qgVar);
                qgVar2.n(-18, com.byazt.bxg.n.n(-18), qgVar);
                Object[] objArr2 = new Object[2];
                Integer.valueOf(-18);
                return;
            }
            qgVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN);
            qgVar2.n(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, th.getMessage(), qgVar);
            Object[] objArr3 = new Object[2];
            Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE);
        }
    }

    private void n(com.byazt.gct.qg qgVar) {
        com.byazt.zq.qg qgVarX = qgVar == null ? null : qgVar.x();
        final String strQ = qgVarX != null ? qgVarX.q() : null;
        final int iA = qgVarX == null ? 0 : qgVarX.a();
        com.byazt.eji.s.n().n("get_ads_ready_queue_drop", strQ, (String) null, iA, new com.byazt.rs.n() { // from class: com.byazt.mw.qg.24
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("err_code", -18);
                jSONObject2.put("err_msg", com.byazt.bxg.n.n(-18));
                jSONObject2.put("rit", strQ);
                jSONObject2.put("ad_type", iA);
                return jSONObject2;
            }
        });
    }

    private void qg(Throwable th, com.byazt.gct.qg qgVar, com.byazt.mw.n.qg qgVar2) {
        if (qgVar2 != null) {
            qgVar.n(TTAdConstant.INIT_LOCAL_FAIL_CODE);
            qgVar2.n(TTAdConstant.INIT_LOCAL_FAIL_CODE, th.getMessage(), qgVar);
            k.n("NetApiImpl", " msg = ", th.getMessage());
        }
    }

    private void n(com.byazt.qk.oa oaVar, com.byazt.zq.qg qgVar, int i, y yVar, com.byazt.mw.n.qg qgVar2, com.byazt.gct.qg qgVar3, com.byazt.qk.rv rvVar) {
        int i2;
        JSONObject jSONObject;
        if (oaVar != null) {
            if (oaVar.x()) {
                try {
                    com.byazt.shr.tj tjVarN = n(rvVar);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strFs = oaVar.fs();
                    qgVar3.n(strFs);
                    if (com.byazt.lq.qg.n != null) {
                        com.byazt.lq.qg.n.s("NetApiImpl", "response:");
                        com.byazt.lq.qg.n.s("NetApiImpl", strFs);
                    }
                    JSONObject jSONObject2 = new JSONObject(strFs);
                    int iOptInt = jSONObject2.optInt("status_code");
                    String strOptString = new JSONObject(qgVar.py()).optString("auction_price");
                    int i3 = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
                    if (iOptInt != 20000) {
                        if (iOptInt == 40046) {
                            qgVar3.n(iOptInt);
                            qgVar2.n(40046, com.byazt.bxg.n.n(iOptInt), qgVar3);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("adms");
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObject3 = new JSONObject(jSONObjectOptJSONObject.optString(itKeys.next()));
                        jSONObject3.put("auction_price", strOptString);
                        JSONObject jSONObjectN = com.byazt.cl.q.n(jSONObject3, false, true);
                        if (jSONObjectN == null) {
                            n(qgVar2, qgVar3);
                            return;
                        }
                        n nVarN = n.n(jSONObjectN, qgVar, yVar);
                        qgVar3.n(nVarN.cp);
                        if (nVarN.q != i3) {
                            qgVar3.n(nVarN.q);
                            StringBuilder sb = new StringBuilder();
                            sb.append("reason: ").append(nVarN.w).append("  message: ").append(nVarN.l);
                            qgVar2.n(nVarN.q, sb.toString(), qgVar3);
                            com.byazt.wd.rv.n().n(qgVar != null ? qgVar.q() : "", nVarN.q, nVarN.w, qgVar.an());
                            return;
                        }
                        if (nVarN.fs == null) {
                            n(qgVar2, qgVar3);
                            return;
                        }
                        nVarN.fs.n(jSONObjectN);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (yVar != 0) {
                            jSONObject = jSONObjectOptJSONObject;
                            i2 = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
                            n(qgVar3, tjVarN.tj() - yVar.fs, nVarN.n, jCurrentTimeMillis - tjVarN.tj(), jCurrentTimeMillis2 - jCurrentTimeMillis);
                        } else {
                            i2 = i3;
                            jSONObject = jSONObjectOptJSONObject;
                        }
                        qgVar2.n(nVarN.fs, qgVar3);
                        com.byazt.bv.qg.n().n(jSONObjectN);
                        strOptString = strOptString;
                        jSONObjectOptJSONObject = jSONObject;
                        i3 = i2;
                    }
                    return;
                } catch (Throwable th) {
                    k.n("NetApiImpl", "get ad error: ", th);
                    n(qgVar2, qgVar3);
                    return;
                }
            }
            int iN = oaVar.n();
            String strQg = oaVar.qg();
            qgVar3.n(iN);
            qgVar2.n(iN, strQg, qgVar3);
        }
    }

    public void l(final com.byazt.zq.qg qgVar, final y yVar, final int i, com.byazt.mw.n.qg qgVar2) {
        final com.byazt.yy.n nVar = new com.byazt.yy.n(qgVar2);
        com.byazt.qit.l.qg(new x("bid_p_f") { // from class: com.byazt.mw.qg.25
            @Override // java.lang.Runnable
            public void run() {
                qg.this.n(qgVar, yVar, i, nVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    private void n(com.byazt.qk.oa oaVar, com.byazt.zq.qg qgVar, int i, y yVar, com.byazt.mw.n.qg qgVar2, com.byazt.gct.qg qgVar3) {
        if (oaVar != null) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(oaVar.fs()).optJSONArray("ads");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    if (qgVar2 != null) {
                        qgVar2.n(-9, com.byazt.bxg.n.n(-9), qgVar3);
                        return;
                    }
                    return;
                }
                int iY = com.byazt.nf.rv.qg().y();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.getJSONObject(i2).optJSONObject("creative");
                    if (jSONObjectOptJSONObject != null) {
                        JSONObject jSONObjectN = com.byazt.cl.q.n(new JSONObject(jSONObjectOptJSONObject.optString("adm")), false, true);
                        if (jSONObjectN == null && qgVar2 != null) {
                            qgVar2.n(-9, com.byazt.bxg.n.n(-9), qgVar3);
                        } else {
                            n nVarN = n.n(jSONObjectN, qgVar, yVar);
                            com.byazt.ed.l.n(nVarN.fs, i, iY, qgVar.an());
                            if (qgVar2 != null) {
                                qgVar2.n(nVarN.fs, qgVar3);
                            }
                        }
                    } else if (qgVar2 != null) {
                        qgVar2.n(-9, com.byazt.bxg.n.n(-9), qgVar3);
                    }
                }
            } catch (Exception unused) {
                if (qgVar2 != null) {
                    qgVar2.n(-9, com.byazt.bxg.n.n(-9), qgVar3);
                }
            }
        }
    }

    @Override // com.byazt.mw.n
    public void s(final com.byazt.zq.qg qgVar, final y yVar, final int i, com.byazt.mw.n.qg qgVar2) {
        final com.byazt.yy.n nVar = new com.byazt.yy.n(qgVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.qit.l.qg(new x("bid_g_m") { // from class: com.byazt.mw.qg.26
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.n(qgVar, yVar, i, nVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            n(qgVar, yVar, i, nVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    private com.byazt.shr.tj n(com.byazt.qk.rv rvVar) {
        try {
            Map<String, Object> mapQ = rvVar.q();
            if (mapQ == null) {
                return new com.byazt.shr.tj();
            }
            Object obj = mapQ.get("load_time_model");
            if (obj instanceof com.byazt.shr.tj) {
                com.byazt.shr.tj tjVar = (com.byazt.shr.tj) obj;
                tjVar.s(true);
                return tjVar;
            }
            return new com.byazt.shr.tj();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void n(com.byazt.qk.rv rvVar, com.byazt.qk.oa oaVar, com.byazt.gct.qg qgVar, com.byazt.mw.n.qg qgVar2, com.byazt.zq.qg qgVar3, y yVar, int i, int i2) {
        String str;
        com.byazt.shr.tj tjVar;
        int i3;
        long length;
        final JSONObject jSONObjectN;
        final boolean zBooleanValue;
        long length2;
        if (oaVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!oaVar.x()) {
            int iN = oaVar.n();
            String strQg = oaVar.qg();
            qgVar.n(iN);
            qgVar2.n(iN, strQg, qgVar);
            com.byazt.wd.rv.n().n(qgVar3 != null ? qgVar3.q() : "", iN, 0, qgVar3.an());
            com.byazt.wz.qg.qg();
            return;
        }
        if (i2 == 1) {
            n(oaVar, qgVar3, i, yVar, qgVar2, qgVar);
            return;
        }
        if (i2 == 3) {
            n(oaVar, qgVar3, i, yVar, qgVar2, qgVar, rvVar);
            return;
        }
        com.byazt.shr.tj tjVarN = n(rvVar);
        tjVarN.w(jCurrentTimeMillis);
        try {
            final String strFs = oaVar.fs();
            if (i2 == 5) {
                byte[] bArrQ = oaVar.q();
                Pair<Boolean, JSONObject> pairN = com.byazt.cl.q.n(oaVar, "get_ads", true);
                jSONObjectN = (JSONObject) pairN.second;
                zBooleanValue = ((Boolean) pairN.first).booleanValue();
                if (zBooleanValue) {
                    length2 = TextUtils.isEmpty(strFs) ? 0L : strFs.getBytes(StandardCharsets.UTF_8).length;
                    qgVar.n(strFs);
                } else {
                    length2 = bArrQ == null ? 0L : bArrQ.length;
                }
                length = length2;
                if (com.byazt.lq.qg.n == null || jSONObjectN == null) {
                    tjVar = tjVarN;
                    i3 = 0;
                } else {
                    tjVar = tjVarN;
                    i3 = 0;
                    com.byazt.qit.l.qg(new x("logAdapter") { // from class: com.byazt.mw.qg.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String string = "";
                                if (zBooleanValue) {
                                    string = strFs;
                                } else {
                                    Pair<Integer, JSONObject> pairN2 = com.byazt.cl.q.n().n(jSONObjectN.toString(), false);
                                    if (pairN2 != null && pairN2.second != null) {
                                        string = ((JSONObject) pairN2.second).toString();
                                    }
                                }
                                if (com.byazt.lq.qg.n == null || TextUtils.isEmpty(string)) {
                                    return;
                                }
                                com.byazt.lq.qg.n.s("NetApiImpl", "response:");
                                com.byazt.lq.qg.n.s("NetApiImpl", string);
                            } catch (Exception e) {
                                k.n(e.getMessage());
                            }
                        }
                    });
                }
            } else {
                tjVar = tjVarN;
                i3 = 0;
                qgVar.n(strFs);
                if (com.byazt.lq.qg.n != null) {
                    com.byazt.lq.qg.n.s("NetApiImpl", "response:");
                    com.byazt.lq.qg.n.s("NetApiImpl", strFs);
                }
                JSONObject jSONObject = new JSONObject(strFs);
                length = TextUtils.isEmpty(strFs) ? 0L : strFs.getBytes(StandardCharsets.UTF_8).length;
                jSONObjectN = com.byazt.cl.q.n(jSONObject, false, true);
                zBooleanValue = false;
            }
            JSONObject jSONObject2 = jSONObjectN;
            tjVar.x(length);
            if (jSONObject2 == null) {
                n(qgVar2, qgVar);
                return;
            }
            com.byazt.dh.s.qg(jSONObject2, i3);
            n nVarN = n.n(jSONObject2, qgVar3, yVar);
            qgVar.n(nVarN.cp);
            boolean zN = n(nVarN, tjVar);
            qg(nVarN.rv);
            if (nVarN.q != 20000) {
                qgVar.n(nVarN.q);
                qgVar.qg(nVarN.w);
                StringBuilder sb = new StringBuilder("reason: ");
                sb.append(nVarN.w).append("  message: ").append(nVarN.l);
                qgVar2.n(nVarN.q, sb.toString(), qgVar);
                com.byazt.wd.rv.n().n(qgVar3 != null ? qgVar3.q() : "", nVarN.q, nVarN.w, qgVar3.an());
                return;
            }
            if (nVarN.fs == null) {
                n(qgVar2, qgVar);
                return;
            }
            nVarN.fs.n(jSONObject2);
            tjVar.qg(System.currentTimeMillis());
            if (yVar != null) {
                str = "NetApiImpl";
                try {
                    n(qgVar, tjVar.tj() - yVar.fs, nVarN.n, tjVar.x() - tjVar.tj(), tjVar.s() - tjVar.x());
                } catch (Throwable th) {
                    th = th;
                    k.n(str, "get ad error: ", th);
                    n(qgVar2, qgVar);
                    return;
                }
            } else {
                str = "NetApiImpl";
            }
            long[] jArrN = n(oaVar, tjVar, nVarN.n);
            if ((jArrN[i3] > 0 || jArrN[1] > 0) && nVarN.fs.qg() != null) {
                Iterator<pk> it = nVarN.fs.qg().iterator();
                while (it.hasNext()) {
                    it.next().kx().n(jArrN[i3], jArrN[1]);
                }
            }
            qgVar2.n(nVarN.fs, qgVar);
            n(tjVar);
            com.byazt.shr.tj tjVar2 = tjVar;
            if (i2 == 5) {
                n++;
            }
            for (pk pkVar : nVarN.fs.qg()) {
                int i4 = i3;
                if (yVar != null) {
                    pkVar.lh(yVar.qg());
                    pkVar.kx().n(yVar.n);
                    pkVar.kx().qg(1);
                }
                if (com.byazt.aci.n.n(pkVar) || com.byazt.aci.n.q(pkVar)) {
                    com.byazt.ts.qg.n().n(this.qg, com.byazt.aci.n.cp(pkVar));
                }
                i3 = i4;
            }
            int i5 = i3;
            if (tjVar2.oa() && nVarN.fs.qg() != null && !nVarN.fs.qg().isEmpty()) {
                pk pkVar2 = nVarN.fs.qg().get(i5 == true ? 1 : 0);
                com.byazt.vyf.qg.n().n(pkVar2);
                String strQg2 = w.qg(i);
                tjVar2.qg(i2 != 5 ? true : i5 == true ? 1 : 0);
                boolean z = i5;
                if (i2 != 5 || zBooleanValue) {
                    z = 1;
                }
                tjVar2.n(z);
                com.byazt.qk.tj tjVarW = oaVar.w();
                tjVar2.n(nVarN.n);
                if (tjVarW != null) {
                    tjVar2.l(tjVarW.fs());
                    tjVar2.q(tjVarW.rv());
                    tjVar2.tj(tjVarW.n());
                    tjVar2.cp(tjVarW.qg());
                    tjVar2.d(tjVarW.s());
                    tjVar2.oa(tjVarW.q());
                    tjVar2.sz(tjVarW.l());
                }
                n(yVar, pkVar2, strQg2, tjVar2);
                if (zN) {
                    n(pkVar2, i, tjVar2);
                }
            }
            com.byazt.bv.qg.n().n(jSONObject2);
            com.byazt.wz.qg.qg();
        } catch (Throwable th2) {
            th = th2;
            str = "NetApiImpl";
        }
    }

    private void qg(String str) {
        com.byazt.ehw.l.n(str);
        if (com.byazt.orb.n.n() != null) {
            com.byazt.orb.n.n().n(str);
        }
    }

    private boolean n(n nVar, com.byazt.shr.tj tjVar) {
        JSONObject jSONObjectQg;
        boolean zN = false;
        try {
            zN = com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).n("ad_request_result", 0.009999999776482582d);
            JSONObject jSONObjectRv = null;
            if (zN) {
                String strN = com.byazt.ehw.l.n();
                String strS = com.byazt.ehw.l.s();
                boolean zN2 = com.byazt.ehw.qg.n(strN, nVar.rv);
                boolean zN3 = com.byazt.ehw.qg.n(strS, nVar.tj);
                if (zN2 || zN3) {
                    jSONObjectQg = com.byazt.ehw.qg.qg();
                    jSONObjectRv = com.byazt.ehw.qg.fs(tjVar.n());
                } else {
                    jSONObjectQg = null;
                }
                JSONObject jSONObject = new JSONObject();
                com.byazt.ehw.qg.n(jSONObject, new com.byazt.ehw.qg.n(tjVar.n(), strN, nVar.rv, strS, nVar.tj, jSONObjectQg, jSONObjectRv));
                tjVar.qg(jSONObject);
            }
            com.byazt.ehw.l.s(nVar.tj);
            if (!TextUtils.isEmpty(nVar.rv) || !TextUtils.isEmpty(nVar.tj)) {
                if (jSONObjectRv == null) {
                    jSONObjectRv = com.byazt.ehw.qg.rv(tjVar.n());
                }
                tjVar.s(jSONObjectRv);
            }
        } catch (Exception e) {
            k.n("NetApiImpl", "csj", e);
        }
        return zN;
    }

    private void n(com.byazt.shr.tj tjVar) {
        JSONObject jSONObjectOu;
        if (tjVar == null || (jSONObjectOu = tjVar.ou()) == null) {
            return;
        }
        try {
            com.byazt.ehw.qg.x(jSONObjectOu);
        } catch (Exception e) {
            k.n("NetApiImpl", "csj", e);
        } finally {
            tjVar.s((JSONObject) null);
        }
    }

    private void n(pk pkVar, int i, com.byazt.shr.tj tjVar) {
        if (tjVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("last_settings_update", com.byazt.ehw.qg.qg(System.currentTimeMillis()));
            JSONObject jSONObjectPy = tjVar.py();
            if (jSONObjectPy != null && jSONObjectPy.length() > 0) {
                Iterator<String> itKeys = jSONObjectPy.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, jSONObjectPy.opt(next));
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (pkVar != null) {
                jSONObject2.putOpt("rit", w.n(pkVar, ""));
                jSONObject2.putOpt("cid", pkVar.q());
                jSONObject2.putOpt("req_id", pkVar.ou());
            }
            jSONObject2.put("adtype", i);
            com.byazt.eji.s.n().n("ad_request_result", jSONObject2, jSONObject);
        } catch (Throwable unused) {
        }
    }

    private void n(y yVar, pk pkVar, String str, com.byazt.shr.tj tjVar) {
        long jS;
        long j;
        if (com.byazt.nf.rv.qg().ei() && tjVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (yVar != null) {
                try {
                    if (yVar.fs > 0) {
                        jSONObject.put("client_start_time", tjVar.tj() - yVar.fs);
                        jS = tjVar.s() - yVar.fs;
                    } else {
                        jS = 0;
                    }
                    if (yVar.rv > 0) {
                        jSONObject.put("real_user_duration", tjVar.s() - yVar.rv);
                        jSONObject.put("switch_st1_time", yVar.fs - yVar.rv);
                    }
                    j = jS;
                } catch (Exception unused) {
                    return;
                }
            } else {
                j = 0;
            }
            jSONObject.put("net_send_time", tjVar.w() - tjVar.tj());
            jSONObject.put("net_rcv_time", tjVar.l() - tjVar.w());
            jSONObject.put("net_callback_time", tjVar.x() - tjVar.l());
            jSONObject.put("network_time", tjVar.x() - tjVar.tj());
            jSONObject.put("sever_time", tjVar.qg());
            jSONObject.put("client_end_time", tjVar.s() - tjVar.x());
            if (tjVar.cp() > 0) {
                jSONObject.put("req_body_length", tjVar.cp());
            }
            if (tjVar.rv() > 0) {
                jSONObject.put("res_body_length", tjVar.rv());
            }
            if (!TextUtils.isEmpty(tjVar.d())) {
                jSONObject.put("x-pglcypher", tjVar.d());
            }
            jSONObject.put("cypher_v", tjVar.um());
            jSONObject.put("armor_s", tjVar.a());
            long jQ = tjVar.q();
            if (jQ > 0) {
                jSONObject.put("raw_req_length", jQ);
            }
            int i = 1;
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("net_module", com.byazt.ed.qg.n().w());
            if (!tjVar.fs()) {
                i = 2;
            }
            jSONObject.put("has_base64", i);
            jSONObject.put("req_build_opt", com.byazt.ed.qg.n().x());
            jSONObject.put("is_boost", com.byazt.gv.n.l());
            jSONObject.put("opt_config", String.valueOf(com.byazt.nf.rv.qg().pt()));
            jSONObject.put("report_index", s.getAndIncrement());
            if (tjVar.hd() > 0) {
                jSONObject.put("net_whqueue", tjVar.k() - tjVar.sz());
                jSONObject.put("net_wtqueue", tjVar.cy() - tjVar.k());
                jSONObject.put("net_oconn", tjVar.cd() - tjVar.hd());
                jSONObject.put("net_bconn", tjVar.hd() - tjVar.cy());
            }
            try {
                JSONObject jSONObjectN = yVar.k.n(-1L);
                Iterator<String> itKeys = jSONObjectN.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, jSONObjectN.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            com.byazt.hm.n.n(pkVar, str, "load_ad_time", j, jSONObject);
        }
    }

    @Override // com.byazt.mw.n
    public void n(com.byazt.oj.qg qgVar, List<com.byazt.fvm.w> list) {
        JSONObject jSONObjectQg;
        if (com.byazt.ivn.l.n() && (jSONObjectQg = qg(qgVar, list)) != null) {
            com.byazt.udc.s sVar = new com.byazt.udc.s();
            sVar.n(w.rv("/api/ad/union/dislike_event/"));
            sVar.s(jSONObjectQg, com.byazt.wg.qg.AD_TAG_DISLIKE);
            sVar.n((com.byazt.qk.x) null);
            if (qgVar == null || qgVar.l() == null) {
                return;
            }
            com.byazt.rm.qg.n(com.byazt.wg.qg.AD_TAG_DISLIKE, null, qgVar.l());
        }
    }

    @JProtect
    private JSONObject qg(com.byazt.oj.qg qgVar, List<com.byazt.fvm.w> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", com.byazt.wg.qg.AD_TAG_DISLIKE);
            jSONObject2.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", com.byazt.nf.tj.w);
            com.byazt.hnb.n.n(jSONObject2);
            if (qgVar != null) {
                jSONObject2.put("extra", qgVar.l());
                if (qgVar.s() == null) {
                    qgVar.n(AdnName.OTHER);
                }
                jSONObject2.put("dislike_source", qgVar.s());
            }
            String strN = n(list);
            if (strN != null) {
                jSONObject2.put("comment", strN);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", qg(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String n(List<com.byazt.fvm.w> list) {
        if (list.get(0).n().equals("0:00")) {
            return list.get(0).qg();
        }
        return null;
    }

    private JSONArray qg(List<com.byazt.fvm.w> list) {
        if (list == null || list.isEmpty()) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<com.byazt.fvm.w> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().n());
        }
        return jSONArray;
    }

    public static void n(com.byazt.mw.n.qg qgVar, com.byazt.gct.qg qgVar2) {
        qgVar2.n(-1);
        qgVar.n(-1, com.byazt.bxg.n.n(-1), qgVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.mw.n.l lVar) {
        lVar.n(-1, com.byazt.bxg.n.n(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.mw.n.q qVar) {
        qVar.n(-1, com.byazt.bxg.n.n(-1));
    }

    @JProtect
    private JSONObject s(com.byazt.zq.qg qgVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            n(jSONObject, "keywords", com.byazt.vyf.s.cy().hu());
            jSONObject.put("protection_of_minors", com.byazt.vyf.s.cy().u());
            if (!com.byazt.ed.s.n().x(i)) {
                com.byazt.hnb.n.n(this.qg, jSONObject);
            }
            String strQg = qg(qgVar);
            if (!TextUtils.equals("[]", strQg)) {
                n(jSONObject, f.R, strQg);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONArray n(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put(TapEventParamConstants.PARAM_NAME, "can_use_sensor");
                jSONObject.put(e.a.d, str);
            } catch (Exception unused) {
                return jSONArray;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return jSONArray;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONArray.put(jSONArray.length(), jSONObject);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(0, jSONObject);
        return jSONArray2;
    }

    private static String qg(com.byazt.zq.qg qgVar) {
        String strS = s(qgVar);
        Map<String, Object> mapUr = com.byazt.vyf.s.cy().ur();
        if (mapUr == null || mapUr.isEmpty()) {
            return strS;
        }
        try {
            JSONArray jSONArray = TextUtils.isEmpty(strS) ? new JSONArray() : new JSONArray(strS);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME) : "";
                if (!TextUtils.isEmpty(strOptString) && mapUr.containsKey(strOptString)) {
                    mapUr.remove(strOptString);
                }
            }
            for (Map.Entry<String, Object> entry : mapUr.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TapEventParamConstants.PARAM_NAME, entry.getKey());
                    jSONObject.put(e.a.d, entry.getValue());
                    jSONArray.put(jSONObject);
                }
            }
            return n(jSONArray).toString();
        } catch (Exception unused) {
            return strS;
        }
    }

    private static String s(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("m_temp_info")) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int length = jSONArray.length() - 1; length >= 0; length--) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(length);
                    if (TextUtils.equals("m_temp_info", jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME) : "")) {
                        jSONArray.remove(length);
                    }
                }
                return jSONArray.toString();
            } catch (JSONException e) {
                k.qg("NetApiImpl", "removeMediationTempInfo error:" + e.toString());
            }
        }
        return str;
    }

    private static JSONArray qg(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.equals("0", str)) {
                jSONObject = new JSONObject();
                jSONObject.put(TapEventParamConstants.PARAM_NAME, "is_shake_ads");
                jSONObject.put(e.a.d, "0");
                com.byazt.vyf.s.cy().qg("0");
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return jSONArray;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONArray.put(jSONArray.length(), jSONObject);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject);
            return jSONArray2;
        } catch (Exception unused) {
            return jSONArray;
        }
    }

    private static String n(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            JSONArray jSONArrayQg = qg(n((JSONArray) null, str2), str2);
            if (jSONArrayQg == null) {
                return null;
            }
            return jSONArrayQg.toString();
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals(jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME), "is_shake_ads")) {
                    if (TextUtils.equals("0", str2)) {
                        jSONObjectOptJSONObject.put(e.a.d, "0");
                        com.byazt.vyf.s.cy().qg("0");
                    } else {
                        com.byazt.vyf.s.cy().qg(jSONObjectOptJSONObject.optString(e.a.d));
                    }
                    z = true;
                }
            }
            if (!z) {
                jSONArray = qg(jSONArray, str2);
            }
            JSONArray jSONArrayN = n(jSONArray, str2);
            return jSONArrayN == null ? str : jSONArrayN.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private static String s(com.byazt.zq.qg qgVar) {
        String strT = com.byazt.vyf.s.cy().t();
        String strL = com.byazt.vyf.s.cy().l();
        com.byazt.vyf.s.cy().qg((String) null);
        String strS = qgVar != null ? s(qgVar.ou()) : null;
        if (TextUtils.isEmpty(strT)) {
            return n(strS, strL);
        }
        try {
            if (!TextUtils.isEmpty(strT) && strT.contains("game_adapter_did")) {
                strT = n(new JSONArray(strT)).toString();
            }
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(strS)) {
            return n(strT, strL);
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(strS);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString(TapEventParamConstants.PARAM_NAME, null);
                    if (TextUtils.equals("is_shake_ads", strOptString)) {
                        if (TextUtils.equals(strL, "0")) {
                            jSONObject.put(e.a.d, "0");
                            com.byazt.vyf.s.cy().qg("0");
                        } else {
                            com.byazt.vyf.s.cy().qg(jSONObject.optString(e.a.d));
                        }
                        z = true;
                    }
                    hashSet.add(strOptString);
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strT);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String strOptString2 = jSONObject2.optString(TapEventParamConstants.PARAM_NAME, null);
                        if (!hashSet.contains(strOptString2)) {
                            if (TextUtils.equals("is_shake_ads", strOptString2)) {
                                if (TextUtils.equals(strL, "0")) {
                                    jSONObject2.put(e.a.d, "0");
                                    com.byazt.vyf.s.cy().qg("0");
                                } else {
                                    com.byazt.vyf.s.cy().qg(jSONObject2.optString(e.a.d));
                                }
                                z = true;
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (!z) {
                    jSONArray = qg(jSONArray, strL);
                }
                return n(n(jSONArray), strL).toString();
            } catch (Throwable unused2) {
                return n(strS, strL);
            }
        } catch (Throwable unused3) {
            return n(strT, strL);
        }
    }

    private static JSONArray n(JSONArray jSONArray) throws JSONException {
        if (com.byazt.nf.tj.fs() && jSONArray != null && jSONArray.length() != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            JSONObject jSONObject = null;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    String strOptString = jSONObject2.optString(TapEventParamConstants.PARAM_NAME, null);
                    if (!TapEventParamConstants.PARAM_DEVICE_ID.equals(strOptString)) {
                        if ("game_adapter_did".equals(strOptString)) {
                            jSONObject = jSONObject2;
                        } else {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject.put(TapEventParamConstants.PARAM_NAME, TapEventParamConstants.PARAM_DEVICE_ID);
                jSONArray2.put(jSONObject);
                return jSONArray2;
            }
        }
        return jSONArray;
    }

    private void n(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject n(com.byazt.zq.qg qgVar, int i, y yVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", qgVar.q());
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, qgVar.um());
            jSONObject.put("show_seq", qgVar.cd());
            jSONObject.put("adtype", i);
            jSONObject.put("themeStatus", com.byazt.vyf.s.cy().dh());
            jSONObject.put("download_type", 0);
            jSONObject.put("show_time", com.byazt.wb.s.x().n(qgVar.q()));
            JSONObject jSONObjectN = com.byazt.msp.s.n(i, qgVar.an());
            if (jSONObjectN != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObjectN.toString());
                    com.byazt.gct.fs.s sVarN = com.byazt.gct.fs.n(i);
                    com.byazt.gct.fs.w wVarHd = sVarN != null ? sVarN.hd() : null;
                    if (wVarHd != null && wVarHd.n(i) && wVarHd.qg() > 0) {
                        long jN = com.byazt.bh.qg.n().n(i, qgVar.q());
                        if (jN > 0) {
                            jSONObject2.put("dynamic_tmax", jN);
                        }
                        long jQg = com.byazt.bh.qg.n().qg(i, qgVar.q());
                        if (jQg > 0) {
                            jSONObject2.put("predict_server_tmax", jQg);
                        }
                        jSONObject2.put("dynamic_tmax_type", wVarHd.q());
                    }
                    jSONObjectN = jSONObject2;
                } catch (Throwable unused) {
                }
                jSONObject.put("ca_interval_info", jSONObjectN);
            }
            Object objQg = com.byazt.msp.s.qg(i, qgVar.q());
            if (objQg != null) {
                jSONObject.put("client_cache_info", objQg);
            }
            if (!TextUtils.isEmpty(qgVar.n()) || !TextUtils.isEmpty(qgVar.qg()) || !TextUtils.isEmpty(qgVar.s()) || com.byazt.lq.s.n()) {
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(qgVar.n())) {
                    jSONObject3.put(MediationConstant.EXTRA_ADID, qgVar.n());
                }
                if (!TextUtils.isEmpty(qgVar.qg())) {
                    jSONObject3.put("creative_id", qgVar.qg());
                }
                if (qgVar.s() != null) {
                    jSONObject3.put("ext", qgVar.s());
                }
                com.byazt.lq.s.n(jSONObject3, qgVar.q());
                jSONObject.put("preview_ads", jSONObject3);
            }
            if (com.byazt.lq.s.n() && com.byazt.vyf.s.cy().lq()) {
                com.byazt.lq.s.qg(jSONObject, qgVar.q());
            }
            com.byazt.vyf.s.C0380s c0380sHe = com.byazt.vyf.s.cy().he();
            if (c0380sHe != null && w.fs().equals("com.pangolin_demo.toutiao")) {
                c0380sHe.n(jSONObject);
            }
            int iD = 1;
            if (i == 3 || i == 4) {
                if (yVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("publisher_timeout_control", yVar.tj);
                    jSONObject4.put("time_out_control", yVar.cp);
                    jSONObject4.put("time_out", yVar.d);
                    jSONObject.put("tmax", jSONObject4);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (yVar != null) {
                jSONObject.put("render_method", yVar.x);
                if (yVar.x == 1) {
                    if (q(qgVar)) {
                        n(i, jSONObject);
                    } else {
                        n(jSONObject, "accepted_size", qgVar.w(), qgVar.x());
                    }
                } else if (yVar.x == 2) {
                    if (qgVar.fs() <= 0.0f || qgVar.rv() <= 0.0f) {
                        if (q(qgVar)) {
                            n(i, jSONObject);
                        } else {
                            n(jSONObject, "accepted_size", qgVar.w(), qgVar.x());
                        }
                    } else {
                        n(jSONObject, "accepted_size", com.byazt.okk.s.s(this.qg, qgVar.fs()), com.byazt.okk.s.s(this.qg, qgVar.rv()));
                    }
                }
            } else {
                jSONObject.put("render_method", 1);
                n(jSONObject, "accepted_size", qgVar.w(), qgVar.x());
            }
            jSONObject.put("ptpl_ids", com.byazt.ed.n.n().n(qgVar.q(), i));
            jSONObject.put("ptpl_ids_v3", com.byazt.ed.n.n().qg(qgVar.q(), i));
            if (i == 5 || i == 9) {
                String string = com.byazt.lk.l.n(com.byazt.vyf.s.cy().ou(), "ad_show_real_size").getString(qgVar.q(), null);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("real_size", new JSONObject(string));
                }
            }
            jSONObject.put("pos", w.l(i));
            jSONObject.put("is_support_dpl", qgVar.tj());
            jSONObject.put("if_support_render_control", qgVar.cp() ? 1 : 0);
            jSONObject.put("support_icon_style", (com.byazt.nf.tj.l < 5900 || !qgVar.h()) ? 0 : 1);
            if (i == 3 || i == 4) {
                jSONObject.put("splash_load_type", com.byazt.nf.rv.qg().x(w.qg(qgVar)));
            }
            if (i == 1 || i == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (yVar != null && yVar.oa != null) {
                jSONObject.put("session_params", yVar.oa);
            }
            int iD2 = qgVar.d();
            if (i == 7) {
                if (j.n()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", j.l());
                }
                if (j.s()) {
                    jSONObject.put("refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", j.x());
                }
                if (j.q()) {
                    jSONObject.put("force_refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", j.x());
                }
                iD2 = 1;
            }
            if (i == 8) {
                boolean zK = com.byazt.nf.rv.qg().k(qgVar.q());
                boolean zN = com.byazt.wd.x.n(qgVar.q());
                if (!zK) {
                    jSONObject.put("refresh_control", 0);
                } else if (zN) {
                    jSONObject.put("refresh_control", 0);
                    com.byazt.eji.s.n().n("refresh_max", new com.byazt.rs.n() { // from class: com.byazt.mw.qg.3
                        @Override // com.byazt.rs.n
                        public JSONObject n(JSONObject jSONObject5) throws JSONException {
                            JSONObject jSONObject6 = new JSONObject();
                            try {
                                jSONObject6.put("cid", "");
                            } catch (JSONException unused2) {
                            }
                            return jSONObject6;
                        }
                    });
                } else {
                    jSONObject.put("refresh_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.byazt.nf.rv.qg().fh());
                }
                if (j.qg()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", j.w());
                }
            } else {
                iD = iD2;
            }
            if (yVar != null && yVar.w != null) {
                iD = qgVar.d();
            }
            jSONObject.put("ad_count", iD);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    private void n(int i, JSONObject jSONObject) {
        if (qg(i)) {
            n(jSONObject, "accepted_size", com.byazt.okk.s.l(this.qg), com.byazt.okk.s.w(this.qg));
        } else {
            n(jSONObject, "accepted_size", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private boolean q(com.byazt.zq.qg qgVar) {
        return qgVar != null && qgVar.x() == 320 && qgVar.w() == 640;
    }

    private void n(JSONObject jSONObject, String str, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (i > 0 && i2 > 0) {
                jSONObject2.put("width", i);
                jSONObject2.put("height", i2);
            } else {
                jSONObject2.put("width", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
                jSONObject2.put("height", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void n(JSONObject jSONObject, String str, float f, float f2) {
        if (f <= 0.0f || f2 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f);
            jSONObject2.put("height", (int) f2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 48})
    public static class n {
        public final ArrayList<Integer> cp;
        public final com.byazt.gct.n fs;
        public final String l;
        public final int n;
        public final int q;
        public final long qg;
        public final String rv;
        public final long s;
        public final String tj;
        public final int w;
        public final String x;

        private n(String str, String str2, int i, int i2, String str3, int i3, String str4, com.byazt.gct.n nVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.n = i;
            this.q = i2;
            this.l = str3;
            this.x = str4;
            this.fs = nVar;
            this.rv = str;
            this.tj = str2;
            this.w = i3;
            this.qg = j;
            this.s = j2;
            this.cp = arrayList;
        }

        public static n n(JSONObject jSONObject) {
            return n(jSONObject, null, null);
        }

        public static n n(JSONObject jSONObject, com.byazt.zq.qg qgVar, y yVar) {
            String strOptString = jSONObject.optString("did");
            String strQ = com.byazt.ehw.qg.q(jSONObject);
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DESC);
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt(MediationConstant.KEY_REASON);
            Pair<com.byazt.gct.n, ArrayList<Integer>> pairN = com.byazt.vgx.qg.n(jSONObject, qgVar, yVar, jOptLong2);
            if (pairN != null && pairN.first != null) {
                ((com.byazt.gct.n) pairN.first).n(jSONObject.optLong("request_after"));
            }
            if (pairN == null) {
                return new n(strOptString, strQ, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
            }
            return new n(strOptString, strQ, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.byazt.gct.n) pairN.first, jOptLong, jOptLong2, (ArrayList) pairN.second);
        }
    }

    @Override // com.byazt.mw.n
    public void n(JSONObject jSONObject, final com.byazt.mw.n.l lVar) {
        if (!com.byazt.ivn.l.n()) {
            if (lVar != null) {
                lVar.n(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || lVar == null) {
                return;
            }
            com.byazt.udc.s sVar = new com.byazt.udc.s();
            sVar.n(w.rv("/api/ad/union/sdk/reward_video/reward/"));
            sVar.s(jSONObject, "verify");
            sVar.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.4
                @Override // com.byazt.qk.x
                public void n(com.byazt.qk.oa oaVar) {
                    if (oaVar != null) {
                        if (oaVar.x()) {
                            try {
                                Pair<Boolean, JSONObject> pairN = com.byazt.cl.q.n(oaVar, "verify", false);
                                q qVarN = q.n(pairN.second != null ? (JSONObject) pairN.second : oaVar.l());
                                if (qVarN.n != 20000) {
                                    lVar.n(qVarN.n, com.byazt.bxg.n.n(qVarN.n));
                                    return;
                                } else if (qVarN.s == null) {
                                    qg.this.n(lVar);
                                    return;
                                } else {
                                    lVar.n(qVarN);
                                    return;
                                }
                            } catch (Exception unused) {
                            }
                        } else {
                            String strN = com.byazt.bxg.n.n(-2);
                            int iN = oaVar.n();
                            if (!oaVar.x() && !TextUtils.isEmpty(oaVar.qg())) {
                                strN = oaVar.qg();
                            }
                            lVar.n(iN, strN);
                            return;
                        }
                    }
                    qg.this.n(lVar);
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str, Throwable th) {
                    lVar.n(-2, th.getMessage());
                }
            });
        }
    }

    @Override // com.byazt.mw.n
    public void n(JSONObject jSONObject, final com.byazt.mw.n.q qVar) {
        if (!com.byazt.ivn.l.n()) {
            if (qVar != null) {
                qVar.n(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || qVar == null) {
                return;
            }
            com.byazt.phf.s.q(w.rv("/api/ad/union/sdk/reward_video/live_room/reward")).qg(com.byazt.cl.s.n(jSONObject == null ? null : jSONObject.toString()).toString()).n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.5
                @Override // com.byazt.qk.x
                public void n(com.byazt.qk.oa oaVar) {
                    if (oaVar == null) {
                        qg.this.n(qVar);
                        return;
                    }
                    if (oaVar.x()) {
                        JSONObject jSONObjectL = oaVar.l();
                        if (jSONObjectL == null) {
                            qg.this.n(qVar);
                            return;
                        }
                        String strQ = jSONObjectL.optInt("cypher", -1) == 3 ? ((com.byazt.vf.k) com.byazt.qp.q.n("encrypt_service")).q(jSONObjectL.optString("message")) : null;
                        if (!TextUtils.isEmpty(strQ)) {
                            try {
                                jSONObjectL = new JSONObject(strQ);
                            } catch (Throwable unused) {
                            }
                        }
                        s sVarN = s.n(jSONObjectL);
                        if (sVarN.n != 20000) {
                            qVar.n(sVarN.n, com.byazt.bxg.n.n(sVarN.n));
                            return;
                        } else if (sVarN.s == null) {
                            qg.this.n(qVar);
                            return;
                        } else {
                            qVar.n(sVarN);
                            return;
                        }
                    }
                    String strN = com.byazt.bxg.n.n(-2);
                    int iN = oaVar.n();
                    if (!oaVar.x() && !TextUtils.isEmpty(oaVar.qg())) {
                        strN = oaVar.qg();
                    }
                    qVar.n(iN, strN);
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str, Throwable th) {
                    qVar.n(-2, th.getMessage());
                }
            });
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 1474})
    public static class q {
        public final int n;
        public final boolean qg;
        public final ju s;

        private q(int i, boolean z, ju juVar) {
            this.n = i;
            this.qg = z;
            this.s = juVar;
        }

        public static q n(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(f.R);
            ju juVar = new ju();
            if (jSONObjectOptJSONObject != null) {
                try {
                    juVar.n(jSONObjectOptJSONObject.optInt(MediationConstant.KEY_REASON));
                    juVar.qg(jSONObjectOptJSONObject.optInt("corp_type"));
                    juVar.s(jSONObjectOptJSONObject.optInt("reward_amount"));
                    juVar.n(jSONObjectOptJSONObject.optString("reward_name"));
                } catch (Throwable unused) {
                }
            }
            return new q(iOptInt, zOptBoolean, juVar);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 47})
    public static class s {
        public final int n;
        public final String qg;
        public final yw s;

        private s(int i, String str, yw ywVar) {
            this.n = i;
            this.qg = str;
            this.s = ywVar;
        }

        public static s n(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString("message");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(f.R);
            yw ywVar = new yw();
            if (jSONObjectOptJSONObject != null) {
                try {
                    ywVar.n(jSONObjectOptJSONObject.optBoolean("is_open"));
                    ywVar.n(jSONObjectOptJSONObject.optString("req_id"));
                } catch (Throwable unused) {
                }
            }
            return new s(iOptInt, strOptString, ywVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e1 A[PHI: r1
      0x00e1: PHI (r1v8 java.lang.String) = (r1v7 java.lang.String), (r1v10 java.lang.String) binds: [B:28:0x00c4, B:33:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.mw.n
    public String n(com.byazt.zq.qg qgVar, boolean z, int i) {
        int iA;
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        y yVar = new y();
        String strQg = yVar.qg();
        n(qgVar, strQg);
        com.byazt.vyf.w wVar = yVar.k;
        if (3 == qgVar.a()) {
            yVar.fs = System.currentTimeMillis();
            yVar.x = 2;
        }
        if (z) {
            yVar.x = 2;
        }
        if (1 == qgVar.cy() || 2 == qgVar.cy()) {
            yVar.x = 2;
        }
        if (yVar.x != 2 && com.byazt.nf.rv.qg().rv(qgVar.q())) {
            yVar.x = 2;
        }
        if (qgVar.a() > 0) {
            iA = qgVar.a();
        } else {
            iA = i > 0 ? i : 0;
        }
        JSONObject jSONObjectN = n(qgVar, yVar, iA, true, 4, false, strQg);
        wVar.qg("adbody_time");
        n(qgVar, yVar, iA);
        wVar.qg("prefetch_time");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(RequestParamsUtils.USER_AGENT_KEY, ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).qg(false));
            wVar.qg("request_headers_time");
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("bid_request", jSONObjectN);
        } catch (Exception unused) {
        }
        Pair<Integer, JSONObject> pairN = com.byazt.cl.q.n().n(jSONObject.toString(), true);
        wVar.qg("encry_time");
        try {
            com.byazt.eji.s.n().n(i, wVar);
        } catch (Throwable unused2) {
        }
        String strOptString = "";
        if (pairN == null) {
            iIntValue = 3;
        } else {
            strOptString = pairN.second != null ? ((JSONObject) pairN.second).optString("message") : "";
            if (pairN.first != null) {
                iIntValue = ((Integer) pairN.first).intValue();
            } else {
                iIntValue = 3;
            }
        }
        if (iIntValue != 3) {
            return "0000000004" + strOptString;
        }
        return "0000000003" + strOptString;
    }

    private void n(final com.byazt.zq.qg qgVar, String str) {
        String string = UUID.randomUUID().toString();
        com.byazt.id.qg qgVar2 = (com.byazt.id.qg) com.byazt.bok.s.n(0);
        qgVar2.qg(string, qgVar.an());
        qgVar2.n(string, new com.byazt.oi.s());
        qgVar2.n(str, string);
        qgVar2.n(string, new com.byazt.bok.qg.n() { // from class: com.byazt.mw.qg.6
            @Override // com.byazt.bok.qg.n
            public void n(com.byazt.wea.fs fsVar) {
                com.byazt.zq.qg qgVar3;
                if (!(fsVar instanceof com.byazt.wea.s) || (qgVar3 = qgVar) == null) {
                    return;
                }
                com.byazt.wea.s sVar = (com.byazt.wea.s) fsVar;
                sVar.x = qgVar3;
                sVar.s = qgVar.q();
                sVar.n = qgVar.a();
                sVar.qg = 1;
            }
        });
        qgVar2.n(string, com.byazt.hes.qg.STARTED);
        qgVar2.n();
    }

    private boolean n(com.byazt.zq.qg qgVar, y yVar, int i) {
        boolean zN = com.byazt.nf.rv.qg().n(qgVar.q());
        if (zN) {
            l(qgVar, yVar, i, new com.byazt.mw.n.qg() { // from class: com.byazt.mw.qg.7
                @Override // com.byazt.mw.n.qg
                public void n(int i2, String str, com.byazt.gct.qg qgVar2) {
                    com.byazt.eji.s.n().n(i2);
                }

                @Override // com.byazt.mw.n.qg
                public void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar2) {
                    com.byazt.eji.s.n().n(0);
                }
            });
        }
        return zN;
    }

    private void n(boolean z, JSONObject jSONObject, String str) throws Exception {
        String strN = com.byazt.tf.n.n().n(z, str);
        String strOptString = "0";
        String str2 = null;
        if (strN != null && !TextUtils.isEmpty(strN)) {
            if (TextUtils.equals(strN, "0")) {
                str2 = "0";
            } else if (TextUtils.equals(strN, "1")) {
                str2 = "1";
            } else {
                JSONObject jSONObject2 = new JSONObject(strN);
                jSONObject.putOpt("cache_info", jSONObject2);
                strOptString = jSONObject2.optString("req_id");
            }
        }
        com.byazt.eji.s.n().n(str, strOptString, str2, false);
    }

    @Override // com.byazt.mw.n
    public String n(com.byazt.zq.qg qgVar) {
        return n(qgVar, false, -1);
    }

    @Override // com.byazt.mw.n
    public void n(String str, String str2, final com.byazt.mw.n.InterfaceC0251n interfaceC0251n) {
        if (!com.byazt.ivn.l.n()) {
            if (interfaceC0251n != null) {
                interfaceC0251n.n(false, -1L, 0L);
            }
        } else {
            if (str == null || str2 == null || interfaceC0251n == null) {
                return;
            }
            JSONObject jSONObjectN = com.byazt.fxc.q.n(str, str2);
            com.byazt.udc.s sVar = new com.byazt.udc.s();
            String strRv = w.rv("/api/ad/union/sdk/material/check/");
            try {
                if (TextUtils.isEmpty(new URL(strRv).getQuery())) {
                    strRv = strRv + "?abort_aes=1";
                } else {
                    strRv = strRv + "&abort_aes=1";
                }
            } catch (Exception unused) {
            }
            sVar.n(strRv);
            sVar.s(jSONObjectN, "check_ad");
            sVar.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.8
                @Override // com.byazt.qk.x
                public void n(com.byazt.qk.oa oaVar) {
                    boolean z;
                    if (oaVar != null) {
                        long j = -1;
                        if (oaVar.x()) {
                            JSONObject jSONObjectL = oaVar.l();
                            if (jSONObjectL != null) {
                                C0252qg c0252qgN = C0252qg.n(jSONObjectL);
                                j = c0252qgN.n;
                                z = c0252qgN.qg;
                            } else {
                                z = false;
                            }
                            interfaceC0251n.n(z, j, oaVar.rv());
                            return;
                        }
                        interfaceC0251n.n(false, oaVar.n() != 0 ? oaVar.n() : -1L, oaVar.rv());
                    }
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str3, Throwable th) {
                    interfaceC0251n.n(false, 0L, 0L);
                }
            });
        }
    }

    @Override // com.byazt.mw.n
    public void n(JSONObject jSONObject, final com.byazt.fxc.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.udc.s sVar = new com.byazt.udc.s();
        String strRv = w.rv("/api/ad/union/sdk/material/cali/");
        try {
            if (TextUtils.isEmpty(new URL(strRv).getQuery())) {
                strRv = strRv + "?abort_aes=1";
            } else {
                strRv = strRv + "&abort_aes=1";
            }
        } catch (Exception unused) {
        }
        sVar.n(strRv);
        sVar.s(jSONObject, "checkAndCorrectAd");
        sVar.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.9
            @Override // com.byazt.qk.x
            public void n(com.byazt.qk.oa oaVar) {
                long j;
                com.byazt.fxc.l lVar;
                if (oaVar != null) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (oaVar.x()) {
                        try {
                            Pair<Boolean, JSONObject> pairN = com.byazt.cl.q.n(oaVar, "checkAndCorrectAd", false);
                            com.byazt.fxc.l lVarN = null;
                            JSONObject jSONObject2 = pairN.second != null ? (JSONObject) pairN.second : null;
                            if (jSONObject2 != null) {
                                try {
                                    lVarN = com.byazt.fxc.l.n(jSONObject2);
                                    j = lVarN != null ? lVarN.n : -1L;
                                    lVar = lVarN;
                                } catch (Exception unused2) {
                                    lVar = lVarN;
                                    j = -1;
                                }
                            } else {
                                lVar = lVarN;
                                j = -1;
                            }
                            qgVar.n(lVar, j, jCurrentTimeMillis2);
                            return;
                        } catch (Exception unused3) {
                        }
                    }
                    qgVar.n(null, oaVar.n() != 0 ? oaVar.n() : -1L, jCurrentTimeMillis2);
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str, Throwable th) {
                qgVar.n(null, -1L, 0L);
            }
        });
    }

    @Override // com.byazt.mw.n
    public com.byazt.px.n n(int i) {
        String strXb;
        com.byazt.px.n nVarQ = null;
        if (!com.byazt.ivn.l.n()) {
            return null;
        }
        if (i == 2) {
            strXb = com.byazt.nf.rv.qg().ct();
        } else {
            strXb = com.byazt.nf.rv.qg().xb();
        }
        if (TextUtils.isEmpty(strXb)) {
            return null;
        }
        com.byazt.qk.oa oaVarL = com.byazt.phf.s.l(com.byazt.lq.l.qg(strXb));
        if (oaVarL != null) {
            try {
                if (oaVarL.x()) {
                    if (i == 2) {
                        nVarQ = com.byazt.ai.qg.l(oaVarL.fs());
                    } else {
                        nVarQ = com.byazt.px.n.q(oaVarL.fs());
                    }
                }
            } catch (Exception unused) {
            }
        }
        return nVarQ;
    }

    @Override // com.byazt.mw.n
    public com.byazt.gct.q n(final pk pkVar, String str) {
        String strCq;
        String strLn;
        if (pkVar != null) {
            strCq = pkVar.cq();
            strLn = w.ln(pkVar);
        } else {
            strCq = null;
            strLn = null;
        }
        com.byazt.qk.rv rvVarQg = com.byazt.phf.s.qg("https://" + com.byazt.nf.rv.qg().tr() + "/customer/api/app/pkg_info");
        rvVarQg.qg("convert_id", strCq);
        rvVarQg.qg("package_name", strLn);
        rvVarQg.qg(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, com.byazt.rd.q.qg(str));
        String str2 = strCq + "_" + strLn + "_" + str;
        com.byazt.gct.q qVarN = com.byazt.iz.n.n(str2);
        if (qVarN != null) {
            return qVarN;
        }
        final com.byazt.qk.oa[] oaVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        rvVarQg.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.10
            @Override // com.byazt.qk.x
            public void n(com.byazt.qk.oa oaVar) {
                oaVarArr[0] = oaVar;
                countDownLatch.countDown();
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str3, final Throwable th) {
                countDownLatch.countDown();
                com.byazt.eji.s sVarN = com.byazt.eji.s.n();
                pk pkVar2 = pkVar;
                sVarN.n("pkg_info_failed", (String) null, pkVar2 != null ? pkVar2.F_() : "", new com.byazt.rs.n() { // from class: com.byazt.mw.qg.10.1
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        Throwable th2 = th;
                        if (th2 != null) {
                            jSONObject2.putOpt("io_error", th2.getMessage());
                        }
                        return jSONObject2;
                    }
                });
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        try {
            com.byazt.qk.oa oaVar = oaVarArr[0];
            if (oaVar != null && oaVar.x()) {
                JSONObject jSONObjectL = oaVarArr[0].l();
                if (jSONObjectL.optInt("code", -1) == 0) {
                    com.byazt.gct.q qVar = new com.byazt.gct.q(jSONObjectL);
                    com.byazt.iz.n.n(str2, qVar);
                    return qVar;
                }
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    @Override // com.byazt.mw.n
    public void n(final wv wvVar, final String str, final String str2, final com.byazt.mw.n.s sVar, final int i, final long j) {
        if (sVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.qit.l.qg(new x("get_wlink") { // from class: com.byazt.mw.qg.11
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.qg(wvVar, str, str2, sVar, i, j);
                }
            });
        } else {
            qg(wvVar, str, str2, sVar, i, j);
        }
    }

    @JProtect
    private JSONObject n(wv wvVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adv_id", wvVar.s());
            jSONObject.put("site_id", wvVar.q());
            jSONObject.put("page_url", str);
            jSONObject.put("log_extra", str2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(wv wvVar, String str, String str2, final com.byazt.mw.n.s sVar, int i, long j) {
        JSONObject jSONObjectN = n(wvVar, str, str2);
        com.byazt.qk.rv rvVarN = com.byazt.phf.s.n();
        if (i == 1) {
            rvVarN.n(wvVar.x());
        } else {
            rvVarN.n(wvVar.n());
        }
        rvVarN.n(jSONObjectN);
        rvVarN.n(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.mw.qg.13
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                sVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, "time out!");
            }
        }, j);
        rvVarN.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.14
            @Override // com.byazt.qk.x
            public void n(com.byazt.qk.oa oaVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (oaVar == null) {
                    sVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, "response is null!");
                    return;
                }
                if (oaVar.x()) {
                    try {
                        JSONObject jSONObjectL = oaVar.l();
                        String strOptString = jSONObjectL.optString("message");
                        int iOptInt = jSONObjectL.optInt("status", -1);
                        if (iOptInt != 200) {
                            sVar.n(iOptInt, strOptString);
                            return;
                        }
                        JSONObject jSONObjectOptJSONObject = jSONObjectL.optJSONObject(f.R);
                        if (jSONObjectOptJSONObject == null) {
                            sVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP, strOptString + ", data is null!");
                            return;
                        } else {
                            sVar.n(jSONObjectOptJSONObject);
                            return;
                        }
                    } catch (Throwable th) {
                        sVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, th.getMessage());
                        return;
                    }
                }
                sVar.n(oaVar.n(), oaVar.qg());
            }

            @Override // com.byazt.qk.x
            public void n(int i2, String str3, Throwable th) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                sVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, th.getMessage());
            }
        });
    }

    @Override // com.byazt.mw.n
    public void n(String str) {
        q(str);
    }

    @Override // com.byazt.mw.n
    public void n(final JSONObject jSONObject, final com.byazt.mw.n.s<com.byazt.qk.oa> sVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.qit.l.n().execute(new Runnable() { // from class: com.byazt.mw.qg.15
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.qg(jSONObject, (com.byazt.mw.n.s<com.byazt.qk.oa>) sVar);
                }
            });
        } else {
            qg(jSONObject, sVar);
        }
    }

    @Override // com.byazt.mw.n
    public void n(final Function<SparseArray<Object>, Object> function) {
        com.byazt.qk.rv rvVarN = com.byazt.phf.s.n();
        rvVarN.n("https://" + com.byazt.vyf.s.cy().ic() + "/ad_union_qa/sdk/query_config_list");
        rvVarN.n("x-pglcypher", "4");
        rvVarN.n("x-ad-sdk-version", com.byazt.nf.tj.w);
        rvVarN.n("x-plugin-version", "7.8.1.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", com.byazt.vyf.s.cy().ou());
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, "android");
            jSONObject.put("ad_sdk_version", com.byazt.nf.tj.w);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
        } catch (Throwable unused) {
        }
        byte[] bArrN = com.byazt.xu.q.n(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        final com.byazt.vf.k kVarS = com.byazt.cl.s.s();
        if (kVarS == null) {
            n(function, -4, "armor service init fail");
        } else {
            rvVarN.n(kVarS.n(bArrN));
            rvVarN.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.16
                @Override // com.byazt.qk.x
                public void n(com.byazt.qk.oa oaVar) {
                    byte[] bArrQg;
                    Function function2 = function;
                    if (function2 == null || oaVar == null) {
                        qg.this.n((Function<SparseArray<Object>, Object>) function2, -1, "response is null");
                        return;
                    }
                    String strN = oaVar.n("content-type");
                    String strN2 = oaVar.n("x-pglcypher");
                    if (TextUtils.equals(strN, "application/octet-stream") || TextUtils.equals(strN2, "4")) {
                        bArrQg = kVarS.qg(oaVar.q());
                    } else {
                        bArrQg = oaVar.q();
                    }
                    String strQg = com.byazt.xu.q.qg(bArrQg);
                    if (TextUtils.isEmpty(strQg)) {
                        qg.this.n((Function<SparseArray<Object>, Object>) function, -3, "response unGzipStr is null");
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(strQg);
                        int iOptInt = jSONObject2.optInt("code", -1);
                        String strOptString = jSONObject2.optString("message");
                        if (iOptInt != 0) {
                            qg.this.n((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                            return;
                        }
                        String strOptString2 = jSONObject2.optString(f.R);
                        if (TextUtils.isEmpty(strOptString2)) {
                            qg.this.n((Function<SparseArray<Object>, Object>) function, iOptInt, "response data is empty");
                        } else {
                            qg.this.n((Function<SparseArray<Object>, Object>) function, strOptString2);
                        }
                    } catch (JSONException unused2) {
                        qg.this.n((Function<SparseArray<Object>, Object>) function, -1, "response create json error");
                    }
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str, Throwable th) {
                    qg.this.n((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Function<SparseArray<Object>, Object> function, String str) {
        if (function != null) {
            function.apply(com.byazt.of.qg.n().n(10000).n(Void.class).n(0, str).qg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Function<SparseArray<Object>, Object> function, int i, String str) {
        if (function != null) {
            function.apply(com.byazt.of.qg.n().n(10001).n(Void.class).n(0, Integer.valueOf(i)).n(1, str).qg());
        }
    }

    @Override // com.byazt.mw.n
    public void n(final Map<String, Object> map, final Function<SparseArray<Object>, Object> function) {
        if (map == null || map.size() == 0) {
            return;
        }
        com.byazt.qk.rv rvVarQ = com.byazt.phf.s.q("https://" + com.byazt.vyf.s.cy().ic() + "/ad_union_qa/sdk/get_ad_config");
        rvVarQ.n("x-pglcypher", "4");
        rvVarQ.n("x-ad-sdk-version", com.byazt.nf.tj.w);
        rvVarQ.n("x-plugin-version", "7.8.1.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", com.byazt.vyf.s.cy().ou());
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, "android");
            jSONObject.put("ad_sdk_version", com.byazt.nf.tj.w);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            byte[] bArrN = com.byazt.xu.q.n(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
            final com.byazt.vf.k kVarS = com.byazt.cl.s.s();
            if (kVarS == null) {
                n(function, -4, "armor service init fail");
            } else {
                rvVarQ.n(kVarS.n(bArrN));
                rvVarQ.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.17
                    @Override // com.byazt.qk.x
                    public void n(com.byazt.qk.oa oaVar) {
                        String strQg;
                        int iOptInt = -1;
                        if (oaVar == null) {
                            qg.this.n((Function<SparseArray<Object>, Object>) function, -1, "response is null");
                            return;
                        }
                        String strN = oaVar.n("content-type");
                        String strN2 = oaVar.n("x-pglcypher");
                        String strOptString = "";
                        if (TextUtils.equals(strN, "application/octet-stream") || TextUtils.equals(strN2, "4")) {
                            strQg = com.byazt.xu.q.qg(kVarS.qg(oaVar.q()));
                            if (TextUtils.isEmpty(strQg)) {
                                strOptString = "data is null";
                            } else {
                                PluginValueSet pluginValueSetQg = com.byazt.of.n.qg(function);
                                if (!TextUtils.isEmpty(strQg) && function != null && pluginValueSetQg != null && TextUtils.equals((CharSequence) pluginValueSetQg.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    com.byazt.vyf.s.cy().n(new com.byazt.vyf.s.C0380s(map, strQg));
                                }
                                iOptInt = 0;
                            }
                        } else {
                            JSONObject jSONObjectL = oaVar.l();
                            if (jSONObjectL != null) {
                                iOptInt = jSONObjectL.optInt("code");
                                strOptString = jSONObjectL.optString("message");
                                strQg = jSONObjectL.optString(f.R);
                                PluginValueSet pluginValueSetQg2 = com.byazt.of.n.qg(function);
                                if (!TextUtils.isEmpty(strQg) && function != null && pluginValueSetQg2 != null && TextUtils.equals((CharSequence) pluginValueSetQg2.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    com.byazt.vyf.s.cy().n(new com.byazt.vyf.s.C0380s(map, strQg));
                                }
                            } else {
                                strQg = "";
                            }
                        }
                        if (iOptInt == 0) {
                            qg.this.n((Function<SparseArray<Object>, Object>) function, strQg);
                        } else {
                            qg.this.n((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                        }
                    }

                    @Override // com.byazt.qk.x
                    public void n(int i, String str, Throwable th) {
                        qg.this.n((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                    }
                });
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(JSONObject jSONObject, final com.byazt.mw.n.s<com.byazt.qk.oa> sVar) {
        String strN = w.n("/api/ad/union/sdk/apply_coupon/v2", false);
        com.byazt.udc.s sVar2 = new com.byazt.udc.s();
        sVar2.n(strN);
        sVar2.s(jSONObject, "coupon_apply");
        sVar2.n(new HashMap());
        sVar2.n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.18
            @Override // com.byazt.qk.x
            public void n(com.byazt.qk.oa oaVar) {
                com.byazt.mw.n.s sVar3 = sVar;
                if (sVar3 != null) {
                    sVar3.n(oaVar);
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str, Throwable th) {
                com.byazt.mw.n.s sVar3 = sVar;
                if (sVar3 != null) {
                    sVar3.n(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, th.getMessage());
                }
            }
        });
    }

    private void q(String str) {
        com.byazt.phf.s.qg(str).n(new com.byazt.qk.x() { // from class: com.byazt.mw.qg.19
            @Override // com.byazt.qk.x
            public void n(int i, String str2, Throwable th) {
            }

            @Override // com.byazt.qk.x
            public void n(com.byazt.qk.oa oaVar) {
                if (oaVar != null) {
                    oaVar.fs();
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.byazt.mw.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 201})
    public static class C0252qg {
        public final int n;
        public final boolean qg;

        private C0252qg(int i, boolean z) {
            this.n = i;
            this.qg = z;
        }

        public static C0252qg n(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0252qg(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }
}
