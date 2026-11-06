package com.byazt.mg;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, 109})
public class w implements com.byazt.ae.vk {
    public SharedPreferences pr;

    private SharedPreferences pr() {
        Context context = TTAppContextHolder.getContext();
        if (context != null && this.pr == null) {
            String string = hw.hw(context, hw("09152a11360f011014022a1c2f1f3a1513070712"), 0).getString(hw("00000000001815"), null);
            if (TextUtils.isEmpty(string)) {
                string = hw("0a041b14330e3a1a090f");
            }
            SharedPreferences sharedPreferencesHw = hw.hw(context, string, 0);
            this.pr = sharedPreferencesHw;
            if (!sharedPreferencesHw.getBoolean("0000000000060c1e0804011a30053a1d150b10", false)) {
                pr(hw.hw(context, hw("0a041b14330e3a141f11142c3b0a1118251605"), 0), this.pr, "0000000000060c1e0804011a30053a1d150b10", true);
            }
        }
        return this.pr;
    }

    private void pr(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, String str, boolean z) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (!all.isEmpty()) {
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            Iterator<String> it = all.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object obj = all.get(next);
                if (z) {
                    next = x(next);
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

    @Override // com.byazt.ae.vk
    public void pr(String str, String str2) {
        SharedPreferences sharedPreferencesPr = pr();
        if (sharedPreferencesPr != null) {
            sharedPreferencesPr.edit().putString(str, str2).apply();
        }
    }

    @Override // com.byazt.ae.vk
    public int pr(String str, int i) {
        SharedPreferences sharedPreferencesPr = pr();
        if (sharedPreferencesPr != null) {
            return sharedPreferencesPr.getInt(str, i);
        }
        return i;
    }

    @Override // com.byazt.ae.vk
    public String hw(String str, String str2) {
        SharedPreferences sharedPreferencesPr = pr();
        if (sharedPreferencesPr != null) {
            return sharedPreferencesPr.getString(str, str2);
        }
        return str2;
    }

    @Override // com.byazt.ae.vk
    public void hw(String str, int i) {
        SharedPreferences sharedPreferencesPr = pr();
        if (sharedPreferencesPr != null) {
            sharedPreferencesPr.edit().putInt(str, i).apply();
        }
    }

    @Override // com.byazt.ae.vk
    public void pr(String str, boolean z) {
        SharedPreferences sharedPreferencesPr = pr();
        if (sharedPreferencesPr != null) {
            sharedPreferencesPr.edit().putBoolean(str, z).apply();
        }
    }

    @Override // com.byazt.ae.vk
    public void pr(String str) {
        SharedPreferences sharedPreferencesPr = pr();
        if (sharedPreferencesPr != null) {
            sharedPreferencesPr.edit().remove(str).apply();
        }
    }

    @Override // com.byazt.ae.vk
    public boolean hw(String str, boolean z) {
        SharedPreferences sharedPreferencesPr = pr();
        if (sharedPreferencesPr != null) {
            return sharedPreferencesPr.getBoolean(str, z);
        }
        return z;
    }

    private String hw(String str) {
        return new String(pr(hn(str), "zeus_key".getBytes()));
    }

    private byte[] hn(String str) {
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

    private byte[] pr(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    private String x(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return pr(pr(str.getBytes(), "zeus_key".getBytes()));
    }

    private String pr(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
