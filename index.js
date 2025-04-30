function rollDice() {
  // Roll dice for Player 1
  var randomNum1 = Math.floor(Math.random() * 6) + 1;
  var randomImageSource1 = "images/dice" + randomNum1 + ".png";
  document.querySelector(".img1").setAttribute("src", randomImageSource1);

  // Roll dice for Player 2
  var randomNum2 = Math.floor(Math.random() * 6) + 1;
  var randomImageSource2 = "images/dice" + randomNum2 + ".png";
  document.querySelector(".img2").setAttribute("src", randomImageSource2);

  // Roll dice for Player 3
  var randomNum3 = Math.floor(Math.random() * 6) + 1;
  var randomImageSource3 = "images/dice" + randomNum3 + ".png";
  document.querySelector(".img3").setAttribute("src", randomImageSource3);


  // Determine the winner
  var maxRoll = Math.max(randomNum1, randomNum2, randomNum3);
  var winners = [];

  if (randomNum1 === maxRoll) winners.push("Player 1");
  if (randomNum2 === maxRoll) winners.push("Player 2");
  if (randomNum3 === maxRoll) winners.push("Player 3");

  if (winners.length > 1) {
      document.querySelector("h6").innerHTML = "It's a Draw between " + winners.join(", ") + "!";
  } else {
      document.querySelector("h6").innerHTML = winners[0] + " Wins!";
  }
}
