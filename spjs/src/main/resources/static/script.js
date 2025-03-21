const form=document.getElementById("userForm");
const userTable=document.getElementById("userTable");
form.addEventListener("submit",async (e) =>{
	e.preventDefault();
	const name=document.getElementById("name").value;
	const email=document.getElementById("email").value;
	const res=await fetch("http://localhost:8080/api/users",{
		method:"POST",
		headers:{"Content-Type":"application/json"},
		body:JSON.stringify({name,email})
	});
	if(res.ok){
		form.reset();
		loadUsers();
	}
	else{
		alert("Error adding User");
	}
});
async function loadUsers(){
	const res=await fetch("http://localhost:8080/api/users");
	const users=await res.json();
	userTable.innerHTML="";
	users.forEach((user) => {
		const row=document.createElement("tr");
		row.innerHTML=`<td>${user.name}</td><td>${user.email}</td>`;
		userTable.appendChild(row);
	});
}