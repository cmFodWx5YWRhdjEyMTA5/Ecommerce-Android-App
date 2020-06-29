/*

Flutter - Laptop coming soon Page
Author: iqonicthemes.in
Version: 3.0
Design and Developed by: iqonicthemes.in

*/


const getRemainingTime = deadline => {
  let now = new Date(),
      remainTime = (new Date(deadline) - now + 1000) / 1000,
      remainSeconds = ('0' + Math.floor(remainTime % 60)).slice(-2),
      remainMinutes = ('0' + Math.floor(remainTime / 60 % 60)).slice(-2),
      remainHours = ('0' + Math.floor(remainTime / 3600 % 24)).slice(-2),
      remainDays = Math.floor(remainTime / (3600 * 24));

  return {
    remainSeconds,
    remainMinutes,
    remainHours,
    remainDays,
    remainTime
  }
};
const countdown = (deadline,elem,finalMessage) => {
  const el = document.getElementById(elem);

  const timerUpdate = setInterval( () => {
    let t = getRemainingTime(deadline);
    el.innerHTML =
  `<div class="label">${t.remainDays}<div class="clock-text">Days</div></div>

   <div class="hours label">${t.remainHours}<div class="clock-text">Hours</div></div>

   <div class="minutes label">${t.remainMinutes}<div class="clock-text">Minutes</div></div>

   <div class="seconds label">${t.remainSeconds}<div class="clock-text">Seconds</div></div>`;

    if(t.remainTime <= 1) {
      clearInterval(timerUpdate);
      el.innerHTML = finalMessage;
    }

  }, 1000)
};

countdown('Apr 04 2019 23:05:40 GMT-0500', 'clock', '¡Ya empezó!');
