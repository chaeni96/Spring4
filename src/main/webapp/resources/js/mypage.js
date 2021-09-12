/**
 * 
 */
 
 const modify = document.getElementById('modify');
 const delete1 = document.getElementById('delete');
 
 modify.addEventListener('click', function(){
	location.href = "./modify";
});

 delete1.addEventListener('click', function(){
	location.href = "./delete?id="+delete1.value;
})
 