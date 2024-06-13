function helloFunction(params) {
    console.log("Hello Adi")
}

helloFunction();


function addNumber(marks, total) {
    console.log("marks " + marks)
    console.log("total " + total)
    var z = marks / total;
    console.log("z " + z)
    var abc = z * 100;
    return abc;
}


console.log("Result " + addNumber(25, 50) + " %")