<!DOCTYPE html>
<html lang="en">
<body>

<input type="text" id="bigOne">
	
	
<script src="https://www.gstatic.com/firebasejs/5.1.0/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyD7K_TwkMXyz9XTyyNdU-CrflrK25mDpZQ",
    authDomain: "fcmtest-e0cc9.firebaseapp.com",
    databaseURL: "https://fcmtest-e0cc9.firebaseio.com",
    projectId: "fcmtest-e0cc9",
    storageBucket: "",
    messagingSenderId: "884208340000"
  };
  firebase.initializeApp(config);
	
  var bigOne = document.getElementById('bigOne');
  var dbRef = firebase.database().ref().child('text');
  dbRef.on('value', snap => bigOne.value = snap.val());
  
  </script>

</body>
</html>