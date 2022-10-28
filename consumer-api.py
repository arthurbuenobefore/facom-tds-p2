import requests
import json
# https://stackoverflow.com/questions/6386308/http-requests-and-json-parsing-in-python

def moduloTreinador():
    #GET TREINADOR
    url = 'http://localhost:8080/api/treinador'

    resp = requests.get(url=url)
    data = resp.json()
    print("GET TReinador: \n")
    print(data)

    #POST TREINADOR
    url = 'http://localhost:8080/api/treinador'

    params = dict(
        nome='Arthur',
        xp=2000
    )

    resp = requests.post(url=url, json=params)
    requests.post(url=url, json=params)
    data = resp.json()
    print("POST TReinador: \n")
    print(data)

    #PUT TREINADOR
    url = 'http://localhost:8080/api/treinador/1'

    params = dict(
        nome='Arthur-Teste',
        xp=2000
    )

    resp = requests.put(url=url, json=params)
    data = resp.json()
    print("PUT TReinador: \n")
    print(data)

    #DELETE TREINADOR
    url = 'http://localhost:8080/api/treinador/1'

    resp = requests.delete(url=url)
    print("DELETE TReinador: \n")
    print(resp)


def moduloTipoPokemon():
    url = 'http://localhost:8080/api/tipo-pokemon'

    resp = requests.get(url=url)
    data = resp.json()
    print("GET tipo-pokemon: \n")
    print(data)

    url = 'http://localhost:8080/api/tipo-pokemon'

    params = dict(
        nome='Gelo'
    )

    resp = requests.post(url=url, json=params)
    requests.post(url=url, json=params)
    data = resp.json()
    print("POST tipo-pokemon: \n")
    print(data)

    url = 'http://localhost:8080/api/tipo-pokemon/3'

    params = dict(
        nome='Fogo',
    )

    resp = requests.put(url=url, json=params)
    data = resp.json()
    print("PUT tipo-pokemon: \n")
    print(data)

    url = 'http://localhost:8080/api/tipo-pokemon/3'

    resp = requests.delete(url=url)
    print("DELETE tipo-pokemon: \n")
    print(resp)

def moduloPokemon():
    url = 'http://localhost:8080/api/pokemon'

    resp = requests.get(url=url)
    data = resp.json()
    print("GET pokemon: \n")
    print(data)

    url = 'http://localhost:8080/api/pokemons?tipo=4'

    resp = requests.get(url=url)
    data = resp.json()
    print("GET pokemons por tipo: \n")
    print(data)

    url = 'http://localhost:8080/api/pokemon'
    tipos = [4]
    params = dict(
        nome='Snorlax',
        altura=192,
        ataque=100,
        defesa=100,
        ataque_especial=100,
        defesa_especial=20,
        velocidade=100,
        tipos=tipos
    )

    resp = requests.post(url=url, json=params)
    requests.post(url=url, json=params)
    data = resp.json()
    print("POST pokemon: \n")
    print(data)

    url = 'http://localhost:8080/api/pokemon/5'

    resp = requests.get(url=url)
    data = resp.json()
    print("GET pokemons por ID: \n")
    print(data)

    url = 'http://localhost:8080/api/pokemon/5'

    tipos = [4]
    params = dict(
        nome='Snorlax Teste',
        altura=192,
        ataque=100,
        defesa=100,
        ataque_especial=100,
        defesa_especial=20,
        velocidade=100,
        tipos=tipos
    )

    resp = requests.put(url=url, json=params)
    data = resp.json()
    print("PUT pokemon: \n")
    print(data)

    url = 'http://localhost:8080/api/pokemon/5'

    resp = requests.delete(url=url)
    print("DELETE okemon: \n")
    print(resp)

def moduloFraqueza():
    url = 'http://localhost:8080/api/fraqueza'

    resp = requests.get(url=url)
    data = resp.json()
    print("GET fraqueza: \n")
    print(data)

    url = 'http://localhost:8080/api/fraqueza'

    params = dict(
        nome='Gelo',
        pokemon_id=6
    )

    resp = requests.post(url=url, json=params)
    data = resp.json()
    print("POST fraqueza: \n")
    print(data)

    url = 'http://localhost:8080/api/fraqueza/7'

    params = dict(
        nome='Fogo',
        pokemon_id=6
    )

    resp = requests.put(url=url, json=params)
    data = resp.json()
    print("PUT fraqueza: \n")
    print(data)

    url = 'http://localhost:8080/api/fraqueza/7'

    resp = requests.delete(url=url)
    print("DELETE fraqueza: \n")
    print(resp)

def moduloHabilidade():
    url = 'http://localhost:8080/api/habilidade'

    resp = requests.get(url=url)
    data = resp.json()
    print("GET habilidade: \n")
    print(data)

    url = 'http://localhost:8080/api/habilidade'

    params = dict(
        nome='Gelo',
        pokemon_id=6
    )

    resp = requests.post(url=url, json=params)
    data = resp.json()
    print("POST habilidade: \n")
    print(data)

    url = 'http://localhost:8080/api/habilidade/8'

    params = dict(
        nome='Fogo',
        pokemon_id=6
    )

    resp = requests.put(url=url, json=params)
    data = resp.json()
    print("PUT habilidade: \n")
    print(data)

    url = 'http://localhost:8080/api/habilidade/8'

    resp = requests.delete(url=url)
    print("DELETE habilidade: \n")
    print(resp)



while True:
    print("Selecione qual módulo deseja testar da API: \n")
    print("1 - Treinador: \n")
    print("2 - Tipo do Pokemon: \n")
    print("3 - Pokemon: \n")
    print("4 - Fraqueza: \n")
    print("5 - Habilidade: \n")
    print("0 - Sair: \n")
    opcao = input()

    if(opcao == '1'):
        moduloTreinador()
    elif(opcao == '2'):
        moduloTipoPokemon()
    elif(opcao == '3'):
        moduloPokemon()
    elif(opcao == '4'):
        moduloFraqueza()
    elif(opcao == '5'):
        moduloHabilidade()
    else:
        break
