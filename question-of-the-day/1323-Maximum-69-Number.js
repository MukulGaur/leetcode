// 1323. Maximum 69 Number

/**
 * @param {number} num
 * @return {number}
 */
var maximum69Number  = function(num) {
    let str= String(num).split('');

    for(let i=0; i<str.length; i++){

        if(str[i]==="6"){
            str[i] = "9";
            break;
        }
    }

return Number(str.join(''));
  
};
