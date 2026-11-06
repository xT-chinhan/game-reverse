(function() {
  "use strict";
  const gentle = ["ribbonstep", "step", "heeltap", "twist", "heartbounce", "swing", "bowbeat", "sidestep", "disco", "waltz", "penguin", "nod", "paw", "sway", "shuffle", "groove"], big = ["starjump", "rocket", "groove", "shuffle"];
  let index = 0, changes = 0, merges = 0;
  function next(large = false) {
    const s = CottonTheatre.getStatus();
    if (s.scene !== "play" || s.dressing || ["set", "up", "win", "codexPanel"].some((id) => document.getElementById(id).classList.contains("on"))) return;
    const pool = large ? big : gentle, motion = pool[index++ % pool.length];
    document.getElementById("cottonFrame").contentWindow.postMessage({ channel: "cotton-theatre-parent", type: "stage-dance", payload: { motion } }, "*");
    document.body.dataset.stageDance = motion;
    changes++;
  }
  window.addEventListener("cotton-game", (e) => {
    var _a, _b;
    const d = e.detail || {};
    if (d.type === "play") next();
    if (d.type === "merge") {
      merges++;
      if (((_a = d.payload) == null ? void 0 : _a.count) >= 6 || merges % 3 === 0) next(((_b = d.payload) == null ? void 0 : _b.count) >= 6);
    }
  });
  setInterval(() => next(), 9200);
  window.CottonDanceDirector = { next, getStatus: () => ({ changes, normal: gentle.length, large: big.length }) };
})();
