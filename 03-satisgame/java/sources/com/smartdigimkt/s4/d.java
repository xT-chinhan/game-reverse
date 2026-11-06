package com.smartdigimkt.s4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static int[] a(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new int[]{options.outWidth, options.outHeight};
        } catch (OutOfMemoryError unused) {
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x00ad A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x00b2 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x00b7 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00bc A[ADDED_TO_REGION, DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c4 A[Catch: all -> 0x00c7, DONT_GENERATE, TRY_LEAVE, TryCatch #1 {all -> 0x00c7, blocks: (B:55:0x00be, B:57:0x00c4), top: B:92:0x00be }] */
    /* JADX WARN: Code duplicated, block: B:98:0x00a8 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Bitmap a(Context context, Bitmap bitmap) {
        RenderScript renderScriptCreate;
        Bitmap bitmapCreateScaledBitmap;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate;
        Allocation allocationCreateFromBitmap;
        Allocation allocationCreateFromBitmap2;
        if (context == null || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        try {
            double d = 500;
            double dMax = Math.max(Math.max(((double) bitmap.getWidth()) / d, ((double) bitmap.getHeight()) / d), 1.0d);
            int width = (int) (((double) bitmap.getWidth()) / dMax);
            int height = (int) (((double) bitmap.getHeight()) / dMax);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
            try {
                renderScriptCreate = RenderScript.create(context);
                try {
                    scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                    try {
                        allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                        try {
                            allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                            try {
                                scriptIntrinsicBlurCreate.setRadius(25.0f);
                                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                                new Canvas(bitmapCreateBitmap).drawColor(855638016);
                                if (allocationCreateFromBitmap2 != null) {
                                    try {
                                        allocationCreateFromBitmap2.destroy();
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (allocationCreateFromBitmap != null) {
                                    try {
                                        allocationCreateFromBitmap.destroy();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                if (scriptIntrinsicBlurCreate != null) {
                                    try {
                                        scriptIntrinsicBlurCreate.destroy();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (renderScriptCreate != null) {
                                    try {
                                        renderScriptCreate.destroy();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                if (bitmapCreateScaledBitmap != null && bitmapCreateScaledBitmap != bitmap) {
                                    try {
                                        if (!bitmapCreateScaledBitmap.isRecycled()) {
                                            bitmapCreateScaledBitmap.recycle();
                                        }
                                    } catch (Throwable unused5) {
                                    }
                                }
                                return bitmapCreateBitmap;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    th.printStackTrace();
                                    return null;
                                } finally {
                                    if (allocationCreateFromBitmap2 != null) {
                                        try {
                                            allocationCreateFromBitmap2.destroy();
                                        } catch (Throwable unused6) {
                                        }
                                    }
                                    if (allocationCreateFromBitmap != null) {
                                        try {
                                            allocationCreateFromBitmap.destroy();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    if (scriptIntrinsicBlurCreate != null) {
                                        try {
                                            scriptIntrinsicBlurCreate.destroy();
                                        } catch (Throwable unused8) {
                                        }
                                    }
                                    if (renderScriptCreate != null) {
                                        try {
                                            renderScriptCreate.destroy();
                                        } catch (Throwable unused9) {
                                        }
                                    }
                                    if (bitmapCreateScaledBitmap != null && bitmapCreateScaledBitmap != bitmap) {
                                        try {
                                            if (!bitmapCreateScaledBitmap.isRecycled()) {
                                                bitmapCreateScaledBitmap.recycle();
                                            }
                                        } catch (Throwable unused10) {
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            allocationCreateFromBitmap2 = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        allocationCreateFromBitmap = null;
                        allocationCreateFromBitmap2 = allocationCreateFromBitmap;
                        th.printStackTrace();
                        return null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    scriptIntrinsicBlurCreate = null;
                    allocationCreateFromBitmap = scriptIntrinsicBlurCreate;
                    allocationCreateFromBitmap2 = allocationCreateFromBitmap;
                    th.printStackTrace();
                    return null;
                }
            } catch (Throwable th5) {
                th = th5;
                renderScriptCreate = null;
                scriptIntrinsicBlurCreate = null;
            }
        } catch (Throwable th6) {
            th = th6;
            renderScriptCreate = null;
            bitmapCreateScaledBitmap = null;
            scriptIntrinsicBlurCreate = null;
        }
    }

    public static Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = width - 1;
        int i3 = height - 1;
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        int[] iArr4 = new int[i];
        int[] iArr5 = new int[Math.max(width, height)];
        int[] iArr6 = new int[173056];
        for (int i4 = 0; i4 < 173056; i4++) {
            iArr6[i4] = i4 / 676;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 51, 3);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i5 >= height) {
                break;
            }
            int i8 = -25;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 25; i8 <= i18; i18 = 25) {
                int i19 = height;
                int i20 = iArr[Math.min(i2, Math.max(i8, 0)) + i6];
                int[] iArr8 = iArr7[i8 + 25];
                iArr8[0] = (i20 & 16711680) >> 16;
                iArr8[1] = (i20 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i20 & 255;
                int iAbs = 26 - Math.abs(i8);
                int i21 = iArr8[0];
                i9 = (i21 * iAbs) + i9;
                int i22 = iArr8[1];
                i10 = (i22 * iAbs) + i10;
                int i23 = iArr8[2];
                i11 = (iAbs * i23) + i11;
                if (i8 > 0) {
                    i17 += i21;
                    i16 += i22;
                    i15 += i23;
                } else {
                    i14 += i21;
                    i13 += i22;
                    i12 += i23;
                }
                i8++;
                height = i19;
            }
            int i24 = height;
            int i25 = 25;
            int i26 = 0;
            while (i26 < width) {
                iArr2[i6] = iArr6[i9];
                iArr3[i6] = iArr6[i10];
                iArr4[i6] = iArr6[i11];
                int i27 = i9 - i14;
                int i28 = i10 - i13;
                int i29 = i11 - i12;
                int[] iArr9 = iArr7[(i25 + 26) % 51];
                int i30 = i14 - iArr9[0];
                int i31 = i13 - iArr9[1];
                int i32 = i12 - iArr9[2];
                if (i5 == 0) {
                    iArr5[i26] = Math.min(i26 + 26, i2);
                }
                int i33 = iArr[iArr5[i26] + i7];
                int i34 = (i33 & 16711680) >> 16;
                iArr9[0] = i34;
                int i35 = (i33 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[1] = i35;
                int i36 = i33 & 255;
                iArr9[2] = i36;
                int i37 = i17 + i34;
                int i38 = i16 + i35;
                int i39 = i15 + i36;
                i9 = i27 + i37;
                i10 = i28 + i38;
                i11 = i29 + i39;
                i25 = (i25 + 1) % 51;
                int[] iArr10 = iArr7[i25 % 51];
                int i40 = iArr10[0];
                i14 = i30 + i40;
                int i41 = iArr10[1];
                i13 = i31 + i41;
                int i42 = iArr10[2];
                i12 = i32 + i42;
                i17 = i37 - i40;
                i16 = i38 - i41;
                i15 = i39 - i42;
                i6++;
                i26++;
                iArr6 = iArr6;
            }
            i7 += width;
            i5++;
            height = i24;
        }
        int[] iArr11 = iArr6;
        int i43 = height;
        int i44 = 0;
        while (i44 < width) {
            int i45 = width * (-25);
            int[] iArr12 = iArr5;
            int[] iArr13 = iArr;
            int i46 = -25;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            for (int i56 = 25; i46 <= i56; i56 = 25) {
                int iMax = Math.max(0, i45) + i44;
                int[] iArr14 = iArr7[i46 + 25];
                iArr14[0] = iArr2[iMax];
                iArr14[1] = iArr3[iMax];
                iArr14[2] = iArr4[iMax];
                int iAbs2 = 26 - Math.abs(i46);
                i47 = (iArr2[iMax] * iAbs2) + i47;
                i48 = (iArr3[iMax] * iAbs2) + i48;
                i49 = (iArr4[iMax] * iAbs2) + i49;
                if (i46 > 0) {
                    i55 += iArr14[0];
                    i54 += iArr14[1];
                    i53 += iArr14[2];
                } else {
                    i52 += iArr14[0];
                    i51 += iArr14[1];
                    i50 += iArr14[2];
                }
                if (i46 < i3) {
                    i45 += width;
                }
                i46++;
            }
            int i57 = i44;
            int i58 = i43;
            int i59 = 0;
            int i60 = 25;
            while (i59 < i58) {
                iArr13[i57] = (iArr13[i57] & ViewCompat.MEASURED_STATE_MASK) | (iArr11[i47] << 16) | (iArr11[i48] << 8) | iArr11[i49];
                int i61 = i47 - i52;
                int i62 = i48 - i51;
                int i63 = i49 - i50;
                int[] iArr15 = iArr7[(i60 + 26) % 51];
                int i64 = i52 - iArr15[0];
                int i65 = i51 - iArr15[1];
                int i66 = i50 - iArr15[2];
                if (i44 == 0) {
                    iArr12[i59] = Math.min(i59 + 26, i3) * width;
                }
                int i67 = iArr12[i59] + i44;
                int i68 = iArr2[i67];
                iArr15[0] = i68;
                int i69 = iArr3[i67];
                iArr15[1] = i69;
                int i70 = iArr4[i67];
                iArr15[2] = i70;
                int i71 = i55 + i68;
                int i72 = i54 + i69;
                int i73 = i53 + i70;
                i47 = i61 + i71;
                i48 = i62 + i72;
                i49 = i63 + i73;
                i60 = (i60 + 1) % 51;
                int[] iArr16 = iArr7[i60];
                int i74 = iArr16[0];
                i52 = i64 + i74;
                int i75 = iArr16[1];
                i51 = i65 + i75;
                int i76 = iArr16[2];
                i50 = i66 + i76;
                i55 = i71 - i74;
                i54 = i72 - i75;
                i53 = i73 - i76;
                i57 += width;
                i59++;
                i58 = i58;
            }
            i43 = i58;
            i44++;
            iArr5 = iArr12;
            iArr = iArr13;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, i43);
        return bitmap;
    }
}
