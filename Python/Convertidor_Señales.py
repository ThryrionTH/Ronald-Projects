import numpy as np

x = [1, 8, -2, 6, -7, 2, 9, -3, 6, -8, 1] #Señal Original
filtro_promedio = [1/3, 1/3, 1/3]
vector_salida = []

# Filtrar los elementos de la señal original que se le aplicara el filtro
for i in range(1, 10):
    x_filtro = x[i-1:i+2]
    #Función de Numpy para hacer la multiplicación de vectores
    u = np.dot(x_filtro, filtro_promedio) 
    # Agregar el resultado al vector de salida  
    vector_salida.append(u) 
  
# Agregar los extremos de la señal original al principio y final de la señal de salida
vector_salida.insert(0, x[0])
vector_salida.append(x[-1])

print("Señal Original:") #Señal Original
print(x)
print("Señal de Salida:")
print(vector_salida) #Señal de Salida
print("Creditos")
print("Over Alexander Mejia Rosado y Ronald Mateo Ceballos Lozano")


