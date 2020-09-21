var app = angular.module("app", []);
 
app.controller("AlumnosController", function($scope, $http) {
 
    $scope.alumnos = [];
    $scope.alumnoForm = {
        alumnoId: 0,
        alumnoNombre: "",
        alumnoApellido: "",
        alumnoCarnet: "",
        alumnoGrado: "",
        alumnoPadre: "",
        alumnoMadre: "",
        alumnoEdad: "",
        alumnoNota: ""
    };
 
    _cargarAlumnoData();
 
 
    $scope.crearAlumno = function() {
    
        var method = "";
        var url = "";

        if ($scope.alumnoForm.alumnoId == 0) {
            method = "POST";
            url = '/alumnos';
        } else {
            method = "PUT";
            url = '/alumnos';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.alumnoForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
        
    };

	$scope.createAlumno = function() {
        _clearFormData();
    }
	
 
 
    $scope.deleteAlumno = function(alumno) {
        $http({
            method: 'DELETE',
            url: '/alumnos/' + alumno.idAlumno
        }).then(_success, _error);
    };
 
    $scope.editAlumno = function(alumno) {
    
    	$scope.alumnoForm.alumnoId = alumno.idAlumno;
        $scope.alumnoForm.alumnoNombre= alumno.nombreAlumno;
        $scope.alumnoForm.alumnoApellido= alumno.apellidoAlumno;
        $scope.alumnoForm.alumnoCarnet= alumno.carnetAlumno;
        $scope.alumnoForm.alumnoGrado= alumno.gradoAlumno;
        $scope.alumnoForm.alumnoPadre= alumno.padreAlumno;
        $scope.alumnoForm.alumnoMadre= alumno.madreAlumno;
        $scope.alumnoForm.alumnoEdad=alumno.edadAlumno;
        $scope.alumnoForm.alumnoNota= alumno.notaFinalAlumno;
    
        $scope.employeeForm.empId = employee.empId;
        $scope.employeeForm.empNo = employee.empNo;
        $scope.employeeForm.empName = employee.empName;
    };
   
     
    function _cargarAlumnoData() {
        $http({
            method: 'GET',
            url: '/alumnos'
        }).then(
            function(res) { // success
                $scope.alumnos = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _cargarAlumnoData();
        _clearFormData();
         alert("Operacion exitosa ");
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    function _clearFormData() {
        $scope.alumnoForm.alumnoId = "0";
        $scope.alumnoForm.alumnoNombre= "";
        $scope.alumnoForm.alumnoApellido= "";
        $scope.alumnoForm.alumnoCarnet= "";
        $scope.alumnoForm.alumnoGrado= "";
        $scope.alumnoForm.alumnoPadre= "";
        $scope.alumnoForm.alumnoMadre= "";
        $scope.alumnoForm.alumnoEdad="";
        $scope.alumnoForm.alumnoNota= "";
    };
	
});