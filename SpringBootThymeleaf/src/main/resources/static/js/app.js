function validate() {
    var name = document.getElementById("name").value;
    if (name == null || name == '') {
        alert('Please enter a valid name.');
        return false;
    } else {
        return true;
    }
}