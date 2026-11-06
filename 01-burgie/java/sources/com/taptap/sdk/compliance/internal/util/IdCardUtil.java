package com.taptap.sdk.compliance.internal.util;

import com.qq.e.comm.managers.setting.GlobalSetting;
import com.umeng.analytics.pro.an;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IdCardUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001b\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/compliance/internal/util/IdCardUtil;", "", "()V", "cityCode", "", "", "[Ljava/lang/String;", "power", "", "checkProvinceId", "", "provinceId", "convertCharToInt", an.aF, "", "convertIdCarBy15bit", "idCard", "getCheckCodeBySum", "sum17", "", "getPowerSum", "bit", "isDigital", "str", "isValidatedIdCard", "validate15IDCard", "idcard", "validate18Idcard", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class IdCardUtil {
    public static final IdCardUtil INSTANCE = new IdCardUtil();
    private static final String[] cityCode = {"11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82", "91"};
    private static final int[] power = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    private IdCardUtil() {
    }

    public final boolean isValidatedIdCard(String idCard) {
        if (idCard == null || Intrinsics.areEqual("", idCard)) {
            return false;
        }
        if (idCard.length() == 15) {
            return validate15IDCard(idCard);
        }
        return validate18Idcard(idCard);
    }

    public final boolean validate18Idcard(String idCard) {
        if (idCard != null && idCard.length() == 18) {
            String idCard17 = idCard.substring(0, 17);
            Intrinsics.checkNotNullExpressionValue(idCard17, "this as java.lang.String…ing(startIndex, endIndex)");
            if (!isDigital(idCard17)) {
                return false;
            }
            String provinceid = idCard.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(provinceid, "this as java.lang.String…ing(startIndex, endIndex)");
            if (!checkProvinceId(provinceid)) {
                return false;
            }
            String birthday = idCard.substring(6, 14);
            Intrinsics.checkNotNullExpressionValue(birthday, "this as java.lang.String…ing(startIndex, endIndex)");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
            try {
                Date it = sdf.parse(birthday);
                if (it != null) {
                    String tmpDate = sdf.format(it);
                    Intrinsics.checkNotNullExpressionValue(tmpDate, "sdf.format(it)");
                    if (!Intrinsics.areEqual(tmpDate, birthday)) {
                        return false;
                    }
                }
                String idCard18Code = idCard.substring(17, 18);
                Intrinsics.checkNotNullExpressionValue(idCard18Code, "this as java.lang.String…ing(startIndex, endIndex)");
                char[] c = idCard17.toCharArray();
                Intrinsics.checkNotNullExpressionValue(c, "this as java.lang.String).toCharArray()");
                int[] bit = convertCharToInt(c);
                int sum17 = getPowerSum(bit);
                String checkCode = getCheckCodeBySum(sum17);
                if (checkCode == null) {
                    return false;
                }
                return StringsKt.equals(idCard18Code, checkCode, true);
            } catch (ParseException e) {
                return false;
            }
        }
        return false;
    }

    public final boolean validate15IDCard(String idcard) {
        if (idcard != null && idcard.length() == 15 && isDigital(idcard)) {
            String provinceid = idcard.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(provinceid, "this as java.lang.String…ing(startIndex, endIndex)");
            if (!checkProvinceId(provinceid)) {
                return false;
            }
            String birthday = idcard.substring(6, 12);
            Intrinsics.checkNotNullExpressionValue(birthday, "this as java.lang.String…ing(startIndex, endIndex)");
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd", Locale.CHINA);
            try {
                Date it = sdf.parse(birthday);
                if (it != null) {
                    String tmpDate = sdf.format(it);
                    Intrinsics.checkNotNullExpressionValue(tmpDate, "sdf.format(it)");
                    if (!Intrinsics.areEqual(tmpDate, birthday)) {
                        return false;
                    }
                    return true;
                }
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
        return false;
    }

    public final String convertIdCarBy15bit(String idCard) {
        if (idCard == null || idCard.length() != 15 || !isDigital(idCard)) {
            return null;
        }
        String provinceId = idCard.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(provinceId, "this as java.lang.String…ing(startIndex, endIndex)");
        if (!checkProvinceId(provinceId)) {
            return null;
        }
        String birthday = idCard.substring(6, 12);
        Intrinsics.checkNotNullExpressionValue(birthday, "this as java.lang.String…ing(startIndex, endIndex)");
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd", Locale.CHINA);
        try {
            Date $this$convertIdCarBy15bit_u24lambda_u242 = sdf.parse(birthday);
            if ($this$convertIdCarBy15bit_u24lambda_u242 == null) {
                $this$convertIdCarBy15bit_u24lambda_u242 = null;
            } else {
                String tmpDate = sdf.format($this$convertIdCarBy15bit_u24lambda_u242);
                Intrinsics.checkNotNullExpressionValue(tmpDate, "sdf.format(this)");
                if (!Intrinsics.areEqual(tmpDate, birthday)) {
                    return null;
                }
            }
            Date birthDate = $this$convertIdCarBy15bit_u24lambda_u242;
            Calendar cday = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(cday, "getInstance()");
            cday.setTime(birthDate);
            String year = String.valueOf(cday.get(1));
            Intrinsics.checkNotNullExpressionValue(year, "valueOf(cday.get(Calendar.YEAR))");
            StringBuilder sb = new StringBuilder();
            String strSubstring = idCard.substring(0, 6);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            StringBuilder sbAppend = sb.append(strSubstring).append(year);
            String strSubstring2 = idCard.substring(8);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            String idCard17 = sbAppend.append(strSubstring2).toString();
            char[] c = idCard17.toCharArray();
            Intrinsics.checkNotNullExpressionValue(c, "this as java.lang.String).toCharArray()");
            int[] bit = convertCharToInt(c);
            int sum17 = getPowerSum(bit);
            String checkCode = getCheckCodeBySum(sum17);
            if (checkCode == null) {
                return null;
            }
            return idCard17 + checkCode;
        } catch (ParseException e) {
            return null;
        }
    }

    private final boolean checkProvinceId(String provinceId) {
        for (String id : cityCode) {
            if (Intrinsics.areEqual(id, provinceId)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isDigital(String str) {
        return new Regex("^[0-9]*$").matches(str);
    }

    private final int getPowerSum(int[] bit) {
        int sum = 0;
        if (power.length != bit.length) {
            return 0;
        }
        int length = bit.length;
        for (int i = 0; i < length; i++) {
            int length2 = power.length;
            for (int j = 0; j < length2; j++) {
                if (i == j) {
                    sum += bit[i] * power[j];
                }
            }
        }
        return sum;
    }

    private final String getCheckCodeBySum(int sum17) {
        switch (sum17 % 11) {
            case 0:
                return "1";
            case 1:
                return "0";
            case 2:
                return "x";
            case 3:
                return GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD;
            case 4:
                return GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD;
            case 5:
                return GlobalSetting.UNIFIED_BANNER_AD;
            case 6:
                return GlobalSetting.NATIVE_UNIFIED_AD;
            case 7:
                return GlobalSetting.REWARD_VIDEO_AD;
            case 8:
                return GlobalSetting.NATIVE_EXPRESS_AD;
            case 9:
                return GlobalSetting.SPLASH_AD;
            case 10:
                return "2";
            default:
                return null;
        }
    }

    private final int[] convertCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        int length = c.length;
        int i = 0;
        while (i < length) {
            char temp = c[i];
            a[k] = Integer.parseInt(String.valueOf(temp));
            i++;
            k++;
        }
        return a;
    }
}
