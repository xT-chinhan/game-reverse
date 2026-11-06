package com.byazt.zn;

import android.text.TextUtils;
import com.anythink.core.e.d;
import com.byazt.ehw.DeviceUtils;
import com.byazt.gwu.s;
import com.byazt.nf.rv;
import com.byazt.qp.q;
import com.byazt.tk.x;
import com.byazt.vf.k;
import com.byazt.vgx.w;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1404, 26})
public class qg {
    private boolean n(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j2 == 0) {
            return !w.n(j, jCurrentTimeMillis);
        }
        return jCurrentTimeMillis - j >= j2;
    }

    public void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectN;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("id_conf")) == null) {
            return;
        }
        try {
            s sVarN = com.byazt.ikv.n.n();
            long j = sVarN.getLong("last_gather_id_time", 0L);
            long jOptLong = jSONObjectOptJSONObject.optLong("delt", 0L);
            if (j <= 0 || n(j, jOptLong)) {
                String strOptString = jSONObjectOptJSONObject.optString("store");
                int iOptInt = jSONObjectOptJSONObject.optInt(WebLoginFragment.QUERY_KEY_ID, 0);
                if (iOptInt != 1) {
                    jSONObjectN = null;
                    if (iOptInt != 2) {
                        if (iOptInt != 4) {
                            return;
                        }
                        File file = new File(strOptString);
                        File file2 = new File(com.byazt.tk.w.n(rv.getContext(), false, null), file.getName());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        n(file);
                    }
                } else {
                    jSONObjectN = n(strOptString);
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("upload", 0);
                if (iOptInt2 > 0) {
                    sVarN.n("last_gather_id_time", System.currentTimeMillis());
                    File file3 = new File(strOptString);
                    jSONObjectN.put("c_r", file3.canRead());
                    jSONObjectN.put("c_w", file3.canWrite());
                    jSONObjectN.put(d.a, strOptString);
                    n(strOptString, jSONObjectN, iOptInt2 == 2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void n(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        n(file2);
                    }
                }
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject n(String str) throws JSONException {
        String strQg = DeviceUtils.qg();
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        String str2 = (TextUtils.isEmpty(strQg) ? 1 : 0) + strQg;
        JSONObject jSONObjectQg = qg(str);
        if (jSONObjectQg == null) {
            jSONObjectQg = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectQg.optJSONObject("aid");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectQg.putOpt("aid", jSONObjectOptJSONObject);
        }
        String packageName = rv.getContext().getPackageName();
        if (packageName == null) {
            packageName = com.byazt.vyf.s.cy().ou();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(packageName);
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectOptJSONObject.put(packageName, jSONArrayOptJSONArray);
        }
        int i = 0;
        while (true) {
            if (i >= jSONArrayOptJSONArray.length()) {
                i = -1;
                break;
            }
            if (TextUtils.equals(jSONArrayOptJSONArray.optString(i), str2)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            jSONArrayOptJSONArray.put(str2);
        }
        qg(jSONObjectQg, str);
        n(jSONObjectOptJSONObject, str);
        return jSONObjectQg;
    }

    @DungeonFlag
    private void n(JSONObject jSONObject, String str) {
        byte[] bArrQ;
        File file = new File(str);
        if (file.exists()) {
            if (!file.canWrite()) {
                return;
            }
        } else if (!file.mkdirs()) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString) && (bArrQ = q(next + "/" + strOptString)) != null) {
                        File file2 = new File(str, n.n(bArrQ, 20));
                        if (file2.isFile()) {
                            file2.delete();
                        }
                        file2.mkdirs();
                        file2.getAbsolutePath();
                    }
                }
            }
        }
    }

    private void qg(JSONObject jSONObject, String str) {
        FileOutputStream fileOutputStream;
        byte[] bArrQ = q(jSONObject.toString());
        if (bArrQ == null || bArrQ.length <= 0) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(com.byazt.qyu.qg.n(rv.getContext()), new File(str).getName()));
            try {
                fileOutputStream.write(bArrQ);
                com.byazt.wvr.qg.n(fileOutputStream);
            } catch (Throwable unused) {
                com.byazt.wvr.qg.n(fileOutputStream);
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
    }

    @DungeonFlag
    private JSONObject qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        JSONObject jSONObjectS = s(str);
        if (file.exists() && file.isDirectory() && file.canRead()) {
            HashMap map = new HashMap();
            n(file, str, map);
            if (map.size() == 0) {
                return jSONObjectS;
            }
            if (jSONObjectS == null) {
                jSONObjectS = new JSONObject();
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectS.optJSONObject("aid");
            try {
                if (jSONObjectOptJSONObject == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObjectS.put("aid", jSONObject);
                    } catch (JSONException unused) {
                    }
                    jSONObjectOptJSONObject = jSONObject;
                } else {
                    for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(entry.getKey());
                        if (jSONArrayOptJSONArray != null) {
                            Set<String> value = entry.getValue();
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                String strOptString = jSONArrayOptJSONArray.optString(i);
                                if (!TextUtils.isEmpty(strOptString)) {
                                    value.add(strOptString);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException unused2) {
            }
            for (Map.Entry<String, Set<String>> entry2 : map.entrySet()) {
                String key = entry2.getKey();
                Set<String> value2 = entry2.getValue();
                if (!TextUtils.isEmpty(key) && value2 != null && value2.size() != 0) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        Iterator<String> it = value2.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next());
                        }
                        jSONObjectOptJSONObject.put(key, jSONArray);
                    } catch (JSONException unused3) {
                    }
                }
            }
        }
        return jSONObjectS;
    }

    private JSONObject s(String str) {
        byte[] bArrQ = x.q(new File(com.byazt.qyu.qg.n(rv.getContext()), new File(str).getName()));
        if (bArrQ == null) {
            return null;
        }
        try {
            String strN = n(bArrQ);
            if (strN != null) {
                return new JSONObject(strN);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void n(File file, String str, Map<String, Set<String>> map) {
        if (file == null || !file.exists() || !file.canRead() || file.getName().startsWith("._tt_")) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                file.delete();
                String absolutePath = file.getAbsolutePath();
                if (absolutePath.length() <= str.length()) {
                    return;
                }
                try {
                    String strN = n(n.n(absolutePath.substring(str.length() + 1)));
                    if (strN == null) {
                        return;
                    }
                    String[] strArrSplit = strN.split("/");
                    if (strArrSplit.length != 2) {
                        return;
                    }
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    Set<String> hashSet = map.get(str2);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(str2, hashSet);
                    }
                    hashSet.add(str3);
                    return;
                } catch (JSONException unused) {
                    return;
                }
            }
            for (File file2 : fileArrListFiles) {
                if (!file2.getName().startsWith("._tt_") && file2.isDirectory()) {
                    n(file2, str, map);
                    file2.delete();
                }
            }
            return;
        }
        try {
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    private byte[] q(String str) {
        byte[] bytes = ((k) q.n("encrypt_service")).s(str).getBytes(StandardCharsets.UTF_8);
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 1);
        byteBufferAllocate.put((byte) 3);
        byteBufferAllocate.put(bytes);
        return byteBufferAllocate.array();
    }

    private String n(byte[] bArr) throws JSONException {
        byte b = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        if (b == 3) {
            return ((k) q.n("encrypt_service")).q(new String(bArr2));
        }
        return null;
    }

    private void n(String str, JSONObject jSONObject, boolean z) {
        if (z || l(str)) {
            n(str, jSONObject);
        }
    }

    private void n(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            jSONObject = qg(str);
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("aid");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            HashSet hashSet = new HashSet();
            int i = 0;
            while (itKeys.hasNext()) {
                i++;
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(strOptString)) {
                            hashSet.add(strOptString);
                        }
                    }
                }
            }
            try {
                jSONObject.put("size", i);
                if (!hashSet.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put("all", jSONArray);
                }
            } catch (JSONException unused) {
            }
        }
        com.byazt.eji.s.n().qg("s_d_i_c", jSONObject);
    }

    private boolean l(String str) {
        File[] fileArrListFiles;
        long jLastModified;
        File file = new File(str);
        boolean z = true;
        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (name.startsWith("._tt_")) {
                    try {
                        jLastModified = Long.parseLong(name.substring(5));
                    } catch (Throwable unused) {
                        jLastModified = file2.lastModified();
                    }
                    if (w.n(jLastModified, System.currentTimeMillis())) {
                        z = false;
                    } else {
                        file2.delete();
                    }
                }
            }
        }
        if (z) {
            new File(file, "._tt_" + System.currentTimeMillis()).mkdirs();
        }
        return z;
    }
}
