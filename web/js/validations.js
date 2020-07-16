


function validateForm() {
    var result = {
        "success": true,
        "message": false
    }

    let rowCount = 0;
    $('#tableCursos > tbody > tr').each(function () {
        let check = $(this).find('td:eq(4)').children('input');
        if (check.is(':checked')) {
            rowCount++;
        }
    });

    if (rowCount === 0) {
        result.success = false;
        result.message = "No se seleccionó ninguna fila";
    }

    return result;
}