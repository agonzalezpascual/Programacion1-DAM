import pickle
listc = [{'numAbo': '636363636', 'nomAbo': 'Alex', 'facAbo': 34.45},
         {'numAbo': '626262626', 'nomAbo': 'Ana', 'facAbo': 41.87}]

with open("facturas_telf.dat","wb") as f:
    pickle.dump(listc, f)

with open("abonado.dat", "rb") as f:
    listf = pickle.load(f)
    for elem in listf:
        print(elem)