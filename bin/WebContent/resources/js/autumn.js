if($==undefined)
 var $ = (exp,el) => el==undefined ? document.querySelector(exp) : el.querySelector(exp) ; 
if($$==undefined)
 var $$ = (exp,el) => el==undefined ? document.querySelectorAll(exp) : el.querySelectorAll(exp) ;
if(_$==undefined)
    var _$ = (html) => document.createRange().createContextualFragment(html);

let autumn = { };
autumn.dParse = new DOMParser();

autumn.parse = ( mark , space) => {
    /*
        e.g. 
        mark = `
            <div>   {{title}}
            </div>
        `
        html = `<div>`+space[title]+`</div>`
    */
    if(space==undefined)
        space = globalThis;
        
    let html = autumn.replaceMark(mark,space);
    let el = autumn.dParse.parseFromString(html,'text/html').documentElement;
    
    el.querySelectorAll('*[event]').forEach( (node) => {
        try{
            let event = node.getAttribute('event').split(',');
            node.addEventListener(event[0],space[event[1]]);
        }catch(e){
            console.log('err while adding callback : '+e);
        }
    } );

    return  el; 
};

autumn.replaceMark = (mark,space) => {
    if(mark.search(/{{([a-zA-Z0-9]*)}}/g)<0)
        return mark;
    else
        return autumn.replaceMark(mark.replace(/{{([a-zA-Z0-9]*)}}/g,(match,cont,off,inp)=> space[cont]) , space);
    
}

let initForm = () => {
    console.log("init forms");
    $$(".auto-list").forEach( list => {
        
        let input = $('input' , list);
        let options = $('options' , list);

        input.addEventListener('focus' , (e) => {
            options.classList.add('block');
                
            $$('option',list).forEach( option => {
                option.addEventListener('click' , (e) => {
                    input.value = e.target.text;
                });
            });
        });
        
        input.addEventListener('focusout' , (e) => {
            setTimeout(()=>{options.classList.remove('block');},200);
        });

        input.addEventListener('input',(e)=>{
            console.log(input.value);
            let val = input.value;
            $$('option',list).forEach( option => {
                console.log(option.text);
                if(val!='' && option.text.toLowerCase().indexOf(val.toLowerCase())<0) {
                    option.classList.add('hide');
                }else{
                    option.classList.remove('hide');
                }
            });
        });

    });

};

( ()=>{
    initForm();
})();

/*
add listeners for nav links
*/
$$('[nav]').forEach( e => {
    e.addEventListener('click',()=>{
        document.location = e.getAttribute("nav");
    });
});