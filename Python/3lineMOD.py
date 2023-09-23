#Tablero 3x3
tablero=[["-", "-", "-"],
         ["-", "-", "-"],
         ["-", "-", "-",]]

#Imprimir tablero
def imprimir_tablero(tablero):
    print("","  ", "1", " ", "2"," ","3")
    print("1","|",tablero[0][0],"|", tablero[0][1],"|",tablero[0][2],"|")
    print("2","|",tablero[1][0],"|",tablero[1][1],"|",tablero[1][2],"|")
    print("3","|",tablero[2][0],"|",tablero[2][1],"|",tablero[2][2],"|")

def jugador_1():
    #Elije la ubicación del indicador "X"
    print(jugador1)
    fila_jugador=int(input("Elija la fila (1-3): "))
    colum_jugador= int(input("Elija la columna (1-3): "))
    #Casilla ocupada
    if (tablero[fila_jugador-1][colum_jugador-1]== "O"):
        print(f"Casilla ocupada por {jugador2}, ha perdido su turno")      
    else:
        tablero[fila_jugador-1][colum_jugador-1]= "X"

def jugador_2():
    #Elije la ubicación del indicador "O"
    print(jugador2)
    fila_jugador=int(input("Elija la fila (1-3): "))
    colum_jugador= int(input("Elija la columna (1-3): "))
    # Casilla ocupada
    if (tablero[fila_jugador-1][colum_jugador-1]== "X"):
        print(f"Casilla ocupada por {jugador1}, ha perdido su turno")
    else:
        tablero[fila_jugador-1][colum_jugador-1]= "O"

def verificar_ganador(ind):
    # Verificar Columna
    #Verifica si las columnas están ocupadas por los indicadores "X" o "O"
    if (tablero[0][0]==ind and tablero[1][0]==ind and tablero[2][0]==ind): 
        return True
    elif  (tablero[0][1]==ind and tablero[1][1]==ind and tablero[2][1]==ind):
        return True
    elif (tablero[0][2]==ind and tablero[1][2]==ind and tablero[2][2]==ind):
        return True
    # Verificar fila
    # Verifica si las filas están ocupadas por los indicadores "X" o "O"
    elif (tablero[0][0]==ind and tablero[0][1]==ind and tablero[0][2]==ind): 
        return True
    elif  (tablero[1][0]==ind and tablero[1][1]==ind and tablero[1][2]==ind):
        return True
    elif (tablero[2][0]==ind and tablero[2][1]==ind and tablero[2][2]==ind):
        return True
    # Verificar diagonales
    # Verifica si las diagonales están ocupadas por los indicadores "X" o "O"
    elif (tablero[0][0]==ind and tablero[1][1]==ind and tablero[2][2]==ind): 
        return True
    elif  (tablero[2][0]==ind and tablero[1][1]==ind and tablero[0][2]==ind):
        return True

def gan_jugador1():
        if (verificar_ganador("X")==True): #Validar el indicador del jugador 1 en la función
            print("El ganador es " + jugador1) 
            print("Creditos: Over Alexander Mejia Rosado y Ronald Mateo Ceballos Lozano")
            return True # Retorna True una vez el jugador 1 sea el ganador  
        
def gan_jugador2():
        if (verificar_ganador("O")==True): #Validar el indicador del jugador 2 en la función
            print("El ganador es " + jugador2) 
            print("Creditos: Over Alexander Mejia Rosado y Ronald Mateo Ceballos Lozano")
            return True # Retorna True una vez el jugador 2 sea el ganador

#Inicio del juego
print("Bienvenido a 3line, para jugar, acontinuación ingrese sus nombres y lea las instrucciones:")
#Instrucciones
print("\n")
print("*. 3line es un juego que consiste en conseguir una linea de 3 fichas identicas en el tablero de tamñao 3x3, en caso de que los jugadores completen el tablero y ninguno haya conseguido el objetivo, se declara empate.")
print("*. Al momento de empezar, ingresar las filas y columnas que aparecen en el mensaje de ingreso.")
print("*. Tener en cuenta que si un jugador ingresa un movimiento que ha realizado su rival o este mismo haya realizado anteriormente, queda anulado y pierde su turno automaticamente.")
print("*. Acontinuación, porfavor ingrese sus nombres")
print("\n")
jugador1 = str(input("Nombre del jugador 1: "))
jugador2 = str(input("Nombre del jugador 2: "))
print("\n")
imprimir_tablero(tablero)

#Verificación de empate
for i in range(5):
    if (i==4):
        jugador_1()
        gan_jugador1()
        print("\n")
        print(f" {tablero[0]}\n {tablero[1]}\n {tablero[2]} \n") 
        print("Esto es un empate\n")
        print("Creditos: Over Alexander Mejia Rosado y Ronald Mateo Ceballos Lozano")
        break

    jugador_1() # Llama a la función para que el jugador establezca el indicador "X"
    gan_jugador1()
    print("\n")
    imprimir_tablero(tablero)
    if (gan_jugador1()==True):
        break
   
    jugador_2()  # Llama a la función para que el jugador establezca el indicador "O"
    gan_jugador2() 
    print("\n")
    imprimir_tablero(tablero)
    if (gan_jugador2()==True):
        break
