import pickle
import os

# Funciones

def Menu():
    print("\nMenú de Opciones\n =============== \n\n").credit(160)
    print("1) Alta de nuevos abonados\n2) Modificación del valor de la factura de un abonado\n3) Consulta del dato de facturación de un abonado\n4) Consulta del dato de facturación total de la compañía\n5) Eliminar el fichero\n6) Salir")
    return input("\nIntroduce una opción: ")
def Alta():
    Numero = input("\nintroduzca el número del abonado: ")
    Nombre = input("introduzca el nombre del abonado: ")
    Factura = float(input("introduzca la factura del abonado: "))
    with open("abonados.dat", "rb+") as archivo:
        lista.append({'numAbo': Numero, 'nomAbo': Nombre, 'facAbo': Factura})
        pickle.dump(lista, archivo)
        print(lista)

def CargaAbonados():
    if os.path.exists("abonados.dat"):
        with open("abonados.dat", "rb+") as archivo:
            list = pickle.load(archivo)
            return list
    else:
        print("\nFichero eliminido")



def CambiaFact():
    NumAbo = input("\nNúmero del abonado: ")
    for ele in lista:  # Apartado 2
        if ele["numAbo"] == NumAbo:
            ele["facAbo"] = float(input("Introduce el nuevo valor de la factura: "))
    with open("abonados.dat", "rb+") as archivo:
        pickle.dump(lista, archivo)

def BuscaFact():
    NumAbo = input("\nNúmero del abonado: ")
    for ele in lista:  # Apartado 3
        if ele["numAbo"] == NumAbo:
            print(f"Valor de la factura: {ele['facAbo']}€")

def FactTotal():
    suma = 0
    for ele in lista:  # Apartado 4
        suma += ele["facAbo"]

    print(f"\nFacturación total: {round(suma,2)}")

def BorraFact(): # Apartado 5
    if os.path.exists("abonados.dat"):
        os.remove("abonados.dat")
    else:
        print("\nNo hay ningún archivo")

def CreaArchivo():
    with open("abonados.dat", "wb") as archivo:  # Apartado 1
        lista = [{'numAbo': '636363636', 'nomAbo': 'Alex', 'facAbo': 34.45}, {'numAbo': '626262626', 'nomAbo': 'Ana', 'facAbo': 41.87}]
        pickle.dump(lista, archivo)

# Cuerpo
cont = ""
CreaArchivo()
while cont != "6":
    lista = CargaAbonados()
    cont = Menu()
    if cont == "1":
        Alta()
    elif cont == "2":
        CambiaFact()
    elif cont == "3":
        BuscaFact()
    elif cont == "4":
        FactTotal()
    elif cont == "5":
        BorraFact()
    elif cont == "6":
        print("\nHasta la próxima")
    else:
        print("\nIntroduzca un valor válido")
