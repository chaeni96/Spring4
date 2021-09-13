/**
 * 
 */
 
 const modify = document.getElementById('modify');
 /*const del= document.getElementById('delete');*/
 const del = document.querySelector("#delete")
 modify.addEventListener('click', function(){
	location.href = "./modify";
});

 del.addEventListener('click', function(){
	let result = confirm('Delete???????');
	if(result){	
		location.href = "./delete";
	}
})
 