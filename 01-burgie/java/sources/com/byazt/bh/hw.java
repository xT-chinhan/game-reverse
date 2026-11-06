package com.byazt.bh;

import android.text.TextUtils;
import com.byazt.ca.fw;
import com.byazt.ca.uc;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.vkw.nt;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import com.byazt.zq.hn;
import com.bytedance.component.sdk.annotation.DungeonFlag;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1993, 13})
public class hw {
    private boolean pr(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j2 == 0) {
            return !ls.pr(j, jCurrentTimeMillis);
        }
        return jCurrentTimeMillis - j >= j2;
    }

    public void pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("id_conf")) == null) {
            return;
        }
        try {
            hn hnVarPr = com.byazt.sd.hw.pr();
            long j = hnVarPr.getLong("last_gather_id_time", 0L);
            long jOptLong = jSONObjectOptJSONObject.optLong("delt", 0L);
            if (j > 0 && !pr(j, jOptLong)) {
                return;
            }
            String strOptString = jSONObjectOptJSONObject.optString("store");
            JSONObject jSONObjectPr = null;
            switch (jSONObjectOptJSONObject.optInt("state", 0)) {
                case 1:
                    jSONObjectPr = pr(strOptString);
                    break;
                case 2:
                    break;
                case 3:
                default:
                    return;
                case 4:
                    File file = new File(strOptString);
                    File file2 = new File(uc.pr(a.getContext(), false, null), file.getName());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    pr(file);
                    break;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("upload", 0);
            if (iOptInt > 0) {
                hnVarPr.pr("last_gather_id_time", System.currentTimeMillis());
                File file3 = new File(strOptString);
                jSONObjectPr.put("c_r", file3.canRead());
                jSONObjectPr.put("c_w", file3.canWrite());
                jSONObjectPr.put("d", strOptString);
                pr(strOptString, jSONObjectPr, iOptInt == 2);
            }
        } catch (Throwable th) {
        }
    }

    private void pr(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        pr(file2);
                    }
                }
                file.delete();
            }
        } catch (Throwable th) {
        }
    }

    private JSONObject pr(String str) throws JSONException {
        String strHw = DeviceUtils.hw();
        if (TextUtils.isEmpty(strHw)) {
            return null;
        }
        String str2 = (TextUtils.isEmpty(strHw) ? 1 : 0) + strHw;
        JSONObject jSONObjectHw = hw(str);
        if (jSONObjectHw == null) {
            jSONObjectHw = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectHw.optJSONObject("aid");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectHw.putOpt("aid", jSONObjectOptJSONObject);
        }
        String packageName = a.getContext().getPackageName();
        if (packageName == null) {
            packageName = zo.nt().ny();
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
        hw(jSONObjectHw, str);
        pr(jSONObjectOptJSONObject, str);
        return jSONObjectHw;
    }

    @DungeonFlag
    private void pr(JSONObject jSONObject, String str) {
        byte[] bArrX;
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
                    if (!TextUtils.isEmpty(strOptString) && (bArrX = x(next + "/" + strOptString)) != null) {
                        File file2 = new File(str, pr.pr(bArrX, 20));
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

    private void hw(JSONObject jSONObject, String str) {
        byte[] bArrX = x(jSONObject.toString());
        if (bArrX != null && bArrX.length > 0) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(com.byazt.mg.hw.pr(a.getContext()), new File(str).getName()));
                try {
                    fileOutputStream2.write(bArrX);
                    com.byazt.cb.hw.pr(fileOutputStream2);
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    com.byazt.cb.hw.pr(fileOutputStream);
                }
            } catch (Throwable th2) {
            }
        }
    }

    @DungeonFlag
    private JSONObject hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        JSONObject jSONObjectHn = hn(str);
        if (file.exists() && file.isDirectory() && file.canRead()) {
            HashMap map = new HashMap();
            pr(file, str, map);
            if (map.size() == 0) {
                return jSONObjectHn;
            }
            if (jSONObjectHn == null) {
                jSONObjectHn = new JSONObject();
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectHn.optJSONObject("aid");
            try {
                if (jSONObjectOptJSONObject == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObjectHn.put("aid", jSONObject);
                        jSONObjectOptJSONObject = jSONObject;
                    } catch (JSONException e) {
                        jSONObjectOptJSONObject = jSONObject;
                    }
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
            } catch (JSONException e2) {
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
                    } catch (JSONException e3) {
                    }
                }
            }
        }
        return jSONObjectHn;
    }

    private JSONObject hn(String str) {
        byte[] bArrX = fw.x(new File(com.byazt.mg.hw.pr(a.getContext()), new File(str).getName()));
        if (bArrX == null) {
            return null;
        }
        try {
            String strPr = pr(bArrX);
            if (strPr != null) {
                return new JSONObject(strPr);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private void pr(File file, String str, Map<String, Set<String>> map) {
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
                    String strPr = pr(pr.pr(absolutePath.substring(str.length() + 1)));
                    if (strPr == null) {
                        return;
                    }
                    String[] strArrSplit = strPr.split("/");
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
                } catch (JSONException e) {
                    return;
                }
            }
            for (File file2 : fileArrListFiles) {
                if (!file2.getName().startsWith("._tt_") && file2.isDirectory()) {
                    pr(file2, str, map);
                    file2.delete();
                }
            }
            return;
        }
        try {
            file.delete();
        } catch (Throwable th) {
        }
    }

    private byte[] x(String str) {
        byte[] bytes = ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(str).getBytes(StandardCharsets.UTF_8);
        if (bytes != null && bytes.length > 0) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 1);
            byteBufferAllocate.put((byte) 3);
            byteBufferAllocate.put(bytes);
            return byteBufferAllocate.array();
        }
        return null;
    }

    private String pr(byte[] bArr) throws JSONException {
        byte b = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        if (b == 3) {
            return ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(new String(bArr2));
        }
        return null;
    }

    private void pr(String str, JSONObject jSONObject, boolean z) {
        if (z || c(str)) {
            pr(str, jSONObject);
        }
    }

    private void pr(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            jSONObject = hw(str);
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
            } catch (JSONException e) {
            }
        }
        com.byazt.xk.hw.pr().hw("s_d_i_c", jSONObject);
    }

    private boolean c(String str) {
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
                    } catch (Throwable th) {
                        jLastModified = file2.lastModified();
                    }
                    if (ls.pr(jLastModified, System.currentTimeMillis())) {
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
