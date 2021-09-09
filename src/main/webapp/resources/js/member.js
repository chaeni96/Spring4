/**
 * 
 */
 
 const all = document.getElementById('all');
 const checks = document.getElementsByClassName('checks');
 const btn = document.getElementById('btn');
 
 btn.addEventListener('click', function(){
	if(all.checked){
		location.href="./join";
	}else{
		alert('필수약관에 동의 해야합니다')
	}
})

 //전체 동의, 해제
 all.addEventListener('click', function(){
	for(let c of checks){
		c.checked= all.checked;
	}	
})

//--------------------
for(let c of checks){
	c.addEventListener('click', function(){
		let result = true;
		
		for(c of checks){
			if(!c.checked){
			result = false;
			break;
		}
		
		}
		all.checked = result;
	})
}









	 