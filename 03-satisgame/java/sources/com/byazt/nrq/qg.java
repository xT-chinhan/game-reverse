package com.byazt.nrq;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.d.i;
import com.byazt.nf.rv;
import com.byazt.tbt.cy;
import com.byazt.tbt.k;
import com.byazt.tbt.sz;
import com.byazt.tbt.tj;
import com.byazt.tk.hd;
import com.byazt.tk.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 26})
public class qg extends n {
    public static final ConcurrentLinkedDeque<String> fs = new ConcurrentLinkedDeque<>();
    public String cp;
    public long rv;
    public final String tj;

    @Override // com.byazt.nrq.n
    public void n(String str) {
    }

    public boolean q() {
        return false;
    }

    public qg(com.byazt.lew.n nVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(nVar, str, str2, jSONObject, str3, str4);
        this.tj = "index_censorship.json";
    }

    @Override // com.byazt.nrq.n
    public void n(final String str, final String str2) {
        com.byazt.eji.s.n().n("web_upload_start", new com.byazt.rs.n() { // from class: com.byazt.nrq.qg.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("cid", str);
                    jSONObject2.put("req_id", str2);
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public void n(final String str, final String str2, final long j, final String str3, final long j2, final long j3) {
        com.byazt.eji.s.n().n("web_upload_finish", new com.byazt.rs.n() { // from class: com.byazt.nrq.qg.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("cid", str);
                    jSONObject2.put("req_id", str2);
                    jSONObject2.put(MediationConstant.EXTRA_DURATION, System.currentTimeMillis() - j);
                    jSONObject2.put("weburl", str3);
                    jSONObject2.put("size", j2);
                    jSONObject2.put("avail_mem", j3);
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    @Override // com.byazt.nrq.n
    public boolean n(WebView webView) {
        if (webView == null || fs.contains(this.qg)) {
            return true;
        }
        return (this.l != null && this.l.get()) || this.n.qg().get() > 0;
    }

    @Override // com.byazt.nrq.n
    public void n(Context context, String str, com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, Map<String, Object> map) {
        int i;
        if (com.byazt.lew.q.s()) {
            String string = qgVar.n().toString();
            String strQg = tjVar.qg();
            if (TextUtils.equals(strQg.toLowerCase(), "javascript")) {
                strQg = "js";
            }
            String str2 = l.qg(string) + i.E + strQg;
            if (TextUtils.isEmpty(strQg)) {
                return;
            }
            HashMap<String, byte[]> map2 = this.n.n().get(strQg);
            if (map2 == null) {
                map2 = new HashMap<>();
                this.n.n().put(strQg, map2);
            }
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[1024];
            InputStream data = webResourceResponse.getData();
            while (true) {
                try {
                    i = 0;
                    if (data.read(bArr) == -1) {
                        break;
                    }
                    while (i < 1024) {
                        arrayList.add(Byte.valueOf(bArr[i]));
                        i++;
                    }
                } catch (Exception unused) {
                    if (data != null) {
                        try {
                            data.close();
                            return;
                        } catch (IOException unused2) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (data != null) {
                        try {
                            data.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] bArr2 = new byte[arrayList.size()];
            while (i < arrayList.size()) {
                bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
                i++;
            }
            if (arrayList.size() <= ((long) rv.qg().su()) * 1048576) {
                map2.put(str2, bArr2);
                n(this.w, str, tjVar, str2, string, qgVar.s(), map);
            }
            if (data != null) {
                try {
                    data.close();
                } catch (IOException unused4) {
                }
            }
        }
    }

    @Override // com.byazt.nrq.n
    public void n(JSONObject jSONObject, String str, tj tjVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(TapEventParamConstants.PARAM_NAME, str2);
            jSONObject2.putOpt(ImagesContract.URL, str3);
            if (map != null) {
                jSONObject2.putOpt("request_headers", new JSONObject(map));
            }
            if (tjVar != null) {
                String lowerCase = tjVar.toString().toLowerCase();
                if (lowerCase.contains("image")) {
                    n(jSONObject2, jSONObject, "sub_pic");
                    return;
                }
                if (!lowerCase.contains("js") && !lowerCase.contains("javascript")) {
                    if (lowerCase.contains("css")) {
                        n(jSONObject2, jSONObject, "css");
                        return;
                    } else {
                        if (lowerCase.contains("html")) {
                            n(jSONObject2, jSONObject, "html");
                            return;
                        }
                        return;
                    }
                }
                n(jSONObject2, jSONObject, "js");
                return;
            }
            n(jSONObject2, jSONObject, AdnName.OTHER);
        } catch (JSONException unused) {
        }
    }

    private void n(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.w.putOpt(str, jSONArray);
            } else {
                jSONArrayOptJSONArray.put(jSONObject);
                this.w.putOpt(str, jSONArrayOptJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.nrq.n
    public void n() {
        try {
            this.w.putOpt("html", new JSONArray());
            this.w.putOpt("js", new JSONArray());
            this.w.putOpt("css", new JSONArray());
            this.w.putOpt("sub_pic", new JSONArray());
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.nrq.n
    public boolean n(tj tjVar) {
        try {
            Set<String> setI = rv.qg().i();
            String str = tjVar.n().trim().toLowerCase() + "/" + tjVar.qg().trim().toLowerCase();
            new StringBuilder("contentType======>").append(setI);
            return setI.contains(str);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.byazt.nrq.n
    public void n(com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, n.InterfaceC0272n interfaceC0272n) {
        interfaceC0272n.n(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(File file, String str, Context context, long j, long j2) {
        try {
            com.byazt.euy.n.qg(str);
            if (file != null && file.exists()) {
                file.delete();
            }
            int i = com.byazt.lew.q.n.get();
            if (i > 0) {
                com.byazt.lew.q.n.decrementAndGet();
            }
            if (i == 0) {
                com.byazt.euy.n.qg(com.byazt.lew.q.qg(context));
            }
            n(this.qg, this.s, this.rv, this.x, j, j2);
        } catch (Exception unused) {
        }
    }

    private byte[] n(byte[] bArr, int i) {
        return com.byazt.cl.qg.n(bArr, i);
    }

    private String n(Context context) {
        String str = this.cp;
        if (str != null) {
            return str;
        }
        try {
            String str2 = com.byazt.lew.q.qg(context) + File.separator + this.qg;
            this.cp = str2;
            return str2;
        } catch (Exception unused) {
            return File.separator + ".lp_cache" + File.separator + this.qg;
        }
    }

    private boolean qg(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.byazt.euy.qg.n(str, str2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.byazt.nrq.n
    public void qg(Context context, String str, com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, Map<String, Object> map) {
        try {
            if (com.byazt.lew.q.s()) {
                String strN = n(context);
                String string = qgVar.n().toString();
                String strQg = tjVar.qg();
                if (TextUtils.equals(strQg.toLowerCase(), "javascript")) {
                    strQg = "js";
                }
                File file = new File(strN);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = l.qg(string) + i.E + strQg;
                File file2 = new File(strN, str2);
                if (file2.exists()) {
                    file2.delete();
                    file2.createNewFile();
                }
                file2.getAbsolutePath();
                rv.qg().su();
                if (com.byazt.euy.n.n(webResourceResponse.getData(), strN, str2, rv.qg().su())) {
                    n(this.w, str, tjVar, str2, string, qgVar.s(), map);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // com.byazt.nrq.n
    public void s() {
        if (fs.contains(this.qg)) {
            this.n.n(new Runnable() { // from class: com.byazt.nrq.qg.3
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.n(null, com.byazt.lew.q.qg(rv.getContext()), rv.getContext(), -1L, -1L);
                }
            });
        } else if (this.q.compareAndSet(false, true)) {
            this.n.n(new Runnable() { // from class: com.byazt.nrq.qg.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        qg.this.l.set(true);
                        qg.this.l();
                        qg.this.q.set(false);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0196 A[Catch: Exception -> 0x01af, LOOP:0: B:80:0x0196->B:82:0x019e, LOOP_START, TryCatch #0 {Exception -> 0x01af, blocks: (B:78:0x0192, B:80:0x0196, B:82:0x019e, B:83:0x01a2, B:85:0x01aa), top: B:90:0x0192 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x019e A[Catch: Exception -> 0x01af, LOOP:0: B:80:0x0196->B:82:0x019e, LOOP_END, TryCatch #0 {Exception -> 0x01af, blocks: (B:78:0x0192, B:80:0x0196, B:82:0x019e, B:83:0x01a2, B:85:0x01aa), top: B:90:0x0192 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01aa A[Catch: Exception -> 0x01af, TRY_LEAVE, TryCatch #0 {Exception -> 0x01af, blocks: (B:78:0x0192, B:80:0x0196, B:82:0x019e, B:83:0x01a2, B:85:0x01aa), top: B:90:0x0192 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01a2 A[EDGE_INSN: B:95:0x01a2->B:83:0x01a2 BREAK  A[LOOP:0: B:80:0x0196->B:82:0x019e], SYNTHETIC] */
    public void l() {
        long j;
        ConcurrentLinkedDeque<String> concurrentLinkedDeque;
        this.rv = System.currentTimeMillis();
        Context context = rv.getContext();
        String strN = n(context);
        if (q()) {
            return;
        }
        if (rv.qg().ry() == 1 && !hd.q(context)) {
            n(null, com.byazt.lew.q.qg(context), context, -1L, -1L);
            return;
        }
        if (!com.byazt.lew.q.s()) {
            return;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() + (runtime.maxMemory() - runtime.totalMemory());
        File file = null;
        try {
            byte[] bytes = this.w.toString().getBytes(StandardCharsets.UTF_8);
            if (rv.qg().ta() != 1 && !com.byazt.euy.n.n(new ByteArrayInputStream(bytes), strN, "index_censorship.json", -2147483648L)) {
                throw new q(false);
            }
            String strQg = com.byazt.lew.q.qg(context);
            File file2 = new File(strQg);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String str = strQg + File.separator + this.qg + "-compress.zip";
            rv.qg().ta();
            File file3 = new File(str);
            try {
                if (file3.exists()) {
                    file3.delete();
                }
                file3.createNewFile();
                String absolutePath = file3.getAbsolutePath();
                if (rv.qg().ta() == 1) {
                    HashMap<String, byte[]> map = new HashMap<>();
                    map.put("index_censorship.json", bytes);
                    this.n.n().put("index_censorship.json", map);
                    if (TextUtils.isEmpty(strN) || !com.byazt.euy.qg.n(this.n.n(), absolutePath)) {
                        throw new q(false);
                    }
                } else if (!qg(strN, absolutePath)) {
                    throw new q(false);
                }
                byte[] bArrN = com.byazt.euy.n.n(absolutePath);
                long length = (int) new File(absolutePath).length();
                try {
                    long jHa = ((long) rv.qg().ha()) * 1048576;
                    rv.qg().ha();
                    if (length > jHa) {
                        throw new q(false);
                    }
                    if (length > jFreeMemory - 1048576) {
                        throw new q(false);
                    }
                    byte[] bArrN2 = n(bArrN, (int) length);
                    if (bArrN2 != null && bArrN2.length <= jHa) {
                        if (n(bArrN2, rv.qg().g(), file3) == 200) {
                            throw new q(true, bArrN2.length);
                        }
                        throw new q(false, bArrN2.length);
                    }
                    throw new q(false, true, bArrN2 == null ? 0L : bArrN2.length);
                } catch (q e) {
                    e = e;
                    j = length;
                    file = file3;
                    try {
                        if (e.n) {
                            while (true) {
                                concurrentLinkedDeque = fs;
                                if (concurrentLinkedDeque.size() > 0) {
                                    break;
                                } else {
                                    concurrentLinkedDeque.pollLast();
                                }
                            }
                            if (!TextUtils.isEmpty(this.qg)) {
                                concurrentLinkedDeque.push(this.qg);
                            }
                        }
                    } catch (Exception unused) {
                    }
                    n(file, strN, context, j, jFreeMemory);
                } catch (IOException unused2) {
                    j = length;
                    file = file3;
                    n(file, strN, context, j, jFreeMemory);
                }
            } catch (q e2) {
                e = e2;
                file = file3;
                j = 0;
                if (e.n) {
                    while (true) {
                        concurrentLinkedDeque = fs;
                        if (concurrentLinkedDeque.size() > 0) {
                            break;
                            break;
                        }
                        concurrentLinkedDeque.pollLast();
                    }
                    if (!TextUtils.isEmpty(this.qg)) {
                        concurrentLinkedDeque.push(this.qg);
                    }
                }
                n(file, strN, context, j, jFreeMemory);
            } catch (IOException unused3) {
                file = file3;
                j = 0;
                n(file, strN, context, j, jFreeMemory);
            }
        } catch (q e3) {
            e = e3;
        } catch (IOException unused4) {
        }
    }

    private int n(byte[] bArr, int i, File file) {
        try {
            cy cyVarQg = com.byazt.mw.s.n().qg().n().n(new sz.n().qg(rv.qg().ju() + ("?aid=" + com.byazt.vyf.s.cy().ou() + "&device_platform=android&device_type=android&source_type=union")).n(k.n(tj.n("multipart/form-data"), bArr, "file", file.getName())).qg()).qg();
            if (cyVarQg.q() == 200) {
                JSONObject jSONObject = new JSONObject(cyVarQg.x().qg());
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                if (iOptInt == 0 && TextUtils.equals("success", strOptString)) {
                    return 200;
                }
                return qg(bArr, i, file);
            }
            return qg(bArr, i, file);
        } catch (Throwable th) {
            th.getMessage();
            return qg(bArr, i, file);
        }
    }

    private int qg(byte[] bArr, int i, File file) {
        if (i <= 0) {
            return -1;
        }
        return n(bArr, i - 1, file);
    }
}
