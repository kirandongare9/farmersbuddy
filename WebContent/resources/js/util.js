if($==undefined)
 var $ = (exp,el) => el==undefined ? document.querySelector(exp) : el.querySelector(exp) ; 
if($$==undefined)
 var $$ = (exp,el) => el==undefined ? document.querySelectorAll(exp) : el.querySelectorAll(exp) ;
if(_$==undefined)
    var _$ = (html) => document.createRange().createContextualFragment(html);

$.$ = (el,exp) => el.querySelector(exp); 
$.$$ = (el,exp) => el.querySelectorAll(exp);

$.loading = (el , action) => {
    
    if(el.querySelector('div.spinner')!=undefined)
            el.removeChild(el.querySelector('div.spinner'));

    if(action)        
        el.appendChild(_$(
            `<div class="spinner round show" >
            </div>`)
        );
}

$.dailog = ( el , config) => {
    let html = '';

    //setting defualt valus if undefined
    if(config.submitText==undefined)
        config.submitText = 'Submit';
    if(config.cancelText==undefined)
        config.cancelText = 'Cancel';

    config.dailogNode = undefined;

    config.submit = () => {
        el.removeChild(config.dailogNode);
            if(config.onSubmit!=undefined)
                config.onSubmit(config.dailogNode);
    };

    config.cancel = () => {
        el.removeChild(config.dailogNode);
        if(config.onCancel!=undefined)
            config.onCancel(config.dailogNode)
    };

    html += `<div class="dailog">
        <div class="dailog-title">{{title}}</div>
        <div class="dailog-subject">{{subject}}</div>
        <div class="dailog-body">
            {{body}}
        </div>
        <div class="dailog-footer">
            <button id="submit" class="success" event="click,submit" > {{submitText}} </button>
            <button id="cancel" class="danger" event="click,cancel" >  {{cancelText}} </button>
        </div>
    </div>` ;

    config.dailogNode = autumn.parse(html,config);
    el.appendChild(config.dailogNode);
    
    return config.dailogNode;
};

function filterQuestion(e){ 
	console.log(e);
}