# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Alonso Portillo Sánchez  uvus: aloporsan

Trabajaremos con un dataset de hamsters y sus carreras. Ofrece los datos del hamster,
el tiempo y distancia de la carrera y también pequeños datos como lo que comieron 
el dia del ejercicio y su comida favorita. Utilizaremos una programación orientada
a objetos para realizar distintas operaciones para la gestion e implementacion de
hamsters y obtener un mejor control del dataset


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.hamster**: Paquete que contiene los tipos del proyecto.
  * **fp.hamster.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **YTD-hamster-2019-2021.csv**: Dataset de hamsters y sus carreras
    
## Estructura del *dataset*

El dataset original tiene la siguiente url: https://www.kaggle.com/grepvim/hamster-exercise-20192020-september-ytd

El dataset está compuesto por 8 columnas, con la siguiente descripción:

* **name**: de tipo String, representa los nombres de los hamsters
* **date**: de tipo LocalDate, representa la fecha de la carrera
* **time**: de tipo LocalTime, representa la hora del inicio de la carrera
* **totalTime**: de tipo Integer, representa la duracion de la carrera
* **totalInches**: de tipo Integer, representa la distancia recorrida de la carrera
* **country**: de tipo String, representa el pais de procedencia del hamster
* **meal**: de tipo List<String>, representa la comida que ha comido hoy el hamster
* **favoriteMeal**: de tipo Comida, representa la comida favorita del hamster

Además, el dataset está formado por 1217 filas. La primera es la cabecera y las demás son los registros. 

## Tipos implementados

Describe aquí los tipos que usas en tu proyecto.

### Tipo Base
Descripción breve del tipo base.

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
