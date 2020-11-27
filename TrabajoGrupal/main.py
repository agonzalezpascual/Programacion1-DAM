import numpy as np
import cv2
ima = "ImgCuestionario.png"
imagen = cv2.imread(ima, 0)
# imgGris = cv2.cvtColor(imagen, cv2.COLOR_BGR2GRAY)
cv2.imshow("Gris", imagen)
cv2.waitKey(0)
"""imgConvertida = cv2.cvtColor(imgGris, cv2.COLOR_GRAY2RGB)
cv2.imshow("Gris convertida", imgConvertida)
"""