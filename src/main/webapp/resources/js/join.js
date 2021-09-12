/**
 * 
 */
 
 const put = document.getElementsByClassName("put");
 const btn = document.getElementById('btn');
 const pws = document.getElementsByClassName('pw');
 const frm = document.getElementById('frm');
 const id = document.getElementById('id');
 const idResult = document.getElementById('idResult');
 const pwCheck = document.getElementById('pwCheck');
 const idCheck = document.getElementById('idCheck');
 
 idCheck.addEventListener('click', function(){
	open("./idCheck?id="+id.value,"","width=400, height=200, top=200, left=300");
});
 
id.addEventListener('keyup', function(){
	
	if(id.value.trim().length>=6){
		idResult.innerHTML = '올바른 ID입니다'
	}else{
		idResult.innerHTML = '6글자 이상으로 입력해주세요'
	}
});

pws[1].addEventListener('blur', function(){
	let result = checkEqual(pws[0], pws[1]);
	if(!result) {
		pwCheck.innerHTML = '비밀번호가 일치하지않습니다'
	}
})

 btn.addEventListener('click', function(){
	//비어있는것들 검사
	let ce = checkEmpty(put);
	
	//두개의 값이 같은지 검사
	let ce2 = checkEqual(pws[0], pws[1]);
	
	//글자수 검사
	let cl = checkLength();
	
	if(ce&&ce2&&cl){
		frm.submit(); /*강제 이벤트 생성-()넣어주기*/
	}else{
		alert("필수입력")
	}
});

function checkLength(){
	let l = pws[0].value.trim().length;
	if(l>=6){
		return true;
	}else {
		return false;
	}
}


function checkEqual(check1, check2){
	return check1.value == check2.value;
}

function checkEmpty(puts){
	let result = true;
	for(r of puts){
		if(r.value.trim() == ""){
			result = false;
			break;
		}
	}
	return result;	
}

/*id.addEventListener('blur', function(){
	if(id.value.trim().length < 6){
		id.focus();
	}
	
});
*/

/*
id.addEventListener('change', function(){
	alert('change');
});
*/
