document.getElementById('viewEInfo').onclick = ViewInformation;
document.getElementById('ReqApply').onclick = AddReimbursement;// () calls fucnction without event
document.getElementById('Eupdate').onclick = UpdateInformation;
document.getElementById('ERes').onclick = ViewREsolvedREquests;
document.getElementById('EPend').onclick= ViewPending;


async function AddReimbursement(){
    apiURL = 'http://localhost:8080/employee/submitForm';
    
    let response = await fetch(apiURL);

    if(response.status >= 200 && response.status < 300){
        document.getElementById('body').innerHTML = `<p> Success </p>`
        
    }else{  
        document.getElementById('body').innerHTML = `<p> Error  </p>`
    }
}

async function ViewInformation(){
    let apiURL = 'http://localhost:8080/employee/profile';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayProfile(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error Profile. </p>`
    }
}

async function updateInformation(){
    let apiURL = 'http://localhost:8080/employee/updateProfile';
	let update = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let stuff = await response.json();
        document.getElementById('body').innerHTML = `<p> Successful Update. </p>`
    }else{
        document.getElementById('body').innerHTML = `<p> Update Not Possible </p>`
    }
}

async function ViewPending(){
    apiURL = 'http://localhost:8080/employee/viewPending';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let info = await response.json();
        displayReimbP(info);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Pending  </p>`
    }
}

async function getResolved(){
    apiURL = 'http://localhost:8080/employee/viewResolved';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayReimbR(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Pending  </p>`
    }
}

function createForm(){
    let body = document.getElementById('body');
    body.innerHTML = ` 
    <form action="../employee/submitForm" method="POST">
        <h4>Enter Reimbursement Info </h4>
        <label for="type">Type</label>
        <select name="type" id="type" required>
            <option value="1"> Temporary Housing</option>
            <option value="2">Food</option>
            <option value="3">Other</option>
        </select>
        <br>
        <label for="amount">Amount: </label>
        <input type="number" id="amount" name="amount" class="form-control" min="0" max="10000" required>
        <label for="desc">Description:</label>
        <input type="text" id="desc" name="desc" class="form-control" maxlength="200">
        
        <button type ="submit" id="submitForm">Submit Reimbursement</button>
    </form>
    `
}

function displayInformation(response){
    document.getElementById('body').innerHTML =
    `<form action="../employee/updateProfile" method="POST">
        <p>User Id: ${response.id}</p>
        <p>User Name: ${response.userName}</p> 
        <label for="email">User Email: </label> 
        <input type="email" id="email" name="email"  value ="${response.email}" maxlength="150">
        <br>
        <label for="firstName">First Name: </label> 
        <input type="text" id="firstName" name="firstName" value="${response.firstName}" minlength="3" maxlength="100">
        <br>
        <label for="lastName">Last Name: </label> 
        <input type="text" id="lastName" name="lastName" value="${response.lastName}" minlength="3" maxlength="100">
        <br>
        <label for="password">Password: </label> 
        <input type="password" id="password" name="password" value="${response.password}" minlength="3" maxlength="50">
        <input type="checkbox" id="passwordBox">Show Password
        <br>
        <button type="submit" id="UpdateInformation">Update Profile</button>
     </form>
     `
}

function displayReimbP(response){
    let body = document.getElementById('body');
    let br = document.createElement('br');

    while(body.firstChild){
        body.removeChild(body.firstChild);
    }

    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
        var p = document.createElement('p');
        p.textContent = `ID: ${obj.id} 
                        Status:  ${obj.reimbStatus} 
                        Amount:  ${obj.reimbAmount} 
                        Time Sent:  ${obj.reimbSubmitted} 
                        Description:  ${obj.reimbDescription}`;
        body.appendChild(p);
    }
}

function displayReimbR(response){
    let body = document.getElementById('body');
    let br = document.createElement('br');

    //Clear old display
    while(body.firstChild){
        body.removeChild(body.firstChild);
    }

    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
        var p = document.createElement('p');
        p.textContent = `ID: ${obj.id} 
                        Status:  ${obj.reimbStatus} 
                        Amount:  ${obj.reimbAmount} 
                        Time Sent:  ${obj.reimbSubmitted} 
                        Time Resolved:  ${obj.reimbResolved} 
                        Description:  ${obj.reimbDescription}`;
        body.appendChild(p);
    }
}