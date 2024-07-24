const input = document.getElementById("input")
function reverseString(str){
    return str.split("").reverse().join("")
}

function checkWord() {
    const value = input.value
    const reverse = reverseString(value)
    if(value == reverse){
    alert("Palindrome!")
    }
    else{
        alert("Not Palindrome!")
    }
    input.value = ""
}