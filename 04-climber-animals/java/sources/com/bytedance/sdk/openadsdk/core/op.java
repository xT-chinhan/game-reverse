package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.common.e.a;
import com.anythink.network.tap.TapATInitManager;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.jw.m;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.il;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.be;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class op implements yu<com.bytedance.sdk.openadsdk.core.zb.ms> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f3196ms;
    private AtomicLong xr = new AtomicLong(0);

    private boolean xr(int i) {
        return i == 3 || i == 4;
    }

    op(Context context) {
        this.f3196ms = context;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0271 A[Catch: all -> 0x037f, TRY_ENTER, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x027b  */
    /* JADX WARN: Code duplicated, block: B:107:0x02a3 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:113:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:116:0x02f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:120:0x0310 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0337 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x033e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0340  */
    /* JADX WARN: Code duplicated, block: B:127:0x0349 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0358 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x036a A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0370  */
    /* JADX WARN: Code duplicated, block: B:137:0x0373 A[Catch: all -> 0x037f, TRY_LEAVE, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0046 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0048 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x004d A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0051 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x007b  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a5 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:35:0x008a, B:37:0x00a5, B:39:0x00ac, B:41:0x00ba, B:43:0x00c1, B:45:0x00c7, B:46:0x00cc, B:48:0x00d2, B:50:0x00d8, B:52:0x00de), top: B:143:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ac A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:35:0x008a, B:37:0x00a5, B:39:0x00ac, B:41:0x00ba, B:43:0x00c1, B:45:0x00c7, B:46:0x00cc, B:48:0x00d2, B:50:0x00d8, B:52:0x00de), top: B:143:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ba A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:35:0x008a, B:37:0x00a5, B:39:0x00ac, B:41:0x00ba, B:43:0x00c1, B:45:0x00c7, B:46:0x00cc, B:48:0x00d2, B:50:0x00d8, B:52:0x00de), top: B:143:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:35:0x008a, B:37:0x00a5, B:39:0x00ac, B:41:0x00ba, B:43:0x00c1, B:45:0x00c7, B:46:0x00cc, B:48:0x00d2, B:50:0x00d8, B:52:0x00de), top: B:143:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00de A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #0 {all -> 0x00e3, blocks: (B:35:0x008a, B:37:0x00a5, B:39:0x00ac, B:41:0x00ba, B:43:0x00c1, B:45:0x00c7, B:46:0x00cc, B:48:0x00d2, B:50:0x00d8, B:52:0x00de), top: B:143:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:55:0x010e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0110  */
    /* JADX WARN: Code duplicated, block: B:61:0x0164 A[Catch: all -> 0x037d, TryCatch #1 {all -> 0x037d, blocks: (B:60:0x014a, B:61:0x0164, B:65:0x0174, B:67:0x0181, B:68:0x0186, B:72:0x0193), top: B:145:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0171  */
    /* JADX WARN: Code duplicated, block: B:64:0x0173  */
    /* JADX WARN: Code duplicated, block: B:67:0x0181 A[Catch: all -> 0x037d, TryCatch #1 {all -> 0x037d, blocks: (B:60:0x014a, B:61:0x0164, B:65:0x0174, B:67:0x0181, B:68:0x0186, B:72:0x0193), top: B:145:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0190  */
    /* JADX WARN: Code duplicated, block: B:71:0x0192  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ba A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01c4 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01d3 A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01ec A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0207 A[Catch: all -> 0x037f, TRY_ENTER, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x020e A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x021f A[Catch: all -> 0x037f, TryCatch #2 {all -> 0x037f, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0032, B:13:0x0038, B:16:0x0048, B:17:0x004d, B:18:0x0051, B:22:0x0059, B:24:0x005d, B:26:0x0064, B:28:0x006c, B:53:0x00e3, B:57:0x0111, B:74:0x01b1, B:76:0x01ba, B:78:0x01c4, B:80:0x01ca, B:83:0x01d3, B:85:0x01d9, B:86:0x01e2, B:88:0x01ec, B:89:0x01f9, B:92:0x0207, B:95:0x021f, B:96:0x0228, B:98:0x0244, B:101:0x0271, B:103:0x0275, B:105:0x027d, B:107:0x02a3, B:109:0x02a7, B:110:0x02ae, B:114:0x02cf, B:117:0x02f5, B:118:0x0305, B:120:0x0310, B:122:0x0337, B:126:0x0341, B:129:0x0358, B:131:0x035c, B:127:0x0349, B:133:0x036a, B:137:0x0373, B:93:0x020e, B:32:0x0081, B:34:0x0085, B:8:0x0027), top: B:147:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0242  */
    public JSONObject ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i, boolean z, int i2) {
        String strNy;
        int i3;
        long jCurrentTimeMillis;
        com.bytedance.sdk.openadsdk.core.live.xr xrVarMs;
        int iAh;
        int i4;
        String strAb;
        boolean z2;
        JSONObject jSONObjectMs;
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar2;
        String[] strArrMs;
        String strConcat;
        String str;
        String str2;
        int i5;
        long jCurrentTimeMillis2;
        long jCurrentTimeMillis3;
        boolean z3;
        String strKa;
        String strC;
        JSONObject jSONObject;
        String strMs;
        int i6;
        JSONObject jSONObject2 = new JSONObject();
        if (eVar != null) {
            try {
                strNy = TextUtils.isEmpty(eVar.xr()) ? com.bytedance.sdk.openadsdk.core.jw.f.ny() : eVar.xr();
                if (xrVar != null && xrVar.re() != null) {
                    i6 = AnonymousClass19.f3207ms[xrVar.re().ordinal()];
                    if (i6 != 1) {
                        jSONObject2.put("req_type", 3);
                    } else if (i6 != 2) {
                        jSONObject2.put("req_type", 1);
                    } else {
                        jSONObject2.put("req_type", -1);
                    }
                }
                if (i == 7) {
                    if (eVar != null && eVar.f3048ms > 0) {
                        jSONObject2.put("req_type", eVar.f3048ms);
                    }
                    if (eVar != null && !TextUtils.isEmpty(eVar.xr)) {
                        jSONObject2.put("pre_sessions", eVar.xr);
                        jSONObject2.put("play_again_count", eVar.ah);
                    }
                } else if (i == 8 && eVar != null && eVar.f3048ms > 0) {
                    jSONObject2.put("req_type", eVar.f3048ms);
                }
                try {
                    strKa = com.bytedance.sdk.openadsdk.core.ah.ka.ms().ka();
                    strC = com.bytedance.sdk.openadsdk.core.ah.ka.ms().c();
                    jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(strKa)) {
                        jSONObject.putOpt("version", strKa);
                    }
                    if (xrVar != null) {
                        strMs = com.bytedance.sdk.openadsdk.core.jw.f.ms(xrVar.h());
                        if (!TextUtils.isEmpty(strMs)) {
                            jSONObject.put("external_ab_vid", strMs);
                        }
                    } else {
                        strMs = null;
                    }
                    if (!TextUtils.isEmpty(strC)) {
                        jSONObject.putOpt("param", strC);
                    }
                    if (TextUtils.isEmpty(strKa) || !TextUtils.isEmpty(strMs) || !TextUtils.isEmpty(strC)) {
                        jSONObject2.put("abtest", jSONObject);
                    }
                } catch (Throwable unused) {
                }
                jSONObject2.put("request_id", strNy);
                jSONObject2.put("ad_sdk_version", g.ah);
                jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
                jSONObject2.put("is_plugin", g.ms());
                jSONObject2.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.d.ms.d());
                if (g.d()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                jSONObject2.put("is_use_tt_video", i3);
                jCurrentTimeMillis = System.currentTimeMillis();
                xrVarMs = com.bytedance.sdk.openadsdk.core.live.xr.ms();
                iAh = xrVarMs.ah();
                jSONObject2.put("live_sdk_status", iAh);
                jSONObject2.put("live_auth_status", xrVarMs.ka());
                jSONObject2.put("live_sdk_config", xrVarMs.x());
                jSONObject2.put("live_ad_click_count", xrVarMs.c());
                ch.ub().sl();
                if (iAh != 2) {
                    try {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        jSONObject2.put("app_start_time", jElapsedRealtime - Process.getStartElapsedRealtime());
                        jSONObject2.put("live_last_init_time", jElapsedRealtime - xrVarMs.ny());
                        if (ch.ub().lm()) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        jSONObject2.put("csj_type", i4);
                        strAb = xrVarMs.ab();
                        if (!TextUtils.isEmpty(strAb)) {
                            jSONObject2.put("live_plugin_version", strAb);
                        }
                        long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
                        if (i2 == 5) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        eVar.ms("liveInfo", jCurrentTimeMillis4, z2);
                        jSONObject2.put("source_type", a.C0080a.c);
                        jSONObject2.put("logsdk_version", com.bytedance.sdk.openadsdk.core.ah.d.ms().ka(i));
                        jSONObject2.put(a.C0080a.c, com.bytedance.sdk.openadsdk.core.jw.ch.xr(i));
                        jSONObjectMs = com.bytedance.sdk.openadsdk.core.ah.ms.ms(this.f3196ms, i);
                        if (jSONObjectMs != null) {
                            if (!re.xr().vy() && !com.bytedance.sdk.openadsdk.core.hi.ch.ah()) {
                                jSONObjectMs.remove("free_space");
                            }
                            xrVar2 = xrVar;
                            if (xrVar2 != null && xrVar.ub() > 0) {
                                jSONObjectMs.put(TapATInitManager.ORIENTATION_KEY, xrVar.ub());
                            }
                            if (cv.ah() > 0) {
                                jSONObjectMs.put("screenshot_time", String.valueOf(cv.ah()));
                            }
                            if (com.bytedance.sdk.openadsdk.core.ah.d.ms().ab(i)) {
                                jSONObjectMs.put("wifi_signal", "unknown");
                                jSONObjectMs.put("cellular_signal", "unknown");
                            } else {
                                jSONObjectMs.put("wifi_signal", com.bytedance.sdk.openadsdk.core.jw.ch.ms(0));
                                jSONObjectMs.put("cellular_signal", com.bytedance.sdk.openadsdk.core.jw.ch.ms(1));
                            }
                            if (i2 != 4) {
                                jSONObjectMs.put("sof_chara", com.bytedance.sdk.openadsdk.core.jw.re.d());
                            }
                            com.bytedance.sdk.openadsdk.core.jw.zb.ms(jSONObjectMs);
                            jSONObjectMs.put("cpu_arch", com.bytedance.sdk.openadsdk.core.jw.re.hi());
                            jSONObjectMs.put("direction", com.bytedance.sdk.openadsdk.core.op.ms.ms().c());
                        } else {
                            xrVar2 = xrVar;
                        }
                        jSONObject2.put("device", jSONObjectMs);
                        jSONObject2.put("pan_code_serial", "1000");
                        jSONObject2.put(be.m, ms(xrVar2, i));
                        jSONObject2.put("ua", com.bytedance.sdk.openadsdk.core.jw.f.ab());
                        jSONObject2.put("channel", g.c);
                        strArrMs = com.bytedance.sdk.openadsdk.core.ah.ms.ms(i);
                        strConcat = "";
                        if (strArrMs != null || strArrMs.length < 2) {
                            str = "";
                            str2 = str;
                        } else {
                            str2 = strArrMs[0];
                            str = strArrMs[1];
                        }
                        jSONObject2.put("ip", str2);
                        jSONObject2.put("client_ipv6", str);
                        jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.ah.ms.ms(str2, i));
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(ms(xrVar2, i, eVar));
                        jSONObject2.put("adslots", jSONArray);
                        if (eVar != null && eVar.zb > 0) {
                            jSONObject2.put("load_ad_api", eVar.zb);
                        }
                        com.bytedance.sdk.openadsdk.core.ah.ms.ms(jSONObject2, i);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("start2req_time", SystemClock.elapsedRealtime() - nw.ka);
                        if (nw.xr.get()) {
                            i5 = 0;
                        } else {
                            i5 = 1;
                        }
                        jSONObject3.put("start_type", i5);
                        jSONObject3.put("show_count", com.bytedance.sdk.openadsdk.core.zb.ah.f3815ms);
                        jSONObject2.put("ads_parameter", jSONObject3);
                        ms(jSONObject2, eVar);
                        jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
                        jSONObject2.put("ts", jCurrentTimeMillis2);
                        if (xrVar.d() != null && strNy != null) {
                            strConcat = String.valueOf(jCurrentTimeMillis2).concat(xrVar.d()).concat(strNy);
                        }
                        jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.ka.xr(strConcat));
                        if (i2 == 4) {
                            jCurrentTimeMillis3 = System.currentTimeMillis();
                            jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(re.xr().ms(xrVar.d())));
                            if (re.xr().xr(xrVar.d())) {
                                if (7 == xrVar.t()) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                ms(z3, jSONObject2, xrVar.d());
                            } else {
                                com.bytedance.sdk.openadsdk.core.t.u.ms().ms(xrVar.d(), (String) null, (String) null, true);
                            }
                            if (eVar != null && eVar.u != null) {
                                eVar.u.ms("precache_time", System.currentTimeMillis() - jCurrentTimeMillis3);
                            }
                        }
                        if (z) {
                            jSONObject2.put("ad_sdk_version", g.ah);
                            return jSONObject2;
                        }
                        if (i2 == 3) {
                            jSONObject2.put("material_keys", com.bytedance.sdk.openadsdk.core.jw.f.ms(xrVar));
                        }
                    } catch (Throwable unused2) {
                    }
                } else {
                    if (ch.ub().lm()) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    jSONObject2.put("csj_type", i4);
                    strAb = xrVarMs.ab();
                    if (!TextUtils.isEmpty(strAb)) {
                        jSONObject2.put("live_plugin_version", strAb);
                    }
                    long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (i2 == 5) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    eVar.ms("liveInfo", jCurrentTimeMillis5, z2);
                    jSONObject2.put("source_type", a.C0080a.c);
                    jSONObject2.put("logsdk_version", com.bytedance.sdk.openadsdk.core.ah.d.ms().ka(i));
                    jSONObject2.put(a.C0080a.c, com.bytedance.sdk.openadsdk.core.jw.ch.xr(i));
                    jSONObjectMs = com.bytedance.sdk.openadsdk.core.ah.ms.ms(this.f3196ms, i);
                    if (jSONObjectMs != null) {
                        if (!re.xr().vy()) {
                            jSONObjectMs.remove("free_space");
                        }
                        xrVar2 = xrVar;
                        if (xrVar2 != null) {
                            jSONObjectMs.put(TapATInitManager.ORIENTATION_KEY, xrVar.ub());
                        }
                        if (cv.ah() > 0) {
                            jSONObjectMs.put("screenshot_time", String.valueOf(cv.ah()));
                        }
                        if (com.bytedance.sdk.openadsdk.core.ah.d.ms().ab(i)) {
                            jSONObjectMs.put("wifi_signal", "unknown");
                            jSONObjectMs.put("cellular_signal", "unknown");
                        } else {
                            jSONObjectMs.put("wifi_signal", com.bytedance.sdk.openadsdk.core.jw.ch.ms(0));
                            jSONObjectMs.put("cellular_signal", com.bytedance.sdk.openadsdk.core.jw.ch.ms(1));
                        }
                        if (i2 != 4) {
                            jSONObjectMs.put("sof_chara", com.bytedance.sdk.openadsdk.core.jw.re.d());
                        }
                        com.bytedance.sdk.openadsdk.core.jw.zb.ms(jSONObjectMs);
                        jSONObjectMs.put("cpu_arch", com.bytedance.sdk.openadsdk.core.jw.re.hi());
                        jSONObjectMs.put("direction", com.bytedance.sdk.openadsdk.core.op.ms.ms().c());
                    } else {
                        xrVar2 = xrVar;
                    }
                    jSONObject2.put("device", jSONObjectMs);
                    jSONObject2.put("pan_code_serial", "1000");
                    jSONObject2.put(be.m, ms(xrVar2, i));
                    jSONObject2.put("ua", com.bytedance.sdk.openadsdk.core.jw.f.ab());
                    jSONObject2.put("channel", g.c);
                    strArrMs = com.bytedance.sdk.openadsdk.core.ah.ms.ms(i);
                    strConcat = "";
                    if (strArrMs != null) {
                        str = "";
                        str2 = str;
                    } else {
                        str = "";
                        str2 = str;
                    }
                    jSONObject2.put("ip", str2);
                    jSONObject2.put("client_ipv6", str);
                    jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.ah.ms.ms(str2, i));
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(ms(xrVar2, i, eVar));
                    jSONObject2.put("adslots", jSONArray2);
                    if (eVar != null) {
                        jSONObject2.put("load_ad_api", eVar.zb);
                    }
                    com.bytedance.sdk.openadsdk.core.ah.ms.ms(jSONObject2, i);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("start2req_time", SystemClock.elapsedRealtime() - nw.ka);
                    if (nw.xr.get()) {
                        i5 = 0;
                    } else {
                        i5 = 1;
                    }
                    jSONObject4.put("start_type", i5);
                    jSONObject4.put("show_count", com.bytedance.sdk.openadsdk.core.zb.ah.f3815ms);
                    jSONObject2.put("ads_parameter", jSONObject4);
                    ms(jSONObject2, eVar);
                    jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
                    jSONObject2.put("ts", jCurrentTimeMillis2);
                    if (xrVar.d() != null) {
                        strConcat = String.valueOf(jCurrentTimeMillis2).concat(xrVar.d()).concat(strNy);
                    }
                    jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.ka.xr(strConcat));
                    if (i2 == 4) {
                        jCurrentTimeMillis3 = System.currentTimeMillis();
                        jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(re.xr().ms(xrVar.d())));
                        if (re.xr().xr(xrVar.d())) {
                            if (7 == xrVar.t()) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            ms(z3, jSONObject2, xrVar.d());
                        } else {
                            com.bytedance.sdk.openadsdk.core.t.u.ms().ms(xrVar.d(), (String) null, (String) null, true);
                        }
                        if (eVar != null) {
                            eVar.u.ms("precache_time", System.currentTimeMillis() - jCurrentTimeMillis3);
                        }
                    }
                    if (z) {
                        jSONObject2.put("ad_sdk_version", g.ah);
                        return jSONObject2;
                    }
                    if (i2 == 3) {
                        jSONObject2.put("material_keys", com.bytedance.sdk.openadsdk.core.jw.f.ms(xrVar));
                    }
                }
            } catch (Throwable unused3) {
            }
        } else {
            if (xrVar != null) {
                i6 = AnonymousClass19.f3207ms[xrVar.re().ordinal()];
                if (i6 != 1) {
                    jSONObject2.put("req_type", 3);
                } else if (i6 != 2) {
                    jSONObject2.put("req_type", 1);
                } else {
                    jSONObject2.put("req_type", -1);
                }
            }
            if (i == 7) {
                if (eVar != null) {
                    jSONObject2.put("req_type", eVar.f3048ms);
                }
                if (eVar != null) {
                    jSONObject2.put("pre_sessions", eVar.xr);
                    jSONObject2.put("play_again_count", eVar.ah);
                }
            } else if (i == 8) {
                jSONObject2.put("req_type", eVar.f3048ms);
            }
            strKa = com.bytedance.sdk.openadsdk.core.ah.ka.ms().ka();
            strC = com.bytedance.sdk.openadsdk.core.ah.ka.ms().c();
            jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(strKa)) {
                jSONObject.putOpt("version", strKa);
            }
            if (xrVar != null) {
                strMs = com.bytedance.sdk.openadsdk.core.jw.f.ms(xrVar.h());
                if (!TextUtils.isEmpty(strMs)) {
                    jSONObject.put("external_ab_vid", strMs);
                }
            } else {
                strMs = null;
            }
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.putOpt("param", strC);
            }
            if (TextUtils.isEmpty(strKa)) {
                jSONObject2.put("abtest", jSONObject);
            } else {
                jSONObject2.put("abtest", jSONObject);
            }
            jSONObject2.put("request_id", strNy);
            jSONObject2.put("ad_sdk_version", g.ah);
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            jSONObject2.put("is_plugin", g.ms());
            jSONObject2.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.d.ms.d());
            if (g.d()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            jSONObject2.put("is_use_tt_video", i3);
            jCurrentTimeMillis = System.currentTimeMillis();
            xrVarMs = com.bytedance.sdk.openadsdk.core.live.xr.ms();
            iAh = xrVarMs.ah();
            jSONObject2.put("live_sdk_status", iAh);
            jSONObject2.put("live_auth_status", xrVarMs.ka());
            jSONObject2.put("live_sdk_config", xrVarMs.x());
            jSONObject2.put("live_ad_click_count", xrVarMs.c());
            ch.ub().sl();
            if (iAh != 2) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                jSONObject2.put("app_start_time", jElapsedRealtime2 - Process.getStartElapsedRealtime());
                jSONObject2.put("live_last_init_time", jElapsedRealtime2 - xrVarMs.ny());
                if (ch.ub().lm()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject2.put("csj_type", i4);
                strAb = xrVarMs.ab();
                if (!TextUtils.isEmpty(strAb)) {
                    jSONObject2.put("live_plugin_version", strAb);
                }
                long jCurrentTimeMillis6 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (i2 == 5) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                eVar.ms("liveInfo", jCurrentTimeMillis6, z2);
                jSONObject2.put("source_type", a.C0080a.c);
                jSONObject2.put("logsdk_version", com.bytedance.sdk.openadsdk.core.ah.d.ms().ka(i));
                jSONObject2.put(a.C0080a.c, com.bytedance.sdk.openadsdk.core.jw.ch.xr(i));
                jSONObjectMs = com.bytedance.sdk.openadsdk.core.ah.ms.ms(this.f3196ms, i);
                if (jSONObjectMs != null) {
                    if (!re.xr().vy()) {
                        jSONObjectMs.remove("free_space");
                    }
                    xrVar2 = xrVar;
                    if (xrVar2 != null) {
                        jSONObjectMs.put(TapATInitManager.ORIENTATION_KEY, xrVar.ub());
                    }
                    if (cv.ah() > 0) {
                        jSONObjectMs.put("screenshot_time", String.valueOf(cv.ah()));
                    }
                    if (com.bytedance.sdk.openadsdk.core.ah.d.ms().ab(i)) {
                        jSONObjectMs.put("wifi_signal", "unknown");
                        jSONObjectMs.put("cellular_signal", "unknown");
                    } else {
                        jSONObjectMs.put("wifi_signal", com.bytedance.sdk.openadsdk.core.jw.ch.ms(0));
                        jSONObjectMs.put("cellular_signal", com.bytedance.sdk.openadsdk.core.jw.ch.ms(1));
                    }
                    if (i2 != 4) {
                        jSONObjectMs.put("sof_chara", com.bytedance.sdk.openadsdk.core.jw.re.d());
                    }
                    com.bytedance.sdk.openadsdk.core.jw.zb.ms(jSONObjectMs);
                    jSONObjectMs.put("cpu_arch", com.bytedance.sdk.openadsdk.core.jw.re.hi());
                    jSONObjectMs.put("direction", com.bytedance.sdk.openadsdk.core.op.ms.ms().c());
                } else {
                    xrVar2 = xrVar;
                }
                jSONObject2.put("device", jSONObjectMs);
                jSONObject2.put("pan_code_serial", "1000");
                jSONObject2.put(be.m, ms(xrVar2, i));
                jSONObject2.put("ua", com.bytedance.sdk.openadsdk.core.jw.f.ab());
                jSONObject2.put("channel", g.c);
                strArrMs = com.bytedance.sdk.openadsdk.core.ah.ms.ms(i);
                strConcat = "";
                if (strArrMs != null) {
                    str = "";
                    str2 = str;
                } else {
                    str = "";
                    str2 = str;
                }
                jSONObject2.put("ip", str2);
                jSONObject2.put("client_ipv6", str);
                jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.ah.ms.ms(str2, i));
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put(ms(xrVar2, i, eVar));
                jSONObject2.put("adslots", jSONArray3);
                if (eVar != null) {
                    jSONObject2.put("load_ad_api", eVar.zb);
                }
                com.bytedance.sdk.openadsdk.core.ah.ms.ms(jSONObject2, i);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("start2req_time", SystemClock.elapsedRealtime() - nw.ka);
                if (nw.xr.get()) {
                    i5 = 0;
                } else {
                    i5 = 1;
                }
                jSONObject5.put("start_type", i5);
                jSONObject5.put("show_count", com.bytedance.sdk.openadsdk.core.zb.ah.f3815ms);
                jSONObject2.put("ads_parameter", jSONObject5);
                ms(jSONObject2, eVar);
                jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
                jSONObject2.put("ts", jCurrentTimeMillis2);
                if (xrVar.d() != null) {
                    strConcat = String.valueOf(jCurrentTimeMillis2).concat(xrVar.d()).concat(strNy);
                }
                jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.ka.xr(strConcat));
                if (i2 == 4) {
                    jCurrentTimeMillis3 = System.currentTimeMillis();
                    jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(re.xr().ms(xrVar.d())));
                    if (re.xr().xr(xrVar.d())) {
                        if (7 == xrVar.t()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        ms(z3, jSONObject2, xrVar.d());
                    } else {
                        com.bytedance.sdk.openadsdk.core.t.u.ms().ms(xrVar.d(), (String) null, (String) null, true);
                    }
                    if (eVar != null) {
                        eVar.u.ms("precache_time", System.currentTimeMillis() - jCurrentTimeMillis3);
                    }
                }
                if (z) {
                    jSONObject2.put("ad_sdk_version", g.ah);
                    return jSONObject2;
                }
                if (i2 == 3) {
                    jSONObject2.put("material_keys", com.bytedance.sdk.openadsdk.core.jw.f.ms(xrVar));
                }
            } else {
                if (ch.ub().lm()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject2.put("csj_type", i4);
                strAb = xrVarMs.ab();
                if (!TextUtils.isEmpty(strAb)) {
                    jSONObject2.put("live_plugin_version", strAb);
                }
                long jCurrentTimeMillis7 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (i2 == 5) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                eVar.ms("liveInfo", jCurrentTimeMillis7, z2);
                jSONObject2.put("source_type", a.C0080a.c);
                jSONObject2.put("logsdk_version", com.bytedance.sdk.openadsdk.core.ah.d.ms().ka(i));
                jSONObject2.put(a.C0080a.c, com.bytedance.sdk.openadsdk.core.jw.ch.xr(i));
                jSONObjectMs = com.bytedance.sdk.openadsdk.core.ah.ms.ms(this.f3196ms, i);
                if (jSONObjectMs != null) {
                    if (!re.xr().vy()) {
                        jSONObjectMs.remove("free_space");
                    }
                    xrVar2 = xrVar;
                    if (xrVar2 != null) {
                        jSONObjectMs.put(TapATInitManager.ORIENTATION_KEY, xrVar.ub());
                    }
                    if (cv.ah() > 0) {
                        jSONObjectMs.put("screenshot_time", String.valueOf(cv.ah()));
                    }
                    if (com.bytedance.sdk.openadsdk.core.ah.d.ms().ab(i)) {
                        jSONObjectMs.put("wifi_signal", "unknown");
                        jSONObjectMs.put("cellular_signal", "unknown");
                    } else {
                        jSONObjectMs.put("wifi_signal", com.bytedance.sdk.openadsdk.core.jw.ch.ms(0));
                        jSONObjectMs.put("cellular_signal", com.bytedance.sdk.openadsdk.core.jw.ch.ms(1));
                    }
                    if (i2 != 4) {
                        jSONObjectMs.put("sof_chara", com.bytedance.sdk.openadsdk.core.jw.re.d());
                    }
                    com.bytedance.sdk.openadsdk.core.jw.zb.ms(jSONObjectMs);
                    jSONObjectMs.put("cpu_arch", com.bytedance.sdk.openadsdk.core.jw.re.hi());
                    jSONObjectMs.put("direction", com.bytedance.sdk.openadsdk.core.op.ms.ms().c());
                } else {
                    xrVar2 = xrVar;
                }
                jSONObject2.put("device", jSONObjectMs);
                jSONObject2.put("pan_code_serial", "1000");
                jSONObject2.put(be.m, ms(xrVar2, i));
                jSONObject2.put("ua", com.bytedance.sdk.openadsdk.core.jw.f.ab());
                jSONObject2.put("channel", g.c);
                strArrMs = com.bytedance.sdk.openadsdk.core.ah.ms.ms(i);
                strConcat = "";
                if (strArrMs != null) {
                    str = "";
                    str2 = str;
                } else {
                    str = "";
                    str2 = str;
                }
                jSONObject2.put("ip", str2);
                jSONObject2.put("client_ipv6", str);
                jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.ah.ms.ms(str2, i));
                JSONArray jSONArray4 = new JSONArray();
                jSONArray4.put(ms(xrVar2, i, eVar));
                jSONObject2.put("adslots", jSONArray4);
                if (eVar != null) {
                    jSONObject2.put("load_ad_api", eVar.zb);
                }
                com.bytedance.sdk.openadsdk.core.ah.ms.ms(jSONObject2, i);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("start2req_time", SystemClock.elapsedRealtime() - nw.ka);
                if (nw.xr.get()) {
                    i5 = 0;
                } else {
                    i5 = 1;
                }
                jSONObject6.put("start_type", i5);
                jSONObject6.put("show_count", com.bytedance.sdk.openadsdk.core.zb.ah.f3815ms);
                jSONObject2.put("ads_parameter", jSONObject6);
                ms(jSONObject2, eVar);
                jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
                jSONObject2.put("ts", jCurrentTimeMillis2);
                if (xrVar.d() != null) {
                    strConcat = String.valueOf(jCurrentTimeMillis2).concat(xrVar.d()).concat(strNy);
                }
                jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.ka.xr(strConcat));
                if (i2 == 4) {
                    jCurrentTimeMillis3 = System.currentTimeMillis();
                    jSONObject2.putOpt("has_pre_fetch", Boolean.valueOf(re.xr().ms(xrVar.d())));
                    if (re.xr().xr(xrVar.d())) {
                        if (7 == xrVar.t()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        ms(z3, jSONObject2, xrVar.d());
                    } else {
                        com.bytedance.sdk.openadsdk.core.t.u.ms().ms(xrVar.d(), (String) null, (String) null, true);
                    }
                    if (eVar != null) {
                        eVar.u.ms("precache_time", System.currentTimeMillis() - jCurrentTimeMillis3);
                    }
                }
                if (z) {
                    jSONObject2.put("ad_sdk_version", g.ah);
                    return jSONObject2;
                }
                if (i2 == 3) {
                    jSONObject2.put("material_keys", com.bytedance.sdk.openadsdk.core.jw.f.ms(xrVar));
                }
            }
        }
        return jSONObject2;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.op$19, reason: invalid class name */
    static /* synthetic */ class AnonymousClass19 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f3207ms;

        static {
            int[] iArr = new int[TTAdLoadType.values().length];
            f3207ms = iArr;
            try {
                iArr[TTAdLoadType.LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3207ms[TTAdLoadType.PRELOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void ms(JSONObject jSONObject, e eVar) {
        if (eVar == null || eVar.ka == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", eVar.ka);
        } catch (Exception unused) {
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.core.nw.xr xrVar, long j, long j2, long j3, long j4) {
        if (xrVar == null) {
            return;
        }
        xrVar.ms(j);
        xrVar.xr(j3);
        xrVar.ah(j2);
        xrVar.d(j4);
    }

    private boolean xr(String str) {
        if (com.bytedance.sdk.openadsdk.core.u.ah.ms()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.u.ah.ms(str)) {
            return false;
        }
        String strXr = com.bytedance.sdk.openadsdk.core.u.ah.xr();
        if (!TextUtils.isEmpty(strXr)) {
            com.bytedance.sdk.openadsdk.core.t.u.ms(strXr, System.currentTimeMillis(), false);
        }
        return true;
    }

    private boolean ah(String str) {
        if (com.bytedance.sdk.openadsdk.core.u.ah.ah()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.u.ah.xr(str)) {
            return false;
        }
        String strD = com.bytedance.sdk.openadsdk.core.u.ah.d();
        if (!TextUtils.isEmpty(strD)) {
            com.bytedance.sdk.openadsdk.core.t.u.ms(strD, System.currentTimeMillis(), true);
        }
        return true;
    }

    private boolean ms(String str, e eVar) {
        float fD = com.bytedance.sdk.openadsdk.core.ah.ka.ms().d();
        if (eVar != null && eVar.d == 2 && fD > 0.0f) {
            return ah(str);
        }
        return xr(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final e eVar, final int i, yu.xr xrVar2) {
        final com.bytedance.sdk.openadsdk.core.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.ms.ms(xrVar2);
        msVar.ms(i);
        if ((i != 3 || !com.bytedance.sdk.openadsdk.core.component.splash.d.ms(xrVar)) && Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.ch.ab.ka(new com.bytedance.sdk.component.ch.ny("get_ad") { // from class: com.bytedance.sdk.openadsdk.core.op.1
                @Override // java.lang.Runnable
                public void run() {
                    op.this.d(xrVar, eVar, i, msVar);
                }
            });
        } else {
            d(xrVar, eVar, i, msVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void xr(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final e eVar, final int i, yu.xr xrVar2) {
        final com.bytedance.sdk.openadsdk.core.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.ms.ms(xrVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("bid_pre") { // from class: com.bytedance.sdk.openadsdk.core.op.11
                @Override // java.lang.Runnable
                public void run() {
                    op.this.ms(xrVar, eVar, i, msVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            ms(xrVar, eVar, i, msVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    public com.bytedance.sdk.openadsdk.core.cv.xr ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2, e eVar, int i, int i2, yu.xr xrVar3) {
        com.bytedance.sdk.openadsdk.core.cv.xr xrVarXr;
        com.bytedance.sdk.openadsdk.tools.xr.ms(xrVar);
        boolean z = i2 == 5;
        eVar.ms("buildAdBodyReady", z);
        JSONObject jSONObjectMs = ms(xrVar, eVar, i, false, i2);
        eVar.ms("doBuildAdBody", z);
        if (jSONObjectMs == null) {
            xrVar2.ms(-9);
            xrVar3.ms(-9, ny.ms(-9), xrVar2);
            return null;
        }
        String string = jSONObjectMs.toString();
        if (i2 == 5) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            xrVarXr = com.bytedance.sdk.openadsdk.core.ah.c.ms().ms(string);
            eVar.ms("encrypt", System.currentTimeMillis() - jCurrentTimeMillis, z);
        } else {
            xrVarXr = com.bytedance.sdk.openadsdk.core.ah.c.ms().xr(string);
        }
        if (xrVarXr == null) {
            xrVar2.ms(-9);
            xrVar3.ms(-9, ny.ms(-9), xrVar2);
            return null;
        }
        xrVarXr.ms(jSONObjectMs);
        return xrVarXr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i, yu.xr xrVar2, String str, int i2) {
        xr(xrVar, eVar, i, xrVar2, str, i2);
    }

    public void d(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i, yu.xr xrVar2) {
        xr(xrVar, eVar, i, xrVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    private void xr(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final e eVar, final int i, final yu.xr xrVar2, String str, final int i2) {
        final com.bytedance.sdk.openadsdk.core.nw.xr xrVar3 = new com.bytedance.sdk.openadsdk.core.nw.xr();
        xrVar3.ms(xrVar);
        try {
            if (ms(xrVar, xrVar3, xrVar2, i2 == 5, eVar, i)) {
                return;
            }
            com.bytedance.sdk.component.ny.xr.ka kaVarMs = ms(xrVar, eVar, i, xrVar2, str, i2, xrVar3);
            if (kaVarMs == null) {
                xrVar3.ms(-15);
                xrVar2.ms(-15, ny.ms(-15), xrVar3);
            } else {
                kaVarMs.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.20
                    @Override // com.bytedance.sdk.component.ny.ms.ms
                    public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar4) {
                        op.this.ms(dVar, xrVar4, xrVar3, xrVar2, xrVar, eVar, i, i2);
                    }

                    @Override // com.bytedance.sdk.component.ny.ms.ms
                    public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                        op.this.ms(dVar, iOException, xrVar3, xrVar2);
                    }
                });
                com.bytedance.sdk.openadsdk.core.d.ms().ah();
                ms();
            }
        } catch (Throwable th) {
            ms(th, xrVar3, xrVar2);
        }
    }

    private boolean ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2, yu.xr xrVar3, boolean z, e eVar, int i) {
        if (xrVar3 == null) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            xrVar2.ms(1000);
            xrVar3.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员", xrVar2);
            return true;
        }
        if (!z) {
            return false;
        }
        eVar.ms("execGetAdReady", z);
        if (!TextUtils.isEmpty(xrVar.nw()) && eVar.d <= 0) {
            ms(xrVar2, xrVar, xrVar3, eVar, i);
            com.bytedance.sdk.openadsdk.core.t.xr.ms();
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (ms(xrVar.d(), eVar)) {
            xrVar2.ms(-8);
            xrVar3.ms(-8, ny.ms(-8), xrVar2);
            com.bytedance.sdk.openadsdk.core.t.xr.ms();
            return true;
        }
        eVar.ms("checkCallFreq", System.currentTimeMillis() - jCurrentTimeMillis, z);
        return false;
    }

    private void ms(com.bytedance.sdk.openadsdk.core.nw.xr xrVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar2, final yu.xr xrVar3, e eVar, int i) {
        xrVar.ah(2);
        xrVar.ms(xrVar2.nw());
        try {
            boolean z = false;
            JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.core.ah.c.ms(new JSONObject(xrVar2.nw()), false, true);
            if (jSONObjectMs == null) {
                ms(xrVar3, xrVar);
                return;
            }
            ms msVarMs = ms.ms(jSONObjectMs, xrVar2, eVar);
            xrVar.ms(msVarMs.ch);
            t.ms(msVarMs.ny);
            if (msVarMs.d != 20000) {
                xrVar.ms(msVarMs.d);
                StringBuilder sb = new StringBuilder("reason: ");
                sb.append(msVarMs.c).append("  message: ").append(msVarMs.ka);
                xrVar3.ms(msVarMs.d, sb.toString(), xrVar);
                return;
            }
            if (msVarMs.x == null) {
                ms(xrVar3, xrVar);
                return;
            }
            msVarMs.x.ms(jSONObjectMs);
            List<lm> listXr = msVarMs.x.xr();
            if (listXr != null) {
                List<lm> arrayList = new ArrayList<>(listXr);
                for (lm lmVar : listXr) {
                    lm lmVarMs = com.bytedance.sdk.openadsdk.core.jw.ka.ms(lmVar.p(), i);
                    if (lmVarMs != null) {
                        arrayList.remove(lmVar);
                        lmVarMs.le(lmVar.pt());
                        arrayList.add(lmVarMs);
                    } else if (lmVar.pc()) {
                        final String str = msVarMs.ab;
                        if (!TextUtils.isEmpty(str) && eVar != null) {
                            eVar.ms(str);
                        }
                        final String strD = xrVar2.d();
                        final String strMs = com.bytedance.sdk.openadsdk.core.jw.f.ms(xrVar2);
                        re.ms().ah(xrVar2, eVar, i, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.op.21
                            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                            public void ms(int i2, String str2, com.bytedance.sdk.openadsdk.core.nw.xr xrVar4) {
                                com.bytedance.sdk.openadsdk.core.t.u.ms().ms(i2, str2, str, strD, strMs);
                                xrVar3.ms(i2, str2, xrVar4);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                            public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar4) {
                                com.bytedance.sdk.openadsdk.core.t.u.ms().ms(0, "success", str, strD, strMs);
                                xrVar3.ms(msVar, xrVar4);
                            }
                        });
                        z = true;
                    }
                }
                if (z) {
                    return;
                } else {
                    msVarMs.x.ms(arrayList);
                }
            }
            xrVar3.ms(msVarMs.x, xrVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ah("NetApiImpl", "get ad error: ", th);
            ms(xrVar3, xrVar);
        }
    }

    private com.bytedance.sdk.component.ny.xr.ka ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i, yu.xr xrVar2, String str, int i2, com.bytedance.sdk.openadsdk.core.nw.xr xrVar3) throws JSONException {
        byte[] bytes;
        Map<String, String> mapMs;
        com.bytedance.sdk.openadsdk.core.cv.xr xrVarMs = ms(xrVar, xrVar3, eVar, i, i2, xrVar2);
        if (xrVarMs == null) {
            return null;
        }
        String strMs = com.bytedance.sdk.openadsdk.core.jw.f.ms(str, true);
        com.bytedance.sdk.component.ny.xr.ka kaVarXr = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
        String strMs2 = com.bytedance.sdk.openadsdk.ab.d.ms(kaVarXr, strMs);
        kaVarXr.ms(strMs2);
        if (xrVarMs.ms() != null) {
            com.bytedance.sdk.openadsdk.ab.d.ms(xrVarMs.ms(), 0);
        }
        if (i2 == 5) {
            if (xrVarMs.d() != null) {
                JSONObject jSONObjectD = xrVarMs.d();
                kaVarXr.ms(jSONObjectD);
                bytes = jSONObjectD.toString().getBytes(StandardCharsets.UTF_8);
                kaVarXr.ms(false);
            } else {
                if (xrVarMs.ah() == null) {
                    return null;
                }
                bytes = xrVarMs.ah();
                kaVarXr.ms("application/octet-stream", bytes);
                kaVarXr.ms(true);
            }
        } else {
            JSONObject jSONObjectD2 = xrVarMs.d();
            kaVarXr.ms(jSONObjectD2);
            bytes = jSONObjectD2.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z = i2 == 5;
        eVar.ms("doHttpReqSignReady", z);
        com.bytedance.sdk.openadsdk.ms.ms.ms msVarMs = com.bytedance.sdk.openadsdk.ms.ms.ms.ms(true);
        eVar.ms("MSInst", z);
        Map<String, String> mapMs2 = msVarMs.ms(strMs2, bytes);
        eVar.ms("doHttpReqSign", z);
        if (mapMs2 == null) {
            mapMs2 = new HashMap<>();
        }
        if (i2 == 5 && (mapMs = com.bytedance.sdk.openadsdk.tools.xr.ms(xrVar.d())) != null) {
            mapMs2.putAll(mapMs);
        }
        com.bytedance.sdk.openadsdk.core.jw.jw.ms(mapMs2);
        Map<String, String> mapKa = xrVarMs.ka();
        kaVarXr.xr("User-Agent", com.bytedance.sdk.openadsdk.core.jw.f.ab());
        if (mapKa != null) {
            mapMs2.putAll(mapKa);
        }
        if (mapMs2.size() > 0) {
            for (Map.Entry<String, String> entry : mapMs2.entrySet()) {
                kaVarXr.xr(entry.getKey(), entry.getValue());
            }
        }
        kaVarXr.ka(ms(bytes, mapKa, xrVarMs));
        eVar.ms("appendHeader", z);
        return kaVarXr;
    }

    private Map<String, Object> ms(byte[] bArr, Map<String, String> map, com.bytedance.sdk.openadsdk.core.cv.xr xrVar) {
        HashMap map2 = new HashMap();
        try {
            com.bytedance.sdk.openadsdk.core.cv.ms msVar = new com.bytedance.sdk.openadsdk.core.cv.ms();
            msVar.x(System.currentTimeMillis());
            msVar.ny(bArr == null ? 0L : bArr.length);
            msVar.ah(xrVar.xr());
            if (map != null) {
                msVar.ms(map.get("x-pglcypher"));
            }
            msVar.ms(xrVar.ms());
            msVar.xr(com.bytedance.sdk.component.panglearmor.ny.ah());
            msVar.ms(re.xr().tk());
            map2.put("load_time_model", msVar);
        } catch (Exception unused) {
        }
        return map2;
    }

    private void ms() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.xr.get() >= 30000) {
            this.xr.set(jCurrentTimeMillis);
            com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.op.22
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.g.x.ms((com.bytedance.sdk.openadsdk.core.g.ka) null).ka();
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException, com.bytedance.sdk.openadsdk.core.nw.xr xrVar, yu.xr xrVar2) {
        com.bytedance.sdk.openadsdk.core.t.xr.ms();
        if (iOException != null) {
            xrVar.ms(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN);
            xrVar2.ms(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, iOException.getMessage(), xrVar);
            com.bytedance.sdk.component.utils.sl.ms("NetApiImpl", "onFailure: ", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE));
        }
    }

    private void ms(Throwable th, com.bytedance.sdk.openadsdk.core.nw.xr xrVar, yu.xr xrVar2) {
        if (xrVar2 != null) {
            xrVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE);
            xrVar2.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, th.getMessage(), xrVar);
            com.bytedance.sdk.component.utils.sl.ah("NetApiImpl", " msg = ", th.getMessage());
        }
    }

    private void ms(com.bytedance.sdk.component.ny.xr xrVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar2, int i, e eVar, yu.xr xrVar3, com.bytedance.sdk.openadsdk.core.nw.xr xrVar4, com.bytedance.sdk.component.ny.xr.d dVar) {
        JSONObject jSONObject;
        int i2;
        JSONObject jSONObject2;
        com.bytedance.sdk.openadsdk.core.nw.xr xrVar5 = xrVar4;
        if (xrVar == null) {
            return;
        }
        if (xrVar.x()) {
            try {
                com.bytedance.sdk.openadsdk.core.cv.ms msVarMs = ms(dVar);
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strD = xrVar.d();
                xrVar5.ms(strD);
                if (LogAdapter.f4121ms != null) {
                    LogAdapter.f4121ms.d("NetApiImpl", "response:");
                    LogAdapter.f4121ms.d("NetApiImpl", strD);
                }
                JSONObject jSONObject3 = new JSONObject(strD);
                int iOptInt = jSONObject3.optInt(com.tapsdk.tapad.internal.tracker.experiment.h.f.z);
                String strOptString = new JSONObject(xrVar2.nw()).optString("auction_price");
                int i3 = 20000;
                try {
                    if (iOptInt != 20000) {
                        if (iOptInt == 40046) {
                            xrVar5.ms(iOptInt);
                            xrVar3.ms(40046, ny.ms(iOptInt), xrVar5);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("adms");
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObject4 = new JSONObject(jSONObjectOptJSONObject.optString(itKeys.next()));
                        jSONObject4.put("auction_price", strOptString);
                        JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.core.ah.c.ms(jSONObject4, false, true);
                        if (jSONObjectMs == null) {
                            ms(xrVar3, xrVar4);
                            return;
                        }
                        ms msVarMs2 = ms.ms(jSONObjectMs, xrVar2, eVar);
                        xrVar5.ms(msVarMs2.ch);
                        if (msVarMs2.d != i3) {
                            xrVar5.ms(msVarMs2.d);
                            StringBuilder sb = new StringBuilder();
                            sb.append("reason: ").append(msVarMs2.c).append("  message: ").append(msVarMs2.ka);
                            xrVar3.ms(msVarMs2.d, sb.toString(), xrVar5);
                            return;
                        }
                        if (msVarMs2.x == null) {
                            ms(xrVar3, xrVar4);
                            return;
                        }
                        msVarMs2.x.ms(jSONObjectMs);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (eVar != 0) {
                            try {
                                jSONObject = jSONObjectOptJSONObject;
                                i2 = 20000;
                                jSONObject2 = jSONObjectMs;
                                ms(xrVar4, msVarMs.ny() - eVar.ab, msVarMs2.f3226ms, jCurrentTimeMillis - msVarMs.ny(), jCurrentTimeMillis2 - jCurrentTimeMillis);
                            } catch (Throwable th) {
                                th = th;
                                com.bytedance.sdk.component.utils.sl.ah("NetApiImpl", "get ad error: ", th);
                                ms(xrVar3, xrVar4);
                                return;
                            }
                        } else {
                            jSONObject = jSONObjectOptJSONObject;
                            jSONObject2 = jSONObjectMs;
                            i2 = i3;
                        }
                        xrVar3.ms(msVarMs2.x, xrVar4);
                        com.bytedance.sdk.openadsdk.xr.xr.ms().ms(jSONObject2);
                        jSONObjectOptJSONObject = jSONObject;
                        xrVar5 = xrVar4;
                        strOptString = strOptString;
                        i3 = i2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            int iMs = xrVar.ms();
            String strXr = xrVar.xr();
            xrVar5.ms(iMs);
            xrVar3.ms(iMs, strXr, xrVar5);
        }
    }

    public void ka(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final e eVar, final int i, yu.xr xrVar2) {
        final com.bytedance.sdk.openadsdk.core.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.ms.ms(xrVar2);
        com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("bid_p_f") { // from class: com.bytedance.sdk.openadsdk.core.op.23
            @Override // java.lang.Runnable
            public void run() {
                op.this.ms(xrVar, eVar, i, msVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    private void ms(com.bytedance.sdk.component.ny.xr xrVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar2, int i, e eVar, yu.xr xrVar3, com.bytedance.sdk.openadsdk.core.nw.xr xrVar4) {
        if (xrVar != null) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(xrVar.d()).optJSONArray("ads");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    if (xrVar3 != null) {
                        xrVar3.ms(-9, ny.ms(-9), xrVar4);
                        return;
                    }
                    return;
                }
                int iG = re.xr().g();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.getJSONObject(i2).optJSONObject("creative");
                    if (jSONObjectOptJSONObject != null) {
                        JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.core.ah.c.ms(new JSONObject(jSONObjectOptJSONObject.optString("adm")), false, true);
                        if (jSONObjectMs == null && xrVar3 != null) {
                            xrVar3.ms(-9, ny.ms(-9), xrVar4);
                        } else {
                            ms msVarMs = ms.ms(jSONObjectMs, xrVar2, eVar);
                            com.bytedance.sdk.openadsdk.core.jw.ka.ms(msVarMs.x, i, iG);
                            if (xrVar3 != null) {
                                xrVar3.ms(msVarMs.x, xrVar4);
                            }
                        }
                    } else if (xrVar3 != null) {
                        xrVar3.ms(-9, ny.ms(-9), xrVar4);
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                if (xrVar3 != null) {
                    xrVar3.ms(-9, ny.ms(-9), xrVar4);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ah(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final e eVar, final int i, yu.xr xrVar2) {
        final com.bytedance.sdk.openadsdk.core.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.ms.ms(xrVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("bid_g_m") { // from class: com.bytedance.sdk.openadsdk.core.op.24
                @Override // java.lang.Runnable
                public void run() {
                    op.this.ms(xrVar, eVar, i, msVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            ms(xrVar, eVar, i, msVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    private com.bytedance.sdk.openadsdk.core.cv.ms ms(com.bytedance.sdk.component.ny.xr.d dVar) {
        try {
            Object obj = dVar.ah().get("load_time_model");
            if (obj instanceof com.bytedance.sdk.openadsdk.core.cv.ms) {
                com.bytedance.sdk.openadsdk.core.cv.ms msVar = (com.bytedance.sdk.openadsdk.core.cv.ms) obj;
                msVar.ah(true);
                return msVar;
            }
        } catch (Throwable unused) {
        }
        return new com.bytedance.sdk.openadsdk.core.cv.ms();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to calculate best type for var: r10v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v3 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r10v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v3 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r10v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v4 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r10v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v5 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r27v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r27v0 'this'  ??, new type: com.bytedance.sdk.openadsdk.core.op
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v0 ??, new type: com.bytedance.sdk.openadsdk.core.cv.ms
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v0 ??, new type: com.bytedance.sdk.openadsdk.core.cv.ms
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r27v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r27v0 'this'  ??, new type: com.bytedance.sdk.openadsdk.core.op
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v3 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public void ms(com.bytedance.sdk.component.ny.xr.d r28, com.bytedance.sdk.component.ny.xr r29, com.bytedance.sdk.openadsdk.core.nw.xr r30, com.bytedance.sdk.openadsdk.core.yu.xr r31, com.bytedance.sdk.openadsdk.ao.xr.ah.xr r32, com.bytedance.sdk.openadsdk.core.nw.e r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.op.ms(com.bytedance.sdk.component.ny.xr.d, com.bytedance.sdk.component.ny.xr, com.bytedance.sdk.openadsdk.core.nw.xr, com.bytedance.sdk.openadsdk.core.yu$xr, com.bytedance.sdk.openadsdk.ao.xr.ah.xr, com.bytedance.sdk.openadsdk.core.nw.e, int, int):void");
    }

    private void ms(e eVar, lm lmVar, String str, com.bytedance.sdk.openadsdk.core.cv.ms msVar) {
        long jXr;
        long j;
        if (re.xr().vm() && msVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (eVar != null) {
                try {
                    if (eVar.ab > 0) {
                        jSONObject.put("client_start_time", msVar.ny() - eVar.ab);
                        jXr = msVar.xr() - eVar.ab;
                    } else {
                        jXr = 0;
                    }
                    if (eVar.x > 0) {
                        jSONObject.put("real_user_duration", msVar.xr() - eVar.x);
                        jSONObject.put("switch_st1_time", eVar.ab - eVar.x);
                    }
                    j = jXr;
                } catch (Exception unused) {
                    return;
                }
            } else {
                j = 0;
            }
            jSONObject.put("net_send_time", msVar.ka() - msVar.ny());
            jSONObject.put("net_rcv_time", msVar.d() - msVar.ka());
            jSONObject.put("net_callback_time", msVar.c() - msVar.d());
            jSONObject.put("network_time", msVar.c() - msVar.ny());
            jSONObject.put("sever_time", msVar.ms());
            jSONObject.put("client_end_time", msVar.xr() - msVar.c());
            if (msVar.ch() > 0) {
                jSONObject.put("req_body_length", msVar.ch());
            }
            if (msVar.x() > 0) {
                jSONObject.put("res_body_length", msVar.x());
            }
            if (!TextUtils.isEmpty(msVar.hi())) {
                jSONObject.put("x-pglcypher", msVar.hi());
            }
            jSONObject.put("cypher_v", msVar.qv());
            jSONObject.put("armor_s", msVar.y());
            long jAh = msVar.ah();
            if (jAh > 0) {
                jSONObject.put("raw_req_length", jAh);
            }
            int i = 1;
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("net_module", com.bytedance.sdk.openadsdk.core.ah.ah.ms().c());
            if (!msVar.ab()) {
                i = 2;
            }
            jSONObject.put("has_base64", i);
            jSONObject.put("req_build_opt", com.bytedance.sdk.openadsdk.core.ah.ah.ms().ab());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.d.ms.d());
            if (msVar.ao() > 0) {
                jSONObject.put("net_whqueue", msVar.u() - msVar.zb());
                jSONObject.put("net_wtqueue", msVar.ub() - msVar.u());
                jSONObject.put("net_oconn", msVar.h() - msVar.ao());
                jSONObject.put("net_bconn", msVar.ao() - msVar.ub());
            }
            try {
                JSONObject jSONObjectMs = eVar.u.ms(-1L);
                Iterator<String> itKeys = jSONObjectMs.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, jSONObjectMs.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, str, "load_ad_time", j, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, List<com.bytedance.sdk.openadsdk.ao.xr.xr.c> list) {
        JSONObject jSONObjectXr;
        if (com.bytedance.sdk.openadsdk.core.g.ny.ms() && (jSONObjectXr = xr(xrVar, list)) != null) {
            m mVar = new m(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
            mVar.ms(com.bytedance.sdk.openadsdk.core.jw.f.ny("/api/ad/union/dislike_event/"));
            mVar.ah(jSONObjectXr, "dislike");
            mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.26
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar2) {
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                }
            });
        }
    }

    private JSONObject xr(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, List<com.bytedance.sdk.openadsdk.ao.xr.xr.c> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.umeng.ccg.a.z, "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", g.ah);
            com.bytedance.sdk.openadsdk.ub.xr.ms(this.f3196ms, jSONObject2);
            if (xrVar != null) {
                jSONObject2.put("extra", xrVar.d());
                if (xrVar.xr() == null) {
                    xrVar.ms(AdnName.OTHER);
                }
                jSONObject2.put("dislike_source", xrVar.xr());
            }
            String strMs = ms(list);
            if (strMs != null) {
                jSONObject2.put("comment", strMs);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", xr(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String ms(List<com.bytedance.sdk.openadsdk.ao.xr.xr.c> list) {
        if (list.get(0).ms().equals("0:00")) {
            return list.get(0).xr();
        }
        return null;
    }

    private JSONArray xr(List<com.bytedance.sdk.openadsdk.ao.xr.xr.c> list) {
        if (list == null || list.isEmpty()) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.ao.xr.xr.c> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().ms());
        }
        return jSONArray;
    }

    public static void ms(yu.xr xrVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
        xrVar2.ms(-1);
        xrVar.ms(-1, ny.ms(-1), xrVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(yu.ka kaVar) {
        kaVar.ms(-1, ny.ms(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(yu.d dVar) {
        dVar.ms(-1, ny.ms(-1));
    }

    private JSONObject ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, int i) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            ms(jSONObject, "keywords", ch.ub().re());
            jSONObject.put("protection_of_minors", ch.ub().k());
            if (!com.bytedance.sdk.openadsdk.core.ah.d.ms().ab(i)) {
                com.bytedance.sdk.openadsdk.ub.xr.d(this.f3196ms, jSONObject);
            }
            String strXr = xr(xrVar);
            String strMs = com.bytedance.sdk.openadsdk.core.ah.d.ms().ms(xrVar.d(), "");
            if (!TextUtils.isEmpty(strMs)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(Common.System.NAME, "dynamic_slot_ab_extra");
                jSONObject2.putOpt(com.anythink.core.common.e.f.a.d, strMs);
                if (TextUtils.isEmpty(strXr)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(strXr);
                }
                jSONArray.put(jSONObject2);
                String string = jSONArray.toString();
                if (!TextUtils.equals("[]", string)) {
                    ms(jSONObject, "data", string);
                }
            } else if (!TextUtils.equals("[]", strXr)) {
                ms(jSONObject, "data", strXr);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONArray ms(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put(Common.System.NAME, "can_use_sensor");
                jSONObject.put(com.anythink.core.common.e.f.a.d, str);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
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

    private static String xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        String strAh = ah(xrVar);
        Map<String, Object> mapYu = ch.ub().yu();
        if (mapYu != null && !mapYu.isEmpty()) {
            try {
                JSONArray jSONArray = TextUtils.isEmpty(strAh) ? new JSONArray() : new JSONArray(strAh);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(Common.System.NAME) : "";
                    if (!TextUtils.isEmpty(strOptString) && mapYu.containsKey(strOptString)) {
                        mapYu.remove(strOptString);
                    }
                }
                for (Map.Entry<String, Object> entry : mapYu.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Common.System.NAME, entry.getKey());
                        jSONObject.put(com.anythink.core.common.e.f.a.d, entry.getValue());
                        jSONArray.put(jSONObject);
                    }
                }
                return ms(jSONArray).toString();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
        return strAh;
    }

    private static JSONArray xr(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.equals("0", str)) {
                jSONObject = new JSONObject();
                jSONObject.put(Common.System.NAME, "is_shake_ads");
                jSONObject.put(com.anythink.core.common.e.f.a.d, "0");
                ch.ub().xr("0");
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
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return jSONArray;
        }
    }

    private static String ms(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            JSONArray jSONArrayXr = xr(ms((JSONArray) null, str2), str2);
            if (jSONArrayXr == null) {
                return null;
            }
            return jSONArrayXr.toString();
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals(jSONObjectOptJSONObject.optString(Common.System.NAME), "is_shake_ads")) {
                    if (TextUtils.equals("0", str2)) {
                        jSONObjectOptJSONObject.put(com.anythink.core.common.e.f.a.d, "0");
                        ch.ub().xr("0");
                    } else {
                        ch.ub().xr(jSONObjectOptJSONObject.optString(com.anythink.core.common.e.f.a.d));
                    }
                    z = true;
                }
            }
            if (!z) {
                jSONArray = xr(jSONArray, str2);
            }
            JSONArray jSONArrayMs = ms(jSONArray, str2);
            return jSONArrayMs == null ? str : jSONArrayMs.toString();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return str;
        }
    }

    private static String ah(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        String strW = ch.ub().w();
        String strC = ch.ub().c();
        ch.ub().xr((String) null);
        String strB = xrVar != null ? xrVar.b() : null;
        if (TextUtils.isEmpty(strW)) {
            return ms(strB, strC);
        }
        try {
            if (!TextUtils.isEmpty(strW) && strW.contains("game_adapter_did")) {
                strW = ms(new JSONArray(strW)).toString();
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        if (TextUtils.isEmpty(strB)) {
            return ms(strW, strC);
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(strB);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString(Common.System.NAME, null);
                    if (TextUtils.equals("is_shake_ads", strOptString)) {
                        if (TextUtils.equals(strC, "0")) {
                            jSONObject.put(com.anythink.core.common.e.f.a.d, "0");
                            ch.ub().xr("0");
                        } else {
                            ch.ub().xr(jSONObject.optString(com.anythink.core.common.e.f.a.d));
                        }
                        z = true;
                    }
                    hashSet.add(strOptString);
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strW);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String strOptString2 = jSONObject2.optString(Common.System.NAME, null);
                        if (!hashSet.contains(strOptString2)) {
                            if (TextUtils.equals("is_shake_ads", strOptString2)) {
                                if (TextUtils.equals(strC, "0")) {
                                    jSONObject2.put(com.anythink.core.common.e.f.a.d, "0");
                                    ch.ub().xr("0");
                                } else {
                                    ch.ub().xr(jSONObject2.optString(com.anythink.core.common.e.f.a.d));
                                }
                                z = true;
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (!z) {
                    jSONArray = xr(jSONArray, strC);
                }
                return ms(ms(jSONArray), strC).toString();
            } catch (Throwable unused) {
                return ms(strB, strC);
            }
        } catch (Throwable unused2) {
            return ms(strW, strC);
        }
    }

    private static JSONArray ms(JSONArray jSONArray) throws JSONException {
        if (g.c() && jSONArray != null && jSONArray.length() != 0) {
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
        }
        return jSONArray;
    }

    private void ms(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, int i, e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", xrVar.d());
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, xrVar.y());
            jSONObject.put("show_seq", xrVar.qv());
            jSONObject.put("adtype", i);
            jSONObject.put("themeStatus", ch.ub().l());
            jSONObject.put(com.anythink.core.common.e.g.a.l, 0);
            if (!TextUtils.isEmpty(xrVar.ms()) || !TextUtils.isEmpty(xrVar.xr()) || !TextUtils.isEmpty(xrVar.ah()) || com.bytedance.sdk.openadsdk.tools.xr.ms()) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(xrVar.ms())) {
                    jSONObject2.put("ad_id", xrVar.ms());
                }
                if (!TextUtils.isEmpty(xrVar.xr())) {
                    jSONObject2.put("creative_id", xrVar.xr());
                }
                if (xrVar.ah() != null) {
                    jSONObject2.put("ext", xrVar.ah());
                }
                com.bytedance.sdk.openadsdk.tools.xr.ms(jSONObject2, xrVar.d());
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (com.bytedance.sdk.openadsdk.tools.xr.ms() && ch.ub().vm()) {
                com.bytedance.sdk.openadsdk.tools.xr.xr(jSONObject, xrVar.d());
            }
            ch.d dVarSk = ch.ub().sk();
            if (dVarSk != null && com.bytedance.sdk.openadsdk.core.jw.f.ch().equals("com.pangolin_demo.toutiao")) {
                dVarSk.ms(jSONObject);
            }
            int iSl = 1;
            if (i == 3 || i == 4) {
                if (eVar != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("publisher_timeout_control", eVar.ny);
                    jSONObject3.put("time_out_control", eVar.ch);
                    jSONObject3.put("time_out", eVar.hi);
                    jSONObject.put("tmax", jSONObject3);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (eVar != null) {
                jSONObject.put("render_method", eVar.c);
                if (eVar.c == 1) {
                    if (d(xrVar)) {
                        ms(i, jSONObject);
                    } else {
                        ms(jSONObject, "accepted_size", xrVar.c(), xrVar.ab());
                    }
                } else if (eVar.c == 2) {
                    if (xrVar.x() <= 0.0f || xrVar.ny() <= 0.0f) {
                        if (d(xrVar)) {
                            ms(i, jSONObject);
                        } else {
                            ms(jSONObject, "accepted_size", xrVar.c(), xrVar.ab());
                        }
                    } else {
                        ms(jSONObject, "accepted_size", com.bytedance.sdk.openadsdk.core.jw.ul.ah(this.f3196ms, xrVar.x()), com.bytedance.sdk.openadsdk.core.jw.ul.ah(this.f3196ms, xrVar.ny()));
                    }
                }
            } else {
                jSONObject.put("render_method", 1);
                ms(jSONObject, "accepted_size", xrVar.c(), xrVar.ab());
            }
            jSONObject.put("ptpl_ids", com.bytedance.sdk.openadsdk.core.ah.xr.ms().ms(xrVar.d(), i));
            jSONObject.put("ptpl_ids_v3", com.bytedance.sdk.openadsdk.core.ah.xr.ms().xr(xrVar.d(), i));
            jSONObject.put("pos", com.bytedance.sdk.openadsdk.core.jw.f.ka(i));
            jSONObject.put("is_support_dpl", xrVar.ch());
            jSONObject.put("if_support_render_control", xrVar.hi() ? 1 : 0);
            jSONObject.put("support_icon_style", (g.xr < 5900 || !xrVar.yu()) ? 0 : 1);
            if (i == 3 || i == 4) {
                jSONObject.put("splash_load_type", re.xr().ny(com.bytedance.sdk.openadsdk.core.jw.f.xr(xrVar)));
            }
            if (i == 1 || i == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (eVar != null && eVar.sl != null) {
                jSONObject.put("session_params", eVar.sl);
            }
            int iSl2 = xrVar.sl();
            if (i == 7) {
                if (com.bytedance.sdk.openadsdk.core.nw.of.ms()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.nw.of.ka());
                }
                if (com.bytedance.sdk.openadsdk.core.nw.of.ah()) {
                    jSONObject.put("refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.nw.of.ab());
                }
                if (com.bytedance.sdk.openadsdk.core.nw.of.d()) {
                    jSONObject.put("force_refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.nw.of.ab());
                }
                iSl2 = 1;
            }
            if (i == 8) {
                boolean zAo = re.xr().ao(xrVar.d());
                boolean zMs = com.bytedance.sdk.openadsdk.core.u.d.ms(xrVar.d());
                if (!zAo) {
                    jSONObject.put("refresh_control", 0);
                } else if (zMs) {
                    jSONObject.put("refresh_control", 0);
                    com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.2
                        @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                        public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("cid", "");
                            } catch (JSONException e) {
                                com.bytedance.sdk.component.utils.sl.ms(e);
                            }
                            return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("refresh_max").xr(jSONObject4.toString());
                        }
                    }, "refresh_max");
                } else {
                    jSONObject.put("refresh_control", 1);
                    jSONObject.put("refresh_ad_req_num", re.xr().cj());
                }
                if (com.bytedance.sdk.openadsdk.core.nw.of.xr()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.nw.of.c());
                }
            } else {
                iSl = iSl2;
            }
            if (eVar != null && eVar.ka != null) {
                iSl = xrVar.sl();
            }
            jSONObject.put("ad_count", iSl);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void ms(int i, JSONObject jSONObject) {
        if (xr(i)) {
            ms(jSONObject, "accepted_size", com.bytedance.sdk.openadsdk.core.jw.ul.d(this.f3196ms), com.bytedance.sdk.openadsdk.core.jw.ul.ka(this.f3196ms));
        } else {
            ms(jSONObject, "accepted_size", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private boolean d(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        return xrVar != null && xrVar.ab() == 320 && xrVar.c() == 640;
    }

    private void ms(JSONObject jSONObject, String str, int i, int i2) {
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

    private void ms(JSONObject jSONObject, String str, float f, float f2) {
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

    public static class ms {
        final String ab;
        final long ah;
        final int c;
        final ArrayList<Integer> ch;
        final int d;
        final String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final int f3226ms;
        final String ny;
        public final com.bytedance.sdk.openadsdk.core.nw.ms x;
        final long xr;

        private ms(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.nw.ms msVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.f3226ms = i;
            this.d = i2;
            this.ka = str2;
            this.ab = str3;
            this.x = msVar;
            this.ny = str;
            this.c = i3;
            this.xr = j;
            this.ah = j2;
            this.ch = arrayList;
        }

        public static ms ms(JSONObject jSONObject) {
            return ms(jSONObject, null, null);
        }

        public static ms ms(JSONObject jSONObject, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar) {
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt(com.tapsdk.tapad.internal.tracker.experiment.h.f.z);
            String strOptString2 = jSONObject.optString(com.anythink.basead.c.b.a.f);
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt(MediationConstant.KEY_REASON);
            Pair<com.bytedance.sdk.openadsdk.core.nw.ms, ArrayList<Integer>> pairMs = com.bytedance.sdk.openadsdk.core.ms.ms(jSONObject, xrVar, eVar, jOptLong2);
            if (pairMs != null && pairMs.first != null) {
                ((com.bytedance.sdk.openadsdk.core.nw.ms) pairMs.first).ms(jSONObject.optLong("request_after"));
            }
            if (pairMs == null) {
                return new ms(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
            }
            return new ms(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.bytedance.sdk.openadsdk.core.nw.ms) pairMs.first, jOptLong, jOptLong2, (ArrayList) pairMs.second);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(JSONObject jSONObject, final yu.ka kaVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            if (kaVar != null) {
                kaVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || kaVar == null) {
                return;
            }
            m mVar = new m(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
            mVar.ms(com.bytedance.sdk.openadsdk.core.jw.f.ny("/api/ad/union/sdk/reward_video/reward/"));
            mVar.ah(jSONObject, "verify");
            mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.3
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    if (xrVar != null) {
                        if (xrVar.x()) {
                            try {
                                Pair<Boolean, JSONObject> pairMs = com.bytedance.sdk.openadsdk.core.ah.c.ms(xrVar, "verify", false);
                                d dVarMs = d.ms(pairMs.second != null ? (JSONObject) pairMs.second : new JSONObject(xrVar.d()));
                                if (dVarMs.f3225ms != 20000) {
                                    kaVar.ms(dVarMs.f3225ms, ny.ms(dVarMs.f3225ms));
                                    return;
                                } else if (dVarMs.ah == null) {
                                    op.this.ms(kaVar);
                                    return;
                                } else {
                                    kaVar.ms(dVarMs);
                                    return;
                                }
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.sl.ms(e);
                            }
                        } else {
                            String strMs = ny.ms(-2);
                            int iMs = xrVar.ms();
                            if (!xrVar.x() && !TextUtils.isEmpty(xrVar.xr())) {
                                strMs = xrVar.xr();
                            }
                            kaVar.ms(iMs, strMs);
                            return;
                        }
                    }
                    op.this.ms(kaVar);
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                    kaVar.ms(-2, iOException.getMessage());
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(JSONObject jSONObject, final yu.d dVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            if (dVar != null) {
                dVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || dVar == null) {
                return;
            }
            JSONObject jSONObjectMs = com.bytedance.sdk.component.utils.ms.ms(jSONObject);
            com.bytedance.sdk.component.ny.xr.ka kaVarXr = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
            kaVarXr.ms(com.bytedance.sdk.openadsdk.core.jw.f.ny("/api/ad/union/sdk/reward_video/live_room/reward"));
            kaVarXr.ah(jSONObjectMs.toString());
            kaVarXr.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.4
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar2, com.bytedance.sdk.component.ny.xr xrVar) {
                    if (xrVar != null) {
                        if (xrVar.x() && !TextUtils.isEmpty(xrVar.d())) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(xrVar.d());
                                String strAh = jSONObject2.optInt("cypher", -1) == 3 ? com.bytedance.sdk.component.utils.ms.ah(jSONObject2.optString("message")) : null;
                                if (!TextUtils.isEmpty(strAh)) {
                                    try {
                                        jSONObject2 = new JSONObject(strAh);
                                    } catch (Throwable unused) {
                                    }
                                }
                                ah ahVarMs = ah.ms(jSONObject2);
                                if (ahVarMs.f3224ms != 20000) {
                                    dVar.ms(ahVarMs.f3224ms, ny.ms(ahVarMs.f3224ms));
                                    return;
                                } else if (ahVarMs.ah == null) {
                                    op.this.ms(dVar);
                                    return;
                                } else {
                                    dVar.ms(ahVarMs);
                                    return;
                                }
                            } catch (JSONException e) {
                                com.bytedance.sdk.component.utils.sl.ms(e);
                            }
                        } else {
                            String strMs = ny.ms(-2);
                            int iMs = xrVar.ms();
                            if (!xrVar.x() && !TextUtils.isEmpty(xrVar.xr())) {
                                strMs = xrVar.xr();
                            }
                            dVar.ms(iMs, strMs);
                            return;
                        }
                    }
                    op.this.ms(dVar);
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar2, IOException iOException) {
                    dVar.ms(-2, iOException.getMessage());
                }
            });
        }
    }

    public static class d {
        public final vl ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final int f3225ms;
        public final boolean xr;

        private d(int i, boolean z, vl vlVar) {
            this.f3225ms = i;
            this.xr = z;
            this.ah = vlVar;
        }

        public static d ms(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            vl vlVar = new vl();
            if (jSONObjectOptJSONObject != null) {
                try {
                    vlVar.ms(jSONObjectOptJSONObject.optInt(MediationConstant.KEY_REASON));
                    vlVar.xr(jSONObjectOptJSONObject.optInt("corp_type"));
                    vlVar.ah(jSONObjectOptJSONObject.optInt("reward_amount"));
                    vlVar.ms(jSONObjectOptJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                }
            }
            return new d(iOptInt, zOptBoolean, vlVar);
        }
    }

    public static class ah {
        public final il ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final int f3224ms;
        public final String xr;

        private ah(int i, String str, il ilVar) {
            this.f3224ms = i;
            this.xr = str;
            this.ah = ilVar;
        }

        public static ah ms(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString("message");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            il ilVar = new il();
            if (jSONObjectOptJSONObject != null) {
                try {
                    ilVar.ms(jSONObjectOptJSONObject.optBoolean("is_open"));
                    ilVar.ms(jSONObjectOptJSONObject.optString("req_id"));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                }
            }
            return new ah(iOptInt, strOptString, ilVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c1 A[PHI: r13
      0x00c1: PHI (r13v10 java.lang.String) = (r13v9 java.lang.String), (r13v14 java.lang.String) binds: [B:32:0x00a4, B:37:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.openadsdk.core.yu
    public String ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z, int i) {
        int iT;
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        e eVar = new e();
        w wVar = eVar.u;
        if (3 == xrVar.t()) {
            eVar.ab = System.currentTimeMillis();
        }
        if (z) {
            eVar.c = 2;
        }
        if (1 == xrVar.ao() || 2 == xrVar.ao()) {
            eVar.c = 2;
        }
        if (eVar.c != 2 && re.xr().ch(xrVar.d())) {
            eVar.c = 2;
        }
        if (xrVar.t() > 0) {
            iT = xrVar.t();
        } else {
            iT = i > 0 ? i : 0;
        }
        JSONObject jSONObjectMs = ms(xrVar, eVar, iT, true, 4);
        wVar.xr("adbody_time");
        ms(xrVar, eVar, iT);
        wVar.xr("prefetch_time");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("User-Agent", com.bytedance.sdk.openadsdk.core.jw.f.ab());
            wVar.xr("request_headers_time");
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("bid_request", jSONObjectMs);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        Pair<Integer, JSONObject> pairMs = com.bytedance.sdk.openadsdk.core.ah.c.ms().ms(jSONObject.toString(), true);
        wVar.xr("encry_time");
        try {
            com.bytedance.sdk.openadsdk.core.t.u.ms().ms(i, wVar);
        } catch (Throwable unused) {
        }
        String strOptString = "";
        if (pairMs == null) {
            iIntValue = 3;
        } else {
            strOptString = pairMs.second != null ? ((JSONObject) pairMs.second).optString("message") : "";
            if (pairMs.first != null) {
                iIntValue = ((Integer) pairMs.first).intValue();
            } else {
                iIntValue = 3;
            }
        }
        if (iIntValue != 3) {
            return "0000000004".concat(String.valueOf(strOptString));
        }
        return "0000000003".concat(String.valueOf(strOptString));
    }

    private boolean ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i) {
        boolean zMs = re.xr().ms(xrVar.d());
        if (zMs) {
            ka(xrVar, eVar, i, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.op.5
                @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                public void ms(int i2, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                    com.bytedance.sdk.openadsdk.core.t.u.ms().ms(i2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                    com.bytedance.sdk.openadsdk.core.t.u.ms().ms(0);
                }
            });
        }
        return zMs;
    }

    private void ms(boolean z, JSONObject jSONObject, String str) throws Exception {
        String strMs = com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms().ms(z, str);
        String strOptString = "0";
        String str2 = null;
        if (strMs != null && !TextUtils.isEmpty(strMs)) {
            if (TextUtils.equals(strMs, "0")) {
                str2 = "0";
            } else if (TextUtils.equals(strMs, "1")) {
                str2 = "1";
            } else {
                JSONObject jSONObject2 = new JSONObject(strMs);
                jSONObject.putOpt("cache_info", jSONObject2);
                strOptString = jSONObject2.optString("req_id");
            }
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().ms(str, strOptString, str2, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public String ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        return ms(xrVar, false, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(String str, String str2, final yu.ms msVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            if (msVar != null) {
                msVar.ms(false, -1L, 0L);
                return;
            }
            return;
        }
        if (str == null || str2 == null || msVar == null) {
            return;
        }
        JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.core.ka.xr.d.ms(str, str2);
        m mVar = new m(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
        String strNy = com.bytedance.sdk.openadsdk.core.jw.f.ny("/api/ad/union/sdk/material/check/");
        try {
            if (TextUtils.isEmpty(new URL(strNy).getQuery())) {
                strNy = strNy + "?abort_aes=1";
            } else {
                strNy = strNy + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        mVar.ms(strNy);
        mVar.ah(jSONObjectMs, "check_ad");
        mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.6
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                if (xrVar != null) {
                    long j = -1;
                    if (xrVar.x()) {
                        boolean z = false;
                        if (xrVar.d() != null) {
                            try {
                                xr xrVarMs = xr.ms(new JSONObject(xrVar.d()));
                                j = xrVarMs.f3227ms;
                                z = xrVarMs.xr;
                            } catch (JSONException e2) {
                                com.bytedance.sdk.component.utils.sl.ms(e2);
                            }
                        }
                        msVar.ms(z, j, xrVar.ny());
                        return;
                    }
                    msVar.ms(false, xrVar.ms() != 0 ? xrVar.ms() : -1L, xrVar.ny());
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                msVar.ms(false, 0L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(List<com.bytedance.sdk.openadsdk.core.ka.xr.d> list, final com.bytedance.sdk.openadsdk.core.ka.xr.xr xrVar) {
        if (list == null || list.isEmpty() || xrVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.core.ka.xr.d.ms(list);
        m mVar = new m(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
        String strNy = com.bytedance.sdk.openadsdk.core.jw.f.ny("/api/ad/union/sdk/material/check_ads/");
        try {
            if (TextUtils.isEmpty(new URL(strNy).getQuery())) {
                strNy = strNy + "?abort_aes=1";
            } else {
                strNy = strNy + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        mVar.ms(strNy);
        mVar.ah(jSONObjectMs, "check_ads_nosplash");
        mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.7
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar2) {
                if (xrVar2 != null) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    long j = -1;
                    if (xrVar2.x()) {
                        com.bytedance.sdk.openadsdk.core.ka.xr.ah ahVarMs = null;
                        if (xrVar2.d() != null) {
                            try {
                                ahVarMs = com.bytedance.sdk.openadsdk.core.ka.xr.ah.ms(new JSONObject(xrVar2.d()));
                                if (ahVarMs != null) {
                                    j = ahVarMs.f2818ms;
                                }
                            } catch (JSONException e2) {
                                com.bytedance.sdk.component.utils.sl.ms(e2);
                            }
                        }
                        xrVar.ms(ahVarMs, j, jCurrentTimeMillis2);
                        return;
                    }
                    xrVar.ms(null, xrVar2.ms() != 0 ? xrVar2.ms() : -1L, jCurrentTimeMillis2);
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                xrVar.ms(null, -1L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.ka.xr.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        m mVar = new m(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
        String strNy = com.bytedance.sdk.openadsdk.core.jw.f.ny("/api/ad/union/sdk/material/cali/");
        try {
            if (TextUtils.isEmpty(new URL(strNy).getQuery())) {
                strNy = strNy + "?abort_aes=1";
            } else {
                strNy = strNy + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        mVar.ms(strNy);
        mVar.ah(jSONObject, "checkAndCorrectAd");
        mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.8
            /* JADX WARN: Code duplicated, block: B:17:0x0033 A[PHI: r5
              0x0033: PHI (r5v4 com.bytedance.sdk.openadsdk.core.ka.xr.ka) = 
              (r5v0 com.bytedance.sdk.openadsdk.core.ka.xr.ka)
              (r5v1 com.bytedance.sdk.openadsdk.core.ka.xr.ka)
              (r5v2 com.bytedance.sdk.openadsdk.core.ka.xr.ka)
             binds: [B:10:0x0023, B:16:0x0030, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar2) {
                long j;
                if (xrVar2 != null) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (xrVar2.x()) {
                        try {
                            Pair<Boolean, JSONObject> pairMs = com.bytedance.sdk.openadsdk.core.ah.c.ms(xrVar2, "checkAndCorrectAd", false);
                            com.bytedance.sdk.openadsdk.core.ka.xr.ka kaVarMs = null;
                            JSONObject jSONObject2 = pairMs.second != null ? (JSONObject) pairMs.second : null;
                            if (jSONObject2 != null) {
                                try {
                                    kaVarMs = com.bytedance.sdk.openadsdk.core.ka.xr.ka.ms(jSONObject2);
                                    if (kaVarMs != null) {
                                        j = kaVarMs.f2820ms;
                                    } else {
                                        j = -1;
                                    }
                                } catch (Exception e2) {
                                    com.bytedance.sdk.component.utils.sl.ms(e2);
                                }
                            } else {
                                j = -1;
                            }
                            xrVar.ms(kaVarMs, j, jCurrentTimeMillis2);
                            return;
                        } catch (Exception unused) {
                        }
                    }
                    xrVar.ms(null, xrVar2.ms() != 0 ? xrVar2.ms() : -1L, jCurrentTimeMillis2);
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                xrVar.ms(null, -1L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public com.bytedance.sdk.component.adexpress.ms.ah.ms ms(int i) {
        String strIh;
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVarD = null;
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            return null;
        }
        if (i == 2) {
            strIh = re.xr().oh();
        } else {
            strIh = re.xr().ih();
        }
        if (TextUtils.isEmpty(strIh)) {
            return null;
        }
        com.bytedance.sdk.component.ny.xr.ah ahVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
        ahVarAh.ms(com.bytedance.sdk.openadsdk.core.jw.jw.xr(strIh));
        com.bytedance.sdk.component.ny.xr xrVarMs = ahVarAh.ms();
        if (xrVarMs != null) {
            try {
                if (xrVarMs.x()) {
                    if (i == 2) {
                        msVarD = com.bytedance.sdk.openadsdk.core.ugeno.c.xr.ka(xrVarMs.d());
                    } else {
                        msVarD = com.bytedance.sdk.component.adexpress.ms.ah.ms.d(xrVarMs.d());
                    }
                }
            } catch (Exception unused) {
            }
        }
        return msVarD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public com.bytedance.sdk.openadsdk.core.nw.d ms(final lm lmVar, String str) {
        String strFl;
        String strZb;
        Object obj;
        if (lmVar != null) {
            strFl = lmVar.fl();
            com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = lmVar.zh();
            com.bytedance.sdk.openadsdk.core.nw.c cVarPh = lmVar.ph();
            strZb = cVarPh != null ? cVarPh.zb() : null;
            if (TextUtils.isEmpty(strZb) && kaVarZh != null) {
                strZb = kaVarZh.d();
            }
            Map<String, Object> mapOu = lmVar.ou();
            if (TextUtils.isEmpty(strZb) && mapOu != null && (obj = mapOu.get("ad_package_name")) != null) {
                strZb = obj.toString();
            }
            if (TextUtils.isEmpty(strZb)) {
                strZb = lmVar.xr;
            }
        } else {
            strFl = null;
            strZb = null;
        }
        com.bytedance.sdk.component.ny.xr.ah ahVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
        ahVarAh.ms("https://" + re.xr().zd() + "/customer/api/app/pkg_info");
        ahVarAh.ms("convert_id", strFl);
        ahVarAh.ms("package_name", strZb);
        ahVarAh.ms("download_url", com.bytedance.sdk.openadsdk.op.x.xr(str));
        String str2 = strFl + "_" + strZb + "_" + str;
        com.bytedance.sdk.openadsdk.core.nw.d dVarMs = com.bytedance.sdk.openadsdk.core.hi.ms.ms(str2);
        if (dVarMs != null) {
            return dVarMs;
        }
        final com.bytedance.sdk.component.ny.xr[] xrVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.9
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                xrVarArr[0] = xrVar;
                countDownLatch.countDown();
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(final com.bytedance.sdk.component.ny.xr.d dVar, final IOException iOException) {
                countDownLatch.countDown();
                com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.9.1
                    @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                    public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        com.bytedance.sdk.component.ny.xr.d dVar2 = dVar;
                        if (dVar2 != null) {
                            jSONObject.putOpt("net_extra", dVar2.d());
                        }
                        IOException iOException2 = iOException;
                        if (iOException2 != null) {
                            jSONObject.putOpt("io_error", iOException2.getMessage());
                        }
                        return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().x(lmVar != null ? lmVar.lx() : "").ms("pkg_info_failed").xr(jSONObject.toString());
                    }
                }, "pkg_info_failed");
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        try {
            com.bytedance.sdk.component.ny.xr xrVar = xrVarArr[0];
            if (xrVar != null && xrVar.x() && !TextUtils.isEmpty(xrVarArr[0].d()) && new JSONObject(xrVarArr[0].d()).optInt("code", -1) == 0) {
                com.bytedance.sdk.openadsdk.core.nw.d dVar = new com.bytedance.sdk.openadsdk.core.nw.d(new JSONObject(xrVarArr[0].d()));
                com.bytedance.sdk.openadsdk.core.hi.ms.ms(str2, dVar);
                return dVar;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(final ce ceVar, final String str, final String str2, final yu.ah ahVar, final int i, final long j) {
        if (ahVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("get_wlink") { // from class: com.bytedance.sdk.openadsdk.core.op.10
                @Override // java.lang.Runnable
                public void run() {
                    op.this.xr(ceVar, str, str2, ahVar, i, j);
                }
            });
        } else {
            xr(ceVar, str, str2, ahVar, i, j);
        }
    }

    private JSONObject ms(ce ceVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adv_id", ceVar.ah());
            jSONObject.put("site_id", ceVar.d());
            jSONObject.put("page_url", str);
            jSONObject.put("log_extra", str2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(ce ceVar, String str, String str2, final yu.ah ahVar, int i, long j) {
        JSONObject jSONObjectMs = ms(ceVar, str, str2);
        com.bytedance.sdk.component.ny.xr.ka kaVarXr = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
        if (i == 1) {
            kaVarXr.ms(ceVar.ab());
        } else {
            kaVarXr.ms(ceVar.ms());
        }
        kaVarXr.ms(jSONObjectMs);
        kaVarXr.ka(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.op.12
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                ahVar.ms(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, "time out!");
            }
        }, j);
        kaVarXr.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.13
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (xrVar == null) {
                    ahVar.ms(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, "response is null!");
                    return;
                }
                if (xrVar.x()) {
                    try {
                        JSONObject jSONObject = new JSONObject(xrVar.d());
                        String strOptString = jSONObject.optString("message");
                        int iOptInt = jSONObject.optInt("status", -1);
                        if (iOptInt != 200) {
                            ahVar.ms(iOptInt, strOptString);
                            return;
                        }
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                        if (jSONObjectOptJSONObject == null) {
                            ahVar.ms(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, strOptString + ", data is null!");
                            return;
                        } else {
                            ahVar.ms(jSONObjectOptJSONObject);
                            return;
                        }
                    } catch (Throwable th) {
                        ahVar.ms(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, th.getMessage());
                        return;
                    }
                }
                ahVar.ms(xrVar.ms(), xrVar.xr());
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                ahVar.ms(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(String str) {
        d(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(final JSONObject jSONObject, final yu.ah<com.bytedance.sdk.component.ny.xr> ahVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.ch.ab.ms().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.op.14
                @Override // java.lang.Runnable
                public void run() {
                    op.this.xr(jSONObject, (yu.ah<com.bytedance.sdk.component.ny.xr>) ahVar);
                }
            });
        } else {
            xr(jSONObject, ahVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(final Bridge bridge) {
        com.bytedance.sdk.component.ny.xr.ka kaVarXr = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
        kaVarXr.ms("https://" + ch.ub().zf() + "/ad_union_qa/sdk/query_config_list");
        kaVarXr.xr("x-pglcypher", "4");
        kaVarXr.xr("x-ad-sdk-version", g.ah);
        kaVarXr.xr("x-plugin-version", "6.9.2.3");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", ch.ub().t());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", g.ah);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
        } catch (Throwable unused) {
        }
        kaVarXr.ms("application/octet-stream", com.bytedance.sdk.component.panglearmor.ny.ms().ms(com.bytedance.sdk.openadsdk.core.jw.sl.ms(jSONObject.toString().getBytes(StandardCharsets.UTF_8))));
        kaVarXr.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.15
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                byte[] bArrXr;
                Bridge bridge2 = bridge;
                if (bridge2 == null || xrVar == null) {
                    op.this.ms(bridge2, -1, "response is null");
                    return;
                }
                String str = xrVar.ah().get("content-type");
                String str2 = xrVar.ah().get("x-pglcypher");
                if (TextUtils.equals(str, "application/octet-stream") || TextUtils.equals(str2, "4")) {
                    bArrXr = com.bytedance.sdk.component.panglearmor.ny.ms().xr(xrVar.ch());
                } else {
                    bArrXr = xrVar.d().getBytes();
                }
                String strXr = com.bytedance.sdk.openadsdk.core.jw.sl.xr(bArrXr);
                if (TextUtils.isEmpty(strXr)) {
                    op.this.ms(bridge, -3, "response unGzipStr is null");
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(strXr);
                    int iOptInt = jSONObject2.optInt("code", -1);
                    String strOptString = jSONObject2.optString("message");
                    if (iOptInt != 0) {
                        op.this.ms(bridge, iOptInt, strOptString);
                        return;
                    }
                    String strOptString2 = jSONObject2.optString("data");
                    if (TextUtils.isEmpty(strOptString2)) {
                        op.this.ms(bridge, iOptInt, "response data is empty");
                    } else {
                        op.this.ms(bridge, strOptString2);
                    }
                } catch (JSONException unused2) {
                    op.this.ms(bridge, -1, "response create json error");
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                op.this.ms(bridge, -2, "response onFailure");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Bridge bridge, String str) {
        if (bridge != null) {
            com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
            xrVarMs.ms(0, str);
            bridge.call(10000, xrVarMs.xr(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Bridge bridge, int i, String str) {
        if (bridge != null) {
            com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
            xrVarMs.ms(0, i);
            xrVarMs.ms(1, str);
            bridge.call(10001, xrVarMs.xr(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yu
    public void ms(final Map<String, Object> map, final Bridge bridge) {
        if (map == null || map.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.ny.xr.ka kaVarXr = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
        kaVarXr.ms("https://" + ch.ub().zf() + "/ad_union_qa/sdk/get_ad_config");
        kaVarXr.xr("x-pglcypher", "4");
        kaVarXr.xr("x-ad-sdk-version", g.ah);
        kaVarXr.xr("x-plugin-version", "6.9.2.3");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", ch.ub().t());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", g.ah);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            kaVarXr.ms("application/octet-stream", com.bytedance.sdk.component.panglearmor.ny.ms().ms(com.bytedance.sdk.openadsdk.core.jw.sl.ms(jSONObject.toString().getBytes(StandardCharsets.UTF_8))));
            kaVarXr.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.16
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    String strXr;
                    Bridge bridge2;
                    Bridge bridge3;
                    int iOptInt = -1;
                    if (xrVar == null) {
                        op.this.ms(bridge, -1, "response is null");
                        return;
                    }
                    String str = xrVar.ah().get("content-type");
                    String str2 = xrVar.ah().get("x-pglcypher");
                    String strOptString = "";
                    if (TextUtils.equals(str, "application/octet-stream") || TextUtils.equals(str2, "4")) {
                        strXr = com.bytedance.sdk.openadsdk.core.jw.sl.xr(com.bytedance.sdk.component.panglearmor.ny.ms().xr(xrVar.ch()));
                        if (TextUtils.isEmpty(strXr)) {
                            strOptString = "data is null";
                        } else {
                            if (!TextUtils.isEmpty(strXr) && (bridge2 = bridge) != null && bridge2.values() != null && TextUtils.equals((CharSequence) bridge.values().objectValue(0, String.class), "GetAdConfigImpl")) {
                                ch.ub().ms(new ch.d(map, strXr));
                            }
                            iOptInt = 0;
                        }
                    } else {
                        try {
                            JSONObject jSONObject2 = new JSONObject(xrVar.d());
                            iOptInt = jSONObject2.optInt("code");
                            String strOptString2 = jSONObject2.optString("message");
                            try {
                                strOptString = jSONObject2.optString("data");
                                if (!TextUtils.isEmpty(strOptString) && (bridge3 = bridge) != null && bridge3.values() != null && TextUtils.equals((CharSequence) bridge.values().objectValue(0, String.class), "GetAdConfigImpl")) {
                                    ch.ub().ms(new ch.d(map, strOptString));
                                }
                            } catch (JSONException unused) {
                            }
                            String str3 = strOptString;
                            strOptString = strOptString2;
                            strXr = str3;
                        } catch (JSONException unused2) {
                            strXr = "";
                        }
                    }
                    if (iOptInt == 0) {
                        op.this.ms(bridge, strXr);
                    } else {
                        op.this.ms(bridge, iOptInt, strOptString);
                    }
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                    op.this.ms(bridge, -2, "response onFailure");
                }
            });
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(JSONObject jSONObject, final yu.ah<com.bytedance.sdk.component.ny.xr> ahVar) {
        String strMs = com.bytedance.sdk.openadsdk.core.jw.f.ms("/api/ad/union/sdk/apply_coupon/v2", false);
        m mVar = new m(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
        mVar.ms(strMs);
        mVar.ah(jSONObject, "coupon_apply");
        mVar.ka(new HashMap());
        mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.17
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                yu.ah ahVar2 = ahVar;
                if (ahVar2 != null) {
                    ahVar2.ms(xrVar);
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                yu.ah ahVar2 = ahVar;
                if (ahVar2 != null) {
                    ahVar2.ms(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                }
            }
        });
    }

    private void d(String str) {
        com.bytedance.sdk.component.ny.xr.ah ahVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
        ahVarAh.ms(str);
        ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.op.18
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
            }
        });
    }

    public static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final int f3227ms;
        public final boolean xr;

        private xr(int i, boolean z) {
            this.f3227ms = i;
            this.xr = z;
        }

        public static xr ms(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new xr(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }
}
