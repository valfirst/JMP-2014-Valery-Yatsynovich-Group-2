$(document).ready(function(){
    $('#addPerson').click(function () {
        addPerson();
    });
    $('#updatePerson').click(function() {
        updatePerson();
    });
    $('#infoPerson').click(function(){
        infoPerson();
    });

    $('#deletePerson').click(function(){
        $('#infoForm').prop('action', 'delete-person.form');
        $('#infoForm').show();
    })

    $('#personId').onkeyup(function(){
        $('#infoForm').submit();
    });

});


function addPerson() {
    $('#personForm').prop('action', 'add-person.form');
    $('#personButton').prop('value', 'Add person');
    $('#personForm').show();
    $('#id').hide();
}

function updatePerson() {
    $('#personForm').prop('action', 'update-person.form');
    $('#personButton').prop('value', 'Update person');
    $('#id').show();
    $('#personForm').show();
}

function infoPerson() {
    $('#infoForm').show();
    $('#personForm').hide();
}