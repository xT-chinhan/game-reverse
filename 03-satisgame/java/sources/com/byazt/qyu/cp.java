package com.byazt.qyu;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1178, 29})
public class cp implements com.byazt.ry.tj {
    public SharedPreferences n;

    private SharedPreferences n() {
        Context context = TTAppContextHolder.getContext();
        if (context != null && this.n == null) {
            String string = qg.qg(context, qg("09152a11360f011014022a1c2f1f3a1513070712"), 0).getString(qg("00000000001815"), null);
            if (TextUtils.isEmpty(string)) {
                string = qg("0a041b14330e3a1a090f");
            }
            SharedPreferences sharedPreferencesQg = qg.qg(context, string, 0);
            this.n = sharedPreferencesQg;
            if (!sharedPreferencesQg.getBoolean("0000000000060c1e0804011a30053a1d150b10", false)) {
                n(qg.qg(context, qg("0a041b14330e3a141f11142c3b0a1118251605"), 0), this.n, "0000000000060c1e0804011a30053a1d150b10", true);
            }
        }
        return this.n;
    }

    private void n(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, String str, boolean z) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (!all.isEmpty()) {
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            Iterator<String> it = all.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object obj = all.get(next);
                if (z) {
                    next = q(next);
                }
                if (obj instanceof String) {
                    editorEdit.putString(next, (String) obj);
                } else if (obj instanceof Integer) {
                    editorEdit.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    editorEdit.putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    editorEdit.putFloat(next, ((Float) obj).floatValue());
                } else if (obj instanceof Boolean) {
                    editorEdit.putBoolean(next, ((Boolean) obj).booleanValue());
                }
                editorEdit.apply();
            }
            return;
        }
        sharedPreferences2.edit().putBoolean(str, true).apply();
    }

    @Override // com.byazt.ry.tj
    public void n(String str, String str2) {
        SharedPreferences sharedPreferencesN = n();
        if (sharedPreferencesN != null) {
            sharedPreferencesN.edit().putString(str, str2).apply();
        }
    }

    @Override // com.byazt.ry.tj
    public int n(String str, int i) {
        SharedPreferences sharedPreferencesN = n();
        return sharedPreferencesN != null ? sharedPreferencesN.getInt(str, i) : i;
    }

    @Override // com.byazt.ry.tj
    public String qg(String str, String str2) {
        SharedPreferences sharedPreferencesN = n();
        return sharedPreferencesN != null ? sharedPreferencesN.getString(str, str2) : str2;
    }

    @Override // com.byazt.ry.tj
    public void qg(String str, int i) {
        SharedPreferences sharedPreferencesN = n();
        if (sharedPreferencesN != null) {
            sharedPreferencesN.edit().putInt(str, i).apply();
        }
    }

    @Override // com.byazt.ry.tj
    public void n(String str, boolean z) {
        SharedPreferences sharedPreferencesN = n();
        if (sharedPreferencesN != null) {
            sharedPreferencesN.edit().putBoolean(str, z).apply();
        }
    }

    @Override // com.byazt.ry.tj
    public void n(String str) {
        SharedPreferences sharedPreferencesN = n();
        if (sharedPreferencesN != null) {
            sharedPreferencesN.edit().remove(str).apply();
        }
    }

    @Override // com.byazt.ry.tj
    public boolean qg(String str, boolean z) {
        SharedPreferences sharedPreferencesN = n();
        return sharedPreferencesN != null ? sharedPreferencesN.getBoolean(str, z) : z;
    }

    private String qg(String str) {
        return new String(n(s(str), "zeus_key".getBytes()));
    }

    private byte[] s(String str) {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    private byte[] n(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    private String q(String str) {
        return (str == null || str.isEmpty()) ? "" : n(n(str.getBytes(), "zeus_key".getBytes()));
    }

    private String n(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
