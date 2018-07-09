function myFunction() {
	var count = 0;
	var a = document.getElementsByClassName("correct");
	for (var i = 0; i < a.length; i++) {
		if (a[i].checked == true && a[i].value=="true") {
			
			count++;
		}
	}
	document.getElementById("check").innerHTML=count;
}