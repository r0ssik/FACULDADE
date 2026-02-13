def calculadora():
    print("Bem vindo a calculadora\nEscolha 2 números e por fim a operação\n")
    num1 = input(int("Digite um número: "))
    num2 = input(int("Digite outro número: "))
    opcao = input(int("Digite 1 para somar, 2 para subtrair, 3 para multiplicar e 4 para dividir e 0 para sair."))

    if opcao == 1:
        result = num1 + num2
        print("O Resultado é " + result)
    elif opcao == 2:
        result = num1 - num2
        print("O Resultado é " + result)
    elif opcao == 3:
        result = num1 * num2
        print("O Resultado é " + result)
    elif opcao == 4 and num2 != 0:
        result = num1 / num2
        print("O Resultado é " + result)
    elif opcao == 0:
        print("Bye Bye")
        return
    else:
        print("Digite uma opcao valida")
        calculadora()
        return

    calculadora()
    return
    