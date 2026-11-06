package com.anythink.basead.b.b;

/* JADX INFO: loaded from: classes.dex */
public enum e {
    NO_HANDLE(0),
    HANDLE_SUCCESS(1),
    HANDLE_FAIL(2),
    HANDLE_SUCCESS_WITH_WEB_CLICK(3),
    HANDLE_DEEPLINK_REFUSE(4);

    private final int f;

    private static /* synthetic */ e[] b() {
        return new e[]{NO_HANDLE, HANDLE_SUCCESS, HANDLE_FAIL, HANDLE_SUCCESS_WITH_WEB_CLICK, HANDLE_DEEPLINK_REFUSE};
    }

    e(int i) {
        this.f = i;
    }

    private int a() {
        return this.f;
    }

    private static e a(int i) {
        for (e eVar : values()) {
            if (eVar.f == i) {
                return eVar;
            }
        }
        return NO_HANDLE;
    }
}
