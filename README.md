
# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Daniel Reyes Zájara  uvus: danreyzaj

Trabajaremos con un dataset de cervezas artesanas. Ofrece los datos de la cerveza,
el numero de fila del dataset,como el volumen de alcohol, la amargura, su numero de id, 
el nombre de la cerveza, el tipo de cerveza, el tamaño de la cerveza en onzas,
un yipo booleano y una fecha aleatoria. Utilizaremos una programación orientada
a objetos para realizar distintas operaciones para la gestion e implementacion del
dataset de cervezas y obtener un mejor control del dataset.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.tipos**: Paquete que contiene los tipos del proyecto.
  * **fp.tipos.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **beers - beers (2).csv**: Dataset de cervezas artesanas(modificado para tener todos los tipos de propiedades necesarias)
    
## Estructura del *dataset*

El dataset original tiene la siguiente url: http://kaggle.com/nickhould/craft-cans

El dataset está compuesto por 9 columnas, con la siguiente descripción:

* **num**: de tipo Integer, representa el numero de fila
* **abv**: de tipo Double, representa el volumen de alcohol de la cerveza
* **ibu**: de tipo Double, representa el nivel de amargura de la cerveza
* **id**: de tipo Integer, representa el numero id
* **name**: de tipo String, representa el nombre de la cerveza
* **style**: de tipo String, representa el estilo de la cerveza
* **ounces**: de tipo Double, representa el tamaño en onzas de la cerveza
* **booleano**: de tipo bool, representa Si es true o false(propiedad aleatoria extra)
* **fecha**: de tipo LocalDate, represenata una fecha(propiedad aleatoria extra)

Además, el dataset está formado por 1000 filas. La primera es la cabecera y las demás son los registros. 

## Tipos implementados

Hemos creado un tipo base 'Cerveza' con su tipo test, el cual crea un objeto de Tipo de Cerveza al cual dse le puede aplicar algunos metodos
definidos en la clase.

### Tipo Base
Tipo Cerveza, para crear un objeto de tipo cerveza,por otro lado estan definidos metodos como los getters y setters, hashcode, equals, compareTo, un propiedad derivada , contructores, la reprensentacion como cadena y obviamente las propidades del objeto.

**Propiedades**:

- num, de tipo Integer, consultable y modificable. 
- abv, de tipo Double, consultable y modificable. 
- ibu, de tipo Double, consultable y modificable.
- id, de tipo Integer, consultable.
- name, de tipo String, consultable y modificable.
- style, de tipo String, consultable. 
- ounces, de tipo Double, consultable y modificable.
- booleano, de tipo bool, consultable.
- fecha, de tipo LocalDate, consutable y modificable.

**Constructores**: 

- Cerveza(Double abv, Double ibu, String name, String style, Double ounces, boolean booleano, LocalDate fecha): Crea un objeto de tipo Cerveza con todas las propiedades basicas.
- Cerveza(Double abv, String name, String style): Crea un objeto de tipo Cerveza con el nombre, el estilo y el volumen de alcohol de la cerveza.

**Restricciones**:
 
- checkAbv(Double abv): Lanza un mensaje cuando el abv es menor que 0.
- CheckName(String name): Lanza un mensaje cuando el nombre de la cerveza esta vacio.

**Criterio de igualdad**: Dos objetos son iguales cuando todas las propiedades basicas son iguales. 

**Criterio de ordenación**: Primero se comparan el abv de los dos objetos, si es el mismo, se compara el nombre , y por ultimo si estos dos tienen el mismo nombre,
se comparan el estilo de la cerveza.

**Otras operaciones**:
 
-	getMes(): Obtiene el numero del mes a partir de la fecha.
- ...

#### Tipos auxiliares
Descripción de los tipos auxiliares que sean necesarios añadir al proyecto.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
