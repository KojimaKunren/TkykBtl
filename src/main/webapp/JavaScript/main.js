let maintext = document.getElementById("maintext");
const context = document.getElementById("context");
const btn = document.getElementById("btn");

btn.addEventListener("click", (e)=>{
	let select = e.target.innerText;
	maintext.innerText = null;
	switch (select) {
		case Attack:
			maintext.innerText="Attack";
			break;

		case Recovery:
			maintext.innerText="Recovery";
			break;
		default:
	}
});


function battle() {
}

function init() {
}


