/**
 * 
 */

function requestStatement() {
	window.location.href = "Statement.jsp";
}


function requestAddMoney() {
	window.location.href = "AddMoney.jsp";
}

function requestSendMoney() {
	window.location.href = "SendMoney.jsp";
}
function requestlogout() {
	window.location.href = "logout.jsp";
}
function validateSelection() {
var selectedAccount = document.querySelector('input[name="selectedAccount"]:checked');
            if (!selectedAccount) {
                alert("Please select an account before proceeding.");
                return false;
            }
            return true;
        }
