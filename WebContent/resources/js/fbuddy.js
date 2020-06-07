if($==undefined)
 var $ = (exp,el) => el==undefined ? document.querySelector(exp) : el.querySelector(exp) ; 
if($$==undefined)
 var $$ = (exp,el) => el==undefined ? document.querySelectorAll(exp) : el.querySelectorAll(exp) ;

 var a;

 function filterQuestions(e){ 
 
	 
	 let filterText = e.target.value;
  
	 $$('.question',$('#questions-list')).forEach(question => {
		 if( $('label',question).innerHTML.includes(filterText) ){
			 question.classList.remove("hide");
		 } else {
			 question.classList.add("hide");
		 }
	 });
	 
  
}