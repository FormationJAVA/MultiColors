# MultiColors
L'objectif de cette exercice est de tester la capacité de l'etudiant de mettre à jour un code existant.
Nous souhaitons developper un programme qui permet de calculer un dégradé de couleurs appliqué à 360 lignes formant un cercle.
La video suivante illustre le resultat final :


## Notions théoriques

Soit un cercle centré dans P1 (x1, x2), P2 (x2, y2) le point initial du cercle.
Pour appliquer une couleur differente à chaque ligne, nous créons une méthode java ```private Color getColor(double r)``` qui permet
de calculer une couleur en fonction du paramètre "r"

r = indice de la ligne / nombre des lignes

En fonction du parametre "r", les caracteristiques d'une couleur (Red - Green - Blue) sont calculées en utilisant l'algorithme décrie en bas.

Pour chaque Position pMouse (xm, ym) du curseur de la souris à l'interieur du cercle, nous calculons la couleur correspondant à l'angle entre les vecteurs P1,P2 et P1,pMouse.
L'algorithme en bas permet de calculer l'angle.

### Algorithme de getColor

- Entrée : r = 0.0, 1.0
- Sortie : resultat = R, G, B

- si r < 1/3 // la couleur est entre bleu et le vert
    - R = 0.0
    - G = 3 * r
    - B = 1 - 3 * r
- sinon
    - si r < 2/3
        - r = r - 1/3
        - R = 3 * r
        - G = 1 - 3 * r
        - B = 0.0
    - sinon
        - r = r - 2/3
        - R = 1 - 3 * r
        - G = 0.0
        - B = 3 * r
- R = R* 255
- G = G* 255
- B = B* 255

### Algorithme de getAngle

- Entrée : P1, P2
- Sortie : angle

// calcul du produit scalaire entre les deux vecteurs
- DotP = x1 * x2 + y1 * y2
- normP1 = (x1)^2 + (y1)^2
- normP2 = (x2)^2 + (y2)^2
- angle =  acos( DotP / (normP1 * normP2) )

## Travail demandé
Completez les méthodes manquantes :
  1.  ```private Color getColor(double r)``` dans la class [panColor](MultiColors/src/winColors/panColor.java)
  2.  ```public double getAngle(Point P)``` dans la class [Point](MultiColors/src/winColors/Point.java)
