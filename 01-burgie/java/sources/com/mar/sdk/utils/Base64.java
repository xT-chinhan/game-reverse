package com.mar.sdk.utils;

import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.cc;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Base64 {
    private static final int BASELENGTH = 128;
    private static final int EIGHTBIT = 8;
    private static final int FOURBYTE = 4;
    private static final int LOOKUPLENGTH = 64;
    private static final char PAD = '=';
    private static final int SIGN = -128;
    private static final int SIXTEENBIT = 16;
    private static final int TWENTYFOURBITGROUP = 24;
    private static final boolean fDebug = false;
    private static final byte[] base64Alphabet = new byte[128];
    private static final char[] lookUpBase64Alphabet = new char[64];

    static {
        for (int i = 0; i < 128; i++) {
            base64Alphabet[i] = -1;
        }
        for (int i2 = 90; i2 >= 65; i2--) {
            base64Alphabet[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 122; i3 >= 97; i3--) {
            base64Alphabet[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 57; i4 >= 48; i4--) {
            base64Alphabet[i4] = (byte) ((i4 - 48) + 52);
        }
        base64Alphabet[43] = 62;
        base64Alphabet[47] = 63;
        for (int i5 = 0; i5 <= 25; i5++) {
            lookUpBase64Alphabet[i5] = (char) (i5 + 65);
        }
        int i6 = 26;
        int j = 0;
        while (i6 <= 51) {
            lookUpBase64Alphabet[i6] = (char) (j + 97);
            i6++;
            j++;
        }
        int i7 = 52;
        int j2 = 0;
        while (i7 <= 61) {
            lookUpBase64Alphabet[i7] = (char) (j2 + 48);
            i7++;
            j2++;
        }
        lookUpBase64Alphabet[62] = '+';
        lookUpBase64Alphabet[63] = '/';
    }

    private static boolean isWhiteSpace(char octect) {
        return octect == ' ' || octect == '\r' || octect == '\n' || octect == '\t';
    }

    private static boolean isPad(char octect) {
        return octect == '=';
    }

    private static boolean isData(char octect) {
        return octect < 128 && base64Alphabet[octect] != -1;
    }

    public static String encode(byte[] binaryData) {
        if (binaryData == null) {
            return null;
        }
        int lengthDataBits = binaryData.length * 8;
        if (lengthDataBits == 0) {
            return "";
        }
        int fewerThan24bits = lengthDataBits % 24;
        int numberTriplets = lengthDataBits / 24;
        int numberQuartet = fewerThan24bits != 0 ? numberTriplets + 1 : numberTriplets;
        char[] encodedData = new char[numberQuartet * 4];
        int i = 0;
        int dataIndex = 0;
        int encodedIndex = 0;
        while (i < numberTriplets) {
            int dataIndex2 = dataIndex + 1;
            byte b1 = binaryData[dataIndex];
            int dataIndex3 = dataIndex2 + 1;
            byte b2 = binaryData[dataIndex2];
            int dataIndex4 = dataIndex3 + 1;
            byte b3 = binaryData[dataIndex3];
            byte l = (byte) (b2 & cc.m);
            byte k = (byte) (b1 & 3);
            byte val1 = (b1 & ByteCompanionObject.MIN_VALUE) == 0 ? (byte) (b1 >> 2) : (byte) ((b1 >> 2) ^ MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            byte val2 = (b2 & ByteCompanionObject.MIN_VALUE) == 0 ? (byte) (b2 >> 4) : (byte) ((b2 >> 4) ^ MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            byte val3 = (byte) ((b3 & ByteCompanionObject.MIN_VALUE) == 0 ? b3 >> 6 : (b3 >> 6) ^ MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF);
            int encodedIndex2 = encodedIndex + 1;
            encodedData[encodedIndex] = lookUpBase64Alphabet[val1];
            int encodedIndex3 = encodedIndex2 + 1;
            encodedData[encodedIndex2] = lookUpBase64Alphabet[(k << 4) | val2];
            int encodedIndex4 = encodedIndex3 + 1;
            encodedData[encodedIndex3] = lookUpBase64Alphabet[(l << 2) | val3];
            encodedIndex = encodedIndex4 + 1;
            encodedData[encodedIndex4] = lookUpBase64Alphabet[b3 & 63];
            i++;
            dataIndex = dataIndex4;
        }
        if (fewerThan24bits == 8) {
            byte b4 = binaryData[dataIndex];
            byte k2 = (byte) (b4 & 3);
            byte val4 = (b4 & ByteCompanionObject.MIN_VALUE) == 0 ? (byte) (b4 >> 2) : (byte) ((b4 >> 2) ^ MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            int encodedIndex5 = encodedIndex + 1;
            encodedData[encodedIndex] = lookUpBase64Alphabet[val4];
            int encodedIndex6 = encodedIndex5 + 1;
            encodedData[encodedIndex5] = lookUpBase64Alphabet[k2 << 4];
            int encodedIndex7 = encodedIndex6 + 1;
            encodedData[encodedIndex6] = PAD;
            int i2 = encodedIndex7 + 1;
            encodedData[encodedIndex7] = PAD;
        } else if (fewerThan24bits == 16) {
            byte b5 = binaryData[dataIndex];
            byte b6 = binaryData[dataIndex + 1];
            byte l2 = (byte) (b6 & cc.m);
            byte k3 = (byte) (b5 & 3);
            byte val5 = (b5 & ByteCompanionObject.MIN_VALUE) == 0 ? (byte) (b5 >> 2) : (byte) ((b5 >> 2) ^ MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            byte val6 = (b6 & ByteCompanionObject.MIN_VALUE) == 0 ? (byte) (b6 >> 4) : (byte) ((b6 >> 4) ^ MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            int encodedIndex8 = encodedIndex + 1;
            encodedData[encodedIndex] = lookUpBase64Alphabet[val5];
            int encodedIndex9 = encodedIndex8 + 1;
            encodedData[encodedIndex8] = lookUpBase64Alphabet[(k3 << 4) | val6];
            int encodedIndex10 = encodedIndex9 + 1;
            encodedData[encodedIndex9] = lookUpBase64Alphabet[l2 << 2];
            encodedIndex = encodedIndex10 + 1;
            encodedData[encodedIndex10] = PAD;
        }
        return new String(encodedData);
    }

    public static String decodeString(String s) {
        try {
            byte[] buf = decode(s);
            String s2 = new String(buf, Key.STRING_CHARSET_NAME);
            try {
                return s2.replaceAll("[\\n|\\r]", "");
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return "";
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] decode(String encoded) {
        if (encoded == null) {
            return null;
        }
        char[] base64Data = encoded.toCharArray();
        int len = removeWhiteSpace(base64Data);
        if (len % 4 != 0) {
            return null;
        }
        int numberQuadruple = len / 4;
        if (numberQuadruple == 0) {
            return new byte[0];
        }
        int i = 0;
        int encodedIndex = 0;
        byte[] decodedData = new byte[numberQuadruple * 3];
        int dataIndex = 0;
        while (true) {
            int encodedIndex2 = encodedIndex;
            if (i < numberQuadruple - 1) {
                int dataIndex2 = dataIndex + 1;
                char d1 = base64Data[dataIndex];
                if (isData(d1)) {
                    dataIndex = dataIndex2 + 1;
                    char d2 = base64Data[dataIndex2];
                    if (!isData(d2)) {
                        break;
                    }
                    int dataIndex3 = dataIndex + 1;
                    char d3 = base64Data[dataIndex];
                    if (isData(d3)) {
                        dataIndex = dataIndex3 + 1;
                        char d4 = base64Data[dataIndex3];
                        if (!isData(d4)) {
                            break;
                        }
                        byte b1 = base64Alphabet[d1];
                        byte b2 = base64Alphabet[d2];
                        byte b3 = base64Alphabet[d3];
                        byte b4 = base64Alphabet[d4];
                        int encodedIndex3 = encodedIndex2 + 1;
                        decodedData[encodedIndex2] = (byte) ((b1 << 2) | (b2 >> 4));
                        int encodedIndex4 = encodedIndex3 + 1;
                        decodedData[encodedIndex3] = (byte) (((b2 & cc.m) << 4) | ((b3 >> 2) & 15));
                        encodedIndex = encodedIndex4 + 1;
                        decodedData[encodedIndex4] = (byte) ((b3 << 6) | b4);
                        i++;
                    }
                }
                return null;
            }
            int dataIndex4 = dataIndex + 1;
            char d5 = base64Data[dataIndex];
            if (isData(d5)) {
                int dataIndex5 = dataIndex4 + 1;
                char d6 = base64Data[dataIndex4];
                if (isData(d6)) {
                    byte b5 = base64Alphabet[d5];
                    byte b6 = base64Alphabet[d6];
                    int dataIndex6 = dataIndex5 + 1;
                    char d7 = base64Data[dataIndex5];
                    int i2 = dataIndex6 + 1;
                    char d8 = base64Data[dataIndex6];
                    if (!isData(d7) || !isData(d8)) {
                        if (isPad(d7) && isPad(d8)) {
                            if ((b6 & cc.m) != 0) {
                                return null;
                            }
                            byte[] tmp = new byte[(i * 3) + 1];
                            System.arraycopy(decodedData, 0, tmp, 0, i * 3);
                            tmp[encodedIndex2] = (byte) ((b5 << 2) | (b6 >> 4));
                            return tmp;
                        }
                        if (!isPad(d7) && isPad(d8)) {
                            byte b7 = base64Alphabet[d7];
                            if ((b7 & 3) != 0) {
                                return null;
                            }
                            byte[] tmp2 = new byte[(i * 3) + 2];
                            System.arraycopy(decodedData, 0, tmp2, 0, i * 3);
                            tmp2[encodedIndex2] = (byte) ((b5 << 2) | (b6 >> 4));
                            tmp2[encodedIndex2 + 1] = (byte) (((b6 & cc.m) << 4) | ((b7 >> 2) & 15));
                            return tmp2;
                        }
                        return null;
                    }
                    byte b8 = base64Alphabet[d7];
                    byte b9 = base64Alphabet[d8];
                    int encodedIndex5 = encodedIndex2 + 1;
                    decodedData[encodedIndex2] = (byte) ((b5 << 2) | (b6 >> 4));
                    int encodedIndex6 = encodedIndex5 + 1;
                    decodedData[encodedIndex5] = (byte) (((b6 & cc.m) << 4) | ((b8 >> 2) & 15));
                    int i3 = encodedIndex6 + 1;
                    decodedData[encodedIndex6] = (byte) ((b8 << 6) | b9);
                    return decodedData;
                }
            }
            return null;
        }
        return null;
    }

    private static int removeWhiteSpace(char[] data) {
        int newSize;
        if (data == null) {
            return 0;
        }
        int len = data.length;
        int i = 0;
        int newSize2 = 0;
        while (i < len) {
            if (isWhiteSpace(data[i])) {
                newSize = newSize2;
            } else {
                newSize = newSize2 + 1;
                data[newSize2] = data[i];
            }
            i++;
            newSize2 = newSize;
        }
        return newSize2;
    }
}
