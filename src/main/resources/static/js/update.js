// (1) 회원정보 수정
function update(userid, event) {
	event.preventDefault(); //폼테그 액션 막기
	
	let data = $("#profileUpdate").serialize();
	
	
	$.ajax({
		type:"put",
		url:`/api/user/${userid}`,
		data: data,
		contentType:"application/x-www-form-urlencoded; charset=urf-8",
		dataType:"json"
	}).done(res=>{ // HttpStatus 상태코드 200번대
		console.log("성공".res);
		location.herf=`user/${userid}`;
	}).fail(error=>{ // HttpStatus 상태코드 200번대가 아닐때
		if(error.data == null ){ 
		alert(error.responseJSON.massage);
		}else {
		alert(JSON.stringify(error.responseJSON.data));
			
		}
	});
	
	
}