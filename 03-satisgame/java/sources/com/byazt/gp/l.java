package com.byazt.gp;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.anythink.core.common.l.f;
import com.anythink.core.e.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.constants.ErrorCode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, 18})
public final class l {
    private static String n(int i) {
        switch (i) {
            case 1001:
                return "a_p_t";
            case 1002:
                return "i_a_a";
            case 1003:
                return "i_w_c_c_a";
            case 1004:
                return "a_s";
            case 1005:
                return f.W;
            case 1006:
                return "d_c";
            case 1007:
                return "a_sc";
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                return "a_p";
            case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                return "v_d";
            case 1010:
                return "p_w";
            case 1011:
                return "p_h";
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                return "e_l";
            case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
                return "b_t";
            default:
                return null;
        }
    }

    private static String q(int i) {
        switch (i) {
            case 4001:
                return "a_p_t";
            case ErrorCode.MANIFEST_ERROR /* 4002 */:
                return "i_t";
            case ErrorCode.POSID_ERROR /* 4003 */:
                return "c";
            case ErrorCode.SPLASH_CONTAINER_INVISIBLE /* 4004 */:
                return "v_d";
            case ErrorCode.CONTAINER_SIZE_ERROR /* 4005 */:
                return "v_w";
            case ErrorCode.NATIVE_CLICK_BEFORE_EXPOSE /* 4006 */:
                return "v_h";
            case ErrorCode.DEVICE_UNSUPPORT /* 4007 */:
                return "v_c_p";
            case ErrorCode.SCREEN_ORIENTATION_ERROR /* 4008 */:
                return "v_p";
            case ErrorCode.SKIP_VIEW_SIZE_ERROR /* 4009 */:
                return "v_c_i_u";
            default:
                return null;
        }
    }

    private static String qg(int i) {
        switch (i) {
            case 2001:
                return "m_t";
            case 2002:
                return "i_t";
            case ErrorCode.NOT_INIT /* 2003 */:
                return "v_d";
            case 2004:
                return "v_w";
            case 2005:
                return "v_h";
            case 2006:
                return "a_sc";
            case 2007:
                return "a_d_c_d";
            case 2008:
                return "p_n";
            case 2009:
                return "ecpm";
            default:
                return null;
        }
    }

    private static String s(int i) {
        switch (i) {
            case ErrorCode.NETWORK_ERROR /* 3001 */:
                return "a_a_t";
            case ErrorCode.NETWORK_TIMEOUT /* 3002 */:
                return "m_t";
            case ErrorCode.NETWORK_UNREACHABLE /* 3003 */:
                return "a_m_t";
            case ErrorCode.NETWORK_SSL_HANDSHAKE /* 3004 */:
                return "s_t";
            case ErrorCode.NETWORK_HTTP_STATUS_CODE /* 3005 */:
                return "c_w";
            case 3006:
                return "c_h";
            case 3007:
                return "c_s_t";
            case 3008:
                return d.a;
            case 3009:
                return "i_a_p";
            case 3010:
                return "i_n_w_a_p";
            case 3011:
                return "r_time";
            case 3012:
                return "r_text";
            case 3013:
                return "d_s";
            case 3014:
                return "a_b_s";
            case 3015:
                return "r_i";
            default:
                return null;
        }
    }

    public static Map<String, Object> n(String str, Map map) {
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.entrySet()) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    String strN = n(str, key);
                    if (!TextUtils.isEmpty(strN) && n(value)) {
                        map2.put(strN, value);
                    }
                }
            }
        }
        return map2;
    }

    private static String n(String str, Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Number)) {
            return null;
        }
        int iIntValue = ((Number) obj).intValue();
        if (n(str, MediationConstant.ADN_GDT)) {
            return n(iIntValue);
        }
        if (n(str, MediationConstant.ADN_KS)) {
            return qg(iIntValue);
        }
        if (n(str, "baidu")) {
            return s(iIntValue);
        }
        if (n(str, MediationConstant.ADN_SIGMOB)) {
            return q(iIntValue);
        }
        return null;
    }

    private static boolean n(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            return !TextUtils.isEmpty((String) obj);
        }
        return (obj instanceof Number) || (obj instanceof Boolean);
    }

    private static boolean n(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equalsIgnoreCase(str2)) ? false : true;
    }
}
