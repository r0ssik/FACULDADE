def calculadora():
    print("Bem vindo a calculadora\nEscolha 2 números e por fim a operação\n")
    num1 = input(int("Digite um número: "))
    num2 = input(int("Digite outro número: "))
    opcao = input(int("Digite 1 para somar, 2 para subtrair, 3 para multiplicar e 4 para dividir."))

    if opcao == 1:
        result = num1 + num2
    elif opcao == 2:
        result = num1 - num2
    elif opcao == 3:
        result = num1 * num2
    elif opcao == 4 and num2 != 0:
        result = num1 / num2
    else:
        print("Digite uma opcao valida")

    print("O Resultado é " + result)