loadAllTodos();

document.getElementById("insert").addEventListener("click", function(){
    saveTodo();
})


document.getElementById("updateName").addEventListener("click", function(){
    updateTodo();
})


document.getElementById("deleteName").addEventListener("click", function(){
    deleteTodo();
})


function deleteTodo(){
    fetch("http://localhost:8080/todos/"+ document.getElementById("id2").value,{
       
        headers:{
            Accept: "application/json",
            "content-type":"application/json"
        },
        method: "DELETE"
    }) 
    .then(function(data) {
           loadAllTodos();
        }).catch(function (err) {
            console.warn('Something went wrong', err);
        });    
}

function updateTodo(){
    let todo = {"name":document.getElementById("name2").value, "id":document.getElementById("id").value};
    console.log(JSON.stringify(todo));
    fetch("http://localhost:8080/todos/"+ document.getElementById("id").value,{
       
        body:JSON.stringify(todo),
        headers:{
            Accept: "application/json",
            "content-type":"application/json"
        },
        method: "PUT"
    }) 
    .then(function(data) {
           loadAllTodos();
        }).catch(function (err) {
            console.warn('Something went wrong', err);
        });    
}


function saveTodo(){
    let todo = {"name":document.getElementById("name").value};
    console.log(JSON.stringify(todo));
    fetch("http://localhost:8080/todos",{
        method: "POST",
        body:JSON.stringify(todo),
        headers:{
        
            "content-type":"application/json"
        }
    }) 
    .then(function(data) {
           loadAllTodos();
        }).catch(function (err) {
            console.warn('Something went wrong', err);
        });    
}


function loadAllTodos(){
    fetch("http://localhost:8080/todos").then(response => response.json())
        .then(function(data) {
            
            let html="";
            data.forEach(element => {
                html += "<li>" + element.name + "</li>";
            });
            document.getElementById("todos").innerHTML = html;
        }).catch(function (err) {
            console.warn('Something went wrong', err);
        });
}