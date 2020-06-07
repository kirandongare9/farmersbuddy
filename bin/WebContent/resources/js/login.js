
let login = () =>{

    $.loading($('body'),true);

    let data = {
        username : $('#username').value ,
        pswd : $('#pswd').value
    }

    axios.post('/user/login',data).then((res)=>{
        console.log('res:'+JSON.stringify(res));
        if(res.data == true ){
            $.loading($('body'));
            document.location = '/ide/home';
        }
        $.loading($('body'));
    }).catch((err)=>{
        $.loading($('body'));
        console.log('err :'+err);
    });
}

let signup = () =>{

    $.loading($('body'),true);

    let data = {
        name : $('#name').value,
        email : $('#email').value,
        username : $('#username').value ,
        pswd : $('#pswd').value
    }

    axios.post('/user/add',data).then((res)=>{
        console.log('res:'+JSON.stringify(res));
        if(res.data.success == true ){
            $.loading($('body'));
            document.location = '/public/login';
        }
        $.loading($('body'));
    }).catch((err)=>{
        $.loading($('body'));
        console.log('err :'+err);
    });
}