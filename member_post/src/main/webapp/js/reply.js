// const replyService =  {};
const replyService = (function(){ 
  const url = "/member_post/reply";

  function write(reply, callback){
    console.log(reply);
    // JSON.stringify() :: obj -> json String
    // JSON.parse() :: json -> obj

    const data = JSON.stringify(reply);
    $.post({url,data,}).done(function(data){
      if(callback)
        callback(data);
    })

  }

  function list(pno, cri, callback){
	let reformeUrl = url + "/list/" + pno;
	if(cri && cri.lastRno){
		reformeUrl += "/"+cri.lastRno;
		if(cri.amount){
			reformeUrl += "/"+cri.amount;
		}
	}
	console.log(reformeUrl);
	
    $.getJSON(reformeUrl).done(function(data){
      if(callback)
        callback(data);
    })

  }
  
  function view(rno, callback){
	$.getJSON(url + "/" + rno).done(function(data){
		if(callback)
			callback(data);
	})
  }
  
  function modify(reply, callback){
	const data = JSON.stringify(reply);
	$.ajax(url, {
		method : "put",
		data
	}).done(function(data){
		if(callback)
			callback(data);
	})
  }
  
  function remove(rno, callback){
	console.log("ssss");
	$.ajax(url + "/" + rno, {
		method : "delete"
	}).done(function(data){
		if(callback)
			callback(data);
	})
  }
  
  return {write, list, view, modify, remove}
  // return {write: write}
})();
