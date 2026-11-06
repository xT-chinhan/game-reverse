package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class zb {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile zb f709ms;
    private SharedPreferences xr = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    public static zb ms() {
        if (f709ms == null) {
            synchronized (zb.class) {
                if (f709ms == null) {
                    f709ms = new zb();
                }
            }
        }
        return f709ms;
    }

    private zb() {
    }

    public void ms(String str) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putString("ROM_LAST_".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
        editorEdit.apply();
    }

    public boolean xr(String str) {
        return !TextUtils.isEmpty(this.xr.getString("HOST_ABI_".concat(String.valueOf(str)), ""));
    }

    public boolean ah(String str) {
        boolean z = !TextUtils.equals(this.xr.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + this.xr.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
        return z;
    }

    public void d(String str) {
        String string = this.xr.getString("HOST_ABI_".concat(String.valueOf(str)), "");
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putString("HOST_ABI_".concat(String.valueOf(str)), Zeus.getHostAbi());
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
    }

    public int ka(String str) {
        int i = this.xr.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
        return i;
    }

    public void ms(String str, int i) {
        int iKa = ka(str);
        if (iKa != i) {
            SharedPreferences.Editor editorEdit = this.xr.edit();
            editorEdit.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), i);
            editorEdit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + iKa + " --> " + i);
    }

    public String c(String str) {
        String string = this.xr.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public void ms(String str, String str2) {
        String strC = c(str);
        if (!TextUtils.equals(strC, str2)) {
            SharedPreferences.Editor editorEdit = this.xr.edit();
            editorEdit.putString("HOST_IDENTITY_".concat(String.valueOf(str)), str2);
            editorEdit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str + ") " + strC + " --> " + str2);
    }

    public void ms(String str, int i, int i2, int i3) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putInt("API_MIN_" + str + "_" + i, i2);
        editorEdit.putInt("API_MAX_" + str + "_" + i, i3);
        editorEdit.apply();
    }

    public int xr(String str, int i) {
        return this.xr.getInt("API_MIN_" + str + "_" + i, 0);
    }

    public int ah(String str, int i) {
        int i2 = this.xr.getInt("API_MAX_" + str + "_" + i, Integer.MAX_VALUE);
        if (i2 == 0) {
            return Integer.MAX_VALUE;
        }
        return i2;
    }

    public void ms(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i;
        if (z) {
            editorEdit.putInt(str2, 0);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " disable=" + z);
    }

    public void ab(String str) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
    }

    public void x(String str) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.remove("UNINSTALL__".concat(String.valueOf(str)));
        editorEdit.apply();
    }

    public boolean ny(String str) {
        return this.xr.getBoolean("UNINSTALL__".concat(String.valueOf(str)), false);
    }

    public String ch(String str) {
        return this.xr.getString("IDENTITY_".concat(String.valueOf(str)), "");
    }

    public void xr(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putString("IDENTITY_".concat(String.valueOf(str)), str2);
        editorEdit.apply();
    }

    public void xr(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        String str2 = "INSTALLED_" + str + "-" + i;
        if (z) {
            editorEdit.putBoolean(str2, true);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
    }

    public boolean d(String str, int i) {
        return this.xr.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i)), false);
    }

    public void ka(String str, int i) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), i);
        editorEdit.apply();
    }

    public boolean c(String str, int i) {
        return this.xr.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", str), -1) == i;
    }

    public void ah(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putBoolean("dex_opt_state_" + str + "_" + i, z);
        editorEdit.apply();
    }

    public boolean ab(String str, int i) {
        return this.xr.getBoolean("dex_opt_state_" + str + "_" + i, false);
    }

    public boolean x(String str, int i) {
        return this.xr.getBoolean("dex_remove_state_" + str + "_" + i, false);
    }

    public void d(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putBoolean("dex_remove_state_" + str + "_" + i, z);
        editorEdit.apply();
    }

    public void ms(String str, int i, int i2) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putInt("remove_entry_flag_" + str + "_" + i, i2);
        editorEdit.apply();
    }

    public int ny(String str, int i) {
        return this.xr.getInt("remove_entry_flag_" + str + "_" + i, 0);
    }

    public void ms(String str, int i, String str2) {
        int iXr = xr(str, i, str2);
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, iXr + 1);
        editorEdit.apply();
    }

    public int xr(String str, int i, String str2) {
        return this.xr.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, 0);
    }

    public void ah(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strMs = c.ms(str);
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putString("ALIAS_".concat(String.valueOf(strMs)), str2);
        editorEdit.apply();
    }

    public String hi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.xr.getString("ALIAS_".concat(String.valueOf(c.ms(str))), "");
    }

    public void sl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strMs = c.ms(str);
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.remove("ALIAS_".concat(String.valueOf(strMs)));
        editorEdit.apply();
    }

    public void d(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.xr.edit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strMs = c.ms(str);
        String string = this.xr.getString("ALIAS_LAST_TIME_".concat(String.valueOf(strMs)), "");
        if (TextUtils.isEmpty(string)) {
            editorEdit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(strMs)), str2);
        } else {
            editorEdit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(strMs)), string + "_" + str2);
        }
        editorEdit.apply();
    }

    public List<String> zb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.xr.getString("ALIAS_LAST_TIME_".concat(String.valueOf(c.ms(str))), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Arrays.asList(string.split("_"));
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strMs = c.ms(str);
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.remove("ALIAS_LAST_TIME_".concat(String.valueOf(strMs)));
        editorEdit.apply();
    }
}
