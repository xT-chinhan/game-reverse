package com.taptap.sdk.kit.internal.extensions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: compiled from: GameEngineExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"isUnityEngine", "", "isUnrealEngine", "tap-kit_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class GameEngineExtKt {
    public static final boolean isUnrealEngine() {
        Object objM184constructorimpl;
        Object objM184constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(Class.forName("com.epicgames.ue4.GameActivity"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m191isSuccessimpl(objM184constructorimpl)) {
            return true;
        }
        if (Result.m187exceptionOrNullimpl(objM184constructorimpl) != null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                objM184constructorimpl2 = Result.m184constructorimpl(Class.forName("com.epicgames.unreal.GameActivity"));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM184constructorimpl2 = Result.m184constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m191isSuccessimpl(objM184constructorimpl2)) {
                return true;
            }
            if (Result.m187exceptionOrNullimpl(objM184constructorimpl2) != null) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isUnityEngine() {
        Object objM184constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(Class.forName("com.unity3d.player.UnityPlayer"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m191isSuccessimpl(objM184constructorimpl)) {
            return Result.m187exceptionOrNullimpl(objM184constructorimpl) == null;
        }
        return true;
    }
}
