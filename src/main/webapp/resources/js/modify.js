/**
 * 
 */
 const revise = document.getElementById('revise');
 const frm = document.getElementsByClassName('frm');
 const pws = document.getElementsByClassName('pws');
 const pwCheck = document.getElementById('pwCheck');
 
 revise.addEventListener('click' ,function(){
	/*password*/
	if (pws[0]==null || pws[1]==null) {
		alert("비밀번호를 입력해주세요.");
	}

	else {
		if (pws[0].value == pws[1].value) {
			
			let cl = checkLength();
			
			if (cl) {
				frm.submit();
			}
			else {
				alert("비밀번호를 6글자 이상으로 설정해주세요.");
			}
		} else {
			pwCheck.innerHTML = '비밀번호가 일치하지않습니다'
		}
	}
});

function checkLength(){
	let l = pws[0].value.trim().length;
	if(l>=6){
		return true;
	}else{
		return false;
	}
};
 
 