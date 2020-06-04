$('#queryForm').on('submit', function (event) {
    event.preventDefault();

    const inputArray = $(this).serializeArray();

    var aux = {};

    for (i = 0; i < inputArray.length; i++) {
        const name = inputArray[i].name;
        const value = inputArray[i].value;

        aux[name] = value;
    }

    console.log(aux);
    
    // Hacer la petición.

    $.ajax({
        url: 'http://localhost:60003',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: aux,
        success: function (result) {
            console.log(result);
        },
        error: function (result) {
            console.log(result);
        }
    });

    
});