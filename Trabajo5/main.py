import pickle

#Numero = "68373837"
"""input("introduzca el número del abonado")"""
#Nombre = "PEpe"
""""input("introduzca el nombre del abonado")"""
#Factura = 34.56
"""float(input("introduzca la factura del abonado"))"""

"""lista = [{'numAbo': '636363636', 'nomAbo': 'Alex', 'facAbo': 34.45}, {'numAbo': '626262626', 'nomAbo': 'Ana', 'facAbo': 41.87}]

print(lista[0]["numAbo"])"""


with open("1af8a910-99cd-3748-b92c-d6d8b05b9e96.dat", "rb+") as archivo: # Apartado 1
    lista = pickle.load(archivo)
"""    pickle.dump(lista, archivo)
with open("abonados.dat", "rb+") as archivo:
    lista.append({'numAbo': Numero, 'nomAbo': Nombre, 'facAbo': Factura})
    pickle.dump(lista, archivo)
with open("abonados.dat", "rb+") as archivo:
    list = pickle.load(archivo)"""
print(lista)

