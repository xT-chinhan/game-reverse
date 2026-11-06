package com.byazt.sd;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.hg.bm;
import com.byazt.hg.ey;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.hg.u;
import com.byazt.mg.PluginConstants;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.qi;
import com.byazt.wt.s;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
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
@com.byazt.vzx.pr(pr = {0, 1, 23, 91})
public class rc implements fo {
    public static final AtomicInteger hn = new AtomicInteger(0);
    public static volatile int pr = 0;
    public final Context hw;
    public AtomicLong x = new AtomicLong(0);

    public rc(Context context) {
        this.hw = context;
    }

    public JSONObject pr(com.byazt.qe.hw hwVar, i iVar, int i, boolean z, int i2, boolean z2) {
        return pr(hwVar, iVar, i, z, i2, z2, (String) null);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    @JProtect
    private JSONObject pr(i iVar) {
        com.byazt.ua.pr.C0204pr c0204prHw;
        boolean z;
        boolean z2;
        CharSequence title;
        JSONObject jSONObject = new JSONObject();
        boolean z3 = true;
        boolean z4 = false;
        if (iVar != null) {
            try {
                if (!TextUtils.isEmpty(iVar.qa) && (c0204prHw = com.byazt.ua.pr.hw(iVar.qa)) != null) {
                    if (TextUtils.isEmpty(c0204prHw.pr)) {
                        z = false;
                    } else {
                        jSONObject.put("top_page_title", c0204prHw.pr);
                        z = true;
                    }
                    if (TextUtils.isEmpty(c0204prHw.hw)) {
                        z2 = false;
                    } else {
                        jSONObject.put("top_page_name", c0204prHw.hw);
                        z2 = true;
                    }
                    if (!TextUtils.isEmpty(c0204prHw.hn)) {
                        jSONObject.put("t_name", c0204prHw.hn);
                        z4 = z;
                    } else {
                        z3 = false;
                        z4 = z;
                    }
                } else {
                    z3 = false;
                    z2 = false;
                }
            } catch (Throwable th) {
                com.byazt.ca.ho.pr("NetApiImpl", "buildFeatureRequestBody error: ", th);
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
        if (zo.nt().hn() != null && zo.nt().hn().pr() != null) {
            activity = zo.nt().hn().pr().get();
        }
        if (activity != null) {
            if (!z4 || !z2) {
                com.byazt.ua.w.pr(activity);
                if (!z4 && (title = activity.getTitle()) != null && title.length() > 0) {
                    jSONObject.put("top_page_title", title.toString());
                }
                if (!z2) {
                    jSONObject.put("top_page_name", activity.getClass().getName());
                }
            }
            if (!z3) {
                try {
                    String strUc = com.byazt.ua.x.uc();
                    if (!TextUtils.isEmpty(strUc)) {
                        jSONObject.put("t_name", strUc);
                    }
                } catch (Throwable th2) {
                }
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0256  */
    /* JADX WARN: Code duplicated, block: B:102:0x0258  */
    /* JADX WARN: Code duplicated, block: B:105:0x0268 A[Catch: all -> 0x0539, TryCatch #4 {all -> 0x0539, blocks: (B:73:0x010b, B:75:0x0114, B:76:0x0119, B:78:0x0120, B:79:0x0126, B:83:0x014f, B:85:0x01ca, B:86:0x01e3, B:90:0x01f2, B:92:0x020c, B:93:0x0211, B:99:0x0242, B:103:0x0259, B:105:0x0268, B:107:0x0272, B:109:0x0278), top: B:221:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0272 A[Catch: all -> 0x0539, TryCatch #4 {all -> 0x0539, blocks: (B:73:0x010b, B:75:0x0114, B:76:0x0119, B:78:0x0120, B:79:0x0126, B:83:0x014f, B:85:0x01ca, B:86:0x01e3, B:90:0x01f2, B:92:0x020c, B:93:0x0211, B:99:0x0242, B:103:0x0259, B:105:0x0268, B:107:0x0272, B:109:0x0278), top: B:221:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0287 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x029e  */
    /* JADX WARN: Code duplicated, block: B:120:0x02a7 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x02b9 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:128:0x035a A[Catch: all -> 0x0537, TRY_ENTER, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0365  */
    /* JADX WARN: Code duplicated, block: B:134:0x03a0 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:140:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:143:0x03f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:147:0x0417 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x041e A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0038 A[Catch: all -> 0x053d, TRY_ENTER, TryCatch #6 {all -> 0x053d, blocks: (B:6:0x001d, B:14:0x0038, B:17:0x0041), top: B:224:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0445 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x044c  */
    /* JADX WARN: Code duplicated, block: B:154:0x044e  */
    /* JADX WARN: Code duplicated, block: B:156:0x0457 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x0466 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0478 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x0480  */
    /* JADX WARN: Code duplicated, block: B:166:0x0483 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x049a A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:172:0x04ba A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x04c4 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x04d6 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0041 A[Catch: all -> 0x053d, TRY_LEAVE, TryCatch #6 {all -> 0x053d, blocks: (B:6:0x001d, B:14:0x0038, B:17:0x0041), top: B:224:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:184:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:187:0x04e8 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x04f5 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:196:0x0507 A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x051f A[Catch: all -> 0x0537, TryCatch #2 {all -> 0x0537, blocks: (B:112:0x0281, B:114:0x0287, B:115:0x0290, B:119:0x02a0, B:122:0x02b9, B:123:0x02c2, B:125:0x02f5, B:128:0x035a, B:130:0x035e, B:132:0x0368, B:134:0x03a0, B:136:0x03a4, B:137:0x03ab, B:141:0x03cd, B:144:0x03f5, B:145:0x0405, B:147:0x0417, B:149:0x041e, B:151:0x0445, B:155:0x044f, B:158:0x0466, B:160:0x046a, B:156:0x0457, B:162:0x0478, B:166:0x0483, B:167:0x048c, B:169:0x049a, B:170:0x04ac, B:172:0x04ba, B:174:0x04c4, B:176:0x04ca, B:177:0x04cf, B:179:0x04d6, B:181:0x04db, B:185:0x04e2, B:187:0x04e8, B:189:0x04ef, B:191:0x04f5, B:193:0x04fb, B:194:0x0500, B:196:0x0507, B:198:0x050b, B:199:0x0519, B:201:0x051f, B:203:0x0525, B:204:0x052a, B:120:0x02a7), top: B:218:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:218:0x0281 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0051 A[Catch: all -> 0x006a, TryCatch #5 {all -> 0x006a, blocks: (B:21:0x004b, B:23:0x0051, B:24:0x0059, B:28:0x0065, B:26:0x005d, B:27:0x0061, B:34:0x0073, B:36:0x0077, B:38:0x007e, B:40:0x0086, B:44:0x009b, B:46:0x009f), top: B:223:0x004b }] */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:26:0x005d A[Catch: all -> 0x006a, TryCatch #5 {all -> 0x006a, blocks: (B:21:0x004b, B:23:0x0051, B:24:0x0059, B:28:0x0065, B:26:0x005d, B:27:0x0061, B:34:0x0073, B:36:0x0077, B:38:0x007e, B:40:0x0086, B:44:0x009b, B:46:0x009f), top: B:223:0x004b }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0061 A[Catch: all -> 0x006a, TryCatch #5 {all -> 0x006a, blocks: (B:21:0x004b, B:23:0x0051, B:24:0x0059, B:28:0x0065, B:26:0x005d, B:27:0x0061, B:34:0x0073, B:36:0x0077, B:38:0x007e, B:40:0x0086, B:44:0x009b, B:46:0x009f), top: B:223:0x004b }] */
    /* JADX WARN: Code duplicated, block: B:31:0x006e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0073 A[Catch: all -> 0x006a, TryCatch #5 {all -> 0x006a, blocks: (B:21:0x004b, B:23:0x0051, B:24:0x0059, B:28:0x0065, B:26:0x005d, B:27:0x0061, B:34:0x0073, B:36:0x0077, B:38:0x007e, B:40:0x0086, B:44:0x009b, B:46:0x009f), top: B:223:0x004b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x007e A[Catch: all -> 0x006a, TryCatch #5 {all -> 0x006a, blocks: (B:21:0x004b, B:23:0x0051, B:24:0x0059, B:28:0x0065, B:26:0x005d, B:27:0x0061, B:34:0x0073, B:36:0x0077, B:38:0x007e, B:40:0x0086, B:44:0x009b, B:46:0x009f), top: B:223:0x004b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0095  */
    /* JADX WARN: Code duplicated, block: B:43:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ce A[Catch: all -> 0x00c8, TryCatch #3 {all -> 0x00c8, blocks: (B:50:0x00c2, B:55:0x00ce, B:57:0x00dc, B:59:0x00e3, B:61:0x00e9, B:62:0x00ee, B:64:0x00f4, B:66:0x00fa, B:68:0x0100), top: B:219:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00dc A[Catch: all -> 0x00c8, TryCatch #3 {all -> 0x00c8, blocks: (B:50:0x00c2, B:55:0x00ce, B:57:0x00dc, B:59:0x00e3, B:61:0x00e9, B:62:0x00ee, B:64:0x00f4, B:66:0x00fa, B:68:0x0100), top: B:219:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e9 A[Catch: all -> 0x00c8, TryCatch #3 {all -> 0x00c8, blocks: (B:50:0x00c2, B:55:0x00ce, B:57:0x00dc, B:59:0x00e3, B:61:0x00e9, B:62:0x00ee, B:64:0x00f4, B:66:0x00fa, B:68:0x0100), top: B:219:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f4 A[Catch: all -> 0x00c8, TryCatch #3 {all -> 0x00c8, blocks: (B:50:0x00c2, B:55:0x00ce, B:57:0x00dc, B:59:0x00e3, B:61:0x00e9, B:62:0x00ee, B:64:0x00f4, B:66:0x00fa, B:68:0x0100), top: B:219:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0100 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #3 {all -> 0x00c8, blocks: (B:50:0x00c2, B:55:0x00ce, B:57:0x00dc, B:59:0x00e3, B:61:0x00e9, B:62:0x00ee, B:64:0x00f4, B:66:0x00fa, B:68:0x0100), top: B:219:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0114 A[Catch: all -> 0x0539, TryCatch #4 {all -> 0x0539, blocks: (B:73:0x010b, B:75:0x0114, B:76:0x0119, B:78:0x0120, B:79:0x0126, B:83:0x014f, B:85:0x01ca, B:86:0x01e3, B:90:0x01f2, B:92:0x020c, B:93:0x0211, B:99:0x0242, B:103:0x0259, B:105:0x0268, B:107:0x0272, B:109:0x0278), top: B:221:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0120 A[Catch: all -> 0x0539, TryCatch #4 {all -> 0x0539, blocks: (B:73:0x010b, B:75:0x0114, B:76:0x0119, B:78:0x0120, B:79:0x0126, B:83:0x014f, B:85:0x01ca, B:86:0x01e3, B:90:0x01f2, B:92:0x020c, B:93:0x0211, B:99:0x0242, B:103:0x0259, B:105:0x0268, B:107:0x0272, B:109:0x0278), top: B:221:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:81:0x014c  */
    /* JADX WARN: Code duplicated, block: B:82:0x014e  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ca A[Catch: all -> 0x0539, TryCatch #4 {all -> 0x0539, blocks: (B:73:0x010b, B:75:0x0114, B:76:0x0119, B:78:0x0120, B:79:0x0126, B:83:0x014f, B:85:0x01ca, B:86:0x01e3, B:90:0x01f2, B:92:0x020c, B:93:0x0211, B:99:0x0242, B:103:0x0259, B:105:0x0268, B:107:0x0272, B:109:0x0278), top: B:221:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:92:0x020c A[Catch: all -> 0x0539, TryCatch #4 {all -> 0x0539, blocks: (B:73:0x010b, B:75:0x0114, B:76:0x0119, B:78:0x0120, B:79:0x0126, B:83:0x014f, B:85:0x01ca, B:86:0x01e3, B:90:0x01f2, B:92:0x020c, B:93:0x0211, B:99:0x0242, B:103:0x0259, B:105:0x0268, B:107:0x0272, B:109:0x0278), top: B:221:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:95:0x023c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:98:0x0241  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Switch 'out' block B:31:0x006e for B:24:0x0059 already processed. Defaulting to fallback option. */
    @JProtect
    public JSONObject pr(com.byazt.qe.hw hwVar, i iVar, int i, boolean z, int i2, boolean z2, String str) {
        com.byazt.qe.hw hwVar2;
        String strHw;
        Object obj;
        int andSet;
        int i3;
        com.byazt.eg.hw hwVarPr;
        int iHn;
        int i4;
        String strFw;
        boolean z3;
        i iVar2;
        JSONObject jSONObjectPr;
        String[] strArrPr;
        String strConcat;
        int i5;
        String str2;
        String str3;
        int i6;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2;
        long jCurrentTimeMillis3;
        long jCurrentTimeMillis4;
        int i7;
        long jCurrentTimeMillis5;
        JSONArray jSONArrayPr;
        JSONObject jSONObjectPr2;
        JSONObject jSONObjectHn;
        long jCurrentTimeMillis6;
        boolean z4;
        String strC;
        String strUc;
        JSONObject jSONObject;
        String strPr;
        JSONObject jSONObject2 = new JSONObject();
        boolean z5 = i2 == 5;
        try {
            long jCurrentTimeMillis7 = System.currentTimeMillis();
            if (iVar == null) {
                if (!TextUtils.isEmpty(str)) {
                    strHw = str;
                } else {
                    strHw = ls.fw();
                }
                if (hwVar != null) {
                    if (hwVar.fo() != null) {
                        switch (com.byazt.nq.x.pr(hwVar.fo())) {
                            case 1:
                                jSONObject2.put("req_type", 1);
                                break;
                            case 2:
                            default:
                                jSONObject2.put("req_type", -1);
                                break;
                            case 3:
                                jSONObject2.put("req_type", 3);
                                break;
                        }
                    }
                    if (i == 7) {
                        if (iVar != null) {
                            jSONObject2.put("req_type", iVar.pr);
                        }
                        if (iVar != null) {
                            jSONObject2.put("pre_sessions", iVar.hn);
                            jSONObject2.put("play_again_count", iVar.x);
                        }
                    } else if (i == 8) {
                        jSONObject2.put("req_type", iVar.pr);
                    }
                    strC = com.byazt.mp.c.pr().c();
                    strUc = com.byazt.mp.c.pr().uc();
                    jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(strC)) {
                        obj = "unknown";
                    } else {
                        obj = "unknown";
                        jSONObject.putOpt("version", strC);
                    }
                    if (hwVar != null) {
                        strPr = null;
                    } else {
                        strPr = ls.pr(hwVar.yb());
                        if (!TextUtils.isEmpty(strPr)) {
                            jSONObject.put("external_ab_vid", strPr);
                        }
                    }
                    if (!TextUtils.isEmpty(strUc)) {
                        jSONObject.putOpt("param", strUc);
                    }
                    if (TextUtils.isEmpty(strC)) {
                        jSONObject2.put("abtest", jSONObject);
                    } else {
                        jSONObject2.put("abtest", jSONObject);
                    }
                    if (z5) {
                        andSet = com.byazt.dt.vk.hw.getAndSet(0);
                        if (andSet > 0) {
                            jSONObject2.put("throttle_count", andSet);
                        }
                    }
                    jSONObject2.put(Constants.Bidding.REQUEST_ID, strHw);
                    if (z2) {
                        jSONObject2.put("exemption_req", 1);
                    }
                    jSONObject2.put("ad_sdk_version", iu.c);
                    jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
                    jSONObject2.put("is_plugin", iu.pr());
                    jSONObject2.put("sdk_boost_type", com.byazt.iq.pr.c());
                    if (iu.x()) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    jSONObject2.put("is_use_tt_video", i3);
                    long jCurrentTimeMillis8 = (System.currentTimeMillis() - jCurrentTimeMillis7) + 0;
                    long jCurrentTimeMillis9 = System.currentTimeMillis();
                    long jCurrentTimeMillis10 = System.currentTimeMillis();
                    hwVarPr = com.byazt.eg.hw.pr();
                    pr(iVar, "liveInstance", jCurrentTimeMillis10, z5);
                    long jCurrentTimeMillis11 = System.currentTimeMillis();
                    iHn = hwVarPr.hn();
                    jSONObject2.put("live_sdk_status", iHn);
                    pr(iVar, "liveSdkStatus", jCurrentTimeMillis11, z5);
                    long jCurrentTimeMillis12 = System.currentTimeMillis();
                    jSONObject2.put("live_auth_status", hwVarPr.c());
                    pr(iVar, "liveAuthStatus", jCurrentTimeMillis12, z5);
                    jSONObject2.put("live_sdk_config", hwVarPr.zo());
                    long jCurrentTimeMillis13 = System.currentTimeMillis();
                    jSONObject2.put("live_ad_click_count", hwVarPr.uc());
                    pr(iVar, "liveAdClickCount", jCurrentTimeMillis13, z5);
                    pr(iVar, "liveSupportCode", System.currentTimeMillis(), z5);
                    long jCurrentTimeMillis14 = System.currentTimeMillis();
                    zo.nt().k();
                    pr(iVar, "liveOaidNotify", jCurrentTimeMillis14, z5);
                    if (iHn != 2) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        jSONObject2.put("app_start_time", jElapsedRealtime - Process.getStartElapsedRealtime());
                        jSONObject2.put("live_last_init_time", jElapsedRealtime - hwVarPr.aj());
                    }
                    if (zo.nt().v()) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    jSONObject2.put("csj_type", i4);
                    jSONObject2.put("pma_data", com.byazt.sq.pr.pr().hw());
                    strFw = hwVarPr.fw();
                    if (!TextUtils.isEmpty(strFw)) {
                        jSONObject2.put("live_plugin_version", strFw);
                    }
                    pr(iVar, "liveInfo", jCurrentTimeMillis9, z5);
                    long jCurrentTimeMillis15 = System.currentTimeMillis();
                    jSONObject2.put("source_type", "app");
                    jSONObject2.put("logsdk_version", com.byazt.mp.x.pr().c(i));
                    long jCurrentTimeMillis16 = jCurrentTimeMillis8 + (System.currentTimeMillis() - jCurrentTimeMillis15);
                    long jCurrentTimeMillis17 = System.currentTimeMillis();
                    if (i2 != 4) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    jSONObject2.put("app", DeviceUtils.pr(i, z3));
                    pr(iVar, "appInfo", jCurrentTimeMillis17, z5);
                    long jCurrentTimeMillis18 = System.currentTimeMillis();
                    Context context = this.hw;
                    if (z5) {
                        iVar2 = iVar;
                    } else {
                        iVar2 = null;
                    }
                    jSONObjectPr = com.byazt.mp.pr.pr(context, i, iVar2);
                    pr(iVar, "deviceInfo", jCurrentTimeMillis18, z5);
                    long jCurrentTimeMillis19 = System.currentTimeMillis();
                    if (jSONObjectPr != null) {
                        hwVar2 = hwVar;
                    } else {
                        if (!a.hw().ag()) {
                            jSONObjectPr.remove("free_space");
                        }
                        hwVar2 = hwVar;
                        if (hwVar2 != null) {
                            if (hwVar.ho() > 0) {
                                jSONObjectPr.put("orientation", hwVar.ho());
                            }
                        }
                        if (com.byazt.mp.x.pr().fw(i)) {
                            Object obj2 = obj;
                            jSONObjectPr.put("wifi_signal", obj2);
                            jSONObjectPr.put("cellular_signal", obj2);
                        } else {
                            jSONObjectPr.put("wifi_signal", DeviceUtils.pr(0));
                            jSONObjectPr.put("cellular_signal", DeviceUtils.pr(1));
                        }
                        if (i2 != 4) {
                            jSONObjectPr.put("sof_chara", com.byazt.wt.rc.fw());
                        }
                        com.byazt.wt.k.pr(jSONObjectPr);
                        jSONObjectPr.put("cpu_arch", com.byazt.wt.rc.g());
                        jSONObjectPr.put("direction", com.byazt.na.pr.pr().uc());
                        jSONObjectPr.put("font_size", com.byazt.mk.hn.fw().g());
                        jSONObjectPr.put("gpu_model", com.byazt.mk.zo.pr());
                    }
                    jSONObject2.put("device", jSONObjectPr);
                    pr(iVar, "deviceExtra", jCurrentTimeMillis19, z5);
                    long jCurrentTimeMillis20 = System.currentTimeMillis();
                    jSONObject2.put("sdk_extra_data", pr(hwVar2, i2));
                    jSONObject2.put("pan_code_serial", "1000");
                    pr(iVar, "sdkExtraData", jCurrentTimeMillis20, z5);
                    long jCurrentTimeMillis21 = System.currentTimeMillis();
                    jSONObject2.put(com.umeng.analytics.pro.z.m, hn(hwVar2, i));
                    pr(iVar, "userInfo", jCurrentTimeMillis21, z5);
                    long jCurrentTimeMillis22 = System.currentTimeMillis();
                    jSONObject2.put(com.umeng.analytics.pro.z.d, ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
                    pr(iVar, "uaInfo", jCurrentTimeMillis22, z5);
                    jSONObject2.put("channel", iu.zo);
                    long jCurrentTimeMillis23 = System.currentTimeMillis();
                    strArrPr = com.byazt.mp.pr.pr(i);
                    strConcat = "";
                    if (strArrPr != null) {
                        i5 = 0;
                        str2 = "";
                        str3 = str2;
                    } else {
                        i5 = 0;
                        str2 = "";
                        str3 = str2;
                    }
                    jSONObject2.put("ip", str3);
                    jSONObject2.put("client_ipv6", str2);
                    jSONObject2.put("client_ipv4", com.byazt.mp.pr.pr(str3, i));
                    pr(iVar, "ipInfo", jCurrentTimeMillis23, z5);
                    long jCurrentTimeMillis24 = System.currentTimeMillis();
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(pr(hwVar2, i, iVar));
                    jSONObject2.put("adslots", jSONArray);
                    pr(iVar, "adslotInfo", jCurrentTimeMillis24, z5);
                    long jCurrentTimeMillis25 = System.currentTimeMillis();
                    if (iVar != null) {
                        jSONObject2.put("load_ad_api", iVar.g);
                    }
                    com.byazt.mp.pr.pr(jSONObject2, i);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("start2req_time", SystemClock.elapsedRealtime() - lb.c);
                    if (lb.hw.get()) {
                        i6 = i5;
                    } else {
                        i6 = 1;
                    }
                    jSONObject3.put("start_type", i6);
                    jSONObject3.put("show_count", com.byazt.pj.pr.pr);
                    jSONObject2.put("ads_parameter", jSONObject3);
                    pr(jSONObject2, iVar);
                    jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    jSONObject2.put("ts", jCurrentTimeMillis);
                    if (hwVar.x() != null) {
                        strConcat = String.valueOf(jCurrentTimeMillis).concat(hwVar.x()).concat(strHw);
                    }
                    jSONObject2.put("req_sign", com.byazt.ca.c.hw(strConcat));
                    jCurrentTimeMillis2 = jCurrentTimeMillis16 + (System.currentTimeMillis() - jCurrentTimeMillis25);
                    if (iVar != null) {
                        iVar.pr("basicFields", jCurrentTimeMillis2, z5);
                    }
                    if (i2 == 4) {
                        jCurrentTimeMillis6 = System.currentTimeMillis();
                        jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(a.hw().pr(hwVar.x())));
                        if (a.hw().hw(hwVar.x())) {
                            if (7 == hwVar.a()) {
                                z4 = 1;
                            } else {
                                z4 = i5;
                            }
                            pr(z4, jSONObject2, hwVar.x());
                        } else {
                            com.byazt.xk.hw.pr().pr(hwVar.x(), (String) null, (String) null, true);
                        }
                        if (iVar != null) {
                            iVar.ho.pr("precache_time", System.currentTimeMillis() - jCurrentTimeMillis6);
                        }
                    }
                    if (z) {
                        jSONObject2.put("ad_sdk_version", iu.c);
                        return jSONObject2;
                    }
                    if (i2 == 3) {
                        jSONObject2.put("material_keys", ls.pr(hwVar));
                    }
                    jCurrentTimeMillis3 = System.currentTimeMillis();
                    if (a.hw().tt()) {
                        jSONObject2.put("feature_data", com.byazt.mk.hn.fw().aj());
                        pr(iVar, "featureV1", jCurrentTimeMillis3, z5);
                    }
                    jCurrentTimeMillis4 = System.currentTimeMillis();
                    if (a.hw().dl()) {
                        jSONObjectHn = com.byazt.gf.pr.pr().hn();
                        if (jSONObjectHn != null) {
                            jSONObject2.putOpt("feature_data_v2", jSONObjectHn);
                        }
                        pr(iVar, "featureV2", jCurrentTimeMillis4, z5);
                    }
                    if (iVar == null) {
                        i7 = i5;
                    } else {
                        i7 = i5;
                    }
                    jCurrentTimeMillis5 = System.currentTimeMillis();
                    if (i7 == 0) {
                        jSONObjectPr2 = pr(iVar);
                        if (jSONObjectPr2 != null) {
                            jSONObject2.put("load_feature", jSONObjectPr2);
                        }
                        pr(iVar, "loadFeature", jCurrentTimeMillis5, z5);
                    }
                    if (iVar != null) {
                        jSONObject2.put("second_page_type", iVar.yb);
                        jSONObject2.put("second_page_origin_req_id", iVar.lb);
                    }
                    jSONArrayPr = com.byazt.ba.c.pr();
                    if (jSONArrayPr != null) {
                        jSONObject2.putOpt("csj_sdk_abilities", jSONArrayPr);
                    }
                    long jCurrentTimeMillis26 = System.currentTimeMillis();
                    com.byazt.wm.pr.pr(jSONObject2);
                    pr(iVar, "dplStatusCounter", jCurrentTimeMillis26, z5);
                } else {
                    if (i == 7) {
                        if (iVar != null) {
                            jSONObject2.put("req_type", iVar.pr);
                        }
                        if (iVar != null) {
                            jSONObject2.put("pre_sessions", iVar.hn);
                            jSONObject2.put("play_again_count", iVar.x);
                        }
                    } else if (i == 8) {
                        jSONObject2.put("req_type", iVar.pr);
                    }
                    strC = com.byazt.mp.c.pr().c();
                    strUc = com.byazt.mp.c.pr().uc();
                    jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(strC)) {
                        obj = "unknown";
                    } else {
                        obj = "unknown";
                        jSONObject.putOpt("version", strC);
                    }
                    if (hwVar != null) {
                        strPr = null;
                    } else {
                        strPr = ls.pr(hwVar.yb());
                        if (!TextUtils.isEmpty(strPr)) {
                            jSONObject.put("external_ab_vid", strPr);
                        }
                    }
                    if (!TextUtils.isEmpty(strUc)) {
                        jSONObject.putOpt("param", strUc);
                    }
                    if (TextUtils.isEmpty(strC)) {
                        jSONObject2.put("abtest", jSONObject);
                    } else {
                        jSONObject2.put("abtest", jSONObject);
                    }
                    if (z5) {
                        andSet = com.byazt.dt.vk.hw.getAndSet(0);
                        if (andSet > 0) {
                            jSONObject2.put("throttle_count", andSet);
                        }
                    }
                    jSONObject2.put(Constants.Bidding.REQUEST_ID, strHw);
                    if (z2) {
                        jSONObject2.put("exemption_req", 1);
                    }
                    jSONObject2.put("ad_sdk_version", iu.c);
                    jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
                    jSONObject2.put("is_plugin", iu.pr());
                    jSONObject2.put("sdk_boost_type", com.byazt.iq.pr.c());
                    if (iu.x()) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    jSONObject2.put("is_use_tt_video", i3);
                    long jCurrentTimeMillis27 = (System.currentTimeMillis() - jCurrentTimeMillis7) + 0;
                    long jCurrentTimeMillis28 = System.currentTimeMillis();
                    long jCurrentTimeMillis110 = System.currentTimeMillis();
                    hwVarPr = com.byazt.eg.hw.pr();
                    pr(iVar, "liveInstance", jCurrentTimeMillis110, z5);
                    long jCurrentTimeMillis111 = System.currentTimeMillis();
                    iHn = hwVarPr.hn();
                    jSONObject2.put("live_sdk_status", iHn);
                    pr(iVar, "liveSdkStatus", jCurrentTimeMillis111, z5);
                    long jCurrentTimeMillis112 = System.currentTimeMillis();
                    jSONObject2.put("live_auth_status", hwVarPr.c());
                    pr(iVar, "liveAuthStatus", jCurrentTimeMillis112, z5);
                    jSONObject2.put("live_sdk_config", hwVarPr.zo());
                    long jCurrentTimeMillis113 = System.currentTimeMillis();
                    jSONObject2.put("live_ad_click_count", hwVarPr.uc());
                    pr(iVar, "liveAdClickCount", jCurrentTimeMillis113, z5);
                    pr(iVar, "liveSupportCode", System.currentTimeMillis(), z5);
                    long jCurrentTimeMillis114 = System.currentTimeMillis();
                    zo.nt().k();
                    pr(iVar, "liveOaidNotify", jCurrentTimeMillis114, z5);
                    if (iHn != 2) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        jSONObject2.put("app_start_time", jElapsedRealtime2 - Process.getStartElapsedRealtime());
                        jSONObject2.put("live_last_init_time", jElapsedRealtime2 - hwVarPr.aj());
                    }
                    if (zo.nt().v()) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    jSONObject2.put("csj_type", i4);
                    jSONObject2.put("pma_data", com.byazt.sq.pr.pr().hw());
                    strFw = hwVarPr.fw();
                    if (!TextUtils.isEmpty(strFw)) {
                        jSONObject2.put("live_plugin_version", strFw);
                    }
                    pr(iVar, "liveInfo", jCurrentTimeMillis28, z5);
                    long jCurrentTimeMillis115 = System.currentTimeMillis();
                    jSONObject2.put("source_type", "app");
                    jSONObject2.put("logsdk_version", com.byazt.mp.x.pr().c(i));
                    long jCurrentTimeMillis116 = jCurrentTimeMillis27 + (System.currentTimeMillis() - jCurrentTimeMillis115);
                    long jCurrentTimeMillis117 = System.currentTimeMillis();
                    if (i2 != 4) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    jSONObject2.put("app", DeviceUtils.pr(i, z3));
                    pr(iVar, "appInfo", jCurrentTimeMillis117, z5);
                    long jCurrentTimeMillis118 = System.currentTimeMillis();
                    Context context2 = this.hw;
                    if (z5) {
                        iVar2 = iVar;
                    } else {
                        iVar2 = null;
                    }
                    jSONObjectPr = com.byazt.mp.pr.pr(context2, i, iVar2);
                    pr(iVar, "deviceInfo", jCurrentTimeMillis118, z5);
                    long jCurrentTimeMillis119 = System.currentTimeMillis();
                    if (jSONObjectPr != null) {
                        hwVar2 = hwVar;
                    } else {
                        if (!a.hw().ag()) {
                            jSONObjectPr.remove("free_space");
                        }
                        hwVar2 = hwVar;
                        if (hwVar2 != null) {
                            if (hwVar.ho() > 0) {
                                jSONObjectPr.put("orientation", hwVar.ho());
                            }
                        }
                        if (com.byazt.mp.x.pr().fw(i)) {
                            Object obj3 = obj;
                            jSONObjectPr.put("wifi_signal", obj3);
                            jSONObjectPr.put("cellular_signal", obj3);
                        } else {
                            jSONObjectPr.put("wifi_signal", DeviceUtils.pr(0));
                            jSONObjectPr.put("cellular_signal", DeviceUtils.pr(1));
                        }
                        if (i2 != 4) {
                            jSONObjectPr.put("sof_chara", com.byazt.wt.rc.fw());
                        }
                        com.byazt.wt.k.pr(jSONObjectPr);
                        jSONObjectPr.put("cpu_arch", com.byazt.wt.rc.g());
                        jSONObjectPr.put("direction", com.byazt.na.pr.pr().uc());
                        jSONObjectPr.put("font_size", com.byazt.mk.hn.fw().g());
                        jSONObjectPr.put("gpu_model", com.byazt.mk.zo.pr());
                    }
                    jSONObject2.put("device", jSONObjectPr);
                    pr(iVar, "deviceExtra", jCurrentTimeMillis119, z5);
                    long jCurrentTimeMillis29 = System.currentTimeMillis();
                    jSONObject2.put("sdk_extra_data", pr(hwVar2, i2));
                    jSONObject2.put("pan_code_serial", "1000");
                    pr(iVar, "sdkExtraData", jCurrentTimeMillis29, z5);
                    long jCurrentTimeMillis210 = System.currentTimeMillis();
                    jSONObject2.put(com.umeng.analytics.pro.z.m, hn(hwVar2, i));
                    pr(iVar, "userInfo", jCurrentTimeMillis210, z5);
                    long jCurrentTimeMillis211 = System.currentTimeMillis();
                    jSONObject2.put(com.umeng.analytics.pro.z.d, ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
                    pr(iVar, "uaInfo", jCurrentTimeMillis211, z5);
                    jSONObject2.put("channel", iu.zo);
                    long jCurrentTimeMillis212 = System.currentTimeMillis();
                    strArrPr = com.byazt.mp.pr.pr(i);
                    strConcat = "";
                    if (strArrPr != null) {
                        i5 = 0;
                        str2 = "";
                        str3 = str2;
                    } else {
                        i5 = 0;
                        str2 = "";
                        str3 = str2;
                    }
                    jSONObject2.put("ip", str3);
                    jSONObject2.put("client_ipv6", str2);
                    jSONObject2.put("client_ipv4", com.byazt.mp.pr.pr(str3, i));
                    pr(iVar, "ipInfo", jCurrentTimeMillis212, z5);
                    long jCurrentTimeMillis213 = System.currentTimeMillis();
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(pr(hwVar2, i, iVar));
                    jSONObject2.put("adslots", jSONArray2);
                    pr(iVar, "adslotInfo", jCurrentTimeMillis213, z5);
                    long jCurrentTimeMillis214 = System.currentTimeMillis();
                    if (iVar != null) {
                        jSONObject2.put("load_ad_api", iVar.g);
                    }
                    com.byazt.mp.pr.pr(jSONObject2, i);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("start2req_time", SystemClock.elapsedRealtime() - lb.c);
                    if (lb.hw.get()) {
                        i6 = i5;
                    } else {
                        i6 = 1;
                    }
                    jSONObject4.put("start_type", i6);
                    jSONObject4.put("show_count", com.byazt.pj.pr.pr);
                    jSONObject2.put("ads_parameter", jSONObject4);
                    pr(jSONObject2, iVar);
                    jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    jSONObject2.put("ts", jCurrentTimeMillis);
                    if (hwVar.x() != null) {
                        strConcat = String.valueOf(jCurrentTimeMillis).concat(hwVar.x()).concat(strHw);
                    }
                    jSONObject2.put("req_sign", com.byazt.ca.c.hw(strConcat));
                    jCurrentTimeMillis2 = jCurrentTimeMillis116 + (System.currentTimeMillis() - jCurrentTimeMillis214);
                    if (iVar != null) {
                        iVar.pr("basicFields", jCurrentTimeMillis2, z5);
                    }
                    if (i2 == 4) {
                        jCurrentTimeMillis6 = System.currentTimeMillis();
                        jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(a.hw().pr(hwVar.x())));
                        if (a.hw().hw(hwVar.x())) {
                            if (7 == hwVar.a()) {
                                z4 = 1;
                            } else {
                                z4 = i5;
                            }
                            pr(z4, jSONObject2, hwVar.x());
                        } else {
                            com.byazt.xk.hw.pr().pr(hwVar.x(), (String) null, (String) null, true);
                        }
                        if (iVar != null) {
                            iVar.ho.pr("precache_time", System.currentTimeMillis() - jCurrentTimeMillis6);
                        }
                    }
                    if (z) {
                        jSONObject2.put("ad_sdk_version", iu.c);
                        return jSONObject2;
                    }
                    if (i2 == 3) {
                        jSONObject2.put("material_keys", ls.pr(hwVar));
                    }
                    jCurrentTimeMillis3 = System.currentTimeMillis();
                    if (a.hw().tt()) {
                        jSONObject2.put("feature_data", com.byazt.mk.hn.fw().aj());
                        pr(iVar, "featureV1", jCurrentTimeMillis3, z5);
                    }
                    jCurrentTimeMillis4 = System.currentTimeMillis();
                    if (a.hw().dl()) {
                        jSONObjectHn = com.byazt.gf.pr.pr().hn();
                        if (jSONObjectHn != null) {
                            jSONObject2.putOpt("feature_data_v2", jSONObjectHn);
                        }
                        pr(iVar, "featureV2", jCurrentTimeMillis4, z5);
                    }
                    if (iVar == null) {
                        i7 = i5;
                    } else {
                        i7 = i5;
                    }
                    jCurrentTimeMillis5 = System.currentTimeMillis();
                    if (i7 == 0) {
                        jSONObjectPr2 = pr(iVar);
                        if (jSONObjectPr2 != null) {
                            jSONObject2.put("load_feature", jSONObjectPr2);
                        }
                        pr(iVar, "loadFeature", jCurrentTimeMillis5, z5);
                    }
                    if (iVar != null) {
                        jSONObject2.put("second_page_type", iVar.yb);
                        jSONObject2.put("second_page_origin_req_id", iVar.lb);
                    }
                    jSONArrayPr = com.byazt.ba.c.pr();
                    if (jSONArrayPr != null) {
                        jSONObject2.putOpt("csj_sdk_abilities", jSONArrayPr);
                    }
                    long jCurrentTimeMillis215 = System.currentTimeMillis();
                    com.byazt.wm.pr.pr(jSONObject2);
                    pr(iVar, "dplStatusCounter", jCurrentTimeMillis215, z5);
                }
            } else {
                try {
                    if (!TextUtils.isEmpty(iVar.hw())) {
                        strHw = iVar.hw();
                    } else if (!TextUtils.isEmpty(str)) {
                        strHw = str;
                    } else {
                        strHw = ls.fw();
                    }
                    if (hwVar != null) {
                        try {
                            if (hwVar.fo() != null) {
                                switch (com.byazt.nq.x.pr(hwVar.fo())) {
                                    case 1:
                                        jSONObject2.put("req_type", 1);
                                        break;
                                    case 2:
                                    default:
                                        jSONObject2.put("req_type", -1);
                                        break;
                                    case 3:
                                        jSONObject2.put("req_type", 3);
                                        break;
                                }
                            }
                            if (i == 7) {
                                if (iVar != null && iVar.pr > 0) {
                                    jSONObject2.put("req_type", iVar.pr);
                                }
                                if (iVar != null && !TextUtils.isEmpty(iVar.hn)) {
                                    jSONObject2.put("pre_sessions", iVar.hn);
                                    jSONObject2.put("play_again_count", iVar.x);
                                }
                            } else if (i == 8 && iVar != null && iVar.pr > 0) {
                                jSONObject2.put("req_type", iVar.pr);
                            }
                            try {
                                strC = com.byazt.mp.c.pr().c();
                                strUc = com.byazt.mp.c.pr().uc();
                                jSONObject = new JSONObject();
                                if (!TextUtils.isEmpty(strC)) {
                                    obj = "unknown";
                                } else {
                                    obj = "unknown";
                                    try {
                                        jSONObject.putOpt("version", strC);
                                    } catch (Throwable th) {
                                    }
                                }
                                if (hwVar != null) {
                                    strPr = null;
                                } else {
                                    strPr = ls.pr(hwVar.yb());
                                    if (!TextUtils.isEmpty(strPr)) {
                                        jSONObject.put("external_ab_vid", strPr);
                                    }
                                }
                                if (!TextUtils.isEmpty(strUc)) {
                                    jSONObject.putOpt("param", strUc);
                                }
                                if (TextUtils.isEmpty(strC) || !TextUtils.isEmpty(strPr) || !TextUtils.isEmpty(strUc)) {
                                    jSONObject2.put("abtest", jSONObject);
                                }
                            } catch (Throwable th2) {
                                obj = "unknown";
                            }
                            if (z5) {
                                try {
                                    andSet = com.byazt.dt.vk.hw.getAndSet(0);
                                    if (andSet > 0) {
                                        jSONObject2.put("throttle_count", andSet);
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    hwVar2 = hwVar;
                                    pr(strHw, hwVar2, th);
                                    return jSONObject2;
                                }
                            }
                            jSONObject2.put(Constants.Bidding.REQUEST_ID, strHw);
                            if (z2) {
                                jSONObject2.put("exemption_req", 1);
                            }
                            jSONObject2.put("ad_sdk_version", iu.c);
                            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
                            jSONObject2.put("is_plugin", iu.pr());
                            jSONObject2.put("sdk_boost_type", com.byazt.iq.pr.c());
                            if (iu.x()) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            jSONObject2.put("is_use_tt_video", i3);
                            long jCurrentTimeMillis216 = (System.currentTimeMillis() - jCurrentTimeMillis7) + 0;
                            long jCurrentTimeMillis217 = System.currentTimeMillis();
                            long jCurrentTimeMillis1110 = System.currentTimeMillis();
                            hwVarPr = com.byazt.eg.hw.pr();
                            pr(iVar, "liveInstance", jCurrentTimeMillis1110, z5);
                            long jCurrentTimeMillis1111 = System.currentTimeMillis();
                            iHn = hwVarPr.hn();
                            jSONObject2.put("live_sdk_status", iHn);
                            pr(iVar, "liveSdkStatus", jCurrentTimeMillis1111, z5);
                            long jCurrentTimeMillis1112 = System.currentTimeMillis();
                            jSONObject2.put("live_auth_status", hwVarPr.c());
                            pr(iVar, "liveAuthStatus", jCurrentTimeMillis1112, z5);
                            jSONObject2.put("live_sdk_config", hwVarPr.zo());
                            long jCurrentTimeMillis1113 = System.currentTimeMillis();
                            jSONObject2.put("live_ad_click_count", hwVarPr.uc());
                            pr(iVar, "liveAdClickCount", jCurrentTimeMillis1113, z5);
                            pr(iVar, "liveSupportCode", System.currentTimeMillis(), z5);
                            long jCurrentTimeMillis1114 = System.currentTimeMillis();
                            zo.nt().k();
                            pr(iVar, "liveOaidNotify", jCurrentTimeMillis1114, z5);
                            if (iHn != 2) {
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                jSONObject2.put("app_start_time", jElapsedRealtime3 - Process.getStartElapsedRealtime());
                                jSONObject2.put("live_last_init_time", jElapsedRealtime3 - hwVarPr.aj());
                            }
                            if (zo.nt().v()) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            jSONObject2.put("csj_type", i4);
                            jSONObject2.put("pma_data", com.byazt.sq.pr.pr().hw());
                            strFw = hwVarPr.fw();
                            if (!TextUtils.isEmpty(strFw)) {
                                jSONObject2.put("live_plugin_version", strFw);
                            }
                            pr(iVar, "liveInfo", jCurrentTimeMillis217, z5);
                            long jCurrentTimeMillis1115 = System.currentTimeMillis();
                            jSONObject2.put("source_type", "app");
                            jSONObject2.put("logsdk_version", com.byazt.mp.x.pr().c(i));
                            long jCurrentTimeMillis1116 = jCurrentTimeMillis216 + (System.currentTimeMillis() - jCurrentTimeMillis1115);
                            long jCurrentTimeMillis1117 = System.currentTimeMillis();
                            if (i2 != 4 || z5) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            jSONObject2.put("app", DeviceUtils.pr(i, z3));
                            pr(iVar, "appInfo", jCurrentTimeMillis1117, z5);
                            long jCurrentTimeMillis1118 = System.currentTimeMillis();
                            Context context3 = this.hw;
                            if (z5) {
                                iVar2 = iVar;
                            } else {
                                iVar2 = null;
                            }
                            jSONObjectPr = com.byazt.mp.pr.pr(context3, i, iVar2);
                            pr(iVar, "deviceInfo", jCurrentTimeMillis1118, z5);
                            long jCurrentTimeMillis1119 = System.currentTimeMillis();
                            if (jSONObjectPr != null) {
                                hwVar2 = hwVar;
                            } else {
                                if (!a.hw().ag() && !com.byazt.jx.aj.hw()) {
                                    jSONObjectPr.remove("free_space");
                                }
                                hwVar2 = hwVar;
                                if (hwVar2 != null) {
                                    try {
                                        if (hwVar.ho() > 0) {
                                            jSONObjectPr.put("orientation", hwVar.ho());
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        pr(strHw, hwVar2, th);
                                    }
                                }
                                if (com.byazt.mp.x.pr().fw(i)) {
                                    Object obj4 = obj;
                                    jSONObjectPr.put("wifi_signal", obj4);
                                    jSONObjectPr.put("cellular_signal", obj4);
                                } else {
                                    jSONObjectPr.put("wifi_signal", DeviceUtils.pr(0));
                                    jSONObjectPr.put("cellular_signal", DeviceUtils.pr(1));
                                }
                                if (i2 != 4) {
                                    jSONObjectPr.put("sof_chara", com.byazt.wt.rc.fw());
                                }
                                com.byazt.wt.k.pr(jSONObjectPr);
                                jSONObjectPr.put("cpu_arch", com.byazt.wt.rc.g());
                                jSONObjectPr.put("direction", com.byazt.na.pr.pr().uc());
                                jSONObjectPr.put("font_size", com.byazt.mk.hn.fw().g());
                                jSONObjectPr.put("gpu_model", com.byazt.mk.zo.pr());
                            }
                            jSONObject2.put("device", jSONObjectPr);
                            pr(iVar, "deviceExtra", jCurrentTimeMillis1119, z5);
                            long jCurrentTimeMillis218 = System.currentTimeMillis();
                            jSONObject2.put("sdk_extra_data", pr(hwVar2, i2));
                            jSONObject2.put("pan_code_serial", "1000");
                            pr(iVar, "sdkExtraData", jCurrentTimeMillis218, z5);
                            long jCurrentTimeMillis219 = System.currentTimeMillis();
                            jSONObject2.put(com.umeng.analytics.pro.z.m, hn(hwVar2, i));
                            pr(iVar, "userInfo", jCurrentTimeMillis219, z5);
                            long jCurrentTimeMillis2110 = System.currentTimeMillis();
                            jSONObject2.put(com.umeng.analytics.pro.z.d, ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
                            pr(iVar, "uaInfo", jCurrentTimeMillis2110, z5);
                            jSONObject2.put("channel", iu.zo);
                            long jCurrentTimeMillis2111 = System.currentTimeMillis();
                            strArrPr = com.byazt.mp.pr.pr(i);
                            strConcat = "";
                            if (strArrPr != null || strArrPr.length < 2) {
                                i5 = 0;
                                str2 = "";
                                str3 = str2;
                            } else {
                                i5 = 0;
                                str3 = strArrPr[0];
                                str2 = strArrPr[1];
                            }
                            jSONObject2.put("ip", str3);
                            jSONObject2.put("client_ipv6", str2);
                            jSONObject2.put("client_ipv4", com.byazt.mp.pr.pr(str3, i));
                            pr(iVar, "ipInfo", jCurrentTimeMillis2111, z5);
                            long jCurrentTimeMillis2112 = System.currentTimeMillis();
                            JSONArray jSONArray3 = new JSONArray();
                            jSONArray3.put(pr(hwVar2, i, iVar));
                            jSONObject2.put("adslots", jSONArray3);
                            pr(iVar, "adslotInfo", jCurrentTimeMillis2112, z5);
                            long jCurrentTimeMillis2113 = System.currentTimeMillis();
                            if (iVar != null && iVar.g > 0) {
                                jSONObject2.put("load_ad_api", iVar.g);
                            }
                            com.byazt.mp.pr.pr(jSONObject2, i);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("start2req_time", SystemClock.elapsedRealtime() - lb.c);
                            if (lb.hw.get()) {
                                i6 = i5;
                            } else {
                                i6 = 1;
                            }
                            jSONObject5.put("start_type", i6);
                            jSONObject5.put("show_count", com.byazt.pj.pr.pr);
                            jSONObject2.put("ads_parameter", jSONObject5);
                            pr(jSONObject2, iVar);
                            jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                            jSONObject2.put("ts", jCurrentTimeMillis);
                            if (hwVar.x() != null && strHw != null) {
                                strConcat = String.valueOf(jCurrentTimeMillis).concat(hwVar.x()).concat(strHw);
                            }
                            jSONObject2.put("req_sign", com.byazt.ca.c.hw(strConcat));
                            jCurrentTimeMillis2 = jCurrentTimeMillis1116 + (System.currentTimeMillis() - jCurrentTimeMillis2113);
                            if (iVar != null) {
                                iVar.pr("basicFields", jCurrentTimeMillis2, z5);
                            }
                            if (i2 == 4) {
                                jCurrentTimeMillis6 = System.currentTimeMillis();
                                jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(a.hw().pr(hwVar.x())));
                                if (a.hw().hw(hwVar.x())) {
                                    if (7 == hwVar.a()) {
                                        z4 = 1;
                                    } else {
                                        z4 = i5;
                                    }
                                    pr(z4, jSONObject2, hwVar.x());
                                } else {
                                    com.byazt.xk.hw.pr().pr(hwVar.x(), (String) null, (String) null, true);
                                }
                                if (iVar != null && iVar.ho != null) {
                                    iVar.ho.pr("precache_time", System.currentTimeMillis() - jCurrentTimeMillis6);
                                }
                            }
                            if (z) {
                                jSONObject2.put("ad_sdk_version", iu.c);
                                return jSONObject2;
                            }
                            if (i2 == 3) {
                                jSONObject2.put("material_keys", ls.pr(hwVar));
                            }
                            jCurrentTimeMillis3 = System.currentTimeMillis();
                            if (a.hw().tt()) {
                                jSONObject2.put("feature_data", com.byazt.mk.hn.fw().aj());
                                pr(iVar, "featureV1", jCurrentTimeMillis3, z5);
                            }
                            jCurrentTimeMillis4 = System.currentTimeMillis();
                            if (a.hw().dl()) {
                                jSONObjectHn = com.byazt.gf.pr.pr().hn();
                                if (jSONObjectHn != null && jSONObjectHn.length() > 0) {
                                    jSONObject2.putOpt("feature_data_v2", jSONObjectHn);
                                }
                                pr(iVar, "featureV2", jCurrentTimeMillis4, z5);
                            }
                            if (iVar == null && (iVar.pr == 2 || iVar.hw == 2)) {
                                i7 = 1;
                            } else {
                                i7 = i5;
                            }
                            jCurrentTimeMillis5 = System.currentTimeMillis();
                            if (i7 == 0 && com.byazt.ua.hn.x() == 1) {
                                jSONObjectPr2 = pr(iVar);
                                if (jSONObjectPr2 != null && jSONObjectPr2.length() > 0) {
                                    jSONObject2.put("load_feature", jSONObjectPr2);
                                }
                                pr(iVar, "loadFeature", jCurrentTimeMillis5, z5);
                            }
                            if (iVar != null && iVar.yb > 0) {
                                jSONObject2.put("second_page_type", iVar.yb);
                                jSONObject2.put("second_page_origin_req_id", iVar.lb);
                            }
                            jSONArrayPr = com.byazt.ba.c.pr();
                            if (jSONArrayPr != null && jSONArrayPr.length() > 0) {
                                jSONObject2.putOpt("csj_sdk_abilities", jSONArrayPr);
                            }
                            long jCurrentTimeMillis2114 = System.currentTimeMillis();
                            com.byazt.wm.pr.pr(jSONObject2);
                            pr(iVar, "dplStatusCounter", jCurrentTimeMillis2114, z5);
                        } catch (Throwable th5) {
                            th = th5;
                            hwVar2 = hwVar;
                            pr(strHw, hwVar2, th);
                            return jSONObject2;
                        }
                    } else {
                        if (i == 7) {
                            if (iVar != null) {
                                jSONObject2.put("req_type", iVar.pr);
                            }
                            if (iVar != null) {
                                jSONObject2.put("pre_sessions", iVar.hn);
                                jSONObject2.put("play_again_count", iVar.x);
                            }
                        } else if (i == 8) {
                            jSONObject2.put("req_type", iVar.pr);
                        }
                        strC = com.byazt.mp.c.pr().c();
                        strUc = com.byazt.mp.c.pr().uc();
                        jSONObject = new JSONObject();
                        if (!TextUtils.isEmpty(strC)) {
                            obj = "unknown";
                        } else {
                            obj = "unknown";
                            jSONObject.putOpt("version", strC);
                        }
                        if (hwVar != null) {
                            strPr = null;
                        } else {
                            strPr = ls.pr(hwVar.yb());
                            if (!TextUtils.isEmpty(strPr)) {
                                jSONObject.put("external_ab_vid", strPr);
                            }
                        }
                        if (!TextUtils.isEmpty(strUc)) {
                            jSONObject.putOpt("param", strUc);
                        }
                        if (TextUtils.isEmpty(strC)) {
                            jSONObject2.put("abtest", jSONObject);
                        } else {
                            jSONObject2.put("abtest", jSONObject);
                        }
                        if (z5) {
                            andSet = com.byazt.dt.vk.hw.getAndSet(0);
                            if (andSet > 0) {
                                jSONObject2.put("throttle_count", andSet);
                            }
                        }
                        jSONObject2.put(Constants.Bidding.REQUEST_ID, strHw);
                        if (z2) {
                            jSONObject2.put("exemption_req", 1);
                        }
                        jSONObject2.put("ad_sdk_version", iu.c);
                        jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
                        jSONObject2.put("is_plugin", iu.pr());
                        jSONObject2.put("sdk_boost_type", com.byazt.iq.pr.c());
                        if (iu.x()) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        jSONObject2.put("is_use_tt_video", i3);
                        long jCurrentTimeMillis2115 = (System.currentTimeMillis() - jCurrentTimeMillis7) + 0;
                        long jCurrentTimeMillis2116 = System.currentTimeMillis();
                        long jCurrentTimeMillis11110 = System.currentTimeMillis();
                        hwVarPr = com.byazt.eg.hw.pr();
                        pr(iVar, "liveInstance", jCurrentTimeMillis11110, z5);
                        long jCurrentTimeMillis11111 = System.currentTimeMillis();
                        iHn = hwVarPr.hn();
                        jSONObject2.put("live_sdk_status", iHn);
                        pr(iVar, "liveSdkStatus", jCurrentTimeMillis11111, z5);
                        long jCurrentTimeMillis11112 = System.currentTimeMillis();
                        jSONObject2.put("live_auth_status", hwVarPr.c());
                        pr(iVar, "liveAuthStatus", jCurrentTimeMillis11112, z5);
                        jSONObject2.put("live_sdk_config", hwVarPr.zo());
                        long jCurrentTimeMillis11113 = System.currentTimeMillis();
                        jSONObject2.put("live_ad_click_count", hwVarPr.uc());
                        pr(iVar, "liveAdClickCount", jCurrentTimeMillis11113, z5);
                        pr(iVar, "liveSupportCode", System.currentTimeMillis(), z5);
                        long jCurrentTimeMillis11114 = System.currentTimeMillis();
                        zo.nt().k();
                        pr(iVar, "liveOaidNotify", jCurrentTimeMillis11114, z5);
                        if (iHn != 2) {
                            long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                            jSONObject2.put("app_start_time", jElapsedRealtime4 - Process.getStartElapsedRealtime());
                            jSONObject2.put("live_last_init_time", jElapsedRealtime4 - hwVarPr.aj());
                        }
                        if (zo.nt().v()) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        jSONObject2.put("csj_type", i4);
                        jSONObject2.put("pma_data", com.byazt.sq.pr.pr().hw());
                        strFw = hwVarPr.fw();
                        if (!TextUtils.isEmpty(strFw)) {
                            jSONObject2.put("live_plugin_version", strFw);
                        }
                        pr(iVar, "liveInfo", jCurrentTimeMillis2116, z5);
                        long jCurrentTimeMillis11115 = System.currentTimeMillis();
                        jSONObject2.put("source_type", "app");
                        jSONObject2.put("logsdk_version", com.byazt.mp.x.pr().c(i));
                        long jCurrentTimeMillis11116 = jCurrentTimeMillis2115 + (System.currentTimeMillis() - jCurrentTimeMillis11115);
                        long jCurrentTimeMillis11117 = System.currentTimeMillis();
                        if (i2 != 4) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        jSONObject2.put("app", DeviceUtils.pr(i, z3));
                        pr(iVar, "appInfo", jCurrentTimeMillis11117, z5);
                        long jCurrentTimeMillis11118 = System.currentTimeMillis();
                        Context context4 = this.hw;
                        if (z5) {
                            iVar2 = iVar;
                        } else {
                            iVar2 = null;
                        }
                        jSONObjectPr = com.byazt.mp.pr.pr(context4, i, iVar2);
                        pr(iVar, "deviceInfo", jCurrentTimeMillis11118, z5);
                        long jCurrentTimeMillis11119 = System.currentTimeMillis();
                        if (jSONObjectPr != null) {
                            hwVar2 = hwVar;
                        } else {
                            if (!a.hw().ag()) {
                                jSONObjectPr.remove("free_space");
                            }
                            hwVar2 = hwVar;
                            if (hwVar2 != null) {
                                if (hwVar.ho() > 0) {
                                    jSONObjectPr.put("orientation", hwVar.ho());
                                }
                            }
                            if (com.byazt.mp.x.pr().fw(i)) {
                                Object obj5 = obj;
                                jSONObjectPr.put("wifi_signal", obj5);
                                jSONObjectPr.put("cellular_signal", obj5);
                            } else {
                                jSONObjectPr.put("wifi_signal", DeviceUtils.pr(0));
                                jSONObjectPr.put("cellular_signal", DeviceUtils.pr(1));
                            }
                            if (i2 != 4) {
                                jSONObjectPr.put("sof_chara", com.byazt.wt.rc.fw());
                            }
                            com.byazt.wt.k.pr(jSONObjectPr);
                            jSONObjectPr.put("cpu_arch", com.byazt.wt.rc.g());
                            jSONObjectPr.put("direction", com.byazt.na.pr.pr().uc());
                            jSONObjectPr.put("font_size", com.byazt.mk.hn.fw().g());
                            jSONObjectPr.put("gpu_model", com.byazt.mk.zo.pr());
                        }
                        jSONObject2.put("device", jSONObjectPr);
                        pr(iVar, "deviceExtra", jCurrentTimeMillis11119, z5);
                        long jCurrentTimeMillis2117 = System.currentTimeMillis();
                        jSONObject2.put("sdk_extra_data", pr(hwVar2, i2));
                        jSONObject2.put("pan_code_serial", "1000");
                        pr(iVar, "sdkExtraData", jCurrentTimeMillis2117, z5);
                        long jCurrentTimeMillis2118 = System.currentTimeMillis();
                        jSONObject2.put(com.umeng.analytics.pro.z.m, hn(hwVar2, i));
                        pr(iVar, "userInfo", jCurrentTimeMillis2118, z5);
                        long jCurrentTimeMillis2119 = System.currentTimeMillis();
                        jSONObject2.put(com.umeng.analytics.pro.z.d, ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
                        pr(iVar, "uaInfo", jCurrentTimeMillis2119, z5);
                        jSONObject2.put("channel", iu.zo);
                        long jCurrentTimeMillis21110 = System.currentTimeMillis();
                        strArrPr = com.byazt.mp.pr.pr(i);
                        strConcat = "";
                        if (strArrPr != null) {
                            i5 = 0;
                            str2 = "";
                            str3 = str2;
                        } else {
                            i5 = 0;
                            str2 = "";
                            str3 = str2;
                        }
                        jSONObject2.put("ip", str3);
                        jSONObject2.put("client_ipv6", str2);
                        jSONObject2.put("client_ipv4", com.byazt.mp.pr.pr(str3, i));
                        pr(iVar, "ipInfo", jCurrentTimeMillis21110, z5);
                        long jCurrentTimeMillis21111 = System.currentTimeMillis();
                        JSONArray jSONArray4 = new JSONArray();
                        jSONArray4.put(pr(hwVar2, i, iVar));
                        jSONObject2.put("adslots", jSONArray4);
                        pr(iVar, "adslotInfo", jCurrentTimeMillis21111, z5);
                        long jCurrentTimeMillis21112 = System.currentTimeMillis();
                        if (iVar != null) {
                            jSONObject2.put("load_ad_api", iVar.g);
                        }
                        com.byazt.mp.pr.pr(jSONObject2, i);
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("start2req_time", SystemClock.elapsedRealtime() - lb.c);
                        if (lb.hw.get()) {
                            i6 = i5;
                        } else {
                            i6 = 1;
                        }
                        jSONObject6.put("start_type", i6);
                        jSONObject6.put("show_count", com.byazt.pj.pr.pr);
                        jSONObject2.put("ads_parameter", jSONObject6);
                        pr(jSONObject2, iVar);
                        jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                        jSONObject2.put("ts", jCurrentTimeMillis);
                        if (hwVar.x() != null) {
                            strConcat = String.valueOf(jCurrentTimeMillis).concat(hwVar.x()).concat(strHw);
                        }
                        jSONObject2.put("req_sign", com.byazt.ca.c.hw(strConcat));
                        jCurrentTimeMillis2 = jCurrentTimeMillis11116 + (System.currentTimeMillis() - jCurrentTimeMillis21112);
                        if (iVar != null) {
                            iVar.pr("basicFields", jCurrentTimeMillis2, z5);
                        }
                        if (i2 == 4) {
                            jCurrentTimeMillis6 = System.currentTimeMillis();
                            jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(a.hw().pr(hwVar.x())));
                            if (a.hw().hw(hwVar.x())) {
                                if (7 == hwVar.a()) {
                                    z4 = 1;
                                } else {
                                    z4 = i5;
                                }
                                pr(z4, jSONObject2, hwVar.x());
                            } else {
                                com.byazt.xk.hw.pr().pr(hwVar.x(), (String) null, (String) null, true);
                            }
                            if (iVar != null) {
                                iVar.ho.pr("precache_time", System.currentTimeMillis() - jCurrentTimeMillis6);
                            }
                        }
                        if (z) {
                            jSONObject2.put("ad_sdk_version", iu.c);
                            return jSONObject2;
                        }
                        if (i2 == 3) {
                            jSONObject2.put("material_keys", ls.pr(hwVar));
                        }
                        jCurrentTimeMillis3 = System.currentTimeMillis();
                        if (a.hw().tt()) {
                            jSONObject2.put("feature_data", com.byazt.mk.hn.fw().aj());
                            pr(iVar, "featureV1", jCurrentTimeMillis3, z5);
                        }
                        jCurrentTimeMillis4 = System.currentTimeMillis();
                        if (a.hw().dl()) {
                            jSONObjectHn = com.byazt.gf.pr.pr().hn();
                            if (jSONObjectHn != null) {
                                jSONObject2.putOpt("feature_data_v2", jSONObjectHn);
                            }
                            pr(iVar, "featureV2", jCurrentTimeMillis4, z5);
                        }
                        if (iVar == null) {
                            i7 = i5;
                        } else {
                            i7 = i5;
                        }
                        jCurrentTimeMillis5 = System.currentTimeMillis();
                        if (i7 == 0) {
                            jSONObjectPr2 = pr(iVar);
                            if (jSONObjectPr2 != null) {
                                jSONObject2.put("load_feature", jSONObjectPr2);
                            }
                            pr(iVar, "loadFeature", jCurrentTimeMillis5, z5);
                        }
                        if (iVar != null) {
                            jSONObject2.put("second_page_type", iVar.yb);
                            jSONObject2.put("second_page_origin_req_id", iVar.lb);
                        }
                        jSONArrayPr = com.byazt.ba.c.pr();
                        if (jSONArrayPr != null) {
                            jSONObject2.putOpt("csj_sdk_abilities", jSONArrayPr);
                        }
                        long jCurrentTimeMillis21113 = System.currentTimeMillis();
                        com.byazt.wm.pr.pr(jSONObject2);
                        pr(iVar, "dplStatusCounter", jCurrentTimeMillis21113, z5);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    hwVar2 = hwVar;
                    strHw = null;
                    pr(strHw, hwVar2, th);
                    return jSONObject2;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            hwVar2 = hwVar;
            strHw = null;
        }
        return jSONObject2;
    }

    private String pr(com.byazt.qe.hw hwVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_settings_update", com.byazt.wt.zo.hw(System.currentTimeMillis()));
            if (hw(hwVar, i)) {
                jSONObject.put("can_merge_same_rit_request", 1);
            }
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    private boolean hw(com.byazt.qe.hw hwVar, int i) {
        if (i != 5 || hwVar == null || TextUtils.isEmpty(hwVar.x()) || !com.byazt.is.vk.m()) {
            return false;
        }
        try {
            com.byazt.pk.pr.pr();
            return com.byazt.tf.pr.hw(hwVar.x());
        } catch (Exception e) {
            return false;
        }
    }

    private static void pr(i iVar, String str, long j, boolean z) {
        if (iVar != null) {
            iVar.pr(str, System.currentTimeMillis() - j, z);
        }
    }

    private void pr(String str, com.byazt.qe.hw hwVar, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("req_id", str);
            if (hwVar != null) {
                jSONObject.putOpt("slot", hwVar.x());
            }
            com.byazt.xk.hw.pr().pr("b_ad_req", jSONObject, th);
        } catch (Throwable th2) {
        }
    }

    private void pr(JSONObject jSONObject, i iVar) {
        if (iVar == null || iVar.uc == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", iVar.uc);
        } catch (Exception e) {
        }
    }

    private void pr(com.byazt.hg.hw hwVar, long j, long j2, long j3, long j4) {
        if (hwVar == null) {
            return;
        }
        hwVar.pr(j);
        hwVar.hw(j3);
        hwVar.hn(j2);
        hwVar.x(j4);
    }

    @Override // com.byazt.sd.fo
    @JProtect
    public void pr(final com.byazt.qe.hw hwVar, final i iVar, final int i, fo.hw hwVar2) {
        final com.byazt.cv.pr prVar = new com.byazt.cv.pr(hwVar2);
        prVar.pr(i);
        if ((i != 3 || !com.byazt.jm.uc.pr(hwVar)) && Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.xlm.c.x(new com.byazt.xlm.fw("get_ad") { // from class: com.byazt.sd.rc.1
                @Override // java.lang.Runnable
                public void run() {
                    rc.this.x(hwVar, iVar, i, prVar);
                }
            });
        } else {
            x(hwVar, iVar, i, prVar);
        }
    }

    @Override // com.byazt.sd.fo
    public void hw(final com.byazt.qe.hw hwVar, final i iVar, final int i, fo.hw hwVar2) {
        final com.byazt.cv.pr prVar = new com.byazt.cv.pr(hwVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("bid_pre") { // from class: com.byazt.sd.rc.12
                @Override // java.lang.Runnable
                public void run() {
                    rc.this.pr(hwVar, iVar, i, prVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            pr(hwVar, iVar, i, prVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    public com.byazt.wn.hw pr(com.byazt.qe.hw hwVar, com.byazt.hg.hw hwVar2, i iVar, int i, int i2, fo.hw hwVar3, boolean z) {
        com.byazt.wn.hw hwVarHw;
        com.byazt.hs.hn.pr(hwVar);
        boolean z2 = i2 == 5;
        iVar.pr("buildAdBodyReady", z2);
        JSONObject jSONObjectPr = pr(hwVar, iVar, i, false, i2, z);
        iVar.pr("doBuildAdBody", z2);
        if (jSONObjectPr == null) {
            hwVar2.pr(-9);
            hwVar3.pr(-9, fw.pr(-9), hwVar2);
            return null;
        }
        String string = jSONObjectPr.toString();
        if (i2 == 5) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            hwVarHw = com.byazt.mp.uc.pr().pr(string);
            iVar.pr("encrypt", System.currentTimeMillis() - jCurrentTimeMillis, z2);
        } else {
            hwVarHw = com.byazt.mp.uc.pr().hw(string);
        }
        if (hwVarHw == null) {
            hwVar2.pr(-9);
            hwVar3.pr(-9, fw.pr(-9), hwVar2);
            return null;
        }
        hwVarHw.pr(jSONObjectPr);
        return hwVarHw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.qe.hw hwVar, i iVar, int i, fo.hw hwVar2, String str, int i2) {
        hn(hwVar, iVar, i, hwVar2, str, i2);
    }

    public void x(com.byazt.qe.hw hwVar, i iVar, int i, fo.hw hwVar2) {
        if (hwVar != null && hwVar.ve()) {
            if (com.byazt.is.vk.vk()) {
                hw(hwVar, iVar, i, hwVar2, "/api/ad/union/sdk/anti_req/", 5);
                return;
            }
            com.byazt.hg.hw hwVar3 = new com.byazt.hg.hw();
            hwVar3.pr(hwVar);
            hwVar3.pr(-17);
            hwVar2.pr(-17, fw.pr(-17), hwVar3);
            return;
        }
        hn(hwVar, iVar, i, hwVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    private void hw(final com.byazt.qe.hw hwVar, final i iVar, int i, final fo.hw hwVar2, String str, int i2) {
        final com.byazt.hg.hw hwVar3 = new com.byazt.hg.hw();
        hwVar3.pr(hwVar);
        try {
            com.byazt.hcx.aj ajVarPr = pr(hwVar, iVar, i, hwVar2, str, i2, hwVar3, false, true);
            if (ajVarPr == null) {
                hwVar3.pr(-15);
                hwVar2.pr(-15, fw.pr(-15), hwVar3);
            } else {
                ajVarPr.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.19
                    @Override // com.byazt.hcx.fw
                    public void pr(com.byazt.hcx.m mVar) {
                        JSONObject jSONObject;
                        if (mVar != null && (jSONObject = (JSONObject) com.byazt.mp.uc.pr(mVar, "get_ads", true).second) != null) {
                            pr prVarPr = pr.pr(jSONObject, hwVar, iVar);
                            if (prVarPr.x != 20000) {
                                hwVar3.pr(prVarPr.x);
                                hwVar3.hw(prVarPr.uc);
                                StringBuilder sb = new StringBuilder();
                                sb.append("reason: ").append(prVarPr.uc).append("  message: ").append(prVarPr.c);
                                hwVar2.pr(prVarPr.x, sb.toString(), hwVar3);
                            }
                        }
                    }

                    @Override // com.byazt.hcx.fw
                    public void pr(int i3, String str2, Throwable th) {
                        rc.this.pr(th, hwVar3, hwVar2);
                    }
                });
                com.byazt.sd.x.pr().hn();
                pr();
            }
        } catch (Throwable th) {
            hw(th, hwVar3, hwVar2);
        }
    }

    private void hn(final com.byazt.qe.hw hwVar, final i iVar, final int i, final fo.hw hwVar2, String str, final int i2) {
        final com.byazt.hg.hw hwVar3 = new com.byazt.hg.hw();
        hwVar3.pr(hwVar);
        try {
            com.byazt.dt.w wVarPr = pr(hwVar, hwVar3, hwVar2, i2 == 5, iVar, i);
            if (wVarPr.pr()) {
                return;
            }
            final com.byazt.hcx.aj ajVarPr = pr(hwVar, iVar, i, hwVar2, str, i2, hwVar3, wVarPr.hw(), false);
            if (ajVarPr == null) {
                hwVar3.pr(-15);
                hwVar2.pr(-15, fw.pr(-15), hwVar3);
            } else {
                ajVarPr.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.20
                    @Override // com.byazt.hcx.fw
                    public void pr(com.byazt.hcx.m mVar) {
                        rc.this.pr(ajVarPr, mVar, hwVar3, hwVar2, hwVar, iVar, i, i2);
                    }

                    @Override // com.byazt.hcx.fw
                    public void pr(int i3, String str2, Throwable th) {
                        rc.this.pr(th, hwVar3, hwVar2);
                    }
                });
                com.byazt.sd.x.pr().hn();
                pr();
            }
        } catch (Throwable th) {
            hw(th, hwVar3, hwVar2);
        }
    }

    private com.byazt.dt.w pr(com.byazt.qe.hw hwVar, com.byazt.hg.hw hwVar2, fo.hw hwVar3, boolean z, i iVar, int i) {
        com.byazt.dt.w wVar = new com.byazt.dt.w();
        wVar.pr(true);
        if (hwVar3 == null) {
            return wVar;
        }
        if (!com.byazt.is.aj.pr()) {
            hwVar2.pr(1000);
            hwVar3.pr(1000, "广告请求开关已关闭,请联系穿山甲管理员", hwVar2);
            return wVar;
        }
        if (z) {
            iVar.pr("execGetAdReady", z);
            if (!TextUtils.isEmpty(hwVar.cz()) && iVar.c <= 0) {
                pr(hwVar2, hwVar, hwVar3, iVar, i);
                return wVar;
            }
            wVar.pr(com.byazt.dt.vk.pr.pr(hwVar2, hwVar, i, hwVar3, iVar, wVar));
            return wVar;
        }
        wVar.pr(false);
        return wVar;
    }

    private void pr(com.byazt.hg.hw hwVar, com.byazt.qe.hw hwVar2, final fo.hw hwVar3, i iVar, int i) {
        hwVar.hn(2);
        hwVar.pr(hwVar2.cz());
        try {
            boolean z = false;
            JSONObject jSONObjectPr = com.byazt.mp.uc.pr(new JSONObject(hwVar2.cz()), false, true);
            if (jSONObjectPr == null) {
                pr(hwVar3, hwVar);
                return;
            }
            pr prVarPr = pr.pr(jSONObjectPr, hwVar2, iVar);
            hwVar.pr(prVarPr.w);
            hw(prVarPr.aj);
            if (prVarPr.x != 20000) {
                hwVar.pr(prVarPr.x);
                StringBuilder sb = new StringBuilder();
                sb.append("reason: ").append(prVarPr.uc).append("  message: ").append(prVarPr.c);
                hwVar3.pr(prVarPr.x, sb.toString(), hwVar);
                return;
            }
            if (prVarPr.zo == null) {
                pr(hwVar3, hwVar);
                return;
            }
            prVarPr.zo.pr(jSONObjectPr);
            List<of> listHw = prVarPr.zo.hw();
            if (listHw != null) {
                List<of> arrayList = new ArrayList<>(listHw);
                for (of ofVar : listHw) {
                    of ofVarPr = com.byazt.wt.x.pr(ofVar.jw(), i, ofVar.yn());
                    if (ofVarPr != null) {
                        arrayList.remove(ofVar);
                        ofVarPr.ww(ofVar.ug());
                        arrayList.add(ofVarPr);
                    } else if (ofVar.wt()) {
                        final String str = prVarPr.fw;
                        if (!TextUtils.isEmpty(str) && iVar != null) {
                            iVar.pr(str);
                        }
                        final String strX = hwVar2.x();
                        final String strPr = ls.pr(hwVar2);
                        a.pr().hn(hwVar2, iVar, i, new fo.hw() { // from class: com.byazt.sd.rc.21
                            @Override // com.byazt.sd.fo.hw
                            public void pr(int i2, String str2, com.byazt.hg.hw hwVar4) {
                                com.byazt.xk.hw.pr().pr(i2, str2, str, strX, strPr);
                                hwVar3.pr(i2, str2, hwVar4);
                            }

                            @Override // com.byazt.sd.fo.hw
                            public void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar4) {
                                com.byazt.xk.hw.pr().pr(0, TrackAction.SUCCESS, str, strX, strPr);
                                hwVar3.pr(prVar, hwVar4);
                            }
                        });
                        z = true;
                    }
                }
                if (z) {
                    return;
                } else {
                    prVarPr.zo.pr(arrayList);
                }
            }
            hwVar3.pr(prVarPr.zo, hwVar);
        } catch (Throwable th) {
            com.byazt.ca.ho.pr("NetApiImpl", "get ad error: ", th);
            pr(hwVar3, hwVar);
        }
    }

    private com.byazt.hcx.aj pr(com.byazt.qe.hw hwVar, i iVar, int i, fo.hw hwVar2, String str, int i2, com.byazt.hg.hw hwVar3, boolean z, boolean z2) throws JSONException {
        String strPr;
        byte[] bytes;
        Map<String, String> mapPr;
        com.byazt.wn.hw hwVarPr = pr(hwVar, hwVar3, iVar, i, i2, hwVar2, z);
        if (hwVarPr == null) {
            return null;
        }
        com.byazt.hcx.aj ajVarPr = com.byazt.tf.hn.pr();
        if (z2) {
            strPr = ls.w(str);
        } else {
            strPr = ls.pr(str, true);
        }
        String strPr2 = com.byazt.jys.hn.pr(ajVarPr, strPr);
        ajVarPr.pr(strPr2);
        if (hwVarPr.pr() != null) {
            com.byazt.jys.hn.pr(hwVarPr.pr(), 0);
        }
        if (i2 == 5) {
            if (hwVarPr.x() != null) {
                JSONObject jSONObjectX = hwVarPr.x();
                ajVarPr.pr(jSONObjectX);
                bytes = jSONObjectX.toString().getBytes(StandardCharsets.UTF_8);
            } else {
                if (hwVarPr.hn() == null) {
                    return null;
                }
                bytes = hwVarPr.hn();
                ajVarPr.pr(bytes);
            }
        } else {
            JSONObject jSONObjectX2 = hwVarPr.x();
            ajVarPr.pr(jSONObjectX2);
            bytes = jSONObjectX2.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z3 = i2 == 5;
        iVar.pr("doHttpReqSignReady", z3);
        com.byazt.qv.pr prVarPr = com.byazt.qv.pr.pr(true);
        iVar.pr("MSInst", z3);
        Map<String, String> mapPr2 = prVarPr.pr(strPr2, bytes);
        iVar.pr("doHttpReqSign", z3);
        if (mapPr2 == null) {
            mapPr2 = new HashMap<>();
        }
        if (i2 == 5 && (mapPr = com.byazt.hs.hn.pr(hwVar.x())) != null) {
            mapPr2.putAll(mapPr);
        }
        s.pr(mapPr2);
        Map<String, String> mapC = hwVarPr.c();
        ajVarPr.pr("User-Agent", ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
        if (mapC != null) {
            mapPr2.putAll(mapC);
        }
        if (mapPr2.size() > 0) {
            for (Map.Entry<String, String> entry : mapPr2.entrySet()) {
                ajVarPr.pr(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> mapPr3 = pr(bytes, mapC, hwVarPr);
        if (com.byazt.is.vk.m() && z3) {
            pr(mapPr3, hwVar, pr(hwVarPr));
        }
        ajVarPr.pr(mapPr3);
        iVar.pr("appendHeader", z3);
        return ajVarPr;
    }

    private void pr(Map<String, Object> map, com.byazt.qe.hw hwVar, boolean z) {
        if (map == null) {
            return;
        }
        com.byazt.pk.pr.pr();
        map.put("is_get_ads", Boolean.TRUE);
        map.put("get_ads_rit", hwVar == null ? "" : hwVar.x());
        map.put("get_ads_request_ts", Long.valueOf(System.currentTimeMillis()));
        map.put("can_merge_same_rit_request", Boolean.valueOf(z));
    }

    private boolean pr(com.byazt.wn.hw hwVar) {
        if (hwVar == null || hwVar.pr() == null) {
            return false;
        }
        try {
            String strOptString = hwVar.pr().optString("sdk_extra_data");
            return !TextUtils.isEmpty(strOptString) && new JSONObject(strOptString).optInt("can_merge_same_rit_request", 0) == 1;
        } catch (Exception e) {
            return false;
        }
    }

    private Map<String, Object> pr(byte[] bArr, Map<String, String> map, com.byazt.wn.hw hwVar) {
        HashMap map2 = new HashMap();
        try {
            com.byazt.wn.pr prVar = new com.byazt.wn.pr();
            prVar.zo(System.currentTimeMillis());
            prVar.aj(bArr == null ? 0L : bArr.length);
            prVar.hn(hwVar.hw());
            if (map != null) {
                prVar.pr(map.get("x-pglcypher"));
            }
            prVar.pr(hwVar.pr());
            com.byazt.vkw.nt ntVarHn = com.byazt.wt.rc.hn();
            prVar.hw(ntVarHn != null ? ntVarHn.hn() : 0);
            prVar.pr(a.hw().vv());
            map2.put("load_time_model", prVar);
        } catch (Exception e) {
        }
        return map2;
    }

    private void pr() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.x.get() >= 30000) {
            this.x.set(jCurrentTimeMillis);
            com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.sd.rc.22
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.is.zo.pr((com.byazt.is.c) null).x();
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Throwable th, com.byazt.hg.hw hwVar, fo.hw hwVar2) {
        if (th != null) {
            hwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN);
            hwVar2.pr(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, th.getMessage(), hwVar);
            Object[] objArr = {"onFailure: ", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE)};
        }
    }

    private void hw(Throwable th, com.byazt.hg.hw hwVar, fo.hw hwVar2) {
        if (hwVar2 != null) {
            hwVar.pr(TTAdConstant.INIT_LOCAL_FAIL_CODE);
            hwVar2.pr(TTAdConstant.INIT_LOCAL_FAIL_CODE, th.getMessage(), hwVar);
            com.byazt.ca.ho.pr("NetApiImpl", " msg = ", th.getMessage());
        }
    }

    private void pr(com.byazt.hcx.m mVar, com.byazt.qe.hw hwVar, int i, i iVar, fo.hw hwVar2, com.byazt.hg.hw hwVar3, com.byazt.hcx.aj ajVar) {
        int i2;
        JSONObject jSONObject;
        if (mVar != null) {
            if (mVar.fw()) {
                try {
                    com.byazt.wn.pr prVarPr = pr(ajVar);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strZo = mVar.zo();
                    hwVar3.pr(strZo);
                    if (com.byazt.hs.hw.pr != null) {
                        com.byazt.hs.hw.pr.hn("NetApiImpl", "response:");
                        com.byazt.hs.hw.pr.hn("NetApiImpl", strZo);
                    }
                    JSONObject jSONObject2 = new JSONObject(strZo);
                    int iOptInt = jSONObject2.optInt("status_code");
                    String strOptString = new JSONObject(hwVar.cz()).optString("auction_price");
                    int i3 = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
                    if (iOptInt != 20000) {
                        if (iOptInt == 40046) {
                            hwVar3.pr(iOptInt);
                            hwVar2.pr(40046, fw.pr(iOptInt), hwVar3);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("adms");
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObject3 = new JSONObject(jSONObjectOptJSONObject.optString(itKeys.next()));
                        jSONObject3.put("auction_price", strOptString);
                        JSONObject jSONObjectPr = com.byazt.mp.uc.pr(jSONObject3, false, true);
                        if (jSONObjectPr == null) {
                            pr(hwVar2, hwVar3);
                            return;
                        }
                        pr prVarPr2 = pr.pr(jSONObjectPr, hwVar, iVar);
                        hwVar3.pr(prVarPr2.w);
                        if (prVarPr2.x != i3) {
                            hwVar3.pr(prVarPr2.x);
                            StringBuilder sb = new StringBuilder();
                            sb.append("reason: ").append(prVarPr2.uc).append("  message: ").append(prVarPr2.c);
                            hwVar2.pr(prVarPr2.x, sb.toString(), hwVar3);
                            com.byazt.dt.aj.pr().pr(hwVar != null ? hwVar.x() : "", prVarPr2.x, prVarPr2.uc, hwVar.gz());
                            return;
                        }
                        if (prVarPr2.zo == null) {
                            pr(hwVar2, hwVar3);
                            return;
                        }
                        prVarPr2.zo.pr(jSONObjectPr);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (iVar != 0) {
                            jSONObject = jSONObjectOptJSONObject;
                            i2 = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
                            pr(hwVar3, prVarPr.vk() - iVar.zo, prVarPr2.pr, jCurrentTimeMillis - prVarPr.vk(), jCurrentTimeMillis2 - jCurrentTimeMillis);
                        } else {
                            i2 = i3;
                            jSONObject = jSONObjectOptJSONObject;
                        }
                        hwVar2.pr(prVarPr2.zo, hwVar3);
                        com.byazt.qu.hw.pr().pr(jSONObjectPr);
                        strOptString = strOptString;
                        jSONObjectOptJSONObject = jSONObject;
                        i3 = i2;
                    }
                    return;
                } catch (Throwable th) {
                    com.byazt.ca.ho.pr("NetApiImpl", "get ad error: ", th);
                    pr(hwVar2, hwVar3);
                    return;
                }
            }
            int iPr = mVar.pr();
            String strHw = mVar.hw();
            hwVar3.pr(iPr);
            hwVar2.pr(iPr, strHw, hwVar3);
        }
    }

    public void c(final com.byazt.qe.hw hwVar, final i iVar, final int i, fo.hw hwVar2) {
        final com.byazt.cv.pr prVar = new com.byazt.cv.pr(hwVar2);
        com.byazt.xlm.c.hw(new com.byazt.xlm.fw("bid_p_f") { // from class: com.byazt.sd.rc.23
            @Override // java.lang.Runnable
            public void run() {
                rc.this.pr(hwVar, iVar, i, prVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    private void pr(com.byazt.hcx.m mVar, com.byazt.qe.hw hwVar, int i, i iVar, fo.hw hwVar2, com.byazt.hg.hw hwVar3) {
        if (mVar != null) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(mVar.zo()).optJSONArray("ads");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                    int i2 = a.hw().i();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.getJSONObject(i3).optJSONObject(ProviderInteractionViews.ROLE_CREATIVE);
                        if (jSONObjectOptJSONObject != null) {
                            JSONObject jSONObjectPr = com.byazt.mp.uc.pr(new JSONObject(jSONObjectOptJSONObject.optString("adm")), false, true);
                            if (jSONObjectPr == null && hwVar2 != null) {
                                hwVar2.pr(-9, fw.pr(-9), hwVar3);
                            } else {
                                pr prVarPr = pr.pr(jSONObjectPr, hwVar, iVar);
                                com.byazt.wt.x.pr(prVarPr.zo, i, i2, hwVar.gz());
                                if (hwVar2 != null) {
                                    hwVar2.pr(prVarPr.zo, hwVar3);
                                }
                            }
                        } else if (hwVar2 != null) {
                            hwVar2.pr(-9, fw.pr(-9), hwVar3);
                        }
                    }
                    return;
                }
                if (hwVar2 != null) {
                    hwVar2.pr(-9, fw.pr(-9), hwVar3);
                }
            } catch (Exception e) {
                if (hwVar2 != null) {
                    hwVar2.pr(-9, fw.pr(-9), hwVar3);
                }
            }
        }
    }

    @Override // com.byazt.sd.fo
    public void hn(final com.byazt.qe.hw hwVar, final i iVar, final int i, fo.hw hwVar2) {
        final com.byazt.cv.pr prVar = new com.byazt.cv.pr(hwVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("bid_g_m") { // from class: com.byazt.sd.rc.24
                @Override // java.lang.Runnable
                public void run() {
                    rc.this.pr(hwVar, iVar, i, prVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            pr(hwVar, iVar, i, prVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    private com.byazt.wn.pr pr(com.byazt.hcx.aj ajVar) {
        try {
            Map<String, Object> mapX = ajVar.x();
            if (mapX == null) {
                return new com.byazt.wn.pr();
            }
            Object obj = mapX.get("load_time_model");
            if (obj instanceof com.byazt.wn.pr) {
                com.byazt.wn.pr prVar = (com.byazt.wn.pr) obj;
                prVar.hn(true);
                return prVar;
            }
            return new com.byazt.wn.pr();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.hcx.aj ajVar, com.byazt.hcx.m mVar, com.byazt.hg.hw hwVar, fo.hw hwVar2, com.byazt.qe.hw hwVar3, i iVar, int i, int i2) {
        String str;
        final boolean zBooleanValue;
        long length;
        JSONObject jSONObjectPr;
        JSONObject jSONObject;
        com.byazt.wn.pr prVar;
        long length2;
        if (mVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!mVar.fw()) {
            int iPr = mVar.pr();
            String strHw = mVar.hw();
            hwVar.pr(iPr);
            hwVar2.pr(iPr, strHw, hwVar);
            com.byazt.dt.aj.pr().pr(hwVar3 != null ? hwVar3.x() : "", iPr, 0, hwVar3.gz());
            com.byazt.ip.hw.hw();
            return;
        }
        if (i2 == 1) {
            pr(mVar, hwVar3, i, iVar, hwVar2, hwVar);
            return;
        }
        if (i2 == 3) {
            pr(mVar, hwVar3, i, iVar, hwVar2, hwVar, ajVar);
            return;
        }
        com.byazt.wn.pr prVarPr = pr(ajVar);
        prVarPr.uc(jCurrentTimeMillis);
        try {
            final String strZo = mVar.zo();
            if (i2 == 5) {
                byte[] bArrX = mVar.x();
                Pair<Boolean, JSONObject> pairPr = com.byazt.mp.uc.pr(mVar, "get_ads", true);
                final JSONObject jSONObject2 = (JSONObject) pairPr.second;
                zBooleanValue = ((Boolean) pairPr.first).booleanValue();
                if (zBooleanValue) {
                    long length3 = TextUtils.isEmpty(strZo) ? 0L : strZo.getBytes(StandardCharsets.UTF_8).length;
                    hwVar.pr(strZo);
                    length2 = length3;
                } else {
                    length2 = bArrX == null ? 0L : bArrX.length;
                }
                if (com.byazt.hs.hw.pr != null && jSONObject2 != null) {
                    com.byazt.xlm.c.hw(new com.byazt.xlm.fw("logAdapter") { // from class: com.byazt.sd.rc.25
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String string = "";
                                if (zBooleanValue) {
                                    string = strZo;
                                } else {
                                    Pair<Integer, JSONObject> pairPr2 = com.byazt.mp.uc.pr().pr(jSONObject2.toString(), false);
                                    if (pairPr2 != null && pairPr2.second != null) {
                                        string = ((JSONObject) pairPr2.second).toString();
                                    }
                                }
                                if (com.byazt.hs.hw.pr != null && !TextUtils.isEmpty(string)) {
                                    com.byazt.hs.hw.pr.hn("NetApiImpl", "response:");
                                    com.byazt.hs.hw.pr.hn("NetApiImpl", string);
                                }
                            } catch (Exception e) {
                                com.byazt.ca.ho.pr(e.getMessage());
                            }
                        }
                    });
                }
                length = length2;
                jSONObjectPr = jSONObject2;
            } else {
                prVarPr = prVarPr;
                hwVar.pr(strZo);
                if (com.byazt.hs.hw.pr != null) {
                    com.byazt.hs.hw.pr.hn("NetApiImpl", "response:");
                    com.byazt.hs.hw.pr.hn("NetApiImpl", strZo);
                }
                JSONObject jSONObject3 = new JSONObject(strZo);
                zBooleanValue = false;
                length = TextUtils.isEmpty(strZo) ? 0L : strZo.getBytes(StandardCharsets.UTF_8).length;
                jSONObjectPr = com.byazt.mp.uc.pr(jSONObject3, false, true);
            }
            com.byazt.wn.pr prVar2 = prVarPr;
            prVar2.fw(length);
            if (jSONObjectPr == null) {
                pr(hwVar2, hwVar);
                return;
            }
            com.byazt.jys.hn.hw(jSONObjectPr, 0);
            pr prVarPr2 = pr.pr(jSONObjectPr, hwVar3, iVar);
            hwVar.pr(prVarPr2.w);
            boolean zPr = pr(prVarPr2, prVar2);
            hw(prVarPr2.aj);
            if (prVarPr2.x != 20000) {
                hwVar.pr(prVarPr2.x);
                hwVar.hw(prVarPr2.uc);
                StringBuilder sb = new StringBuilder();
                sb.append("reason: ").append(prVarPr2.uc).append("  message: ").append(prVarPr2.c);
                hwVar2.pr(prVarPr2.x, sb.toString(), hwVar);
                com.byazt.dt.aj.pr().pr(hwVar3 != null ? hwVar3.x() : "", prVarPr2.x, prVarPr2.uc, hwVar3.gz());
                return;
            }
            if (prVarPr2.zo == null) {
                pr(hwVar2, hwVar);
                return;
            }
            prVarPr2.zo.pr(jSONObjectPr);
            prVar2.hw(System.currentTimeMillis());
            if (iVar != null) {
                prVar = prVar2;
                jSONObject = jSONObjectPr;
                str = "NetApiImpl";
                try {
                    pr(hwVar, prVar2.vk() - iVar.zo, prVarPr2.pr, prVar2.fw() - prVar2.vk(), prVar2.hn() - prVar2.fw());
                } catch (Throwable th) {
                    th = th;
                    com.byazt.ca.ho.pr(str, "get ad error: ", th);
                    pr(hwVar2, hwVar);
                    return;
                }
            } else {
                jSONObject = jSONObjectPr;
                prVar = prVar2;
                str = "NetApiImpl";
            }
            hwVar2.pr(prVarPr2.zo, hwVar);
            pr(prVar);
            if (i2 == 5) {
                pr++;
            }
            for (of ofVar : prVarPr2.zo.hw()) {
                com.byazt.wn.pr prVar3 = prVar;
                if (iVar != null) {
                    ofVar.gz(iVar.hw());
                    ofVar.xh().pr(iVar.pr);
                    ofVar.xh().hw(1);
                }
                if (com.byazt.ja.pr.pr(ofVar) || com.byazt.ja.pr.x(ofVar)) {
                    com.byazt.ic.hw.pr().pr(this.hw, com.byazt.ja.pr.vk(ofVar));
                }
                prVar = prVar3;
            }
            com.byazt.wn.pr prVar4 = prVar;
            if (prVar4.m() && prVarPr2.zo.hw() != null && !prVarPr2.zo.hw().isEmpty()) {
                of ofVar2 = prVarPr2.zo.hw().get(0);
                com.byazt.sd.x.pr().pr(ofVar2);
                String strHw2 = ls.hw(i);
                prVar4.hw(i2 != 5);
                prVar4.pr(i2 != 5 || zBooleanValue);
                com.byazt.hcx.vk vkVarUc = mVar.uc();
                prVar4.pr(prVarPr2.pr);
                if (vkVarUc != null) {
                    prVar4.c(vkVarUc.zo());
                    prVar4.x(vkVarUc.aj());
                    prVar4.vk(vkVarUc.pr());
                    prVar4.w(vkVarUc.hw());
                    prVar4.k(vkVarUc.hn());
                    prVar4.m(vkVarUc.x());
                    prVar4.g(vkVarUc.c());
                }
                pr(iVar, ofVar2, strHw2, prVar4);
                if (zPr) {
                    pr(ofVar2, i, prVar4);
                }
            }
            com.byazt.qu.hw.pr().pr(jSONObject);
            com.byazt.ip.hw.hw();
        } catch (Throwable th2) {
            th = th2;
            str = "NetApiImpl";
        }
    }

    private void hw(String str) {
        com.byazt.wt.nt.pr(str);
        if (com.byazt.qv.pr.pr() != null) {
            com.byazt.qv.pr.pr().pr(str);
        }
    }

    private boolean pr(pr prVar, com.byazt.wn.pr prVar2) {
        JSONObject jSONObjectHw;
        boolean zPr = false;
        try {
            zPr = com.byazt.lg.pr.pr(zo.nt().ny()).pr("ad_request_result", 0.009999999776482582d);
            JSONObject jSONObjectAj = null;
            if (zPr) {
                String strPr = com.byazt.wt.nt.pr();
                String strHn = com.byazt.wt.nt.hn();
                boolean zPr2 = com.byazt.wt.zo.pr(strPr, prVar.aj);
                boolean zPr3 = com.byazt.wt.zo.pr(strHn, prVar.vk);
                if (!zPr2 && !zPr3) {
                    jSONObjectHw = null;
                } else {
                    jSONObjectHw = com.byazt.wt.zo.hw();
                    jSONObjectAj = com.byazt.wt.zo.zo(prVar2.pr());
                }
                JSONObject jSONObject = new JSONObject();
                com.byazt.wt.zo.pr(jSONObject, new com.byazt.wt.zo.pr(prVar2.pr(), strPr, prVar.aj, strHn, prVar.vk, jSONObjectHw, jSONObjectAj));
                prVar2.hw(jSONObject);
            }
            com.byazt.wt.nt.hn(prVar.vk);
            if (!TextUtils.isEmpty(prVar.aj) || !TextUtils.isEmpty(prVar.vk)) {
                if (jSONObjectAj == null) {
                    jSONObjectAj = com.byazt.wt.zo.aj(prVar2.pr());
                }
                prVar2.hn(jSONObjectAj);
            }
        } catch (Exception e) {
            com.byazt.ca.ho.pr("NetApiImpl", "csj", e);
        }
        return zPr;
    }

    private void pr(com.byazt.wn.pr prVar) {
        JSONObject jSONObjectNy;
        if (prVar == null || (jSONObjectNy = prVar.ny()) == null) {
            return;
        }
        try {
            try {
                com.byazt.wt.zo.fw(jSONObjectNy);
            } catch (Exception e) {
                com.byazt.ca.ho.pr("NetApiImpl", "csj", e);
            }
        } finally {
            prVar.hn((JSONObject) null);
        }
    }

    private void pr(of ofVar, int i, com.byazt.wn.pr prVar) {
        if (prVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("last_settings_update", com.byazt.wt.zo.hw(System.currentTimeMillis()));
            JSONObject jSONObjectCz = prVar.cz();
            if (jSONObjectCz != null && jSONObjectCz.length() > 0) {
                Iterator<String> itKeys = jSONObjectCz.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, jSONObjectCz.opt(next));
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (ofVar != null) {
                jSONObject2.putOpt("rit", ls.pr(ofVar, ""));
                jSONObject2.putOpt("cid", ofVar.x());
                jSONObject2.putOpt("req_id", ofVar.ny());
            }
            jSONObject2.put("adtype", i);
            com.byazt.xk.hw.pr().pr("ad_request_result", jSONObject2, jSONObject);
        } catch (Throwable th) {
        }
    }

    private void pr(i iVar, of ofVar, String str, com.byazt.wn.pr prVar) {
        long jHn;
        long j;
        if (!a.hw().na() || prVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (iVar == null) {
            j = 0;
        } else {
            try {
                if (iVar.zo <= 0) {
                    jHn = 0;
                } else {
                    jSONObject.put("client_start_time", prVar.vk() - iVar.zo);
                    jHn = prVar.hn() - iVar.zo;
                }
                if (iVar.aj > 0) {
                    jSONObject.put("real_user_duration", prVar.hn() - iVar.aj);
                    jSONObject.put("switch_st1_time", iVar.zo - iVar.aj);
                }
                j = jHn;
            } catch (Exception e) {
                return;
            }
        }
        jSONObject.put("net_send_time", prVar.uc() - prVar.vk());
        jSONObject.put("net_rcv_time", prVar.c() - prVar.uc());
        jSONObject.put("net_callback_time", prVar.fw() - prVar.c());
        jSONObject.put("network_time", prVar.fw() - prVar.vk());
        jSONObject.put("sever_time", prVar.hw());
        jSONObject.put("client_end_time", prVar.hn() - prVar.fw());
        if (prVar.w() > 0) {
            jSONObject.put("req_body_length", prVar.w());
        }
        if (prVar.aj() > 0) {
            jSONObject.put("res_body_length", prVar.aj());
        }
        if (!TextUtils.isEmpty(prVar.k())) {
            jSONObject.put("x-pglcypher", prVar.k());
        }
        jSONObject.put("cypher_v", prVar.qa());
        jSONObject.put("armor_s", prVar.a());
        long jX = prVar.x();
        if (jX > 0) {
            jSONObject.put("raw_req_length", jX);
        }
        int i = 1;
        jSONObject.put("sdk_parallel_load", 1);
        jSONObject.put("net_module", com.byazt.mp.hn.pr().uc());
        if (!prVar.zo()) {
            i = 2;
        }
        jSONObject.put("has_base64", i);
        jSONObject.put("req_build_opt", com.byazt.mp.hn.pr().fw());
        jSONObject.put("is_boost", com.byazt.iq.pr.c());
        jSONObject.put("opt_config", String.valueOf(a.hw().ug()));
        jSONObject.put("report_index", hn.getAndIncrement());
        if (prVar.yb() > 0) {
            jSONObject.put("net_whqueue", prVar.ho() - prVar.g());
            jSONObject.put("net_wtqueue", prVar.nt() - prVar.ho());
            jSONObject.put("net_oconn", prVar.lb() - prVar.yb());
            jSONObject.put("net_bconn", prVar.yb() - prVar.nt());
        }
        try {
            JSONObject jSONObjectPr = iVar.ho.pr(-1L);
            Iterator<String> itKeys = jSONObjectPr.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    jSONObject.put(next, jSONObjectPr.opt(next));
                }
            }
        } catch (Exception e2) {
        }
        com.byazt.pj.pr.pr(ofVar, str, "load_ad_time", j, jSONObject);
    }

    @Override // com.byazt.sd.fo
    public void pr(com.byazt.dw.hw hwVar, List<com.byazt.mr.uc> list) {
        JSONObject jSONObjectHw;
        if (!com.byazt.is.aj.pr() || (jSONObjectHw = hw(hwVar, list)) == null) {
            return;
        }
        qi qiVar = new qi();
        qiVar.pr(ls.aj("/api/ad/union/dislike_event/"));
        qiVar.hn(jSONObjectHw, com.byazt.pfl.hw.AD_TAG_DISLIKE);
        qiVar.pr((com.byazt.hcx.fw) null);
    }

    @JProtect
    private JSONObject hw(com.byazt.dw.hw hwVar, List<com.byazt.mr.uc> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", com.byazt.pfl.hw.AD_TAG_DISLIKE);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", iu.c);
            com.byazt.igw.hw.pr(jSONObject2);
            if (hwVar != null) {
                jSONObject2.put("extra", hwVar.c());
                if (hwVar.hn() == null) {
                    hwVar.pr("other");
                }
                jSONObject2.put("dislike_source", hwVar.hn());
            }
            String strPr = pr(list);
            if (strPr == null) {
                jSONObject2.put("comment", (Object) null);
            } else {
                jSONObject2.put("comment", strPr);
                list.clear();
            }
            jSONObject2.put("filter_words", hw(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private String pr(List<com.byazt.mr.uc> list) {
        if (!list.get(0).pr().equals("0:00")) {
            return null;
        }
        return list.get(0).hw();
    }

    private JSONArray hw(List<com.byazt.mr.uc> list) {
        if (list == null || list.isEmpty()) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<com.byazt.mr.uc> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().pr());
        }
        return jSONArray;
    }

    public static void pr(fo.hw hwVar, com.byazt.hg.hw hwVar2) {
        hwVar2.pr(-1);
        hwVar.pr(-1, fw.pr(-1), hwVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(fo.c cVar) {
        cVar.pr(-1, fw.pr(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(fo.x xVar) {
        xVar.pr(-1, fw.pr(-1));
    }

    @JProtect
    private JSONObject hn(com.byazt.qe.hw hwVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            pr(jSONObject, "keywords", zo.nt().z());
            jSONObject.put("protection_of_minors", zo.nt().qn());
            if (!com.byazt.mp.x.pr().fw(i)) {
                com.byazt.igw.hw.pr(this.hw, jSONObject);
            }
            String strHw = hw(hwVar);
            if (!TextUtils.equals("[]", strHw)) {
                pr(jSONObject, "data", strHw);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private static JSONArray pr(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        if (str == null) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject();
                jSONObject.put(Common.System.NAME, "can_use_sensor");
                jSONObject.put(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD, str);
            } catch (Exception e) {
                return jSONArray;
            }
        }
        if (jSONObject != null) {
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONArray.put(jSONArray.length(), jSONObject);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject);
            return jSONArray2;
        }
        return jSONArray;
    }

    private static String hw(com.byazt.qe.hw hwVar) {
        String strHn = hn(hwVar);
        Map<String, Object> mapVe = zo.nt().ve();
        if (mapVe == null || mapVe.isEmpty()) {
            return strHn;
        }
        try {
            JSONArray jSONArray = TextUtils.isEmpty(strHn) ? new JSONArray() : new JSONArray(strHn);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(Common.System.NAME) : "";
                if (!TextUtils.isEmpty(strOptString) && mapVe.containsKey(strOptString)) {
                    mapVe.remove(strOptString);
                }
            }
            for (Map.Entry<String, Object> entry : mapVe.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Common.System.NAME, entry.getKey());
                    jSONObject.put(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD, entry.getValue());
                    jSONArray.put(jSONObject);
                }
            }
            return pr(jSONArray).toString();
        } catch (Exception e) {
            return strHn;
        }
    }

    private static String hn(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("m_temp_info")) {
            return str;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(length);
                if (TextUtils.equals("m_temp_info", jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(Common.System.NAME) : "")) {
                    jSONArray.remove(length);
                }
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            com.byazt.ca.ho.hw("NetApiImpl", "removeMediationTempInfo error:" + e.toString());
            return str;
        }
    }

    private static JSONArray hw(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.equals("0", str)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                jSONObject.put(Common.System.NAME, "is_shake_ads");
                jSONObject.put(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD, "0");
                zo.nt().hw("0");
            }
            if (jSONObject != null) {
                if (jSONArray != null && jSONArray.length() > 0) {
                    jSONArray.put(jSONArray.length(), jSONObject);
                    return jSONArray;
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(0, jSONObject);
                return jSONArray2;
            }
            return jSONArray;
        } catch (Exception e) {
            return jSONArray;
        }
    }

    private static String pr(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            JSONArray jSONArrayHw = hw(pr((JSONArray) null, str2), str2);
            if (jSONArrayHw == null) {
                return null;
            }
            return jSONArrayHw.toString();
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals(jSONObjectOptJSONObject.optString(Common.System.NAME), "is_shake_ads")) {
                    if (TextUtils.equals("0", str2)) {
                        jSONObjectOptJSONObject.put(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD, "0");
                        zo.nt().hw("0");
                    } else {
                        zo.nt().hw(jSONObjectOptJSONObject.optString(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD));
                    }
                    z = true;
                }
            }
            if (!z) {
                jSONArray = hw(jSONArray, str2);
            }
            JSONArray jSONArrayPr = pr(jSONArray, str2);
            return jSONArrayPr == null ? str : jSONArrayPr.toString();
        } catch (Exception e) {
            return str;
        }
    }

    private static String hn(com.byazt.qe.hw hwVar) {
        String strHn;
        String strIu = zo.nt().iu();
        String strC = zo.nt().c();
        zo.nt().hw((String) null);
        if (hwVar == null) {
            strHn = null;
        } else {
            strHn = hn(hwVar.ny());
        }
        if (TextUtils.isEmpty(strIu)) {
            return pr(strHn, strC);
        }
        try {
            if (!TextUtils.isEmpty(strIu) && strIu.contains("game_adapter_did")) {
                strIu = pr(new JSONArray(strIu)).toString();
            }
        } catch (JSONException e) {
        }
        if (TextUtils.isEmpty(strHn)) {
            return pr(strIu, strC);
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(strHn);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString(Common.System.NAME, null);
                    if (TextUtils.equals("is_shake_ads", strOptString)) {
                        if (TextUtils.equals(strC, "0")) {
                            jSONObject.put(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD, "0");
                            zo.nt().hw("0");
                        } else {
                            zo.nt().hw(jSONObject.optString(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD));
                        }
                        z = true;
                    }
                    hashSet.add(strOptString);
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strIu);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String strOptString2 = jSONObject2.optString(Common.System.NAME, null);
                        if (!hashSet.contains(strOptString2)) {
                            if (TextUtils.equals("is_shake_ads", strOptString2)) {
                                if (TextUtils.equals(strC, "0")) {
                                    jSONObject2.put(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD, "0");
                                    zo.nt().hw("0");
                                } else {
                                    zo.nt().hw(jSONObject2.optString(com.tapsdk.tapad.group.constants.Constants.VALUE_FIELD));
                                }
                                z = true;
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (!z) {
                    jSONArray = hw(jSONArray, strC);
                }
                return pr(pr(jSONArray), strC).toString();
            } catch (Throwable th) {
                return pr(strHn, strC);
            }
        } catch (Throwable th2) {
            return pr(strIu, strC);
        }
    }

    private static JSONArray pr(JSONArray jSONArray) throws JSONException {
        if (!iu.fw() || jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        JSONObject jSONObject = null;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 != null) {
                String strOptString = jSONObject2.optString(Common.System.NAME, null);
                if (!"device_id".equals(strOptString)) {
                    if ("game_adapter_did".equals(strOptString)) {
                        jSONObject = jSONObject2;
                    } else {
                        jSONArray2.put(jSONObject2);
                    }
                }
            }
        }
        if (jSONObject != null) {
            jSONObject.put(Common.System.NAME, "device_id");
            jSONArray2.put(jSONObject);
            return jSONArray2;
        }
        return jSONArray;
    }

    private void pr(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    private JSONObject pr(com.byazt.qe.hw hwVar, int i, i iVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", hwVar.x());
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, hwVar.qa());
            jSONObject.put("show_seq", hwVar.lb());
            jSONObject.put("adtype", i);
            jSONObject.put("themeStatus", zo.nt().nw());
            jSONObject.put("download_type", 0);
            jSONObject.put("show_time", com.byazt.mk.hn.fw().pr(hwVar.x()));
            JSONObject jSONObjectPr = com.byazt.ra.hn.pr(i, hwVar.gz());
            if (jSONObjectPr != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObjectPr.toString());
                    com.byazt.hg.zo.hn hnVarPr = com.byazt.hg.zo.pr(i);
                    com.byazt.hg.zo.c cVarYb = hnVarPr != null ? hnVarPr.yb() : null;
                    if (cVarYb != null && cVarYb.hw() && cVarYb.hn() > 0) {
                        long jPr = com.byazt.cf.hw.pr().pr(i, hwVar.x());
                        if (jPr > 0) {
                            jSONObject2.put("dynamic_tmax", jPr);
                        }
                        jSONObject2.put("dynamic_tmax_type", cVarYb.c());
                    }
                    jSONObjectPr = jSONObject2;
                } catch (Throwable th) {
                }
                jSONObject.put("ca_interval_info", jSONObjectPr);
            }
            Object objHw = com.byazt.ra.hn.hw(i, hwVar.x());
            if (objHw != null) {
                jSONObject.put("client_cache_info", objHw);
            }
            if (!TextUtils.isEmpty(hwVar.pr()) || !TextUtils.isEmpty(hwVar.hw()) || !TextUtils.isEmpty(hwVar.hn()) || com.byazt.hs.hn.pr()) {
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(hwVar.pr())) {
                    jSONObject3.put(MediationConstant.EXTRA_ADID, hwVar.pr());
                }
                if (!TextUtils.isEmpty(hwVar.hw())) {
                    jSONObject3.put("creative_id", hwVar.hw());
                }
                if (hwVar.hn() != null) {
                    jSONObject3.put("ext", hwVar.hn());
                }
                com.byazt.hs.hn.pr(jSONObject3, hwVar.x());
                jSONObject.put("preview_ads", jSONObject3);
            }
            if (com.byazt.hs.hn.pr() && zo.nt().od()) {
                com.byazt.hs.hn.hw(jSONObject, hwVar.x());
            }
            zo.hn hnVarJw = zo.nt().jw();
            if (hnVarJw != null && ls.zo().equals("com.pangolin_demo.toutiao")) {
                hnVarJw.pr(jSONObject);
            }
            int iK = 1;
            if (i == 3 || i == 4) {
                if (iVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("publisher_timeout_control", iVar.vk);
                    jSONObject4.put("time_out_control", iVar.w);
                    jSONObject4.put("time_out", iVar.k);
                    jSONObject.put("tmax", jSONObject4);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (iVar != null) {
                jSONObject.put("render_method", iVar.fw);
                if (iVar.fw != 1) {
                    if (iVar.fw == 2) {
                        if (hwVar.zo() <= 0.0f || hwVar.aj() <= 0.0f) {
                            if (x(hwVar)) {
                                pr(i, jSONObject);
                            } else {
                                pr(jSONObject, "accepted_size", hwVar.uc(), hwVar.fw());
                            }
                        } else {
                            pr(jSONObject, "accepted_size", er.hn(this.hw, hwVar.zo()), er.hn(this.hw, hwVar.aj()));
                        }
                    }
                } else if (x(hwVar)) {
                    pr(i, jSONObject);
                } else {
                    pr(jSONObject, "accepted_size", hwVar.uc(), hwVar.fw());
                }
            } else {
                jSONObject.put("render_method", 1);
                pr(jSONObject, "accepted_size", hwVar.uc(), hwVar.fw());
            }
            jSONObject.put("ptpl_ids", com.byazt.mp.hw.pr().pr(hwVar.x(), i));
            jSONObject.put("ptpl_ids_v3", com.byazt.mp.hw.pr().hw(hwVar.x(), i));
            if (i == 5 || i == 9) {
                String string = com.byazt.qn.x.pr(zo.nt().ny(), "ad_show_real_size").getString(hwVar.x(), null);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("real_size", new JSONObject(string));
                }
            }
            jSONObject.put("pos", ls.c(i));
            jSONObject.put("is_support_dpl", hwVar.vk());
            jSONObject.put("if_support_render_control", hwVar.w() ? 1 : 0);
            jSONObject.put("support_icon_style", (iu.x < 5900 || !hwVar.b()) ? 0 : 1);
            if (i == 3 || i == 4) {
                jSONObject.put("splash_load_type", a.hw().zo(ls.hw(hwVar)));
            }
            if (i == 1 || i == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (iVar != null && iVar.m != null) {
                jSONObject.put("session_params", iVar.m);
            }
            int iK2 = hwVar.k();
            if (i == 7) {
                if (com.byazt.hg.ww.pr()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.byazt.hg.ww.c());
                }
                if (com.byazt.hg.ww.hn()) {
                    jSONObject.put("refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.byazt.hg.ww.fw());
                }
                if (com.byazt.hg.ww.x()) {
                    jSONObject.put("force_refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.byazt.hg.ww.fw());
                }
                iK2 = 1;
            }
            if (i != 8) {
                iK = iK2;
            } else {
                boolean zHo = a.hw().ho(hwVar.x());
                boolean zPr = com.byazt.dt.fw.pr(hwVar.x());
                if (zHo) {
                    if (zPr) {
                        jSONObject.put("refresh_control", 0);
                        com.byazt.xk.hw.pr().pr("refresh_max", new com.byazt.ttf.pr() { // from class: com.byazt.sd.rc.2
                            @Override // com.byazt.ttf.pr
                            public JSONObject pr(JSONObject jSONObject5) throws JSONException {
                                JSONObject jSONObject6 = new JSONObject();
                                try {
                                    jSONObject6.put("cid", "");
                                } catch (JSONException e) {
                                }
                                return jSONObject6;
                            }
                        });
                    } else {
                        jSONObject.put("refresh_control", 1);
                        jSONObject.put("refresh_ad_req_num", a.hw().cb());
                    }
                } else {
                    jSONObject.put("refresh_control", 0);
                }
                if (com.byazt.hg.ww.hw()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.byazt.hg.ww.uc());
                }
            }
            if (iVar != null && iVar.uc != null) {
                iK = hwVar.k();
            }
            jSONObject.put("ad_count", iK);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private void pr(int i, JSONObject jSONObject) {
        if (hw(i)) {
            pr(jSONObject, "accepted_size", er.c(this.hw), er.uc(this.hw));
        } else {
            pr(jSONObject, "accepted_size", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private boolean hw(int i) {
        if (i == 3 || i == 4) {
            return true;
        }
        return false;
    }

    private boolean x(com.byazt.qe.hw hwVar) {
        if (hwVar == null || hwVar.fw() != 320 || hwVar.uc() != 640) {
            return false;
        }
        return true;
    }

    private void pr(JSONObject jSONObject, String str, int i, int i2) {
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
        } catch (Exception e) {
        }
    }

    private void pr(JSONObject jSONObject, String str, float f, float f2) {
        if (f > 0.0f && f2 >= 0.0f) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject2.put("width", (int) f);
                jSONObject2.put("height", (int) f2);
                jSONArray.put(jSONObject2);
                jSONObject.put(str, jSONArray);
            } catch (Exception e) {
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION})
    public static class pr {
        public final String aj;
        public final String c;
        public final String fw;
        public final long hn;
        public final long hw;
        public final int pr;
        public final int uc;
        public final String vk;
        public final ArrayList<Integer> w;
        public final int x;
        public final com.byazt.hg.pr zo;

        private pr(String str, String str2, int i, int i2, String str3, int i3, String str4, com.byazt.hg.pr prVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.pr = i;
            this.x = i2;
            this.c = str3;
            this.fw = str4;
            this.zo = prVar;
            this.aj = str;
            this.vk = str2;
            this.uc = i3;
            this.hw = j;
            this.hn = j2;
            this.w = arrayList;
        }

        public static pr pr(JSONObject jSONObject) {
            return pr(jSONObject, null, null);
        }

        public static pr pr(JSONObject jSONObject, com.byazt.qe.hw hwVar, i iVar) {
            String strOptString = jSONObject.optString("did");
            String strX = com.byazt.wt.zo.x(jSONObject);
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString("desc");
            String strOptString3 = jSONObject.optString(Constants.Bidding.REQUEST_ID);
            int iOptInt3 = jSONObject.optInt(MediationConstant.KEY_REASON);
            Pair<com.byazt.hg.pr, ArrayList<Integer>> pairPr = com.byazt.sd.pr.pr(jSONObject, hwVar, iVar, jOptLong2);
            if (pairPr != null && pairPr.first != null) {
                ((com.byazt.hg.pr) pairPr.first).pr(jSONObject.optLong("request_after"));
            }
            if (pairPr == null) {
                return new pr(strOptString, strX, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
            }
            return new pr(strOptString, strX, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.byazt.hg.pr) pairPr.first, jOptLong, jOptLong2, (ArrayList) pairPr.second);
        }
    }

    @Override // com.byazt.sd.fo
    public void pr(JSONObject jSONObject, final fo.c cVar) {
        if (!com.byazt.is.aj.pr()) {
            if (cVar != null) {
                cVar.pr(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || cVar == null) {
                return;
            }
            qi qiVar = new qi();
            qiVar.pr(ls.aj("/api/ad/union/sdk/reward_video/reward/"));
            qiVar.hn(jSONObject, "verify");
            qiVar.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.3
                @Override // com.byazt.hcx.fw
                public void pr(com.byazt.hcx.m mVar) {
                    if (mVar != null) {
                        if (mVar.fw()) {
                            try {
                                Pair<Boolean, JSONObject> pairPr = com.byazt.mp.uc.pr(mVar, "verify", false);
                                x xVarPr = x.pr(pairPr.second != null ? (JSONObject) pairPr.second : mVar.c());
                                if (xVarPr.pr != 20000) {
                                    cVar.pr(xVarPr.pr, fw.pr(xVarPr.pr));
                                    return;
                                } else if (xVarPr.hn == null) {
                                    rc.this.pr(cVar);
                                    return;
                                } else {
                                    cVar.pr(xVarPr);
                                    return;
                                }
                            } catch (Exception e) {
                            }
                        } else {
                            String strPr = fw.pr(-2);
                            int iPr = mVar.pr();
                            if (!mVar.fw() && !TextUtils.isEmpty(mVar.hw())) {
                                strPr = mVar.hw();
                            }
                            cVar.pr(iPr, strPr);
                            return;
                        }
                    }
                    rc.this.pr(cVar);
                }

                @Override // com.byazt.hcx.fw
                public void pr(int i, String str, Throwable th) {
                    cVar.pr(-2, th.getMessage());
                }
            });
        }
    }

    @Override // com.byazt.sd.fo
    public void pr(JSONObject jSONObject, final fo.x xVar) {
        if (!com.byazt.is.aj.pr()) {
            if (xVar != null) {
                xVar.pr(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || xVar == null) {
                return;
            }
            com.byazt.tf.hn.x(ls.aj("/api/ad/union/sdk/reward_video/live_room/reward")).hw(com.byazt.wt.rc.pr(jSONObject == null ? null : jSONObject.toString()).toString()).pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.4
                @Override // com.byazt.hcx.fw
                public void pr(com.byazt.hcx.m mVar) {
                    if (mVar == null) {
                        rc.this.pr(xVar);
                        return;
                    }
                    if (mVar.fw()) {
                        JSONObject jSONObjectC = mVar.c();
                        if (jSONObjectC == null) {
                            rc.this.pr(xVar);
                            return;
                        }
                        int iOptInt = jSONObjectC.optInt("cypher", -1);
                        String strOptString = jSONObjectC.optString("message");
                        String strX = null;
                        if (iOptInt == 3) {
                            strX = ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).x(strOptString);
                        }
                        if (!TextUtils.isEmpty(strX)) {
                            try {
                                jSONObjectC = new JSONObject(strX);
                            } catch (Throwable th) {
                            }
                        }
                        hn hnVarPr = hn.pr(jSONObjectC);
                        if (hnVarPr.pr != 20000) {
                            xVar.pr(hnVarPr.pr, fw.pr(hnVarPr.pr));
                            return;
                        } else if (hnVarPr.hn == null) {
                            rc.this.pr(xVar);
                            return;
                        } else {
                            xVar.pr(hnVarPr);
                            return;
                        }
                    }
                    String strPr = fw.pr(-2);
                    int iPr = mVar.pr();
                    if (!mVar.fw() && !TextUtils.isEmpty(mVar.hw())) {
                        strPr = mVar.hw();
                    }
                    xVar.pr(iPr, strPr);
                }

                @Override // com.byazt.hcx.fw
                public void pr(int i, String str, Throwable th) {
                    xVar.pr(-2, th.getMessage());
                }
            });
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 2271})
    public static class x {
        public final ey hn;
        public final boolean hw;
        public final int pr;

        private x(int i, boolean z, ey eyVar) {
            this.pr = i;
            this.hw = z;
            this.hn = eyVar;
        }

        public static x pr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            ey eyVar = new ey();
            if (jSONObjectOptJSONObject != null) {
                try {
                    eyVar.pr(jSONObjectOptJSONObject.optInt(MediationConstant.KEY_REASON));
                    eyVar.hw(jSONObjectOptJSONObject.optInt("corp_type"));
                    eyVar.hn(jSONObjectOptJSONObject.optInt("reward_amount"));
                    eyVar.pr(jSONObjectOptJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                }
            }
            return new x(iOptInt, zOptBoolean, eyVar);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 1867})
    public static class hn {
        public final bm hn;
        public final String hw;
        public final int pr;

        private hn(int i, String str, bm bmVar) {
            this.pr = i;
            this.hw = str;
            this.hn = bmVar;
        }

        public static hn pr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
            String strOptString = jSONObject.optString("message");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            bm bmVar = new bm();
            if (jSONObjectOptJSONObject != null) {
                try {
                    bmVar.pr(jSONObjectOptJSONObject.optBoolean("is_open"));
                    bmVar.pr(jSONObjectOptJSONObject.optString("req_id"));
                } catch (Throwable th) {
                }
            }
            return new hn(iOptInt, strOptString, bmVar);
        }
    }

    @Override // com.byazt.sd.fo
    public String pr(com.byazt.qe.hw hwVar, boolean z, int i) {
        int iA;
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        i iVar = new i();
        String strHw = iVar.hw();
        pr(hwVar, strHw);
        ny nyVar = iVar.ho;
        if (3 == hwVar.a()) {
            iVar.zo = System.currentTimeMillis();
            iVar.fw = 2;
        }
        if (z) {
            iVar.fw = 2;
        }
        if (1 == hwVar.nt() || 2 == hwVar.nt()) {
            iVar.fw = 2;
        }
        if (iVar.fw != 2 && a.hw().aj(hwVar.x())) {
            iVar.fw = 2;
        }
        if (hwVar.a() > 0) {
            iA = hwVar.a();
        } else if (i <= 0) {
            iA = 0;
        } else {
            iA = i;
        }
        JSONObject jSONObjectPr = pr(hwVar, iVar, iA, true, 4, false, strHw);
        nyVar.hw("adbody_time");
        pr(hwVar, iVar, iA);
        nyVar.hw("prefetch_time");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("User-Agent", ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
            nyVar.hw("request_headers_time");
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("bid_request", jSONObjectPr);
        } catch (Exception e) {
        }
        Pair<Integer, JSONObject> pairPr = com.byazt.mp.uc.pr().pr(jSONObject.toString(), true);
        nyVar.hw("encry_time");
        try {
            com.byazt.xk.hw.pr().pr(i, nyVar);
        } catch (Throwable th) {
        }
        String strOptString = "";
        if (pairPr != null) {
            strOptString = pairPr.second != null ? ((JSONObject) pairPr.second).optString("message") : "";
            iIntValue = pairPr.first != null ? ((Integer) pairPr.first).intValue() : 3;
        } else {
            iIntValue = 3;
        }
        if (iIntValue != 3) {
            return "0000000004" + strOptString;
        }
        return "0000000003" + strOptString;
    }

    private void pr(final com.byazt.qe.hw hwVar, String str) {
        String string = UUID.randomUUID().toString();
        com.byazt.dc.hw hwVar2 = (com.byazt.dc.hw) com.byazt.ewt.c.pr(0);
        hwVar2.hw(string, hwVar.gz());
        hwVar2.pr(string, new com.byazt.tb.hn());
        hwVar2.pr(str, string);
        hwVar2.pr(string, new com.byazt.ewt.x.pr() { // from class: com.byazt.sd.rc.5
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar3) {
                com.byazt.qe.hw hwVar4;
                if ((hwVar3 instanceof com.byazt.pv.hw) && (hwVar4 = hwVar) != null) {
                    com.byazt.pv.hw hwVar5 = (com.byazt.pv.hw) hwVar3;
                    hwVar5.pr = hwVar4;
                    hwVar5.g = hwVar.x();
                    hwVar5.k = hwVar.a();
                    hwVar5.m = 1;
                }
            }
        });
        hwVar2.pr(string, com.byazt.tq.hw.STARTED);
    }

    private boolean pr(com.byazt.qe.hw hwVar, i iVar, int i) {
        boolean zPr = a.hw().pr(hwVar.x());
        if (zPr) {
            c(hwVar, iVar, i, new fo.hw() { // from class: com.byazt.sd.rc.6
                @Override // com.byazt.sd.fo.hw
                public void pr(int i2, String str, com.byazt.hg.hw hwVar2) {
                    com.byazt.xk.hw.pr().pr(i2);
                }

                @Override // com.byazt.sd.fo.hw
                public void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar2) {
                    com.byazt.xk.hw.pr().pr(0);
                }
            });
        }
        return zPr;
    }

    private void pr(boolean z, JSONObject jSONObject, String str) throws Exception {
        String strPr = com.byazt.bv.pr.pr().pr(z, str);
        String str2 = "1";
        String strOptString = "0";
        if (strPr != null && !TextUtils.isEmpty(strPr)) {
            if (TextUtils.equals(strPr, "0")) {
                str2 = "0";
            } else if (!TextUtils.equals(strPr, "1")) {
                JSONObject jSONObject2 = new JSONObject(strPr);
                jSONObject.putOpt("cache_info", jSONObject2);
                strOptString = jSONObject2.optString("req_id");
                str2 = null;
            }
        } else {
            str2 = null;
        }
        com.byazt.xk.hw.pr().pr(str, strOptString, str2, false);
    }

    @Override // com.byazt.sd.fo
    public String pr(com.byazt.qe.hw hwVar) {
        return pr(hwVar, false, -1);
    }

    @Override // com.byazt.sd.fo
    public void pr(String str, String str2, final fo.pr prVar) {
        if (!com.byazt.is.aj.pr()) {
            if (prVar != null) {
                prVar.pr(false, -1L, 0L);
            }
        } else {
            if (str == null || str2 == null || prVar == null) {
                return;
            }
            JSONObject jSONObjectPr = com.byazt.xe.x.pr(str, str2);
            qi qiVar = new qi();
            String strAj = ls.aj("/api/ad/union/sdk/material/check/");
            try {
                if (TextUtils.isEmpty(new URL(strAj).getQuery())) {
                    strAj = strAj + "?abort_aes=1";
                } else {
                    strAj = strAj + "&abort_aes=1";
                }
            } catch (Exception e) {
            }
            qiVar.pr(strAj);
            qiVar.hn(jSONObjectPr, "check_ad");
            qiVar.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.7
                @Override // com.byazt.hcx.fw
                public void pr(com.byazt.hcx.m mVar) {
                    long jPr;
                    boolean z;
                    long j;
                    if (mVar != null) {
                        if (mVar.fw()) {
                            JSONObject jSONObjectC = mVar.c();
                            if (jSONObjectC == null) {
                                z = false;
                                j = -1;
                            } else {
                                hw hwVarPr = hw.pr(jSONObjectC);
                                long j2 = hwVarPr.pr;
                                z = hwVarPr.hw;
                                j = j2;
                            }
                            prVar.pr(z, j, mVar.aj());
                            return;
                        }
                        if (mVar.pr() == 0) {
                            jPr = -1;
                        } else {
                            jPr = mVar.pr();
                        }
                        prVar.pr(false, jPr, mVar.aj());
                    }
                }

                @Override // com.byazt.hcx.fw
                public void pr(int i, String str3, Throwable th) {
                    prVar.pr(false, 0L, 0L);
                }
            });
        }
    }

    @Override // com.byazt.sd.fo
    public void pr(JSONObject jSONObject, final com.byazt.xe.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        qi qiVar = new qi();
        String strAj = ls.aj("/api/ad/union/sdk/material/cali/");
        try {
            if (TextUtils.isEmpty(new URL(strAj).getQuery())) {
                strAj = strAj + "?abort_aes=1";
            } else {
                strAj = strAj + "&abort_aes=1";
            }
        } catch (Exception e) {
        }
        qiVar.pr(strAj);
        qiVar.hn(jSONObject, "checkAndCorrectAd");
        qiVar.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.8
            @Override // com.byazt.hcx.fw
            public void pr(com.byazt.hcx.m mVar) {
                com.byazt.xe.c cVar;
                long j;
                long jPr;
                if (mVar != null) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (mVar.fw()) {
                        try {
                            Pair<Boolean, JSONObject> pairPr = com.byazt.mp.uc.pr(mVar, "checkAndCorrectAd", false);
                            com.byazt.xe.c cVarPr = null;
                            JSONObject jSONObject2 = pairPr.second != null ? (JSONObject) pairPr.second : null;
                            if (jSONObject2 == null) {
                                cVar = null;
                                j = -1;
                            } else {
                                try {
                                    cVarPr = com.byazt.xe.c.pr(jSONObject2);
                                    j = cVarPr != null ? cVarPr.pr : -1L;
                                    cVar = cVarPr;
                                } catch (Exception e2) {
                                    cVar = cVarPr;
                                    j = -1;
                                }
                            }
                            hwVar.pr(cVar, j, jCurrentTimeMillis2);
                            return;
                        } catch (Exception e3) {
                        }
                    }
                    if (mVar.pr() == 0) {
                        jPr = -1;
                    } else {
                        jPr = mVar.pr();
                    }
                    hwVar.pr(null, jPr, jCurrentTimeMillis2);
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str, Throwable th) {
                hwVar.pr(null, -1L, 0L);
            }
        });
    }

    @Override // com.byazt.sd.fo
    public com.byazt.hfm.pr pr(int i) {
        String strOj;
        com.byazt.hfm.pr prVarX = null;
        if (!com.byazt.is.aj.pr()) {
            return null;
        }
        if (i == 2) {
            strOj = a.hw().lj();
        } else {
            strOj = a.hw().oj();
        }
        if (TextUtils.isEmpty(strOj)) {
            return null;
        }
        com.byazt.hcx.m mVarC = com.byazt.tf.hn.c(s.hw(strOj));
        if (mVarC != null) {
            try {
                if (mVarC.fw()) {
                    if (i == 2) {
                        prVarX = com.byazt.qk.hw.c(mVarC.zo());
                    } else {
                        prVarX = com.byazt.hfm.pr.x(mVarC.zo());
                    }
                }
            } catch (Exception e) {
            }
        }
        return prVarX;
    }

    @Override // com.byazt.sd.fo
    public com.byazt.hg.x pr(final of ofVar, String str) {
        String strTz;
        String strIu;
        if (ofVar == null) {
            strTz = null;
            strIu = null;
        } else {
            strTz = ofVar.tz();
            strIu = ls.iu(ofVar);
        }
        com.byazt.hcx.aj ajVarHw = com.byazt.tf.hn.hw("https://" + a.hw().t() + "/customer/api/app/pkg_info");
        ajVarHw.hw("convert_id", strTz);
        ajVarHw.hw("package_name", strIu);
        ajVarHw.hw("download_url", com.byazt.zp.aj.hw(str));
        String str2 = strTz + "_" + strIu + "_" + str;
        com.byazt.hg.x xVarPr = com.byazt.jx.pr.pr(str2);
        if (xVarPr != null) {
            return xVarPr;
        }
        final com.byazt.hcx.m[] mVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ajVarHw.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.9
            @Override // com.byazt.hcx.fw
            public void pr(com.byazt.hcx.m mVar) {
                mVarArr[0] = mVar;
                countDownLatch.countDown();
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str3, final Throwable th) {
                countDownLatch.countDown();
                com.byazt.xk.hw hwVarPr = com.byazt.xk.hw.pr();
                of ofVar2 = ofVar;
                hwVarPr.pr("pkg_info_failed", (String) null, ofVar2 != null ? ofVar2.B_() : "", new com.byazt.ttf.pr() { // from class: com.byazt.sd.rc.9.1
                    @Override // com.byazt.ttf.pr
                    public JSONObject pr(JSONObject jSONObject) throws JSONException {
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
        } catch (InterruptedException e) {
        }
        try {
            com.byazt.hcx.m mVar = mVarArr[0];
            if (mVar != null && mVar.fw()) {
                JSONObject jSONObjectC = mVarArr[0].c();
                if (jSONObjectC.optInt(PluginConstants.KEY_ERROR_CODE, -1) == 0) {
                    com.byazt.hg.x xVar = new com.byazt.hg.x(jSONObjectC);
                    com.byazt.jx.pr.pr(str2, xVar);
                    return xVar;
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    @Override // com.byazt.sd.fo
    public void pr(final u uVar, final String str, final String str2, final fo.hn hnVar, final int i, final long j) {
        if (hnVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("get_wlink") { // from class: com.byazt.sd.rc.10
                @Override // java.lang.Runnable
                public void run() {
                    rc.this.hw(uVar, str, str2, hnVar, i, j);
                }
            });
        } else {
            hw(uVar, str, str2, hnVar, i, j);
        }
    }

    @JProtect
    private JSONObject pr(u uVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adv_id", uVar.hn());
            jSONObject.put("site_id", uVar.x());
            jSONObject.put("page_url", str);
            jSONObject.put("log_extra", str2);
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(u uVar, String str, String str2, final fo.hn hnVar, int i, long j) {
        JSONObject jSONObjectPr = pr(uVar, str, str2);
        com.byazt.hcx.aj ajVarPr = com.byazt.tf.hn.pr();
        if (i == 1) {
            ajVarPr.pr(uVar.fw());
        } else {
            ajVarPr.pr(uVar.pr());
        }
        ajVarPr.pr(jSONObjectPr);
        ajVarPr.pr(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.sd.rc.11
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                hnVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, "time out!");
            }
        }, j);
        ajVarPr.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.13
            @Override // com.byazt.hcx.fw
            public void pr(com.byazt.hcx.m mVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (mVar == null) {
                    hnVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, "response is null!");
                    return;
                }
                if (mVar.fw()) {
                    try {
                        JSONObject jSONObjectC = mVar.c();
                        String strOptString = jSONObjectC.optString("message");
                        int iOptInt = jSONObjectC.optInt(NotificationCompat.CATEGORY_STATUS, -1);
                        if (iOptInt != 200) {
                            hnVar.pr(iOptInt, strOptString);
                            return;
                        }
                        JSONObject jSONObjectOptJSONObject = jSONObjectC.optJSONObject("data");
                        if (jSONObjectOptJSONObject == null) {
                            hnVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP, strOptString + ", data is null!");
                            return;
                        } else {
                            hnVar.pr(jSONObjectOptJSONObject);
                            return;
                        }
                    } catch (Throwable th) {
                        hnVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, th.getMessage());
                        return;
                    }
                }
                hnVar.pr(mVar.pr(), mVar.hw());
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i2, String str3, Throwable th) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                hnVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, th.getMessage());
            }
        });
    }

    @Override // com.byazt.sd.fo
    public void pr(String str) {
        x(str);
    }

    @Override // com.byazt.sd.fo
    public void pr(final JSONObject jSONObject, final fo.hn<com.byazt.hcx.m> hnVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.byazt.xlm.c.pr().execute(new Runnable() { // from class: com.byazt.sd.rc.14
                @Override // java.lang.Runnable
                public void run() {
                    rc.this.hw(jSONObject, (fo.hn<com.byazt.hcx.m>) hnVar);
                }
            });
        } else {
            hw(jSONObject, hnVar);
        }
    }

    @Override // com.byazt.sd.fo
    public void pr(final Function<SparseArray<Object>, Object> function) {
        com.byazt.hcx.aj ajVarPr = com.byazt.tf.hn.pr();
        ajVarPr.pr("https://" + zo.nt().vj() + "/ad_union_qa/sdk/query_config_list");
        ajVarPr.pr("x-pglcypher", GlobalSetting.NATIVE_EXPRESS_AD);
        ajVarPr.pr("x-ad-sdk-version", iu.c);
        ajVarPr.pr("x-plugin-version", "7.7.1.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, zo.nt().ny());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", iu.c);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
        } catch (Throwable th) {
        }
        byte[] bArrPr = com.byazt.wt.w.pr(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        final com.byazt.vkw.nt ntVarHn = com.byazt.wt.rc.hn();
        if (ntVarHn == null) {
            pr(function, -4, "armor service init fail");
        } else {
            ajVarPr.pr(ntVarHn.pr(bArrPr));
            ajVarPr.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.15
                @Override // com.byazt.hcx.fw
                public void pr(com.byazt.hcx.m mVar) {
                    byte[] bArrHw;
                    Function function2 = function;
                    if (function2 == null || mVar == null) {
                        rc.this.pr((Function<SparseArray<Object>, Object>) function2, -1, "response is null");
                        return;
                    }
                    String strPr = mVar.pr("content-type");
                    String strPr2 = mVar.pr("x-pglcypher");
                    if (TextUtils.equals(strPr, "application/octet-stream") || TextUtils.equals(strPr2, GlobalSetting.NATIVE_EXPRESS_AD)) {
                        bArrHw = ntVarHn.hw(mVar.x());
                    } else {
                        bArrHw = mVar.x();
                    }
                    String strHw = com.byazt.wt.w.hw(bArrHw);
                    if (TextUtils.isEmpty(strHw)) {
                        rc.this.pr((Function<SparseArray<Object>, Object>) function, -3, "response unGzipStr is null");
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(strHw);
                        int iOptInt = jSONObject2.optInt(PluginConstants.KEY_ERROR_CODE, -1);
                        String strOptString = jSONObject2.optString("message");
                        if (iOptInt != 0) {
                            rc.this.pr((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                            return;
                        }
                        String strOptString2 = jSONObject2.optString("data");
                        if (TextUtils.isEmpty(strOptString2)) {
                            rc.this.pr((Function<SparseArray<Object>, Object>) function, iOptInt, "response data is empty");
                        } else {
                            rc.this.pr((Function<SparseArray<Object>, Object>) function, strOptString2);
                        }
                    } catch (JSONException e) {
                        rc.this.pr((Function<SparseArray<Object>, Object>) function, -1, "response create json error");
                    }
                }

                @Override // com.byazt.hcx.fw
                public void pr(int i, String str, Throwable th2) {
                    rc.this.pr((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Function<SparseArray<Object>, Object> function, String str) {
        if (function != null) {
            function.apply(com.byazt.xi.hw.pr().pr(10000).pr(Void.class).pr(0, str).hw());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Function<SparseArray<Object>, Object> function, int i, String str) {
        if (function != null) {
            function.apply(com.byazt.xi.hw.pr().pr(10001).pr(Void.class).pr(0, Integer.valueOf(i)).pr(1, str).hw());
        }
    }

    @Override // com.byazt.sd.fo
    public void pr(final Map<String, Object> map, final Function<SparseArray<Object>, Object> function) {
        if (map == null || map.size() == 0) {
            return;
        }
        com.byazt.hcx.aj ajVarX = com.byazt.tf.hn.x("https://" + zo.nt().vj() + "/ad_union_qa/sdk/get_ad_config");
        ajVarX.pr("x-pglcypher", GlobalSetting.NATIVE_EXPRESS_AD);
        ajVarX.pr("x-ad-sdk-version", iu.c);
        ajVarX.pr("x-plugin-version", "7.7.1.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, zo.nt().ny());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", iu.c);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            byte[] bArrPr = com.byazt.wt.w.pr(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
            final com.byazt.vkw.nt ntVarHn = com.byazt.wt.rc.hn();
            if (ntVarHn == null) {
                pr(function, -4, "armor service init fail");
            } else {
                ajVarX.pr(ntVarHn.pr(bArrPr));
                ajVarX.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.16
                    @Override // com.byazt.hcx.fw
                    public void pr(com.byazt.hcx.m mVar) {
                        String strHw;
                        int iOptInt = -1;
                        if (mVar == null) {
                            rc.this.pr((Function<SparseArray<Object>, Object>) function, -1, "response is null");
                            return;
                        }
                        String strPr = mVar.pr("content-type");
                        String strPr2 = mVar.pr("x-pglcypher");
                        String strOptString = "";
                        if (TextUtils.equals(strPr, "application/octet-stream") || TextUtils.equals(strPr2, GlobalSetting.NATIVE_EXPRESS_AD)) {
                            strHw = com.byazt.wt.w.hw(ntVarHn.hw(mVar.x()));
                            if (!TextUtils.isEmpty(strHw)) {
                                PluginValueSet pluginValueSetHw = com.byazt.xi.pr.hw(function);
                                if (!TextUtils.isEmpty(strHw) && function != null && pluginValueSetHw != null && TextUtils.equals((CharSequence) pluginValueSetHw.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    zo.nt().pr(new zo.hn(map, strHw));
                                }
                                iOptInt = 0;
                            } else {
                                strOptString = "data is null";
                            }
                        } else {
                            JSONObject jSONObjectC = mVar.c();
                            if (jSONObjectC == null) {
                                strHw = "";
                            } else {
                                iOptInt = jSONObjectC.optInt(PluginConstants.KEY_ERROR_CODE);
                                strOptString = jSONObjectC.optString("message");
                                strHw = jSONObjectC.optString("data");
                                PluginValueSet pluginValueSetHw2 = com.byazt.xi.pr.hw(function);
                                if (!TextUtils.isEmpty(strHw) && function != null && pluginValueSetHw2 != null && TextUtils.equals((CharSequence) pluginValueSetHw2.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    zo.nt().pr(new zo.hn(map, strHw));
                                }
                            }
                        }
                        if (iOptInt == 0) {
                            rc.this.pr((Function<SparseArray<Object>, Object>) function, strHw);
                        } else {
                            rc.this.pr((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                        }
                    }

                    @Override // com.byazt.hcx.fw
                    public void pr(int i, String str, Throwable th) {
                        rc.this.pr((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                    }
                });
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(JSONObject jSONObject, final fo.hn<com.byazt.hcx.m> hnVar) {
        String strPr = ls.pr("/api/ad/union/sdk/apply_coupon/v2", false);
        qi qiVar = new qi();
        qiVar.pr(strPr);
        qiVar.hn(jSONObject, "coupon_apply");
        qiVar.pr(new HashMap());
        qiVar.pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.17
            @Override // com.byazt.hcx.fw
            public void pr(com.byazt.hcx.m mVar) {
                fo.hn hnVar2 = hnVar;
                if (hnVar2 != null) {
                    hnVar2.pr(mVar);
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str, Throwable th) {
                fo.hn hnVar2 = hnVar;
                if (hnVar2 != null) {
                    hnVar2.pr(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, th.getMessage());
                }
            }
        });
    }

    private void x(String str) {
        com.byazt.tf.hn.hw(str).pr(new com.byazt.hcx.fw() { // from class: com.byazt.sd.rc.18
            @Override // com.byazt.hcx.fw
            public void pr(com.byazt.hcx.m mVar) {
                if (mVar != null) {
                    mVar.zo();
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str2, Throwable th) {
            }
        });
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 1865})
    public static class hw {
        public final boolean hw;
        public final int pr;

        private hw(int i, boolean z) {
            this.pr = i;
            this.hw = z;
        }

        public static hw pr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new hw(jSONObject.optInt(com.tapsdk.tapad.group.constants.Constants.ERROR_CODE_FIELD), jSONObject.optBoolean("result"));
        }
    }
}
