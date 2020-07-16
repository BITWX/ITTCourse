


$(document).ready(init);

function init() {
    $('#pageLoader').hide();
}


$('#form-cursos').submit(function (event) {
    $('#msgInfo').hide();
    let result = validateForm();
    if (!result.success) {
        event.preventDefault();
        $('#msgInfo').html(result.message);
        $('#msgInfo').show();
    }
});
