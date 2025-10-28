function sum(a,b){
    return a+b;
}

function prod(a,b){
    return a*b;
}

function divi(a,b){
    if(b==0){
        return false;
    }else{
        return a/b;
    }
}

function subt(a,b){
    return a-b;
}
module.exports = {sum,prod,divi,subt};