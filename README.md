# Java Challenge

## Autor: Carlos Nieto

### Analisis y Diseño
Me he centrado principalmente en  generar los métodos expuestos de la API
generando la capa de persistencia en memoria y obviando control de errores y comprobación de datos de entrada

### Desarrollo: 
Para generar el proyecto inicial he utilizado la herramienta: [spring initializr](https://start.spring.io/)

### Despliegue: 
Arrancar el proyecto con Spring Boot. 
La capa de bbdd será manejada desde memoria y he incluido unos registros base que se cargaran al iniciar el proyecto

### Test: 
Para poder probar el API he añadido un fichero con una colección de llamadas a las operaciones: 
(/src/main/resources/postman/java_challenge.postman_collection.json)
* listCustomers: Consultar la lista de clientes
    * Entrada: vacio
    * Salida: lista de clientes
* listCars: Consultar la lista de coches en el inventario
    * Entrada: vacio
    * Salida: lista de coches
* createCar: Incluir un nuevo modelo de coche en el inventario
    * Entrada: tipo y modelo
    * Salida: Objeto CAr
* listRents: Consultar la lista de Alquileres actuales y anteriores
    * Entrada: vacio
    * Salida: lista de clientes
* rentCar: Realizar uno o varios Alquileres
    * Entrada: Lista de Alquileres a realizar con el idCustomer, idCar y los dias seleccionados
    * Salida: Lista de Alquileres realizados
* returnCar: Devolver un coches alquilado
    * Entrada: idRent y dias extra
    * Salida: Alquiler finalizado
	
### Excluido: Que cosas no me ha dado tiempo a incluir y que serían los próximos pasos que daría
* Comprobación de datos entrada
* Manejo de errores
* JavaDoc
* Más Test Unitarios

	
	

