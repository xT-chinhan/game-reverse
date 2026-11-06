package com.taptap.sdk.compliance.internal.util;

import com.qq.e.comm.managers.setting.GlobalSetting;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001b\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/compliance/internal/util/IdCardUtil;", "", "()V", "cityCode", "", "", "[Ljava/lang/String;", "power", "", "checkProvinceId", "", "provinceId", "convertCharToInt", "c", "", "convertIdCarBy15bit", "idCard", "getCheckCodeBySum", "sum17", "", "getPowerSum", "bit", "isDigital", "str", "isValidatedIdCard", "validate15IDCard", "idcard", "validate18Idcard", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        if (idCard == null || idCard.length() != 18) {
            return false;
        }
        String strSubstring = idCard.substring(0, 17);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (!isDigital(strSubstring)) {
            return false;
        }
        String strSubstring2 = idCard.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        if (!checkProvinceId(strSubstring2)) {
            return false;
        }
        String strSubstring3 = idCard.substring(6, 14);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        try {
            Date date = simpleDateFormat.parse(strSubstring3);
            if (date != null) {
                String str = simpleDateFormat.format(date);
                Intrinsics.checkNotNullExpressionValue(str, "sdf.format(it)");
                if (!Intrinsics.areEqual(str, strSubstring3)) {
                    return false;
                }
            }
            String strSubstring4 = idCard.substring(17, 18);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
            char[] charArray = strSubstring.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            String checkCodeBySum = getCheckCodeBySum(getPowerSum(convertCharToInt(charArray)));
            if (checkCodeBySum == null) {
                return false;
            }
            return StringsKt.equals(strSubstring4, checkCodeBySum, true);
        } catch (ParseException unused) {
            return false;
        }
    }

    public final boolean validate15IDCard(String idcard) {
        if (idcard == null || idcard.length() != 15 || !isDigital(idcard)) {
            return false;
        }
        String strSubstring = idcard.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (!checkProvinceId(strSubstring)) {
            return false;
        }
        String strSubstring2 = idcard.substring(6, 12);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd", Locale.CHINA);
        try {
            Date date = simpleDateFormat.parse(strSubstring2);
            if (date == null) {
                return true;
            }
            String str = simpleDateFormat.format(date);
            Intrinsics.checkNotNullExpressionValue(str, "sdf.format(it)");
            return Intrinsics.areEqual(str, strSubstring2);
        } catch (ParseException unused) {
            return false;
        }
    }

    public final String convertIdCarBy15bit(String idCard) {
        if (idCard == null || idCard.length() != 15 || !isDigital(idCard)) {
            return null;
        }
        String strSubstring = idCard.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (!checkProvinceId(strSubstring)) {
            return null;
        }
        String strSubstring2 = idCard.substring(6, 12);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd", Locale.CHINA);
        try {
            Date date = simpleDateFormat.parse(strSubstring2);
            if (date != null) {
                String str = simpleDateFormat.format(date);
                Intrinsics.checkNotNullExpressionValue(str, "sdf.format(this)");
                if (!Intrinsics.areEqual(str, strSubstring2)) {
                    return null;
                }
            } else {
                date = null;
            }
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
            calendar.setTime(date);
            String strValueOf = String.valueOf(calendar.get(1));
            Intrinsics.checkNotNullExpressionValue(strValueOf, "valueOf(cday.get(Calendar.YEAR))");
            StringBuilder sb = new StringBuilder();
            String strSubstring3 = idCard.substring(0, 6);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
            StringBuilder sbAppend = sb.append(strSubstring3).append(strValueOf);
            String strSubstring4 = idCard.substring(8);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String).substring(startIndex)");
            String string = sbAppend.append(strSubstring4).toString();
            char[] charArray = string.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            String checkCodeBySum = getCheckCodeBySum(getPowerSum(convertCharToInt(charArray)));
            if (checkCodeBySum == null) {
                return null;
            }
            return string + checkCodeBySum;
        } catch (ParseException unused) {
            return null;
        }
    }

    private final boolean checkProvinceId(String provinceId) {
        for (String str : cityCode) {
            if (Intrinsics.areEqual(str, provinceId)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isDigital(String str) {
        return new Regex("^[0-9]*$").matches(str);
    }

    private final int getPowerSum(int[] bit) {
        if (power.length != bit.length) {
            return 0;
        }
        int length = bit.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int length2 = power.length;
            for (int i3 = 0; i3 < length2; i3++) {
                if (i2 == i3) {
                    i += bit[i2] * power[i3];
                }
            }
        }
        return i;
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
                return "7";
            case 6:
                return "6";
            case 7:
                return "5";
            case 8:
                return "4";
            case 9:
                return "3";
            case 10:
                return "2";
            default:
                return null;
        }
    }

    private final int[] convertCharToInt(char[] c) throws NumberFormatException {
        int[] iArr = new int[c.length];
        int length = c.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            iArr[i2] = Integer.parseInt(String.valueOf(c[i]));
            i++;
            i2++;
        }
        return iArr;
    }
}
