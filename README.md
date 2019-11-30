**LOC:**
[![](https://tokei.rs/b1/github/AladMocu/ProyectoDalgo2019-2)](https://github.com/AladMocu/ProyectoDalgo2019-2)

## ProblemaA
**Enunciado:**
Desarrollar un programa que, dado un arreglo de enteros, determine la longitud máxima dentro de todos
los subarreglos recurrentes.

**Ejemplo entrada/salida:**

|stdin|stdoud|
|--|--|
|4<br>1 4 2 1 <br>10 <br>0 1 2 1 4 1 2 1 0 5<br>0 |1<br>3  |


## Problema B

**Enunciado:**
Se quiere evidenciar la posible falsedad de la afirmación exhibiendo una cadena de individuos que sea
creciente en la medición de A y estrictamente decreciente en la medición de B. Más aún, se quiere
mostrar un contraejemplo maximal, en cuanto a longitud (o sea, no hay cadenas contraejemplo más
largas).

En caso de que haya varios contraejemplos de tamaño máximo, se debe escoger uno de ellos, de
manera determinística. Si no existe ningún contraejemplo, debe reconocerse la situación.

**Ejemplo entrada/salida:**

|stdin|stdoud|
|--|--|
|9<br>1 601 65 <br>2 600 105 <br>3 50 100 <br>4 100 200 <br>5 110 150 <br>6 600 100 <br>7 800 70 <br>8 600 60 <br>9 200 95 <br>3 <br>1 100 50 <br>2 300 70 <br>3 200 60 <br>4 <br>1 601 65 <br>2 600 105 <br>3 50 100 <br>4 100 200|5<br> 4 5 2 6 7<br> 0<br> *<br> 3<br> 4 2 1|

## Problema C
**Enunciado:**
Para un punto en el dominio se quiere determinar si el punto está dentro, fuera o en la frontera del
polígono

**Ejemplo entrada/salida:**

|stdin|stdoud|
|--|--|
|6 3 2 4 <br>1 1 2 5 6 3 <br>6 3 5 1 1 1 2 5 6 3 <br>10 12 6 5 <br>3 3 4 3 8 8 5 2 10 7 7 10 4 9 4 6 2 4 0 5 1 0 <br>10 12 5 7 <br>3 3 4 3 8 8 5 2 10 7 7 10 4 9 4 6 2 4 0 5 1 0 <br>10 12 3 5 <br>3 3 4 3 8 8 5 2 10 7 7 10 4 9 4 6 2 4 0 5 1 <br>0 0 0 0 0|1 <br>-1 <br>1 <br>-1 <br>0 |


## REFERENCIA DE SOLUCION IMPLEMENTADA
**Problema a:**

    -https://xlinux.nist.gov/dads/HTML/longestCommonSubstring.html
    -https://metacpan.org/pod/String::LCSS_XS
    -https://metacpan.org/pod/Tree::Suffix
    
**Problema b:**

    -https://algorithmist.com/wiki/Longest_Increasing_Subsequence
    -https://web.piyushgarg.in/2017/06/longest-increasing-sub-sequence-longest.html
    -https://stackoverflow.com/questions/22923646/number-of-all-longest-increasing-subsequences/22945390#22945390
    
**Problema c:**

    -http://jedi.ks.uiuc.edu/~johns/raytracer/rtn/rtnv3n4.html#art22
    -http://geomalgorithms.com/a03-_inclusion.html
    -http://totologic.blogspot.com/2014/01/accurate-point-in-triangle-test.html
    
