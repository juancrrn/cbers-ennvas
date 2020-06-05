
var namespace = {};

/**
 * @param {object} json
 * 
 * @return {string}
 */
namespace.jsonToProduct = function(json)
{
    const html = '\
    <div class="card mb-2">\
        <div class="card-body">\
            <div class="product-pre-header mb-2">\
                <span class="badge badge-secondary">' + json.brand + '</span>\
                <span class="badge badge-secondary">' + json.type + '</span>\
            </div>\
            <h5 class="card-title mb-3">' + json.name + '</h5>\
            <div class="product-attributes mb-4">\
                <span><i class="fas fa-cubes"></i> ' + json.stock + '</span>\
                <span><i class="fas fa-star"></i> ' + json.rating + '</span>\
                <span><i class="fas fa-dolly"></i> ' + json.shippingPrice + '</span>\
                <span><i class="fas fa-shipping-fast"></i> ' + json.shippingTime + '</span>\
            </div>\
            <p class="card-text">' + json.description + '</p>\
            <a target="_blank" href="' + json.providerUniqueUrl + '" class="card-link">' + json.price + ' en ' + json.providerName + '</a>\
        </div>\
    </div>\
    ';

    return html;
}

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
        url: 'http://localhost:60005/ennvas/front/rest/search',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(aux),
        success: function (result) {

            console.log(result);

            $('#product-container').empty();

            if (result.products) {
                for (i = 0; i < result.products.length; i++) {
                    const productHtml = namespace.jsonToProduct(result.products[i]);
                    $('#product-container').append(productHtml);
                }
            }
        },
        error: function (result) {
            console.log(result);
        }
    });

    
});