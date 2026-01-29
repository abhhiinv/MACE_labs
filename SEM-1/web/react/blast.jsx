// blast.js
export default function blast() {
  const output = document.getElementById("output");

  if (!output) return;

  // Terminal style (start)
  document.body.style.background = "#000000"; // black
  output.style.color = "#00ff41"; // neon green text
  output.innerHTML = "";

  const countdown = ["Your Root folder will be deleted in\n3", "Your Root folder will be deleted in\n2", "Your Root folder will be deleted in\n1"];

  countdown.forEach((text, i) => {
    setTimeout(() => {
      output.innerHTML = text;
    }, (i + 1) * 1000);
  });

  setTimeout(() => {
    document.body.classList.add("boom");

    setTimeout(() => {
      document.body.classList.remove("boom");

      // Terminal final background (stay black)
      document.body.style.background = "#000000";

      output.innerHTML = `
        <h1 style="font-size:3rem; color:#00ff41; animation: fadeIn 1s ease;">
          Your Root folder has been successfully deleted ^_^
        </h1>
      `;
    }, 1000);
  }, 4000);
}
