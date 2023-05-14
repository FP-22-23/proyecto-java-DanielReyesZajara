
# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Daniel Reyes Zájara  uvus: danreyzaj

Trabajaremos con un dataset de cervezas artesanas. Ofrece los datos de la cerveza,
el numero de fila del dataset,como el volumen de alcohol, la amargura, su numero de id, 
el nombre de la cerveza, el tipo de cerveza, el tamaño de la cerveza en onzas,
un tipo booleano, una fecha aleatoria, un tipo lista , y el tipo de color de la cerveza. 
Utilizaremos una programación orientada a objetos para realizar distintas operaciones 
para la gestion e implementacion del dataset de cervezas y obtener un mejor control del dataset.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.tipos**: Paquete que contiene los tipos del proyecto.
  * **fp.tipos.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **beer1 (2).csv**: Dataset de cervezas artesanas(modificado para tener todos los tipos de propiedades necesarias)
    
## Estructura del *dataset*

El dataset original tiene la siguiente url: http://kaggle.com/nickhould/craft-cans

El dataset está compuesto por 11 columnas, con la siguiente descripción:

* **num**: de tipo Integer, representa el numero de fila
* **abv**: de tipo Integer, representa el volumen de alcohol de la cerveza
* **ibu**: de tipo Double, representa el nivel de amargura de la cerveza
* **id**: de tipo Integer, representa el numero id
* **name**: de tipo String, representa el nombre de la cerveza
* **style**: de tipo String, representa el estilo de la cerveza
* **ounces**: de tipo Double, representa el tamaño en onzas de la cerveza
* **booleano**: de tipo bool, representa Si es true o false(propiedad aleatoria extra)
* **fecha**: de tipo LocalDate, representa una fecha(propiedad aleatoria extra)
* **lista**: de tipo List<String>, representa un lista de String(propiedad aleatoria extra)
* **color**: de tipo Cerveza(enum), representa el tipo de color que puede tomar la cerveza(propiedad extra)

Además, el dataset está formado por 100 filas. La primera es la cabecera y las demás son los registros. 

## Tipos implementados

Hemos creado un tipo base 'Cerveza' con su tipo test, el cual crea un objeto de Tipo de Cerveza al cual se le puede aplicar algunos metodos
definidos en la clase.Una Factoria 'FactoriaCervezas' con su tipo test, el cual lee el csv parseando las propiedades necesarias para convetirlo a su tipo
y creando un contenedor con todas las cervezas como elementos de ese contenedor.Además de un Record de Cerveza cuyas propiedades son el nombre, el estilo y el abv.

### Tipo Base
Tipo Cerveza, para crear un objeto de tipo cerveza,por otro lado estan definidos metodos como los getters y setters, hashcode, equals, compareTo, un propiedad derivada , contructores, la reprensentacion como cadena y obviamente las propidades del objeto.

**Propiedades**:

- num, de tipo Integer, consultable y modificable. 
- abv, de tipo Integer, consultable y modificable. 
- ibu, de tipo Double, consultable y modificable.
- id, de tipo Integer, consultable.
- name, de tipo String, consultable y modificable.
- style, de tipo String, consultable. 
- ounces, de tipo Double, consultable y modificable.
- booleano, de tipo bool, consultable.
- fecha, de tipo LocalDate, consutable y modificable.
- lista, de tipo contenedor(List<String>), consultable.
- color, de tipo Color(enum), consultable.

**Constructores**: 

- Cerveza(Double abv, Double ibu, String name, String style, Double ounces, boolean booleano, LocalDate fecha, List<String> lista,
Color color): Crea un objeto de tipo Cerveza con todas las propiedades basicas.
- Cerveza(Double abv, String name, String style): Crea un objeto de tipo Cerveza con el nombre, el estilo y el volumen de alcohol de la cerveza.

**Restricciones**:
 
- checkAbv(Double abv): Lanza un mensaje cuando el abv es menor que 0.
- CheckName(String name): Lanza un mensaje cuando el nombre de la cerveza esta vacio.

**Criterio de igualdad**: Dos objetos son iguales cuando todas las propiedades basicas son iguales. 

**Criterio de ordenación**: Primero se comparan el abv de los dos objetos, si es el mismo, se compara el nombre , y por ultimo si estos dos tienen el mismo nombre,
se comparan el estilo de la cerveza.

**Otras operaciones**:
 
-	getMes(): Obtiene el numero del mes a partir de la fecha.

#### Tipos auxiliares


### Factoría
FactoriaCervezas, para poder leer el csv y poder parsear propiedades como el tipo boolean(booleano) o el tipo List<>(lista).

- leerCervezas(String fichero): Lee el csv que pongamos como parametro en fichero, saltandose la primera linea que seria el nombre de la propiedades, ademas dde crear un contenedor de tipo Cervezas para almacenar cada linea(Objeto de tipo cerveza).
-	parseaCerveza(String linea): Para cada linea del csv va leyendola y parsean cada propiedad a su tipo correspondiente, además de que cada una de ellas serian un objeto de tipo cerveza que se va almacenando una lista de tipo Cervezas(Contenedor).
- parseaLista(String cad): Para poder parsear el string(lista) de cada linea del csv convirtiendola en tipo List<String> como la propidad basica de cerveza.
- parseaBoolean(String cadena): Para poder parsear el string(booleano) de cada linea del csv en un tipo Boolean como la propiedad basiza de la cerveza.
- parseaColor(String c): Para poder parsear el string(color) de cada linea del csv en un tipo Color como la propiedad de la cerveza.
- checkNombre(String n): Lanza una excepcion si el campo del nombre de la cerveza esta vacio.

### Tipo Contenedor

Cervezas, Para crear un contenedor de tipo List<Cerveza> donde se almacenan onjetos de tipo Cerveza, además estan definidos los metodos hashcode, equals, toString como otros metodos como añadir un nuevo elemento u otra lista a la lista, averiguar el tamaño de la lista o eliminar un elemento y por ultimo algunos tratamientos secuenciales.

**Propiedades**:

- cervezas, de tipo List<Cerveza>. 

**Constructores**: 

- Cervezas(): Crea un objeto de tipo Cervezas vacio.
- Cervezas(List<Cerveza> c): Crea un objeto de tipo Cervezas a partir de otra lista.
- Cervezas(Stream <Cerveza> stream): Crea un objeto de tipo Cervezas a partir de un stream que contenga elementos de tipo Cerveza.

**Restricciones**:
 
- No tiene ninguna restriccion

**Criterio de igualdad**: Dos contenedores de tipo Cervezas son iguales si contienen los mismos objetos.

**Criterio de ordenación**: No ningún criterio de ordenación.

**Otras operaciones**:
 
-	getNumeroDeElementos(): Obtiene el numero de elementos del contenedor.
- agregarCerveza(Cerveza c): Agrega un elemento de tipo Cerveza al contendor.
- agregarListaCervezas(List<Cerveza> lc): Agrega una lista de cervezas al contenedor.
- eliminaCerveza(Cerveza c): Elimina una cerveza dada del contendor.
- getCervezaColor(Color co): Determina si existe alguna cerveza que tenga el mismo color de cerveza segun establezca 'co'.
- getMediaAmarguraDeUnColor(Color co): Calcula la media de amargura de las cervezas que tengan de el color segun establezca 'co'.
- getCervezasPorUnElementoDeSuAtributoLista(String gen): Filtra todas las cervezas, sin repetir ninguna, que tengan el mismo elemento en su lista igual a 'gen'.
- getListaCervezasPorOunces(): Obtiene un Map<Double, List<Cervezas>> que para cada ounces diferente(clave) obtiene la lista de cervezas con ese ounces(valor).
- getSumaTotalDeAbvPorAnyo(): Obtiene un Map<Integer, Integer> que para cada año(Clave) obtiene la suma total de abv de dicho año(valor).
- getCervezaColorStream(Color co): Determina si existe alguna cerveza que tenga el mismo color que establezca 'co', utilizando el metodo Stream.
- getMediaCervezaAmarguraDeUnColorSt(Color co): Calcula la media de amargura de las cervezas que sean del mismo color que 'co', usando el metodo Stream.
- getCervezasPorUnElementoDeSuAtributoListaSt(String gen): Filtra todas las cervezas, sin repetir ninguna , que tenga el mismo elemento en si lista igual a 'gen', utilizando el metodo Stream.
- getCervezaMayorAbvDadoUnAño(Integer a): Utlizando el metodo Stream, obtiene la cerveza con mayor abv de el año 'a'.
- getNombresCervezasOrdenadosAlfabeticamenteDadoUnBool(Boolean x): Utilizando el metodo Stream, obtiene un conjunto ordenado alfabeticamente de los nombres de las cervezas cuya propiedad Booleano coincida con 'x'.
- getCervezaPorOuncesStream(): Utilizando el metdodo Stream, Obtiene un Map que obtiene listas de cervezas por cada numero de Ounces.
- getEstiloCervezaPorColor(): Utilizando el metodo Stream, obtiene un Map que agrupa los estilos de las cervezas por cada color.
- getMinimoIbuPorBooleano(): Utilizando el metodo Stream, obtiene un Map que obtiene por cada booleano el minimo ibu de las cervezas que tengan ese bool.
- getTopNDeAbvPorMes(Integer n): Utilizando el metodo Stream, obtiene un SortedMap que por cada mes obtiene el top 'n' de abvs de ese mes.
- getBoolenaoConMenorIbu(): Utilizando el metodo Stream, obtiene la clave y el valor cuyo valor sea el minimo del Map "getMinimoIbuPorBooleano()".
