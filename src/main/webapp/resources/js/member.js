/**
 * 
 */
 
 const all = document.getElementById('all');
 const checks = document.getElementsByClassName('checks');
 const btn = document.getElementById('btn');
 const must = document.getElementsByClassName('must');
 const ad = document.getElementById('ad');
 
/* btn.addEventListener('click', function(){
	 if(all.checked){
		
		location.href="./join";
	
	} else{
		alert('필수약관에 동의 해야합니다')
	}
})
*/
//---------------- 필수 동의시 가입
	btn.addEventListener('click',function(){
		let result="true";
		for(let m of must){
			if(!m.checked){
				result=false;
				break;
			}
		}
		
		if(result){
			location.href="./join";
		}else{
			alert("필수 약관에 동의하세요");
		}
	});



 //전체 동의, 해제
 all.addEventListener('click', function(){
	for(let c of checks){
		c.checked= all.checked;
	}	
})

//------------------
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









	 