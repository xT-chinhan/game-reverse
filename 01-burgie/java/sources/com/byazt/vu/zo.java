package com.byazt.vu;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 733, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public static boolean pr(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof uc) {
            return ((uc) viewParent).pr(view, view2, i, i2);
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view, view2, i);
                } catch (AbstractMethodError e) {
                    ho.pr("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
                    return false;
                }
            }
            if (viewParent instanceof c) {
                return ((c) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }
        return false;
    }

    public static void hw(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (!(viewParent instanceof uc) && i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i);
                    return;
                } catch (AbstractMethodError e) {
                    ho.pr("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
                    return;
                }
            }
            if (viewParent instanceof c) {
                ((c) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    public static void pr(ViewParent viewParent, View view, int i) {
        if (!(viewParent instanceof uc) && i == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                    return;
                } catch (AbstractMethodError e) {
                    ho.pr("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
                    return;
                }
            }
            if (viewParent instanceof c) {
                ((c) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void pr(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (!(viewParent instanceof uc) && i5 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i, i2, i3, i4);
                    return;
                } catch (AbstractMethodError e) {
                    ho.pr("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
                    return;
                }
            }
            if (viewParent instanceof c) {
                ((c) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }
    }

    public static void pr(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof uc) {
            ((uc) viewParent).pr(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i, i2, iArr);
                    return;
                } catch (AbstractMethodError e) {
                    ho.pr("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
                    return;
                }
            }
            if (viewParent instanceof c) {
                ((c) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }
    }

    public static boolean pr(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                ho.pr("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }
        if (viewParent instanceof c) {
            return ((c) viewParent).onNestedFling(view, f, f2, z);
        }
        return false;
    }

    public static boolean pr(ViewParent viewParent, View view, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                ho.pr("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }
        if (viewParent instanceof c) {
            return ((c) viewParent).onNestedPreFling(view, f, f2);
        }
        return false;
    }
}
