/**
 * 
 */


function requestlogout() {
	window.location.href = "logout.jsp";
}
function validateAndRedirect(action) {
            var selectedAccount = document.querySelector('input[name="selectedAccount"]:checked');
            if (!selectedAccount) {
                alert("Please select an account before proceeding.");
                return false;
            }
            // Add logic to set the action parameter and submit the form
            document.getElementById('selectedAction').value = action;
            document.getElementById('accountForm').submit();
            return true;
        
  }

