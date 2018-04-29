# Java DarkSouls Game

TP réalisé à deux : Llanes Jade et Pavé Tanguy.

## Installing

Nous avons utilisé **Eclipse** pour notre projet.

## Réponses aux questions

**TP1**

Question 1 (6)

```
La visibilité optimale pour isAlive est protected dans cette configuration car la méthode ne sera accessible 
que par elle-même, par la classe fille et par le package auquel elle appartient.
```

Question 2 (7)

```
La visibilité optimale pour isAlive est public dans cette configuration car la méthode doit être accessible 
à l'intérieur des autres packages.
```

**TP2**

Question 3 (1.2)

```
getClass() récupère la classe dans laquelle se trouve la méthode, puis la méthode getSimpleName() récupère 
le nom de la classe concernée. Il faudra passer les membres de private à protected car il y aura des classes 
filles qui hériteront des méthodes et attributs.
```
Question 4 (6)

```
On remarque que la durabilité de l'épée continue de diminuer même lorsque les dégats et la stamina sont à zéro.
``` 	

**TP3**

Question 5 (4.2)

```
Les classes Hero et  Monster présentent une erreur car elles héritent de la  classe Character,  qui demande 
obligatoirement d'écrire la méthode abstraite computeProtection  dans chacune des classes.
```

**TP4**

Question 6 (3.4)

```
Au niveau de l'itération, la doc nous explique que le rendu est dans n'importe quel ordre. 
De plus, il y a la présence d'un "fail-fast", ce qui veut dire que si le set est modifié après la création 
de l'itérator, il envoit une erreur : ConcurrentModificationException. Le Fail-fast est utilisé pour 
detecter des bugs.
```
