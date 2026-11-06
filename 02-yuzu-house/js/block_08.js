(function() {
  "use strict";
  const reduced = matchMedia("(prefers-reduced-motion: reduce)");
  let serial = 0, completed = 0, queued = false, nextKind = "", animation = null;
  const routes = { bPet: "pet", bLive: "live", bMeme: "meme", petClose: "home", memeClose: "home", bStart: "chapters", bFree: "play", bHome: "home", bWear: "wardrobe", wardrobeDone: "home", bSet: "voice", bSetOpen: "voice", bVoiceOpen: "voice", bSetClose: "back", bLv: "upgrade", bUpA: "back", bUpB: "back", bUpC: "back", stats: "collection", bCxClose: "back", bHowTo: "guide", guideNext: "guide", guidePrev: "guide", guideSkip: "back", bWinBack: "back", bWinFresh: "play", bWinKeep: "play" };
  function target() {
    for (const [id, test] of [["appSettings", "dialog"], ["chapterOverlay", "hidden"], ["chapterWin", "hidden"], ["wardrobeOverlay", "on"], ["memeRoom", "hidden"], ["petRoom", "on"], ["up", "on"], ["set", "on"], ["codexPanel", "on"], ["win", "on"]]) {
      const el = document.getElementById(id);
      if (!el) continue;
      const shown = test === "dialog" ? el.open : test === "hidden" ? !el.hidden : el.classList.contains("on");
      if (shown) return el.querySelector(".box,.panel,.chapter-panel,.wardrobe-shell") || el;
    }
    return null;
  }
  function schedule(kind) {
    nextKind = kind;
    if (queued) return;
    queued = true;
    queueMicrotask(() => {
      queued = false;
      serial++;
      const kind2 = nextKind;
      animation == null ? void 0 : animation.cancel();
      animation = null;
      document.body.dataset.transitionCount = String(serial);
      if (!reduced.matches && !["back", "home", "play"].includes(kind2)) {
        const panel = target();
        if (panel) animation = panel.animate([{ opacity: 0.6, translate: "0 4px" }, { opacity: 1, translate: "0 0" }], { duration: 160, easing: "cubic-bezier(.2,.7,.2,1)" });
      }
      completed++;
    });
  }
  function run(kind, change) {
    const result = change();
    schedule(kind);
    return result;
  }
  document.addEventListener("click", (e) => {
    const el = e.target.closest('button,[role="button"],#stats');
    if (el && !el.disabled && routes[el.id]) schedule(routes[el.id]);
  }, true);
  window.CottonTransitions = Object.freeze({ run, getStatus: () => ({ count: serial, completed, active: (animation == null ? void 0 : animation.playState) === "running", reducedMotion: reduced.matches, native: false, immediate: true }) });
})();
