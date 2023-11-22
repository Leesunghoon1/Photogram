// (1) 회원정보 수정
function update(userid) {
	
	let date = $("#profileUpdate").serialize();
	
	console.log(date);
	
	$.ajax({
		type:"put",
		url:`/api/user/${userid}`,
		data : data,
		contentType:"application/x-www-form-urlencoded; charset=urf-8",
		dataType:"json"
	}).done(res=>{
		console.log("update 성공");
		location.herf=`user/${userid}`;
	}).fail(error=>{
		console.log("update 실패");
	})
	
	
}