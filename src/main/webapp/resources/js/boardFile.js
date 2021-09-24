/**
 * boardFile.js
 */
 
 
 let files = '<div class="input-group mb-3">';
 	files = files+'<input type="file" name="files" class="form-control">';
 	files = files+'<button class="btn btn-outline-secondary del" type="button">X</button>';
 	files = files+'</div>';

 let count = 0;
 
 function setCount(c){
	count = c;
}

function updateCount(){
	count--;
}
 	
 /*let index = 0;*/
 $('#fileAdd').click(function(){
	
/*	index++;
	let files = '<div class="input-group mb-3" id="del'+index+'">';
 	files = files+'<input type="file" class="form-control">';
 	files = files+'<button data-btn-id="'+index+'" class="btn btn-outline-secondary del" type="button">X</button>';
 	files = files+'</div>';*/	
	if(count <5){
		count++;
		$('#fileAddResult').append(files);
	}else{
		alert('최대 5개까지 가능합니다');
	}
});

$("#fileAddResult").on('click', '.del' , function(){
	/*let num = $(this).attr('data-btn-id');
	$("#del"+num).remove();	*/
	
	$(this).parent().remove();
	count--;
});

/*$('.del').click(function(){
	alert('test');
});*/