package com.bytedance.sdk.openadsdk.core.g.ms;

import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.c;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.tapsdk.tapad.constants.Constants;
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
public class xr {
    private boolean ms(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j2 == 0) {
            return !f.ms(j, jCurrentTimeMillis);
        }
        return jCurrentTimeMillis - j >= j2;
    }

    public void ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectMs;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("id_conf")) == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
            long j = xrVarMs.getLong("last_gather_id_time", 0L);
            long jOptLong = jSONObjectOptJSONObject.optLong("delt", 0L);
            if (j <= 0 || ms(j, jOptLong)) {
                String strOptString = jSONObjectOptJSONObject.optString("store");
                int iOptInt = jSONObjectOptJSONObject.optInt("state", 0);
                if (iOptInt != 1) {
                    if (iOptInt != 2) {
                        if (iOptInt != 4) {
                            return;
                        }
                        File file = new File(strOptString);
                        File file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext()), file.getName());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        ms(file);
                    }
                    jSONObjectMs = null;
                } else {
                    jSONObjectMs = ms(strOptString);
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("upload", 0);
                if (iOptInt2 == 1 || iOptInt2 == 2) {
                    xrVarMs.ms("last_gather_id_time", System.currentTimeMillis());
                    File file3 = new File(strOptString);
                    jSONObjectMs.put("c_r", file3.canRead());
                    jSONObjectMs.put("c_w", file3.canWrite());
                    jSONObjectMs.put("d", strOptString);
                    ms(strOptString, jSONObjectMs, iOptInt2 == 1);
                }
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private void ms(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        ms(file2);
                    }
                }
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject ms(String str) throws JSONException {
        String strC = t.c();
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        String str2 = (!t.ka() ? 1 : 0) + strC;
        JSONObject jSONObjectXr = xr(str);
        if (jSONObjectXr == null) {
            jSONObjectXr = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectXr.optJSONObject("aid");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectXr.putOpt("aid", jSONObjectOptJSONObject);
        }
        String packageName = re.getContext().getPackageName();
        if (packageName == null) {
            packageName = ch.ub().t();
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
        xr(jSONObjectXr, str);
        ms(jSONObjectOptJSONObject, str);
        return jSONObjectXr;
    }

    @DungeonFlag
    private void ms(JSONObject jSONObject, String str) {
        byte[] bArrD;
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
                    if (!TextUtils.isEmpty(strOptString) && (bArrD = d(next + "/" + strOptString)) != null) {
                        File file2 = new File(str, ms.ms(bArrD, 20));
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

    private void xr(JSONObject jSONObject, String str) {
        FileOutputStream fileOutputStream;
        byte[] bArrD = d(jSONObject.toString());
        if (bArrD == null || bArrD.length <= 0) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext()), new File(str).getName()));
            try {
                fileOutputStream.write(bArrD);
                com.bytedance.sdk.component.c.ah.ah.xr.ms(fileOutputStream);
            } catch (Throwable unused) {
                com.bytedance.sdk.component.c.ah.ah.xr.ms(fileOutputStream);
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
    }

    @DungeonFlag
    private JSONObject xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        JSONObject jSONObjectAh = ah(str);
        if (file.exists() && file.isDirectory() && file.canRead()) {
            HashMap map = new HashMap();
            ms(file, str, map);
            if (map.size() == 0) {
                return jSONObjectAh;
            }
            if (jSONObjectAh == null) {
                jSONObjectAh = new JSONObject();
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectAh.optJSONObject("aid");
            try {
                if (jSONObjectOptJSONObject == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObjectAh.put("aid", jSONObject);
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
                    } catch (JSONException e) {
                        sl.ms(e);
                    }
                }
            }
        }
        return jSONObjectAh;
    }

    private JSONObject ah(String str) {
        byte[] bArrD = c.d(new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext()), new File(str).getName()));
        if (bArrD == null) {
            return null;
        }
        try {
            String strMs = ms(bArrD);
            if (strMs != null) {
                return new JSONObject(strMs);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        return null;
    }

    private void ms(File file, String str, Map<String, Set<String>> map) {
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
                    String strMs = ms(ms.ms(absolutePath.substring(str.length() + 1)));
                    if (strMs == null) {
                        return;
                    }
                    String[] strArrSplit = strMs.split("/");
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
                    ms(file2, str, map);
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

    private byte[] d(String str) {
        byte[] bytes = com.bytedance.sdk.component.utils.ms.xr(str).getBytes(StandardCharsets.UTF_8);
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 1);
        byteBufferAllocate.put((byte) 3);
        byteBufferAllocate.put(bytes);
        return byteBufferAllocate.array();
    }

    private String ms(byte[] bArr) throws JSONException {
        byte b = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        if (b == 3) {
            return com.bytedance.sdk.component.utils.ms.ah(new String(bArr2));
        }
        return null;
    }

    private void ms(String str, JSONObject jSONObject, boolean z) {
        if (z || ka(str)) {
            ms(str, jSONObject);
        }
    }

    private void ms(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            jSONObject = xr(str);
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
                    jSONObject.put(Constants.e.c, jSONArray);
                }
            } catch (JSONException unused) {
            }
        }
        u.ms().ms("s_d_i_c", jSONObject);
    }

    private boolean ka(String str) {
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
                    if (f.ms(jLastModified, System.currentTimeMillis())) {
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
