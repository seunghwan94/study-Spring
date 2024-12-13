// const replyService =  {};
const replyService = (function(){ 
  const url = "/member_post/reply";

  function write(reply, callback){
    console.log(reply);
    // JSON.stringify() :: obj -> json String
    // JSON.parse() :: json -> obj

    const data = JSON.stringify(reply);
    $.post({url,data,}).done(function(data){
      console.log(data);
      if(callback)
        callback(data);
    })

  }

  function list(pno, cri, callback){
	let reformedUrl = "";
	if(cri && cri.lastRno){
		reformedUrl += "/" + cri.lastRno;
		if(cri.amount){
			reformedUrl += "/" + cri.amount;
		}		
	}
	
    $.getJSON(url + "/list/" + pno + reformedUrl).done(function(data){
      if(callback)
        callback(data);
    })

  }
  return {write, list}
  // return {write: write}
})();
